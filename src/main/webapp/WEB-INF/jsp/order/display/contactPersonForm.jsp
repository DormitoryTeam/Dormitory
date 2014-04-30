<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    	<jsp:include page="/jsp/header/header.jsp" />
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
							<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
								<li class="ui-state-default ui-tabs-active ui-state-active ui-corner-left" role="tab" tabindex="0" aria-controls="tabs-emergency" aria-labelledby="ui-id-1" aria-selected="true"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=0"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1" style="cursor: pointer;">个人信息</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-emergency" aria-labelledby="ui-id-2" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=1"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">个人偏好</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-emergency" aria-labelledby="ui-id-3" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=2"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">担保人信息</a></li>
								<li style="background-color: antiquewhite;" class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-emergency" aria-labelledby="ui-id-4" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=3"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">紧急联系人信息</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-emergency" aria-labelledby="ui-id-5" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=4"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">补充信息</a></li>
							</ul>
							<div id="tabs-emergency" aria-labelledby="ui-id-5" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
								<fieldset>
									<dl>
										<dt>称呼</dt>
										<dd>
											<c:set var="gender" value="${order.orderContact.contactPersonInfo.gender}" />
											<c:if test="${gender eq 0}">Mr.</c:if>
											<c:if test="${gender eq 1}">Mrs.</c:if>
											<c:if test="${gender eq 2}">Miss</c:if>
										</dd>
									</dl>
									<dl>
										<dt>与你的关系</dt>
										<dd>
											<c:set var="relationship" value="${order.orderContact.contactPersonInfo.relationship}" />
											${relationship}
										</dd>
									</dl>
									<dl>
										<dt>姓</dt>
										<dd>
											<c:set var="lastName" value="${order.orderContact.contactPersonInfo.lastName}" />
											${lastName}  
										</dd>
										<dt>名</dt>
										<dd>
											<c:set var="name" value="${order.orderContact.contactPersonInfo.name}" />
											${name}
										</dd>
									</dl>
									<dl>
										<dt>国籍</dt>
										<dd>
											<c:set var="nationality" value="${order.orderContact.contactPersonInfo.nationality}" />
											${nationality}
										</dd>
									</dl>
									<dl>
										<dt>出生日期</dt>
										<dd>
											<c:set var="birthday" value="${order.orderContact.contactPersonInfo.birthday}" />
											<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>
										</dd>
									</dl>
									<dl>
										<dt>电子邮件</dt>
										<dd>
											<c:set var="email" value="${order.orderContact.contactPersonInfo.email}" />
											${email}
										</dd>
									</dl>
									<dl>
										<dt>手机号码</dt>
										<dd>
											<c:set var="phone" value="${order.orderContact.contactPersonInfo.phone}" />
											${phone}
										</dd>
									</dl>
									<dl>
										<dt>家庭住址</dt>
										<dd>
											<c:set var="country" value="${order.orderContact.contactPersonInfo.country}" />
											<c:set var="province" value="${order.orderContact.contactPersonInfo.province}" />
											<c:set var="city" value="${order.orderContact.contactPersonInfo.city}" />
											<c:set var="county" value="${order.orderContact.contactPersonInfo.county}" />
											<c:set var="address" value="${order.orderContact.contactPersonInfo.address}" />
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
											<c:set var="postalcode" value="${order.orderContact.contactPersonInfo.postalcode}" />
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
    <jsp:include page="/jsp/footer/footer.jsp" />
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>