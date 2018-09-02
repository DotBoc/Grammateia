<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="/WEB-INF/elements/head.jsp"></jsp:include>
<jsp:include page="/WEB-INF/elements/GramTopMenu.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="SignupStudent">
		Username:<input type="text" name="username" /><br /> <br />
		Password:<input type="text" name="password" /><br /> <br /> 
		Name:<input	type="text" name="name" /><br /> <br />
		Surname:<input type="text" name="surname" /><br /><br /> 
		Department: <select name="department">
			<option value="1">Computer Science</option>
			<option value="2">Mathematics</option>	
		</select> <br /><br />
		Registration Number:<input	type="text" name="registration_number" /><br /> <br />
		Gender: <select name="gender">
			<option value="Female">Female</option>
			<option value="Male">Male</option>	
		</select> <br /><br />		
		Semester:<select name="semester">
			<option value="1">1</option>
			<option value="2">2</option>	
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>			
		</select> <br /><br />		
		<input type="submit" value="Sign up" />
	</form>

</body>
</html>