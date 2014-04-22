<div class="quick">
	<div class="title">快速预定</div>
	<form id="quickPlaceOrderForm" action="<c:url value="/order/dormitory-place-order.html"/>" method="GET">
		<input type="hidden" name="dormitoryId" value="${dormitory['id']}" />
		<input type="hidden" id="quickContractId" name="contractId" /> 
		<input type="hidden" id="quickRoomInfoId" name="roomInfoId" />
		<fieldset>
			<dl class="clearfix">
				<dd>房型</dd>
				<dt>
					<select id="selectQuickRoom">
						<c:forEach var="room" items="${dormitory['rooms']}">
							<option value="${room['id']}">${room['roomType']}</option>
						</c:forEach>
					</select>
				</dt>
			</dl>
			<dl class="clearfix">
				<dd>租期</dd>
				<dt>
					<select id="selectQuickContract">
						<c:forEach var="contractPrice" items="${dormitory['rooms'][0]['contractPrice']}">
							<option value="${contractPrice['contractId']}">${contractPrice['contract']}</option>
						</c:forEach>
					</select>
				</dt>
			</dl>
			<dl class="clearfix">
				<dd>价格</dd>
				<dt id="quickPricePreview">
					${dormitory['rooms'][0]['contractPrice'][0]['currency']}&nbsp;${dormitory['rooms'][0]['contractPrice'][0]['salePrice']}
				</dt>
			</dl>
		</fieldset>
		<p id="quickRoomNamePreview">${dormitory['rooms'][0]['name']}</p>
		<input type="button" class="btn-quick" value="快速预定" />
	</form>
</div>