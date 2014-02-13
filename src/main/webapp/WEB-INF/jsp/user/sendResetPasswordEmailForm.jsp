<html>
<body>
<h1>Send Reset Password Email</h1>
${message}<br>
<form action="<c:url value="/user/sendResetPasswordEmail.html"/>" method="POST" id="loginForm" name="loginForm">
username: <input name="login" type="text"/><br>
<input name="submit" type="submit" value="submit"/>
</form>
</body>
</html>