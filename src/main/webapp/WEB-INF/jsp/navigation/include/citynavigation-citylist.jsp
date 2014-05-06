<div class="row">
	<%-- 
	<div class="tip pull-right">
		<span class="tip-arraw">&nbsp;</span>
		<ul>
			<li class="tip-header">&nbsp;</li>
			<li>微信二维码</li>
			<li class="text-center"><img src="<c:url value='/img/banner/webchat-bar.jpg'/>" alt /></li>
			<li>微信：@abcd</li>
			<li><a href="#">点击进入城市论坛</a></li>
			<li><a href="#">点击进入利兹大学百度贴吧</a></li>
			<li>QQ群：12345678</li>
			<li class="tip-bottom">&nbsp;</li>
		</ul>
	</div>
	--%>
	<div class="contentBox country-list-box">
		<ul class="country-list">
			<li><a href="<c:url value='/navigation/hot-colleges.html?countryId=${countries[0].id}'/>" class="more">> 切换到学校列表</a></li>
			<c:set var="size" value="${fn:length(cityColleges)}" />
			<c:forEach var="cityCollege" items="${cityColleges}"  varStatus="i">
				<li class="${cityId eq cityCollege['cityId'] ? 'open' : 'close' } ${i['count'] eq size ? 'last' : ''}">
					<div class="country-title jQ-citylist" style="text-align: left;">
						<p style="margin-left:60px;<c:if test="${fn:length(cityCollege['cityName']) > 12}">font-size: 20px;</c:if>">${cityCollege['cityName']}</p>
					</div>
					<ul class="city-list">
						<c:forEach var="college" items="${cityCollege['colleges']}">
							<li><a href="<c:url value='/dormitory/dormitory-list.html?cityId=${cityCollege.cityId}&collegeId=${college.collegeId}'/>">
									<p>${college['originalName']}</p> <span>${college['collegeName']}</span>
							</a></li>
						</c:forEach>
					</ul>
					<div class="close-line">&nbsp;</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>