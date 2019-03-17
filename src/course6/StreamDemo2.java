package course6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象操作流
 * @author ywb
 *
 */
public class StreamDemo2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private static ObjectInputStream ois;
	
	
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public StreamDemo2() {
		super();
	}
	public StreamDemo2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//对象操作流(类必须实现Serializable接口)
		//存入对象
		StreamDemo2 people = new StreamDemo2("张三",18);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/eclipse/workspace"
				+ "/java_study/aaa/b.txt"));
		
		oos.writeObject(people);
		oos.close();
		
		ois = new ObjectInputStream(new FileInputStream("E:/eclipse/workspace"
				+ "/java_study/aaa/b.txt"));
		StreamDemo2 s1 = (StreamDemo2) ois.readObject();
		System.out.println(s1);
	}
}
