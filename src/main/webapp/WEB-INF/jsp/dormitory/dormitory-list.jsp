<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/dormitory/dormitory-list.js' />"></script>
<title></title>
</head>
<body>
	<h3>${country['name']}&nbsp;&gt;&nbsp;${city['name']}&nbsp;&gt;&nbsp;${college['name']}</h3>
	<br />

	<form action="/dormitory/dormitory/dormitory-list.html?collegeId=${college['id']}&cityId=${city['id']}" method="POST">
		<input type="radio" name="sortField" value="distance" <c:if test="${sortField eq 'distance' or empty sortField}">checked</c:if> /> Sort By Distance
		<input type="radio" name="sortField" value="salePrice" <c:if test="${sortField eq 'salePrice'}">checked</c:if> /> Sort By Price
		<input type="radio" name="sortField" value="rating" <c:if test="${sortField eq 'rating'}">checked</c:if> /> Sort By Rate
		<input type="radio" name="sortField" value="sales" <c:if test="${sortField eq 'sales'}">checked</c:if> /> Sort By Sales
		<input type="text" name="keyword" value="${keyword}"/>
		<input type="submit" value="search" />
	</form>
	<hr />

	<table style="width:1100px;">
		<tbody>
			<c:if test="${not empty dormitories}">
				<c:forEach var="dormitory" items="${dormitories}" varStatus="i">
					<tr>
						<td><img style="float: left;margin-right:30px;" src="/dormitory/img/dormitory_sample.jpg" />
							<ul>
								<li>Name: ${dormitory['name']} ${dormitory['status']} &nbsp; 
									<input type="button" class="btnDetail" dormitoryId="${dormitory['id']}" value="to detail" /></li>
								<li>Addr: ${dormitory['address']}</li>
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
								<li>Price: ${dormitory['salePrice']}</li>
								<li>
									<table>
										<tbody>
											<tr>
												<th>Room</th>
												<th>Bed Type</th>
												<th>Checkin Date</th>
												<th>Sale Price</th>
												<th>Status</th>
											</tr>
											<c:if test="${not empty dormitory['rooms']}">
												<c:forEach var="room" items="${dormitory['rooms']}" varStatus="j" begin="0" end="1">
													<c:if test="${not empty room}">
														<tr>
															<td>${room['roomType']}</td>
															<td>${room['bedType']}</td>
															<td>${room['checkinDateString']}</td>
															<td>
																<c:if test="${not empty room['contractPrice'][0]}">
																	${room['contractPrice'][0]['salePrice']}
																</c:if>
															</td>
															<td>${room['status']}</td>
														</tr>
													</c:if>
												</c:forEach>
											</c:if>
										</tbody>
									</table>
							</ul>
							<hr /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/> 
</body>
</html>