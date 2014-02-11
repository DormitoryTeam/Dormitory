<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/home.js'/>"></script>
<title></title>
</head>
<body>
	<form>
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
</body>
</html>