<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/elements/head.jsp"></jsp:include>
<jsp:include page="/WEB-INF/elements/GramTopMenu.jsp"></jsp:include>
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