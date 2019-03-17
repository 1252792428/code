package course2;
/**
 * equals方法的重写
 * @author ywb
 *
 */
public class EqualsDemo {
	public static void main(String[] args) {
		Person p1 = new Person(18,"zs","123");
		Person p2 = new Person(18,"ww","66");
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
	}
}
class Person{
	int id;
	String name;
	String pwd;
	
	public Person(int id,String name,String pwd){
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	@Override
	public boolean equals(Object obj){
		if(this == obj)//注意，这个this是指p1那个对象
			return true;
		if(obj == null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		Person other = (Person)obj;
		if(id!=other.id)
			return false;
		return true;
	}
}