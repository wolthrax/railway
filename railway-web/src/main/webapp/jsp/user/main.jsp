<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="/railway/assets/js/jquery.js"></script>
		<script type="text/javascript" src="/railway/assets/js/datatimepicker/jquery.datetimepicker.full.js"></script>
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/jquery.datetimepicker.css" />
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/table.css" />
		<link rel="stylesheet" type="text/css" href="/railway/assets/css/style.css" />
		<title>User Main</title>
	</head>
	<body>
		<div id="mainDiv">
			<div id="username">
				<table align="center">
					<tr valign="middle">
						<td>${user}</td>
						<td valign="middle">
							<form action="controller" method="POST" style="display: inline-block;">
								<input type="hidden" name="command" value="logout"/>
								<input style="width:56px;" type="submit" value="LogOut"/>
							</form><br>
						</td>
						<td>
							<form action="controller" method="POST" style="display: inline-block;">
								<input type="hidden" name="command" value="go_to_update_user"/>
								<input style="width:56px;" type="submit" value="Edit"/>
							</form><br>
						</td>
					</tr>
					<tr>
						<td>${money}</td>
						<td colspan="2">
							<form action="controller" method="POST" style="display: inline-block;">
								<input type="hidden" name="command" value="update_user"/>
								<input type="hidden" name="password1"/>
								<input type="hidden" name="password2"/>
								<input type="hidden" name="name"/>
								<input type="hidden" name="surname"/>
								<input type="hidden" name="email"/>
								<input type="hidden" name="phone"/>
								<input type="text" style="width:56px;" name="money"/>
								<input style="width:56px;" type="submit" value="Add"/>
							</form>
						</td>
					</tr>
				</table>
				<span class="errorMessage">${errors["money"]}</span>
			</div>
			
			<div id="menu">
				
				<form action="controller" method="get">
					<table align="center">
						<tr>
							<td>
								<input type="hidden" name="command" value="show_all_tickets"/>
								<input type="submit" value="Show all tickets"/>
							</td>
						<tr>
					</table>
				</form><br><br>
							
				
				<form action="controller" method="POST">
					<input type="hidden" name="command" value="get_siutable_train">
					<table>
						<tr>
							<td>From:</td>
							<td><input type="text" name="fromTime" class="datetimepicker_mask"></td>
						</tr>
						<tr>
							<td>To:</td>
							<td><input type="text" name="toTime" class="datetimepicker_mask"></td>
						</tr>
						
						<tr>
							<td>Depature station:</td>
							<td>
								<select name="depatureStation">
									<option value="0">!--Station--!</option>
									<c:forEach var = "station" items ="${stationList}" varStatus= "loopIndex">	
										<option value="${station.id}">${station.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>Arrival station:</td>
							<td>
								<select name="arrivalStation">
									<option value="0">!--Station--!</option>
									<c:forEach var = "station" items ="${stationList}" varStatus= "loopIndex">
										<option value="${station.id}">${station.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<input type="submit" value="Show siutable trains">
							</td>
						</tr>
					</table>
				</form>
				<span class="errorMessage">${errors["from_time"]}</span>
				<span class="errorMessage">${errors["to_time"]}</span>
				<span class="errorMessage">${errors["depature_station"]}</span>
				<span class="errorMessage">${errors["arrival_station"]}</span>
			</div>
			<div class="divTable">
				${message}
				
				<table class="bordered">
				    <thead>
					    <tr>
					        <th>Depature time</th>        
					        <th>Arrival time</th>
					        <th>Depature station</th>
					        <th>Arrival station</th>
					        <th>Free places</th>
					        <th>Price</th>
					        <th>Book a ticket</th>
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
					        	<form action="controller" method="POST">
					        		<input type="hidden" name="command" value="book_a_ticket">
					        		<input type="hidden" name="trainId" value="${train.id}">
					        		<input type="hidden" name="trainPlaces" value="${train.places}">
					        		<input type="hidden" name="trainPrice" value="${train.price}">
					        		<input type="hidden" name="trainList" value="${trainList}">
					        		<input type="submit" value="Book a ticket">
					        	</form>
					        </td>
				        </tr>
					</c:forEach>     
			    </table>
		    </div>
		</div>
	</body>
	<script type="text/javascript" src="/railway/assets/js/datatimepicker/pickerinit.js"></script>
</html>