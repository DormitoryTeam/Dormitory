<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/admin/dormitory/dormitory-management.js'/>"></script>
<title></title>
</head>
<body>
	<input type="button" id="btnAdd" value="Create Dormitory">
	<hr />

	<table style="width:1100px;">
		<tbody>
			<c:if test="${not empty dormitories}">
				<c:forEach var="dormitory" items="${dormitories}" varStatus="i">
					<tr>
						<td><img style="float: left;margin-right:30px;" src="<c:url value='/dormitory/img/dormitory_sample.jpg'/>" />
							<ul>
								<li>Name: ${dormitory['name']} ${dormitory['status']} &nbsp; 
									<input type="button" class="btnEdit" dormitoryId="${dormitory['id']}" value="Edit" /></li>
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
								<li>Rating: ${dormitory['rating']}</li>
								<li>Room Count: ${fn:length(dormitory['rooms'])}</li>
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