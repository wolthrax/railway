<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/table.css" />
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/style.css" />
		<title>Show passengers</title>
	</head>
	<body>


		<form action="controller" method="get">
			<input type="hidden" name="command" value="go_to_admin_main">
			<input type="submit" value="Back">
		</form>

		<div class="divTable">
			${messageTrain}
			<table class="bordered">
			    <thead>
				    <tr>
				        <th>Id</th>        
				        <th>Login</th>
				        <th>Name</th>
				        <th>Surname</th>
				        <th>Email</th>
				        <th>Phone</th>
				    </tr>
			    </thead>
			    
			    <c:forEach var = "user" items ="${userList}" varStatus= "loopIndex">
			   		<tr>
						<td>${user.id}</td>        
				        <td>${user.login}</td>
				        <td>${user.name}</td>
				        <td>${user.surname}</td>
				        <td>${user.email}</td>
				        <td>${user.phone}</td>
			        </tr>
				</c:forEach>     
		    </table>
		</div>
	</body>
</html>