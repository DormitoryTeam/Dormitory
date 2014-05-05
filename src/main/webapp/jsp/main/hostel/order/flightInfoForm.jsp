<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
	<div class="tip-text">
		2014年接机名额还剩1000个
	</div>
	<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
	<input type="hidden" name="pageStep" value="1" />
	<input type="hidden" name="orderType" value="${orderType}"/>
	<input type="hidden" name="command" id="command"/>
	<a class="addOne" href="<c:url value="/order/dormitory-place-order.html?orderType=pickup"/>">&nbsp;</a>
	<div class="btnBox">
		<input type="button" value="保存" class="save btn-place-order-save">
	</div>
	<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
		<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-personal" aria-labelledby="ui-id-1" aria-selected="false"><a href="#tabs-personal" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">个人信息</a></li>
		<li class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-hobby" aria-labelledby="ui-id-2" aria-selected="true"><a href="#tabs-hobby" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">航班信息</a></li>
		<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-security" aria-labelledby="ui-id-3" aria-selected="false"><a href="#tabs-security" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">送达地址</a></li>
		<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-additional" aria-labelledby="ui-id-4" aria-selected="false"><a href="#tabs-additional" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">补充信息</a></li>
	</ul>
	
	<div id="tabs-hobby" aria-labelledby="ui-id-2" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: block;" aria-expanded="true" aria-hidden="false">
		<fieldset>
			<dl>
				<dt>起飞时间</dt>
				<dd>
					<input type="text" class="datepicker" name="takeOffDate" value="<fmt:formatDate value='${item.takeOffDate}' pattern='yyyy-MM-dd'/>"/>
				</dd>
			</dl>
			<dl>
				<dt class="long">起飞城市</dt>
				<dd>
					<input type="text" name="takeOffCity" value="${item.takeOffCity}" class="min"/>
				</dd>
				<dt class="long">抵达城市</dt>
				<dd>
					<input type="text" name="arrivalCity" value="${item.arrivalCity}" class="min"/>
				</dd>
			</dl>
			<dl>
				<dt>抵达国家</dt>
				<dd>
					<input type="text" name="arrivalCountry" value="${item.arrivalCountry}" class="min"/>
				</dd>
			</dl>
			<dl>
				<dt>抵达机场</dt>
				<dd>
					<input type="text" name="arrivalAirport" value="${item.arrivalAirport}"/>
				</dd>
			</dl>
			<dl>
				<dt>接机时间</dt>
				<dd>
					<input type="text" class="datepicker" name="pickupDate" value="<fmt:formatDate value='${item.pickupDate}' pattern='yyyy-MM-dd'/>"/>
				</dd>
			</dl>
			<dl>
				<dt>航空公司</dt>
				<dd>
					<input type="text" name="flightCompany" value="${item.flightCompany}"/>
				</dd>
			</dl>
			<dl>
				<dt>航班号</dt>
				<dd>
					<input type="text" name="flightNumber" value="${item.flightNum}" placeholder="xxx转xxx"/>
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
