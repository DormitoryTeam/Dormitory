<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="hostel" tagdir="/WEB-INF/tags"%>
<hostel:container template="hostel">

	<script type="text/javascript" src="<c:url value='/js/dormitory/dormitory-list.js'/>"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDseYSlaYVhokgVdQuPH9Y35gACzO2n3BM&sensor=false"></script>
	
	<%-- top section --%>
	<header>
		<jsp:include page="/jsp/header/header.jsp" />
	</header>

	<%-- main section --%>
	<main> <%-- content --%>
	<div class="container">
		<div class="row">
			<div class="sidebar pull-right">
				<jsp:include page="include/dormitorylist-map.jsp" />
				<jsp:include page="include/dormitorylist-rightinfobar.jsp" />
			</div>
			<div class="contentBox">
				<jsp:include page="include/dormitorylist-top.jsp" />
				<jsp:include page="include/dormitorylist-list.jsp" />
			</div>
		</div>
	</div>
	</main>

	<%-- bottom section --%>
	<footer>
		<jsp:include page="/jsp/footer/footer.jsp" />
	</footer>
</hostel:container>