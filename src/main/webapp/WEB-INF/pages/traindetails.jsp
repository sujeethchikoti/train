<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan" align="center">
<form action="traindetails" method="post">
		Source:<select name="source">
			<option value="">-Select-</option>
			<option value="Mathura">Mathura</option>
			<option value="lonavala">Lonavala</option>
			<option value="ambala">Ambala</option>
			<option value="delhi">Delhi</option>
			<option value="mumbai">Mumbai</option>
			<option value="chandigarh">Chandigarh</option>
		</select><br><br>
		 Destination:<select name="destination">
			<option value="">-Select-</option>
			<option value="Mathura">Mathura</option>
			<option value="lonavala">Lonavala</option>
			<option value="ambala">Ambala</option>
			<option value="agra">Agra</option>
			<option value="pune">Pune</option>
			<option value="kurukshetra">Kurukshetra</option>
		</select><br> <br> <input type="submit" value="Get Train Details" />
	</form>
</body>
</html>