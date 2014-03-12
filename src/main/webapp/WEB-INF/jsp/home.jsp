<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.slides.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/home.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/style/slides.css' />" />
<title></title>
</head>
<body>
	<form action="/dormitory/dormitory/dormitory-list.html" method="GET">
		<table>
			<tr>
				<td>Country:</td>
				<td><select id="sltCountry" name="countryId">
						<c:choose>
							<c:when test="${not empty countries}">
								<c:forEach items="${countries}" var="country">
									<option value="${country['id']}">${country['name']}</option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<option value="0">no valid result</option>
							</c:otherwise>
						</c:choose>
				</select></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><select id="sltCity" name="cityId">
						<c:choose>
							<c:when test="${not empty cities}">
								<c:forEach items="${cities}" var="city">
									<option value="${city['id']}">${city['name']}</option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<option value="0">no valid result</option>
							</c:otherwise>
						</c:choose>
				</select></td>
			</tr>
			<tr>
				<td>College:</td>
				<td><select id="sltCollege" name="collegeId">
						<c:choose>
							<c:when test="${not empty colleges}">
								<c:forEach items="${colleges}" var="college">
									<option value="${college['id']}">${college['name']}</option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<option value="0">no valid result</option>
							</c:otherwise>
						</c:choose>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="search" /></td>
			</tr>
		</table>
	</form>

	<hr />

	<div class="container">
		<div id="slides">
			<c:forEach var="slide" items="${slides}" varStatus="index">
				<img src="/dormitory/admin/slide-image-preview.html?fileName=${slide['path']}" />
			</c:forEach>
		</div>
	</div>
</body>
</html>