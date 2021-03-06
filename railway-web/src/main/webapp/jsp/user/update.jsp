<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registration</title>
	<link rel="stylesheet" type="text/css" href="/railway/assets/css/style.css" />
	</head>
	<body>
		<div id="index">
			<form action="controller" method="POST">
					<input type="hidden" name="command" value="update_user"/>
					
					<table align="center">
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password1"/></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password2"/></td>
						</tr>
						<tr>
							<td>Name:</td>
							<td><input type="text" name="name"/></td>
						</tr>
						<tr>
							<td>Surname:</td>
							<td><input type="text" name="surname"/></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input type="text" name="email"/></td>
						</tr>
						<tr>
							<td>Phone:</td>
							<td><input type="text" name="phone"/></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input class="submitLarge" type="submit" value="Update profile"/></td>
						</tr>
					</table>
			</form>
			<span class="errorMessage">${errors["password"]}</span>
			<span class="errorMessage">${errors["name"]}</span>
			<span class="errorMessage">${errors["surname"]}</span>
			<span class="errorMessage">${errors["email"]}</span>
			<span class="errorMessage">${errors["phone"]}</span>
			<span>${message}</span>
		</div>>
	</body>
</html>