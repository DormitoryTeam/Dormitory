<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
	<li class="ui-state-default ui-corner-top<c:if test="${'userInfo' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="0" aria-controls="tabs-data" aria-labelledby="ui-id-8" aria-selected="true"><a href="<c:url value='/user/editUserInfo.html?pageStep=0'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-8">个人资料</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'prefer' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-preference" aria-labelledby="ui-id-9" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=1'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-9">个人偏好</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'guarantee' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-warrantor" aria-labelledby="ui-id-10" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=2'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-10">担保人信息</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'contact' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-emergency" aria-labelledby="ui-id-11" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=3'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-11">紧急联系人信息</a></li>
	<li class="ui-state-default ui-corner-top<c:if test="${'note' eq param.pageName}"> ui-tabs-active ui-state-active</c:if>" role="tab" tabindex="-1" aria-controls="tabs-additional" aria-labelledby="ui-id-12" aria-selected="false"><a href="<c:url value='/user/editUserInfo.html?pageStep=4'/>" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-12">补充信息</a></li>
</ul>