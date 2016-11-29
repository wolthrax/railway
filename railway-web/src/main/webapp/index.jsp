<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="/railway/assets/js/validator.js"></script>
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/style.css" />
		<title>Index</title>
	</head>
	<body>

		<div id="index">
		
			<form action="controller" method="POST" name="form" onsubmit="return validate()">
				<input type="hidden" name="command" value="login"/>
				<table>
					<tr>
						<td valign="top">Login:</td>
						<td><input type="text" name="login"></td>
					</tr>
					
					<tr>
						<td valign="top">Password:</td>
						<td><input type="text" name="password"></td>
					</tr>
				
					<tr>
						<td><input type="submit" value="LogIn"/></td>
					</tr>
				</table>
						
			</form>
				<form action="controller" method="POST">
					<table>
						<tr>
							<td>
								<input type="hidden" name="command" value="go_to_registration"/>		
								<input type="submit" value="Registration"/>
							</td>
						<tr>
					</table>
				</form>
			<span class="errorMessage" id="login"></span>
			<span class="errorMessage" id="password"></span>
			<span class="errorMessage">${message}</span>
		</div>

	</body>
</html>