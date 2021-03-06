<div class="row myaccount">
	<jsp:include page="/jsp/main/myaccount/infoheader.jsp" />
	<div class="myaccount-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
		<jsp:include page="/jsp/main/myaccount/user/includes/myaccountLeftNav.jsp" flush="true">
		    <jsp:param name="pageName" value="info" />
		</jsp:include>
		<div id="tabs-personal" aria-labelledby="ui-id-7" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
			<div class="personal-info-tab ui-tabs ui-widget ui-widget-content ui-corner-all">
		    	<jsp:include page="/jsp/main/myaccount/user/includes/myaccountTopNav.jsp" flush="true">
					<jsp:param name="pageName" value="userInfo" />
				</jsp:include>
				<div id="tabs-data" aria-labelledby="ui-id-12" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="infoId" type="hidden" value="${user.info.id}"/>
					<fieldset>
						<dl>
							<dd>称呼：</dd>
							<dt>
							<c:if test="${user.info.gender eq 0}">Mr.</c:if>
							<c:if test="${user.info.gender eq 1}">Mrs.</c:if>
							<c:if test="${user.info.gender eq 2}">Miss</c:if>
							</dt>
						</dl>
						<dl>
							<dd>姓：</dd>
							<dt>${user.info.lastName}</dt>
						</dl>
						<dl>
							<dd>名：</dd>
							<dt>${user.info.name}</dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt>${user.info.nationality}</dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt><fmt:formatDate value='${user.info.birthday}' pattern='yyyy-MM-dd'/></dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt>${user.info.email}</dt>
						</dl>
						<dl>
							<dd>QQ：</dd>
							<dt>${user.info.qq}</dt>
						</dl>
						<dl>
							<dd>微信号：</dd>
							<dt>${user.info.wechat}</dt>
						</dl>
						<dl>
							<dd>手机号：</dd>
							<dt>${user.info.phone}</dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt>${user.info.country}${user.info.province}${user.info.city}${user.info.county}</dt>
						</dl>
						<dl>
							<dd>&nbsp;</dd>
							<dt>
								${user.info.address} 
							</dt>
						</dl>
						<dl>
							<dd>邮编：</dd>
							<dt>
								${user.info.postalcode}
							</dt>
						</dl>
					</fieldset>
					<a href="#" class="modify btn-user-info-edit" gotoURL="<c:url value='/user/editUserInfo.html?command=edit&pageStep=0'/>">修改</a>
				<form>
				</div>
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
			<div class="personal-info-tab">
		    	<ul>
					<li style="background-color: #32B16C;"><a href="#tabs-data">个人资料</a></li>
					<li><a href="<c:url value='/user/editUserInfo.html?pageStep=1'/>">个人偏好</a></li>
					<li><a href="<c:url value='/user/editUserInfo.html?pageStep=2'/>">担保人信息</a></li>
					<li><a href="<c:url value='/user/editUserInfo.html?pageStep=3'/>">紧急联系人信息</a></li>
					<li><a href="<c:url value='/user/editUserInfo.html?pageStep=4'/>">补充信息</a></li>
				</ul>
				<div id="tabs-data">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="infoId" type="hidden" value="${user.info.id}"/>
					<fieldset>
						<dl>
							<dd>称呼：</dd>
							<dt>
							<c:if test="${user.info.gender eq 0}">Mr.</c:if>
							 <c:if test="${user.info.gender eq 1}">Mrs.</c:if>
							<c:if test="${user.info.gender eq 2}">Miss</c:if>
							</dt>
						</dl>
						<dl>
							<dd>姓：</dd>
							<dt>${user.info.lastName}</dt>
						</dl>
						<dl>
							<dd>名：</dd>
							<dt>${user.info.name}</dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt>${user.info.nationality}</dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt><fmt:formatDate value='${user.info.birthday}' pattern='yyyy-MM-dd'/></dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt>${user.info.email}</dt>
						</dl>
						<dl>
							<dd>QQ：</dd>
							<dt>${user.info.qq}</dt>
						</dl>
						<dl>
							<dd>微信号：</dd>
							<dt>${user.info.wechat}</dt>
						</dl>
						<dl>
							<dd>手机号：</dd>
							<dt>${user.info.phone}</dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt>${user.info.country}${user.info.province}${user.info.city}${user.info.county}</dt>
						</dl>
						<dl>
							<dt>&nbsp;</dt>
							<dd>
								${user.info.address} 
							</dd>
						</dl>
						<dl>
							<dt>邮编</dt>
							<dd>
								${user.info.postalcode}
							</dd>
						</dl>
					</fieldset>
					<a href="#" class="modify btn-user-info-edit" gotoURL="<c:url value='/user/editUserInfo.html?command=edit&pageStep=0'/>">修改</a>
				<form>
				</div>
			</div>
		</div>
		
    </div>
</div>
--%>