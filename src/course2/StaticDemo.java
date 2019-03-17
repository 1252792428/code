package course2;
/**
 * static关键字
 * @author ywb
 *
 */
public class StaticDemo {
	int id;
	String name;
	int age;
	static {//静态代码块只会执行一次，一般会用来初始化一些值，并且在所有对象中全局共享。
		System.out.println("这是静态代码块");
	}
	static void addInfo(int id,String name,int age){
		//this.id = id;这会报错，静态方法中不能使用this(因为静态方法属于整个类，而不属于对象)
	}
	
	public static void main(String[] args) {//静态代码块中的代码会在main方法之前执行
		StaticDemo sd = null;
		//声明了StaticDemo的一个引用为空（未实例化），然而静态代码块中的代码执行了
		//因此静态代码块中的代码是在类实例化之前就执行了，(也在构造器之前执行)
		System.out.println(sd);
	}
}
