package course2;
/**
 * 多态
 * @author ywb
 *
 */
public class PolymorphicDemo {
	public static void main(String[] args) {
		Animal a = new Animal();
		animalShout(a);
		
		Dog d = new Dog();
		animalShout(d);
		
		//也可以写成
		Animal c = new Cat();
		animalShout(c);
		
	}
	static void animalShout(Animal a){
		a.shout();
	}
}

class Animal{
	public void shout(){
		System.out.println("动物叫了一声");
	}
	
}
class Dog extends Animal{
	public void shout(){
		System.out.println("狗叫了一声");
	}
}
class Cat extends Animal{
	public void shout(){
		System.out.println("猫叫了一声");
	}
}