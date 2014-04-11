<html>
<body>
<h1>Edit User</h1>
${message}<br>
Order for Pickup
<hr>
<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="loginForm" name="loginForm">
<input type="hidden" name="pageStep" value="3" />
<input type="hidden" name="orderType" value="${orderType}"/>
luggageAmount:<input type="text" name="luggageAmount" value="${item.luggageAmount}"/>
luggageSize:<input type="text" name="luggageSize" value="${item.luggageSize}"/>
<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>