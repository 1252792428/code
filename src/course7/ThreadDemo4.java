package course7;
/**
 * 守护线程(其他线程执行完毕，守护线程也停止执行(也会有延迟))
 * @author ywb
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("aaa");
				}
			}
		};
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<50;i++){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("bbb");
				}
			}
		});
		/**
		 * 注意，设置为守护线程应放在线程启动之前，如果在启动线程之后设置守护线程的话会抛出
		 *  java.lang.IllegalThreadStateException
		 */
		t2.setDaemon(true);//当传入true的时候，说明将t2线程设置为守护线程
		t1.start();
		t2.start();
		
	}
}
