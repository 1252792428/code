package course2;
/**
 * super的用法
 * @author ywb
 *
 */
public class SuperDemo {
	public static void main(String[] args) {
		Child c = new Child();
		c.test();
	}
}
class Father{
	public int i;
	public void test(){
		i = 100;
		System.out.println(i);
	}
	public Father(){
		System.out.println("我是父类的构造方法");
	}
}
class Child extends Father{
	public int i;
	public void test(){
		super.test();//要调用父类的方法，必须使用super，否则调的是自己
		System.out.println(super.i);//调用父类的变量
		i = 200;//设置的是这个类中的变量(父类中的i并没有被改变)
		System.out.println(i);
		System.out.println(super.i);//调用父类的变量
	}
	public Child(){//构造方法的第一句是super();会调用父类的构造方法，构造方法先与普通方法执行
		System.out.println("我是子类的构造方法");
	}
}
/*该程序打印的先后顺序为
我是父类的构造方法
我是子类的构造方法
100
100
200*/