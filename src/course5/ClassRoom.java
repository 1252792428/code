package course5;

import java.util.ArrayList;
import java.util.List;
/**
 * 班级
 * @author ywb
 *
 */
public class ClassRoom {
	private int roomId;
	private List<Student> stu;
	private double total;  //总分
	
	public ClassRoom() {
		stu = new ArrayList<Student>();
	}
	public ClassRoom(int roomId) {
		this();
		this.roomId = roomId;
		
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public List<Student> getStu() {
		return stu;
	}
	public void setStu(List<Student> stu) {
		this.stu = stu;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "ClassRoom [roomId=" + roomId + ", stu=" + stu + ", total=" + total + "]";
	}
	
}
