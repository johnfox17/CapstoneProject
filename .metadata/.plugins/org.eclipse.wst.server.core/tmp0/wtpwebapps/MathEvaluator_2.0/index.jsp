<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="get" action="info">
		<table>
			<tr>
				<td>Please input student ID number</td>
				<td><input type="text" name="ID"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
			</tr>
			<tr>
				<td><a href="sign_up_page.jsp">If not signed up, please do so.</a></td>
			</tr>
			<tr>
				<td><a href="eliminate_student.jsp">To eliminate student please click on this link.</a></td>
			</tr>
		</table>
	</form>
	<p>${error}</p>
</body>
</html>