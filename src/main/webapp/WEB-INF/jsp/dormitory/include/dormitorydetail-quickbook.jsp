<div class="quick">
	<div class="title">快速预定</div>
	
	<a id="arcPopLogin" style="display: none;" href="javascript:void(0)" class="login-btn jQ-loginbtn" data-popupSrc="<c:url value="/user/loadLogin.html"/>">&nbsp;</a>
	<input type="hidden" id="hidUserId" value="${sessionScope.USER_ID}" />
	
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
							<option value="${room['id']}">${room['name']}</option>
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
				<dd style="line-height: 20px;">价格</dd>
				<dt id="quickPricePreview">
					<c:if test="${dormitory['rooms'][0]['contractPrice'][0]['salePrice'] >= 0}">£&nbsp;<fmt:formatNumber value="${dormitory['rooms'][0]['contractPrice'][0]['salePrice']}" pattern="#0.00"/></c:if><c:if test="${dormitory['rooms'][0]['contractPrice'][0]['salePrice'] < 0}">暂未定价</c:if>
				</dt>
			</dl>
		</fieldset>
		<p id="quickRoomNamePreview">${dormitory['rooms'][0]['roomType']}</p>
		<input type="button" class="btn-quick" value="快速预定" ${empty dormitory['rooms'] ? 'disabled' : ''} userId="${userId}" hasOrder="${hasOrder}" id="expressBooking"/>
	</form>
</div>
