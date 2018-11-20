<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%  String name = (String) session.getAttribute("name");%>
<%  String level = (String) session.getAttribute("level");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<b>Hello: </b><%=name%>
	<b>You're at level: </b><%=level%>

</body>
</html>