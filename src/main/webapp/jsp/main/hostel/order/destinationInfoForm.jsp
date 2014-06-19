<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
	<div class="tip-text">
		2014年接机名额还剩1000个
	</div>
	<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
	<input type="hidden" name="pageStep" value="2" />
	<input type="hidden" name="orderType" value="${orderType}"/>
	<input type="hidden" name="command" id="command"/>
	<!-- <a href="<c:url value="/order/dormitory-place-order.html?orderType=pickup"/>" class="addOne">&nbsp;</a>-->
	<div class="btnBox">
		<input class="save btn-place-order-save" value="保存" type="button">
	</div>
	<jsp:include page="/jsp/main/hostel/order/include/pickupOrderTab.jsp"/>	
	
	<div aria-hidden="false" aria-expanded="true" style="display: block;" role="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom" aria-labelledby="ui-id-3" id="tabs-security">
		<fieldset>
			<dl>
				<dt>送达城市</dt>
				<dd>
					<input type="text" name="pickup2City" value="${item.pickup2City}" class="validate" errorFieldName="送达城市"/> (学生手填)
				</dd>
			</dl>
			<dl>
				<dt>送达地址</dt>
				<dd>
					<input type="text" name="pickup2Address" value="${item.pickup2Address}" class="larger validate" errorFieldName="送达地址"/>
				</dd>
			</dl>
			<dl>
				<dt>宿舍</dt>
				<dd>
					<input type="text" name="pickup2Dormitory" value="${item.pickup2Dormitory}"/>(若是公寓宿舍请提供其名字)
				</dd>
			</dl>
			<dl>
				<dt>邮编</dt>
				<dd>
					<input type="text" name="pickup2Postalcode" value="${item.pickup2Postalcode}"/> (若是公寓宿舍请提供其邮编)
				</dd>
			</dl>
			<dl>
				<dt>&nbsp;</dt>
				<dd>
					<c:if test="${not empty order.id}">
					<button class="btn-style btn-place-order-pre" preStep="<c:url value="/order/dormitory-place-order.html?orderType=pickup&orderId=${order.id}&pageStep=1"/>">上一步</button>
					</c:if>
					<button class="btn-style btn-place-order-next">下一步</button>
				</dd>
			</dl>
		</fieldset>
	</div>
	</form>
</div>


