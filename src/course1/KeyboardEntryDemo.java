package course1;
import java.util.Scanner;
/**
 * 键盘输入
 * @author ywb
 *
 */
public class KeyboardEntryDemo {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("请输入名字");
		String name = scanner.nextLine();
		System.out.println("请输入年龄");
		int age = scanner.nextInt();
		System.out.println("---------------------");
		System.out.println(name + "\t" +age);
	}
}
