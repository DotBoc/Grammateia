<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/elements/head.jsp"></jsp:include>
<jsp:include page="/WEB-INF/elements/ProfessorTopMenu.jsp"></jsp:include>
</head>
<body>

<div>
<h3>Hello: ${user.username}</h3>
</div>

<div>
<% String status = request.getParameter("status");  %> ${status}
</div>

</body>
</html>