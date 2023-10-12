<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String uname = (String) session.getAttribute("uname");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
div {
	width: 1200px;
	overflow: hidden;
	clear: both;
}

p {
	margin-bottom: 10px;
}

input.right {
	float: right;
}
</style>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body align="center" bgcolor="cyan">
	<h1>Welcome to Rail Portal</h1>
	<div>
		<form action="index.jsp" method="post">
			<input type="submit" value="Logout" class="right">
			<%
				session.invalidate();
			%>
		</form>
	</div>
	<h2>
		Welcome
		<%=uname%></h2>
	<form action="nodetails" method="post">
		<b>Click here to get train details</b><br> <br> <input
			type="submit" value="Train Details"><br> <br>
	</form>
	<form action="details" method="post">
		<b>Click here to get trains list</b><br> <br> <input
			type="submit" value="Get Trains">
	</form>
</body>
</html>