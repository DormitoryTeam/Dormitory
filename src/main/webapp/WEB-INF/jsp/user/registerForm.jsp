<html>
<body>
<h1>Register</h1>
${message}<br>
<form action="<c:url value="/user/register.html"/>" method="POST" id="loginForm" name="loginForm">
userName: <input name="login" value="${login}" type="text"/><br>
password: <input name="password" type="password"/><br>
<input name="submit" type="submit" value="submit"/>
</form>
</body>
</html>