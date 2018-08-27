package models;

import java.util.InputMismatchException;

public class Students extends Users {
	
	private int RegistrationNumber;
	private String Gender;
	
	
	public int getRegistrationNumber() {
		return RegistrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		RegistrationNumber = registrationNumber;
	}
	
	public String getGender() {
		return Gender;
	}

	public void setGender( String gender) {
		Gender = gender;
	}
	
	
	public Students(String username, String password, String name, String surname, String department, String gender, int registrationNumber) {
		super(username, password, name, surname, department);
		this.setGender(gender);
		try {
		this.setRegistrationNumber(registrationNumber);
		}
		catch (InputMismatchException exception) {
			System.out.println("Integers only, please.");
		}
	}
		//Constructor for the Students objects.
}
	
	

