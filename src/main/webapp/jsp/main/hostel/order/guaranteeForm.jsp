<div class="reservation-content">
	<jsp:include page="/jsp/main/hostel/order/include/orderHeader.jsp"/>
	<div class="reservation-personal reservation-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
		<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
			<input type="hidden" name="command" id="command"/>
			<input type="hidden" name="action" value="${action}"/>
			<input type="hidden" name="pageStep" value="2" />
			<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
			<input type="hidden" name="contractId" value="${price.contractId}" /> 
			<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
			<input name="infoId" type="hidden" value="${order.orderContact.guaranteeInfo.id}"/>
					
			<!-- <a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${dormitory.id}&contractId=${price.contractId}&roomInfoId=${roomInfo.id}"/>" class="addOne">&nbsp;</a>-->
			<div class="btnBox">
				<c:if test="${'edit' eq action}">
					<input type="button" class="save btn-back" value="返回" data-url="<c:url value="/user/orderList.html?orderType=D"/>"/>
				</c:if>
				<input class="save btn-place-order-save" type="button" value="保存" />
				<input type="button" style="background-color: #808080;" value="提交" />
			</div>
			<jsp:include page="/jsp/main/hostel/order/include/dormitoryOrderTab.jsp"/>			
			
			<div id="tabs-security" aria-labelledby="ui-id-3" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: block;" aria-expanded="true" aria-hidden="false">
				<fieldset>
					<dl>
						<dt>称呼</dt>
						<dd>
							<c:set var="gender" value="${order.orderContact.guaranteeInfo.gender}" />
							<c:if test="${null == gender}">
							<c:set var="gender" value="${user.guaranteeInfo.gender}" />
							</c:if>
							<select name="gender">
								<option value="0" <c:if test="${gender eq 0}">selected</c:if>>Mr.</option>
								<option value="1" <c:if test="${gender eq 1}">selected</c:if>>Mrs.</option>
								<option value="2" <c:if test="${gender eq 2}">selected</c:if>>Miss</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>与你的关系</dt>
						<dd>
							<c:set var="relationship" value="${order.orderContact.guaranteeInfo.relationship}" />
							<c:if test="${null == relationship}">
							<c:set var="relationship" value="${user.guaranteeInfo.relationship}" />
							</c:if>
							<input type="text" name="relationship" value="${relationship}" /> 
						</dd>
					</dl>
					<dl>
						<dt>姓</dt>
						<dd>
							<c:set var="lastName" value="${order.orderContact.guaranteeInfo.lastName}" />
							<c:if test="${null == lastName}">
							<c:set var="lastName" value="${user.guaranteeInfo.lastName}" />
							</c:if>
							<input type="text" name="lastName" value="${lastName}" class="min validate" errorFieldName="姓" />  
						</dd>
						<dt>名</dt>
						<dd>
							<c:set var="name" value="${order.orderContact.guaranteeInfo.name}" />
							<c:if test="${null == name}">
							<c:set var="name" value="${user.guaranteeInfo.name}" />
							</c:if>
							<input type="text" name="name" value="${name}" class="min validate" errorFieldName="名" />
						</dd>
					</dl>
					<dl>
						<dt>国籍</dt>
						<dd>
							<c:set var="nationality" value="${order.orderContact.guaranteeInfo.nationality}" />
							<c:if test="${null == nationality}">
							<c:set var="nationality" value="${user.guaranteeInfo.nationality}" />
							</c:if>
							<input name="nationality" type="text" value="${nationality}" class="validate" errorFieldName="国籍"/>
						</dd>
					</dl>
					<dl>
						<dt>出生日期</dt>
						<dd>
							<c:set var="birthday" value="${order.orderContact.guaranteeInfo.birthday}" />
							<c:if test="${null == birthday}">
							<c:set var="birthday" value="${user.guaranteeInfo.birthday}" />
							</c:if>
							<input class="datepicker validate" errorFieldName="出生日期" name="birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" />
						</dd>
					</dl>
					<dl>
						<dt>电子邮件</dt>
						<dd>
							<c:set var="email" value="${order.orderContact.guaranteeInfo.email}" />
							<c:if test="${null == email}">
							<c:set var="email" value="${user.guaranteeInfo.email}" />
							</c:if>
							<input name="email" type="text" class="long validate" errorFieldName="电子邮件" value="${email}"/> 
						</dd>
					</dl>
					<dl>
						<dt>手机号码</dt>
						<dd>
							<c:set var="phone" value="${order.orderContact.guaranteeInfo.phone}" />
							<c:if test="${null == phone}">
							<c:set var="phone" value="${user.guaranteeInfo.phone}" />
							</c:if>
							<input name="phone" type="text" value="${phone}" class="validate" errorFieldName="手机号码" />
						</dd>
					</dl>
					<dl>
						<dt>家庭住址</dt>
						<dd>
							<c:set var="country" value="${order.orderContact.guaranteeInfo.country}" />
						<c:if test="${null == country}">
						<c:set var="country" value="${user.guaranteeInfo.country}" />
						</c:if>
						<c:set var="province" value="${order.orderContact.guaranteeInfo.province}" />
						<c:if test="${null == province}">
						<c:set var="province" value="${user.guaranteeInfo.province}" />
						</c:if>
						<c:set var="city" value="${order.orderContact.guaranteeInfo.city}" />
						<c:if test="${null == city}">
						<c:set var="city" value="${user.guaranteeInfo.city}" />
						</c:if>
						<c:set var="county" value="${order.orderContact.guaranteeInfo.county}" />
						<c:if test="${null == county}">
						<c:set var="county" value="${user.guaranteeInfo.county}" />
						</c:if>
						<c:set var="address" value="${order.orderContact.guaranteeInfo.address}" />
						<c:if test="${null == address}">
						<c:set var="address" value="${user.guaranteeInfo.address}" />
						</c:if>
						<input name="country" type="text" value="${country}" class="min validate" errorFieldName="国家"  />&nbsp;(国家)&nbsp;<input name="province" type="text" value="${province}" class="min validate" errorFieldName="省" />&nbsp;(省)&nbsp;<input name="city" type="text" value="${city}" class="min validate" errorFieldName="市" />&nbsp;(市)&nbsp;<input type="text" name="county" value="${county}" class="min validate" errorFieldName="区县" />&nbsp;(区县)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input name="address" type="text" value="${address}" class="larger validate" errorFieldName="街道地址"/>&nbsp;(街道地址)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<c:set var="postalcode" value="${order.orderContact.guaranteeInfo.postalcode}" />
							<c:if test="${null == postalcode}">
							<c:set var="postalcode" value="${user.guaranteeInfo.postalcode}" />
							</c:if>
							<input type="text" name="postalcode" value="${postalcode}" class="mini validate" errorFieldName="邮编" />&nbsp;(邮编)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<c:if test="${not empty order.id}"><button class="btn-style btn-place-order-pre" preStep="<c:url value="/order/dormitory-place-order.html?orderId=${order.id}&pageStep=1&action=${action}"/>">上一步</button></c:if><button class="btn-style btn-place-order-next">下一步</button>
						</dd>
					</dl>
				</fieldset>
			</div>
			
			
		</form>
	</div>
</div>
<%--
﻿<div class="reservation-content">
	<div class="reservation-info">
		<span>基本信息</span>
		<fieldset>
			<dl>
				<dt>房屋名</dt>
				<dd>${dormitory.name}</dd>
			</dl>
			<dl>
				<dt>租期</dt>
				<dd>${price.contract}</dd>
			</dl>
			<dl>
				<dt>单价</dt>
				<dd>&#163; ${price.salePrice}</dd>
			</dl>
			<dl>
				<dt>总价</dt>
				<dd>&#163;${price.salePrice}</dd>
			</dl>
			<dl>
				<dt>入住时间</dt>
				<dd><fmt:formatDate value='${roomInfo.checkinDate}' pattern='yyyy.MM.dd'/></dd>
			</dl>
		</fieldset>
	</div>
	<div class="reservation-personal reservation-tab">
		<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
			<input type="hidden" name="command" id="command"/>
			<input type="hidden" name="pageStep" value="2" />
			<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
			<input type="hidden" name="contractId" value="${price.contractId}" /> 
			<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
			<input name="infoId" type="hidden" value="${order.orderContact.guaranteeInfo.id}"/>
					
			<a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${dormitory.id}&contractId=${price.contractId}&roomInfoId=${roomInfo.id}"/>" class="addOne">&nbsp;</a>
			<div class="btnBox">
				<input class="save btn-place-order-save" type="button" value="保存" />
				<input type="submit" style="background-color: #808080;" value="提交" />
			</div>
			<ul>
				<li><a href="#tabs-security">个人信息</a></li>
				<li><a href="#tabs-security">个人偏好</a></li>
				<li style="background-color: antiquewhite;"><a href="#tabs-security">担保人信息</a></li>
				<li><a href="#tabs-security">紧急联系人信息</a></li>
				<li><a href="#tabs-security">补充信息</a></li>
			</ul>
			<div id="tabs-security">
				<fieldset>
					<dl>
						<dt>称呼</dt>
						<dd>
							<c:set var="gender" value="${order.orderContact.guaranteeInfo.gender}" />
							<c:if test="${null == gender}">
							<c:set var="gender" value="${user.guaranteeInfo.gender}" />
							</c:if>
							<select name="gender">
								<option value="0" <c:if test="${gender eq 0}">selected</c:if>>Mr.</option>
								<option value="1" <c:if test="${gender eq 1}">selected</c:if>>Mrs.</option>
								<option value="2" <c:if test="${gender eq 2}">selected</c:if>>Miss</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>与你的关系</dt>
						<dd>
							<c:set var="relationship" value="${order.orderContact.guaranteeInfo.relationship}" />
							<c:if test="${null == relationship}">
							<c:set var="relationship" value="${user.guaranteeInfo.relationship}" />
							</c:if>
							<input type="text" name="relationship" value="${relationship}" /> 
						</dd>
					</dl>
					<dl>
						<dt>姓</dt>
						<dd>
							<c:set var="lastName" value="${order.orderContact.guaranteeInfo.lastName}" />
							<c:if test="${null == lastName}">
							<c:set var="lastName" value="${user.guaranteeInfo.lastName}" />
							</c:if>
							<input type="text" name="lastName" value="${lastName}" class="min" />  
						</dd>
						<dt>名</dt>
						<dd>
							<c:set var="name" value="${order.orderContact.guaranteeInfo.name}" />
							<c:if test="${null == name}">
							<c:set var="name" value="${user.guaranteeInfo.name}" />
							</c:if>
							<input type="text" name="name" value="${name}" class="min" /> 
						</dd>
					</dl>
					<dl>
						<dt>国籍</dt>
						<dd>
							<c:set var="nationality" value="${order.orderContact.guaranteeInfo.nationality}" />
							<c:if test="${null == nationality}">
							<c:set var="nationality" value="${user.guaranteeInfo.nationality}" />
							</c:if>
							<input name="nationality" type="text" value="${nationality}" />
						</dd>
					</dl>
					<dl>
						<dt>出生日期</dt>
						<dd>
							<c:set var="birthday" value="${order.orderContact.guaranteeInfo.birthday}" />
							<c:if test="${null == birthday}">
							<c:set var="birthday" value="${user.guaranteeInfo.birthday}" />
							</c:if>
							<input name="birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" />
						</dd>
					</dl>
					<dl>
						<dt>电子邮件</dt>
						<dd>
							<c:set var="email" value="${order.orderContact.guaranteeInfo.email}" />
							<c:if test="${null == email}">
							<c:set var="email" value="${user.guaranteeInfo.email}" />
							</c:if>
							<input name="email" type="text" class="long"  value="${email}"/>
						</dd>
					</dl>
					<dl>
						<dt>手机号码</dt>
						<dd>
							<c:set var="phone" value="${order.orderContact.guaranteeInfo.phone}" />
							<c:if test="${null == phone}">
							<c:set var="phone" value="${user.guaranteeInfo.phone}" />
							</c:if>
							<input name="phone" type="text" value="${phone}" />
						</dd>
					</dl>
					<dl>
						<dt>家庭住址</dt>
						<dd>
						<c:set var="country" value="${order.orderContact.guaranteeInfo.country}" />
						<c:if test="${null == country}">
						<c:set var="country" value="${user.guaranteeInfo.country}" />
						</c:if>
						<c:set var="province" value="${order.orderContact.guaranteeInfo.province}" />
						<c:if test="${null == province}">
						<c:set var="province" value="${user.guaranteeInfo.province}" />
						</c:if>
						<c:set var="city" value="${order.orderContact.guaranteeInfo.city}" />
						<c:if test="${null == city}">
						<c:set var="city" value="${user.guaranteeInfo.city}" />
						</c:if>
						<c:set var="county" value="${order.orderContact.guaranteeInfo.county}" />
						<c:if test="${null == county}">
						<c:set var="county" value="${user.guaranteeInfo.county}" />
						</c:if>
						<c:set var="address" value="${order.orderContact.guaranteeInfo.address}" />
						<c:if test="${null == address}">
						<c:set var="address" value="${user.guaranteeInfo.address}" />
						</c:if>
							<input name="country" type="text" value="${country}" class="min" /> (国家)<input name="province" type="text" value="${province}" class="min" /> (省)<input name="city" type="text" value="${city}" class="min" /> (市)<input type="text" name="county" value="${county}" class="min" /> (区县)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input name="address" type="text" value="${address}" class="larger"/> (街道地址)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<c:set var="postalcode" value="${order.orderContact.guaranteeInfo.postalcode}" />
							<c:if test="${null == postalcode}">
							<c:set var="postalcode" value="${user.guaranteeInfo.postalcode}" />
							</c:if>
							<input type="text" name="postalcode" value="${postalcode}" /> (邮编)
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
</div>
--%>