<table>
<form action="<c:url value='/admin/order/orderList.html'/>" method="POST">
orderType: <input type="text" name="orderType" value="${type}"/><br>
orderNumber: <input type="text" name="orderId" value="${orderId}"/><br>
username: <input type="text" name="login" value="${login}"/><br>
date from: <input type="text" name="dateFrom" value="${dateFrom}"/><br>
date to: <input type="text" name="dateTo" value="${dateTo}"/><br>
<input type="submit" value="submit"/>
</form>
<hr>
<c:choose>
<c:when test='${"D" eq type}'>
	<tr>
		<td>Order Number</td>
		<td>Dormitory Name</td>
		<td>Price</td>
		<td>Book By</td>
		<td>Book For</td>
		<td>Book Time</td>
		<td>status</td>
	</tr>
	<c:forEach var="order" items="${orders}" varStatus="i">
	<tr>
		<td><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">${order.id}</a></td>
		<td>${order.lineItems[0].dormitory.name}</td>
		<td>${order.amount}</td>
		<td>${order.user.login}</td>
		<td>${order.belongsTo.login}</td>
		<td>${order.createTime}</td>
		<td>${order.orderStatus}</td>
	<tr>
	</c:forEach>
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>
</table>