package course7;
/**
 * 创建线程
 * @author ywb
 *
 */
public class ThreadDemo1 {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();//3.创建线程对象
		t1.start();//4.启动线程    注意: 是start方法
		for(int i=0; i < 1000; i++){
			System.out.println("cccccc");
		}
		
		Thread2 t2 = new Thread2();//创建类的实例对象
		Thread t = new Thread(t2); //把对象传给Thread类
		t.start();//Thread类调用start方法
		
		//使用匿名内部类实现多线程的方式
		//a
		new Thread(){
			public void run(){
				for(int i = 0 ; i <1000 ; i ++){
					System.out.println("1");
				}
			}
		}.start();
		//b
		new Thread(new Runnable(){
			public void run(){
				for(int i = 0 ; i <1000 ; i ++){
					System.out.println("2");
				}
			}
		}).start();
	}
}

//创建一个线程的两种方式   方式一
class Thread1 extends Thread{//1.继承Thread类
	public void run(){//2.重写run方法
		for(int i=0; i < 1000; i++){
			System.out.println("aaaaaa");
		}
	}
}
//创建一个线程的两种方式   方式二
class Thread2 implements Runnable{//实现Runnable接口
	@Override
	public void run() {//重写run方法
		for(int i=0; i < 1000; i++){
			System.out.println("bbbbbb");
		}
	}
	
}