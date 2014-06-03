<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="qq" >
				咨询宿舍客服<a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=0fcd0b428cd49421d6a1a8d2a0485cb2900343e3d6c19301"><img border="0" src="<c:url value='/img/banner/qq.gif'/>" alt="咨询宿舍客服" title="咨询宿舍客服"></a>
				咨询接机客服<a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=df28b70a97e2f31eaffed329873cf58385a2c10bfff7e8d9"><img border="0" src="<c:url value='/img/banner/qq.gif'/>" alt="咨询接机客服" title="咨询接机客服"></a>
			</div>
			<jsp:include page="include/homepage-slidebanner.jsp"/>
			<jsp:include page="include/homepage-infobanner.jsp"/>
			<jsp:include page="include/homepage-newslist.jsp"/>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    	<jsp:include page="/jsp/footer/footer.jsp"/>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/home.js'/>"></script>
</hostel:container>