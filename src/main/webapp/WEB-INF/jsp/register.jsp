<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hostel" tagdir="/WEB-INF/tags" %>
<hostel:container template="global">

    <%-- top section --%>
    <header>
    	<jsp:include page="/jsp/header/header.jsp"/>  
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
			<input type="hidden" id="hidPageType" value="register" />
			<a id="popupLink" href="javascript:void(0)" class="hidden" data-popupSrc="/dormitory/user/loadRegister.html">&nbsp;</a>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    	<jsp:include page="/jsp/footer/footer.jsp"/>
    </footer>  
</hostel:container>