<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addUser" method="post">
	<table>
		<tr>
			<td>Name</td><td><input type="text" name="userName" id="userName"/>
		</tr>
		<tr>
			<td>password</td><td><input type="password" name="password" id="password"/>
		</tr>
		<tr>
			<td>Address</td><td><textarea rows="5" cols="5" name="address" id="address"></textarea></td>
		</tr>
		<tr>
			<td></td><td><input type="submit" value="Go"/></td>
		</tr>
	</table>
</form>
${msg }
<a href="home">click here for login page</a>
</body>
</html>