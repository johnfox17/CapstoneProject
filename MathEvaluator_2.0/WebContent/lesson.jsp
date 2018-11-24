<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String name = (String) session.getAttribute("name");
%>
<%
	String level = (String) session.getAttribute("level");
%>
<%
	String problem = (String) session.getAttribute("problem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="lesson">
		<table>
			<tr>
				<td><b>Hello: </b><%=name%> </td>
				<td></td>
				<td><b>You're at level: </b><%=level%></td>
			</tr>
			<tr>
				<td><b>---</b><%=problem%></td>
			</tr>
			<tr>
				<td><input type="submit" value="login"></td>
			</tr>
			
		</table>
	</form>
	<form method="get" action="sign_out">
		<table>
			<tr>
				<td><input type="submit" value="logout"></td>
			</tr>
			
		</table>
	</form>
	

</body>
</html>