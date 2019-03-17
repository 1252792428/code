package course9;
/**
 * 反射    (获取字节码对象)
 * @author ywb
 *
 */
public class ReflectDemo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		//获取字节码对象方式一
		Class clazz1 = Class.forName("course9.ReflectDemo1");
		//方式二
		Class clazz2 = ReflectDemo1.class;
		//方式三
		ReflectDemo1 ref = new ReflectDemo1();
		Class clazz3 = ref.getClass();
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);//发现三个字节码对象时同一个字节码对象
	}
}
