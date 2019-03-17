package course8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 网络编程练习2   (客户端)    重要
 * 实现从客户端上传文件到服务端
 * @author ywb
 *
 */
public class Practice_2_TCP_Client {
	public static void main(String[] args) throws IOException {
		//获取文件路径
		File file = getFile();
		//发送文件名到服务端
		Socket socket = new Socket("127.0.0.1",12345);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//用字符输入流包装字节输入流
		PrintStream ps = new PrintStream(socket.getOutputStream());//用打印流包装字节输出流
		ps.println(file.getName());//要上传的文件的名字
		
		String result = br.readLine();//读取，根据返回的参数确定是否需要上传
		if("文件已存在".equals(result)){
			System.out.println("您上传的文件已经存在,不需要再上传");
			socket.close();
			return;
		}else{//如果文件不存在,则上传文件
			FileInputStream in = new FileInputStream(file);//输入流获取整个文件
			byte[] b = new byte[8192];//定义缓冲区
			int len ;
			while ((len = in.read(b)) != -1){//将文件放在客户端输出流中
				ps.write(b,0,len);//注意,未知文件格式,不能用print方法,因为print方法不是字节流
				ps.flush();
			}
		in.close();
		socket.close();
		}
		
	}
	
	public static File getFile(){//获取文件路径
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入您要上传的文件的路径:");
		while(true){
			String line = scanner.nextLine();
			File file = new File(line);
			
			if(!file.exists()){//如果文件不存在的话
				System.out.println("您录入的文件路径不存在，请重新输入");
			}else if(file.isDirectory()){//如果是一个文件夹
				System.out.println("不能上传文件夹，请重新输入");
			}else{
				return file;
			}
		}
	}
}
