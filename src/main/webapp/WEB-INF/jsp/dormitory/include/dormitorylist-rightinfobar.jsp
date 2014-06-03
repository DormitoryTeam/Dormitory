<ul class="hostel-list-info">
	<li class="top">&nbsp;</li>
	<li class="item">
		<h2 class="favorites">我浏览过的宿舍</h2>
		<ul class="favorites-hostel-list">
			<c:forEach var="his" items="${history}" end="4" >
				<li><a href="<c:url value='/dormitory/dormitory-detail.html?id=${his.dormitoryId}'/>">${his['name']}</a></li>
			</c:forEach>
		</ul>
	</li>
	<li class="item">
		<h2>附近的大学</h2>
		<ul class="favorites-hostel-list">
			<c:forEach var="college" items="${colleges}" end="2" >
				<li><a href="<c:url value='/dormitory/dormitory-list.html?cityId=${city.id}&collegeId=${college.id}'/>">${college['originalName']}</a></li>
			</c:forEach>
		</ul>
	</li>
	<li class="item">
		<h2>附近的宿舍</h2>
		<ul class="favorites-hostel-list">
			<c:forEach var="relatedDormitory" items="${relatedDormitories}" end="2" >
				<li><a href="<c:url value='/dormitory/dormitory-detail.html?id=${relatedDormitory.id}'/>">${relatedDormitory['name']}</a></li>
			</c:forEach>
		</ul>
	</li>
	<li class="bottom">&nbsp;</li>
</ul>

<ul class="about-info">
	<li class="top">&nbsp;</li>
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
	<li class="bottom">&nbsp;</li>
</ul>