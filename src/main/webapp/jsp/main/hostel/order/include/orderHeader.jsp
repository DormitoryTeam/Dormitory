<div class="reservation-info">
	<span>基本信息</span>
	<fieldset>
		<dl>
			<dt>房屋名</dt>
			<dd>${order.lineItems[0].dormitory.name}</dd>
		</dl>
		<dl>
			<dt>租期</dt>
			<dd><fmt:parseNumber value="${price.contract div 7}" integerOnly="true"/>周${price.contract % 7}天</dd>
		</dl>
		<dl>
			<dt>单价</dt>
			<dd>£${price.weekPrice}</dd>
		</dl>
		<dl>
			<dt>总价</dt>
			<dd>£${price.salePrice}</dd>
		</dl>
		<dl>
			<dt>入住时间</dt>
			<dd><fmt:formatDate value='${order.lineItems[0].roomInfo.checkinDate}' pattern='yyyy-MM-dd'/></dd>
		</dl>
	</fieldset>
</div>