<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
	<div class="tip-text">
		2014年接机名额还剩1000个
	</div>
	<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
	<input type="hidden" name="pageStep" value="2" />
	<input type="hidden" name="orderType" value="${orderType}"/>
	<input type="hidden" name="command" id="command"/>
	<a href="<c:url value="/order/dormitory-place-order.html?orderType=pickup"/>" class="addOne">&nbsp;</a>
	<div class="btnBox">
		<input class="save btn-place-order-save" value="保存" type="button">
	</div>
	<ul role="tablist" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
		<li aria-selected="false" aria-labelledby="ui-id-1" aria-controls="tabs-personal" tabindex="-1" role="tab" class="ui-state-default ui-corner-top"><a id="ui-id-1" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-personal">个人信息</a></li>
		<li aria-selected="false" aria-labelledby="ui-id-2" aria-controls="tabs-hobby" tabindex="-1" role="tab" class="ui-state-default ui-corner-top"><a id="ui-id-2" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-hobby">航班信息</a></li>
		<li aria-selected="true" aria-labelledby="ui-id-3" aria-controls="tabs-security" tabindex="0" role="tab" class="ui-state-default ui-corner-top ui-tabs-active ui-state-active"><a id="ui-id-3" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-security">送达地址</a></li>
		<li aria-selected="false" aria-labelledby="ui-id-4" aria-controls="tabs-additional" tabindex="-1" role="tab" class="ui-state-default ui-corner-top"><a id="ui-id-4" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-additional">补充信息</a></li>
	</ul>
	
	
	<div aria-hidden="false" aria-expanded="true" style="display: block;" role="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom" aria-labelledby="ui-id-3" id="tabs-security">
		<fieldset>
			<dl>
				<dt>城市</dt>
				<dd>
					<input type="text" name="pickup2City" value="${item.pickup2City}"/> (学生手填)
				</dd>
			</dl>
			<dl>
				<dt>地址</dt>
				<dd>
					<input type="text" name="pickup2Address" value="${item.pickup2Address}" class="larger"/>
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
					<input type="text" name="pickup2Postalcode" value="${item.pickup2Postalcode}"/> (若是公寓宿舍请提供其名字)
				</dd>
			</dl>
			<dl>
				<dt>&nbsp;</dt>
				<dd>
					<button class="btn-style btn-user-info-save">下一步</button>
				</dd>
			</dl>
		</fieldset>
	</div>
	</form>
</div>


