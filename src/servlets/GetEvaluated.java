package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Evaluated;
import models.Users;
import utilities.AuthUtils;
import utilities.DBUtils;

/**
 * Servlet implementation class GetEvaluated
 */
@WebServlet("/GetEvaluated")
public class GetEvaluated extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetEvaluated() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int course_ID;

			System.out.println("# - Starting GetEvaluated");
			HttpSession session = request.getSession();
			System.out.println("# - GetEvaluated got Session");

			Users loginedUser = AuthUtils.getLoginedUser(session);
			System.out.println("# - GetEvaluated got User");

			String course_id = request.getParameter("CourseName");
			course_ID = Integer.parseInt(course_id);

			System.out.println("Starting the retrieval from DB");

			if (loginedUser == null) {
				response.sendRedirect(request.getContextPath() + "/login");
				return;
			}

			
			
			if(DBUtils.getEvaluated(course_ID) == null || DBUtils.getEvaluated(course_ID).isEmpty()) {				
				request.setAttribute("status","There are no records for this course.");
				RequestDispatcher rd = request.getRequestDispatcher("ProfMenu");
				rd.forward(request,response);
			}else {
				request.setAttribute("user", loginedUser);
				request.setAttribute("AllCourses", DBUtils.getEvaluated(course_ID));
				RequestDispatcher dispatcher = request.getRequestDispatcher("PShowEvaluated.jsp");
				dispatcher.forward(request, response);				
			}
			
			
			
	}
}
