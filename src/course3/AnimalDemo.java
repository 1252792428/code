package course3;

public abstract class AnimalDemo {
	public abstract void run();
}

class cat extends AnimalDemo{
	@Override
	public void run() {
		//继承抽象类的类必须实现抽象类的全部方法，否则为抽象类
	}
	
}