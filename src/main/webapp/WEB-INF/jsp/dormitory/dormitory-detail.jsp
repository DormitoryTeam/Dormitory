<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<title></title>
</head>
<body>
	<form action="/dormitory/order/dormitory-order-fill.html" method="POST">
		<input type="hidden" name="dormitoryId" value="${dormitory['id']}" />
		<c:set var="dormitoryId" value="${dormitory['id']}" />

		<ul>
			<li>${dormitory['name']}</li>
			<li>${dormitory['address']}</li>
			<li>Service: ${dormitory['binaryService']}</li>
			<li>Equipment: ${dormitory['binaryEquipment']}</li>
			<li>Rate:</li>
		</ul>

		<table class="table" style="width:1100px;">
			<tbody>
				<tr>
					<th></th>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<th>
							${room['roomType']}
							<c:forEach var="contractPrice" items="${room['contractPrice']}">
								<br />${contractPrice['contract']}: ${contractPrice['currency']} ${contractPrice['salePrice']}
							</c:forEach>
						</th>
					</c:forEach>
				</tr>
				<tr>
					<td>Check-in Date</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['checkinDateString']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Room Area</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['houseArea']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Bed Type</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['bedType']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Ensuite Bathroom</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['ensuitBathroom']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Shared Kitchen People Number</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['kitchenPeople']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Floors</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['floors']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Can Arrange Floor</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['floorArrange']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Can Arrange Orientation</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['orientationArrange']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Can Arrange Room Language</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['roomLanguageArrange']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Kitchen Equipment</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['kitchenEquipment']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td>Bathroom Equipment</td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							${room['bathroomEquipment']}
						</td>
					</c:forEach>
				</tr>
				<tr>
					<td></td>
					<c:forEach var="room" items="${dormitory['rooms']}">
						<td>
							<input type="submit" id="btnBookDormitory" roomId="${room['id']}" value="Book it!" />
						</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>