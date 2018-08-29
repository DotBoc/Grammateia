package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.BCrypt;

import models.Users;

public class DBUtils {

	public static boolean checkUsername(String username) {
		boolean availiable = true;
		try {

			Connection con = SQLConnUtils.getSQLConnection();
			System.out.println("# - Starting checkUsername");

			PreparedStatement ps = con
					.prepareStatement("Select Count(GUser_username) AS searched from GUser where GUser_username=?");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			System.out.println("# - Query executed");

			rs.next();
			int exists = rs.getInt("searched");
			rs.close();

			if (exists == 1) {
				availiable = false;
				System.out.println("# - Username exists");
			}

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
		}
		return availiable;
	}

	public static boolean register(String username, String password, String name, String surname, String department) {
		boolean registered = false;
		try {

			int department_id = Integer.parseInt(department);

			String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

			Connection con = SQLConnUtils.getSQLConnection();
			PreparedStatement ps = con.prepareStatement("insert into GUser values(?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, hashed);
			ps.setString(3, name);
			ps.setString(4, surname);
			ps.setInt(5, department_id);

			int i = ps.executeUpdate();

			if (i > 0) {
				registered = true;
				System.out.println("You are sucessfully registered as GUser");
			}

		} catch (Exception se) {
			se.printStackTrace();
		}
		return registered;
	}

	public static boolean register(String username, String password, String name, String surname, String department,
			String registration_number, String gender, String semester) {
		boolean registered = false;
		int gUser_ID = 0;

		try {

			int semester_numerical = Integer.parseInt(semester);

			if (register(username, password, name, surname, department)) {

				Connection con = SQLConnUtils.getSQLConnection();
				PreparedStatement ps = con.prepareStatement("Select GUser_ID from GUser where GUser_username=?");
				ps.setString(1, username);

				ResultSet rs = ps.executeQuery();
				System.out.println("# - Query executed");

				while (rs.next()) {

					gUser_ID = rs.getInt("GUser_ID");

					System.out.println(gUser_ID);

				}

				PreparedStatement ps1 = con.prepareStatement("insert into Students values(?,?,?,?)");
				ps1.setInt(1, gUser_ID);
				ps1.setString(2, registration_number);
				ps1.setString(3, gender);
				ps1.setInt(4, semester_numerical);

				int i = ps1.executeUpdate();

				if (i > 0) {
					registered = true;
					System.out.println("You are sucessfully registered as Student");
				}

			}

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error : " + ex);
		}

		return registered;
	}

	public static boolean register(String username, String password, String name, String surname, String department,
			String email) {
		boolean registered = false;
		int gUser_ID = 0;

		try {

			if (register(username, password, name, surname, department)) {

				Connection con = SQLConnUtils.getSQLConnection();
				PreparedStatement ps = con.prepareStatement("Select GUser_ID from GUser where GUser_username=?");
				ps.setString(1, username);

				ResultSet rs = ps.executeQuery();
				System.out.println("# - Query executed");

				while (rs.next()) {

					gUser_ID = rs.getInt("GUser_ID");

					System.out.println(gUser_ID);

				}

				PreparedStatement ps1 = con.prepareStatement("insert into Professors values(?,?)");
				ps1.setInt(1, gUser_ID);
				ps1.setString(2, email);

				int i = ps1.executeUpdate();

				if (i > 0) {
					registered = true;
					System.out.println("You are sucessfully registered as Professor");
				}

			}

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error : " + ex);
		}

		return registered;
	}

	public static boolean validate(String username, String password) {
		boolean status = false;
		try {

			Connection con = SQLConnUtils.getSQLConnection();
			System.out.println("# - Starting Validation");

			PreparedStatement ps = con.prepareStatement("Select * from GUser where GUser_username=?");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			System.out.println("# - Query executed");
			while (rs.next()) {
					
				
				int gUser_ID = rs.getInt("GUser_ID");
				String gUser_username = rs.getString("GUser_username");
				String gUser_password_hashed = rs.getString("GUser_password");
				String gUser_name = rs.getString("GUser_name");
				String gUser_surname = rs.getString("GUser_surname");
				int gUser_department = rs.getInt("GUser_department");
				
				Users user = new Users(gUser_ID ,gUser_username, gUser_name,gUser_surname, gUser_department);

				System.out.println(gUser_password_hashed);

				if (BCrypt.checkpw(password, gUser_password_hashed)) {
					status = true;
				}
				
				
			}

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
		}
		return status;
	}
	
	public static int rolechecker(int gUser_ID) {
		int role = 0;
		
		Users.getUsersID
		
		
		
		
		return role;
		
	}

}