package course9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 反射   (动态代理)	比较重要
 * @author ywb
 *
 */
public class ReflectDemo4 implements User{
	public static void main(String[] args) {
		ReflectDemo4 ref = new ReflectDemo4();
		ref.add();
		ref.delete();
		MyInvocationHandler m = new MyInvocationHandler(ref);//创建动态代理类(放入需要代理的对象)
		User user = (User) Proxy.newProxyInstance(ref.getClass().getClassLoader(), ref.getClass().getInterfaces(), m);//获取类加载器和接口
		
		System.out.println("-----------------------");
		user.add();
		user.delete();
	}
	@Override
	public void add() {
		//System.out.println("权限校验");
		System.out.println("添加功能");
		//System.out.println("日志记录");
	}
	@Override
	public void delete() {
		//System.out.println("权限校验");
		System.out.println("删除功能");
		//System.out.println("日志记录");
	}
}
interface User{
	public void add();
	public void delete(); 
}

//动态代理类
class MyInvocationHandler implements InvocationHandler{
	private Object target;
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限校验");
		method.invoke(target, args);//执行被代理target对象的方法
		System.out.println("日志记录");
		return null;
	}
	
}