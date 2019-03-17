package course8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP传输	接收端
 * @author ywb
 *
 */
public class UDP_Data_2ReceiveDemo {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(6666);//创建Socket  并指定端口号
		DatagramPacket packet = new DatagramPacket(new byte[1024],1024);//创建packet
		
		while(true){
			socket.receive(packet);
			byte[] data = packet.getData();
			int len = packet.getLength();
			String str = new String(data,0,len);
			System.out.println(str+"-----");
		}
	}
}
