package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;
import utilities.*;

/**
 * Servlet implementation class LoginChecker
 */
@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			

		Users user = null;
		String page;		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		if (DBUtils.validate(username, password)) {
			
			
			try {
				user = DBUtils.getUser(username);
				System.out.println("# - Created user");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(user.getRole()) {
				
			case "Gram" :
				page = "/GramMenu.jsp";
				System.out.println(user.getRole());
				break;
										
			case "Student" :
				page = "/StudentsMenu";
				System.out.println(user.getRole());
				break;
			
			case "Professor" : 
				page = "/ProfessorMenu.jsp";
				System.out.println(user.getRole());
				break;					
				
			default: 
				page = "/failed.html";
				System.out.println(user.getRole());
				break;
			
			}	
		
			
			
	        AuthUtils.storeLoginedUser(session, user);
	        System.out.println("# - Stored user");
	        response.sendRedirect(request.getContextPath() + page);
			
			
		} else {
			out.print("Sorry username or password error");
					
			if (session != null) {
				session.invalidate();
			}
			RequestDispatcher rd = request.getRequestDispatcher("failed.html");
			rd.include(request, response);
		}

		out.close();
	}
}