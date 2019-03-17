package course8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP传输	(接收端)  先启动接收端，再启动发送端
 * @author ywb
 *
 */
public class UDP_Data_1ReceiveDemo {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(6666);//创建Socket  并指定端口号
		DatagramPacket packet = new DatagramPacket(new byte[1024],1024);//创建packet
		socket.receive(packet);
		
		byte[] data = packet.getData();
		int len = packet.getLength();
		String str = new String(data,0,len);
		
		System.out.println(str);
		socket.close();
	}
}
