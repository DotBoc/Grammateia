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

	<div style="margin-left: auto; margin-right: auto;">


		<table>
			<thead>
				<tr>

					<th width="40%">Course Name</th>
					<th width="20%">Semester</th>
					<th width="40%">Professor</th>

				</tr>
			</thead>

			<c:forEach items="${AllCourses}" var="p">

				<tr>
					<td>${p.name}</td>
					<td>${p.semester}</td>
					<td>${p.surname}</td>
				</tr>


			</c:forEach>

		</table>




	</div>

</body>
</html>