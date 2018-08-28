<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%		
		String username = null;
		String sessionID = null;
		if (session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		} else {			
			username = (String) session.getAttribute("username");
			sessionID = session.getId();
		}
	%>
	
	<h3>Hi <%=username%>, Login successful. </h3>
	
	Your Session ID=<%=sessionID%>
	
	<br>
	<form action="<%=response.encodeURL("Logout")%>" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>