package course7;
/**
 * 休眠线程
 * @author ywb
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) throws InterruptedException {
		for(int i = 5 ; i > 0 ;i --){
			Thread.sleep(1000);
			System.out.println("倒数计时" + i);
		}
		new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("aaa");
				}
			}
		}.start();
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<10;i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("bbb");
				}
			}
		}).start();
	}
}
