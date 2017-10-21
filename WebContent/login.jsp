<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PantryCup Login</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>

<body>
<div style="padding-top:50px">
	<form action="/PantryCup/spring/doLogin" method="post">
		<table align="center">
			<tr align="center">
				<td colspan="2">
					<h1 style="color:blue; font-weight=bold">Login with your credentials</h1>
					${errors}
				</td>
			</tr>
			<tr>
				<td><label for="usernametext">Username</label></td>
				<td><input type="text" name="username" class="form-control" id="usernametext"
					placeholder="Enter username" required/></td>
			</tr>
			<tr>
				<td><label for="passwordtext">Password</label></td>
				<td><input type="password" name="password" class="form-control" id="passwordtext"
					placeholder="Enter password" required/></td>
			</tr>
			<tr align="center">
				<td colspan="2" style="padding-top: 10px;"><button type="submit" class="btn btn-primary">Login</button></td>
			</tr>
			<tr align="center">
				<td colspan="2"><a href="registeruser.jsp" target=_self>Sign Up</a></td>
			</tr>
		</table>
	</form>
</div>



















	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>
</html>