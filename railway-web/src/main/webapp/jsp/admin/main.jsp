<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>ADMIN MAIN</h3><br><br>
	
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="logout"/>
		<input type="submit" value="LogOut"/>
	</form>
	
	<h5>${message}</h5>
	
	<h4>Menu</h4>
	<a href="controller?command=go_to_add_station">Add station</a><br>
	<a href="controller?command=go_to_add_train">Add train</a><br>
	<a href="#">Show all train</a><br>
	<a href="#">Find train</a><br>
	
	<h4>${message}</h4>
	
	

</body>
</html>