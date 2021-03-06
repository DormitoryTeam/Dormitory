<div class="row myaccount">
	<jsp:include page="/jsp/main/myaccount/infoheader.jsp" />
	<div class="myaccount-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
		<jsp:include page="/jsp/main/myaccount/user/includes/myaccountLeftNav.jsp" flush="true">
		    <jsp:param name="pageName" value="info" />
		</jsp:include>
		<div id="tabs-personal" aria-labelledby="ui-id-7" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
			<div class="personal-info-tab ui-tabs ui-widget ui-widget-content ui-corner-all">
				<jsp:include page="/jsp/main/myaccount/user/includes/myaccountTopNav.jsp" flush="true">
					<jsp:param name="pageName" value="guarantee" />
				</jsp:include>
				<div id="tabs-data" aria-labelledby="ui-id-12" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="infoId" type="hidden" value="${user.guaranteeInfo.id}"/>
					<input name="pageStep" type="hidden" value="2"/>
					<fieldset>
						<dl>
							<dd>称呼：</dd>
							<dt>
							<select name="gender">
							<option value="0" <c:if test="${user.guaranteeInfo.gender eq 0}">selected</c:if>>Mr.</option>
							<option value="1" <c:if test="${user.guaranteeInfo.gender eq 1}">selected</c:if>>Mrs.</option>
							<option value="2" <c:if test="${user.guaranteeInfo.gender eq 2}">selected</c:if>>Miss</option>
							</select>
							</dt>
						</dl>
						<dl>
							<dd>与你的关系</dd>
							<dt><input type="text" name="relationship" value="${user.guaranteeInfo.relationship}" /> </dt>
						</dl>
						<dl>
							<dd>姓：</dd>
							<dt><input name="lastName" type="text" value="${user.guaranteeInfo.lastName}" class="min validate" errorFieldName="姓"/></dt>
						</dl>
						<dl>
							<dd>名：</dd>
							<dt><input name="name" type="text" value="${user.guaranteeInfo.name}" class="min validate" errorFieldName="名" /></dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt><input name="nationality" type="text" value="${user.guaranteeInfo.nationality}" class="validate" errorFieldName="国籍" /></dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt><input class="datepicker validate" errorFieldName="出生日期" name="birthday" type="text" value="<fmt:formatDate value='${user.guaranteeInfo.birthday}' pattern='yyyy-MM-dd'/>" /></dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt><input name="email" value="${user.guaranteeInfo.email}" class="long validate" errorFieldName="电子邮件" /></dt>
						</dl>
						<dl>
							<dd>手机号码：</dd>
							<dt><input name="phone" type="text" value="${user.guaranteeInfo.phone}" class="validate" errorFieldName="手机号码" /></dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt><input name="country" type="text" value="${user.guaranteeInfo.country}" class="min validate" errorFieldName="国家" />&nbsp;(国家)&nbsp;<input name="province" type="text" value="${user.guaranteeInfo.province}" class="min validate" errorFieldName="省" />&nbsp;(省)&nbsp;<input name="city" type="text" value="${user.guaranteeInfo.city}" class="min validate" errorFieldName="市" />&nbsp;(市)&nbsp;<input name="county" type="text" value="${user.guaranteeInfo.county}" class="min validate" errorFieldName="区县" />&nbsp;(区县)</dt>
						</dl>
						<dl>
							<dd>&nbsp;</dd>
							<dt>
								<input name="address" type="text" value="${user.guaranteeInfo.address}" class="larger validate" errorFieldName="街道地址" />&nbsp;(街道地址)
							</dt>
						</dl>
						<dl>
							<dd>&nbsp;</dd>
							<dt>
								<input name="postalcode" type="text" value="${user.guaranteeInfo.postalcode}" class="mini validate" errorFieldName="邮编"/>&nbsp;(邮编)
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
					<li style="background-color: white;"><a href="#tabs-data"style="color: #32B16C;">个人资料</a></li>
					<li><a href="#tabs-data">个人偏好</a></li>
					<li style="background-color: #32B16C;"><a href="#tabs-data" style="color: white;">担保人信息</a></li>
					<li><a href="#tabs-data">紧急联系人信息</a></li>
					<li><a href="#tabs-data">补充信息</a></li>
				</ul>
				<div id="tabs-data">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="infoId" type="hidden" value="${user.guaranteeInfo.id}"/>
					<input name="pageStep" type="hidden" value="2"/>
					<fieldset>
						<dl>
							<dd>称呼：</dd>
							<dt>
							<select name="gender">
							<option value="0" <c:if test="user.guaranteeInfo.gender eq 0">selected</c:if>>Mr.</option>
							<option value="1" <c:if test="user.guaranteeInfo.gender eq 1">selected</c:if>>Mrs.</option>
							<option value="2" <c:if test="user.guaranteeInfo.gender eq 2">selected</c:if>>Miss</option>
							</select>
							</dt>
						</dl>
						<dl>
							<dd>与你的关系</dd>
							<dt><input type="text" name="relationship" value="${user.guaranteeInfo.relationship}" /> </dt>
						</dl>
						<dl>
							<dd>姓：</dd>
							<dt><input name="lastName" type="text" value="${user.guaranteeInfo.lastName}" /></dt>
						</dl>
						<dl>
							<dd>名：</dd>
							<dt><input name="name" type="text" value="${user.guaranteeInfo.name}" /></dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt><input name="nationality" type="text" value="${user.guaranteeInfo.nationality}" /></dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt><input name="birthday" type="text" value="<fmt:formatDate value='${user.guaranteeInfo.birthday}' pattern='yyyy-MM-dd'/>" /></dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt><input name="email" value="${user.guaranteeInfo.email}"/></dt>
						</dl>
						<dl>
							<dd>手机号：</dd>
							<dt><input name="phone" type="text" value="${user.guaranteeInfo.phone}" /></dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt><input name="country" type="text" value="${user.guaranteeInfo.country}" class="min" /> (国家)<input name="province" type="text" value="${user.guaranteeInfo.province}" class="min" /> (省)<input name="city" type="text" value="${user.guaranteeInfo.city}" class="min" /> (市)<input name="county" type="text" value="${user.guaranteeInfo.county}" class="min" /> (区县)</dt>
						</dl>
						<dl>
							<dt>&nbsp;</dt>
							<dd>
								<input name="address" type="text" value="${user.guaranteeInfo.address}" class="larger"/> (街道地址)
							</dd>
						</dl>
						<dl>
							<dt>&nbsp;</dt>
							<dd>
								<input name="postalcode" type="text" value="${user.guaranteeInfo.postalcode}" class="mini"/> (邮编)
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