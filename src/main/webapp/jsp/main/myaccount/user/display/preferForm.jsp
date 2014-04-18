<div class="row myaccount">
	<jsp:include page="/jsp/main/myaccount/infoheader.jsp" />
	<div class="myaccount-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
		<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
			<li style="background-color: #32B16C;" class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-personal" aria-labelledby="ui-id-1" aria-selected="true"><a href="#tabs-personal" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">个人信息</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-personal" aria-labelledby="ui-id-2" aria-selected="false"><a href="<c:url value="/user/orderList.html?orderType=D"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">宿舍订单</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-personal" aria-labelledby="ui-id-3" aria-selected="false"><a href="<c:url value="/dormitory/user/orderList.html"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">接机订单</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-personal" aria-labelledby="ui-id-4" aria-selected="false"><a href="#tabs-personal" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">旅游年卡</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-personal" aria-labelledby="ui-id-5" aria-selected="false"><a href="#tabs-personal" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">导游服务</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-personal" aria-labelledby="ui-id-6" aria-selected="false"><a href="#tabs-personal" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-6">校友卡</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-personal" aria-labelledby="ui-id-7" aria-selected="false"><a href="#tabs-personal" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-7">24H安全</a></li>
		</ul>
		<div id="tabs-personal" aria-labelledby="ui-id-7" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
			<div class="personal-info-tab ui-tabs ui-widget ui-widget-content ui-corner-all">
		    	<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
					<li style="background-color: white;"  class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-data" aria-labelledby="ui-id-8" aria-selected="true"><a href="<c:url value='/user/editUserInfo.html?pageStep=0'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-8" style="color: #32B16C;">个人资料</a></li>
					<li style="background-color: #32B16C;" class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-data" aria-labelledby="ui-id-9" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=1'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-9" style="color: white;">个人偏好</a></li>
					<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-data" aria-labelledby="ui-id-10" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=2'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-10">担保人信息</a></li>
					<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-data" aria-labelledby="ui-id-11" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=3'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-11">紧急联系人信息</a></li>
					<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-data" aria-labelledby="ui-id-12" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=4'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-12">补充信息</a></li>
				</ul>
				<div id="tabs-data" aria-labelledby="ui-id-12" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="preferId" type="hidden" value="${user.prefer.id}"/>
					<input name="pageStep" type="hidden" value="1"/>
					<fieldset>
						<dl>
							<dd>您是否抽烟?</dd>
							<dt>
							<c:set var="smoke" value="${user.prefer.smoke}" />
							<c:if test="${smoke}"><label>是</label></c:if>
							<c:if test="${not smoke}"><label>否</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>您是否是素食主义者?</dd>
							<dt>
							<c:set var="vegetarianism" value="${user.prefer.vegetarianism}" />
							<c:if test="${vegetarianism}"><label>是</label></c:if>
							<c:if test="${not vegetarianism}"><label>否</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>您的年级?</dd>
							<dt>
							<c:set var="yourGrade" value="${user.prefer.yourGrade}" />
							<c:if test="${'1' eq yourGrade}"><label>大一</label></c:if>
							<c:if test="${'2' eq yourGrade}"><label>大二</label></c:if>
							<c:if test="${'3' eq yourGrade}"><label>大三</label></c:if>
							<c:if test="${'4' eq yourGrade}"><label>大四</label></c:if>
							<c:if test="${'5' eq yourGrade}"><label>硕士</label></c:if>
							<c:if test="${'6' eq yourGrade}"><label>博士</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>您想和哪个年级的人一起住?</dd>
							<dt>
							<c:set var="roomMemberGrade" value="${user.prefer.roomMemberGrade}" />
							<c:if test="${'1' eq roomMemberGrade}"><label>大一</label></c:if>
							<c:if test="${'2' eq roomMemberGrade}"><label>大二</label></c:if>
							<c:if test="${'3' eq roomMemberGrade}"><label>大三</label></c:if>
							<c:if test="${'4' eq roomMemberGrade}"><label>大四</label></c:if>
							<c:if test="${'5' eq roomMemberGrade}"><label>硕士</label></c:if>
							<c:if test="${'6' eq roomMemberGrade}"><label>博士</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>室友性别要求?</dd>
							<dt>
							<c:set var="roomMemberGender" value="${user.prefer.roomMemberGender}" />
							<c:if test="${0 eq roomMemberGender}"><label>混合性别</label></c:if>
							<c:if test="${1 eq roomMemberGender}"><label>我是男性想和所有男性一起住</label></c:if>
							<c:if test="${2 eq roomMemberGender}"><label>我是女性想和所有女性一起住</label></c:if>
							<c:if test="${3 eq roomMemberGender}"><label>无所谓</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>您的专业</dd>
							<dt>${user.prefer.major}</dt>
						</dl>
						<dl>
							<dd>学校</dd>
							<dt>${user.prefer.college}</dt>
						</dl>
						<dl>
							<dd>特殊要求</dd>
							<dt>${user.prefer.floor}</dt>
						</dl>
					</fieldset>
					<a href="#" class="modify btn-user-info-edit" gotoURL="<c:url value='/user/editUserInfo.html?command=edit&pageStep=1'/>">修改</a>
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
					<li style="background-color: white;"><a href="<c:url value='/user/editUserInfo.html?pageStep=0'/>" style="color:#32B16C;">个人资料</a></li>
					<li style="background-color: #32B16C;"><a href="#tabs-data" style="color: white;">个人偏好</a></li>
					<li><a href="<c:url value='/user/editUserInfo.html?pageStep=2'/>">担保人信息</a></li>
					<li><a href="<c:url value='/user/editUserInfo.html?pageStep=3'/>">紧急联系人信息</a></li>
					<li><a href="<c:url value='/user/editUserInfo.html?pageStep=4'/>">补充信息</a></li>
				</ul>
				<div id="tabs-data">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="preferId" type="hidden" value="${user.prefer.id}"/>
					<input name="pageStep" type="hidden" value="1"/>
					<fieldset>
						<dl>
							<dd>您是否抽烟?</dd>
							<dt>
							<c:set var="smoke" value="${user.prefer.smoke}" />
							<c:if test="${smoke}"><label>是</label></c:if>/>
							<c:if test="${not smoke}"><label>否</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>您是否是素食主义者?</dd>
							<dt>
							<c:set var="vegetarianism" value="${user.prefer.vegetarianism}" />
							<c:if test="${vegetarianism}"><label>是</label></c:if>
							<c:if test="${not vegetarianism}"><label>否</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>您的年级?</dd>
							<dt>
							<c:set var="yourGrade" value="${user.prefer.yourGrade}" />
							<c:if test="${'1' eq yourGrade}"><label>大一</label></c:if>
							<c:if test="${'2' eq yourGrade}"><label>大二</label></c:if>
							<c:if test="${'3' eq yourGrade}"><label>大三</label></c:if>
							<c:if test="${'4' eq yourGrade}"><label>大四</label></c:if>
							<c:if test="${'5' eq yourGrade}"><label>硕士</label></c:if>
							<c:if test="${'6' eq yourGrade}"><label>博士</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>您想和哪个年级的人一起住?</dd>
							<dt>
							<c:set var="roomMemberGrade" value="${user.prefer.roomMemberGrade}" />
							<c:if test="${'1' eq roomMemberGrade}"><label>大一</label></c:if>
							<c:if test="${'2' eq roomMemberGrade}"><label>大二</label></c:if>
							<c:if test="${'3' eq roomMemberGrade}"><label>大三</label></c:if>
							<c:if test="${'4' eq roomMemberGrade}"><label>大四</label></c:if>
							<c:if test="${'5' eq roomMemberGrade}"><label>硕士</label></c:if>
							<c:if test="${'6' eq roomMemberGrade}"><label>博士</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>室友性别要求?</dd>
							<dt>
							<c:set var="roomMemberGender" value="${user.prefer.roomMemberGender}" />
							<c:if test="${0 eq roomMemberGender}"><label>混合性别</label></c:if>
							<c:if test="${1 eq roomMemberGender}"><label>我是男性想和所有男性一起住</label></c:if>
							<c:if test="${2 eq roomMemberGender}"><label>我是女性想和所有女性一起住</label></c:if>
							<c:if test="${3 eq roomMemberGender}"><label>无所谓</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>您的专业</dd>
							<dt>${user.prefer.major}</dt>
						</dl>
						<dl>
							<dd>学校</dd>
							<dt>${user.prefer.college}</dt>
						</dl>
						<dl>
							<dd>特殊要求</dd>
							<dt>${user.prefer.floor}</dt>
						</dl>
					</fieldset>
					<a href="#" class="modify btn-user-info-edit" gotoURL="<c:url value='/user/editUserInfo.html?command=edit&pageStep=1'/>">修改</a>
				<form>
				</div>
			</div>
		</div>
		
    </div>
</div>
--%>