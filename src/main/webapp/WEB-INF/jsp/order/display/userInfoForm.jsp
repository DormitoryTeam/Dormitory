<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row">
				<div class="reservation-content">
					<jsp:include page="displayOrderHeader.jsp"/>
					<div class="reservation-personal reservation-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
						<form>
							<div class="btnBox">
								<a style="color:#AE0000; font-weight: bold; font-size: 20px;" href="<c:url value="/user/orderList.html?orderType=D"/>" >返回</a>
							</div>
							<ul role="tablist" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
								<li aria-selected="true" aria-labelledby="ui-id-1" aria-controls="tabs-personal" tabindex="0" role="tab" class="ui-state-default ui-tabs-active ui-state-active ui-corner-left" style="background-color: antiquewhite;"><a id="ui-id-1" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=0"/>">个人信息</a></li>
								<li aria-selected="false" aria-labelledby="ui-id-2" aria-controls="tabs-personal" tabindex="-1" role="tab" class="ui-state-default ui-corner-left"><a id="ui-id-2" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=1"/>">个人偏好</a></li>
								<li aria-selected="false" aria-labelledby="ui-id-3" aria-controls="tabs-personal" tabindex="-1" role="tab" class="ui-state-default ui-corner-left"><a id="ui-id-3" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=2"/>">担保人信息</a></li>
								<li aria-selected="false" aria-labelledby="ui-id-4" aria-controls="tabs-personal" tabindex="-1" role="tab" class="ui-state-default ui-corner-left"><a id="ui-id-4" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=3"/>">紧急联系人信息</a></li>
								<li aria-selected="false" aria-labelledby="ui-id-5" aria-controls="tabs-personal" tabindex="-1" role="tab" class="ui-state-default ui-corner-left"><a id="ui-id-5" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=4"/>">补充信息</a></li>
							</ul>
							<div aria-hidden="false" aria-expanded="true" role="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom" aria-labelledby="ui-id-5" id="tabs-personal">
								<fieldset>
									<dl>
										<dt>称呼</dt>
										<dd>
										<c:set var="gender" value="${order.orderContact.belongsToInfo.gender}" />
										<c:if test="${gender eq 0}">Mr.</c:if>
										<c:if test="${gender eq 1}">Mrs.</c:if>
										<c:if test="${gender eq 2}">Miss</c:if>
										</dd>
									</dl>
									<dl>
										<dt>姓</dt>
										<dd>
											<c:set var="lastName" value="${order.orderContact.belongsToInfo.lastName}" />
											${lastName}
										</dd>
										<dt>名</dt>
										<dd>
											<c:set var="name" value="${order.orderContact.belongsToInfo.name}" />
											${name}
										</dd>
									</dl>
									<dl>
										<dt>国籍</dt>
										<dd>
											<c:set var="nationality" value="${order.orderContact.belongsToInfo.nationality}" />
											${nationality}
										</dd>
									</dl>
									<dl>
										<dt>出生日期</dt>
										<dd>
											<c:set var="birthday" value="${order.orderContact.belongsToInfo.birthday}" />
											<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>
										</dd>
									</dl>
									<dl>
										<dt>电子邮件</dt>
										<dd>
											<c:set var="email" value="${order.orderContact.belongsToInfo.email}" />
											${email}
										</dd>
									</dl>
									<dl>
										<dt>QQ</dt>
										<dd>
											<c:set var="qq" value="${order.orderContact.belongsToInfo.qq}" />
											${qq}
										</dd>
									</dl>
									<dl>
										<dt>微信号</dt>
										<dd>
											<c:set var="wechat" value="${order.orderContact.belongsToInfo.wechat}" />
											${wechat}
										</dd>
									</dl>
									<dl>
										<dt>手机号码</dt>
										<dd>
											<c:set var="phone" value="${order.orderContact.belongsToInfo.phone}" />
											${phone}
										</dd>
									</dl>
									<dl>
										<dt>家庭住址</dt>
										<dd>
											<c:set var="country" value="${order.orderContact.belongsToInfo.country}" />
											<c:set var="province" value="${order.orderContact.belongsToInfo.province}" />
											<c:set var="city" value="${order.orderContact.belongsToInfo.city}" />
											<c:set var="county" value="${order.orderContact.belongsToInfo.county}" />
											<c:set var="address" value="${order.orderContact.belongsToInfo.address}" />
											${country} (国家)${province} (省)${city} (市)${county} (区县)
										</dd>
									</dl>
									<dl>
										<dt>&nbsp;</dt>
										<dd>
											${address} (街道地址)
										</dd>
									</dl>
									<dl>
										<dt>邮编</dt>
										<dd>
											<c:set var="postalcode" value="${order.orderContact.belongsToInfo.postalcode}" />
											${postalcode}
										</dd>
									</dl>
								</fieldset>
							</div>
						</form>
					</div>
				</div>
            </div>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>