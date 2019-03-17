package course2;
/**
 * 参数传递机制
 *    xx=cc格式是基本数据类型传值     而aa.xx=cc格式是引用类型参数传值
 * @author ywb
 *
 */

public class ParameterTransmitDemo {
	int id;
	String name;
	public ParameterTransmitDemo(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	public void test0(int id){
		//基本数据类型传值(传递的是参数值的副本,这个副本的值改变了，原参数的值也不会改变)
		id = id +11;
	}
	public void test1(ParameterTransmitDemo ptd){
		//引用数据类型参数传值(传的是内存地址，内存地址中的值改变了，原参数值也会改变)
		ptd.name = "xxx";
	}
	public void test2(ParameterTransmitDemo ptd){
		/*引用数据类型参数传值，但是创建了新的内存地址，并把新的内存地址指向了这个对象，
		 * 这个对象不再引用原对象的物理地址，因此这个对象地址中的值改变和原参数的值无关*/
		ptd = new ParameterTransmitDemo(11, "yyyy");
	}
	
	public static void main(String[] args) {
		ParameterTransmitDemo ptd = new ParameterTransmitDemo(1,"zs");
		ptd.test0(10);
		System.out.println(ptd.id);//发现id并没有变化
		
		ptd.test1(ptd);
		System.out.println(ptd.name);
		ptd.test2(ptd);
		System.out.println(ptd.name);
	}
}
