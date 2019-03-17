package course8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP结合多线程     让数据在一个类中数据传递
 * @author ywb
 *
 */
public class UDP_Data_3TransmitDemo {
	public static void main(String[] args) {
		
		new UDPReceive().start();
		new UDPSend().start();
	}
}

class UDPSend extends Thread{
	public void run(){
		try {
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
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class UDPReceive extends Thread{
	public void run(){
		try {
			DatagramSocket socket = new DatagramSocket(6666);//创建Socket  并指定端口号
			DatagramPacket packet = new DatagramPacket(new byte[1024],1024);//创建packet
			
			while(true){
				socket.receive(packet);
				byte[] data = packet.getData();
				int len = packet.getLength();
				String str = new String(data,0,len);
				System.out.println(str+"-----");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}