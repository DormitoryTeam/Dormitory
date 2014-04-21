<div class="row">
	<div class="tip pull-right">
		<span class="tip-arraw">&nbsp;</span>
		<ul>
			<li class="tip-header">&nbsp;</li>
			<li>微信二维码</li>
			<li class="text-center"><img src="/img/banner/webchat-bar.jpg" alt /></li>
			<li>微信：@abcd</li>
			<li><a href="#">点击进入城市论坛</a></li>
			<li><a href="#">点击进入利兹大学百度贴吧</a></li>
			<li>QQ群：12345678</li>
			<li class="tip-bottom">&nbsp;</li>
		</ul>
	</div>
	<div class="contentBox country-list-box">
		<ul class="country-list">
			<c:forEach var="cityColleges" items="${cityColleges}">
				<li class="${cityId eq cityColleges['cityId'] ? 'open' : 'close' }">
					<div class="country-title jQ-citylist">
						<p>${cityColleges['cityName']}</p>
					</div>
					<ul class="city-list">
						<c:forEach var="college" items="${cityColleges['colleges']}">
							<li><a href="/dormitory/dormitory/dormitory-list.html?cityId=${cityColleges['cityId']}&collegeId=${college['collegeId']}">
									<p>${college['collegeName']}</p> <span>${college['originalName']}</span>
							</a></li>
						</c:forEach>
					</ul>
					<div class="close-line">&nbsp;</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>