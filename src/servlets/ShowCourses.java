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
 * Servlet implementation class ShowCourses
 */
@WebServlet("/ShowCourses")
public class ShowCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public ShowCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("# - Starting ShowCourses");
		HttpSession session = request.getSession();
		System.out.println("# - ShowCourses got Session");

		Users loginedUser = AuthUtils.getLoginedUser(session);
		System.out.println("# - ShowCourses got User");

		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.setAttribute("user", loginedUser);
		request.setAttribute("AllCourses", DBUtils.getDepartmentCoursesWithProf(loginedUser));
		
		
		
		System.out.println("# - ShowCourses setted user");
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("SCourses.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
