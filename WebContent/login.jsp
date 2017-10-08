<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="doLogin">
		<table align="center">
			<tr align="center">
				<td colspan="2">
					<h1>Login with your credentials</h1>
				</td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"
					placeholder="Enter username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					placeholder="Enter password" /></td>
			</tr>
			<tr align="center">
				<td colspan="2" style="padding-top: 10px;"><input type="submit" value="Login" /></td>
			</tr>
			<tr align="center">
				<td colspan="2"><a href="#" target=_blank>Register new user</a></td>
			</tr>
		</table>



	</form>


</body>
</html>