<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row airport">
                <jsp:include page="/jsp/main/hostel/order/luggageInfoForm.jsp"/>
            </div>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>

<%--
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
--%>