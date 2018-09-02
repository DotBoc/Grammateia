<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/elements/head.jsp"></jsp:include>
<jsp:include page="/WEB-INF/elements/GramTopMenu.jsp"></jsp:include>
</head>
<body>

	<h3>Select a Professor and a Course</h3>
	<div style="margin-left: auto; margin-right: auto;">

		<form action="CourseAssign" method="post">

			<select name="ProfessorName">

				<c:forEach items="${AllProfessors}" var="l">

					<option value="${l.usersID}">${l.surname}</option>

				</c:forEach>


			</select> <select name="CourseName">

				<c:forEach items="${AllCourses}" var="p">

					<option value="${p.id}">${p.name}</option>

				</c:forEach>


			</select> <input type="submit" value="Submit">
		</form>


	</div>

</body>
</html>