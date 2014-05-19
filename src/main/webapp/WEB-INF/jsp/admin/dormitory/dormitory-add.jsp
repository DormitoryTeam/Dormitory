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

	<form action="<c:url value='/admin/dormitory/dormitory-save.html'/>" method="POST">
		<table>
			<tbody>
				<tr>
					<td>Name*:</td>
					<td><input type="text" name="name" value="" /></td>

				</tr>
				<tr>
					<td>Country:</td>
					<td><select id="sltCountry" name="countryId">
							<c:forEach items="${countries}" var="country">
								<option value="${country['id']}">${country['name']}</option>
							</c:forEach>
					</select></td>
					<td>City*:</td>
					<td><select id="sltCity" name="cityId">
							<c:forEach var="city" items="${cities}">
								<option value="${city['id']}">${city['name']}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Name*:</td>
					<td><input type="text" name="name" value="" /></td>

				</tr>
				<tr>
					<td>Country:</td>
					<td><select id="sltCountry" name="countryId">
							<c:forEach items="${countries}" var="country">
								<option value="${country['id']}">${country['name']}</option>
							</c:forEach>
					</select></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>College*:</td>
					<td><select id="sltCollege" name="collegeId">
							<c:forEach var="college" items="${colleges}">
								<option value="${college['id']}">${college['name']}</option>
							</c:forEach>
					</select></td>
					<td>Post Code:</td>
					<td><input type="text" name="postCode" value="" /></td>
				</tr>
				<tr>
					<td>Contract:</td>
					<td><select name="contractId">
							<c:forEach var="contractType" items="${contractTypes}">
								<option value="${contractType['id']}">${contractType['name']}</option>
							</c:forEach>
					</select></td>
					<td>Dormitory Type:</td>
					<td><select name="dormitoryTypeId">
							<c:forEach var="dormitoryType" items="${dormitoryTypes}">
								<option value="${dormitoryType['id']}">${dormitoryType['name']}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Latitude:</td>
					<td><input type="text" name="latitude" value="" /></td>
					<td>Longitude:</td>
					<td><input type="text" name="longitude" value="" /></td>
				</tr>
				<tr>
					<td>Address*:</td>
					<td><input type="text" name="address" value="" style="width: 300px;" /></td>
					<td>Currency:</td>
					<td><input type="text" name="currency" value="" /></td>
				</tr>
				<tr>
					<td>List Price:</td>
					<td><input type="text" name="listPrice" value="" /></td>
					<td>Sale Price:</td>
					<td><input type="text" name="salePrice" value="" /></td>
				</tr>
				<tr>
					<td>Service:</td>
					<td><input type="text" name="service" value="" /></td>
					<td>Equipment:</td>
					<td><input type="text" name="equipment" value="" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td colspan="3"><textarea name="description" cols="80" rows="5"></textarea></td>
				</tr>
				<tr>
					<td>Dormitory Image Path:</td>
					<td><input type="text" name="picPath" value="" /></td>
					<td><input type="text" name="picPath" value="" /></td>
					<td><input type="text" name="picPath" value="" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="save" /></td>
					<td><a href="${backURL}">Back to list</a></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>