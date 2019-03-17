package course7;
/**
 * 线程安全问题1
 * @author ywb
 *
 */
public class ThreadSafeDemo1 {
	public static void main(String[] args) {

	/*	new Money().start();
		new Money().start();
		new Money().start();
		new Money().start();*/
		
		Tickets tickets = new Tickets();
		new Thread(tickets).start();
		new Thread(tickets).start();
		new Thread(tickets).start();
		new Thread(tickets).start();
	}
}
class Money extends Thread{
	private static double totalMoney = 100.0;//总话费金额(设置为共享的资源对象,否则每个线程单独执行一次全部的循环)
	/*public void run(){
		while(true){
			if(totalMoney <= 0){
				break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("取出:1块钱\t剩余" + totalMoney--);
		}
	}//会发现，有时会出现负数金额的情况，这是不合理的*/
	public void run(){
		while(true){
			synchronized (Money.class) {//同步代码块的方式	(这里放的锁是线程类的字节码对象)
				if(totalMoney <= 0){
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getName()+"取出:1块钱\t剩余" + totalMoney--);
			}
			
		}
	}
}

class Tickets implements Runnable{
	private int ticket = 100;//因为4个线程都共用整个类的对象，这里可以不用设置为静态变量
	public void run(){
		while(true){
			synchronized (Tickets.class) {//同步代码块的方式	(这里放的锁是线程类的字节码对象)
				if( ticket<= 0){
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"取出:1张票\t剩余" + ticket--);
			}
			
		}
	}
	
}