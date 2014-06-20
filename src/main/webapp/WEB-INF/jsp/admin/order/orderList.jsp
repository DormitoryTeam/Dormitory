<%@ taglib uri="/dormitory" prefix="dor"%>
<link rel="stylesheet" href="/style/all.css">
${message}
<br />
<form action="<c:url value='/admin/order/orderList.html'/>" method="GET">
<input type="hidden" name="orderType" value="${type}"/><br>
订单编号： <input type="text" name="orderId" value="${orderId}"/><br>
用户名： &nbsp;&nbsp;&nbsp;<input type="text" name="login" value="${login}"/><br>
用户识别码： &nbsp<input type="text" name="userToken" value="${userToken}"/><br>
起始时间： <input type="text" name="dateFrom" class="datepicker" value="${dateFrom}"/><br>
结束时间： <input type="text" name="dateTo" class="datepicker" value="${dateTo}"/><br>
是否有效：<select name="condition">
		<option value="active" <c:if test="${empty param.condition or param.condition eq 'active'}">selected</c:if>>是</option>
		<option value="inactive" <c:if test="${param.condition eq 'inactive'}">selected</c:if>>否</option>
		</select><br>
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
		<td><a href="<c:url value='/admin/order/editDormitoryOrder.html?orderId=${order.id}'/>"><dor:getOrderToken orderId="${order.id}" prefix="AC"  /></a></td>
		<td>${order.lineItems[0].dormitory.name}</td>
		<td>${order.amount}</td>
		<td>${order.user.login}</td>
		<td>${order.createTime}</td>
		<td>
			<c:choose>
				<c:when test="${'INITIAL' eq order.orderStatus}">等待用户完成订单</c:when>
				<c:when test="${'COMMIT' eq order.orderStatus}">已提交,等待审核</c:when>
				<c:when test="${'REVIEWDE' eq order.orderStatus}">审核完成，等待发送合同</c:when>
				<c:when test="${'SENDING_CONTACT' eq order.orderStatus}">合同发送中</c:when>
				<c:when test="${'DONE' eq order.orderStatus}">完成</c:when>
				<c:otherwise>完成</c:otherwise>
			</c:choose>
		</td>
		<td>
		<c:choose>
		<c:when test="${'active' eq order.condition}">
		<a href="<c:url value="/admin/order/updateOrderCondition.html?id=${order.id}&currentPage=${param.currentPage}&updateCondition=inactive&pageSize=${param.pageSize}&orderType=${param.orderType}&orderId=${param.orderId}&login=${param.login}&userToken=${param.userToken}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&condition=${param.condition}"/>">取消</a>
		</c:when>
		<c:otherwise>
		<a href="<c:url value="/admin/order/updateOrderCondition.html?id=${order.id}&currentPage=${param.currentPage}&updateCondition=active&pageSize=${param.pageSize}&orderType=${param.orderType}&orderId=${param.orderId}&login=${param.login}&userToken=${param.userToken}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&condition=${param.condition}"/>">恢复</a>
		</c:otherwise>
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
		<td><a href="<c:url value='/admin/order/editPickupOrder.html?orderId=${order.id}&orderType=${type}'/>"><dor:getOrderToken orderId="${order.id}" prefix="PU" /></a></td>
		<td>${order.lineItems[0].flightNum}</td>
		<td>${order.amount}</td>
		<td>${order.user.login}</td>
		<td>${order.createTime}</td>
		<td>
			<c:choose>
				<c:when test="${'INITIAL' eq order.orderStatus}">等待用户完成订单</c:when>
				<c:when test="${'COMMIT' eq order.orderStatus}">已提交,等待审核</c:when>
				<c:when test="${'REVIEWDE' eq order.orderStatus}">审核完成，已发送付款邮件</c:when>
				<c:when test="${'PAYMENT_DONE' eq order.orderStatus}">已支付，已发送车票邮件</c:when>
				<c:when test="${'PAYMENT_NOT_DONE' eq order.orderStatus}">未支付，已发送车票邮件</c:when>
				<c:otherwise>已支付，已发送车票邮件</c:otherwise>
			</c:choose>
		</td>
		<td>
		<c:choose>
		<c:when test="${'active' eq order.condition}">
		<a href="<c:url value="/admin/order/updateOrderCondition.html?id=${order.id}&currentPage=${param.currentPage}&updateCondition=inactive&pageSize=${param.pageSize}&orderType=${param.orderType}&orderId=${param.orderId}&login=${param.login}&userToken=${param.userToken}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&condition=${param.condition}"/>">取消</a>
		</c:when>
		<c:otherwise>
		<a href="<c:url value="/admin/order/updateOrderCondition.html?id=${order.id}&currentPage=${param.currentPage}&updateCondition=active&pageSize=${param.pageSize}&orderType=${param.orderType}&orderId=${param.orderId}&login=${param.login}&userToken=${param.userToken}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&condition=${param.condition}"/>">恢复</a>
		</c:otherwise>
		</c:choose>
		</td>
	<tr>
	</c:forEach>
</c:otherwise>
</c:choose>
</table>
<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/>
<script type="text/javascript" charset="utf-8" src="/js/vendor/jquery-1.10.2.min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/lib/jquery-ui.js"></script>
<script>
$(function() {

	// bind datepicker
    var currentYear = new Date().getFullYear();
    $(".datepicker").datepicker({ 
        dateFormat: "yy-mm-dd",
        showMonthAfterYear:true,
        changeMonth: true,
        changeYear: true,
        yearRange: (currentYear-34) + ":" + currentYear
    });
    $(".datepicker").attr("readonly",true);

});

</script>