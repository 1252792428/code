package course3;
/**
 * 测试异常和变量
 * @author ywb
 *
 */
public class Exception1Demo {
    String str;//成员变量，使用时可以不用初始化
	static int i;//静态成员变量
	public static void main(String[] args){
		int i = 2;//局部变量 ， 使用前必须初始化
		ABCD abcd = new ABCD();
		abcd.method2();
		System.out.println(i);//打印的是局部变量里的i
		try{
			int a = i/1;//注意，如果这里抛出了异常，下面的代码不会执行
			throw new AaaaException("抛出了自定义的异常");
			//try和catch中的return 会在finally之后执行
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("11222");
		}
		finally{
			System.out.println("1111111");
		}
	}
	public void method1(){
		System.out.println(str);
	}
	
}
class ABCD{
	String str2;//成员变量
	public void method2(){
		System.out.println(str2);
	};
}
//自定义异常
class AaaaException extends Exception{//继承Exception类
	
    public AaaaException() {
    }
    public AaaaException(String msg) {
        super(msg);
    }
}