package course5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Collections工具类对容器的控制
 * @author ywb
 *
 */
public class CollectionControlDemo {
	public static void main(String[] args) {
		/**
		 * 同步控制(线程安全)
		 */
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		List<String> synList = Collections.synchronizedList(list);//将list转换成线程安全的list(同理还有Collection     Map     Set等)
		System.out.println(synList);
		
		/**
		 * 只读设置
					方式:emptyXxx()			空的不可变的集合
						 singletonXxx()		一个元素不可变的集合
						 unmodifiableXxx() 	不可变容器
		 */
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "张三");
		map.put("position", "学生");
		
		Map<String,String> map2 = Collections.unmodifiableMap(map);//map2无法修改
		//map2.put("play", "学习");//会报错
		System.out.println(map2);
	}
}
