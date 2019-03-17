package course4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 迭代器使用
 * @author ywb
 *
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			String str = (String) iter.next();
			System.out.println(str);
		}
	}
}
