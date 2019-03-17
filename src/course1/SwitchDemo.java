package course1;
/**
 * switch语句
 * @author ywb
 *
 */
public class SwitchDemo {
	public static void main(String[] args) {
		int month = (int)(1+12*Math.random());
		System.out.println(month);
		switch(month){
			case 1:
				System.out.println("寒假");
				break;
			case 7:
				System.out.println("暑假");
				break;
			case 8:
				System.out.println("暑假");
				break;
			/*default:
				System.out.println("上课");
			break;*/
		}
		
		for(int a = 0 ; a < 5 ;a ++){
			System.out.println(a);
			if(a == 2){
				continue;
			}
			System.out.println("/"+a);
		}
	}
}
