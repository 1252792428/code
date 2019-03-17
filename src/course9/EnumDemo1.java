package course9;
/**
 * 自己创建枚举类
 * @author ywb
 *
 */
public class EnumDemo1 {
	public static void main(String[] args) {
		Week1 week1 = Week1.Mon;//注意，构造器被私有了，通过类名点来调用
		System.out.println(week1);
		
		Week2 week2 = Week2.Tue;
		System.out.println(week2.getName());
		
		Week3 week3 = Week3.Sat;
		week3.show();
		System.out.println(week3.getName());
	}
}
//创建枚举类1
class Week1{
	
	private Week1(){}//私有构造器
	public static final Week1 Mon = new Week1();
	public static final Week1 Tue = new Week1();
	public static final Week1 Wed = new Week1();
	public static final Week1 Thu = new Week1();
	public static final Week1 Fri = new Week1();
	public static final Week1 Sat = new Week1();
	public static final Week1 Sun = new Week1();
}
//创建枚举类2
class Week2{
	String name;
	private Week2(String name){
		this.name = name;
	}//私有构造器
	public String getName() {
		return name;
	}
	public static final Week2 Mon = new Week2("星期一");
	public static final Week2 Tue = new Week2("星期二");
	public static final Week2 Wed = new Week2("星期三");
	public static final Week2 Thu = new Week2("星期四");
	public static final Week2 Fri = new Week2("星期五");
	public static final Week2 Sat = new Week2("星期六");
	public static final Week2 Sun = new Week2("星期天");
}
//创建枚举类3
abstract class Week3{
	String name;
	private Week3(String name){
		this.name = name;
	}//私有构造器
	public String getName() {
		return name;
	}
	public static final Week3 Mon = new Week3("星期一"){
		public void show(){
			System.out.println("星期一");
		}
	};
	public static final Week3 Tue = new Week3("星期二"){
		public void show(){
			System.out.println("今天是星期二");
		}
	};
	public static final Week3 Wed = new Week3("星期三"){
		public void show(){
			System.out.println("今天是星期三");
		}
	};
	public static final Week3 Thu = new Week3("星期四"){
		public void show(){
			System.out.println("今天是星期四");
		}
	};
	public static final Week3 Fri = new Week3("星期五"){
		public void show(){
			System.out.println("今天是星期五");
		}
	};
	public static final Week3 Sat = new Week3("星期六"){
		public void show(){
			System.out.println("今天是星期六");
		}
	};
	public static final Week3 Sun = new Week3("星期天"){
		public void show(){
			System.out.println("今天是星期天");
		}
	};
	public abstract void show();
}