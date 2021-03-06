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
                <jsp:include page="/jsp/main/hostel/order/destinationInfoForm.jsp"/>
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
--%>