package models;

public class Users {

	private String Username;
	private String PasswordHash;
	private String Name;
	private String Surname;
	private int Department;
	private static int UsersID = 0;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPasswordHash() {
		return PasswordHash;
	}

	public void setPasswordHash(String passwordHash) {
		PasswordHash = passwordHash;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getDepartment() {
		return Department;
	}

	public void setDepartment(int department) {
		Department = department;
	}

	public void setUsersID(int usersID) {
		UsersID = usersID;
	}

	public int getUsersID() {
		return UsersID;
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

	public Users(int usersID ,String username, String name,String surname, int department){
		this.setUsersID(usersID);
		this.setUsername(username);		
		this.setName(name);
		this.setSurname(surname);
		this.setDepartment(department);		
	}

}
