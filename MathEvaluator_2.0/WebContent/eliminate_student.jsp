<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>You have decided to eliminate a student from our database. Please input the ID of the student that you want to eliminate</h1>
	<form method="post" action="eliminate_student">
		<table>
			<tr>
				<td>ID Number</td>
				<td><input type="text" name="ID"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="enter"></td>
			</tr>
			<tr>
				<td><a href="index.jsp">Sign-in.</a></td>
			</tr>
		</table>
	</form>
</body>
</html>