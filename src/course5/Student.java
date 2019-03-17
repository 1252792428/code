package course5;

public class Student {
	private int id;
	private String name;
	private double score;
	private int classRoom;
	
	
	public Student() {
	}
	public Student(int id, String name, double score, int classRoom) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.classRoom = classRoom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", score=" + score + ", classRoom=" + classRoom + "]";
	}
	
	
}
