package course3;

public class IntegerDemo {
	public static void main(String[] args) {
		Integer i1 = 1234;
		Integer i2 = 1234;
		Integer i3 = 123;
		Integer i4 = 123;
		System.out.println(i1==i2);//false
		System.out.println(i3==i4);//true   在-128~127之间的数，仍当做基本数据类型来处理
	}
}
