package course7;
/**
 * 通过等待唤醒机制实现两个线程之间的通信
 * @author ywb
 *
 */
public class WaitAndNotifyDemo1 {
	public static void main(String[] args) {
		ThreadA ta = new ThreadA();
		
			new ThreadA(){
				public void run(){
					while(true){
						try {
							ta.run1();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
			new ThreadA(){
				public void run(){
					while(true){
						try {
							ta.run2();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		
	}
}


class ThreadA extends Thread{
	int flag = 1;
	public void run1() throws InterruptedException{
		synchronized(this){
			if(flag != 1){
				this.wait();
			}
			System.out.print("3");
			System.out.print("2");
			System.out.print("1");
			System.out.print("0");
			flag = 2;
			this.notify();
		}
	}

	public void run2() throws InterruptedException{
		synchronized(this){
			if(flag != 2){
				this.wait();
			}
			System.out.print("开");
			System.out.print("始");
			System.out.print("游");
			System.out.print("戏" + "\n");
			flag = 1;
			this.notify();
		}
		
	}
}