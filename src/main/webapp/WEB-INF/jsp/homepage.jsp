<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hostel" tagdir="/WEB-INF/tags" %>
<hostel:container template="homepage">

	<script type="text/javascript" src="<c:url value='/js/home.js'/>"></script>
	
    <%-- top section --%>
    <header>
    	<jsp:include page="/jsp/header/header.jsp"/>  
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
			<jsp:include page="include/slideBanner.jsp"/>
            <jsp:include page="include/infoBanner.jsp"/>
            <jsp:include page="include/newsList.jsp"/>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    	<jsp:include page="/jsp/footer/footer.jsp"/>
    </footer>  
</hostel:container>