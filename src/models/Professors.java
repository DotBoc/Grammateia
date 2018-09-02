package models;

public class Professors extends Users {
	
	private String Email;
	
	public String getEmail() {
		return Email;
	}

	public void setEmail( String email) {
		Email = email;
	}
	
	public Professors(int usersID ,String username,  String name, String surname, int department,String role, String email) {
		super(usersID ,username, name, surname, department ,role);		
		this.setEmail(email);		
		//Constructor for the Professors objects.
	}
}
