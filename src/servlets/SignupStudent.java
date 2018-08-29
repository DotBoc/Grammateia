package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilities.DBUtils;

/**
 * Servlet implementation class SignupStudent
 */
@WebServlet("/SignupStudent")
public class SignupStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String department = request.getParameter("department");
		String registration_number = request.getParameter("registration_number");
		String gender = request.getParameter("gender");
		String semester = request.getParameter("semester");

		if (DBUtils.checkUsername(username)) {
			if (DBUtils.register(username, password, name, surname, department,"Student",registration_number,gender,semester)) {
				RequestDispatcher rd = request.getRequestDispatcher("StudentsMenu.jsp");
				rd.forward(request, response);
			} else {
				out.print("Sorry username or password error");
				RequestDispatcher rd = request.getRequestDispatcher("failed.html");
				rd.include(request, response);
			}
		} else {
			out.print("Sorry this username is already in use");
			RequestDispatcher rd = request.getRequestDispatcher("failed.html");
			rd.include(request, response);
		}

		out.close();
	}
}