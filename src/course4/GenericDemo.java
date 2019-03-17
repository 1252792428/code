package course4;
/**
 * 泛型的使用
 * @author ywb
 *
 */
public class GenericDemo {
	public static void main(String[] args) {
		Object obj = 100;
		int i = (int)obj;//先将Object转换成Integer，再自动拆箱
		
		System.out.println(i);
		
		//泛型在使用时指定数据类型
		Person<String,Integer> p = new Person<String,Integer>();//泛型的数据类型不能是基本数据类型，但可以是包装类
		
		//类型检查
		p.setStudent("123");//里面只能放String类型
		p.setTeacher(1);//只能是Integer类型或int类型
		System.out.println(32000&32);
	}
	
}

/**
 * 泛型类
 * @author ywb
 *
 * @param <T>
 */
class Person<T1,T2>{
	private T1 student;
	private T2 teacher;
	public T1 getStudent() {
		return student;
	}
	public void setStudent(T1 student) {
		this.student = student;
	}
	public T2 getTeacher() {
		return teacher;
	}
	public void setTeacher(T2 teacher) {
		this.teacher = teacher;
	}
	
}