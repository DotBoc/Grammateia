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
 * Servlet implementation class InsertEvaluation
 */
@WebServlet("/InsertEvaluation")
public class InsertEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertEvaluation() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int course_ID ;
		float grade;
		String rnumber,page;
		
		try {
		HttpSession session = request.getSession();
		Users loginedUser = AuthUtils.getLoginedUser(session);
		System.out.println(loginedUser.getName());
		
		String course_id = request.getParameter("CourseName");
		course_ID = Integer.parseInt(course_id);
		
		rnumber = request.getParameter("registration_number");
		
		String grade_ = request.getParameter("grade");
		grade = Float.parseFloat(grade_);
		
		System.out.println("CourseName"+ course_id);
		System.out.println("registration_number"+ rnumber);
		System.out.println("grade"+ grade_);


		if (DBUtils.gradeStudent(course_ID , rnumber , grade)) {
			page = "ProfMenu";
			request.setAttribute("status","You have succesfully graded a Student.");

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
