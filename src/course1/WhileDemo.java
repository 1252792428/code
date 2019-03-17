package course1;
/**
 * while用法中注意事项，还有GetFileContentDemo中需要注意方法执行两次的情况
 * @author ywb
 *
 */
public class WhileDemo {
	static int a = 10;
	static int b = 2;
	public static void main(String[] args) {
		int i = 100;
		int j = 5;
		int x = i/j;
		while(i/j > 2){
			i = i - 5;
			System.out.println(x);
		}
	/*	while(x > 2){如果传入的是x，则不会重新赋值，一直打印20
			i -= 5;
			System.out.println(x);
		}*/
	}
}
