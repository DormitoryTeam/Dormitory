<html>
<body>
<h1>Edit User Prefer</h1>

${dormitory.name}, ${price.contract}, ${price.salePrice}, ${price.salePrice},  <fmt:formatDate value='${roomInfo.checkinDate}' pattern='yyyy-MM-dd'/>
<hr>
${message}<br>
<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="loginForm" name="loginForm">
<input name="pageStep" type="hidden" value="1"/>
<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
<input type="hidden" name="contractId" value="${price.contractId}" /> 
<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
<input name="preferId" type="hidden" value="${order.orderContact.prefer.id}"/>


<c:set var="smoke" value="${order.orderContact.prefer.smoke}" />
<c:if test="${null == smoke}">
<c:set var="smoke" value="${user.prefer.smoke}" />
</c:if>
smoking: <input name="smoke" type="radio" value="Y" <c:if test="${smoke}">checked</c:if>/>Yes <input name="smoke" type="radio" value="N" <c:if test="${not smoke}">checked</c:if> /> No<br> 

<c:set var="vegetarianism" value="${order.orderContact.prefer.vegetarianism}" />
<c:if test="${null == vegetarianism}">
<c:set var="vegetarianism" value="${user.prefer.vegetarianism}" />
</c:if>
vegetarianism: <input name="vegetarianism" type="radio" value="Y" <c:if test="${vegetarianism}">checked</c:if> />Yes <input name="vegetarianism" type="radio" value="N"  <c:if test="${not vegetarianism}">checked</c:if> /> No<br>

<c:set var="yourGrade" value="${order.orderContact.prefer.yourGrade}" />
<c:if test="${null == yourGrade}">
<c:set var="yourGrade" value="${user.prefer.yourGrade}" />
</c:if>
your grade: <input name="yourGrade" type="text" value="${yourGrade}" /><br>

<c:set var="roomMemberGrade" value="${order.orderContact.prefer.roomMemberGrade}" />
<c:if test="${null == roomMemberGrade}">
<c:set var="roomMemberGrade" value="${user.prefer.roomMemberGrade}" />
</c:if>
which grade prefer: <input name="roomMemberGrade" type="text" value="${roomMemberGrade}" /><br>

<c:set var="major" value="${order.orderContact.prefer.major}" />
<c:if test="${null == major}">
<c:set var="major" value="${user.prefer.major}" />
</c:if>
major: <input name="major" type="text" value="${major}" /><br>

<c:set var="college" value="${order.orderContact.prefer.college}" />
<c:if test="${null == college}">
<c:set var="college" value="${user.prefer.college}" />
</c:if>
college: <input name="college" value="${college}"/><br>

<c:set var="roomMemberGender" value="${order.orderContact.prefer.roomMemberGender}" />
<c:if test="${null == roomMemberGender}">
<c:set var="roomMemberGender" value="${user.prefer.roomMemberGender}" />
</c:if>
room member gender: <input name="roomMemberGender" type="radio" value="0" <c:if test="${0 eq roomMemberGender}">checked</c:if> />Mix <input name="roomMemberGender" type="radio" value="1" <c:if test="${1 eq roomMemberGender}">checked</c:if> /> Boy only<input name="roomMemberGender" type="radio" value="2" <c:if test="${2 eq roomMemberGender}">checked</c:if> />Girl only<input name="roomMemberGender" type="radio" value="3" <c:if test="${3 eq roomMemberGender}">checked</c:if> />not care<br>

<c:set var="floor" value="${order.orderContact.prefer.floor}" />
<c:if test="${null == floor}">
<c:set var="floor" value="${user.prefer.floor}" />
</c:if>
floor: <input name="floor" type="text" value="${floor}" /><br>


<c:set var="orientation" value="${order.orderContact.prefer.orientation}" />
<c:if test="${null == orientation}">
<c:set var="orientation" value="${user.prefer.orientation}" />
</c:if>
orientation: <input name="orientation" type="radio" value="0" <c:if test="${0 eq orientation}">checked</c:if> />East<input name="orientation" type="radio" value="1" <c:if test="${1 eq orientation}">checked</c:if>/>West<input name="orientation" type="radio" value="2" <c:if test="${2 eq orientation}">checked</c:if> />South<input name="orientation" type="radio" value="3" <c:if test="${3 eq orientation}">checked</c:if> />North<br>

<c:set var="graduateSchool" value="${order.orderContact.prefer.graduateSchool}" />
<c:if test="${null == graduateSchool}">
<c:set var="graduateSchool" value="${user.prefer.graduateSchool}" />
</c:if>
graduateSchool: <input name="graduateSchool" type="text" value="${graduateSchool}" /><br>
<input type="hidden" name="needPush" value="${order.orderContact.prefer.needPush ? "Y" : "N"}" />
<input type="hidden" name="readClause" value="${order.orderContact.prefer.readClause ? "Y" : "N"}" />
<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>