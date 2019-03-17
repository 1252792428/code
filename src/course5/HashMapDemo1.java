package course5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * HashMap经典存储    分拣思路  
 * @author ywb
 *
 */
public class HashMapDemo1 {
	String str = "You become what you believe. You are where you are today in your life"
			   + " based on everything you have believed";
	String[] strArr = str.split(" ");
	//统计上面字符串各个单词出现的次数
	//方案一
	public void method1(){
		Map<String, Boxs> boxs = new HashMap<String,Boxs>();
		for(String temp : strArr){
			if(!boxs.containsKey(temp)){//如果容器内没有这个key
				boxs.put(temp, new Boxs());
			}
			Boxs box = boxs.get(temp);
			box.setId(box.getId() + 1);
		}
		//输出Map的值
		Set<String> keys = boxs.keySet();
		for(String key:keys){
			Boxs box = boxs.get(key);
			System.out.println("单词"+key+"出现了"+box.getId()+"次！");
		}
	}
	//方案二
	public void method2(){
		Map<String, Boxs> boxs = new HashMap<String,Boxs>();
	
		for(String temp:strArr){
			Boxs box = null;
			//为所有key创建容器
			if(null==(box=boxs.get(temp))){
				box = new Boxs();
				box.setId(0);
				boxs.put(temp,box);
			}
			//之后容器中存放对应的value
			box.setId(box.getId()+1);
		}
		//输出Map的值
		Set<String> keys = boxs.keySet();
		for(String key:keys){
			Boxs box = boxs.get(key);
			System.out.println("单词"+key+"出现了"+box.getId()+"次！");
		}
	}
	
	public static void main(String[] args) {
		HashMapDemo1 hmd = new HashMapDemo1();
		//hmd.method1();
		hmd.method2();
		
		
	}
}
