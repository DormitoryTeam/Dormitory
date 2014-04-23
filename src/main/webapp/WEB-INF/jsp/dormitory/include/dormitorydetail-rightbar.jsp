<ul class="hostel-list-info">
	<li class="top">&nbsp;</li>
	<li class="item">
		<h2 class="favorites">我浏览过的宿舍</h2>
		<ul class="favorites-hostel-list">
			<c:forEach var="his" items="${history}" end="4" >
				<li><a href="/dormitory/dormitory/dormitory-detail.html?id=${his['dormitoryId']}">${his['name']}</a></li>
			</c:forEach>
		</ul>
	</li>
	<li class="item">
		<h2>附近的大学</h2>
		<ul class="favorites-hostel-list">
			<c:forEach var="college" items="${colleges}" end="2" >
				<li><a href="/dormitory/dormitory/dormitory-list.html?cityId=${cityId}&collegeId=${college['id']}">${college['name']}</a></li>
			</c:forEach>
		</ul>
	</li>
	<li class="item">
		<h2>附近的宿舍</h2>
		<ul class="favorites-hostel-list">
			<c:forEach var="relatedDormitory" items="${relatedDormitories}" end="2" >
				<li><a href="/dormitory/dormitory/dormitory-detail.html?id=${relatedDormitory['id']}">${relatedDormitory['name']}</a></li>
			</c:forEach>
		</ul>
	</li>
	<li class="bottom">&nbsp;</li>
</ul>

<ul class="about-info">
	<li class="top">&nbsp;</li>
	<li class="item">
		<h2 class="aboutus">关于我们</h2>
		<p>网易 (NASDAQ: NTES)是中国领先的互联网技术公司，在开发互联网应用、服务及其它技术方面，网易始终保持国内业界的领先地位。网易对中国互联网的发展具有强烈的使命感，网易利用最先进的互联网技术，加强人与人之间信息的交流和共享。</p>
	</li>
	<li class="item">
		<h2 class="phone">与我们联系</h2>
		<p>
			+86 010 1111111 <br /> +86 135 0000000
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
