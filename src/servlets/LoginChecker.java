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

		String page;
		String role = "error";
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (DBUtils.validate(username, password)) {
			
			switch(DBUtils.getrole(username)) {
				
			case "Gram" :
				page = "GramMenu.jsp";
				role = "Gram";
				break;
							
			
			case "Student" :
				page = "StudentsMenu.jsp";
				role = "Student";
				break;
			
			case "Professor" : 
				page = "ProfessorMenu.jsp";
				role = "Professor";
				break;
			
			case "error" : 
				page = "failed.html";
				role = "error";
				break;
				
			default: 
				page = "failed.html";
				break;
			
			}
			
			
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);	
			session.setAttribute("role", role);	
			session.setMaxInactiveInterval(5 * 60);
			
			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else {
			out.print("Sorry username or password error");
			HttpSession session = request.getSession(false);
			System.out.println("User=" + session.getAttribute("user"));
			System.out.println("Role=" + session.getAttribute("role"));
			if (session != null) {
				session.invalidate();
			}
			RequestDispatcher rd = request.getRequestDispatcher("failed.html");
			rd.include(request, response);
		}

		out.close();
	}
}