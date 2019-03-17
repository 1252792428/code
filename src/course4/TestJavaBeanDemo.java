package course4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author ywb
 *
 */
public class TestJavaBeanDemo {
	public static void main(String[] args) {
		//JavaBeanDemo jb = new JavaBeanDemo();一个个set太麻烦了
		JavaBeanDemo jb1 = new JavaBeanDemo(1,"zs",18,"root","123456","2018-11-11");
		JavaBeanDemo jb2 = new JavaBeanDemo(2,"ls",20,"root","123456","2018-11-11");
		JavaBeanDemo jb3 = new JavaBeanDemo(3,"ws",20,"root","123456","2018-11-11");
		
		
		//用List来保存数据(规定类型只能是JavaBeanDemo)
		List<JavaBeanDemo> list = new ArrayList<JavaBeanDemo>();
		list.add(jb1);
		list.add(jb2);
		list.add(jb3);
		System.out.println(list.size());
		
		Map map = new HashMap<>();
		map.put("id", 10);
		map.put("name", "abc");
		map.put("age", 18);
		map.put("userName", "root");
		map.put("password", "123456");
		map.put("date", "8102-11-11");
		List<Map> list2 = new ArrayList<Map>();
		list2.add(map);
		
		
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println(list.get(i).getName());
		}
		
		
		System.out.println(list2.get(0).get("password"));
	}
}
