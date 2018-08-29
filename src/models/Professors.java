package models;

public class Professors extends Users {
	
	private String TeachingSubject;
	private String Email;
	
	
	public String getTeachingSubject() {
		return TeachingSubject;
	}

	public void setTeachingSubject( String teachingSubject) {
		TeachingSubject = teachingSubject;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail( String email) {
		Email = email;
	}
	
	public Professors(String username, String password, String name, String surname, int department, String email, String teachingSubject) {
		super(username, password, name, surname, department);		
		this.setEmail(email);
		this.setTeachingSubject(teachingSubject);
		//Constructor for the Professors objects.
	}
}
