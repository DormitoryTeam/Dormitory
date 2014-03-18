<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<title></title>
</head>
<body>
	<form action="/dormitory/order/dormitory-order-fill.html" method="POST">
		<input type="hidden" name="dormitoryId" value="${dormitory['id']}" />
		<c:set var="dormitoryId" value="${dormitory['id']}"/>
		<ul>
			<li>Name:${dormitory['name']}</li>
			<li>Address:${dormitory['address']}:</li>
			<li>ZIP Code:${dormitory['postCode']}</li>
			<li>Dormitory Type:${dormitory['dormitoryType']}</li>
			<li>Contract Type:${dormitory['contract']}</li>
			<li>List Price:${dormitory['listPrice']}</li>
			<li>Sale Price:${dormitory['salePrice']}</li>
			<li>Service:${dormitory['service']}</li>
			<li>Equipment:${dormitory['equipment']}</li>
			<li>Description:${dormitory['description']}</li>
			<li>Images:
			<c:forEach items="${dormitory['picPath']}" var="imgPath">
				<img hight="200px" width="200px" src="<c:url value='/upload/images/dormitory/${dormitoryId}/${imgPath}'/>">
			</c:forEach>
			</li>
			<li>Videos:${dormitory['videoPath']}</li>
			<li>Rating:${dormitory['rating']}</li>
			<li><input type="submit" id="btnBookDormitory" value="Book it!" /></li>
		</ul>
	</form>
</body>
</html>