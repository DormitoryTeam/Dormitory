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
				<h2 class="aboutus">关于我们</h2>
				<p>
					留学生活网总部位于国家级高新技术创业服务中心 - 鄞创科技孵化器， 核心团队由6名海归组成，团队成员在海外十多年的学习生活经验，对留学生住宿行业，服务行业有着更深刻的理解， 为广大留学生提供更专业，道地的生活建议， 因为懂你所以专业。
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
					<a href="<c:url value='/navigation/home.html'/>" class="btn-style">返回</a>
				</c:if>
			</div>
			<div class="news-content-text">${article['textBody']}</div>
			<div class="news-footer">
				<a href="<c:url value='/navigation/home.html'/>" class="btn-style">返回</a>
			</div>
		</div>
	</div>
</div>
