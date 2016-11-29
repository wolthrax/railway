<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/style.css" />
	</head>
	<body>
		<div id="index">
			<form action="controller" method="POST">
			<input type="hidden" name="command" value="add_station"/>
				<table>
					<tr>
						<td>Station name:</td>
						<td><input type="text" name="station"></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Add station"/></td>
					</tr>
				</table>
			</form>
			<span class="errorMessage">${errors["name"]}</span>
		</div>

	</body>
</html>