import java.io.Serializable;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Group implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student[] group = new Student[10];

	public Group(Student[] group) {
		this.group = group;
	}

	public Group() {
		super();
	}

	
	
	public Student[] getGroup() {
		return group;
	}

	public boolean removeStudent(Student student) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] == student) {
				group[i] = null;
				return true;
			}
		}
		return false;
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
	int index = -1;
	Student student = new Student(name, age, sex, facult, course);
	for (int i = group.length - 1; i >= 0; i--) {
		if (group[i] == null) {
			index = i;
		}
	}
	try {
		if (index != -1) {
			group[index] = student;
		} else {
			throw new FullGroupException();
		}
	} catch (FullGroupException e) {
		System.out.println(e.getMessage());
	}
	}

	


	public void setStudent(Student student) {
		int index = -1;
		for (int i = group.length - 1; i >= 0; i--) {
			if (group[i] == null) {
				index = i;
			}
		}
		try {
			if (index != -1) {
				group[index] = student;
			} else {
				throw new FullGroupException();
			}
		} catch (FullGroupException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setStudent(Student student, int index) {
		try {
			if (index >= 0 && index < group.length) {
				group[index] = student;
			} else {
				throw new IllegalIndexException();
			}
		} catch (IllegalIndexException e) {
			System.out.println(e.getMessage());
		}
	}

	public String searchOfStudent(String name) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null && group[i].getName().equals(name)) {
				return group[i].getName();
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
			Arrays.sort(group, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : a.getName().compareTo(b.getName()));
		}
		if(parametr.equals("age")) {
			Arrays.sort(group, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : a.getAge() - b.getAge());
		}
		if(parametr.equals("sex")) {
			
			Arrays.sort(group, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : compareToBoolean(a.getSex(), b.getSex()));
		}
		if(parametr.equals("facult")) {
			Arrays.sort(group, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
					? CheckNull.checkNull(a, b) : a.getFacult().compareTo(b.getFacult()));
		}
		if(parametr.equals("course")) {
			Arrays.sort(group, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL
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
//		sorter("name");
		String str = "";
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				str += new String(i + " - " + group[i].getName() + "\n");
			}
		}
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(group);
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
		Group other = (Group) obj;
		if (!Arrays.equals(group, other.group))
			return false;
		return true;
	}

}
