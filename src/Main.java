import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args)  {
        Student studentTwo = new Student("Yarik", 18, true, "KNIT", 2);
        Student studentThree = new Student("Galyts", 18, true, "KNIT", 2);
        Student studentFive = new Student("Maria", 17, false, "MED-2", 2);
        Student studentSix = new Student("Masha", 17, false, "MED-2", 2);
        Student studentFour = new Student("Lesha", 18, true, "FRGTB", 2);
        
        Group group = new Group();
        group.setStudent(studentSix, 6);
        group.setStudent(studentFive, 7);
        group.setStudent(studentThree, 8);
        group.setStudent(studentTwo, 2);
        group.setStudent(studentFour);
        File file = new File("Group");
        
        SaveOrLoadStudentWithFiles.saveToFile(group, file);
        
		System.out.println(SaveOrLoadStudentWithFiles.loadFromFile(file));
	}

}
