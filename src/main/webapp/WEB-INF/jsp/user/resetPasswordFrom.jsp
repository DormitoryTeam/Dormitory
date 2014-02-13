<html>
<body>
<h1>Reset Password Form</h1>
${message}<br>
<form action="<c:url value="/user/resetPassword.html"/>" method="POST" id="loginForm" name="loginForm">
New password: <input name="password" type="password"/><br>
<input name="sign" type="hidden" value="${sign}"/>
<input name="login" type="hidden" value="${user.login}"/>
<input name="submit" type="submit" value="submit"/>
</form>
</body>
</html>