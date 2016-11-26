<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin Main</title>
		<script type="text/javascript" src="/railway/assets/js/jquery.js"></script>
		<script type="text/javascript" src="/railway/assets/js/datatimepicker/jquery.datetimepicker.full.js"></script>
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/jquery.datetimepicker.css" />
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/table.css" />
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/style.css" />
	</head>
	<body>
	
		<h3 style="display: inline-block;">ADMIN</h3>
		
		<form action="controller" method="POST" style="display: inline-block;">
			<input type="hidden" name="command" value="logout"/>
			<input type="submit" value="LogOut"/>
		</form>
		
		<h5>${message}</h5>
		
		<h4>Menu</h4>
		<a href="controller?command=go_to_add_station">Add station</a><br>
		<a href="controller?command=go_to_add_train">Add train</a><br>
		
		<h3>Find train</h3>
		
		<form action="controller" method="POST" style="display: inline-block;">
			<input type="hidden" name="command" value="find_train">
			Depature time:<input type="text" name="depatureTime" class="datetimepicker_mask">${errors["depature_time"]}<br>
			Depature station:<select name="depatureStation">
		
					<option value="0">!--Station--!</option>
				<c:forEach var = "station" items ="${stationList}" varStatus= "loopIndex">	
					<option value="${station.id}">${station.name}</option>
				</c:forEach>
			
			</select>${errors["depature_station"]}<br>
			Arrival station:<select name="arrivalStation">
		
					<option value="0">!--Station--!</option>
				<c:forEach var = "station" items ="${stationList}" varStatus= "loopIndex">
					<option value="${station.id}">${station.name}</option>
				</c:forEach>
			
			</select>${errors["arrival_station"]}<br>
			<input type="submit" value="get">
		</form>
		
		<div class="divTable">
			${messageTrain}
			<table class="bordered">
			    <thead>
				    <tr>
				        <th>Depature time</th>        
				        <th>Arrival time</th>
				        <th>Depature station</th>
				        <th>Arrival station</th>
				        <th>Free places</th>
				        <th>Price</th>
				        <th>Show passengers</th>
				    </tr>
			    </thead>
			    
			    <c:forEach var = "train" items ="${trainList}" varStatus= "loopIndex">
			   		<tr>
						<td>${train.schedule.depatureTime}</td>        
				        <td>${train.schedule.arrivalTime}</td>
				        <td>${train.schedule.depatureStation}</td>
				        <td>${train.schedule.arrivalStation}</td>
				        <td>${train.places}</td>
				        <td>${train.price}</td>
				        <td>
				        	<form action="controller" method="get">
				        		<input type="hidden" name="command" value="show_passengers">
				        		<input type="hidden" name="trainId" value="${train.id}">
				        		<input type="submit" value="Show passengers">
				        	</form>
				        </td>
			        </tr>
				</c:forEach>     
		    </table>
	    </div>
	</body>
	<script type="text/javascript" src="/railway/assets/js/datatimepicker/pickerinit.js"></script>
</html>