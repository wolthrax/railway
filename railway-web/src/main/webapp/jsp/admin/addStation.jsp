<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/style.css" />
	</head>
	<body>
		<div id="index">
			<form action="controller" method="POST">
			<input type="hidden" name="command" value="add_station"/>
				<table align="center">
					<tr>
						<td>Station name:</td>
						<td><input type="text" name="station"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Add station"/></td>
					</tr>
				</table>
			</form>
			<span class="errorMessage">${errors["name"]}</span>
			<span class="errorMessage">${message}</span>
		</div>

	</body>
</html>