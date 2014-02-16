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
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>

