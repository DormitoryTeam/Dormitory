<div class="row info-banner">
	<img src="<c:url value='/img/banner/banner.jpg'/>" alt/>
</div>
<div class="row">
	<div class="sidebar pull-left">
		<div class="news-box">
			<ul>
				<c:forEach var="article" items="${news}" end="6">
					<li><a href="<c:url value='/navigation/article-detail.html?id=${article.id}&backURL=${pageContext.request.contextPath}${requestScope.javax.servlet.forward.servlet_path}'/>">${article['title']}</a></li>
				</c:forEach>
			</ul>
			<a href="<c:url value='/navigation/article-list.html?type=1'/>" class="more"> 更多</a>
		</div>
	</div>
	<div class="contentBox pull-left ml-10">
		<img src="<c:url value='/img/video/index.jpg'/>" alt/>
	</div>
</div>
<div class="row hot-city">
	<div class="title">
		<span>公寓预定热门城市</span>
		<a href="<c:url value='/navigation/navigator.html?countryId=${countries[0].id}'/>" class="more">> 更多城市</a>
	</div>
	<ul class="city-list show-list-c">
		<li class="active"><a href="<c:url value='/navigation/navigator.html?countryId=${countries[0].id}'/>">${countries[0]['name']}</a></li>
		<c:forEach var="city" items="${cities}" end="13">
			<li><a href="<c:url value='/navigation/navigator.html?cityId=${city.id}'/>">${city['name']}</a></li>
		</c:forEach>
	</ul>
</div>