package course7;
/**
 * 加入线程，礼让线程
 * @author ywb
 *
 */
public class ThreadDemo5 {
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
					if(i == 0){
						try {
							t1.join();//插入线程1，等待线程1执行完毕
							//也可以设置插队的时间
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("bbb");
				}
			}
		});
		t1.start();
		t2.start();
		//礼让线程和加入线程相反(礼让线程效果不好)
	}
}
