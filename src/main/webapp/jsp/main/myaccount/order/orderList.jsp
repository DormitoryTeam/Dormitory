<%@ taglib uri="/dormitory" prefix="dor"%>
<div class="row myaccount">
    <jsp:include page="/jsp/main/myaccount/infoheader.jsp" />
    <div class="myaccount-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
    	<c:choose>
			<c:when test='${"D" eq type}'>
    	<jsp:include page="/jsp/main/myaccount/user/includes/myaccountLeftNav.jsp" flush="true">
			<jsp:param name="pageName" value="order" />
		</jsp:include>
		</c:when>
		<c:otherwise>
		<jsp:include page="/jsp/main/myaccount/user/includes/myaccountLeftNav.jsp" flush="true">
			<jsp:param name="pageName" value="pickup" />
		</jsp:include>
		</c:otherwise>
		</c:choose>
		<div id="tabs-house" aria-labelledby="ui-id-2" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: block;" aria-expanded="true" aria-hidden="false">
			<div style="margin-bottom: 5px;"><span style="color:red;font-weight:bolder;">提示：</span>鼠标移到订单号上显示订单进度</div>
			<div class="order-list">
				<ul class="list-header">
					<li class="order-id">订单号</li>
					<li class="order-author">预定人</li>
					<li class="order-time">预定日期</li>
					<c:choose>
					<c:when test='${"D" eq type}'>
					<li class="name">宿舍名称</li>
					</c:when>
					<c:otherwise>
					<li class="name">航班号</li>
					</c:otherwise>
					</c:choose>
					<li class="order-price">订单金额</li>
					<li class="order-active">操作</li>
				</ul>
				<c:forEach var="order" items="${orders}" varStatus="i">
				<ul>
					<li class="order-id">
						<a href="#"><dor:getOrderToken orderId="${order.id}" /></a>
						<div class="progress-content">
							<div class="title">订单进度</div>
							<ul class="progress">
								<li class="first <c:if test="${order.orderStatus == 'INITIAL'}">wait</c:if><c:if test="${order.orderStatus == 'COMMIT'}">complete</c:if><c:if test="${order.orderStatus != 'INITIAL' and order.orderStatus != 'COMMIT'}">complete</c:if>">
									<div class="num">1</div>
									<div class="progress-tip">申请已提交</div>
								</li>
								<li class="second <c:if test="${order.orderStatus == 'INITIAL' or  order.orderStatus == 'COMMIT'}">wait</c:if><c:if test="${order.orderStatus == 'REVIEWDE'}">complete</c:if><c:if test="${order.orderStatus == 'SENDING_CONTACT' or order.orderStatus == 'DONE'}">complete</c:if>">
									<div class="num">2</div>
									<div class="progress-tip">审核中</div>
								</li>
								<li class="third <c:if test="${order.orderStatus == 'INITIAL' or  order.orderStatus == 'COMMIT' or order.orderStatus == 'REVIEWDE' }">wait</c:if><c:if test="${order.orderStatus == 'SENDING_CONTACT'}">complete</c:if><c:if test="${order.orderStatus == 'DONE'}">complete</c:if>">
									<div class="num">3</div>
									<div class="progress-tip">合同发送</div>
								</li>
							</ul>
						</div>
					</li>
					<li class="order-author">${order.user.login}</li>
					<li class="order-time"><fmt:formatDate value='${order.createTime}' pattern='yyyy-MM-dd'/></li>
					<c:choose>
					<c:when test='${"D" eq type}'>
					<li class="name">${order.lineItems[0].dormitory.name}</li>
					</c:when>
					<c:otherwise>
					<li class="name">${order.lineItems[0].flightNum}</li>
					</c:otherwise>
					</c:choose>
					<li class="order-price"><c:if test="${order.amount >= 0}">&#163;<fmt:formatNumber value="${order.amount}" pattern="#0.00"/></c:if><c:if test="${order.amount < 0}">暂未定价</c:if></li>
					<c:choose>
					<c:when test='${"D" eq type}'>
					<li class="order-active"><a href="<c:url value="/order/view-order.html?orderId=${order.id}"/>">查看</a><c:if test="${order.orderStatus == 'INITIAL' or  order.orderStatus == 'COMMIT'}">|<a href="<c:url value="/order/dormitory-place-order.html?orderId=${order.id}"/>">修改</a><!--|<a href="#">取消</a>--></c:if></li>
					</c:when>
					<c:otherwise>
					<li class="order-active"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&orderType=pickup"/>">查看</a><c:if test="$order.orderStatus == 'INITIAL' or  order.orderStatus == 'COMMIT'}">|<a href="<c:url value="/order/dormitory-place-order.html?orderId=${order.id}&orderType=pickup"/>">修改</a><!--|<a href="#">取消</a>--></c:if></li>
					</c:otherwise>
					</c:choose>
					
				</ul>
				</c:forEach>
			</div>
			<div class="row pager" style="margin-top: 15px;">
			<jsp:include page="/jsp/utils/pagination.jsp" flush="true">
				<jsp:param name="pageName" value="myaccount"/>
			</jsp:include>
			</div>
			<div class="order-list-tip">
				<p>订单处理时，可随时拨打以下电话与我们联系</p>
  				<p>联系电话：010-12345678</p>
			</div>
		</div>
    </div>
</div>
<%--
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
					<li class="order-price"><c:if test="${order.amount >=0 }">&#163;<fmt:formatNumber value="${order.amount}" pattern="#0.00"/></c:if><c:if test="${order.amount < 0}">暂未定价</c:if></li>
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

--%>