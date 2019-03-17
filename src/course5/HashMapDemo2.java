package course5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * HashMap经典存储    分拣思路   (与面对对象组合)
 * @author ywb
 *
 */
public class HashMapDemo2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		//HashMapDemo2 hmd = new HashMapDemo2();
		//hmd.exam(list);
		exam(list);
		
		Map<Integer,ClassRoom> rooms = new HashMap<Integer,ClassRoom>();//泛型内不能放基本数据类型
		count(rooms,list);
		printScore(rooms);
	}
	
	public static void exam(List<Student> list){
		list.add(new Student(1111,"zs",90,1));
		list.add(new Student(1112,"ls",70,1));
		list.add(new Student(1113,"ww",60,1));
		list.add(new Student(1114,"zl",80,2));
		list.add(new Student(1115,"sl",80,2));
	}
	public static void count(Map<Integer,ClassRoom> rooms,List<Student> list){
		for(Student stu :list){
			int classRoom = stu.getClassRoom();//获取学生班级编号
			double score = stu.getScore();//获取分数
			
			ClassRoom room = rooms.get(classRoom);//根据键查询班级号
			if(null == room){
				room = new ClassRoom(classRoom);
				rooms.put(classRoom,room);
			}
			
			//存储
			room.setTotal(room.getTotal()+score);
			room.getStu().add(stu);
		}
	}
	//打印
	public static void printScore(Map<Integer,ClassRoom> rooms){
		Set<Map.Entry<Integer,ClassRoom>> entrySet = rooms.entrySet();
		Iterator<Map.Entry<Integer,ClassRoom>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<Integer,ClassRoom> room = it.next();
			System.out.println("班级编号:"+room.getValue().getRoomId()+"----班级总分:"+room.getValue().getTotal()+"----班级总人数:"+room.getValue().getStu().size());
		}
	}
}
