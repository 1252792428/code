package course7;
/**
 * 线程安全问题2    重要！！！！！
 * @author ywb
 *
 */
public class ThreadSafeDemo2 {
	public static void main(String[] args) {
		ThreadB tb = new ThreadB();//注意   ！！！！！
		while(true){//为什么出现线程不安全问题？
				new ThreadB(){
					public void run(){
						tb.methodB();//为什么如果用对象.方法的话，不会出现安全问题
					}
				}.start();
			
		}
		
		/*new ThreadB(){//单线程的话不会出现问题
			public void run(){
				while(true){
					methodB();
				}
			}
		}.start();*/
		
		
		/*new ThreadB(){//为什么会出现线程安全问题？ ,为什么使用对象.methodB就不会出现安全问题？
			public void run(){
				while(true){
					methodA();
				}
			}
		}.start();
		new ThreadB(){
			public void run(){
				while(true){
					methodB();
				}
			}
		}.start();*/
		
		/*ThreadC tc = new ThreadC();//为什么有时候会出现乱码的情况？
		new Thread(tc).start();*/
	}
}

class ThreadB extends Thread{
	synchronized public void methodA(){
			System.out.print("3");
			System.out.print("2");
			System.out.print("1");
			System.out.print("0" + "\n");
			
	}
	synchronized public void methodB(){
		System.out.print("开");
		System.out.print("始");
		System.out.print("游");
		System.out.print("戏" + "\n");
		
}
}

class ThreadC extends Thread{
	public void run(){
		while(true){
			synchronized(this){
				System.out.print("开");
				System.out.print("始");
				System.out.print("游");
				System.out.print("戏" + "\n");
			}
		}
		
	}
}