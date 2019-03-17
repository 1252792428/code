package course7;
/**
 * 单例模式
 * @author ywb
 *
 */
public class SingletonDemo {
	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getS();
		Singleton1 s2 = Singleton1.getS();
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
	}
}

/**
 * 单例设计模式 ——饿汉式
 * @author ywb
 *
 */
class Singleton1{
	private Singleton1(){}//私有化构造方法
	private static Singleton1 s = new Singleton1();//创建本类对象
	public static Singleton1 getS(){//对外提供公共的访问方法
		return s;
	}
}
/**
 * 单例设计模式——懒汉式
 * @author ywb
 *
 */
class Singleton2{
	private Singleton2(){}//私有化构造方法
	private static Singleton2 s;//声明一个引用
	public static Singleton2 getS(){//获取实例
		if(s == null){
			s = new Singleton2();
		}
		return s;
	}
}