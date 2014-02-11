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
	<table>
		<tbody>
			<tr>
				<td>Country:</td>
			</tr>
			<c:choose>
				<c:when test="${not empty countries}">
					<c:forEach items="${countries}" var="country" varStatus="i">
						<c:if test="i % 5 == 0">
							<tr>
						</c:if>
						<td><a href="javascript:void(0)" class="anchorCountry" countryId="${country['id']}">${country['name']}</a></td>
						<c:if test="i % 5 == 0">
							</tr>
						</c:if>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td>no valid country</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>

	<hr />

	<table id="tableCity">
		<tbody>

		</tbody>
	</table>

	<hr />

	<table id="tableCollege">
		<tbody>

		</tbody>
	</table>
</body>
</html>