import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class Group implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> group = new ArrayList<>();
	
	public Group(List<Student> group) {
		this.group = group;
	}

	public Group() {
		super();
	}

	
	
	public List<Student> getGroup() {
		return group;
	}

	public boolean removeStudent(Student student) {
		return group.remove(student);
	}

	public void setStudent() throws GenderException {
		int age;
		String name;
		boolean sex;
		String facult;
		int course;

		for (;;) {

			try {
				age = Integer.valueOf(JOptionPane.showInputDialog("Input an age"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			}
		}
				name = String.valueOf(JOptionPane.showInputDialog("Input a name"));
		
	
	for (;;) {

		try {
			String temp = String.valueOf(JOptionPane.showInputDialog("This is a man? : yes or no"));
			if(temp.equals("yes")) {
				sex = true;
				break;
			}
			if(temp.equals("no")) {
				sex = false;
				break;
			}else {
				throw new GenderException();
			}
		} catch (GenderException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	facult = String.valueOf(JOptionPane.showInputDialog("Input a facult: "));
	for (;;) {

		try {
			course = Integer.valueOf(JOptionPane.showInputDialog("Input a course: "));
			break;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error number format");
		}
	}
	Student student = new Student(name, age, sex, facult, course);
	group.add(student);
	}

	


	public void setStudent(Student student) {
		group.add(student);
	}

	public String searchOfStudent(String name) {
		for(Student student : group) {
			if(student.getName().equals(name)) {
				return name;
			}
		}
		return "Name is not found";
	}
	
	private int compareToBoolean(boolean a, boolean b) {
		if(a == true && b == false) {
			return 1;
		}
		if(a == false && b == true) {
			return -1;
		}
		return 0;
	}

	public void sorter(String parametr) {
		try {
			
		if(parametr.equals("name")) {
			group.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : a.getName().compareTo(b.getName()));
			return;
		}
		if(parametr.equals("age")) {
			group.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : a.getAge() - b.getAge());
			return;
		}
		if(parametr.equals("sex")) {
			group.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : compareToBoolean(a.getSex(), b.getSex()));
			return;
		}
		if(parametr.equals("facult")) {
			group.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : a.getFacult().compareTo(b.getFacult()));
			return;
		}
		if(parametr.equals("course")) {
			group.sort((a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : a.getCourse() - b.getCourse());
		}else {
			throw new IllegalParametrException();
		}
		}catch(IllegalParametrException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		sorter("name");
		StringBuilder sb = new StringBuilder();
		group.forEach((student) -> sb.append(student.toString()).append(System.lineSeparator()));
		return sb.toString();
	}


}
