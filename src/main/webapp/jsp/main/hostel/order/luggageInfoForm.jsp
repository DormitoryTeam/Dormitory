<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
	<div class="tip-text">
		2014年接机名额还剩1000个
	</div>
	<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
	<input type="hidden" name="pageStep" value="3" />
	<input type="hidden" name="orderType" value="${orderType}"/>
	<input type="hidden" name="command" id="command"/>
	<!-- <a href="<c:url value="/order/dormitory-place-order.html?orderType=pickup"/>" class="addOne">&nbsp;</a>-->
	<div class="btnBox">
		<input class="save btn-place-order-save" value="保存" type="button">
	</div>
	<ul role="tablist" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
		<li aria-selected="false" aria-labelledby="ui-id-1" aria-controls="tabs-personal" tabindex="-1" role="tab" class="ui-state-default ui-corner-top"><a id="ui-id-1" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-personal">个人信息</a></li>
		<li aria-selected="false" aria-labelledby="ui-id-2" aria-controls="tabs-hobby" tabindex="-1" role="tab" class="ui-state-default ui-corner-top"><a id="ui-id-2" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-hobby">航班信息</a></li>
		<li aria-selected="false" aria-labelledby="ui-id-3" aria-controls="tabs-security" tabindex="-1" role="tab" class="ui-state-default ui-corner-top"><a id="ui-id-3" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-security">送达地址</a></li>
		<li aria-selected="true" aria-labelledby="ui-id-4" aria-controls="tabs-additional" tabindex="0" role="tab" class="ui-state-default ui-corner-top ui-tabs-active ui-state-active"><a id="ui-id-4" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-additional">补充信息</a></li>
	</ul>
	<div aria-hidden="false" aria-expanded="true" style="display: block;" role="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom" aria-labelledby="ui-id-4" id="tabs-additional">
		<fieldset>
			<dl>
				<dd>托运行李箱信息(可在订单管理页面更改)</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize1" value="${item.luggageSize1}"/>
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount1" value="${item.luggageAmount1}"/>
				</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize2" value="${item.luggageSize2}"/>
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount2" value="${item.luggageAmount2}"/>
				</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize3" value="${item.luggageSize3}"/>
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount3" value="${item.luggageAmount3}"/>
				</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize4" value="${item.luggageSize4}"/>
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount4" value="${item.luggageAmount4}"/>
				</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize5" value="${item.luggageSize5}"/>
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount5" value="${item.luggageAmount5}"/>
				</dd>
			</dl>
			<dl>
				<dt>&nbsp;</dt>
				<dd>
					<c:if test="${not empty order.id}">
					<button class="btn-style btn-place-order-pre" preStep="<c:url value="/order/dormitory-place-order.html?orderType=pickup&orderId=${order.id}&pageStep=2"/>">上一步</button>
					</c:if>
					<button class="btn-style btn-place-order-next">下一步</button>
				</dd>
			</dl>
		</fieldset>
	</div>
	</form>
</div>

