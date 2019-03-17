package course5;

import java.util.TreeSet;

/**
 * TreeSet的使用  (TreeMap使用方式基本相同)
 * @author ywb
 *
 */
public class TreeSetDemo {
	private String name;
	private int price;
	public TreeSetDemo() {
		super();
	}
	public TreeSetDemo(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "名称:"+this.name+"\t"+"价格:"+this.price+"\n";
	}
	
	
	public static void main(String[] args) {
		TreeSetDemo t1 = new TreeSetDemo("土豆",10);
		TreeSetDemo t2 = new TreeSetDemo("萝卜",5);
		TreeSetDemo t3 = new TreeSetDemo("肉",15);
		TreeSetDemo t4 = new TreeSetDemo("白菜",1);
		
		TreeSet<TreeSetDemo> t = new TreeSet<TreeSetDemo>(
				new java.util.Comparator<TreeSetDemo>(){//通过匿名内部类的方式
					@Override
					public int compare(TreeSetDemo o1, TreeSetDemo o2) {
						return o1.price - o2.price;
					}
					
				}
		);
		
		t.add(t1);//在添加的时候就会自动排序，不需要再调用Collections的sort方法了
		t.add(t2);
		t.add(t3);
		t.add(t4);
		System.out.println(t);
	}
	
}
