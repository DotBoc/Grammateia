package models;

public class Courses {
	
	private String name;
	private int semester;
	private int id;
	private int department;
	
	
	public String getName() {
		return name;
	}

	public void setName( String courseName) {
		name = courseName;
	}
	
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester_) {
		semester = semester_;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id_) {
		id = id_;
	}
	
	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department_) {
		department = department_;
	}

}
