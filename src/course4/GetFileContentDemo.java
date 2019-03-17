package course4;

import java.io.FileReader;
import java.io.IOException;
/**
 * 获得文件内容;while循环中需要注意的事项
 * @author ywb
 *
 */
public class GetFileContentDemo {
	public static void main(String[] args) {
		FileReader fileReader = null;
		StringBuffer sb = new StringBuffer(16);
		try {
			fileReader = new FileReader("E:/eclipse/workspace/java_study/aaa/a.txt");
			int n = -1;//注意！！！！！！！！
			/**
			 * 这里加一个变量的目的是传入fileReader.read()的值，因为while循环中括号里会默认执行
			 * 一次fileReader.read()，如果在内部再使用fileReader.read()的话会导致只读取一半的数据
			 */
			while((n=fileReader.read()) != -1){
				char c = (char)n;
				sb.append(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(fileReader != null){
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sb);
	}
}
