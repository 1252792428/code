package course1;
/**
 * 运算符
 * @author ywb
 *
 */
public class OperatorDemo {
	public static void main(String[] args) {
		int a = 1;
		int b = a++;
		int c = ++a;
		
		short s1 = 1;
		s1 = 1;
		//s1 = s1 + 1;//需要强制类型转换
		s1 += 1;//发现编译通过
		System.out.println(s1);
		System.out.println(a+"\t"+b+"\t"+c);
		//a=3 b=1 c=3
		a += b;  //等效于a=a+b
		System.out.println(a);
		a *= b+1; //等效于 a=a*(b+1)
		System.out.println(a);
		
		//移位运算符
		System.out.println(~2);//取反
		System.out.println(3<<3);//3*2*2*2
		System.out.println(16>>3);//16/2/2/2
	}
}
