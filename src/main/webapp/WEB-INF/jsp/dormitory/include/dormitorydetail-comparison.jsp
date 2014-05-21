<ul class="compare-title">
	<li class="title-hight">
		<select id="choosePeriod">
			<option>选择周期</option>
			<c:forEach var="contractType" items="${contractTypes}">
			<option value="${contractType.key}">${contractType.value}</option>
			</c:forEach>
		</select>
		<p style="margin-top: 20px; color: red; margin-left: 5px; margin-right: 5px; font-size: 12px;">（*如选择后右边周期不变的，为该房间无此类周期合同）</p>
	</li>
	<li style="font-weight:bolder">房间状态</li>
	<li style="font-weight:bolder">入住时间</li>
	<li style="font-weight:bolder">房间面积</li>
	<li style="font-weight:bolder">床型</li>
	<li style="font-weight:bolder">独立卫浴</li>
	<li style="font-weight:bolder">共用厨房人数</li>
	<li style="font-weight:bolder">可否安排朝向</li>
	<li style="font-weight:bolder">可否提供语言宿舍</li>
	<li class="title-hight last">&nbsp;</li>
</ul>
<div class="scroll-pane">
	<div class="scroll-content ">
		<c:forEach var="room" items="${dormitory['rooms']}">
			<ul class="scroll-content-item itme-header">
				<li>
					<h3>${room['name']}</h3> 
					<p><span>周期：</span><span id="period_${room['id']}" style="color: black">${room['contractPrice'][0]['contract']}</span></p>
					<p><span>周价：</span><span id="weekPrice_${room['id']}" style="color: black"><c:if test="${room['contractPrice'][0]['weekPrice'] >= 0}">&#163;&nbsp;<fmt:formatNumber value="${room['contractPrice'][0]['weekPrice']}" pattern="#0.00"/></c:if><c:if test="${room['contractPrice'][0]['weekPrice'] < 0}">暂未定价</c:if></span></p>
					<p><span>总价：</span><span id="price_${room['id']}" style="color: black"><c:if test="${room['contractPrice'][0]['salePrice'] >= 0}">&#163;&nbsp;<fmt:formatNumber value="${room['contractPrice'][0]['salePrice']}" pattern="#0.00"/></c:if><c:if test="${room['contractPrice'][0]['salePrice'] < 0}">暂未定价</c:if></span></p>
				</li>
			</ul>
		</c:forEach>
		<c:if test="${fn:length(dormitory['rooms']) > 0 and fn:length(dormitory['rooms']) < 4}">
			<ul class="scroll-content-item itme-header">
				<li></li>
			</ul>
		</c:if>
	</div>
	<c:if test="${fn:length(dormitory['rooms']) > 0}">
	<div class="scroll-bar-wrap">
		<div class="scroll-bar"></div>
		<div class="srcoll-bar-bg"></div>
	</div>
	</c:if>
	<div class="scroll-content">
		<c:forEach var="room" items="${dormitory['rooms']}">
			<ul class="scroll-content-item item-body" style="height:634px;">
				<li style="height:18px">
					<c:if test="${room['status'] eq '0'}">已订满</c:if>
					<c:if test="${room['status'] eq '1'}">尚有空房</c:if>
					<c:if test="${room['status'] eq '2'}">剩余不多</c:if>
					<c:if test="${room['status'] eq '3'}">仅剩几间</c:if>
					<c:if test="${room['status'] eq '4'}">仅剩9间</c:if>
					<c:if test="${room['status'] eq '5'}">仅剩8间</c:if>
					<c:if test="${room['status'] eq '6'}">仅剩7间</c:if>
					<c:if test="${room['status'] eq '7'}">仅剩6间</c:if>
					<c:if test="${room['status'] eq '8'}">仅剩5间</c:if>
					<c:if test="${room['status'] eq '9'}">仅剩4间</c:if>
					<c:if test="${room['status'] eq '10'}">仅剩3间</c:if>
					<c:if test="${room['status'] eq '11'}">仅剩2间</c:if>
					<c:if test="${room['status'] eq '12'}">仅剩1间</c:if>
					<c:if test="${room['status'] eq '13'}">请先咨询</c:if>
				</li>
				<li style="height:18px"><c:if test="${ '-1' eq room['checkinDate']}">未知</c:if><c:if test="${not( '-1' eq room['checkinDate'])}">${room['checkinDate']}</c:if></li>
				<li style="height:18px"><c:if test="${ '-1' eq room['houseArea']}">未知</c:if><c:if test="${not( '-1' eq room['houseArea'])}">${room['houseArea']}${empty room['houseArea'] ? '' : '平米'}</c:if></li>
				<li style="height:18px"><c:if test="${ '-1' eq room['bedType']}">未知</c:if><c:if test="${not( '-1' eq room['bedType'])}">${room['bedType']}</c:if></li>
				<li style="height:18px">${room['ensuitBathroom'] ? '有' : '没有'}</li>
				<li style="height:18px"><c:if test="${ '-1' eq room['kitchenPeople']}">未知</c:if><c:if test="${not( '-1' eq room['kitchenPeople'])}">${room['kitchenPeople']}</c:if></li>
				<li style="height:18px">${room['orientationArrange'] ? '可以' : '不可以'}</li>
				<li style="height:18px">${room['roomLanguageArrange'] ? '可以' : '不可以'}</li>
				<li class="title-hight last">
					<c:if test="${not (room['status'] eq '0')}">
						<a href="javascript:void(0)" class="btn-style jQ-quick" roomId="${room['id']}" data-popupSrc="<c:url value='/dormitory/dormitory-quik-book.html'/>">立即预定</a>
					</c:if>
				</li>
			</ul>
		</c:forEach>
		<c:if test="${fn:length(dormitory['rooms']) > 0 and fn:length(dormitory['rooms']) < 4}">
			<ul class="scroll-content-item item-body" style="height:634px;">
				<li style="height:18px"></li>
				<li style="height:18px"></li>
				<li style="height:18px"></li>
				<li style="height:18px"></li>
				<li style="height:18px"></li>
				<li style="height:18px"></li>
				<li style="height:18px"></li>
				<li style="height:18px"></li>
				<li style="height:18px"></li>
			</ul>
		</c:if>
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
		//var contract = {"id": ${contractPrice['contractId']}, "name": "${contractPrice['contract']}", "salePrice": ${contractPrice['salePrice']}, "currency": "${contractPrice['currency']}", "roomName": "${room['name']}", "roomType": "${room['roomType']}"};
		var contract = {"id": ${contractPrice['contractId']}, "name": "${contractPrice['contract']}", "salePrice": ${contractPrice['salePrice']}, "currency": "${contractPrice['currency']}", "roomName": "${room['name']}"};
		contracts.push(contract);
	</c:forEach>
	room_contracts["${room['id']}"] = contracts;
</c:forEach>

var contract_room_price ={};
var room_ids = [];
<c:forEach var="contractType" items="${contractTypes}">
contract_room_price['${contractType.key}'] = {};
</c:forEach>
<c:forEach var="room" items="${dormitory['rooms']}">
	room_ids.push('${room['id']}');
	<c:forEach var="contractPrice" items="${room['contractPrice']}">
		var tempData = {"period": "${contractPrice['contract']}", 
			"weekPrice" : "<c:if test="${contractPrice['weekPrice'] >= 0}">£ <fmt:formatNumber value="${contractPrice['weekPrice']}" pattern="#0.00"/></c:if><c:if test="${contractPrice['weekPrice'] < 0}">暂未定价</c:if>",
			"price": "<c:if test="${contractPrice['salePrice'] >= 0}">£ <fmt:formatNumber value="${contractPrice['salePrice']}" pattern="#0.00"/></c:if><c:if test="${contractPrice['salePrice'] < 0}">暂未定价</c:if>"
			}
		contract_room_price['${contractPrice["contractId"]}']['${room["id"]}'] = tempData;
	</c:forEach>
</c:forEach>

</script>