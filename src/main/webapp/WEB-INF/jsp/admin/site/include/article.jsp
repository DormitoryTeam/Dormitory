<div class="row">
	<div class="sidebar ml-10 pull-right">
		<div class="hot-news-list">
			<div class="title">热门信息</div>
			<ul class="news-list">
				<li><a href="#">预订宿舍免费接机</a></li>
				<li><a href="#">国内免费寄送新生大礼包</a></li>
				<li><a href="#">预订宿舍免费接机</a></li>
				<li><a href="#">国内免费寄送新生大礼包</a></li>
				<li><a href="#">预订宿舍免费接机</a></li>
				<li><a href="#">预订宿舍免费接机</a></li>
				<li class="last"><a href="#">国内免费寄送新生大礼包</a></li>
			</ul>
		</div>
		<ul class="about-info news">
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
		</ul>
	</div>
	<div class="contentBox news-info">
		<h1>${article['title']}</h1>
		<p>发布时间 : ${article['createTime']}</p>
		<div class="news-details">
			<div class="news-header">
				<c:if test="${not empty article['coverPath']}">
					<img src="/dormitory/upload/images/articleCover/${article['id']}/${article['coverPath']}" />
					<a href="#" class="btn-style">宿舍预定</a>
				</c:if>
			</div>
			<div class="news-content-text">${article['textBody']}</div>
		</div>
	</div>
</div>