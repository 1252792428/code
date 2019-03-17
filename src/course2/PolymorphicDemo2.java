package course2;
/**
 * 多态
 * @author ywb
 *
 */
public class PolymorphicDemo2 {
	public static void main(String[] args) {
		Eat e = new Eat();
		e.eat(new Cat1());
	}
}

interface Animal1{
	public void eat(); 
}
class Dog1 implements Animal1{
	@Override
	public void eat() {
		System.out.println("吃肉");
	}
	
}
class Cat1 implements Animal1{
	@Override
	public void eat() {
		System.out.println("吃鱼");
	}
	
}
class Eat{
	public void eat(Animal1 a){
		a.eat();
	}
}