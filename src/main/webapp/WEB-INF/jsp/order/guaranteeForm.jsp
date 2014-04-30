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
                <jsp:include page="/jsp/main/hostel/order/guaranteeForm.jsp"/>
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
<h1>Edit Guarantee</h1>
${message}<br>
${dormitory.name}, ${price.contract}, ${price.salePrice}, ${price.salePrice},  <fmt:formatDate value='${roomInfo.checkinDate}' pattern='yyyy-MM-dd'/>
<hr>
<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="loginForm" name="loginForm">
<input type="hidden" name="pageStep" value="2" />
<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
<input type="hidden" name="contractId" value="${price.contractId}" /> 
<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
<input name="infoId" type="hidden" value="${order.orderContact.guaranteeInfo.id}"/>

<c:set var="gender" value="${order.orderContact.guaranteeInfo.gender}" />
<c:if test="${null == gender}">
<c:set var="gender" value="${user.guaranteeInfo.gender}" />
</c:if>
gender: 
<select name="gender">
<option value="0" <c:if test="gender eq 0">selected</c:if>>Mr.</option>
<option value="1" <c:if test="gender eq 1">selected</c:if>>Mrs.</option>
<option value="2" <c:if test="gender eq 2">selected</c:if>>Miss</option>
</select><br>

<c:set var="name" value="${order.orderContact.guaranteeInfo.name}" />
<c:if test="${null == name}">
<c:set var="name" value="${user.guaranteeInfo.name}" />
</c:if>
name: <input name="name" type="text" value="${name}" /><br>

<c:set var="nationality" value="${order.orderContact.guaranteeInfo.nationality}" />
<c:if test="${null == nationality}">
<c:set var="nationality" value="${user.guaranteeInfo.nationality}" />
</c:if>
nationality: <input name="nationality" type="text" value="${nationality}" /><br>

<c:set var="birthday" value="${order.orderContact.guaranteeInfo.birthday}" />
<c:if test="${null == birthday}">
<c:set var="birthday" value="${user.guaranteeInfo.birthday}" />
</c:if>
birthday: <input name="birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" /><br>

<c:set var="email" value="${order.orderContact.guaranteeInfo.email}" />
<c:if test="${null == email}">
<c:set var="email" value="${user.guaranteeInfo.email}" />
</c:if>
email: <input name="email" value="${email}"/><br>

<c:set var="qq" value="${order.orderContact.guaranteeInfo.qq}" />
<c:if test="${null == qq}">
<c:set var="qq" value="${user.guaranteeInfo.qq}" />
</c:if>
qq: <input name="qq" type="text" value="${qq}" /><br>

<c:set var="wechat" value="${order.orderContact.guaranteeInfo.wechat}" />
<c:if test="${null == wechat}">
<c:set var="wechat" value="${user.guaranteeInfo.wechat}" />
</c:if>
wechat: <input name="wechat" type="text" value="${wechat}" /><br>

<c:set var="phone" value="${order.orderContact.guaranteeInfo.phone}" />
<c:if test="${null == phone}">
<c:set var="phone" value="${user.guaranteeInfo.phone}" />
</c:if>
phone: <input name="phone" type="text" value="${phone}" /><br>

<c:set var="country" value="${order.orderContact.guaranteeInfo.country}" />
<c:if test="${null == country}">
<c:set var="country" value="${user.guaranteeInfo.country}" />
</c:if>
<c:set var="province" value="${order.orderContact.guaranteeInfo.province}" />
<c:if test="${null == province}">
<c:set var="province" value="${user.guaranteeInfo.province}" />
</c:if>
<c:set var="city" value="${order.orderContact.guaranteeInfo.city}" />
<c:if test="${null == city}">
<c:set var="city" value="${user.guaranteeInfo.city}" />
</c:if>
<c:set var="address" value="${order.orderContact.guaranteeInfo.address}" />
<c:if test="${null == address}">
<c:set var="address" value="${user.guaranteeInfo.address}" />
</c:if>
address: country <input name="country" type="text" value="${country}" /> | province <input name="province" type="text" value="${province}" /> | city <input name="city" type="text" value="${city}" /> | <input name="address" type="text" value="${address}" /><br>

<input name="submit" type="submit" value="Next"/>
</form>
</body>
</html>
--%>