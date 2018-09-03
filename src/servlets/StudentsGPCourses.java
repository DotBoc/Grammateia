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
 * Servlet implementation class StudentsGPCourses
 */
@WebServlet("/StudentsGPCourses")
public class StudentsGPCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsGPCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("# - Starting StudentsGPCourses");
		HttpSession session = request.getSession();
		System.out.println("# - StudentsGPCourses got Session");

		Users loginedUser = AuthUtils.getLoginedUser(session);
		System.out.println("# - StudentsGPCourses got User");

		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.setAttribute("user", loginedUser);
		request.setAttribute("AllCourses", DBUtils.getStudentGradedCourses(loginedUser));
					
		System.out.println("# - StudentsGPCourses setted user");
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("GradesPerCourse.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
