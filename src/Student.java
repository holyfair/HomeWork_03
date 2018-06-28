
public class Student extends Human{

	private String facult;
	private int course;
	
	public Student(String name, int age, boolean sex, String facult, int course) {
		super(name, age, sex);
		this.facult = facult;
		this.course = course;
	}
	
	public Student(String name, int age, boolean sex) {
		super(name, age, sex);
	}

	public String getFacult() {
		return facult;
	}

	public void setFacult(String facult) {
		this.facult = facult;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}
	
	@Override
	public String hello() {
		return "Darova";
	}

	@Override
	public String toString() {
		return "[facult=" + facult + ", course=" + course + " " + super.toString() +"]";
	}
	
	
	
}
