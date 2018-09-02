<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/elements/head.jsp"></jsp:include>
<jsp:include page="/WEB-INF/elements/ProfessorTopMenu.jsp"></jsp:include>
</head>
<body>

	<h3>Select a Course , type the Student's Registration Number and
		the Grade</h3>
	<div style="margin-left: auto; margin-right: auto;">

		<form action="InsertEvaluation" method="post">

			Course : <select name="CourseName">

				<c:forEach items="${AllCourses}" var="p">

					<option value="${p.id}">${p.name}</option>

				</c:forEach>
				
			</select><br />	<br /> 
			
			Registration Number : <input type="text" name="registration_number" /><br />	<br /> 
			
			Grade :  <input type="number" name="grade" min="1" max="10" step="0.5"><br /> <br /> 
			
			<input type="submit" value="Submit">
		</form>


	</div>

</body>
</html>