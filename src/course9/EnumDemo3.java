package course9;

public class EnumDemo3 {
	public static void main(String[] args) {
		Week7 week7 = Week7.Mon;
		switch(week7){
		case Mon:
			System.out.println("今天是星期一");
			break;
		case Tue:
			System.out.println("今天是星期二");
			break;
		}
	}
}

enum Week7{
	Mon,Tue;
}