${message}
<c:choose>
<c:when test='${"D" eq type}'>
Order&nbsp;&nbsp;number:&nbsp;&nbsp;${order.id}<br>
Order&nbsp;&nbsp;status:&nbsp;&nbsp;${order.orderStatus}<br>
Proposer:&nbsp;&nbsp;${order.belongsTo.login}<br>
Phone:&nbsp;&nbsp;${order.orderContact.phone}<br>
QQ:&nbsp;&nbsp;${order.orderContact.QQ}<br>
Address:&nbsp;&nbsp;${order.orderContact.address}<br>
<hr>
Dormitory&nbsp;&nbsp;name:&nbsp;&nbsp;${order.lineItems[0].dormitory.name}<br>
Dormitory&nbsp;&nbsp;address:&nbsp;&nbsp;${order.lineItems[0].dormitory.address}<br>
Dormitory&nbsp;&nbsp;price:&nbsp;&nbsp;${order.amount}<br>
Contact&nbsp;&nbsp;type:&nbsp;&nbsp;${order.lineItems[0].dormitory.contract}<br>

<hr>
<c:choose>
<c:when test="${0 eq order.orderStatus.value}"><c:set value="Reviewed" var="buttonValue"/> <c:set value="1" var="showForm"/></c:when>
<c:when test="${1 eq order.orderStatus.value}"><c:set value="0" var="showForm"/></c:when>
<c:when test="${2 eq order.orderStatus.value}"><c:set value="0" var="showForm"/></c:when>
<c:when test="${3 eq order.orderStatus.value}"><c:set value="ComfirmPayment" var="buttonValue"/> <c:set value="1" var="showForm"/></c:when>
<c:when test="${4 eq order.orderStatus.value}"><c:set value="Send Contract" var="buttonValue"/> <c:set value="1" var="showForm"/></a></c:when>
<c:otherwise><c:set value="0" var="showForm"/></c:otherwise>
</c:choose>


<c:if test="${'1' eq showForm }">
<form action="<c:url value='/admin/order/updateOrderStatus.html'/>" method="POST">
	<input type="hidden" name="orderId" value="${order.id}"/>
	<input type="hidden" name="orderType" value="${type}"/>
	<input type="hidden" name="nextStatusValue" value="${order.orderStatus.nextStatus.value}"/>
	<input type="submit" value="${buttonValue}"/>
</form>
</c:if>

</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>

