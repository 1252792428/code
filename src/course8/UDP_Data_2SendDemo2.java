package course8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP传输	发送端	从键盘获取数据并传输
 * @author ywb
 *
 */
public class UDP_Data_2SendDemo2 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		DatagramSocket socket = new DatagramSocket();//创建Socket(相当于码头)
		while(true){
			String str = scanner.nextLine();
			if("quit".equals(str)){
				break;
			}
			//创建发送对象
			DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length,InetAddress.getByName("127.0.0.1"),6666);
			socket.send(packet);//发货
		}
		
		socket.close();
	}
}
