<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Train details</title>
</head>
<body bgcolor="cyan" align="center">
<form action="trainnodetails" method="post">
		<h2>Enter Train Details</h2>
		Train No:<input type="number" name="trainno" /><br> <br> <input
			type="submit" value="GO" /><br> <br> <br>
		To book a Ticket:
		<button>
			<a href='https://www.irctc.co.in/nget/train-search'>IRCTC</a>
		</button>
		</br>
		</br>
	</form>
</body>
</html>