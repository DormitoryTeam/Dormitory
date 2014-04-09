<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery-raty/jquery.raty.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDseYSlaYVhokgVdQuPH9Y35gACzO2n3BM&sensor=false"></script>
<script type="text/javascript" src="<c:url value='/js/dormitory/dormitory-detail.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<title></title>
</head>
<body>

	<input type="hidden" id="dormitoryLatitude" value="${dormitory['latitude']}" />
	<input type="hidden" id="dormitoryLongitude" value="${dormitory['longitude']}" />

	
		<input type="hidden" name="dormitoryId" value="${dormitory['id']}" />
		<c:set var="dormitoryId" value="${dormitory['id']}" />

		<ul>
			<li>${dormitory['name']}</li>
			<li>${dormitory['address']}</li>
			<li>
				Service: 
				<c:forEach var="binaryService" items="${dormitory['binaryServiceArray']}" varStatus="i">
 					<c:if test="${binaryService eq '1'.charAt(0)}">
 						<c:if test="${hasOneService > 0}">, </c:if>
 						<c:set var="hasOneService" value="1" />
 						${services[i['index']]}
 					</c:if>
				</c:forEach>
			</li>
			<li>
				Equipment: 
				<c:forEach var="binaryEquipment" items="${dormitory['binaryEquipmentArray']}" varStatus="i">
 					<c:if test="${binaryEquipment eq '1'.charAt(0)}">
 						<c:if test="${hasOneEquipment eq 1}">, </c:if>
 						<c:set var="hasOneEquipment" value="1" />
 						${equipments[i['index']]}
 					</c:if>
				</c:forEach>
			</li>
			<li>Rate: <div style="display:inline;" id="dormitoryRate" data-score="${dormitory['rating']}"></div></li>
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
				<%--
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
				--%>
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
							<input type="submit" class="btnBookDormitory" roomId="${room['id']}" value="Book it!" />
						</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	
	
	<hr />


	<ol>
		<c:forEach var="dormitory" items="${history}">
			<li>${dormitory['name']} + ${dormitory['dormitoryId']}</li>
		</c:forEach>
	</ol>
	
	<hr />
	<ol>
		<c:forEach var="rate" items="${rates}">
			<c:if test="${rate['status'] > 0}">
				<li>${rate}</li>
			</c:if>
		</c:forEach>
	</ol>
	<form action="/dormitory/dormitory/rate.html" method="POST">
		<input type="hidden" name="dormitoryId" value="${dormitory['id']}" />
		<input type="hidden" name="id" value="${curRate['id']}" />
		<table>
			<tbody>
				<tr>
					<td>Alias:</td>
					<td colspan="2"><input type="text" name="alias" value="${empty curRate['alias'] ? userName : curRate['alias']}" /></td>
				</tr>
				<tr>
					<td>Comment:</td>
					<td colspan="2"><textarea rows="5" cols="40" name="comment">${curRate['comment']}</textarea></td>
				</tr>
				<tr>
					<td>Rate:</td>
					<td><div id="rate" data-score="${curRate['point']}"></div></td>
					<td><input type="submit" ${empty sessionScope['USER_ID'] ? 'disabled value="cannot submit before login"' : 'value="submit"'} /></td>
				</tr>
			</tbody>
		</table>
	</form>
	<hr />
	<form id="placeOrderForm" action="<c:url value="/order/dormitory-place-order.html"/>" method="GET">
		<input type="hidden" name="dormitoryId" value="${dormitory['id']}" />
		<input type="hidden" id="contractId" name="contractId" /> 
		<input type="hidden" id="roomInfoId" name="roomInfoId" />
	</form>
	<div id="chooseContract">
	
	</div>
	<div id="map_canvas" style="width:500px; height:500px"></div>
	<script>
	var room_contracts = {};
	<c:forEach var="room" items="${dormitory['rooms']}">
		var contracts = [];
		<c:forEach var="contractPrice" items="${room['contractPrice']}">
			var contract = {"id": ${contractPrice['contractId']}, "name": "${contractPrice['contract']}", "salePrice": ${contractPrice['salePrice']}, "currency": "${contractPrice['currency']}"};
			contracts.push(contract);
		</c:forEach>
		room_contracts["${room['id']}"] = contracts;
	</c:forEach>
	</script>
</body>
</html>