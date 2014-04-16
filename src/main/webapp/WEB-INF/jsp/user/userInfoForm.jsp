<hostel:container template="myaccount">
    <%-- top section --%>
    <header>
        <jsp:include page="/jsp/header/header.jsp"/>  
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
			<c:choose>
			<c:when test="${'edit' eq command}">
            <jsp:include page="/jsp/main/myaccount/user/userInfoForm.jsp"/>
            </c:when>
            <c:otherwise>
            <jsp:include page="/jsp/main/myaccount/user/display/userInfoForm.jsp"/>
            </c:otherwise>
            </c:choose>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
        <jsp:include page="/jsp/footer/footer.jsp"/>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/user/userinfo.js'/>"></script>
</hostel:container>
<%--
<html>
<body>
<h1>Edit User</h1>
${message}<br>
<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="loginForm" name="loginForm">
<input name="infoId" type="hidden" value="${user.info.id}"/>
gender: 
<select name="gender">
<option value="0" <c:if test="user.info.gender eq 0">selected</c:if>>Mr.</option>
<option value="1" <c:if test="user.info.gender eq 1">selected</c:if>>Mrs.</option>
<option value="2" <c:if test="user.info.gender eq 2">selected</c:if>>Miss</option>
</select><br>
alias: <input name="alias" type="text" value="${user.alias}" /><br>
name: <input name="name" type="text" value="${user.info.name}" /><br>
nationality: <input name="nationality" type="text" value="${user.info.nationality}" /><br>
birthday: <input name="birthday" type="text" value="<fmt:formatDate value='${user.info.birthday}' pattern='yyyy-MM-dd'/>" /><br>
email: <input name="email" value="${user.info.email}"/><br>
qq: <input name="qq" type="text" value="${user.info.qq}" /><br>
wechat: <input name="wechat" type="text" value="${user.info.wechat}" /><br>
phone: <input name="phone" type="text" value="${user.info.phone}" /><br>
address: country <input name="country" type="text" value="${user.info.country}" /> | province <input name="province" type="text" value="${user.info.province}" /> | city <input name="city" type="text" value="${user.info.city}" /> | <input name="address" type="text" value="${user.info.address}" /><br>

<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>
--%>