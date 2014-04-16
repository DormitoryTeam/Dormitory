<hostel:container template="myaccount">
    <%-- top section --%>
    <header>
        <jsp:include page="/jsp/header/header.jsp"/>  
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <c:choose>
			<c:when test="${'edit' eq command}">
            <jsp:include page="/jsp/main/myaccount/user/notesForm.jsp"/>
            </c:when>
            <c:otherwise>
            <jsp:include page="/jsp/main/myaccount/user/display/notesForm.jsp"/>
            </c:otherwise>
            </c:choose>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
        <jsp:include page="/jsp/footer/footer.jsp"/>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/user/userinfo.js'/>"></script>
</hostel:container>
<%--
<html>
<body>
<h1>Edit Others</h1>
${message}<br>
<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="loginForm" name="loginForm">
<input name="preferId" type="hidden" value="${user.prefer.id}"/>
<input name="pageStep" type="hidden" value="4"/>
needPush: <input name="needPush" type="radio" value="Y" <c:if test="${user.prefer.needPush}">checked</c:if> />Yes <input name="needPush" type="radio" value="N" <c:if test="${not user.prefer.needPush}">checked</c:if> />No<br>
readClause: <input name="readClause" type="radio" value="Y" <c:if test="${user.prefer.readClause}">checked</c:if> />Yes <input name="readClause" type="radio" value="N" <c:if test="${not user.prefer.readClause}">checked</c:if> />No<br>
<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>
--%>