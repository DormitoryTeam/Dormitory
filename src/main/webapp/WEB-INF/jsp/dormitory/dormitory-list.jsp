<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/navigation/navigation.js'/>"></script>
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

	<table>
		<tbody>
			<c:if test="${not empty dormitories}">
				<c:forEach var="dormitory" items="${dormitories}" varStatus="i">
					<tr>
						<td><img style="float: left;margin-right: 30px;margin-top: 10px;" src="/dormitory/img/dormitory_sample.jpg" />
							<ul>
								<li>Name: ${dormitory['name']}</li>
								<li>Addr: ${dormitory['address']}</li>
								<li>Equip: ${dormitory['equipment']}</li>
								<li>Serv: ${dormitory['service']}</li>
								<li>Price: ${dormitory['salePrice']}</li>
								<li>Rate: ${dormitory['rating']}</li>
								<li>Dist: ${dormitory['distance']}</li>
								<li style="display: none;"><hr /></li>
							</ul></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>