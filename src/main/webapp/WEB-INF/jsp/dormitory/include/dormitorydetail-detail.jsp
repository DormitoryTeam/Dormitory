<div class="row house-detail-info">
	<div class="house-score pull-right">
		用户评分
		<div class="starBox" data-score="${dormitory['rating']}"></div>
	</div>
	<div class="house-text-info">
		<div class="title">${dormitory['name']}</div>
		<div class="address">${dormitory['address']}</div>
		<p>设施：
			<c:forEach var="binaryEquipment" items="${dormitory['binaryEquipmentArray']}" varStatus="i">
				<c:if test="${binaryEquipment eq '1'.charAt(0)}">
					<c:if test="${hasOneEquipment eq 1}">ã</c:if>
					<c:set var="hasOneEquipment" value="1" />
					${equipments[i['index']]}
				</c:if>
			</c:forEach>
		</p>
		<p>服务：
			<c:forEach var="binaryService" items="${dormitory['binaryServiceArray']}" varStatus="i">
				<c:if test="${binaryService eq '1'.charAt(0)}">
					<c:if test="${hasOneService > 0}">ã</c:if>
					<c:set var="hasOneService" value="1" />
					${services[i['index']]}
				</c:if>
			</c:forEach>
		</p>
	</div>
	<div class="house-tabs">
		<ul>
			<li><a href="#tabs-video">图片视频</a></li>
			<li><a href="#tabs-info">基本介绍</a></li>
			<li><a href="#tabs-compaer">房型对比</a></li>
			<li><a href="#tabs-map">地图</a></li>
			<li><a href="#tabs-air">接机</a></li>
			<li class="min little"><a href="#tabs-pay">付款取消政策</a></li>
			<li class="min"><a href="#tabs-qa">常见问题</a></li>
			<li class="min"><a href="#tabs-server">特色服务</a></li>
		</ul>
		<div id="tabs-video">
			<jsp:include page="dormitorydetail-slide.jsp" />
		</div>
		<div id="tabs-info">${dormitory['description']}</div>
		<div id="tabs-compaer" class="compare-no">
			<jsp:include page="dormitorydetail-comparison.jsp" />
		</div>
		<div id="tabs-map">
			<div id="map_canvas" style="width:650px; height:500px"></div>
			<input type="hidden" id="dormitoryName" value="${dormitory['name']}" />
			<input type="hidden" id="dormitoryLatitude" value="${dormitory['latitude']}" />
			<input type="hidden" id="dormitoryLongitude" value="${dormitory['longitude']}" />
		</div>
		<div id="tabs-air">接机</div>
		<div id="tabs-pay">付款取消政策</div>
		<div id="tabs-qa">常见问题</div>
		<div id="tabs-server">特色服务</div>
	</div>
</div>