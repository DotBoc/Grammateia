<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/elements/head.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Grammateia</title>
<script src="res/js/loginrules"></script>
</head>
<body>
	<form method="post" action="LoginChecker">
		Name:<input type="text" name="username" /><br />
		<br /> Password:<input type="password" name="password" /><br />
		<br /> <input type="submit" value="login" />
	</form>
</body>
</html>