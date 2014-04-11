<html>
<body>
<h1>Edit User</h1>
${message}<br>
Order for Pickup: Flight Information.
<hr>
<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="loginForm" name="loginForm">
<input type="hidden" name="pageStep" value="1" />
<input type="hidden" name="orderType" value="${orderType}"/>
takeOffDate:<input type="text" name="takeOffDate" value="${item.takeOffDate}"/><br>
takeOffCity:<input type="text" name="takeOffCity" value="${item.takeOffCity}"/><br>
pickupDate:<input type="text" name="pickupDate" value="${item.pickupDate}"/><br>
arrivalCity:<input type="text" name="arrivalCity" value="${item.arrivalCity}"/><br>
arrivalCountry:<input type="text" name="arrivalCountry" value="${item.arrivalCountry}"/><br>
arrivalAirport:<input type="text" name="arrivalAirport" value="${item.arrivalAirport}"/><br>
flightCompany:<input type="text" name="flightCompany" value="${item.flightCompany}"/><br>
flightNumber:<input type="text" name="flightNumber" value="${item.flightNum}"/><br>
<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>