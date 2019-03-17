package course8;
/**
 * TCP  服务端    优化2   (增加多线程)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_3_ServerDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket server= new ServerSocket(12344);
		while(true){
			final Socket socket = server.accept();
			new Thread(){
				public void run(){
					try {
						BufferedReader br = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
						//用打印流包装输出流
						PrintStream ps = new PrintStream(socket.getOutputStream());	
						//服务端获取内容后，返回数据给服务端
						System.out.println(br.readLine());
						ps.println("充钱就能变强!");
						server.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
			
		}
		
	}
}
