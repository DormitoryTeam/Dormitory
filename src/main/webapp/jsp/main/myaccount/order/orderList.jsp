<div class="row myaccount">
    <jsp:include page="/jsp/main/myaccount/infoheader.jsp" />
    <div class="myaccount-tab">
    	<ul>
			<li style="background-color: #32B16C;"><a href="#tabs-personal">个人信息</a></li>
			<li><a href="#tabs-personal">宿舍订单</a></li>
			<li><a href="#tabs-personal">接机订单</a></li>
			<li><a href="#tabs-personal">旅游年卡</a></li>
			<li><a href="#tabs-personal">导游服务</a></li>
			<li><a href="#tabs-personal">校友卡</a></li>
			<li><a href="#tabs-personal">24H安全</a></li>
		</ul>
		<div id="tabs-personal">
			<div class="personal-info-tab">
		    	<ul>
					<li style="background-color: #32B16C;"><a href="#tabs-data">个人资料</a></li>
					<li><a href="#tabs-data">个人偏好</a></li>
					<li><a href="#tabs-data">担保人信息</a></li>
					<li><a href="#tabs-data">紧急联系人信息</a></li>
					<li><a href="#tabs-data">补充信息</a></li>
				</ul>
				<div id="tabs-data">
					<div class="order-list">
						<ul class="list-header">
							<li class="order-id">订单号</li>
							<li class="order-author">预定人</li>
							<li class="order-time">预定日期</li>
							<li class="name">宿舍名称</li>
							<li class="order-price">订单金额</li>
							<li class="order-active">操作</li>
						</ul>
						<c:forEach var="order" items="${orders}" varStatus="i">
						<ul>
							<li class="order-id">
								<a href="#">${order.id}</a>
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
							<li class="order-author">${order.user.login}</li>
							<li class="order-time">${order.createTime}</li>
							<li class="name">${order.lineItems[0].dormitory.name}</li>
							<li class="order-price">&#163;${order.amount}</li>
							<li class="order-active"><a href="#">查看</a>|<a href="<c:url value="/order/dormitory-place-order.html?orderId=${order.id}"/>">修改</a>|<a href="#">取消</a></li>
						</ul>
						</c:forEach>
					</div>
					<div class="order-list-tip">
						<p>订单处理时，可随时拨打以下电话与我们联系</p>
		  				<p>联系电话：010-12345678</p>
					</div>
				</div>
			</div>
		</div>
		
    </div>
</div>