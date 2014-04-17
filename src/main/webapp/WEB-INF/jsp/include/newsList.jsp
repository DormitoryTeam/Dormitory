<div class="row">
	<div class="sidebar ml-10 pull-right">
		<ul class="about-info">
			<li class="top">&nbsp;</li>
			<li class="item">
				<h2 class="aboutus">关于我们</h2>
				<p>
					网易 (NASDAQ: NTES)是中国领先的互联网技术公司，在开发互联网应用、服务及其它技术方面，网易始终保持国内业界的领先地位。网易对中国互联网的发展具有强烈的使命感，网易利用最先进的互联网技术，加强人与人之间信息的交流和共享。
				</p>
			</li>
			<li class="item">
				<h2 class="phone">与我们联系</h2>
				<p>
					+86 010 1111111 <br />
					+86 135 0000000
				</p>
			</li>
			<li class="item">
				<h2 class="webchat">在微信上关注我们</h2>
				<p>
					<img src="/dormitory/img/banner/webchat.jpg" alt />
				</p>
			</li>
			<li class="bottom">&nbsp;</li>
		</ul>
	</div>
	<div class="contentBox">
		<div class="title">
			<span>一起去旅行</span>
		</div>
		<ul class="news-list">
			<c:forEach var="article" items="${goTravles}" end="2">
				<li class="news-itme">
					<div class="news-img pull-left">
						<img src="/dormitory/upload/images/articleCover/${article['id']}/${article['coverPath']}" />
					</div>
					<div class="news-info">
						<h2><a href="/dormitory/admin/site/article-detail.html?id=${article['id']}">${article['title']}</a></h2>
						<p>${article['textBody']}</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>