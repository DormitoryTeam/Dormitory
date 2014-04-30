<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="hostel" tagdir="/WEB-INF/tags" %>
<hostel:container template="homepage">
    <%-- top section --%>
    <header>
    	<jsp:include page="/jsp/header/header.jsp"/>  
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
			<jsp:include page="include/collegenavigation-collegelist.jsp"/>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    	<jsp:include page="/jsp/footer/footer.jsp"/>
    </footer>  
</hostel:container>