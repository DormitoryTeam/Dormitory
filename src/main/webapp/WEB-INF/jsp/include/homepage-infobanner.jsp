<div class="row info-banner">
	<img src="<c:url value='/img/banner/banner.jpg'/>" alt/>
</div>
<div class="row">
	<div class="sidebar pull-left">
		<div class="news-box">
			<ul>
				<c:forEach var="article" items="${news}" end="6">
					<li><a href="<c:url value='/navigation/article-detail.html?id=${article.id}'/>">${article['title']}</a></li>
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
		<a href="<c:url value='/navigation/hot-cities.html?countryId=${countries[0].id}'/>" class="more">> 更多城市</a>
	</div>
	<ul class="city-list">
		<li class="active"><a href="<c:url value='/navigation/hot-cities.html?countryId=${countries[0].id}'/>">${countries[0]['name']}</a></li>
		<c:set var="count" value="0" />
		<c:forEach var="city" items="${allCities}">
			<c:if test="${city['topCity'] && count < 15}">
				<li><a href="<c:url value='/navigation/hot-cities.html?cityId=${city.id}#${city.id}'/>">${city['name_ch']}</a></li>
				<c:set var="count" value="${count + 1}" />
			</c:if>
		</c:forEach>
	</ul>
</div>
<div class="row hot-city">
	<div class="title">
		<span>公寓预定热门学校</span>
		<a href="<c:url value='/navigation/hot-colleges.html?countryId=${countries[0].id}'/>" class="more">> 更多学校</a>
	</div>
	<ul class="city-list show-list-c">
		<c:set var="count" value="0" />
		<c:forEach var="college" items="${allColleges}">
			<c:if test="${college['topCollege'] && count < 10}">
				<li><a href="<c:url value='/dormitory/dormitory-list.html?cityId=${college.cityId}&collegeId=${college.id}'/>">${college['originalName']}</a></li>
				<c:set var="count" value="${count + 1}" />
			</c:if>
		</c:forEach>
	</ul>
</div>