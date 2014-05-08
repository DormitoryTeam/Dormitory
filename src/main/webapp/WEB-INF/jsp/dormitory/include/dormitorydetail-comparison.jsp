<ul class="compare-title">
	<li class="title-hight">&nbsp;</li>
	<li>房间状态</li>
	<li>入住时间</li>
	<li>房间面积</li>
	<li>床型</li>
	<li>独立卫浴</li>
	<li>共用厨房人数</li>
	<li>可否安排朝向</li>
	<li>可否提供语言宿舍</li>
	<li class="title-hight last">&nbsp;</li>
</ul>
<div class="scroll-pane">
	<div class="scroll-content ">
		<c:forEach var="room" items="${dormitory['rooms']}">
			<ul class="scroll-content-item itme-header">
				<li>
					<h3>${room['name']}</h3> 
					<c:forEach var="contractPrice" items="${room['contractPrice']}">
						<p><span>周期：</span>${contractPrice['contract']}</p>
						<p><span>周价：</span>&#163;${contractPrice['weekPrice']}</p>
						<p><span>总价：</span>&#163;${contractPrice['salePrice']}</p>
					</c:forEach>
				</li>
			</ul>
		</c:forEach>
	</div>
	<div class="scroll-bar-wrap">
		<div class="scroll-bar"></div>
		<div class="srcoll-bar-bg"></div>
	</div>
	<div class="scroll-content">
		<c:forEach var="room" items="${dormitory['rooms']}">
			<ul class="scroll-content-item item-body" style="height:634px;">
				<li>&nbsp;
					<c:if test="${room['status'] eq 'HAS_VACANCY'}">尚有空房</c:if>
					<c:if test="${room['status'] eq 'NO_VACANCY'}">已注满</c:if>
				</li>
				<li>&nbsp;${room['checkinDate']}</li>
				<li>&nbsp;${room['houseArea']}${empty room['houseArea'] ? '' : '平米'}</li>
				<li>&nbsp;${room['bedType']}</li>
				<li>&nbsp;${room['ensuitBathroom'] ? '有' : '没有'}</li>
				<li>&nbsp;${room['kitchenPeople']}</li>
				<li>&nbsp;${room['orientationArrange'] ? '可以' : '不可以'}</li>
				<li>&nbsp;${room['roomLanguageArrange'] ? '可以' : '不可以'}</li>
				<li class="title-hight last">
					<c:if test="${room['status'] eq 'HAS_VACANCY'}">
						<a href="javascript:void(0)" class="btn-style jQ-quick" roomId="${room['id']}" data-popupSrc="<c:url value='/dormitory/dormitory-quik-book.html'/>">立即预定</a>
					</c:if>
				</li>
			</ul>
		</c:forEach>
	</div>
</div>


<form id="placeOrderForm" action="<c:url value="/order/dormitory-place-order.html"/>" method="GET">
	<input type="hidden" name="dormitoryId" value="${dormitory['id']}" />
	<input type="hidden" id="contractId" name="contractId" /> 
	<input type="hidden" id="roomInfoId" name="roomInfoId" />
</form>
<div id="chooseContract">

</div>
<script>
var room_contracts = {};
<c:forEach var="room" items="${dormitory['rooms']}">
	var contracts = [];
	<c:forEach var="contractPrice" items="${room['contractPrice']}">
		var contract = {"id": ${contractPrice['contractId']}, "name": "${contractPrice['contract']}", "salePrice": ${contractPrice['salePrice']}, "currency": "${contractPrice['currency']}", "roomName": "${room['name']}", "roomType": "${room['roomType']}"};
		contracts.push(contract);
	</c:forEach>
	room_contracts["${room['id']}"] = contracts;
</c:forEach>
</script>