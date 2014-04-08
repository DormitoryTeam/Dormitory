<html>
<body>
<h1>Edit Contact Person</h1>
${message}<br>
<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="loginForm" name="loginForm">
<input name="infoId" type="hidden" value="${user.contactPersonInfo.id}"/>
<input name="pageStep" type="hidden" value="3"/>
gender: 
<select name="gender">
<option value="0" <c:if test="user.contactPersonInfo.gender eq 0">selected</c:if>>Mr.</option>
<option value="1" <c:if test="user.contactPersonInfo.gender eq 1">selected</c:if>>Mrs.</option>
<option value="2" <c:if test="user.contactPersonInfo.gender eq 2">selected</c:if>>Miss</option>
</select><br>
name: <input name="name" type="text" value="${user.contactPersonInfo.name}" /><br>
nationality: <input name="nationality" type="text" value="${user.contactPersonInfo.nationality}" /><br>
birthday: <input name="birthday" type="text" value="<fmt:formatDate value='${user.contactPersonInfo.birthday}' pattern='yyyy-MM-dd'/>" /><br>
email: <input name="email" value="${user.contactPersonInfo.email}"/><br>
qq: <input name="qq" type="text" value="${user.contactPersonInfo.qq}" /><br>
wechat: <input name="wechat" type="text" value="${user.contactPersonInfo.wechat}" /><br>
phone: <input name="phone" type="text" value="${user.contactPersonInfo.phone}" /><br>
address: country <input name="country" type="text" value="${user.contactPersonInfo.country}" /> | province <input name="province" type="text" value="${user.contactPersonInfo.province}" /> | city <input name="city" type="text" value="${user.contactPersonInfo.city}" /> | <input name="address" type="text" value="${user.contactPersonInfo.address}" /><br>

<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>