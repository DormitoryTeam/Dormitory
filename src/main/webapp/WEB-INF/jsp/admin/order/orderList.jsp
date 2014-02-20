<form action="<c:url value='/admin/order/orderList.html'/>" method="POST">
orderType: <input type="text" name="orderType" value="${type}"/><br>
orderNumber: <input type="text" name="orderId" value="${orderId}"/><br>
username: <input type="text" name="login" value="${login}"/><br>
date from: <input type="text" name="dateFrom" value="${dateFrom}"/><br>
date to: <input type="text" name="dateTo" value="${dateTo}"/><br>
<input type="submit" value="submit"/>
</form>
<hr>
<table>
<c:choose>
<c:when test='${"D" eq type}'>
	<tr>
		<td>Order Number</td>
		<td>Dormitory Name</td>
		<td>Price</td>
		<td>Book By</td>
		<td>Book For</td>
		<td>Book Time</td>
		<td>Status</td>
		<td>Action</td>
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
		<td>
			<c:choose>
				<c:when test="${0 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">Review</a></c:when>
				<c:when test="${1 eq order.orderStatus.value}">Waiting for Payment</c:when>
				<c:when test="${2 eq order.orderStatus.value}">Waiting for Payment</c:when>
				<c:when test="${3 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">Comfirm Payment</a></c:when>
				<c:when test="${4 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">Send Contract</a></c:when>
				<c:otherwise>FINISH</c:otherwise>
			</c:choose>
		</td>
	<tr>
	</c:forEach>
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>
</table>