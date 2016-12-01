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
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/style.css" />
	</head>
	<body>
		<div id="index">
			<form action="controller" method="POST">
				<input type="hidden" name="command" value="add_train">
				
				<table align="center">
					<tr>
						<td>Places:</td>
						<td><input type="text" name="places"></td>
					</tr>
					<tr>
					
						<td>Price:</td>
						<td><input type="text" name="price"></td>
					</tr>
					<tr>
						<td>Depature time:</td>
						<td><input type="text" name="depatureTime" class="datetimepicker_mask"></td>
					</tr>
					<tr>
						<td>Arrival time:</td>
						<td><input type="text" name="arrivalTime" class="datetimepicker_mask"></td>
					</tr>
					<tr>
						<td>Depature station:</td>
						<td>
							<select name="depatureStation">
								<option value="">!--Station--!</option>
								<c:forEach var = "station" items ="${stationList}" varStatus= "loopIndex">	
									<option value="${station.id}">${station.name}</option>
								</c:forEach>
							</select><br>
						</td>
					</tr>
					<tr>
						<td>Arrival station:</td>
						<td>
							<select name="arrivalStation">
								<option value="">!--Station--!</option>
								<c:forEach var = "station" items ="${stationList}" varStatus= "loopIndex">
									<option value="${station.id}">${station.name}</option>
								</c:forEach>
							</select><br>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Add train"></td>
					</tr>
				</table>
			</form>
			
			<span class="errorMessage">${errors["places"]}</span>
			<span class="errorMessage">${errors["price"]}</span>
			<span class="errorMessage">${errors["depature_time"]}</span>
			<span class="errorMessage">${errors["arrival_time"]}</span>
			<span class="errorMessage">${errors["depature_station"]}</span>
			<span class="errorMessage">${errors["arrival_station"]}</span>
			<span class="errorMessage">${errors["station_repeated"]}</span>
		</div>
	</body>
	
	<script type="text/javascript" src="/railway/assets/js/datatimepicker/pickerinit.js"></script>
</html>