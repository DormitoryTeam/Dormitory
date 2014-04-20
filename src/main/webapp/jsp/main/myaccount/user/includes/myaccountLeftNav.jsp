<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
	<li class="ui-state-default ui-corner-top<c:if test="${'info' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="0" aria-controls="tabs-personal" aria-labelledby="ui-id-1" aria-selected="true"><a href="<c:url value='/user/editUserInfo.html'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">个人信息</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'order' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-house" aria-labelledby="ui-id-2" aria-selected="false"><a href="<c:url value='/user/orderList.html?orderType=D'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">宿舍订单</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'pickup' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-air" aria-labelledby="ui-id-3" aria-selected="false"><a href="<c:url value='/user/orderList.html'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">接机订单</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'other' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-tour" aria-labelledby="ui-id-4" aria-selected="false"><a href="#tabs-tour" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">旅游年卡</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'other' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-guide" aria-labelledby="ui-id-5" aria-selected="false"><a href="#tabs-guide" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">导游服务</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'other' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-alumni" aria-labelledby="ui-id-6" aria-selected="false"><a href="#tabs-alumni" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-6">校友卡</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'other' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-safe" aria-labelledby="ui-id-7" aria-selected="false"><a href="#tabs-safe" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-7">24H安全</a></li>
</ul>