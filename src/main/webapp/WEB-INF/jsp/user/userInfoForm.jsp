<html>
<body>
<h1>Edit User</h1>
${message}<br>
<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="loginForm" name="loginForm">
name: <input name="name" type="text" value="${user.name}" /><br>
gender: <input name="password" type="text" value="${user.gender}" /><br>
passport: <input name="passport" type="text" value="${user.passport}" /><br>
birthday: <input name="birthday" type="text" value="${user.birthday}" /><br>
address: <input name="address" type="text" value="${user.address}" /><br>
phone: <input name="phone" type="text" value="${user.phone}" /><br>
qq: <input name="qq" type="text" value="${user.qq}" /><br>
<input name="submit" type="submit" value="submit"/>
</form>
</body>
</html>