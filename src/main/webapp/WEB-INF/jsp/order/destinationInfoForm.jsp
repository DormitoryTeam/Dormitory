<html>
<body>
<h1>Edit User</h1>
${message}<br>
Order for Pickup: Destination Information.
<hr>
<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="loginForm" name="loginForm">
<input type="hidden" name="pageStep" value="2" />
<input type="hidden" name="orderType" value="${orderType}"/>
pickup2City:<input type="text" name="pickup2City" value="${item.pickup2City}"/><br>
pickup2Address:<input type="text" name="pickup2Address" value="${item.pickup2Address}"/><br>
pickup2Dormitory:<input type="text" name="pickup2Dormitory" value="${item.pickup2Dormitory}"/><br>
pickup2Postalcode:<input type="text" name="pickup2Postalcode" value="${item.pickup2Postalcode}"/><br>
<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>