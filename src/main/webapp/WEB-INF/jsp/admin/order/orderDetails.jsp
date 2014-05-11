${message}

订单编号:&nbsp;&nbsp;${order.id}<br>
订单价格:&nbsp;&nbsp;${order.amount}<br>
当前状态:&nbsp;&nbsp;${order.orderStatus}<br>
用户:&nbsp;&nbsp;${order.belongsTo.login}<br>
联系电话:&nbsp;&nbsp;${order.orderContact.belongsToInfo.phone}<br>
QQ:&nbsp;&nbsp;${order.orderContact.belongsToInfo.qq}<br>
地址:&nbsp;&nbsp;${order.orderContact.belongsToInfo.address}<br>
<hr>
<c:choose>
<c:when test='${"D" eq type}'>
宿舍名称:&nbsp;&nbsp;${order.lineItems[0].dormitory.name}<br>
宿舍地址:&nbsp;&nbsp;${order.lineItems[0].dormitory.address}<br>
宿舍价格:&nbsp;&nbsp;${order.amount}<br>
合同类型:&nbsp;&nbsp;${order.lineItems[0].contractType.name}<br>
</c:when>
<c:otherwise>
航班号:${order.lineItems[0].flightNum}<br>
接机时间:${order.lineItems[0].pickupDate}<br>
接机方式:${order.lineItems[0].pickupType}<br>
最大行李尺寸:${order.lineItems[0].luggageSize}<br>
行李数量:${order.lineItems[0].luggageAmount}<br>
</c:otherwise>
</c:choose>
<c:choose>
<%--
<c:when test="${0 eq order.orderStatus.value}"><c:set value="Waiting for user place order." var="buttonValue"/> <c:set value="0" var="showForm"/></c:when>
<c:when test="${1 eq order.orderStatus.value}"><c:set value="Reviewed" var="buttonValue"/> <c:set value="1" var="showForm"/></c:when>
<c:when test="${2 eq order.orderStatus.value}"><c:set value="Waiting for user payment." var="buttonValue"/><c:set value="0" var="showForm"/></c:when>
<c:when test="${3 eq order.orderStatus.value}"><c:set value="Waiting for user payment." var="buttonValue"/><c:set value="0" var="showForm"/></c:when>
<c:when test="${4 eq order.orderStatus.value}"><c:set value="ComfirmPayment" var="buttonValue"/> <c:set value="1" var="showForm"/></c:when>
<c:when test="${5 eq order.orderStatus.value}"><c:set value="Send Contract" var="buttonValue"/> <c:set value="1" var="showForm"/></a></c:when>
--%>
<c:when test="${0 eq order.orderStatus.value}"><c:set value="等待用户提交订单" var="buttonValue"/> <c:set value="0" var="showForm"/></c:when>
<c:when test="${1 eq order.orderStatus.value}"><c:set value="通过审核" var="buttonValue"/> <c:set value="1" var="showForm"/></c:when>
<c:when test="${2 eq order.orderStatus.value}"><c:set value="发送合同" var="buttonValue"/> <c:set value="1" var="showForm"/></c:when>
<c:when test="${3 eq order.orderStatus.value}"><c:set value="已发送合同" var="buttonValue"/> <c:set value="1" var="showForm"/></a></c:when>
<c:otherwise><c:set value="0" var="showForm"/></c:otherwise>
</c:choose>


<c:if test="${'1' eq showForm }">
<hr>
<form action="<c:url value='/admin/order/updateOrderStatus.html'/>" method="POST">
	<input type="hidden" name="orderId" value="${order.id}"/>
	<input type="hidden" name="orderType" value="${type}"/>
	<input type="hidden" name="nextStatusValue" value="${order.orderStatus.nextStatus.value}"/>
	<input type="submit" value="${buttonValue}"/>
</form>
</c:if>
<c:if test="${'0' eq showForm }">
<hr>
${buttonValue}
</c:if>

<c:if test="${order.orderStatus.value lt 2}">
<hr>
<form action="<c:url value='/admin/order/updateOrderPrice.html'/>" method="POST">
	<input type="hidden" name="orderId" value="${order.id}"/>
	<input type="hidden" name="orderType" value="${type}"/>
	重新设置价格: <input type="text" name="price" value="${order.amount}"/><br>
	<input type="submit" value="改变价格"/>
</form>
</c:if>



