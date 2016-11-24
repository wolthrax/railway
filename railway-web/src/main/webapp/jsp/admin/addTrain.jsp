<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add train</title>
	<script type="text/javascript" src="/railway/assets/js/jquery.js"></script>
	<script type="text/javascript" src="/railway/assets/js/datatimepicker/jquery.datetimepicker.full.js"></script>
	<link rel="stylesheet" type="text/css" href="/railway/assets/css/jquery.datetimepicker.css" />
	</head>
	<body>

		<form action="controller" method="POST">
			<input type="hidden" name="command" value="add_train">
			Places:<input type="text" name="places">${errors["places"]}<br>
			Price:<input type="text" name="price">${errors["price"]}<br>
			Depature time:<input type="text" name="depatureTime" class="datetimepicker_mask">${errors["depature_time"]}<br>
			Arrival time:<input type="text" name="arrivalTime" class="datetimepicker_mask">${errors["arrival_time"]}<br>
			Depature station:<select name="depatureStation">
			
					<option value="">!--Station--!</option>
				<c:forEach var = "station" items ="${stationList}" varStatus= "loopIndex">	
					<option value="${station.id}">${station.name}</option>
				</c:forEach>
				
			</select>${errors["depature_station"]}<br>
			Arrival station:<select name="arrivalStation">
			
					<option value="">!--Station--!</option>
				<c:forEach var = "station" items ="${stationList}" varStatus= "loopIndex">
					<option value="${station.id}">${station.name}</option>
				</c:forEach>
				
			</select>${errors["arrival_station"]}<br>
			<input type="submit" value="Add train">
		</form>
	</body>
	
	<script type="text/javascript" src="/railway/assets/js/datatimepicker/pickerinit.js"></script>
</html>