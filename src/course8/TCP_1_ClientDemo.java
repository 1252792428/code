package course8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP	客户端
 * @author ywb
 *
 */
public class TCP_1_ClientDemo {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",12345);//地址与端口号
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		//write方法在两个类中必须有一个放在前面，否则会发现两个类都没有输出内容
		out.write("如何才能变强?".getBytes());//先把数据输给服务端
		
		byte[] arr = new byte[1024];
		int len = in.read(arr);
		System.out.println(new String(arr,0,len));
		
		
		/*byte[] bytes = "如何才能变强".getBytes();
		System.out.println(new String(bytes,0,bytes.length));*/
		socket.close();
	}
}
