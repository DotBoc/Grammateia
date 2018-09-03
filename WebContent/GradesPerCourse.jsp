<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/elements/head.jsp"></jsp:include>
<jsp:include page="/WEB-INF/elements/StudentsTopMenu.jsp"></jsp:include>
</head>
<body>
	<div style="margin-left: auto; margin-right: auto;">

		

			<table>
				<thead>
					<tr>
						<th width="33%">Course Name</th>
						<th width="34%">Grade</th>
						<th width="33%">Semester</th>

					</tr>
				</thead>

				<c:forEach items="${AllCourses}" var="p">

					<tr>		
						<td>${p.name}</td>				
						<td>${p.grade}</td>
						<td>${p.semester}</td>
					</tr>


				</c:forEach>

			</table>
			

	</div>
	
</body>
</html>