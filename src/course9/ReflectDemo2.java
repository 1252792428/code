package course9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 */


public class ReflectDemo2 {
	private String name;
	public ReflectDemo2(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "[name=" + name + "]";
	}
	public void method1(){
		System.out.println("你好啊");
	}
	public void method2(String name){
		System.out.println("hello"+name);
	}

	public static void main(String[] args) throws Exception {
		//通过反射获取有参构造,并通过有参构造创建对象
		Class clazz = Class.forName("course9.ReflectDemo2");
		Constructor c = clazz.getConstructor(String.class);
		ReflectDemo2 ref = (ReflectDemo2) c.newInstance("zx");
		System.out.println(ref);
		//通过反射获取成员变量并使用
					/*Field f = clazz.getField("name");//获取姓名字段					
					f.set(ref, "ls");没有作用*/
		Field f = clazz.getDeclaredField("name");//获取姓名字段（暴力反射获取，即使是私有变量）
		f.setAccessible(true);//设置去除私有权限
		f.set(ref, "ls");
		System.out.println(ref);
		
		//通过反射获取方法并使用
		Method m1 = clazz.getMethod("method1");
		Method m2 = clazz.getMethod("method2",String.class);
		m1.invoke(ref);
		m2.invoke(ref,"张三");
		
		
		//通过反射越过泛型检查
	}
}
	