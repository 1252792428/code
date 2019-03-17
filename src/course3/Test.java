package course3;

public class Test {
	public int aMethod() {
		int i=0;
		i++;
		return i;
	}

	public static void main(String args[]) {
		Test test = new Test();
		test.aMethod();
		int j = test.aMethod();
		System.out.println(j);

	}
}

class Super {
	public Object method0() {
		return "abc";
	}
}

class Sub extends Super {
	public Integer method0() {//参数类型和个数都不变，这是方法的重写
		//注意！！方法的重写的返回类型与父类的返回值类型相同或方法的返回值类型是父类中方法返回值类型的子类
		return 111;
	}
}