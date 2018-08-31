<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href='style.css' rel='stylesheet'>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;    
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li><a>Home</a></li>
	<li><a>Courses</a>
		<ul>
			<li><a href="StudentsCourses">Course Registration</a></li>
			<li><a>Semester</a></li>
			<li><a>Grades Summary</a></li>
		</ul></li>

	<li><a>Help</a></li>
	<li><a>Log Out</a></li>
</ul>
<form method="post" action="CoursesProvider">		
	<input type="submit" value="test"> 
	</form>
</body>
</html>