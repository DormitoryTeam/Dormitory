<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
	<div class="tip-text">
		2014年接机名额还剩1000个
	</div>
	<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
	<input type="hidden" name="pageStep" value="3" />
	<input type="hidden" name="action" value="${action}"/>
	<input type="hidden" name="orderType" value="${orderType}"/>
	<input type="hidden" name="command" id="command"/>
	<!-- <a href="<c:url value="/order/dormitory-place-order.html?orderType=pickup"/>" class="addOne">&nbsp;</a>-->
	<div class="btnBox">
		<c:if test="${'edit' eq action}">
			<input type="button" class="save btn-back" value="返回" data-url="<c:url value="/user/orderList.html"/>"/>
		</c:if>
		<input class="save btn-place-order-save" value="保存" type="button">
	</div>
	<jsp:include page="/jsp/main/hostel/order/include/pickupOrderTab.jsp"/>
	<div aria-hidden="false" aria-expanded="true" style="display: block;" role="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom" aria-labelledby="ui-id-4" id="tabs-additional">
		<fieldset>
			<dl>
				<dd>托运行李箱信息(可在订单管理页面更改)</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize1" value="${item.luggageSize1}" style="width:100px;" class="validate" errorFieldName="第一排尺寸" />&nbsp;（寸）
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount1" value="${item.luggageAmount1}" style="width:100px;" class="validate" errorFieldName="第一排个数" />&nbsp;（个）
				</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize2" value="${item.luggageSize2}" style="width:100px;"/>&nbsp;（寸）
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount2" value="${item.luggageAmount2}" style="width:100px;"/>&nbsp;（个）
				</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize3" value="${item.luggageSize3}" style="width:100px;"/>&nbsp;（寸）
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount3" value="${item.luggageAmount3}" style="width:100px;"/>&nbsp;（个）
				</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize4" value="${item.luggageSize4}" style="width:100px;"/>&nbsp;（寸）
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount4" value="${item.luggageAmount4}" style="width:100px;"/>&nbsp;（个）
				</dd>
			</dl>
			<dl>
				<dt>尺寸</dt>
				<dd>
					<input type="text" name="luggageSize5" value="${item.luggageSize5}" style="width:100px;"/>&nbsp;（寸）
				</dd>
				<dt class="min">个数</dt>
				<dd>
					<input type="text" name="luggageAmount5" value="${item.luggageAmount5}" style="width:100px;"/>&nbsp;（个）
				</dd>
			</dl>
			<dl>
				<dt>&nbsp;</dt>
				<dd>
					<c:if test="${not empty order.id}">
					<button class="btn-style btn-place-order-pre" preStep="<c:url value="/order/dormitory-place-order.html?orderType=pickup&orderId=${order.id}&pageStep=2&action=${action}"/>">上一步</button>
					</c:if>
					<button class="btn-style btn-place-order-next">下一步</button>
				</dd>
			</dl>
		</fieldset>
	</div>
	</form>
</div>

