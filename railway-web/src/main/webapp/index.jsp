<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/railway/assets/js/validator.js"></script>
<title>Index</title>
</head>
<body>
	<form action="controller" method="POST" name="form" onsubmit="return validate()">
		<input type="hidden" name="command" value="login"/>
		Login: <input type="text" name="login"> <span style='color:red' id="login"></span><br />
		Password: <input type="text" name="password"> <span style='color:red' id="password"></span><br />
		<input type="submit" value="LogIn"/>
	</form>
	
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="go_to_registration"/>
		<input type="submit" value="Registration"/>
	</form>
	
	<h4>${message}</h4>

</body>
</html>