<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
	<form action="doSignup" method="post">
		<table align="center">
			<tr align="center">
				<td colspan="2">
					<h1 style="color: blue;">Sign Up</h1>
				</td>
			</tr>
			<tr>
				<td><label></label></td>
				<td>
					<div class="form-check">
						<label class="form-check-label"> <input name="isserviceprovidercheckbox"
							class="form-check-input" type="checkbox" value="checked"> I am a
							Service Provider
						</label>
					</div>
				</td>
			</tr>
			<tr>
				<td><label for="fullnametext">Name</label></td>
				<td><input type="text" name="fullname" class="form-control"
					id="fullnametext" placeholder="Enter fullname" /></td>
			</tr>
			<tr>
				<td><label for="usernametext">Username</label></td>
				<td><input type="text" name="username" class="form-control"
					id="usernametext" placeholder="Enter username" /></td>
			</tr>
			<tr>
				<td><label for="passwordtext">Password</label></td>
				<td><input type="password" name="password" class="form-control"
					id="passwordtext" placeholder="Enter password" /></td>
			</tr>
			<tr>
				<td><label for="emailtext">Email</label></td>
				<td><input type="email" name="email" class="form-control"
					id="emailtext" placeholder="Enter email" /></td>
			</tr>
			<tr>
				<td><label for="locationtext">Location</label></td>
				<td><input type="text" name="location" class="form-control"
					id="locationtext" placeholder="Enter location" /></td>
			</tr>
			<tr>
				<td><label for="contacttext">ContactNo</label></td>
				<td><input type="text" name="contactNo" class="form-control"
					id="contacttext" placeholder="Enter contact No." /></td>
			</tr>

			<tr>
				<td><label name="specializationlabel" for="specializationtext">Specialization</label></td>
				<td><input type="text" name="specialization"
					class="form-control" id="specializationtext"
					placeholder="Enter specialization" /></td>
			</tr>
			<tr>
				<td><label name="costbasislabel" for="costbasisselect">Charge Basis</label></td>
				<td><select class="form-control" id="costbasisselect">
						<option>Per Day basis</option>
						<option>Per Hour basis</option>
						<option>Half day basis</option>
				</select></td>
			</tr>
			<tr>
				<td><label name="costlabel" for="costtext">Cost</label></td>
				<td><input type="text" name="cost" class="form-control"
					id="costtext"
					placeholder="Enter charges based on your charge basis" /></td>
			</tr>
			<tr align="center">
				<td colspan="2" style="padding-top: 10px;"><button
						type="submit" class="btn btn-primary">OK</button></td>
			</tr>
		</table>
	</form>










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
		
	<script type="text/javascript">
	$('input[name="specialization"]').hide();
    $('label[name="specializationlabel"]').hide();
	$('select[id="costbasisselect"]').hide();
    $('label[name="costbasislabel"]').hide();
    $('input[name="cost"]').hide();
    $('label[name="costlabel"]').hide();
		//show it when the checkbox is clicked
		$('input[name="isserviceprovidercheckbox"]').on('click', function() {
		
		if ( $(this).prop('checked') ) {
			$('input[name="specialization"]').show();
		    $('label[name="specializationlabel"]').show();
			$('select[id="costbasisselect"]').show();
		    $('label[name="costbasislabel"]').show();
		    $('input[name="cost"]').show();
		    $('label[name="costlabel"]').show();
		} 
		else {
			$('input[name="specialization"]').hide();
		    $('label[name="specializationlabel"]').hide();
			$('select[id="costbasisselect"]').hide();
		    $('label[name="costbasislabel"]').hide();
		    $('input[name="cost"]').hide();
		    $('label[name="costlabel"]').hide();

		}
		});
	</script>
</body>
</html>