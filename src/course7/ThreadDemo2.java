package course7;
/**
 * 线程设置名字，获取名字
 * 获取当前线程的对象
 * @author ywb
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		//给线程命名方式一
		new Thread("线程1"){
			public void run(){
				for(int i = 0 ; i <10 ; i ++){
					System.out.println("1"+this.getName());//获取线程名字
				}
			}
		}.start();
		//给线程命名方式二
		new Thread(new Runnable(){
			public void run(){
				for(int i = 0 ; i <10 ; i ++){
					System.out.println("2"+Thread.currentThread().getName());
					//获取当前正在执行的线程的名字
				}
			}
		},"线程2").start();
		//给线程命名方式三  通过setName的方式
		
		
		//获取当前线程的名字(主线程)    也可以设置名字
		System.out.println(Thread.currentThread().getName());
	}
}
