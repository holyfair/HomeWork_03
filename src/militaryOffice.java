import java.awt.List;
import java.util.ArrayList;

public interface militaryOffice {

	public ArrayList militaryOffice = new ArrayList<Student>();
	
	public static ArrayList<Student> getRecruit(Group group){
		for(Student student : group.getGroup()) {
			if(student != null && student.getAge() >= 18) {
				militaryOffice.add(student);
			}
		}
		return militaryOffice;
	}
}
