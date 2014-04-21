${message}

Order&nbsp;&nbsp;number:&nbsp;&nbsp;${order.id}<br>
Order&nbsp;&nbsp;amount:&nbsp;&nbsp;${order.amount}<br>
Order&nbsp;&nbsp;status:&nbsp;&nbsp;${order.orderStatus}<br>
Proposer:&nbsp;&nbsp;${order.belongsTo.login}<br>
Phone:&nbsp;&nbsp;${order.orderContact.belongsToInfo.phone}<br>
QQ:&nbsp;&nbsp;${order.orderContact.belongsToInfo.qq}<br>
Address:&nbsp;&nbsp;${order.orderContact.belongsToInfo.address}<br>
<hr>
<c:choose>
<c:when test='${"D" eq type}'>
Dormitory&nbsp;&nbsp;name:&nbsp;&nbsp;${order.lineItems[0].dormitory.name}<br>
Dormitory&nbsp;&nbsp;address:&nbsp;&nbsp;${order.lineItems[0].dormitory.address}<br>
Dormitory&nbsp;&nbsp;price:&nbsp;&nbsp;${order.amount}<br>
Contact&nbsp;&nbsp;type:&nbsp;&nbsp;${order.lineItems[0].contractType.name}<br>
</c:when>
<c:otherwise>
Flight&nbsp;&nbsp;Number:${order.lineItems[0].flightNum}<br>
Pickup&nbsp;&nbsp;Date:${order.lineItems[0].pickupDate}<br>
Pickup&nbsp;&nbsp;Type:${order.lineItems[0].pickupType}<br>
Max&nbsp;&nbsp;Luggage&nbsp;&nbsp;Size:${order.lineItems[0].luggageSize}<br>
Luggage&nbsp;&nbsp;Amount:${order.lineItems[0].luggageAmount}<br>
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
<c:when test="${0 eq order.orderStatus.value}"><c:set value="Waiting for user place order." var="buttonValue"/> <c:set value="0" var="showForm"/></c:when>
<c:when test="${1 eq order.orderStatus.value}"><c:set value="Reviewed" var="buttonValue"/> <c:set value="1" var="showForm"/></c:when>
<c:when test="${2 eq order.orderStatus.value}"><c:set value="Send Contract" var="buttonValue"/> <c:set value="1" var="showForm"/></c:when>
<c:when test="${3 eq order.orderStatus.value}"><c:set value="Contract sent" var="buttonValue"/> <c:set value="1" var="showForm"/></a></c:when>
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
	New Price: <input type="text" name="price" value="${order.amount}"/><br>
	<input type="submit" value="Change"/>
</form>
</c:if>



