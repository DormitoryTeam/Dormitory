<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="hostel" tagdir="/WEB-INF/tags"%>
<hostel:container template="hostel">
	<%-- top section --%>
	<script type="text/javascript" src="/dormitory/js/jquery-raty/jquery.raty.min.js"></script>
	<script type="text/javascript" src="/dormitory/js/dormitory/dormitory-detail.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDseYSlaYVhokgVdQuPH9Y35gACzO2n3BM&sensor=false"></script>
	
	<header>
		<jsp:include page="/jsp/header/header.jsp" />
	</header>

	<%-- main section --%>
	<main> <%-- content --%>
	<div class="container">
		<div class="row">
			<div class="sidebar pull-right">
				<jsp:include page="/jsp/main/hostel/quick.jsp" />
				<jsp:include page="include/dormitorydetail-rightbar.jsp" />
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