package course6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流的操作1
 * @author ywb
 *
 */
public class StreamDemo1 {
	public static void main(String[] args) {
		try {
			FileInputStream in = new FileInputStream("E:/eclipse/workspace/java_study/aaa/a.txt");
			int b;
			try {
				while((b = in.read()) != -1){//in.read()在条件中就会执行一次，需要注意用一个变量接收，否则在循环体中再执行的话，一次循环就执行了两次
					System.out.print(b+" ");
				}
				FileOutputStream out = new FileOutputStream("E:/eclipse/workspace/java_study/aaa/a.txt",true);
				//后面传入参数true，则write方法会在原有的基础上添加元素，否则write方法会覆盖原有的元素
				out.write(97);
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in.close();//先开后关
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
