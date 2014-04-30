<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    	<jsp:include page="/jsp/header/header.jsp" />
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row airport">
                <jsp:include page="/jsp/main/hostel/order/flightInfoForm.jsp"/>
            </div>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    <jsp:include page="/jsp/footer/footer.jsp" />
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>
<%--
<html>
<body>
<h1>Edit User</h1>
${message}<br>
Order for Pickup: Flight Information.
<hr>
<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="loginForm" name="loginForm">
<input type="hidden" name="pageStep" value="1" />
<input type="hidden" name="orderType" value="${orderType}"/>
takeOffDate:<input type="text" name="takeOffDate" value="<fmt:formatDate value='${item.takeOffDate}' pattern='yyyy-MM-dd'/>"/><br>
takeOffCity:<input type="text" name="takeOffCity" value="${item.takeOffCity}"/><br>
pickupDate:<input type="text" name="pickupDate" value="<fmt:formatDate value='${item.pickupDate}' pattern='yyyy-MM-dd'/>"/><br>
arrivalCity:<input type="text" name="arrivalCity" value="${item.arrivalCity}"/><br>
arrivalCountry:<input type="text" name="arrivalCountry" value="${item.arrivalCountry}"/><br>
arrivalAirport:<input type="text" name="arrivalAirport" value="${item.arrivalAirport}"/><br>
flightCompany:<input type="text" name="flightCompany" value="${item.flightCompany}"/><br>
flightNumber:<input type="text" name="flightNumber" value="${item.flightNum}"/><br>
<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>
--%>