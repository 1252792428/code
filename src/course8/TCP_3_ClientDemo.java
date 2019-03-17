package course8;
/**
 * TCP  客户端   优化2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCP_3_ClientDemo {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",12344);//地址与端口号
		//用字符流包装字节流
		BufferedReader br = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//用打印流包装输出流
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		ps.println("如何才能变强？");
		//要先把客户端放入客户端的输出流，从而服务端的输入流才能获取到数据
		System.out.println(br.readLine());

		
		socket.close();
	}
}
