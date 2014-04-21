<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row airport">
				<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
				<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
					<div class="tip-text">
						2014年接机名额还剩1000个
					</div>
						<form >
						<div class="btnBox">
							<a style="color:#AE0000; font-weight: bold; font-size: 20px;" href="<c:url value="/user/orderList.html"/>" >返回</a>
						</div>
						<jsp:include page="displayPickupOrderTopNav.jsp">
							<jsp:param name="pageName" value="info"/>
						</jsp:include>
						<div id="tabs-personal" aria-labelledby="ui-id-1" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
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
	</main>
	
    <%-- bottom section --%>
    <footer>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>