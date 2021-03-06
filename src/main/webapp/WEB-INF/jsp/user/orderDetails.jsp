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
<%-- Pickup&nbsp;&nbsp;Type:${order.lineItems[0].pickupType}<br> --%>
Max&nbsp;&nbsp;Luggage&nbsp;&nbsp;Size:${order.lineItems[0].luggageSize}<br>
Luggage&nbsp;&nbsp;Amount:${order.lineItems[0].luggageAmount}<br>
</c:otherwise>
</c:choose>
