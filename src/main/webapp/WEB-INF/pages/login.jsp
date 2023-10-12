<html>
<head>
<title>Login</title>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body align="center" bgcolor="cyan">
<form action="login" method="post">
<h2>Login</h2>
Username <input type="text" name="username" required="true" /><br><br>
Password <input type="password" name="password" required="true" /><br><br>
<input type="submit" value="Login"/><input type="reset" value="Clear"/>
</form>
</body>
</html>