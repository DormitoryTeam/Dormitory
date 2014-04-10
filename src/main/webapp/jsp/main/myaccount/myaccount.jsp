<div class="row myaccount">
    <jsp:include page="infoheader.jsp" />
    <div class="myaccount-tab">
    	<ul>
			<li><a href="#tabs-personal">个人信息</a></li>
			<li><a href="#tabs-house">宿舍订单</a></li>
			<li><a href="#tabs-air">接机订单</a></li>
			<li><a href="#tabs-tour">旅游年卡</a></li>
			<li><a href="#tabs-guide">导游服务</a></li>
			<li><a href="#tabs-alumni">校友卡</a></li>
			<li><a href="#tabs-safe">24H安全</a></li>
		</ul>
		<div id="tabs-personal">
			<div class="personal-info-tab">
		    	<ul>
					<li><a href="#tabs-data">个人资料</a></li>
					<li><a href="#tabs-preference">个人偏好</a></li>
					<li><a href="#tabs-warrantor">担保人信息</a></li>
					<li><a href="#tabs-emergency">紧急联系人信息</a></li>
					<li><a href="#tabs-additional">补充信息</a></li>
				</ul>
				<div id="tabs-data">
					<fieldset>
						<dl>
							<dd>称呼：</dd>
							<dt>Mr</dt>
						</dl>
						<dl>
							<dd>姓名：</dd>
							<dt>袋鼠在中国</dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt>中国</dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt>1990.01.01</dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt>xxx@163.com</dt>
						</dl>
						<dl>
							<dd>QQ：</dd>
							<dt>12346579</dt>
						</dl>
						<dl>
							<dd>微信号：</dd>
							<dt>12456</dt>
						</dl>
						<dl>
							<dd>手机号：</dd>
							<dt>124567890</dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt>四川成都</dt>
						</dl>
					</fieldset>
					<a href="#" class="modify">修改个人信息</a>
				</div>
				<div id="tabs-preference">
					个人偏好
				</div>
				<div id="tabs-warrantor">
					担保人信息
				</div>
				<div id="tabs-emergency">
					紧急联系人信息
				</div>
				<div id="tabs-additional">
					补充信息
				</div>
			</div>
		</div>
		<div id="tabs-house">
			<div class="order-list">
				<ul class="list-header">
					<li class="order-id">订单号</li>
					<li class="order-author">预定人</li>
					<li class="order-time">预定日期</li>
					<li class="name">宿舍名称</li>
					<li class="order-price">订单金额</li>
					<li class="order-active">操作</li>
				</ul>
				<ul>
					<li class="order-id">
						<a href="#">001</a>
						<div class="progress-content">
							<div class="title">订单进度</div>
							<ul class="progress">
								<li class="first complete">
									<div class="num">1</div>
									<div class="progress-tip">申请已提交</div>
								</li>
								<li class="second now">
									<div class="num">2</div>
									<div class="progress-tip">审核中</div>
								</li>
								<li class="third wait">
									<div class="num">3</div>
									<div class="progress-tip">合同发送</div>
								</li>
							</ul>
						</div>
					</li>
					<li class="order-author">袋鼠在欧洲</li>
					<li class="order-time">2014.01.01</li>
					<li class="name">The Pad</li>
					<li class="order-price">&#163;106</li>
					<li class="order-active"><a href="#">查看</a>|<a href="#">修改</a>|<a href="#">取消</a></li>
				</ul>
				<ul>
					<li class="order-id">
						<a href="#">001</a>
						<div class="progress-content">
							<div class="title">订单进度</div>
							<ul class="progress">
								<li class="first now">
									<div class="num">1</div>
									<div class="progress-tip">申请已提交</div>
								</li>
								<li class="second wait">
									<div class="num">2</div>
									<div class="progress-tip">审核中</div>
								</li>
								<li class="third wait">
									<div class="num">3</div>
									<div class="progress-tip">合同发送</div>
								</li>
							</ul>
						</div>
					</li>
					<li class="order-author">袋鼠在欧洲</li>
					<li class="order-time">2014.01.01</li>
					<li class="name">The Pad</li>
					<li class="order-price">&#163;106</li>
					<li class="order-active"><a href="#">查看</a>|<a href="#">修改</a>|<a href="#">取消</a></li>
				</ul>
			</div>
			<div class="order-list-tip">
				<p>订单处理时，可随时拨打以下电话与我们联系</p>
  				<p>联系电话：010-12345678</p>
			</div>
		</div>
		<div id="tabs-air">
			<div class="order-list air-list">
				<ul class="list-header">
					<li class="order-id">订单号</li>
					<li class="order-author">预定人</li>
					<li class="order-airid">航班号</li>
					<li class="order-time">航班日期</li>
					<li class="name">班车时间</li>
					<li class="order-price">同行人员</li>
					<li class="order-active">操作</li>
				</ul>
				<ul>
					<li class="order-id">
						<a href="#">001</a>
						<div class="progress-content">
							<div class="title">订单进度</div>
							<ul class="progress">
								<li class="first complete">
									<div class="num">1</div>
									<div class="progress-tip">申请已提交</div>
								</li>
								<li class="second now">
									<div class="num">2</div>
									<div class="progress-tip">审核中</div>
								</li>
								<li class="third wait">
									<div class="num">3</div>
									<div class="progress-tip">合同发送</div>
								</li>
							</ul>
						</div>
					</li>
					<li class="order-author">袋鼠在欧洲</li>
					<li class="order-airid">CA1111</li>
					<li class="order-time">2014.01.01</li>
					<li class="name">2014.01.01<br> 17:30</li>
					<li class="order-price">张三<br>李四<br>王五</li>
					<li class="order-active"><a href="#">查看</a>|<a href="#">修改</a>|<a href="#">取消</a></li>
				</ul>
				<ul>
					<li class="order-id">
						<a href="#">001</a>
						<div class="progress-content">
							<div class="title">订单进度</div>
							<ul class="progress">
								<li class="first complete">
									<div class="num">1</div>
									<div class="progress-tip">申请已提交</div>
								</li>
								<li class="second now">
									<div class="num">2</div>
									<div class="progress-tip">审核中</div>
								</li>
								<li class="third wait">
									<div class="num">3</div>
									<div class="progress-tip">合同发送</div>
								</li>
							</ul>
						</div>
					</li>
					<li class="order-author">袋鼠在欧洲</li>
					<li class="order-airid">CA1111</li>
					<li class="order-time">2014.01.01</li>
					<li class="name">2014.01.01<br> 17:30</li>
					<li class="order-price">张三<br>李四<br>王五</li>
					<li class="order-active"><a href="#">查看</a>|<a href="#">修改</a>|<a href="#">取消</a></li>
				</ul>
			</div>
			<div class="order-list-tip">
				<p>订单处理时，可随时拨打以下电话与我们联系</p>
  				<p>联系电话：010-12345678</p>
  				<p>接机QQ群号：123456789</p>
  				<p>接机微信账号：xxx</p>
			</div>
		</div>
		<div id="tabs-tour">
			旅游年卡
		</div>
		<div id="tabs-guide">
			导游服务
		</div>
		<div id="tabs-alumni">
			校友卡
		</div>
		<div id="tabs-safe">
			24H安全
		</div>
    </div>
</div>