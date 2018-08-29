package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (DBUtils.validate(username, password)) {
			
			switch(DBUtils.getrole(username)) {
				
			case "Gram" : 
			
			case "Student" :
			
			case "Professor" :
			
			case "error" :
				
			default:	
			
			}
			
			
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);			
			session.setMaxInactiveInterval(5 * 60);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("StudentsMenu.jsp");
			rd.forward(request, response);
		} else {
			out.print("Sorry username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("failed.html");
			rd.include(request, response);
		}

		out.close();
	}
}