import java.io.File;
import java.io.IOException;

public class SaveOrLoadStudentWithFiles {

	public static Group loadFromFile(File file){
		Group group = null;
		try {
			group = (Group) Service.loadObject(file);
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("no");
		}
		return group;
	}
	public static void saveToFile(Group group, File file) {
		try {
			Service.saveObject(file, group);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
