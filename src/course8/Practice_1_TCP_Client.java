package course8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 网络编程练习	(客户端)  
 * 实现一个从客户端发送字符串给服务端，服务端返回逆序的字符串给客户端
 * @author ywb
 *
 */
public class Practice_1_TCP_Client {
	public static void main(String[] args) throws  IOException {
		Socket socket = new Socket("127.0.0.1",54321);
		//用字符流包装字节流
		BufferedReader br = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//用打印流包装输出流
		PrintStream ps = new PrintStream(socket.getOutputStream());
		System.out.println("请输入文字");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		ps.println(str);
		System.out.println(br.readLine());
		scanner.close();
		socket.close();
	}
}
