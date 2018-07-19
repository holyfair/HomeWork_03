import java.io.Serializable;

public class Student extends Human implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course;
		result = prime * result + ((facult == null) ? 0 : facult.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (course != other.course)
			return false;
		if (facult == null) {
			if (other.facult != null)
				return false;
		} else if (!facult.equals(other.facult))
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	
}
