package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.mindrot.BCrypt;

import models.*;

public class DBUtils {

	public static Users getUser(String username) throws SQLException {

		try {
			Connection con = SQLConnUtils.getSQLConnection();
			System.out.println("# - Starting getUser");

			PreparedStatement ps = con.prepareStatement(
					"Select GUser_ID,GUser_username,GUser_name,GUser_surname,GUser_department,GUser_role from GUser where GUser_username=?");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			System.out.println("# - Query executed");
			while (rs.next()) {

				Users user = new Users();
				user.setUsersID(rs.getInt("GUser_ID"));
				user.setUsername(rs.getString("GUser_username"));
				user.setName(rs.getString("GUser_name"));
				user.setSurname(rs.getString("GUser_surname"));
				user.setDepartment(rs.getInt("GUser_department"));
				user.setRole(rs.getString("GUser_role"));
				System.out.println(user);
				return user;

			}

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
		}

		return null;
	}

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

	public static boolean register(String username, String password, String name, String surname, String department,
			String role) {
		boolean registered = false;
		try {

			int department_id = Integer.parseInt(department);

			String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

			Connection con = SQLConnUtils.getSQLConnection();
			PreparedStatement ps = con.prepareStatement("insert into GUser values(?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, hashed);
			ps.setString(3, name);
			ps.setString(4, surname);
			ps.setInt(5, department_id);
			ps.setString(6, role);

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
			String role, String registration_number, String gender, String semester) {
		boolean registered = false;
		int gUser_ID = 0;

		try {

			int semester_numerical = Integer.parseInt(semester);

			if (register(username, password, name, surname, department, role)) {

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

	public static boolean registerP(String username, String password, String name, String surname, String department,
			String role, String email) {
		boolean registered = false;
		int gUser_ID = 0;

		try {

			if (register(username, password, name, surname, department, role)) {

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

				// Users user = new Users(gUser_ID ,gUser_username, gUser_name,gUser_surname,
				// gUser_department);

				System.out.println(gUser_password_hashed);

				if (BCrypt.checkpw(password, gUser_password_hashed)) {
					status = true;
				}

			}

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
		}
		System.out.println("# - Ending Validate");
		return status;
	}

	public static String getrole(String username) {
		String role = "error";

		try {

			Connection con = SQLConnUtils.getSQLConnection();
			System.out.println("# - Starting Validation");

			PreparedStatement ps = con.prepareStatement("Select GUser_role from GUser where GUser_username=?");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			System.out.println("# - Query role executed");
			while (rs.next()) {

				role = rs.getString("GUser_role");
				System.out.println("Role:" + role);
			}

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
		}
		return role;
	}

	public static List<Courses> getAllCourses(Users user) {

		List<Courses> list = new LinkedList<>();

		try {
			Connection con = SQLConnUtils.getSQLConnection();
			System.out.println("# - Creating List");

			PreparedStatement ps = con.prepareStatement("Select * from Courses where FK_Courses_Department_ID = ?");
			ps.setInt(1, user.getDepartment());

			ResultSet rs = ps.executeQuery();
			System.out.println("# - Query executed");

			while (rs.next()) {
				Courses course = new Courses();
				course.setId(rs.getInt("Courses_ID"));
				course.setName(rs.getString("Courses_Name"));
				course.setSemester(rs.getInt("Course_Semester"));
				course.setDepartment(rs.getInt("FK_Courses_Department_ID"));
				System.out.println("# - Added Course to list");

				list.add(course);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static List<Courses> getDepartmentCoursesWithProf(Users user) {

		List<Courses> list = new LinkedList<>();

		try {
			Connection con = SQLConnUtils.getSQLConnection();
			System.out.println("# - Creating List");

			PreparedStatement ps = con
					.prepareStatement("Select Courses.Courses_Name , Courses.Course_Semester, GUser.GUser_surname \r\n"
							+ "From GUser,Professors,Professors_has_Courses,Courses\r\n"
							+ "where GUser.GUser_ID = Professors.FK_Professors_GUser_ID \r\n"
							+ "and Professors.FK_Professors_GUser_ID = Professors_has_Courses.FK_Professors_has_Courses_Professors_ID\r\n"
							+ "and Professors_has_Courses.FK_Professors_has_Courses_Courses_ID = Courses.Courses_ID\r\n"
							+ "and GUser.GUser_department = ?");
			ps.setInt(1, user.getDepartment());

			ResultSet rs = ps.executeQuery();
			System.out.println("# - Query executed");

			while (rs.next()) {
				Courses course = new Courses();
				course.setId(rs.getInt("Courses_ID"));
				course.setName(rs.getString("Courses_Name"));
				course.setSemester(rs.getInt("Course_Semester"));
				course.setDepartment(rs.getInt("FK_Courses_Department_ID"));

				list.add(course);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static boolean enrolltocourse(int uid, int course_id) {
		boolean success = false;
		try {

			Connection con = SQLConnUtils.getSQLConnection();
			PreparedStatement ps = con.prepareStatement("insert into Students_has_Courses values(?,?)");
			ps.setInt(1, uid);
			ps.setInt(2, course_id);

			int i = ps.executeUpdate();

			if (i > 0) {
				success = true;
				System.out.println("You are sucessfully enrolled to a course");
			}

		} catch (Exception se) {
			se.printStackTrace();
		}

		return success;

	}

	public static List<Professors> getAllProfessors(Users user) {

		List<Professors> list = new LinkedList<>();

		try {
			Connection con = SQLConnUtils.getSQLConnection();
			System.out.println("# - Creating List");

			PreparedStatement ps = con.prepareStatement(
					"Select GUser.GUser_ID , GUser.GUser_username , GUser.GUser_name ,GUser.GUser_surname , GUser.GUser_department , GUser.GUser_role , Professors.Professors_email From GUser,Professors where GUser.GUser_department = ? and GUser.GUser_ID = Professors.FK_Professors_GUser_ID ");
			ps.setInt(1, user.getDepartment());

			ResultSet rs = ps.executeQuery();
			System.out.println("# - Query executed");

			while (rs.next()) {
				
				Professors professor = new Professors(rs.getInt("GUser_ID"), rs.getString("GUser_username"), rs.getString("GUser_name"), rs.getString("GUser_surname"),rs.getInt("GUser_department"), rs.getString("GUser_role"), rs.getString("Professors_email"));
				System.out.println("# - Added Professors to list");

				list.add(professor);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static boolean assignCourse (int gUser_ID , int course_ID ) {
		boolean assigned = false;
		
		try {

			
			Connection con = SQLConnUtils.getSQLConnection();
			PreparedStatement ps = con.prepareStatement("insert into Professors_has_Courses values (?,?)");
			ps.setInt(1, gUser_ID);
			ps.setInt(2, course_ID);
			

			int i = ps.executeUpdate();

			if (i > 0) {
				assigned = true;
				System.out.println("You have succesfully assigned a course");
			}

		} catch (Exception se) {
			se.printStackTrace();
		}
		
		return assigned ;
	}
}