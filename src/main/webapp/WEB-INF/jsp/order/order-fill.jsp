<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/order/order-fill.js'/>"></script>
<title></title>
</head>
<body>
	<form action="/dormitory/dormitory/dormitory-list.html" method="GET">
		<table>
			<tr>
				<td>Dormitory:</td>
				<td>${dormitory['name']}</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td>${dormitory['address']}</td>
				<td>Price:</td>
				<td>${dormitory['currency']}&nbsp;${dormitory['salePrice']}</td>
			</tr>
			<tr>
				<td colspan="4"><hr /></td>
			</tr>
			<tr>
				<td>User contact Informations:</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${user['name']}" /></td>
				<td>Gender:</td>
				<td><select name="gender">
						<option value="1" <c:if test="${user['gender']}">selected="selected"</c:if>>Male</option>
						<option value="0" <c:if test="${not user['gender']}">selected="selected"</c:if>>Female</option>
				</select></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="${user['phone']}" /></td>
				<td>QQ:</td>
				<td><input type="text" name="QQ" value="${user['qq']}" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td colspan="3"><input type="text" name="address" value="${user['address']}" /></td>
			</tr>
			<tr>
				<td colspan="4"><hr /></td>
			</tr>
			<tr>
				<td><input type="radio" name="orderFor" value="true" />Myself</td>
				<td><input type="radio" name="orderFor" value="false" />Other User</td>
				<td><input type="text" id="otherUserEmail" name="otherUserEmail" value="" /></td>
				<td><input type="button" id="btnSearchOtherUserByEmail" name="btnSearchOtherUserByEmail" value="Search Other User With Email" /></td>
			</tr>
			<div id="divOtherUserInfo">
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" value="" /></td>
					<td>Gender:</td>
					<td><select name="gender">
							<option value="1">Male</option>
							<option value="0">Female</option>
					</select></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="phone" value="" /></td>
					<td>QQ:</td>
					<td><input type="text" name="QQ" value="" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td colspan="3"><input type="text" name="address" value="" /></td>
				</tr>
			</div>
		</table>
	</form>
</body>
</html>