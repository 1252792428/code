package course9;

public class JDK8_NewProperties {
	public static void main(String[] args) {
		Bbb b = new Bbb();
		b.method1();
	}
}
interface Aaa{
	public default void method1(){//用default修饰的方法可以有方法体
		System.out.println("111");
	}
}

class Bbb implements Aaa{
	
}
class Ccc{
	public void study(){
		int i = 10;
		class Inner{
			public void run(){
				System.out.println(i);//局部内部内可以使用方法中的局部变量
			}
		}
	}
}