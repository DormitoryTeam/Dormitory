<div class="row">
	<div class="sidebar ml-10 pull-right">
		<div class="serviceBox">
			<div class="itembar">
				<ul>
					<li>宿舍</li>
					<li>接机</li>
				</ul>
			</div>
			<div class="selectContent">
				<form name="" action="#">
					<fieldset>
						<dl>
							<dt>国家</dt>
							<dd>
								<select>
									<option value="英国">英国</option>
								</select>
							</dd>
						</dl>
						<dl>
							<dt>城市</dt>
							<dd>
								<select>
									<option value="伦敦">伦敦</option>
								</select>
							</dd>
						</dl>
						<dl class="btnBox">
							<dt>&nbsp;</dt>
							<dd>
								<input type="submit" value="搜索" class="btn-search" />
							</dd>
						</dl>
					</fieldset>
				</form>
			</div>
		</div>
		<c:if test="${sessionScope.USER_ID > 0}">
			<div class="userInfo">
				<ul>
					<li class="user-header">
						<div class="header-img-opacity">
							<img src="/dormitory/img/login/header.jpg" alt="" />
						</div>
					</li>
					<li>
						<div class="user-name">
							<a href="#">袋鼠在欧洲</a>
						</div>
						<ul class="user-links">
							<li><a href="#">我的订单</a></li>
							<li><a href="#">个人中心</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</c:if>
		<c:if test="${empty sessionScope.USER_ID}">
			<div class="login-plan">
				<ul>
					<li><a href="/dormitory/user/register.html" class="reg-btn">&nbsp;</a></li>
					<li><a href="/dormitory/user/login.html" class="login-btn">&nbsp;</a></li>
				</ul>
			</div>
		</c:if>
	</div>
	<div class="contentBox">
		<div class="sliderShow">
			<div class="sliderList">
				<c:if test="${not empty slides}">
					<c:forEach var="img" items="${slides}">
						<div class="sliderItem">
							<a href="/dormitory/upload/images/slide/${img['path']}">
								<img src="/dormitory/upload/images/slide/${img['path']}" alt="${empty img['desc'] ? img['path'] : img['desc']}" />
							</a>
							<p class="text"></p>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty slides}">
					<div class="sliderItem">
						<a href="#">
							<img src="/dormitory/img/slider/slider-img.jpg" alt=""/>
						</a> 
						<p class="text"></p>
					</div> 
				</c:if>
			</div>
			<div class="sliderPager"></div>
		</div>
	</div>
</div>