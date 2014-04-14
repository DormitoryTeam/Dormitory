<div class="reservation-content">
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
			<input name="pageStep" type="hidden" value="3"/>
			<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
			<input type="hidden" name="contractId" value="${price.contractId}" /> 
			<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
			<input name="infoId" type="hidden" value="${order.orderContact.contactPersonInfo.id}"/>
			<a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${dormitory.id}&contractId=${price.contractId}&roomInfoId=${roomInfo.id}"/>" class="addOne">&nbsp;</a>
			<div class="btnBox">
				<input class="save btn-place-order-save" type="button" value="保存" />
				<input type="submit" style="background-color: #808080;" value="提交" />
			</div>
			<ul>
				<li><a href="#tabs-emergency">个人信息</a></li>
				<li><a href="#tabs-emergency">个人偏好</a></li>
				<li><a href="#tabs-emergency">担保人信息</a></li>
				<li style="background-color: antiquewhite;"><a href="#tabs-emergency">紧急联系人信息</a></li>
				<li><a href="#tabs-emergency">补充信息</a></li>
			</ul>
			<div id="tabs-emergency">
				<fieldset>
					<dl>
						<dd>
							<input id="sameas" type="checkbox"/><label>同担保人信息</label>
						</dd>
					</dl>
					<dl>
						<dt>称呼</dt>
						<dd>
							<c:set var="gender" value="${order.orderContact.contactPersonInfo.gender}" />
							<c:if test="${null == gender}">
							<c:set var="gender" value="${user.contactPersonInfo.gender}" />
							</c:if>
							<select name="gender" id="gender">
							<option value="0" <c:if test="gender eq 0">selected</c:if>>Mr.</option>
							<option value="1" <c:if test="gender eq 1">selected</c:if>>Mrs.</option>
							<option value="2" <c:if test="gender eq 2">selected</c:if>>Miss</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>与你的关系</dt>
						<dd>
							<c:set var="relationship" value="${order.orderContact.contactPersonInfo.relationship}" />
							<c:if test="${null == relationship}">
							<c:set var="relationship" value="${user.contactPersonInfo.relationship}" />
							</c:if>
							<input type="text" name="relationship" value="${relationship}" id="relationship" /> 
						</dd>
					</dl>
					<dl>
						<dt>姓</dt>
						<dd>
							<c:set var="lastName" value="${order.orderContact.contactPersonInfo.lastName}" />
							<c:if test="${null == lastName}">
							<c:set var="lastName" value="${user.contactPersonInfo.lastName}" />
							</c:if>
							<input type="text" name="lastName" value="${lastName}" class="min" id="lastName" />  
						</dd>
						<dt>名</dt>
						<dd>
							<c:set var="name" value="${order.orderContact.contactPersonInfo.name}" />
							<c:if test="${null == name}">
							<c:set var="name" value="${user.contactPersonInfo.name}" />
							</c:if>
							<input type="text" name="name" value="${name}" class="min" id="name" /> 
						</dd>
					</dl>
					<dl>
						<dt>国籍</dt>
						<dd>
							<c:set var="nationality" value="${order.orderContact.contactPersonInfo.nationality}" />
							<c:if test="${null == nationality}">
							<c:set var="nationality" value="${user.contactPersonInfo.nationality}" />
							</c:if>
							<input name="nationality" type="text" value="${nationality}" id="nationality" />
						</dd>
					</dl>
					<dl>
						<dt>出生日期</dt>
						<dd>
							<c:set var="birthday" value="${order.orderContact.contactPersonInfo.birthday}" />
							<c:if test="${null == birthday}">
							<c:set var="birthday" value="${user.contactPersonInfo.birthday}" />
							</c:if>
							<input name="birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" id="birthday" />
						</dd>
					</dl>
					<dl>
						<dt>电子邮件</dt>
						<dd>
							<c:set var="email" value="${order.orderContact.contactPersonInfo.email}" />
							<c:if test="${null == email}">
							<c:set var="email" value="${user.contactPersonInfo.email}" />
							</c:if>
							<input name="email" value="${email}" type="text" class="long" id="email" />
						</dd>
					</dl>
					<dl>
						<dt>手机号码</dt>
						<dd>
							<c:set var="phone" value="${order.orderContact.contactPersonInfo.phone}" />
							<c:if test="${null == phone}">
							<c:set var="phone" value="${user.contactPersonInfo.phone}" />
							</c:if>
							<input name="phone" type="text" value="${phone}" id="phone" /> 
						</dd>
					</dl>
					<dl>
						<dt>家庭住址</dt>
						<dd>
							<c:set var="country" value="${order.orderContact.contactPersonInfo.country}" />
							<c:if test="${null == country}">
							<c:set var="country" value="${user.contactPersonInfo.country}" />
							</c:if>
							<c:set var="province" value="${order.orderContact.contactPersonInfo.province}" />
							<c:if test="${null == province}">
							<c:set var="province" value="${user.contactPersonInfo.province}" />
							</c:if>
							<c:set var="city" value="${order.orderContact.contactPersonInfo.city}" />
							<c:if test="${null == city}">
							<c:set var="city" value="${user.contactPersonInfo.city}" />
							</c:if>
							<c:set var="county" value="${order.orderContact.contactPersonInfo.county}" />
							<c:if test="${null == county}">
							<c:set var="county" value="${user.contactPersonInfo.county}" />
							</c:if>
							<c:set var="address" value="${order.orderContact.contactPersonInfo.address}" />
							<c:if test="${null == address}">
							<c:set var="address" value="${user.contactPersonInfo.address}" />
							</c:if>
							<input name="country" type="text" value="${country}" class="min" id="country" /> (国家)<input name="province" type="text" value="${province}" class="min" id="province" /> (省)<input name="city" type="text" value="${city}" class="min" id="city" /> (市)<input type="text" name="county" value="${county}" class="min" id="county" /> (区县)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input name="address" type="text" value="${address}" class="larger" id="address" /> (街道地址)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<c:set var="postalcode" value="${order.orderContact.contactPersonInfo.postalcode}" />
							<c:if test="${null == postalcode}">
							<c:set var="postalcode" value="${user.contactPersonInfo.postalcode}" />
							</c:if>
							<input type="text" name="postalcode" value="${postalcode}" id="postalcode" /> (邮编)
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
<script>
var guarantee = {gender:"${order.orderContact.guaranteeInfo.gender}", 
				 relationship: "${order.orderContact.guaranteeInfo.relationship}", 
				 name: "${order.orderContact.guaranteeInfo.name}", 
				 lastName: "${order.orderContact.guaranteeInfo.lastName}", 
				 nationality: "${order.orderContact.guaranteeInfo.nationality}",
				 birthday:"<fmt:formatDate value='${order.orderContact.guaranteeInfo.birthday}' pattern='yyyy-MM-dd'/>", 
				 email: "${order.orderContact.guaranteeInfo.email}",
				 phone: "${order.orderContact.guaranteeInfo.phone}",
				 country: "${order.orderContact.guaranteeInfo.country}",
				 province: "${order.orderContact.guaranteeInfo.province}",
				 city: "${order.orderContact.guaranteeInfo.city}",
				 county: "${order.orderContact.guaranteeInfo.county}",
				 address: "${order.orderContact.guaranteeInfo.address}",
				 postalcode: "${order.orderContact.guaranteeInfo.postalcode}"
				 }
</script>