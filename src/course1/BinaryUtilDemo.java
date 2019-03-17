package course1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class BinaryUtilDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入一个整数:");
		
		boolean isNum = true;
		while(isNum){
			String value1 = scanner.nextLine();//这句放在while循环中的意义是防止后面的代码一直执行，因为程序执行到这一步会暂停
			try {
				int num = Integer.parseInt(value1);
				System.out.println(Integer.toBinaryString(num));//将输入的十进制数转换成二进制数
				isNum = false;
			} catch (Exception e) {
				try{
					new BigInteger(value1);//如果没抛出异常，则说明是数字过大，否则说明输入的不是整数
					System.out.println("输入数字过大，请重新输入:");
				}
				catch(Exception e2){
					try{
						new BigDecimal(value1);//如果没抛出异常，则说明是数字，否则说明输入的不是数字
						System.out.println("不能输入小数，请重新输入:");
					}catch(Exception e3){
						System.out.println("不能输入字符,请重新输入:");
					}
				}
			}

		}
		scanner.close();	
	}
}