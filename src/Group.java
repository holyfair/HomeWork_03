import java.util.Arrays;

public class Group {

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
	
	public void setStudent(Student student) {
		int index = -1;
		for(int i = group.length - 1; i >= 0; i--) {
			if(group[i] == null) {
				index = i;
			}
		}
		try {
		if(index != -1) {
			group[index] = student;
		}else {
			throw new FullGroupException();
		}
	}catch(FullGroupException e) {
		System.out.println(e.getMessage());
	}
}
	
	public void setStudent(Student student, int index) {
		try {
		if(index >= 0 && index < group.length) {
			group[index] = student;
		}else {
			throw new IllegalIndexException();
		}
	}catch(IllegalIndexException e) {
		System.out.println(e.getMessage());
	}
}
	public String searchOfStudent(String name) {
		for(int i = 0; i < group.length; i++) {
			if(group[i] != null && group[i].getName().equals(name)) {
				return group[i].getName();
			}
		}
		return "Name is not found";
	}
	
	static void swap(Student[] group, int left, int right) {
	    if (left != right) {
	        Student temp = group[left];
	        group[left] = group[right];
	        group[right] = temp;
	    }
	}
	private Student[] sorter(Student[] group){
        for (int i = 1; i < group.length - 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
            	int state = 0;
                if (group[j] == null) {
                    swap(group, j, j + 1);
                } else {
                    if(group[j + 1] != null && group[j].getName().charAt(0) > group[j + 1].getName().charAt(0)) {
                    	swap(group, j, j + 1);
                    }else {
                    		if(group[j + 1] != null) {
                    			while(state < group[j].getName().length() && state < group[j + 1].getName().length() && (group[j].getName().charAt(state) == group[j + 1].getName().charAt(state))) {
                        			state++;
                        			if(group[j].getName().charAt(state) > group[j + 1].getName().charAt(state)) {
                                    	swap(group, j, j + 1);
                                    	break;
                                    }
                        		}
                    		}
                    	break;
                    }
                    
                }
            }
        }
		return group;
	}
	
	@Override
	public String toString() {
		group = sorter(group);
		String sb = "";
		for(int i = 0; i < group.length; i++) {
			if(group[i] != null) {
				sb += new String(i + " - " + group[i].getName() + "\n");
			}
		}
		return sb;
	}
	
	
	
}
