package course8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP	服务端
 * @author ywb
 *
 */
public class TCP_1_ServerDemo {
	public static void main(String[] args) throws IOException {
		
		ServerSocket server= new ServerSocket(12345);
		Socket socket = server.accept();
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		
		byte[] arr = new byte[1024];
		int len = in.read(arr);//注意，在调用read方法的时候会去调用另外一个类的输出输入流
		System.out.println(new String(arr,0,len));
		
		//服务端获取内容后，返回数据给服务端
		out.write("充钱就能变强  ——by:马化腾".getBytes());
		server.close();
	}
}
