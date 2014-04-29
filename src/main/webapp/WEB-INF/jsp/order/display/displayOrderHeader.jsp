<div class="reservation-info">
	<span style="margin-right: 0px; padding-right: 5px; padding-left: 5px;">基本信息</span>
	<fieldset>
		<dl>
			<dt>房屋名</dt>
			<dd>${order.lineItems[0].dormitory.name}</dd>
		</dl>
		<dl>
			<dt>租期</dt>
			<dd><fmt:parseNumber value="${order.lineItems[0].contractType.name div 7}" integerOnly="true"/>周${order.lineItems[0].contractType.name % 7}天</dd>
		</dl>
		<dl>
			<dt>周价</dt>
			<dd>£${order.lineItems[0].listPrice}</dd>
		</dl>
		<dl>
			<dt>附加费用</dt>
			<dd>£${order.lineItems[0].dormitory.additionalPrice}</dd>
		</dl>
		<dl>
			<dt>总价</dt>
			<dd>£${order.amount}</dd>
		</dl>
		<dl>
			<dt>入住时间</dt>
			<dd><fmt:formatDate value='${order.lineItems[0].roomInfo.checkinDate}' pattern='yyyy-MM-dd'/></dd>
		</dl>
	</fieldset>
</div>