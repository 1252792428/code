package course9;
/**
 * 通过enum创建枚举类
 * @author ywb
 *
 */
public class EnumDemo2 {
	public static void main(String[] args) {
		Week4 week4 = Week4.Mon;
		System.out.println(week4);
		
		Week5 week5 = Week5.Sun;
		System.out.println(week5.getName());
		
		Week6 week6 = Week6.Thu;
		week6.show();
		System.out.println(week6.getName());
	}
}

enum Week4{
	Mon,Tue,Wed,Thu,Fri,Sat,Sun;
}

enum Week5{
	Mon("星期一"),Tue("星期二"),Wed("星期三"),Thu("星期四"),Fri("星期五"),Sat("星期六"),Sun("星期天");
	private String name;

	private Week5(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

enum Week6{
	Mon("星期一"){
		public void show(){
			System.out.println("今天周一");
		}
	},
	Tue("星期二"){
		public void show(){
			System.out.println("今天周二");
		}
	},
	Wed("星期三"){
		public void show(){
			System.out.println("今天周三");
		}
	},
	Thu("星期四"){
		public void show(){
			System.out.println("今天周四");
		}
	},
	Fri("星期五"){
		public void show(){
			System.out.println("今天周五");
		}
	},
	Sat("星期六"){
		public void show(){
			System.out.println("今天周六");
		}
	},
	Sun("星期天"){
		public void show(){
			System.out.println("今天周日");
		}
	};
	private String name;

	private Week6(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public abstract void show();

}
