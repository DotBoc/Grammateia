package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;
import utilities.AuthUtils;

/**
 * Servlet implementation class StudentsMenu
 */
@WebServlet("/StudentsMenu")
public class StudentsMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentsMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("# - Starting StudentsMenu");
		HttpSession session = request.getSession();
		System.out.println("# - StudentsMenu got Session");
		

		Users loginedUser = AuthUtils.getLoginedUser(session);
		System.out.println("# - StudentsMenu got User");

		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.setAttribute("user", loginedUser);
		System.out.println("# - StudentsMenu setted user");

		RequestDispatcher dispatcher = request.getRequestDispatcher("Students.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
