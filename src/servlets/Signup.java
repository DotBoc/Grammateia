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
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
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

		if (DBUtils.checkUsername(username)) {
			if (DBUtils.register(username, password, name, surname, department,"Gram")) {
				RequestDispatcher rd = request.getRequestDispatcher("GramMenu");
				request.setAttribute("status","You have succesfully created a Secretary Account");
				rd.forward(request, response);
			} else {
				out.print("Sorry username or password error");
				RequestDispatcher rd = request.getRequestDispatcher("failed.html");
				rd.include(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("GramMenu");
			request.setAttribute("status","Sorry this username is already in use");
			rd.include(request, response);
		}

		out.close();
	}
}