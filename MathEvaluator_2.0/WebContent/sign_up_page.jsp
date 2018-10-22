<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Please input students information. So we can put it in the
		system.</h1>
	<form method="post" action="create_student">
		<table>
			<tr>
				<td>Student Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>ID Number</td>
				<td><input type="text" name="ID"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="enter"></td>
			</tr>
		</table>
	</form>
</body>
</html>