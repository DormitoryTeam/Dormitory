<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
	<div class="tip-text">
		2014年接机名额还剩1000个
	</div>
		<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
		<input type="hidden" name="pageStep" value="0" />
		<input type="hidden" name="command" id="command"/>
		<input type="hidden" name="orderType" value="${orderType}"/>
		<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
		<input type="hidden" name="contractId" value="${price.contractId}" /> 
		<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
		<input name="infoId" type="hidden" value="${order.orderContact.belongsToInfo.id}"/>
		<a class="addOne" href="<c:url value="/order/dormitory-place-order.html?orderType=pickup"/>">&nbsp;</a>
		<div class="btnBox">
			<input type="button" value="保存" class="save btn-place-order-save">
		</div>
		<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
			<li class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-personal" aria-labelledby="ui-id-1" aria-selected="true"><a href="#tabs-personal" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">个人信息</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-hobby" aria-labelledby="ui-id-2" aria-selected="false"><a href="#tabs-hobby" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">航班信息</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-security" aria-labelledby="ui-id-3" aria-selected="false"><a href="#tabs-security" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">送达地址</a></li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-additional" aria-labelledby="ui-id-4" aria-selected="false"><a href="#tabs-additional" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">补充信息</a></li>
		</ul>
		<div id="tabs-personal" aria-labelledby="ui-id-1" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
			<fieldset>
				<dl>
					<dt>称呼</dt>
					<dd>
						<c:set var="gender" value="${order.orderContact.belongsToInfo.gender}" />
						<c:if test="${null == gender}">
						<c:set var="gender" value="${user.info.gender}" />
						</c:if>
						<select name="gender">
						<option value="0" <c:if test="${gender eq 0}">selected</c:if>>Mr.</option>
						<option value="1" <c:if test="${gender eq 1}">selected</c:if>>Mrs.</option>
						<option value="2" <c:if test="${gender eq 2}">selected</c:if>>Miss</option>
						</select>
					</dd>
				</dl>
				<dl>
					<dt>姓</dt>
					<dd>
						<c:set var="lastName" value="${order.orderContact.belongsToInfo.lastName}" />
						<c:if test="${null == lastName}">
						<c:set var="lastName" value="${user.info.lastName}" />
						</c:if>
						<input name="lastName" type="text" value="${lastName}" class="min validate" errorFieldName="姓" /> 
					</dd>
					<dt>名</dt>
					<dd>
						<c:set var="name" value="${order.orderContact.belongsToInfo.name}" />
						<c:if test="${null == name}">
						<c:set var="name" value="${user.info.name}" />
						</c:if>
						<input name="name" type="text" value="${name}" class="min validate" errorFieldName="名" />
					</dd>
				</dl>
				<dl>
					<dt>国籍</dt>
					<dd>
						<c:set var="nationality" value="${order.orderContact.belongsToInfo.nationality}" />
						<c:if test="${null == nationality}">
						<c:set var="nationality" value="${user.info.nationality}" />
						</c:if>
						<input name="nationality" type="text" value="${nationality}" class="validate" errorFieldName="国籍"/>
					</dd>
					<!--<dt class="long">服务语言</dt>
					<dd>
						<span class="select-el"><select>
							<option value="中文">中文</option>
						</select><div class="sim-select"><div class="sim-head"><span str="中文" class="current">中文</span><span class="sim-arrow"></span></div><div class="sim-list"><ul><li str="中文" class=" last  ">中文</li></ul></div></div></span>
					</dd>-->
				</dl>
				<dl>
					<dt>出生日期</dt>
					<dd>
						<c:set var="birthday" value="${order.orderContact.belongsToInfo.birthday}" />
						<c:if test="${null == birthday}">
						<c:set var="birthday" value="${user.info.birthday}" />
						</c:if>
						<input class="datepicker validate" errorFieldName="出生日期" name="birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" />
					</dd>
				</dl>
				<dl>
					<dt>电子邮件</dt>
					<dd>
						<c:set var="email" value="${order.orderContact.belongsToInfo.email}" />
						<c:if test="${null == email}">
						<c:set var="email" value="${user.info.email}" />
						</c:if>
						<input name="email" type="text" class="long validate" errorFieldName="电子邮件" value="${email}"/> 
					</dd>
				</dl>
				<dl>
					<dt>QQ</dt>
					<dd>
						<c:set var="qq" value="${order.orderContact.belongsToInfo.qq}" />
						<c:if test="${null == qq}">
						<c:set var="qq" value="${user.info.qq}" />
						</c:if>
						<input name="qq" type="text" value="${qq}" class="validate" errorFieldName="QQ" />
					</dd>
				</dl>
				<dl>
					<dt>微信号</dt>
					<dd>
						<c:set var="wechat" value="${order.orderContact.belongsToInfo.wechat}" />
						<c:if test="${null == wechat}">
						<c:set var="wechat" value="${user.info.wechat}" />
						</c:if>
						<input name="wechat" type="text" value="${wechat}" class="validate" errorFieldName="微信号" />
					</dd>
				</dl>
				<dl>
					<dt>手机号码</dt>
					<dd>
						<c:set var="phone" value="${order.orderContact.belongsToInfo.phone}" />
						<c:if test="${null == phone}">
						<c:set var="phone" value="${user.info.phone}" />
						</c:if>
						<input name="phone" type="text" value="${phone}" class="validate" errorFieldName="手机号码" />
					</dd>
				</dl>
				<dl>
					<dt>家庭住址</dt>
					<dd>
						<c:set var="country" value="${order.orderContact.belongsToInfo.country}" />
						<c:if test="${null == country}">
						<c:set var="country" value="${user.info.country}" />
						</c:if>
						<c:set var="province" value="${order.orderContact.belongsToInfo.province}" />
						<c:if test="${null == province}">
						<c:set var="province" value="${user.info.province}" />
						</c:if>
						<c:set var="city" value="${order.orderContact.belongsToInfo.city}" />
						<c:if test="${null == city}">
						<c:set var="city" value="${user.info.city}" />
						</c:if>
						<c:set var="county" value="${order.orderContact.belongsToInfo.county}" />
						<c:if test="${null == county}">
						<c:set var="county" value="${user.info.county}" />
						</c:if>
						<c:set var="address" value="${order.orderContact.belongsToInfo.address}" />
						<c:if test="${null == address}">
						<c:set var="address" value="${user.info.address}" />
						</c:if>
						<input name="country" type="text" value="${country}" class="min validate" errorFieldName="国家" />&nbsp;(国家)&nbsp;<input name="province" type="text" value="${province}" class="min validate" errorFieldName="省" />&nbsp;(省)&nbsp;<input name="city" type="text" value="${city}" class="min validate" errorFieldName="市" />&nbsp;(市)&nbsp;<input name="county" type="text" value="${county}" class="min validate" errorFieldName="区县" />&nbsp;(区县)
					</dd>
				</dl>
				<dl>
					<dt>&nbsp;</dt>
					<dd>
						<input name="address" type="text" value="${address}" class="larger validate" errorFieldName="街道地址" />&nbsp;(街道地址)
					</dd>
				</dl>
				<dl>
					<dt>&nbsp;</dt>
					<dd>
						<c:set var="postalcode" value="${order.orderContact.belongsToInfo.postalcode}" />
						<c:if test="${null == postalcode}">
						<c:set var="postalcode" value="${user.info.postalcode}" />
						</c:if>
						<input name="postalcode" type="text" value="${postalcode}" class="mini validate" errorFieldName="邮编" />&nbsp;(邮编)
					</dd>
				</dl>
				<dl>
					<dt>&nbsp;</dt>
					<dd>
						<button class="btn-style btn-place-order-next">下一步</button>
					</dd>
				</dl>
			</fieldset>
		</div>
		</form>
</div>

