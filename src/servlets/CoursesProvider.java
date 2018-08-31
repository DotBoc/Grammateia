package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilities.SQLConnUtils;

/**
 * Servlet implementation class CoursesProvider
 */
@WebServlet("/StudentCourses")
public class CoursesProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
	    	PrintWriter out = response.getWriter();
	    	out.print("<table border='1' style=\"width:100%\"><th>Course</th><th>Semester</th><th>Enrolled</th>");
	    	
	    	try {
	    		Connection con = SQLConnUtils.getSQLConnection();
				System.out.println("# - Starting Validation");
				
				PreparedStatement ps = con.prepareStatement("Select Courses_ID,Courses_Name,Course_Semester from Courses");
				

				ResultSet rs = ps.executeQuery();
				System.out.println("# - Query executed");
				while (rs.next()) {				
					
					out.print("<tr><td>");
					out.print(rs.getString(2));
					out.print("</td>");
					out.print("<td>");
					out.print(Integer.toString(rs.getInt(3)));
					out.print("</td>");
					out.print("<td>");
					out.print("<input type='checkbox' name="+ Integer.toString(rs.getInt(1)) +" />");
					out.print("</td>");
					
				}
	    	}catch (Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    	out.print("</table>");
	    }
  
}
