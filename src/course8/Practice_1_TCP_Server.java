package course8;
/**
 * 网络编程练习   (服务端)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Practice_1_TCP_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server= new ServerSocket(54321);
		while(true){
			final Socket socket = server.accept();
			new Thread(){
				public void run(){
					try {
						BufferedReader br = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());	
					    String readLine = br.readLine();
					    readLine = new StringBuilder(readLine).reverse().toString();//字符串反转(这是链式编程)
						ps.println(readLine);
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
			
		}
	}
}
