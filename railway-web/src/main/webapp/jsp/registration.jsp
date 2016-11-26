<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="registration"/>
		Login:<input type="text" name="login"/>${errors["login"]}<br>
		Password:<input type="text" name="password"/>${errors["password"]}<br>
		Name:<input type="text" name="name"/>${errors["name"]}<br>
		Surname:<input type="text" name="surname"/>${errors["surname"]}<br>
		Email:<input type="text" name="email"/>${errors["email"]}<br>
		Phone:<input type="text" name="phone"/>${errors["phone"]}<br>
		<input type="submit" value="Registration"/>
	</form>
	
	<h4>${message}</h4>

</body>
</html>