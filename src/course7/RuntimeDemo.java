package course7;

import java.io.IOException;

/**
 * 运行时对象    (该类也实现了单例模式-饿汉式，还有很多类都实现了单例模式)
 * @author ywb
 *
 */
public class RuntimeDemo {
	/**
	 * 为什么Runtime使用单例设计模式？
	 * 因为开启和关闭需要操作同一对象
	 */

	public static void main(String[] args) throws IOException {
		Runtime r =Runtime.getRuntime();
		//r.exec("shutdown -s -t 300");  //内部放的是命令行(300s后关闭计算机)
		r.exec("shutdown -a");//取消
		
	}
}
