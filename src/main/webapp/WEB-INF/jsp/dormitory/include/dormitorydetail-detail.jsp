<div class="row house-detail-info">
	<div class="house-score pull-right">
		用户评分
		<div class="starBox" data-score="${dormitory['rating']}"></div>
	</div>
	<div class="house-text-info">
		<div class="title">${dormitory['name']}</div>
		<div class="address">${dormitory['address']},&nbsp${dormitory['postcode']}</div>
		<p><span style="font-weight: bolder">设施：</span></p>
		<p><textarea readonly class="auto-height-textarea" style="font-family: '微软雅黑';border: 0px;resize: none;overflow-y: hidden;font-size: 13px;width: 666px; height:auto;">${dormitory['equipment']}</textarea></p>
		<p><span style="font-weight: bolder">服务：</span></p>
		<p><textarea readonly class="auto-height-textarea" style="font-family: '微软雅黑';border: 0px;resize: none;overflow-y: hidden;font-size: 13px;width: 666px; height:auto;">${dormitory['service']}</textarea></p>
		<p><span style="font-weight: bolder">优惠：</span></p>
		<p><textarea readonly class="auto-height-textarea" style="font-family: '微软雅黑';border: 0px;resize: none;overflow-y: hidden;font-size: 13px;width: 666px; height:auto;">${dormitory['promotion']}</textarea></p>
		<p><span style="font-weight: bolder">附加费用：</span><span><c:if test="${dormitory['additionalPrice']>=0}"><em>&#163;</em>&nbsp;<fmt:formatNumber value="${dormitory['additionalPrice']}" pattern="#0.00"/></c:if><c:if test="${dormitory['additionalPrice']<0}">暂未定价</c:if></span></p>
	</div>
	<div class="house-tabs">
		<ul>
			<li><a href="#tabs-video">图片视频</a></li>
			<li><a href="#tabs-info">基本介绍</a></li>
			<li><a href="#tabs-compaer">房型对比</a></li>
			<li><a href="#tabs-map">地图</a></li>
			<li><a href="#tabs-air">接机</a></li>
			<li class="min little"><a href="#tabs-pay">付款取消政策</a></li>
			<li><a href="#tabs-qa" style="width: 30;">常见问题</a></li>
			<%--	
			<li class="min"><a href="#tabs-server" style="width: 30;">特色服务</a></li>
			--%>
		</ul>
		<div id="tabs-video">
			<jsp:include page="dormitorydetail-slide.jsp" />
		</div>
		<div id="tabs-info"><textarea style="height: 500px; width: 644px; resize: none; border: 0px;" readonly>${dormitory['description']}</textarea></div>
		<div id="tabs-compaer" class="compare-no">
			<jsp:include page="dormitorydetail-comparison.jsp" />
		</div>
		<div id="tabs-map">
			<div id="map_canvas" style="width:650px; height:500px"></div>
			<input type="hidden" id="dormitoryName" value="${dormitory['name']}" />
			<input type="hidden" id="dormitoryLatitude" value="${dormitory['latitude']}" />
			<input type="hidden" id="dormitoryLongitude" value="${dormitory['longitude']}" />
			<input type="hidden" id="collegeLatitude" value="${college['latitude']}" />
			<input type="hidden" id="collegeLongitude" value="${college['longitude']}" />
			<input type="hidden" id="collegeOriginalName" value="${college['originalName']}" />
		</div>
		<div id="tabs-air">接机</div>
		<div id="tabs-pay"><textarea style="height: 500px; width: 644px; resize: none; border: 0px;" readonly>${dormitory['refund']}</textarea></div>
		<div id="tabs-qa"><textarea style="height: 500px; width: 644px; resize: none; border: 0px;" readonly>${dormitory['question']}</textarea></div>
		<%--
		<div id="tabs-server"><textarea style="height: 500px; width: 644px; resize: none; border: 0px; " readonly>${dormitory['feature']}</textarea></div>
		--%>
	</div>
</div>