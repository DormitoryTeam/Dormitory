<div class="row">
	<div class="sidebar ml-10 pull-right">
		<div class="hot-news-list">
			<div class="title">热门信息</div>
			<ul class="news-list">
				<c:forEach var="article" items="${hotArticles}">
					<li><a href="<c:url value='/navigation/article-detail.html?id=${article.id}'/>">${article.title}</a></li>
				</c:forEach>
			</ul>
		</div>
		<ul class="about-info news">
			<li class="item">
				<h2 class="webchat">在微信上关注我们</h2>
				<p>
					<img src="<c:url value='/img/banner/webchat.jpg'/>" alt />
				</p>
			</li>
			<li class="item">
				<h2 class="aboutus">
</h2>
				<p>
					留学生活网凭借与海外公寓供应商的稳健合作关系，不仅可能帮同学们拿到公寓中一些特价、向阳以及楼层较好的房间，还能帮助大家协调喜欢的室友。而我们优质的接机服务的经验也在过去的几年得到了不断的积淀和传承。我们有能力给每一位远赴异国留学的同学提供一个更加舒适惬意的留学生活体验。
				</p>
			</li>
			<li class="item">
				<h2 class="phone">与我们联系</h2>
				<p>
					宿舍预定服务邮箱：<br />
					accommodation@liuxuelife.com<br />
					宿舍客服QQ： 2635338036<br />
					接机预定服务邮箱：<br />
					pickup@liuxuelife.com<br />
					接机客服QQ： 1550390156<br />
					中国地区客服电话：<br /> 
					0086 (0) 574 8282 2767<br />
					英国地区客服电话：<br />
					0044 (0) 740 4836 506 
				</p>
			</li>
		</ul>
	</div>
	<div class="contentBox news-info">
		<h1>${article['title']}</h1>
		<p>发布时间 : ${article['createTime']}</p>
		<div class="news-details">
			<div class="news-header">
				<c:if test="${not empty article['coverPath']}">
					<img src="<c:url value="/upload/images/articleCover/${article['id']}/${article['coverPath']}"/>" />
				</c:if>
			</div>
			<div class="news-content-text">${article['textBody']}</div>
			<div class="news-footer">
				<a href="<c:url value='/navigation/home.html'/>" class="btn-style">返回</a>
			</div>
		</div>
	</div>
</div>
