<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String first_name = (String) session.getAttribute("first_name");
%>
<%
	String last_name = (String) session.getAttribute("last_name");
%>
<%
	String chapter = (String) session.getAttribute("chapter");
%>
<%
	String difficulty = (String) session.getAttribute("difficulty");
%>
<%
	String problem = (String) session.getAttribute("problem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.container {
	position: relative;
}

.topright {
	position: absolute;
	top: 8px;
	right: 16px;
	font-size: 18px;
}

.submitbutton {
	position: absolute;
	top: 120px;
	height:100px;
	width:200px;
	left:0px;
	font-size: 46px;
}
.problemdisplay {
	position: absolute;
	top: 200px;
	left:400px;
	font-size: 150px;
}

.headerinf {
	position: absolute;
	right:400px;
	top: 35px;
}
.img {
	width: 100%;
	height: auto;
	opacity: 0.3;
}

HTML, body {
	margin: 30px;
	padding: 10px;
	border: 10px;
}
</style>
</head>
<body style="background-color: lightblue">
	<div class="container">
		<img src="src/ASUOnlineLogo.png" alt="ASUlogo">
		<div class="topright">
			<b>Logout? </b><a href="logout.jsp">here</a>
		</div>
		<div class="headerinf">
			<table style="width: 200%">
				<tr>
					<td><font size=+1><b>Hello: </b><%=first_name%> <%=last_name%></font></td>
					<td><font size=+1><b>Chapter: </b><%=chapter%></font></td>
					<td><font size=+1><b>Difficulty: </b><%=difficulty%></font></td>
				</tr>
				<tr>
			</table>
		</div>
	</div>
	<div>
		<font class="problemdisplay"><%=problem %></font>
	</div>
	<div class="container">
		<div>
			<form method="get" action="lesson">
				<input type="submit" value="Submit" class="submitbutton">
			</form>
		</div>
	</div>
</body>
</html>