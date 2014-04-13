<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="hostel" tagdir="/WEB-INF/tags"%>
<hostel:container>
	<%-- top section --%>
	<header>
		<jsp:include page="/jsp/header/header.jsp" />
	</header>

	<%-- main section --%>
	<main> <%-- content --%>
	<div class="container">
		<div class="row">
			<div class="sidebar pull-right">
				<jsp:include page="/jsp/main/hostel/quick.jsp" />
				<jsp:include page="/jsp/main/hostel/rightinfobar.jsp" />
			</div>
			<div class="contentBox">
				<jsp:include page="include/dormitorydetail-detail.jsp" />
				<jsp:include page="include/dormitorydetail-comment.jsp" />
			</div>
		</div>
	</div>
	</main>

	<%-- bottom section --%>
	<footer>
		<jsp:include page="/jsp/footer/footer.jsp" />
	</footer>
</hostel:container>