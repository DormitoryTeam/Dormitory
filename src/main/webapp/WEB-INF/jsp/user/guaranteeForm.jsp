<html>
<body>
<h1>Edit Guarantee</h1>
${message}<br>
<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="loginForm" name="loginForm">
<input name="infoId" type="hidden" value="${user.guaranteeInfo.id}"/>
<input name="pageStep" type="hidden" value="2"/>
gender: 
<select name="gender">
<option value="0" <c:if test="user.guaranteeInfo.gender eq 0">selected</c:if>>Mr.</option>
<option value="1" <c:if test="user.guaranteeInfo.gender eq 1">selected</c:if>>Mrs.</option>
<option value="2" <c:if test="user.guaranteeInfo.gender eq 2">selected</c:if>>Miss</option>
</select><br>
name: <input name="name" type="text" value="${user.guaranteeInfo.name}" /><br>
nationality: <input name="nationality" type="text" value="${user.guaranteeInfo.nationality}" /><br>
birthday: <input name="birthday" type="text" value="<fmt:formatDate value='${user.guaranteeInfo.birthday}' pattern='yyyy-MM-dd'/>" /><br>
email: <input name="email" value="${user.guaranteeInfo.email}"/><br>
qq: <input name="qq" type="text" value="${user.guaranteeInfo.qq}" /><br>
wechat: <input name="wechat" type="text" value="${user.guaranteeInfo.wechat}" /><br>
phone: <input name="phone" type="text" value="${user.guaranteeInfo.phone}" /><br>
address: country <input name="country" type="text" value="${user.guaranteeInfo.country}" /> | province <input name="province" type="text" value="${user.guaranteeInfo.province}" /> | city <input name="city" type="text" value="${user.guaranteeInfo.city}" /> | <input name="address" type="text" value="${user.guaranteeInfo.address}" /><br>

<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>