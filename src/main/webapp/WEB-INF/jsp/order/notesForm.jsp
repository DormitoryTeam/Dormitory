<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row">
                <jsp:include page="/jsp/main/hostel/order/notesForm.jsp"/>
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
<h1>Edit Others</h1>
${message}<br>
${dormitory.name}, ${price.contract}, ${price.salePrice}, ${price.salePrice},  <fmt:formatDate value='${roomInfo.checkinDate}' pattern='yyyy-MM-dd'/>
<hr>
<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="loginForm" name="loginForm">
<input name="pageStep" type="hidden" value="4"/>
<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
<input type="hidden" name="contractId" value="${price.contractId}" /> 
<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
<input name="preferId" type="hidden" value="${order.orderContact.prefer.id}"/>

<c:set var="needPush" value="${order.orderContact.prefer.needPush}" />
<c:if test="${null == needPush}">
<c:set var="needPush" value="${user.prefer.needPush}" />
</c:if>
needPush: <input name="needPush" type="radio" value="Y" <c:if test="${needPush}">checked</c:if> />Yes <input name="needPush" type="radio" value="N" <c:if test="${not needPush}">checked</c:if> />No<br>

<c:set var="readClause" value="${order.orderContact.prefer.readClause}" />
<c:if test="${null == readClause}">
<c:set var="readClause" value="${user.prefer.readClause}" />
</c:if>
readClause: <input name="readClause" type="radio" value="Y" <c:if test="${readClause}">checked</c:if> />Yes <input name="readClause" type="radio" value="N" <c:if test="${not readClause}">checked</c:if> />No<br>
<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>
--%>