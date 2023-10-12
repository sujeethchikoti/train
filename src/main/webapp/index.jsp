<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body align="center" bgcolor="cyan">
	<h1>Welcome To Rail Portal</h1>
<img src="https://www.irctc.co.in/nget/assets/images/secondry-logo.png" alt="train logo"/>
	<form action="register" method="post">
		<br>
		<br>
		<h2>Registration</h2>
		
		<br> Full name: <input type="text" name="name" required="True" /><br>
		<br> E-mail: <input type="email" name="email" required="True"/><br>
		<br> Password: <input type="password" name="password" required="True"/><br>
		<br> <input type="submit" value="Register" /><input type="reset"
			value="Clear" />

	</form>
	<br>
	<br>
	<form action="create" method="post">
		Already have an Account ? <input type="submit" value="Login" />
	</form>
</body>
</html>

