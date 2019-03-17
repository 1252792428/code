package course7;
/**
 * 设置线程优先级
 * @author ywb
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				for(int i=0;i<500;i++){
					System.out.println("aaa");
				}
			}
		};
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<500;i++){
					System.out.println("bbb");
				}
			}
		});
		t1.setPriority(10);
		t2.setPriority(1);
		
		t1.start();
		t2.start();
	}
}
