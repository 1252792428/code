package course7;
/**
 * 三个或以上线程之间的通信
 * @author ywb
 *
 */
public class WaitAndNotifyDemo2 {
	public static void main(String[] args) {
		ThreadA1 ta = new ThreadA1();
		new ThreadA1(){
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
			new ThreadA1(){
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
			new ThreadA1(){
				public void run(){
					while(true){
						try {
							ta.run3();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		
	}
}

//用之前的wait和notify方法，发现当三个线程或以上的时候，会出现问题(原因是notify唤醒是随机的,唤醒了不应该唤醒的线程，从而导致全部线程都陷入睡眠)
/*class ThreadA1 extends Thread{
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
			System.out.print("戏");
			flag = 3;
			this.notify();
		}
		
	}
	public void run3() throws InterruptedException{
		synchronized(this){
			if(flag != 3){
				this.wait();
			}
			System.out.print("——");
			System.out.print("——");
			System.out.print("联");
			System.out.print("盟" + "\n");
			flag = 1;
			this.notify();
		}
		
	}
}*/
//把if语句改为while    使用notifyAll方法
class ThreadA1 extends Thread{
	int flag = 1;
	public void run1() throws InterruptedException{
		synchronized(ThreadA1.class){//锁对象  (这里为了明显，没使用this而是使用类的对象 )
			while(flag != 1){
				ThreadA1.class.wait();//由锁对象调用
			}
			System.out.print("3");
			System.out.print("2");
			System.out.print("1");
			System.out.print("0");
			flag = 2;
			ThreadA1.class.notifyAll();//由锁对象调用
		}
	}

	public void run2() throws InterruptedException{
		synchronized(ThreadA1.class){
			while(flag != 2){
				ThreadA1.class.wait();
			}
			System.out.print("开");
			System.out.print("始");
			System.out.print("游");
			System.out.print("戏");
			flag = 3;
			ThreadA1.class.notifyAll();
		}
		
	}
	public void run3() throws InterruptedException{
		synchronized(ThreadA1.class){//锁对象
			if(flag != 3){
				ThreadA1.class.wait();//由锁对象调用
			}
			System.out.print("——");
			System.out.print("——");
			System.out.print("联");
			System.out.print("盟" + "\n");
			flag = 1;
			ThreadA1.class.notifyAll();//由锁对象调用
		}
		
	}
}