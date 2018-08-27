<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="Signup">
		Username:<input type="text" name="username" /><br /> <br />
		Password:<input type="text" name="password" /><br /> <br /> 
		Name:<input	type="text" name="name" /><br /> <br />
		Surname:<input type="text" name="surname" /><br /><br /> 
		Department: <select name="department">
			<option value="1">Computer Science</option>
			<option value="2">Mathematics</option>
		</select> <br /><br />
		<input type="submit" value="Sign up" />
	</form>
</body>
</html>