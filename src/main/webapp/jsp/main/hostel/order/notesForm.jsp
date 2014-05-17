<div class="reservation-content">
	<jsp:include page="/jsp/main/hostel/order/include/orderHeader.jsp"/>
	<div class="reservation-personal reservation-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
		<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
			<input type="hidden" name="command" id="command"/>
			<input name="pageStep" type="hidden" value="4"/>
			<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
			<input type="hidden" name="contractId" value="${price.contractId}" /> 
			<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
			<input name="preferId" type="hidden" value="${order.orderContact.prefer.id}"/>
					
			<!-- <a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${dormitory.id}&contractId=${price.contractId}&roomInfoId=${roomInfo.id}"/>" class="addOne">&nbsp;</a>-->
			<div class="btnBox">
				<input class="save" type="button" style="background-color: #808080;" value="保存" />
				<input type="button" class="btn-place-order-next" value="提交" />
			</div>
			<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
				<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-personal" aria-labelledby="ui-id-1" aria-selected="false"><a href="#tabs-additional" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">个人信息</a></li>
				<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-hobby" aria-labelledby="ui-id-2" aria-selected="false"><a href="#tabs-additional" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">个人偏好</a></li>
				<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-security" aria-labelledby="ui-id-3" aria-selected="false"><a href="#tabs-additional" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">担保人信息</a></li>
				<li class="ui-state-default ui-corner-left" role="tab" tabindex="-1" aria-controls="tabs-emergency" aria-labelledby="ui-id-4" aria-selected="false"><a href="#tabs-additional" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">紧急联系人信息</a></li>
				<li style="background-color: antiquewhite;" class="ui-state-default ui-corner-left ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-additional" aria-labelledby="ui-id-5" aria-selected="true"><a href="#tabs-additional" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">补充信息</a></li>
			</ul>
			
			
			
			
			<div id="tabs-additional" aria-labelledby="ui-id-5" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: block;" aria-expanded="true" aria-hidden="false">
				<fieldset>
					<dl>
						<dt>毕业院校</dt>
						<dd>
							<c:set var="graduateSchool" value="${order.orderContact.prefer.graduateSchool}" />
							<c:if test="${null == graduateSchool}">
							<c:set var="graduateSchool" value="${user.prefer.graduateSchool}" />
							</c:if>
							<input name="graduateSchool" type="text" value="${graduateSchool}" class="long" />
						</dd>
					</dl>
					<dl>
						<dd>是否需要推送你的入读城市信息?</dd>
						<dd>
							<c:set var="needPush" value="${order.orderContact.prefer.needPush}" />
							<c:if test="${null == needPush}">
							<c:set var="needPush" value="${user.prefer.needPush}" />
							</c:if>
							<input name="needPush" type="radio" value="Y" <c:if test="${needPush}">checked</c:if> /><label>是</label>
							<input name="needPush" type="radio" value="N" <c:if test="${not needPush}">checked</c:if> /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd>我已阅读并同意留学生活网的《条款条例》</dd>
						<dd>
							<c:set var="readClause" value="${order.orderContact.prefer.readClause}" />
							<c:if test="${null == readClause}">
							<c:set var="readClause" value="${user.prefer.readClause}" />
							</c:if>
							<input class="isChoose" name="readClause" type="radio" value="Y" <c:if test="${readClause}">checked</c:if> /><label>是</label> 
							<input class="isChoose" name="readClause" type="radio" value="N" <c:if test="${not readClause}">checked</c:if> /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<c:if test="${not empty order.id}"><button class="btn-style btn-place-order-pre" preStep="<c:url value="/order/dormitory-place-order.html?orderId=${order.id}&pageStep=3"/>">上一步</button></c:if><button class="btn-style btn-place-order-next">提交</button>
						</dd>
					</dl>
				</fieldset>
			</div>
		</form>
	</div>
</div>
<%--
﻿<div class="reservation-content">
	<div class="reservation-info">
		<span>基本信息</span>
		<fieldset>
			<dl>
				<dt>房屋名</dt>
				<dd>${dormitory.name}</dd>
			</dl>
			<dl>
				<dt>租期</dt>
				<dd>${price.contract}</dd>
			</dl>
			<dl>
				<dt>单价</dt>
				<dd>&#163; ${price.salePrice}</dd>
			</dl>
			<dl>
				<dt>总价</dt>
				<dd>&#163;${price.salePrice}</dd>
			</dl>
			<dl>
				<dt>入住时间</dt>
				<dd><fmt:formatDate value='${roomInfo.checkinDate}' pattern='yyyy.MM.dd'/></dd>
			</dl>
		</fieldset>
	</div>
	<div class="reservation-personal reservation-tab">
		<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
			<input type="hidden" name="command" id="command"/>
			<input name="pageStep" type="hidden" value="4"/>
			<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
			<input type="hidden" name="contractId" value="${price.contractId}" /> 
			<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
			<input name="preferId" type="hidden" value="${order.orderContact.prefer.id}"/>
					
			<a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${dormitory.id}&contractId=${price.contractId}&roomInfoId=${roomInfo.id}"/>" class="addOne">&nbsp;</a>
			<div class="btnBox">
				<input class="save" type="button" style="background-color: #808080;" value="保存" />
				<input type="submit" class="btn-place-order-next" value="提交" />
			</div>
			<ul>
				<li><a href="#tabs-additional">个人信息</a></li>
				<li><a href="#tabs-additional">个人偏好</a></li>
				<li><a href="#tabs-additional">担保人信息</a></li>
				<li><a href="#tabs-additional">紧急联系人信息</a></li>
				<li style="background-color: antiquewhite;"><a href="#tabs-additional">补充信息</a></li>
			</ul>
			<div id="tabs-additional">
				<fieldset>
					<dl>
						<dt>毕业院校</dt>
						<dd>
							<c:set var="graduateSchool" value="${order.orderContact.prefer.graduateSchool}" />
							<c:if test="${null == graduateSchool}">
							<c:set var="graduateSchool" value="${user.prefer.graduateSchool}" />
							</c:if>
							<input name="graduateSchool" type="text" value="${graduateSchool}" class="long" />
						</dd>
					</dl>
					<dl>
						<dd>是否需要推送你的入读城市信息?</dd>
						<dd>
							<c:set var="needPush" value="${order.orderContact.prefer.needPush}" />
							<c:if test="${null == needPush}">
							<c:set var="needPush" value="${user.prefer.needPush}" />
							</c:if>
							<input name="needPush" type="radio" value="Y" <c:if test="${needPush}">checked</c:if> /><label>是</label>
							<input name="needPush" type="radio" value="N" <c:if test="${not needPush}">checked</c:if> /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd>我已阅读并同意留学生活网的《条款条例》</dd>
						<dd>
							<c:set var="readClause" value="${order.orderContact.prefer.readClause}" />
							<c:if test="${null == readClause}">
							<c:set var="readClause" value="${user.prefer.readClause}" />
							</c:if>
							<input name="readClause" type="radio" value="Y" <c:if test="${readClause}">checked</c:if> /><label>是</label> 
							<input name="readClause" type="radio" value="N" <c:if test="${not readClause}">checked</c:if> /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<button class="btn-style btn-place-order-next">提交</button>
						</dd>
					</dl>
				</fieldset>
			</div>
		</form>
	</div>
</div>
--%>