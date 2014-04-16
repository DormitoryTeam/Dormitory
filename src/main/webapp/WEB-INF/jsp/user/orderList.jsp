<hostel:container template="myaccount">
    <%-- top section --%>
    <header>
        <jsp:include page="/jsp/header/header.jsp"/>  
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <jsp:include page="/jsp/main/myaccount/order/orderList.jsp"/>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
        <jsp:include page="/jsp/footer/footer.jsp"/>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/user/userinfo.js'/>"></script>
</hostel:container>

<%--
<table>
<c:choose>
<c:when test='${"D" eq type}'>
	<tr>
		<td>Order Number</td>
		<td>Dormitory Name</td>
		<td>Price</td>
		<td>Book By</td>
		<td>Book For</td>
		<td>Book Time</td>
		<td>status</td>
	</tr>
	<c:forEach var="order" items="${orders}" varStatus="i">
	<tr>
		<td><a href="<c:url value='/user/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">${order.id}</a></td>
		<td>${order.lineItems[0].dormitory.name}</td>
		<td>${order.amount}</td>
		<td>${order.user.login}</td>
		<td>${order.belongsTo.login}</td>
		<td>${order.createTime}</td>
		<td>${order.orderStatus}</td>
	<tr>
	</c:forEach>
</c:when>
<c:otherwise>
	<tr>
		<td>Order Number</td>
		<td>Flight Name</td>
		<td>Price</td>
		<td>Book By</td>
		<td>Book For</td>
		<td>Book Time</td>
		<td>status</td>
	</tr>
	<c:forEach var="order" items="${orders}" varStatus="i">
	<tr>
		<td><a href="<c:url value='/user/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">${order.id}</a></td>
		<td>${order.lineItems[0].flightNum}</td>
		<td>${order.amount}</td>
		<td>${order.user.login}</td>
		<td>${order.belongsTo.login}</td>
		<td>${order.createTime}</td>
		<td>${order.orderStatus}</td>
	<tr>
	</c:forEach>
</c:otherwise>
</c:choose>


</table>
<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/>
--%>