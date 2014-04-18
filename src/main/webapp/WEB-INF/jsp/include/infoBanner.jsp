<div class="row info-banner">
	<img src="/dormitory/img/banner/banner.jpg" alt/>
</div>
<div class="row">
	<div class="sidebar pull-left">
		<div class="news-box">
			<ul>
				<c:forEach var="article" items="${news}" end="6">
					<li><a href="/dormitory/navigation/article-detail.html?id=${article['id']}&backURL=${pageContext['request']['contextPath']}${requestScope['javax.servlet.forward.servlet_path']}">${article['title']}</a></li>
				</c:forEach>
			</ul>
			<a href="/dormitory/navigation/article-list.html?type=1" class="more"> 更多</a>
		</div>
	</div>
	<div class="contentBox pull-left ml-10">
		<img src="/dormitory/img/video/index.jpg" alt/>
	</div>
</div>
<div class="row hot-city">
	<div class="title">
		<span>公寓预定热门城市</span>
		<a href="#" class="more">> 更多城市</a>
	</div>
	<ul class="city-list">
		<li class="active"><a href="#">英国</a></li>
		<li><a href="#">伦敦</a></li>
		<li><a href="#">曼切斯特</a></li>
		<li><a href="#">布拉德福德</a></li>
		<li><a href="#">哈德斯菲尔德</a></li>
		<li><a href="#">利兹</a></li>
		<li><a href="#">谢菲尔德</a></li>
		<li><a href="#">伯明翰</a></li>
		<li><a href="#">英国</a></li>
		<li><a href="#">伦敦</a></li>
		<li><a href="#">曼切斯特</a></li>
		<li><a href="#">布拉德福德</a></li>
		<li><a href="#">哈德斯菲尔德</a></li>
		<li><a href="#">利兹</a></li>
		<li><a href="#">谢菲尔德</a></li>
		<li><a href="#">伯明翰</a></li>
	</ul>
</div>