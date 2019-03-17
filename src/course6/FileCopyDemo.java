package course6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件拷贝操作
 * @author ywb
 *
 */
public class FileCopyDemo {
	public static void main(String[] args) throws Exception {
		//fileCopy();
		fileCopy3();
		
	}
	
	public static void fileCopy() throws Exception{//一个字节一个字节的拷贝，效率低
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("E:/eclipse/workspace/java_study/aaa/a.txt");
			out = new FileOutputStream("E:/eclipse/workspace/java_study/aaa/copy.txt");
			int tep;
			while((tep = in.read()) != -1){
				out.write(tep);
			}
		}
		finally{
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 文件拷贝优化1
	 */
	public static void fileCopy1(){
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("E:/eclipse/workspace/java_study/aaa/a.txt");
			out = new FileOutputStream("E:/eclipse/workspace/java_study/aaa/copy.txt");
			byte[] b = new byte[4]; //一次读取4个字节  (也可以一次读取in.available()个字节)
			while(in.read(b) != -1){
				out.write(b);//会发现多写了几个字节
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 文件拷贝优化2
	 */
	public static void fileCopy2() throws Exception{
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("E:/eclipse/workspace/java_study/aaa/a.txt");
			out = new FileOutputStream("E:/eclipse/workspace/java_study/aaa/copy.txt");
			int len;
			byte[] b = new byte[4]; //一次读取4个字节  (也可以一次读取in.available()个字节)
			while((len = in.read(b)) != -1){
				out.write(b,0,len);//区别优化1
			}
		}
		finally{
			try{
				if(out != null){
					out.close();
				}
			}
			finally{
				if(in != null){
					in.close();
				}
			}
		}
	}
	
	/**
	 * 文件拷贝3,使用Buffered
	 */
	
	public static void fileCopy3() throws Exception{
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream("E:/eclipse/workspace/java_study/aaa/a.txt"));
			out = new BufferedOutputStream(new FileOutputStream("E:/eclipse/workspace/java_study/aaa/copy.txt"));
			int b ;
			while((b = in.read()) != -1){
				out.write(b);
			}
		}
		finally{
			try{
				if(out != null){
					out.close();
				}
			}
			finally{
				if(in != null){
					in.close();
				}
			}
		}
	}
	/**
	 * 文件拷贝4，自动关闭流对象
	 */
	public static void fileCopy4() throws Exception{
		//把流的创建放在try的小括号里，在执行完毕后会自动关闭流对象
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:/eclipse/workspace/java_study/aaa/a.txt"));
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:/eclipse/workspace/java_study/aaa/copy.txt"));
			) {
			int b ;
			while((b = in.read()) != -1){
				out.write(b);
			}
		}
	}
}
