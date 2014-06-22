<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
	<div class="tip-text">
		2014年接机名额还剩1000个
	</div>
	<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
	<input type="hidden" name="pageStep" value="1" />
	<input type="hidden" name="action" value="${action}"/>
	<input type="hidden" name="orderType" value="${orderType}"/>
	<input type="hidden" name="command" id="command"/>
	<!-- <a class="addOne" href="<c:url value="/order/dormitory-place-order.html?orderType=pickup"/>">&nbsp;</a>-->
	<div class="btnBox">
		<c:if test="${'edit' eq action}">
			<input type="button" class="save btn-back" value="返回" data-url="<c:url value="/user/orderList.html"/>"/>
		</c:if>
		<input type="button" value="保存" class="save btn-place-order-save">
	</div>
	<jsp:include page="/jsp/main/hostel/order/include/pickupOrderTab.jsp"/>	
	<div id="tabs-hobby" aria-labelledby="ui-id-2" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: block;" aria-expanded="true" aria-hidden="false">
		<fieldset>
			<dl>
				<dt>起飞时间</dt>
				<dd>
					<input style="width:180px;" type="text" class="timepicker validate" errorFieldName="起飞时间" name="takeOffDate" value="<fmt:formatDate value='${item.takeOffDate}' pattern='yyyy-MM-dd HH:mm'/>"/>&nbsp;<span style="color: red;">（请选择准确的起飞时间）</span>
				</dd>
			</dl>
			<dl>
				<dt class="long">起飞城市</dt>
				<dd>
					<input type="text" name="takeOffCity" errorFieldName="起飞城市" value="${item.takeOffCity}" class="min validate"/>
				</dd>
				<dt class="long">抵达城市</dt>
				<dd>
					<input type="text" name="arrivalCity" errorFieldName="抵达城市" value="${item.arrivalCity}" class="min validate"/>
				</dd>
			</dl>
			<dl>
				<dt>抵达国家</dt>
				<dd>
					<input type="text" name="arrivalCountry" errorFieldName="抵达国家" value="${item.arrivalCountry}" class="min validate"/>
				</dd>
			</dl>
			<dl>
				<dt>抵达机场</dt>
				<dd>
					<input type="text" name="arrivalAirport" errorFieldName="抵达机场" value="${item.arrivalAirport}"/>
				</dd>
			</dl>
			<dl>
				<dt>抵达时间</dt>
				<dd>
					<input type="text" style="width:180px;" class="timepicker validate" errorFieldName="抵达时间" name="pickupDate" value="<fmt:formatDate value='${item.pickupDate}' pattern='yyyy-MM-dd HH:mm'/>"/>&nbsp;<span style="color: red;">（请选择准确的抵达时间）</span>
				</dd>
			</dl>
			<dl>
				<dt>航空公司</dt>
				<dd>
					<input type="text" name="flightCompany" value="${item.flightCompany}" class="validate" errorFieldName="航空公司"/>
				</dd>
			</dl>
			<dl>
				<dt>航班号</dt>
				<dd>
					<input type="text" name="flightNumber" value="${item.flightNum}" placeholder="xxx转xxx" class="validate" errorFieldName="航班号"/>
				</dd>
			</dl>
			<dl>
				<dt>&nbsp;</dt>
				<dd>
					<c:if test="${not empty order.id}">
					<button class="btn-style btn-place-order-pre" preStep="<c:url value="/order/dormitory-place-order.html?orderType=pickup&orderId=${order.id}&pageStep=0"/>">上一步</button>
					</c:if>
					<button class="btn-style btn-place-order-next">下一步</button>
				</dd>
			</dl>
		</fieldset>
	</div>
	</form>
</div>
