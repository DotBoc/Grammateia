package models;

public class Users {
	
	private String Username;
	private String PasswordHash;
	private String Name;
	private String Surname;
	private String Department;
	private static int UsersCounter = 0; 
	
	
	
	public String getUsername() {
		return Username;
	}

	public void setUsername( String username) {
		Username = username;
	}
	
	public String getPasswordHash() {
		return PasswordHash;
	}

	public void setPasswordHash( String passwordHash) {
		PasswordHash = passwordHash;
	}
	
	public String getName() {
		return Name;
	}

	public void setName( String name) {
		Name = name;
	}
	
	public String getSurname() {
		return Surname;
	}

	public void setSurname( String surname) {
		Surname = surname;
	}
	
	public String getDepartment() {
		return Department;
	}

	public void setDepartment( String department) {
		Department = department;
	}
	
	public int getUsersCounter() {
		return UsersCounter;
	}
	
	public Users() {
		
	}
	
	public Users(String username, String password, String name,String surname, String department){
		this.setUsername(username);
		this.setPasswordHash(password);
		this.setName(name);
		this.setSurname(surname);
		this.setDepartment(department);
		//Basic Constructor
	}
	
}


