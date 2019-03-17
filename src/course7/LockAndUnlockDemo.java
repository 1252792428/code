package course7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock类的互斥锁lock 与 unLock   (替代synchronized)
 * @author ywb
 *
 */
public class LockAndUnlockDemo {
	public static void main(String[] args) {
		ThreadB1 ta = new ThreadB1();
		new ThreadB1(){
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
			new ThreadB1(){
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
			new ThreadB1(){
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
class ThreadB1 extends Thread{
	int flag = 1;
	ReentrantLock rl = new ReentrantLock();
	Condition c1 = rl.newCondition();
	Condition c2 = rl.newCondition();
	Condition c3 = rl.newCondition();
	public void run1() throws InterruptedException{
		rl.lock(); //获取锁
			if(flag != 1){
				c1.await();
			}
			System.out.print("3");
			System.out.print("2");
			System.out.print("1");
			System.out.print("0");
			flag = 2;
			c2.signal();
		rl.unlock();//释放锁
		}

	public void run2() throws InterruptedException{
		rl.lock();
			if(flag != 2){
				c2.await();
			}
			System.out.print("开");
			System.out.print("始");
			System.out.print("游");
			System.out.print("戏");
			flag = 3;
			c3.signal();
		rl.unlock();
		}
		
	public void run3() throws InterruptedException{
		rl.lock();
			if(flag != 3){
				c3.await();
			}
			System.out.print("——");
			System.out.print("——");
			System.out.print("联");
			System.out.print("盟" + "\n");
			flag = 1;
			c1.signal();
		rl.unlock();
		}
}
