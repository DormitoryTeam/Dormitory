<% String isLogin = request.getParameter("login"); %>
<%
	if ("1".equals(isLogin)){
	}
%>
<div class="row">
	<div class="sidebar ml-10 pull-right">
		<div class="serviceBox">
			<div class="itembar">
				<ul>
					<li>
						宿舍
					</li>
					<li>
						接机
					</li>
				</ul>	
			</div>
			<div class="selectContent">
				<form name="" action="#">
					<fieldset>
						<dl>
							<dt>
								国家
							</dt>
							<dd>
								<select>
									<option value="英国">英国</option>
								</select>
							</dd>
						</dl>
						<dl>
							<dt>
								城市
							</dt>
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
		<%
		if ("1".equals(isLogin)){
		%>
			<div class="userInfo">
				<ul>
					<li class="user-header">
						<div class="header-img-opacity">
							<img src="../data/hostel/images/login/header.jpg" alt="" />
						</div>
					</li>
					<li>
						<div class="user-name">
							<a href="#">袋鼠在欧洲</a>
						</div>
						<ul class="user-links">
							<li>
								<a href="#">我的订单</a>
							</li>
							<li>
								<a href="#">个人中心</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		<%}else{%>
			<div class="login-plan">
				<ul>
					<li>
						<a href="#" class="reg-btn">&nbsp;</a>
					</li>
					<li>
						<a href="#" class="login-btn">&nbsp;</a>
					</li>
				</ul>
			</div>
		<%}%>
	</div>
	<div class="contentBox">
		<div class="sliderShow">
			<div class="sliderList">
				<div class="sliderItem">
						<a href="#">
							<img src="../data/hostel/images/slider/slider-img.jpg" alt=""/>
						</a> 
					<p class="text"></p>
				</div> 
				<div class="sliderItem">
						<a href="#">
							<img src="../data/hostel/images/slider/slider-img.jpg" alt=""/>
						</a> 
					<p class="text"></p>
				</div> 
			</div>
			<div class="sliderPager"></div>
		</div>
	</div>
</div>