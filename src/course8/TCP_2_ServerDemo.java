package course8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP	服务端   优化1
 * @author ywb
 *
 */
public class TCP_2_ServerDemo {
	public static void main(String[] args) throws IOException {
		
		ServerSocket server= new ServerSocket(12344);
		Socket socket = server.accept();
		BufferedReader br = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//用打印流包装输出流
		PrintStream ps = new PrintStream(socket.getOutputStream());	
		//服务端获取内容后，返回数据给服务端
		
		System.out.println(br.readLine());
		ps.println("充钱就能变强!");
		
		server.close();
	}
}
