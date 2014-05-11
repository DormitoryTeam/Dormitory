<form action="<c:url value='/admin/order/orderList.html'/>" method="GET">
订单类型: <input type="text" name="orderType" value="${type}"/><br>
订单编号: <input type="text" name="orderId" value="${orderId}"/><br>
用户名: &nbsp;&nbsp;&nbsp;<input type="text" name="login" value="${login}"/><br>
起始时间: <input type="text" name="dateFrom" value="${dateFrom}"/><br>
结束时间: <input type="text" name="dateTo" value="${dateTo}"/><br>
<input type="submit" value="查询"/>
</form>
<hr>
<table>
<c:choose>
<c:when test='${"D" eq type}'>
	<tr>
		<td>订单编号</td>
		<td>宿舍名称</td>
		<td>价格</td>
		<td>用户</td>
		<td>预定时间</td>
		<td>当前状态</td>
		<td>操作</td>
	</tr>
	<c:forEach var="order" items="${orders}" varStatus="i">
	<tr>
		<td><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">${order.id}</a></td>
		<td>${order.lineItems[0].dormitory.name}</td>
		<td>${order.amount}</td>
		<td>${order.user.login}</td>
		<td>${order.createTime}</td>
		<td>${order.orderStatus}</td>
		<td>
			<c:choose>
				<c:when test="${0 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">审核中</a></c:when>
				<c:when test="${1 eq order.orderStatus.value}">等待付款</c:when>
				<c:when test="${2 eq order.orderStatus.value}">等待付款</c:when>
				<c:when test="${3 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">确认制服</a></c:when>
				<c:when test="${4 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">发送合同</a></c:when>
				<c:otherwise>完成</c:otherwise>
			</c:choose>
		</td>
	<tr>
	</c:forEach>
</c:when>
<c:otherwise>
	<tr>
		<td>订单编号</td>
		<td>航班号</td>
		<td>价格</td>
		<td>用户</td>
		<td>预定时间</td>
		<td>当前状态</td>
		<td>操作</td>
	</tr>
	<c:forEach var="order" items="${orders}" varStatus="i">
	<tr>
		<td><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">${order.id}</a></td>
		<td>${order.lineItems[0].flightNum}</td>
		<td>${order.amount}</td>
		<td>${order.user.login}</td>
		<td>${order.createTime}</td>
		<td>${order.orderStatus}</td>
		<td>
			<c:choose>
				<c:when test="${0 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">审核中</a></c:when>
				<c:when test="${1 eq order.orderStatus.value}">等待付款</c:when>
				<c:when test="${2 eq order.orderStatus.value}">等待付款</c:when>
				<c:when test="${3 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">确认制服</a></c:when>
				<c:when test="${4 eq order.orderStatus.value}"><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">发送合同</a></c:when>
				<c:otherwise>FINISH</c:otherwise>
			</c:choose>
		</td>
	<tr>
	</c:forEach>
</c:otherwise>
</c:choose>
</table>
<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/>