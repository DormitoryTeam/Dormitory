<div class="row myaccount">
	<jsp:include page="/jsp/main/myaccount/infoheader.jsp" />
	<div class="myaccount-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
		<jsp:include page="/jsp/main/myaccount/user/includes/myaccountLeftNav.jsp" flush="true">
		    <jsp:param name="pageName" value="info" />
		</jsp:include>
		<div id="tabs-personal" aria-labelledby="ui-id-7" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
			<div class="personal-info-tab ui-tabs ui-widget ui-widget-content ui-corner-all">
				<jsp:include page="/jsp/main/myaccount/user/includes/myaccountTopNav.jsp" flush="true">
					<jsp:param name="pageName" value="contact" />
				</jsp:include>
				<div id="tabs-data" aria-labelledby="ui-id-12" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="infoId" type="hidden" value="${user.contactPersonInfo.id}"/>
					<input name="pageStep" type="hidden" value="3"/>
					<fieldset>
						<dl>
							<dt><input id="sameas" type="checkbox"/><label>同担保人信息</label></dt>
						</dl>
						<dl>
							<dd>称呼：</dd>
							<dt>
							<select name="gender" id="gender" class="same-as" >
							<option value="0" <c:if test="${user.contactPersonInfo.gender eq 0}">selected</c:if>>Mr.</option>
							<option value="1" <c:if test="${user.contactPersonInfo.gender eq 1}">selected</c:if>>Mrs.</option>
							<option value="2" <c:if test="${user.contactPersonInfo.gender eq 2}">selected</c:if>>Miss</option>
							</select>
							</dt>
						</dl>
						<dl>
							<dd>与你的关系</dd>
							<dt><input type="text" name="relationship" id="relationship" value="${user.contactPersonInfo.relationship}" class="same-as" /> </dt>
						</dl>
						<dl>
							<dd>姓：</dd>
							<dt><input name="lastName" id="lastName" type="text" value="${user.contactPersonInfo.lastName}" class="same-as" /></dt>
						</dl>
						<dl>
							<dd>名：</dd>
							<dt><input name="name" id="name" type="text" value="${user.contactPersonInfo.name}" class="same-as" /></dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt><input name="nationality" id="nationality" type="text" value="${user.contactPersonInfo.nationality}" class="same-as" /></dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt><input name="birthday" id="birthday" type="text" value="<fmt:formatDate value='${user.contactPersonInfo.birthday}' pattern='yyyy-MM-dd'/>" class="same-as" /></dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt><input name="email" id="email" value="${user.contactPersonInfo.email}" class="same-as" /></dt>
						</dl>
						<dl>
							<dd>手机号：</dd>
							<dt><input name="phone" id="phone" type="text" value="${user.contactPersonInfo.phone}" class="same-as" /></dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt><input name="country" id="country" type="text" value="${user.contactPersonInfo.country}" class="min same-as" /> (国家)<input name="province" id="province" type="text" value="${user.contactPersonInfo.province}" class="min same-as" /> (省)<input name="city" id="city" type="text" value="${user.contactPersonInfo.city}" class="min same-as" /> (市)<input name="county" id="county" type="text" value="${user.contactPersonInfo.county}" class="min same-as" /> (区县)</dt>
						</dl>
						<dl>
							<dd>&nbsp;</dd>
							<dt>
								<input name="address" id="address" type="text" value="${user.contactPersonInfo.address}" class="larger same-as"/> (街道地址)
							</dt>
						</dl>
						<dl>
							<dd>&nbsp;</dd>
							<dt>
								<input name="postalcode" id="postalcode" type="text" value="${user.contactPersonInfo.postalcode}" class="larger same-as"/> (邮编)
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
<input id="gender_val" type="hidden" value="${user.guaranteeInfo.gender}"/>
<input id="relationship_val" type="hidden" value="${user.guaranteeInfo.relationship}"/>
<input id="name_val" type="hidden" value="${user.guaranteeInfo.name}"/>
<input id="lastName_val" type="hidden" value="${user.guaranteeInfo.lastName}"/>
<input id="nationality_val" type="hidden" value="${user.guaranteeInfo.nationality}"/>
<input id="birthday_val" type="hidden" value="<fmt:formatDate value='${user.guaranteeInfo.birthday}' pattern='yyyy-MM-dd'/>"/>
<input id="email_val" type="hidden" value="${user.guaranteeInfo.email}"/>
<input id="phone_val" type="hidden" value="${user.guaranteeInfo.phone}"/>
<input id="country_val" type="hidden" value="${user.guaranteeInfo.country}"/>
<input id="province_val" type="hidden" value="${user.guaranteeInfo.province}"/>
<input id="city_val" type="hidden" value="${user.guaranteeInfo.city}"/>
<input id="county_val" type="hidden" value="${user.guaranteeInfo.county}"/>
<input id="address_val" type="hidden" value="${user.guaranteeInfo.address}"/>
<input id="postalcode_val" type="hidden" value="${user.guaranteeInfo.postalcode}"/>
<%--


<div class="row myaccount">
    <jsp:include page="/jsp/main/myaccount/infoheader.jsp" />
    <div class="myaccount-tab">
    	<ul>
			<li><a href="#tabs-personal">个人信息</a></li>
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
					<li style="background-color: white;"><a href="#tabs-data" style="color:#32B16C;">个人资料</a></li>
					<li><a href="#tabs-data">个人偏好</a></li>
					<li style="background-color: #32B16C;"><a href="#tabs-data" style="color: white;" >担保人信息</a></li>
					<li><a href="#tabs-data">紧急联系人信息</a></li>
					<li><a href="#tabs-data">补充信息</a></li>
				</ul>
				<div id="tabs-data">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="infoId" type="hidden" value="${user.contactPersonInfo.id}"/>
					<input name="pageStep" type="hidden" value="3"/>
					<fieldset>
						<dl>
							<dt><input id="sameas" type="checkbox"/><label>同担保人信息</label></dt>
						</dl>
						<dl>
							<dd>称呼：</dd>
							<dt>
							<select name="gender">
							<option value="0" <c:if test="user.contactPersonInfo.gender eq 0">selected</c:if>>Mr.</option>
							<option value="1" <c:if test="user.contactPersonInfo.gender eq 1">selected</c:if>>Mrs.</option>
							<option value="2" <c:if test="user.contactPersonInfo.gender eq 2">selected</c:if>>Miss</option>
							</select>
							</dt>
						</dl>
						<dl>
							<dd>与你的关系</dd>
							<dt><input type="text" name="relationship" value="${user.contactPersonInfo.relationship}" /> </dt>
						</dl>
						<dl>
							<dd>姓：</dd>
							<dt><input name="lastName" type="text" value="${user.contactPersonInfo.lastName}" /></dt>
						</dl>
						<dl>
							<dd>名：</dd>
							<dt><input name="name" type="text" value="${user.contactPersonInfo.name}" /></dt>
						</dl>
						<dl>
							<dd>国籍：</dd>
							<dt><input name="nationality" type="text" value="${user.contactPersonInfo.nationality}" /></dt>
						</dl>
						<dl>
							<dd>出生日期：</dd>
							<dt><input name="birthday" type="text" value="<fmt:formatDate value='${user.contactPersonInfo.birthday}' pattern='yyyy-MM-dd'/>" /></dt>
						</dl>
						<dl>
							<dd>电子邮箱：</dd>
							<dt><input name="email" value="${user.contactPersonInfo.email}"/></dt>
						</dl>
						<dl>
							<dd>手机号：</dd>
							<dt><input name="phone" type="text" value="${user.contactPersonInfo.phone}" /></dt>
						</dl>
						<dl>
							<dd>家庭住址：</dd>
							<dt><input name="country" type="text" value="${user.contactPersonInfo.country}" class="min" /> (国家)<input name="province" type="text" value="${user.contactPersonInfo.province}" class="min" /> (省)<input name="city" type="text" value="${user.contactPersonInfo.city}" class="min" /> (市)<input name="county" type="text" value="${user.contactPersonInfo.county}" class="min" /> (区县)</dt>
						</dl>
						<dl>
							<dt>&nbsp;</dt>
							<dd>
								<input name="address" type="text" value="${user.contactPersonInfo.address}" class="larger"/> (街道地址)
							</dd>
						</dl>
						<dl>
							<dt>&nbsp;</dt>
							<dd>
								<input name="postalcode" type="text" value="${user.contactPersonInfo.postalcode}" class="mini"/> (邮编)
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