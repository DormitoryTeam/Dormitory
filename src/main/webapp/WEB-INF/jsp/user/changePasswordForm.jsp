<html>
<body>
<h1>Change Password</h1>
${message}<br>
<form action="<c:url value="/user/changePassword.html"/>" method="POST" id="loginForm" name="loginForm">
oldPassword: <input name="oldPassword" type="password"/><br>
newPassword: <input name="newPassword" type="password"/><br>
<input name="submit" type="submit" value="submit"/>
</form>
</body>
</html>