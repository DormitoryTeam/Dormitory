<ul class="compare-title">
	<li class="title-hight">&nbsp;</li>
	<li>入住时间</li>
	<li>房间面积</li>
	<li>床型</li>
	<li>独立卫浴</li>
	<li>share厨房人数</li>
	<li>可否安排朝向</li>
	<li>是否提供语言宿舍</li>
	<li class="title-hight">厨房/客厅设施</li>
	<li>卧室/浴室设施</li>
	<li class="title-hight last">&nbsp;</li>
</ul>
<div class="scroll-pane">
	<div class="scroll-content ">
		<c:forEach var="room" items="${dormitory['rooms']}">
			<ul class="scroll-content-item itme-header">
				<li>
					<h3>${room['name']}</h3> 
					<c:forEach var="contractPrice" items="${room['contractPrice']}">
						<p>
							<span>${contractPrice['contract']}：</span>&#163;${contractPrice['salePrice']}
						</p>
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
			<ul class="scroll-content-item item-body">
				<li>${room['checkinDateString']}</li>
				<li>${room['houseArea']}</li>
				<li>${room['bedType']}</li>
				<li>${room['ensuitBathroom']}</li>
				<li>${room['kitchenPeople']}</li>
				<li>${room['orientationArrange']}</li>
				<li>${room['roomLanguageArrange']}</li>
				<li class="title-hight">
					${room['kitchenEquipment']}
				</li>
				<li>
					${room['bathroomEquipment']}
				</li>
				<li class="title-hight last">
					<input class="btn-style btnBookDormitory" type="submit" class="btnBookDormitory" roomId="${room['id']}" value="立即预定" />
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
		var contract = {"id": ${contractPrice['contractId']}, "name": "${contractPrice['contract']}", "salePrice": ${contractPrice['salePrice']}, "currency": "${contractPrice['currency']}"};
		contracts.push(contract);
	</c:forEach>
	room_contracts["${room['id']}"] = contracts;
</c:forEach>
</script>