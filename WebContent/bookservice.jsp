
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Service</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />

</head>
<body>
	<form action="/PantryCup/spring/doBook" method="post">
	<input type="hidden" name="providerno" id="providerno"/>
		<table align="center">
			<tr align="center">
				<td colspan="2">
					<h1 style="color: blue;">Service Booking</h1>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"><label for="fromdatetime">Select Duration</label></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="text" name="fromdatetimerange" /></td>
			</tr>

			<tr align="center">
				<td colspan="2" style="padding-top: 10px;">
					<button type="submit" class="btn btn-primary">OK</button>
					<button type="button" onclick="location.href = '/PantryCup/serviceprovidersearch.jsp';" class="btn btn-primary">Cancel</button>
				</td>
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
	<script src="https://momentjs.com/downloads/moment.js"></script>

	<!-- Include Date Range Picker -->
	<script type="text/javascript"
		src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
	<script type="text/javascript">

		function getParameterByName(name) 
		{
		    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		    results = regex.exec(location.search);
		    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
		}
		var msg = getParameterByName("providerno");
		if (msg) 
		{
	    	document.getElementById("providerno").value = decodeURIComponent(msg);
		}
		$(function() {
			$('input[name="fromdatetimerange"]').daterangepicker({
				timePicker : true,
				timePickerIncrement : 30,
				locale : {
					format : 'MM/DD/YYYY h:mm A'
				},
				"autoApply": true,
				"linkedCalendars": true,
				"showDropdowns": true,
				"showCustomRangeLabel" : true,
				"opens" : "center",
				"alwaysShowCalendars": true
			});
		});

	</script>


</body>
</html>