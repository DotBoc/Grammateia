package models;

public class Users {

	private String username;
	private String passwordHash;
	private String name;
	private String surname;
	private int department;
	private String role;
	private int usersID = 0;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username_) {
		username = username_;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash_) {
		passwordHash = passwordHash_;
	}

	public String getName() {
		return name;
	}

	public void setName(String name_) {
		name = name_;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname_) {
		surname = surname_;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department_) {
		department = department_;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role_) {
		role = role_;
	}


	public void setUsersID(int usersID_) {
		usersID = usersID_;
	}

	public int getUsersID() {
		return usersID;
	}

	public Users() {

	}

	public Users(String username, String password, String name, String surname, int department) {
		this.setUsername(username);
		this.setPasswordHash(password);
		this.setName(name);
		this.setSurname(surname);
		this.setDepartment(department);
	}

	public Users(int usersID ,String username, String name,String surname, int department ,String role){
		this.setUsersID(usersID);
		this.setUsername(username);		
		this.setName(name);
		this.setSurname(surname);
		this.setDepartment(department);		
		this.setRole(role);
	}

}
