<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/order/pickup-order-fill.js'/>"></script>
<title></title>
</head>
<body>
	<form action="/dormitory/order/pickup-order-place.html" method="POST">
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
				<td>Flight:</td>
				<td><select id="sltFlight" name="flightNum">
						<c:choose>
							<c:when test="${not empty flights}">
								<c:forEach items="${flights}" var="flight">
									<option flightName="${flight['name']}" value="${flight['flightNum']}">${flight['flightNum']}</option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<option value="0">no valid result</option>
							</c:otherwise>
						</c:choose>
				</select></td>
			</tr>
			<tr>
				<td>Pickup Date*:</td>
				<td><input type="text" name="pickupDate" /></td>
				<td>Pickup Type*:</td>
				<td><select name="pickupType">
						<option value="TAXI">Taxi</option>
						<option value="BUS">Bus</option>
				</select></td>
			</tr>
			<tr>
				<td>Max Luggage Size*:</td>
				<td><input type="text" name="luggageSize" /></td>
				<td>Luggage Amount*:</td>
				<td><input type="text" name="luggageAmount" /></td>
			</tr>
			<tr>
				<td colspan="4"><hr /></td>
			</tr>
			<tr>
				<td>User contact Informations:</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" id="name" name="name" value="${user['name']}" /></td>
				<td>Gender:</td>
				<td><select name="gender" id="gender">
						<option value="1" <c:if test="${user['gender']}">selected="selected"</c:if>>Male</option>
						<option value="0" <c:if test="${not user['gender']}">selected="selected"</c:if>>Female</option>
				</select></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" id="phone" value="${user['phone']}" /></td>
				<td>QQ:</td>
				<td><input type="text" name="qq" id="qq" value="${user['qq']}" /></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td colspan="3"><input type="text" name="address" id="address" value="${user['address']}" style="width: 400px;" /></td>
			</tr>
			<tr>
				<td colspan="4"><hr /></td>
			</tr>

			<c:if test="${empty user['id']}">
				<tr>
					<td>Email:</td>
					<td colspan="3"><input type="text" name="email" id="email" value="${user['email']}" style="width: 400px;" /></td>
				</tr>
			</c:if>

			<c:if test="${not empty user['id']}">
				<tr>
					<td><input type="radio" class="orderFor" name="orderFor" value="true" checked="checked" />Myself</td>
					<td><input type="radio" class="orderFor" name="orderFor" value="false" />Other User</td>
					<td><input type="hidden" name="id" value="${user['id']}" /> <input type="hidden" name="email" value="${user['email']}" /> <input type="hidden" name="login" value="${user['login']}" /></td>
				</tr>
			</c:if>

			<tr class="trOther" style="display: none;">
				<td>Email:</td>
				<td><input type="text" class="otheruser" id="otheremail" name="otheremail" value="" /></td>
				<td colspan="2"><input type="button" id="btnSearchOtherUserByEmail" name="btnSearchOtherUserByEmail" value="Search Other User With Email" /></td>
			</tr>
			<tr class="trOther" style="display: none;">
				<td>Name:</td>
				<td><input type="text" class="otheruser" name="othername" id="othername" value="${user['name']}" /> <input type="hidden" class="otheruser" name="otherid" id="otherid" value="${user['id']}" /></td>
				<td>Gender:</td>
				<td><select name="othergender" class="otheruser" id="othergender">
						<option value="1" <c:if test="${user['gender']}">selected="selected"</c:if>>Male</option>
						<option value="0" <c:if test="${not user['gender']}">selected="selected"</c:if>>Female</option>
				</select></td>
			</tr>
			<tr class="trOther" style="display: none;">
				<td>Phone:</td>
				<td><input type="text" class="otheruser" name="otherphone" id="otherphone" value="${user['phone']}" /></td>
				<td>QQ:</td>
				<td><input type="text" class="otheruser" name="otherqq" id="otherqq" value="${user['qq']}" /></td>
			</tr>
			<tr class="trOther" style="display: none;">
				<td>Address</td>
				<td colspan="3"><input type="text" class="otheruser" name="otheraddress" id="otheraddress" value="${user['address']}" style="width: 400px;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>