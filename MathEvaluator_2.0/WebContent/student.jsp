<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String first_name = (String) session.getAttribute("first_name");
%>
<%
	String last_name = (String) session.getAttribute("last_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student page</title>
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
			<a href="logout.jsp">logout?</a>
		</div>
	</div>
	<br />
	<br />
	<br />
	<div>
		<h1>Student page</h1>
		<h2>Welcome to the student page</h2>
	</div>
	<br />
	<div>
		<p align="justify">
			<font size=+1>Hello <b><%=first_name%> <%=last_name%></b>,
				it's nice to see you're here. For now, you can do two things in our
				system:
			</font>
		</p>
		<br />
		<ul>
			<li><font size=+1>Take <b>automated </b><a
					href="lesson.jsp">tests</a>.
			</font></li>
		</ul>

		<ul>
			<li><font size=+1>Check your <a href="lesson.jsp">grades</a>.
			</font></li>
		</ul>
	</div>
	<br />
	<div>
		<p align="justify">
			<font size=+1>The automated test taking portion of this
				software, will allow you to increase level of difficulty, when you
				have reached 10 correct answer in a row. If you are unable to do so,
				you will finish the test and if you obtain an average of 75 or
				above, you will move to the next lesson.</font>
		</p>
	</div>
	<div>
		<p align="justify">
			<font size=+1>You report card will illustrate your grades, and the streaks for each section. </font>
		</p>
	</div>
</body>
</html>
