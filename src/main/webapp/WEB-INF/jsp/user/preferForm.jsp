<html>
<body>
<h1>Edit User Prefer</h1>
${message}<br>
<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="loginForm" name="loginForm">
<input name="preferId" type="hidden" value="${user.prefer.id}"/>
<input name="pageStep" type="hidden" value="1"/>
smoking: <input name="smoke" type="radio" value="Y" <c:if test="${user.prefer.smoke}">checked</c:if>/>Yas <input name="smoke" type="radio" value="N" <c:if test="${not user.prefer.smoke}">checked</c:if> /> No<br> 
vegetarianism: <input name="vegetarianism" type="radio" value="Y" <c:if test="${user.prefer.vegetarianism}">checked</c:if> />Yas <input name="vegetarianism" type="radio" value="N"  <c:if test="${not user.prefer.vegetarianism}">checked</c:if> /> No<br>
your grade: <input name="yourGrade" type="text" value="${user.prefer.yourGrade}" /><br>
which grade prefer: <input name="roomMemberGrade" type="text" value="${user.prefer.roomMemberGrade}" /><br>
major: <input name="major" type="text" value="${user.prefer.major}" /><br>
college: <input name="college" value="${user.prefer.college}"/><br>
room member gender: <input name="roomMemberGender" type="radio" value="0" <c:if test="${0 eq user.prefer.roomMemberGender}">checked</c:if> />Mix <input name="roomMemberGender" type="radio" value="1" <c:if test="${1 eq user.prefer.roomMemberGender}">checked</c:if> /> Boy only<input name="roomMemberGender" type="radio" value="2" <c:if test="${2 eq user.prefer.roomMemberGender}">checked</c:if> />Girl only<input name="roomMemberGender" type="radio" value="3" <c:if test="${3 eq user.prefer.roomMemberGender}">checked</c:if> />not care<br>
floor: <input name="floor" type="text" value="${user.prefer.floor}" /><br>
orientation: <input name="orientation" type="radio" value="0" <c:if test="${0 eq user.prefer.orientation}">checked</c:if> />East<input name="orientation" type="radio" value="1" <c:if test="${1 eq user.prefer.orientation}">checked</c:if> />West<input name="orientation" type="radio" value="2" <c:if test="${2 eq user.prefer.orientation}">checked</c:if> />South<input name="orientation" type="radio" value="3" <c:if test="${3 eq user.prefer.orientation}">checked</c:if> />North<br>
graduateSchool: <input name="graduateSchool" type="text" value="${user.prefer.graduateSchool}" /><br>
<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>