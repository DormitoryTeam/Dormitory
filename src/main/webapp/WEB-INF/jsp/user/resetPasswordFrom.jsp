<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hostel" tagdir="/WEB-INF/tags"%>
<hostel:container template="global">

	<%-- top section --%>
	<header>
		<jsp:include page="/jsp/header/header.jsp" />
	</header>

	<%-- main section --%>z`
	<main> <%-- content --%>
	<div class="container">
		<br />
		<br />
		<br />
		<form action="<c:url value="/user/resetPassword.html"/>" method="POST" id="loginForm" name="loginForm">
			新的密码: <input name="password" type="password" />
			<input name="sign" type="hidden" value="${sign}" /> 
			<input name="login" type="hidden" value="${user.login}" /> 
			<input name="submit" type="submit" value="修改密码！" />
		</form>
	</div>
	</main>

	<%-- bottom section --%>
	<footer>
		<jsp:include page="/jsp/footer/footer.jsp" />
	</footer>
</hostel:container>