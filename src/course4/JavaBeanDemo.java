package course4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaBeanDemo {//这种类叫做javaBean或实体类
	private int id;
	private String name;
	private int age;
	private String userName;
	private String password;
	private String date;
	public JavaBeanDemo(){
		
	}
	public JavaBeanDemo(int id, String name, int age, String userName, String password, String date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.userName = userName;
		this.password = password;

		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = df2.parse(date);
			this.date = parse.toLocaleString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
