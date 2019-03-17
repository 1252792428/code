package course8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP传输    (发送端)
 * @author ywb
 *
 */
public class UDP_Data_1SendDemo {
	public static void main(String[] args) throws Exception {
		String str = "因爱好而努力,不是一件令人愉悦的事情吗?\n为梦想而努力,不是一件令人激动的事情吗?";
		DatagramSocket socket = new DatagramSocket();//创建Socket(相当于码头)
		//创建发送对象
		DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length,InetAddress.getByName("127.0.0.1"),6666);
		socket.send(packet);//发货
		socket.close();
	}
}
