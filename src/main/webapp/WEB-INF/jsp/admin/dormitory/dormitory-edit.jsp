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

	<form action="/dormitory/admin/dormitory/dormitory-update.html" method="POST">
		<table>
			<tbody>
				<tr>
					<td>DormitoryId:<input type="hidden" name="id" value="${dormitory['id']}" /></td>
					<td>${dormitory['id']}</td>
				</tr>
				<tr>
					<td>Name*:</td>
					<td><input type="text" name="name" value="${dormitory['name']}" /></td>
					<td>Post Code:</td>
					<td><input type="text" name="postCode" value="${dormitory['postCode']}" /></td>
				</tr>
				<tr>
					<td>City*:</td>
					<td><select name="cityId">
							<c:forEach var="city" items="${cities}">
								<option value="${city['id']}" <c:if test="${city['id'] eq dormitory['cityId']}">selected="selected"</c:if>>${city['name']}</option>
							</c:forEach>
					</select></td>
					<td>College*:</td>
					<td><select name="collegeId">
							<c:forEach var="college" items="${colleges}">
								<option value="${college['id']}" <c:if test="${college['id'] eq dormitory['collegeId']}">selected="selected"</c:if>>${college['name']}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Contract:</td>
					<td><select name="contractId">
							<c:forEach var="contractType" items="${contractTypes}">
								<option value="${contractType['id']}" <c:if test="${contractType['id'] eq dormitory['contractId']}">selected="selected"</c:if>>${contractType['name']}</option>
							</c:forEach>
					</select></td>
					<td>Dormitory Type:</td>
					<td><select name="dormitoryTypeId">
							<c:forEach var="dormitoryType" items="${dormitoryTypes}">
								<option value="${dormitoryType['id']}" <c:if test="${dormitoryType['id'] eq dormitory['dormitoryTypeId']}">selected="selected"</c:if>>${dormitoryType['name']}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Latitude:</td>
					<td><input type="text" name="latitude" value="${dormitory['latitude']}" /></td>
					<td>Longitude:</td>
					<td><input type="text" name="longitude" value="${dormitory['longitude']}" /></td>
				</tr>
				<tr>
					<td>Address*:</td>
					<td><input type="text" name="address" value="${dormitory['address']}" style="width: 300px;" /></td>
					<td>Currency:</td>
					<td><input type="text" name="currency" value="${dormitory['currency']}" /></td>
				</tr>
				<tr>
					<td>List Price:</td>
					<td><input type="text" name="listPrice" value="${dormitory['listPrice']}" /></td>
					<td>Sale Price:</td>
					<td><input type="text" name="salePrice" value="${dormitory['salePrice']}" /></td>
				</tr>
				<tr>
					<td>Service:</td>
					<td><input type="text" name="service" value="${dormitory['service']}" /></td>
					<td>Equipment:</td>
					<td><input type="text" name="equipment" value="${dormitory['equipment']}" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td colspan="3"><textarea name="description" cols="80" rows="5">
						${dormitory['description']}
					</textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update" />
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>