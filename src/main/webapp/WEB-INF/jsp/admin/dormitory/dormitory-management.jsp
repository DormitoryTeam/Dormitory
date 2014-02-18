<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/admin/dormitory/dormitory-management.js'/>"></script>
<title></title>
</head>
<body>
	<form action="/dormitory/admin/dormitory/dormitory-list.html" method="POST">
		<input type="text" name="cityName" value="${cityName}"/>
		<input type="text" name="dormitoryName" value="${dormitoryName}"/>
		<input type="submit" value="search" />
		<br />
		<input type="radio" name="sortField" value="distance" <c:if test="${sortField eq 'distance' or empty sortField}">checked</c:if> /> Sort By Distance
		<input type="radio" name="sortField" value="salePrice" <c:if test="${sortField eq 'salePrice'}">checked</c:if> /> Sort By Price
		<input type="radio" name="sortField" value="rating" <c:if test="${sortField eq 'rating'}">checked</c:if> /> Sort By Rate
		<input type="radio" name="sortField" value="sales" <c:if test="${sortField eq 'sales'}">checked</c:if> /> Sort By Sales
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
								<li>Price: ${dormitory['salePrice']}</li>
								<li>Rate: ${dormitory['rating']}</li>
								<li>Dist: ${dormitory['distance']}</li>
								<li><input type="button" class="btnEdit" dormitoryId="${dormitory['id']}" value="Edit" /></li>
							</ul>
							<hr /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<jsp:include page="/jsp/utils/pagination.jsp" flush="true" /> 
</body>
</html>