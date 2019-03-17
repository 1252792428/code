package course5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties的使用
 * @author ywb
 *
 */
public class PropertiesDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//创建对象
		Properties pro = new Properties();
		pro.setProperty("driver", "jdbc:mysql://localhost:3306/db_student");
		pro.setProperty("user", "root");
		pro.setProperty("password", "123456");
		
		//创建配置文件
		pro.store(new FileOutputStream(new File("E:/eclipse/workspace/java_study/aaa/jdbc.properties")), "数据库配置文件");
		pro.storeToXML(new FileOutputStream(new File("E:/eclipse/workspace/java_study/aaa/jdbc.xml")), "数据库配置文件");
		
		//读取文件
		pro.load(new FileInputStream(new File("E:/eclipse/workspace/java_study/aaa/jdbc.properties")));
		System.out.println(pro);
	}
}
