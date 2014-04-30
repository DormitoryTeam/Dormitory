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
								<li class="ui-state-default ui-tabs-active ui-state-active ui-corner-left" role="tab" tabindex="0" aria-controls="tabs-hobby" aria-labelledby="ui-id-1" aria-selected="true"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=0"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1" style="cursor: pointer;">个人信息</a></li>
								<li style="background-color: antiquewhite;" class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-hobby" aria-labelledby="ui-id-2" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=1"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">个人偏好</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-hobby" aria-labelledby="ui-id-3" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=2"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">担保人信息</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-hobby" aria-labelledby="ui-id-4" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=3"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">紧急联系人信息</a></li>
								<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-hobby" aria-labelledby="ui-id-5" aria-selected="false"><a href="<c:url value="/order/view-order.html?orderId=${order.id}&pageStep=4"/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">补充信息</a></li>
							</ul>
							<div id="tabs-hobby" aria-labelledby="ui-id-5" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
								<fieldset>
									<dl>
										<dd>您是否抽烟?</dd>
										<dd>
											<c:set var="smoke" value="${order.orderContact.prefer.smoke}" />
											<c:if test="${smoke}"><label>是</label></c:if>
											<c:if test="${not smoke}"><label>否</label></c:if>
										</dd>
									</dl>
									<dl>
										<dd>您是否是素食主义者?</dd>
										<dd>
											<c:set var="vegetarianism" value="${order.orderContact.prefer.vegetarianism}" />
											<c:if test="${vegetarianism}"><label>是</label></c:if>
											<c:if test="${not vegetarianism}"><label>否</label></c:if>
										</dd>
									</dl>
									<dl>
										<dd>您的年级?</dd>
										<dd>
											<c:set var="yourGrade" value="${order.orderContact.prefer.yourGrade}" />
										
											<c:if test="${'1' eq yourGrade}"><label>大一</label></c:if>
											<c:if test="${'2' eq yourGrade}"><label>大二</label></c:if>
											<c:if test="${'3' eq yourGrade}"><label>大三</label></c:if>
											<c:if test="${'4' eq yourGrade}"><label>大四</label></c:if>
											<c:if test="${'5' eq yourGrade}"><label>硕士</label></c:if>
											<c:if test="${'6' eq yourGrade}"><label>博士</label></c:if>
										</dd>
									</dl>
									<dl>
										<dd>您想和哪个年级的人一起住?</dd>
										<dd>
											<c:set var="roomMemberGrade" value="${order.orderContact.prefer.roomMemberGrade}" />
											<c:if test="${'1' eq roomMemberGrade}"><label>大一</label></c:if>
											<c:if test="${'2' eq roomMemberGrade}"><label>大二</label></c:if>
											<c:if test="${'3' eq roomMemberGrade}"><label>大三</label></c:if>
											<c:if test="${'4' eq roomMemberGrade}"><label>大四</label></c:if>
											<c:if test="${'5' eq roomMemberGrade}"><label>硕士</label></c:if>
											<c:if test="${'6' eq roomMemberGrade}"><label>博士</label></c:if>
										</dd>
									</dl>
									<dl>
										<dd>室友性别要求?</dd>
										<dd>
											<c:set var="roomMemberGender" value="${order.orderContact.prefer.roomMemberGender}" />
											<c:if test="${0 eq roomMemberGender}"><label>混合性别</label></c:if>
											<c:if test="${1 eq roomMemberGender}"><label>我是男性想和所有男性一起住</label></c:if>
											<c:if test="${2 eq roomMemberGender}"><label>我是女性想和所有女性一起住</label></c:if>
											<c:if test="${3 eq roomMemberGender}"><label>无所谓</label></c:if>
										</dd>
									</dl>
									<dl>
										<dt>您的专业</dt>
										<dd>
											<c:set var="major" value="${order.orderContact.prefer.major}" />
											${major}
										</dd>
									</dl>
									<dl>
										<dt>学校</dt>
										<dd>
											<c:set var="college" value="${order.orderContact.prefer.college}" />
											${college}
										</dd>
									</dl>
									<dl>
										<dt>特殊要求</dt>
										<dd>
											<c:set var="floor" value="${order.orderContact.prefer.floor}" />
											${floor}
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