<%@ taglib uri="/dormitory" prefix="dor"%>
<html>
${message}
<form method="POST" action="<c:url value='/admin/order/editPickupOrder.html'/>">
	<input type="hidden" name="orderId" value="${order.id}" />
	<hr>
	<h2>订单基本信息</h2>
	订单编号:&nbsp;&nbsp;
	<dor:getOrderToken orderId="${order.id}" />
	<br> 订单价格:&nbsp;&nbsp;${order.amount}<br> 当前状态:&nbsp;&nbsp;
	<c:choose>
		<c:when test="${'INITIAL' eq order.orderStatus}">等待用户完成订单</c:when>
		<c:when test="${'COMMIT' eq order.orderStatus}">已提交,等待审核</c:when>
		<c:when test="${'REVIEWDE' eq order.orderStatus}">审核完成，已发送付款邮件</c:when>
		<c:when test="${'PAYMENT_DONE' eq order.orderStatus}">已支付，已发送车票邮件</c:when>
		<c:when test="${'PAYMENT_NOT_DONE' eq order.orderStatus}">未支付，已发送车票邮件</c:when>
		<c:otherwise>已支付，已发送车票邮件</c:otherwise>
	</c:choose>
	<br>
	<hr>
	<h2>个人信息</h2>
	<c:set var="gender" value="${order.orderContact.belongsToInfo.gender}" />
	称呼: <select name="gender">
		<option value="0" <c:if test="${gender eq 0}">selected</c:if>>Mr.</option>
		<option value="1" <c:if test="${gender eq 1}">selected</c:if>>Mrs.</option>
		<option value="2" <c:if test="${gender eq 2}">selected</c:if>>Miss</option>
	</select><br> 姓：
	<c:set var="lastName" value="${order.orderContact.belongsToInfo.lastName}" />
	<input name="lastName" type="text" value="${lastName}" class="min validate" errorFieldName="姓" /><br> 名：
	<c:set var="name" value="${order.orderContact.belongsToInfo.name}" />
	<input name="name" type="text" value="${name}" class="min validate" errorFieldName="名" /><br> 国籍：
	<c:set var="nationality" value="${order.orderContact.belongsToInfo.nationality}" />
	<input name="nationality" type="text" value="${nationality}" class="validate" errorFieldName="国籍" /><br> 出生日期：
	<c:set var="birthday" value="${order.orderContact.belongsToInfo.birthday}" />
	<input class="datepicker validate" errorFieldName="出生日期" name="birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" /><br> 电子邮件：
	<c:set var="email" value="${order.orderContact.belongsToInfo.email}" />
	<input id="login" name="email" type="text" class="long validate" errorFieldName="电子邮件" value="${email}" /><br> QQ：
	<c:set var="qq" value="${order.orderContact.belongsToInfo.qq}" />
	<input name="qq" type="text" value="${qq}" class="validate" errorFieldName="QQ" /><br> 微信号：
	<c:set var="wechat" value="${order.orderContact.belongsToInfo.wechat}" />
	<input name="wechat" type="text" value="${wechat}" class="validate" errorFieldName="微信号" /><br> 手机号码：
	<c:set var="phone" value="${order.orderContact.belongsToInfo.phone}" />
	<input name="phone" type="text" value="${phone}" class="validate" errorFieldName="手机号码" /> 家庭住址：
	<c:set var="country" value="${order.orderContact.belongsToInfo.country}" />
	<c:set var="province" value="${order.orderContact.belongsToInfo.province}" />
	<c:set var="city" value="${order.orderContact.belongsToInfo.city}" />
	<c:set var="county" value="${order.orderContact.belongsToInfo.county}" />
	<c:set var="address" value="${order.orderContact.belongsToInfo.address}" />
	<input name="country" type="text" value="${country}" class="min validate" errorFieldName="国家" />&nbsp;(国家)&nbsp;<input name="province" type="text" value="${province}" class="min validate" errorFieldName="省" />&nbsp;(省)&nbsp;<input name="city" type="text"
		value="${city}" class="min validate" errorFieldName="市" />&nbsp;(市)&nbsp;<input name="county" type="text" value="${county}" class="min validate" errorFieldName="区县" />&nbsp;(区县)<br> <input name="address" type="text" value="${address}" class="larger validate"
		errorFieldName="街道地址" />&nbsp;(街道地址)<br>
	<c:set var="postalcode" value="${order.orderContact.belongsToInfo.postalcode}" />
	<input name="postalcode" type="text" value="${postalcode}" class="mini validate" errorFieldName="邮编" />&nbsp;(邮编)<br>
	<hr>
	<h2>航班信息</h2>
	起飞日期： <input type="text" class="datepicker" name="takeOffDate" value="<fmt:formatDate value='${item.takeOffDate}' pattern='yyyy-MM-dd'/>" /><br> 起飞城市：<input type="text" name="takeOffCity" value="${item.takeOffCity}" class="min" /><br> 抵达城市： <input type="text"
		name="arrivalCity" value="${item.arrivalCity}" class="min" /><br> 抵达国家：<input type="text" name="arrivalCountry" value="${item.arrivalCountry}" class="min" /><br> 抵达机场： <input type="text" name="arrivalAirport" value="${item.arrivalAirport}" /><br> 抵达时间：<input
		type="text" style="width: 180px;" class="timepicker" name="pickupDate" value="<fmt:formatDate value='${item.pickupDate}' pattern='yyyy-MM-dd HH:mm'/>" /><br> 航空公司：<input type="text" name="flightCompany" value="${item.flightCompany}" /><br> 航班号：<input
		type="text" name="flightNumber" value="${item.flightNum}" placeholder="xxx转xxx" /><br>
	<hr>
	<h2>送达地址</h2>
	城市：<input type="text" name="pickup2City" value="${item.pickup2City}" /><br> 地址： <input type="text" name="pickup2Address" value="${item.pickup2Address}" class="larger" /><br> 宿舍：<input type="text" name="pickup2Dormitory" value="${item.pickup2Dormitory}" /><br>
	邮编：<input type="text" name="pickup2Postalcode" value="${item.pickup2Postalcode}" /><br>
	<hr>
	<h2>补充信息</h2>
	尺寸： <input type="text" name="luggageSize1" value="${item.luggageSize1}" />&nbsp;&nbsp;个数：<input type="text" name="luggageAmount1" value="${item.luggageAmount1}" /><br> 尺寸： <input type="text" name="luggageSize2" value="${item.luggageSize2}" />&nbsp;&nbsp;个数：<input
		type="text" name="luggageAmount2" value="${item.luggageAmount2}" /><br> 尺寸： <input type="text" name="luggageSize3" value="${item.luggageSize3}" />&nbsp;&nbsp;个数：<input type="text" name="luggageAmount3" value="${item.luggageAmount3}" /><br> 尺寸： <input
		type="text" name="luggageSize4" value="${item.luggageSize4}" />&nbsp;&nbsp;个数：<input type="text" name="luggageAmount4" value="${item.luggageAmount4}" /><br> 尺寸： <input type="text" name="luggageSize5" value="${item.luggageSize5}" />&nbsp;&nbsp;个数：<input type="text"
		name="luggageAmount5" value="${item.luggageAmount5}" /><br>
	<hr>
	价格：<input type="text" name="price" value="${order.amount}" /> <br> 支付链接： <input type="text" name="paymentUrl" value="${item.paymentUrl}" /><br> 
	当前状态:&nbsp;&nbsp;
	<c:choose>
		<c:when test="${'INITIAL' eq order.orderStatus}">等待用户完成订单</c:when>
		<c:when test="${'COMMIT' eq order.orderStatus}">已提交,等待审核</c:when>
		<c:when test="${'REVIEWDE' eq order.orderStatus}">审核完成，已发送付款邮件</c:when>
		<c:when test="${'PAYMENT_DONE' eq order.orderStatus}">已支付，已发送车票邮件</c:when>
		<c:when test="${'PAYMENT_NOT_DONE' eq order.orderStatus}">未支付，已发送车票邮件</c:when>
		<c:otherwise>已支付，已发送车票邮件</c:otherwise>
	</c:choose><br>
	操作：<input name="operation" type="radio" value="" checked />更新信息&nbsp;&nbsp;|&nbsp;&nbsp;<input name="operation" type="radio" value="REVIEWDE" />审核，发送付款邮件&nbsp;&nbsp; | &nbsp;&nbsp;<input 	name="operation" type="radio" value="PAYMENT_DONE" />确认已支付，发送车票邮件&nbsp;&nbsp; | &nbsp;&nbsp;<input 	name="operation" type="radio" value="PAYMENT_NOT_DONE" />未支付，发送车票邮件<br> 
	<input type="submit" value="提交" /> <a href="<c:url value="/admin/order/orderList.html"/>">返回</a>
</form>
</html>