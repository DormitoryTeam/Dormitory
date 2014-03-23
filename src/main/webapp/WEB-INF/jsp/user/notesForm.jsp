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