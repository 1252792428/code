package course9;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 反射与泛型擦除
 * @author ywb
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		//使用反射越过泛型的检查
		ArrayList<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(22);
		Class clazz = Class.forName("java.util.ArrayList");//获取java.util.ArrayList类的字节码对象
		Method m = clazz.getMethod("add", Object.class);//获取其中的add方法
		m.invoke(list, "abc");
		System.out.println(list);
	}
}
