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
					<li style="background-color: #32B16C;" class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-data" aria-labelledby="ui-id-8" aria-selected="true"><a href="<c:url value='/user/editUserInfo.html?pageStep=0'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-8">个人资料</a></li>
					<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-data" aria-labelledby="ui-id-9" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=1'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-9">个人偏好</a></li>
					<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-data" aria-labelledby="ui-id-10" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=2'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-10">担保人信息</a></li>
					<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-data" aria-labelledby="ui-id-11" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=3'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-11">紧急联系人信息</a></li>
					<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-data" aria-labelledby="ui-id-12" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=4'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-12">补充信息</a></li>
				</ul>
				<div id="tabs-data" aria-labelledby="ui-id-12" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="infoId" type="hidden" value="${user.info.id}"/>
					<fieldset>
						<dl>
							<dd>称呼：</dd>
							<dt>
							<select name="gender">
							<option value="0" <c:if test="${user.info.gender eq 0}">selected</c:if>>Mr.</option>
							<option value="1" <c:if test="${user.info.gender eq 1}">selected</c:if>>Mrs.</option>
							<option value="2" <c:if test="${user.info.gender eq 2}">selected</c:if>>Miss</option>
							</select>
							</dt>
						</dl>
						<dl>
							<dd>姓：</dd>
							<dt><input name="lastName" type="text" value="${user.info.lastName}" /></dt>
						</dl>
						<dl>
							<dd>名：</dd>
							<dt><input name="name" type="text" value="${user.info.name}" /></dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt><input name="nationality" type="text" value="${user.info.nationality}" /></dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt><input name="birthday" type="text" value="<fmt:formatDate value='${user.info.birthday}' pattern='yyyy-MM-dd'/>" /></dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt><input name="email" value="${user.info.email}"/></dt>
						</dl>
						<dl>
							<dd>QQ：</dd>
							<dt><input name="qq" type="text" value="${user.info.qq}" /></dt>
						</dl>
						<dl>
							<dd>微信号：</dd>
							<dt><input name="wechat" type="text" value="${user.info.wechat}" /></dt>
						</dl>
						<dl>
							<dd>手机号：</dd>
							<dt><input name="phone" type="text" value="${user.info.phone}" /></dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt><input name="country" type="text" value="${user.info.country}" class="min" /> (国家)<input name="province" type="text" value="${user.info.province}" class="min" /> (省)<input name="city" type="text" value="${user.info.city}" class="min" /> (市)<input name="county" type="text" value="${user.info.county}" class="min" /> (区县)</dt>
						</dl>
						<dl>
							<dd>&nbsp;</dd>
							<dt>
								<input name="address" type="text" value="${user.info.address}" class="larger"/> (街道地址)
							</dt>
						</dl>
						<dl>
							<dd>&nbsp;</dd>
							<dt>
								<input name="postalcode" type="text" value="${user.info.postalcode}" class="larger"/> (邮编)
							</dt>
						</dl>
					</fieldset>
					<a href="#" class="modify btn-user-info-save">完成</a>
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
					<li><a href="#tabs-data">个人偏好</a></li>
					<li><a href="#tabs-data">担保人信息</a></li>
					<li><a href="#tabs-data">紧急联系人信息</a></li>
					<li><a href="#tabs-data">补充信息</a></li>
				</ul>
				<div id="tabs-data">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="infoId" type="hidden" value="${user.info.id}"/>
					<fieldset>
						<dl>
							<dd>称呼：</dd>
							<dt>
							<select name="gender">
							<option value="0" <c:if test="user.info.gender eq 0">selected</c:if>>Mr.</option>
							<option value="1" <c:if test="user.info.gender eq 1">selected</c:if>>Mrs.</option>
							<option value="2" <c:if test="user.info.gender eq 2">selected</c:if>>Miss</option>
							</select>
							</dt>
						</dl>
						<dl>
							<dd>姓：</dd>
							<dt><input name="lastName" type="text" value="${user.info.lastName}" /></dt>
						</dl>
						<dl>
							<dd>名：</dd>
							<dt><input name="name" type="text" value="${user.info.name}" /></dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt><input name="nationality" type="text" value="${user.info.nationality}" /></dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt><input name="birthday" type="text" value="<fmt:formatDate value='${user.info.birthday}' pattern='yyyy-MM-dd'/>" /></dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt><input name="email" value="${user.info.email}"/></dt>
						</dl>
						<dl>
							<dd>QQ：</dd>
							<dt><input name="qq" type="text" value="${user.info.qq}" /></dt>
						</dl>
						<dl>
							<dd>微信号：</dd>
							<dt><input name="wechat" type="text" value="${user.info.wechat}" /></dt>
						</dl>
						<dl>
							<dd>手机号：</dd>
							<dt><input name="phone" type="text" value="${user.info.phone}" /></dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt><input name="country" type="text" value="${user.info.country}" class="min" /> (国家)<input name="province" type="text" value="${user.info.province}" class="min" /> (省)<input name="city" type="text" value="${user.info.city}" class="min" /> (市)<input name="county" type="text" value="${user.info.county}" class="min" /> (区县)</dt>
						</dl>
						<dl>
							<dt>&nbsp;</dt>
							<dd>
								<input name="address" type="text" value="${user.info.address}" class="larger"/> (街道地址)
							</dd>
						</dl>
						<dl>
							<dt>&nbsp;</dt>
							<dd>
								<input name="postalcode" type="text" value="${user.info.postalcode}" class="larger"/> (邮编)
							</dd>
						</dl>
					</fieldset>
					<a href="#" class="modify btn-user-info-save">完成</a>
				<form>
				</div>
			</div>
		</div>
		
    </div>
</div>
--%>