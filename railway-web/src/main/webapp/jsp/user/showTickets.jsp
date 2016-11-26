<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/table.css" />
		<title>Show tickets</title>
	</head>
	<body>
		<form action="controller" method="get">
			<input type="hidden" name="command" value="go_to_user_main">
			<input type="submit" value="Back">
		</form>

		<div class="divTable">
			${message}
			<table class="bordered">
			    <thead>
				    <tr>
				    	<th>Id</th>    
				        <th>Depature time</th>
				        <th>Arrival time</th>
				        <th>Depature station</th>
				        <th>Arrival station</th>
				        <th>Place</th>
				        <th>Price</th>
				    </tr>
			    </thead>
			    
			    <c:forEach var = "train" items ="${trainList}" varStatus= "loopIndex">
			   		<tr>
			   			<td>${train.id}</td> 
						<td>${train.schedule.depatureTime}</td>        
				        <td>${train.schedule.arrivalTime}</td>
				        <td>${train.schedule.depatureStation}</td>
				        <td>${train.schedule.arrivalStation}</td>
				        <td>${train.places}</td>
				        <td>${train.price}</td>
			        </tr>
				</c:forEach>     
		    </table>
		</div>
	</body>
</html>