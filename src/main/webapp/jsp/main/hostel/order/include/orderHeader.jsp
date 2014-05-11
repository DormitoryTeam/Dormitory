<div class="reservation-info">
	<span style="margin-right: 0px; padding-right: 5px; padding-left: 5px;">基本信息</span>
	<fieldset>
		<dl>
			<dt>房屋名</dt>
			<dd>${order.lineItems[0].dormitory.name}</dd>
		</dl>
		<dl>
			<dt>租期</dt>
			<dd>${order.lineItems[0].contractType.name}</dd>
		</dl>
		<dl>
			<dt>周价</dt>
			<dd><c:if test="${order.lineItems[0].listPrice >= 0}">£&nbsp;<fmt:formatNumber value="${order.lineItems[0].listPrice}" pattern="#0.00"/></c:if><c:if test="${order.lineItems[0].listPrice < 0}">暂未定价</c:if></dd>
		</dl>
		<dl>
			<dt>附加费用</dt>
			<dd><c:if test="${order.lineItems[0].dormitory.additionalPrice >= 0}">£&nbsp;<fmt:formatNumber value="${order.lineItems[0].dormitory.additionalPrice}" pattern="#0.00"/></c:if><c:if test="${order.lineItems[0].dormitory.additionalPrice < 0}">暂未定价</c:if></dd>
		</dl>
		<dl>
			<dt>总价</dt>
			<dd><c:if test="${order.amount >= 0}">£&nbsp;<fmt:formatNumber value="${order.amount}" pattern="#0.00"/></c:if><c:if test="${order.amount < 0}">暂未定价</c:if></dd>
		</dl>
		<dl>
			<dt>入住时间</dt>
			<dd>${order.lineItems[0].roomInfo.checkinDate}</dd>
		</dl>
	</fieldset>
</div>