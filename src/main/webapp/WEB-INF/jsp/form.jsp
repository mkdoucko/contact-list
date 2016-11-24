<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="javax.servlet.*,javax.servlet.http.* "%>

<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" />
</head>
<body style="color: white; background-color: blue">
	<p style="font-size: 120%">
		<b> Contact Form </b>
	</p>


	<form method='get' action="saveContact">
		<table style="font-size: 120%;">
			<tr>
				<td>First name:</td>
				<td style="padding-left: 30px"><input type='text'
					name='firstName'> <br /></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td style="padding-left: 30px"><input type='text'
					name='lastName'> <br /></td>
			</tr>
			<tr>
				<td>e-mail:</td>
				<td style="padding-left: 30px"><input type='text' name='email'>
					<br /></td>
			</tr>
			<tr>
				<td>phone number:</td>
				<td style="padding-left: 30px"><input type='text'
					name='phoneNumber'> <br /></td>
			</tr>
		</table>
		<br /> <input type='submit'  style="background-color: yellow"
			value="Insert contact" name="opt">
			<br /> <br />
			<input type='submit' style="background-color: white"
			value="Select contact" name="opt">
			<br />
	</form>
	<br />
	<form action="/warn" method="get">
		<input type='submit' type='submit' style="background-color: red"
			value="Delete all contacts" name="w" id="w" />
	</form>
	<br />
	<form action="/all" method="get">
		<input type='submit' style="background-color: white"
			value="Show all contacts" name="all" id="all" />
	</form>
</body>
</html>