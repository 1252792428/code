package course1;
/**
 * 递归操作
 * @author ywb
 *
 */
public class RecursionDemo {
	public static void main(String[] args) {
		//method1();
		//method2();
		Recursion recursion = new Recursion();
		recursion.printTime();
	}
	public static void method1(){//会发现在执行很多次后抛出一个溢出的错误
		System.out.println("你好");
		method1();//不断自己调用自己，直到内存溢出
	}
	
	public static int i = 0;
	public static void method2(){
		System.out.println("你好");
		if(i < 10){//这也是一种递归
			i++;//自增必须放在自己调用自己之前，否则还没自增就又会调用自己
			method2();
		}
	}
	
	
}
class Recursion{
	public void printTime(){
		long d1 = System.currentTimeMillis(); //返回当前正在运行该方法的java虚拟机时间
		System.out.println("计算的结果为"+Recursion.count(10));//递归算法
		System.out.println("计算的结果为"+Recursion.count2(10));//循环算法
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long d2 = System.currentTimeMillis();
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d2-d1);
	}
	static int count(int i){
		if(i==1){
			return 1;
		}else{
			return i * count(i-1);
		}
	}
	static int count2(int i){
		int result=1;
		while(i>1){
			result = result * i * (i-1);
			i = i - 2;
		}
		return result;
	}
}
