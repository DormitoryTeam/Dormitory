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
								<li class="ui-state-default ui-tabs-active ui-state-active ui-corner-left" role="tab" tabindex="0" aria-controls="tabs-additional" aria-labelledby="ui-id-1" aria-selected="true"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=0"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1" style="cursor: pointer;">个人信息</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-additional" aria-labelledby="ui-id-2" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=1"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">个人偏好</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-additional" aria-labelledby="ui-id-3" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=2"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">担保人信息</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-additional" aria-labelledby="ui-id-4" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=3"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">紧急联系人信息</a></li>
								<li style="background-color: antiquewhite;" class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-additional" aria-labelledby="ui-id-5" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=4"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">补充信息</a></li>
							</ul>
							<div id="tabs-additional" aria-labelledby="ui-id-5" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
								<fieldset>
									<dl>
										<dt>毕业院校</dt>
										<dd>
											<c:set var="graduateSchool" value="${order.orderContact.prefer.graduateSchool}" />
											${graduateSchool}
										</dd>
									</dl>
									<dl>
										<dd>是否需要推送你的入读城市信息?</dd>
										<dd>
											<c:set var="needPush" value="${order.orderContact.prefer.needPush}" />
											<c:if test="${needPush}"><label>是</label></c:if>
											<c:if test="${not needPush}"><label>否</label></c:if>
										</dd>
									</dl>
									<dl>
										<dd>我已阅读并同意留学生活网的《条款条例》</dd>
										<dd>
											<c:set var="readClause" value="${order.orderContact.prefer.readClause}" />
											<c:if test="${readClause}"><label>是</label></c:if>
											<c:if test="${not readClause}"><label>否</label></c:if>
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