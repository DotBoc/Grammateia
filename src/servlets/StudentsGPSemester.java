package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Users;
import utilities.AuthUtils;
import utilities.DBUtils;

/**
 * Servlet implementation class StudentsGPSemester
 */
@WebServlet("/StudentsGPSemester")
public class StudentsGPSemester extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentsGPSemester() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("# - Starting StudentsGPSemester");
		HttpSession session = request.getSession();
		System.out.println("# - StudentsGPSemester got Session");

		Users loginedUser = AuthUtils.getLoginedUser(session);
		System.out.println("# - StudentsGPSemester got User");

		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.setAttribute("user", loginedUser);
		request.setAttribute("GradesPerSemesters", DBUtils.getGradesPerSemesters(loginedUser));

		System.out.println("# - StudentsGPSemester setted user");

		RequestDispatcher dispatcher = request.getRequestDispatcher("StudentGradesPerSemester.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
