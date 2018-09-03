package models;

public class GradedCourses {
	
	private String name;
	private float grade;
	private int semester;
	
	
	
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

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	
	
	

}
