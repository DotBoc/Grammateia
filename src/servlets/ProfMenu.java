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

/**
 * Servlet implementation class ProfMenu
 */
@WebServlet("/ProfMenu")
public class ProfMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProfMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		
		System.out.println("# - Starting ProfMenu");
		HttpSession session = request.getSession();
		System.out.println("# - ProfMenu got Session");
		

		Users loginedUser = AuthUtils.getLoginedUser(session);
		System.out.println("# - ProfMenu got User");

		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.setAttribute("user", loginedUser);
		System.out.println("# - ProfMenu setted user");

		RequestDispatcher dispatcher = request.getRequestDispatcher("Professor.jsp");
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
