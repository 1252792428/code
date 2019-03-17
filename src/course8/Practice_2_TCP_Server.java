package course8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程练习2
 * @author ywb
 *
 */
public class Practice_2_TCP_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("服务器启动");
		
		while(true){
			final Socket socket = server.accept();//用final修饰
			new Thread(){
				public void run(){
					try {
						InputStream in = socket.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						
						String fileName = br.readLine();
						File dir = new File("update");
						dir.mkdir();//创建文件夹
						File file = new File(dir,fileName);//封装成File对象
						if(file.exists()){
							ps.println("文件已存在");
							socket.close();
							return;
						}
						else{
							ps.println("文件不存在");
						}
						
						FileOutputStream out = new FileOutputStream(file);//创建输出流(将从客户端获取的文件保存)
						byte[] b = new byte[8192];
						int len ;
						while((len = in.read(b)) != -1){//读取客户端的输出流的数据
							out.write(b,0,len);//把数据输出到文件中
						}
						out.close();
						ps.close();
						socket.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}

	}
}
