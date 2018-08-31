package utilities;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import models.*;

public class AuthUtils {
	
	 public static void storeLoginedUser(HttpSession session, Users loggedinUser) {
		   System.out.println("Store loggedin user");
	       session.setAttribute("loggedinUser", loggedinUser);
	   }
	 
	 public static Users getLoginedUser(HttpSession session) {
		   System.out.println("Get stored loggedin user");
	       Users loggedinUser = (Users) session.getAttribute("loggedinUser");
	       return loggedinUser;
	 }

}
