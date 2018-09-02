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

import models.Users;
import utilities.AuthUtils;
import utilities.DBUtils;

/**
 * Servlet implementation class CourseAssign
 */
@WebServlet("/CourseAssign")
public class CourseAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseAssign() {
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

		int gUser_ID, course_ID;
		String page;	
		
		HttpSession session = request.getSession();
		Users loginedUser = AuthUtils.getLoginedUser(session);
		System.out.println(loginedUser.getName());
		
		String guser_id = request.getParameter("ProfessorName");
		gUser_ID = Integer.parseInt(guser_id);

		String course_id = request.getParameter("CourseName");
		course_ID = Integer.parseInt(course_id);

		System.out.println("UserID"+ guser_id);
		System.out.println("CourseID" + course_id);

		try {

			if (DBUtils.assignCourse(gUser_ID, course_ID)) {
				page = "GramMenu";
				request.setAttribute("status","You have succesfully assigned a course");

			} else {
				page = "failed.html";

				if (session != null) {
					session.invalidate();
				}				
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request,response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
