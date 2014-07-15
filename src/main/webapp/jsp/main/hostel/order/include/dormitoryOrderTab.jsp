<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
	<li class="ui-state-default ui-corner-left" <c:if test="${0 != step}">style="background-color: ${order.fillOrdmitoryOrderStatus.fillUserInfo ? 'rgb(123, 230, 123)':'rgb(238, 80, 80)'}"</c:if>><a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${param.dormitoryId}&contractId=${param.contractId}&roomInfoId=${param.roomInfoId}&orderId=${order.id}&pageStep=0&action=${action}" />" class="ui-tabs-anchor">个人信息</a></li>
	<li class="ui-state-default ui-corner-left" <c:if test="${1 != step}">style="background-color: ${order.fillOrdmitoryOrderStatus.fillPrefer ? 'rgb(123, 230, 123)':'rgb(238, 80, 80)'}"</c:if>><a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${param.dormitoryId}&contractId=${param.contractId}&roomInfoId=${param.roomInfoId}&orderId=${order.id}&pageStep=1&action=${action}" />" class="ui-tabs-anchor">个人偏好</a></li>
	<li class="ui-state-default ui-corner-left" <c:if test="${2 != step}">style="background-color: ${order.fillOrdmitoryOrderStatus.fillGuaranteeInfo ? 'rgb(123, 230, 123)':'rgb(238, 80, 80)'}"</c:if>><a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${param.dormitoryId}&contractId=${param.contractId}&roomInfoId=${param.roomInfoId}&orderId=${order.id}&pageStep=2&action=${action}" />" class="ui-tabs-anchor">担保人信息</a></li>
	<li class="ui-state-default ui-corner-left" <c:if test="${3 != step}">style="background-color: ${order.fillOrdmitoryOrderStatus.fillContactInfo ? 'rgb(123, 230, 123)':'rgb(238, 80, 80)'}"</c:if>><a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${param.dormitoryId}&contractId=${param.contractId}&roomInfoId=${param.roomInfoId}&orderId=${order.id}&pageStep=3&action=${action}" />" class="ui-tabs-anchor">紧急联系人信息</a></li>
	<li class="ui-state-default ui-corner-left" <c:if test="${4 != step}">style="background-color: ${order.fillOrdmitoryOrderStatus.fillNote ? 'rgb(123, 230, 123)':'rgb(238, 80, 80)'}"</c:if>><a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${param.dormitoryId}&contractId=${param.contractId}&roomInfoId=${param.roomInfoId}&orderId=${order.id}&pageStep=4&action=${action}" />" class="ui-tabs-anchor">补充信息</a></li>
</ul>