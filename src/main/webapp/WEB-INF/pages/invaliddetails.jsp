<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Train Details</title>
</head>
<body bgcolor="cyan" align="center">
	<jsp:include page="traindetails.jsp" />
	<h3>
		Train Details
		</h3>
		<%=request.getAttribute("message")%>
		</body>
</html>