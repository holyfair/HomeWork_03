
public class Human {

	private String name;
	private int age;
	private boolean sex;
	
	public Human(String name, int age, boolean sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	public String hello() {
		return "Hi";
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
