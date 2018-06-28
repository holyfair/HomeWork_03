
public class Main {

	public static void main(String[] args) {
		Human human = new Human("Petya", 19, true);
        System.out.println(human);
        Student studentOne = new Student("Vlad", 19, true, "KNIT", 2);
        System.out.println(studentOne);
        Student studentTwo = new Student("Yarik", 18, true, "Knit", 2);
        Student studentThree = new Student("Galyts", 18, true, "KNIT", 2);
        Student studentFive = new Student("Maria", 17, false, "MED-2", 2);
        Student studentSix = new Student("Masha", 17, false, "MED-2", 2);
        
        Group group = new Group();
        group.setStudent(studentOne, 3);
        group.setStudent(studentSix, 6);
        group.setStudent(studentFive, 7);
        group.setStudent(studentThree, 8);
        group.setStudent(studentTwo, 2);
        group.setStudent(studentOne, 10);
        
        System.out.println(group.searchOfStudent("Vld"));
        System.out.println(group.searchOfStudent("Vlad"));
        System.out.println(group);
	}

}
