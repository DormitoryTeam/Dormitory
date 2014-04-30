<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    	<jsp:include page="/jsp/header/header.jsp" />
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row">
                <jsp:include page="/jsp/main/hostel/order/contactPersonForm.jsp"/>
            </div>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    <jsp:include page="/jsp/footer/footer.jsp" />
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>
<%--
<html>
<body>
<h1>Edit Contact Person</h1>
${message}<br>
${dormitory.name}, ${price.contract}, ${price.salePrice}, ${price.salePrice},  <fmt:formatDate value='${roomInfo.checkinDate}' pattern='yyyy-MM-dd'/>
<hr>
<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="loginForm" name="loginForm">
<input name="pageStep" type="hidden" value="3"/>
<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
<input type="hidden" name="contractId" value="${price.contractId}" /> 
<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
<input name="infoId" type="hidden" value="${order.orderContact.contactPersonInfo.id}"/>
<c:set var="gender" value="${order.orderContact.contactPersonInfo.gender}" />
<c:if test="${null == gender}">
<c:set var="gender" value="${user.contactPersonInfo.gender}" />
</c:if>
gender: 
<select name="gender">
<option value="0" <c:if test="gender eq 0">selected</c:if>>Mr.</option>
<option value="1" <c:if test="gender eq 1">selected</c:if>>Mrs.</option>
<option value="2" <c:if test="gender eq 2">selected</c:if>>Miss</option>
</select><br>

<c:set var="name" value="${order.orderContact.contactPersonInfo.name}" />
<c:if test="${null == name}">
<c:set var="name" value="${user.contactPersonInfo.name}" />
</c:if>
name: <input name="name" type="text" value="${name}" /><br>

<c:set var="nationality" value="${order.orderContact.contactPersonInfo.nationality}" />
<c:if test="${null == nationality}">
<c:set var="nationality" value="${user.contactPersonInfo.nationality}" />
</c:if>
nationality: <input name="nationality" type="text" value="${nationality}" /><br>

<c:set var="birthday" value="${order.orderContact.contactPersonInfo.birthday}" />
<c:if test="${null == birthday}">
<c:set var="birthday" value="${user.contactPersonInfo.birthday}" />
</c:if>
birthday: <input name="birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" /><br>

<c:set var="email" value="${order.orderContact.contactPersonInfo.email}" />
<c:if test="${null == email}">
<c:set var="email" value="${user.contactPersonInfo.email}" />
</c:if>
email: <input name="email" value="${email}"/><br>

<c:set var="qq" value="${order.orderContact.contactPersonInfo.qq}" />
<c:if test="${null == qq}">
<c:set var="qq" value="${user.contactPersonInfo.qq}" />
</c:if>
qq: <input name="qq" type="text" value="${qq}" /><br>

<c:set var="wechat" value="${order.orderContact.contactPersonInfo.wechat}" />
<c:if test="${null == wechat}">
<c:set var="wechat" value="${user.contactPersonInfo.wechat}" />
</c:if>
wechat: <input name="wechat" type="text" value="${wechat}" /><br>

<c:set var="phone" value="${order.orderContact.contactPersonInfo.phone}" />
<c:if test="${null == phone}">
<c:set var="phone" value="${user.contactPersonInfo.phone}" />
</c:if>
phone: <input name="phone" type="text" value="${phone}" /><br>

<c:set var="country" value="${order.orderContact.contactPersonInfo.country}" />
<c:if test="${null == country}">
<c:set var="country" value="${user.contactPersonInfo.country}" />
</c:if>
<c:set var="province" value="${order.orderContact.contactPersonInfo.province}" />
<c:if test="${null == province}">
<c:set var="province" value="${user.contactPersonInfo.province}" />
</c:if>
<c:set var="city" value="${order.orderContact.contactPersonInfo.city}" />
<c:if test="${null == city}">
<c:set var="city" value="${user.contactPersonInfo.city}" />
</c:if>
<c:set var="address" value="${order.orderContact.contactPersonInfo.address}" />
<c:if test="${null == address}">
<c:set var="address" value="${user.contactPersonInfo.address}" />
</c:if>
address: country <input name="country" type="text" value="${country}" /> | province <input name="province" type="text" value="${province}" /> | city <input name="city" type="text" value="${city}" /> | <input name="address" type="text" value="${address}" /><br>

<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>
--%>