<%@ taglib uri="/dormitory" prefix="dor"%>
<html>
${message}
<form method="POST" action="<c:url value='/admin/order/editDormitoryOrder.html'/>">
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
		<c:otherwise>已支付，已发送车票邮件</c:otherwise>
	</c:choose>
	<br>
	<hr>
	
	<h2>个人信息</h2>
	<c:set var="gender" value="${order.orderContact.belongsToInfo.gender}" />
	称呼: <select name="order.orderContact.belongsToInfo.gender">
		<option value="0" <c:if test="${gender eq 0}">selected</c:if>>Mr.</option>
		<option value="1" <c:if test="${gender eq 1}">selected</c:if>>Mrs.</option>
		<option value="2" <c:if test="${gender eq 2}">selected</c:if>>Miss</option>
	</select><br> 姓：
	<c:set var="lastName" value="${order.orderContact.belongsToInfo.lastName}" />
	<input name="order.orderContact.belongsToInfo.lastName" type="text" value="${lastName}" class="min validate" errorFieldName="姓" /><br> 名：
	<c:set var="name" value="${order.orderContact.belongsToInfo.name}" />
	<input name="order.orderContact.belongsToInfo.name" type="text" value="${name}" class="min validate" errorFieldName="名" /><br> 国籍：
	<c:set var="nationality" value="${order.orderContact.belongsToInfo.nationality}" />
	<input name="order.orderContact.belongsToInfo.nationality" type="text" value="${nationality}" class="validate" errorFieldName="国籍" /><br> 出生日期：
	<c:set var="birthday" value="${order.orderContact.belongsToInfo.birthday}" />
	<input class="datepicker validate" errorFieldName="出生日期" name="order.orderContact.belongsToInfo.birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" /><br> 电子邮件：
	<c:set var="email" value="${order.orderContact.belongsToInfo.email}" />
	<input id="login" name="order.orderContact.belongsToInfo.email" type="text" class="long validate" errorFieldName="电子邮件" value="${email}" /><br> QQ：
	<c:set var="qq" value="${order.orderContact.belongsToInfo.qq}" />
	<input name="order.orderContact.belongsToInfo.qq" type="text" value="${qq}" class="validate" errorFieldName="QQ" /><br> 微信号：
	<c:set var="wechat" value="${order.orderContact.belongsToInfo.wechat}" />
	<input name="order.orderContact.belongsToInfo.wechat" type="text" value="${wechat}" class="validate" errorFieldName="微信号" /><br> 手机号码：
	<c:set var="phone" value="${order.orderContact.belongsToInfo.phone}" />
	<input name="order.orderContact.belongsToInfo.phone" type="text" value="${phone}" class="validate" errorFieldName="手机号码" /> 家庭住址：
	<c:set var="country" value="${order.orderContact.belongsToInfo.country}" />
	<c:set var="province" value="${order.orderContact.belongsToInfo.province}" />
	<c:set var="city" value="${order.orderContact.belongsToInfo.city}" />
	<c:set var="county" value="${order.orderContact.belongsToInfo.county}" />
	<c:set var="address" value="${order.orderContact.belongsToInfo.address}" />
	<input name="order.orderContact.belongsToInfo.country" type="text" value="${country}" class="min validate" errorFieldName="国家" />&nbsp;(国家)&nbsp;
	<input name="order.orderContact.belongsToInfo.province" type="text" value="${province}" class="min validate" errorFieldName="省" />&nbsp;(省)&nbsp;
	<input name="order.orderContact.belongsToInfo.city" type="text" value="${city}" class="min validate" errorFieldName="市" />&nbsp;(市)&nbsp;
	<input name="order.orderContact.belongsToInfo.county" type="text" value="${county}" class="min validate" errorFieldName="区县" />&nbsp;(区县)<br> 
	<input name="order.orderContact.belongsToInfo.address" type="text" value="${address}" class="larger validate" errorFieldName="街道地址" />&nbsp;(街道地址)<br>
	<c:set var="postalcode" value="${order.orderContact.belongsToInfo.postalcode}" />
	<input name="order.orderContact.belongsToInfo.postalcode" type="text" value="${postalcode}" class="mini validate" errorFieldName="邮编" />&nbsp;(邮编)<br>
	<hr>
	
	<h2>个人偏好</h2>
	是否抽烟：
	<c:set var="smoke" value="${order.orderContact.prefer.smoke}" />
	<input name="smoke" type="radio" value="Y" <c:if test="${smoke}">checked</c:if>/><label>是</label>
	<input name="smoke" type="radio" value="N" <c:if test="${not smoke}">checked</c:if> /><label>否</label>
	<br /> 
	
	是否是素食主义者：
	<c:set var="vegetarianism" value="${order.orderContact.prefer.vegetarianism}" />
	<input name="vegetarianism" type="radio" value="Y" <c:if test="${vegetarianism}">checked</c:if> /><label>是</label>
	<input name="vegetarianism" type="radio" value="N"  <c:if test="${not vegetarianism}">checked</c:if> /><label>否</label>
	<br />
	
	What will be your year of study：
	<c:set var="yourGrade" value="${order.orderContact.prefer.yourGrade}" />
	<input type="radio" name="yourGrade" value="1" <c:if test="${'1' eq yourGrade}">checked</c:if> /><label>大一</label>
	<input type="radio" name="yourGrade" value="2" <c:if test="${'2' eq yourGrade}">checked</c:if> /><label>大二</label>
	<input type="radio" name="yourGrade" value="3" <c:if test="${'3' eq yourGrade}">checked</c:if> /><label>大三</label>
	<input type="radio" name="yourGrade" value="4" <c:if test="${'4' eq yourGrade}">checked</c:if> /><label>大四</label>
	<input type="radio" name="yourGrade" value="5" <c:if test="${'5' eq yourGrade}">checked</c:if> /><label>硕士</label>
	<input type="radio" name="yourGrade" value="6" <c:if test="${'6' eq yourGrade}">checked</c:if> /><label>博士</label>
	<br />
	
	想和哪个年级的人一起住：
	<c:set var="roomMemberGrade" value="${order.orderContact.prefer.roomMemberGrade}" />
	<input type="radio" name="roomMemberGrade" value="1" <c:if test="${'1' eq roomMemberGrade}">checked</c:if> /><label>大一</label>
	<input type="radio" name="roomMemberGrade" value="2" <c:if test="${'2' eq roomMemberGrade}">checked</c:if> /><label>大二</label>
	<input type="radio" name="roomMemberGrade" value="3" <c:if test="${'3' eq roomMemberGrade}">checked</c:if> /><label>大三</label>
	<input type="radio" name="roomMemberGrade" value="4" <c:if test="${'4' eq roomMemberGrade}">checked</c:if> /><label>大四</label>
	<input type="radio" name="roomMemberGrade" value="5" <c:if test="${'5' eq roomMemberGrade}">checked</c:if> /><label>硕士</label>
	<input type="radio" name="roomMemberGrade" value="6" <c:if test="${'6' eq roomMemberGrade}">checked</c:if> /><label>博士</label>
	<br />
	
	室友性别要求：
	<c:set var="roomMemberGender" value="${order.orderContact.prefer.roomMemberGender}" />
	<input name="roomMemberGender" type="radio" value="0" <c:if test="${0 eq roomMemberGender}">checked</c:if> /><label>混合性别</label>
	<input name="roomMemberGender" type="radio" value="1" <c:if test="${1 eq roomMemberGender}">checked</c:if> /><label>我是男性想和所有男性一起住</label>
	<input name="roomMemberGender" type="radio" value="2" <c:if test="${2 eq roomMemberGender}">checked</c:if> /><label>我是女性想和所有女性一起住</label>
	<input name="roomMemberGender" type="radio" value="3" <c:if test="${3 eq roomMemberGender}">checked</c:if> /><label>无所谓</label>
	<br /> 
	
	您的专业： <c:set var="major" value="${order.orderContact.prefer.major}" />
	<input name="major" type="text" value="${major}" /> 
	<br />
	学校：<c:set var="college" value="${order.orderContact.prefer.college}" />
	<input name="college" value="${college}"/><br> 
	<br />
	特殊要求：<c:set var="floor" value="${order.orderContact.prefer.floor}" />
	<input name="floor" type="text" value="${floor}" class="larger" placeholder="楼层/朝向/团队预定/语言班宿舍/提前入住" />
	<br />
	<hr>
	
	<h2>担保人信息</h2>
	<c:set var="gender" value="${order.orderContact.guaranteeInfo.gender}" />
	称呼: <select name="order.orderContact.guaranteeInfo.gender">
		<option value="0" <c:if test="${gender eq 0}">selected</c:if>>Mr.</option>
		<option value="1" <c:if test="${gender eq 1}">selected</c:if>>Mrs.</option>
		<option value="2" <c:if test="${gender eq 2}">selected</c:if>>Miss</option>
	</select><br> 关系：
	<c:set var="relationship" value="${order.orderContact.guaranteeInfo.relationship}" />
	<input type="text" name="order.orderContact.guaranteeInfo.relationship" value="${relationship}" /><br> 姓：
	<c:set var="lastName" value="${order.orderContact.guaranteeInfo.lastName}" />
	<input name="order.orderContact.guaranteeInfo.lastName" type="text" value="${lastName}" class="min validate" errorFieldName="姓" /><br> 名：
	<c:set var="name" value="${order.orderContact.guaranteeInfo.name}" />
	<input name="order.orderContact.guaranteeInfo.name" type="text" value="${name}" class="min validate" errorFieldName="名" /><br> 国籍：
	<c:set var="nationality" value="${order.orderContact.guaranteeInfo.nationality}" />
	<input name="order.orderContact.guaranteeInfo.nationality" type="text" value="${nationality}" class="validate" errorFieldName="国籍" /><br> 出生日期：
	<c:set var="birthday" value="${order.orderContact.guaranteeInfo.birthday}" />
	<input class="datepicker validate" errorFieldName="出生日期" name="order.orderContact.guaranteeInfo.birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" /><br> 电子邮件：
	<c:set var="email" value="${order.orderContact.guaranteeInfo.email}" />
	<input id="login" name="order.orderContact.guaranteeInfo.email" type="text" class="long validate" errorFieldName="电子邮件" value="${email}" /><br> QQ：
	<c:set var="qq" value="${order.orderContact.guaranteeInfo.qq}" />
	<input name="order.orderContact.guaranteeInfo.qq" type="text" value="${qq}" class="validate" errorFieldName="QQ" /><br> 微信号：
	<c:set var="wechat" value="${order.orderContact.guaranteeInfo.wechat}" />
	<input name="order.orderContact.guaranteeInfo.wechat" type="text" value="${wechat}" class="validate" errorFieldName="微信号" /><br> 手机号码：
	<c:set var="phone" value="${order.orderContact.guaranteeInfo.phone}" />
	<input name="order.orderContact.guaranteeInfo.phone" type="text" value="${phone}" class="validate" errorFieldName="手机号码" /> 家庭住址：
	<c:set var="country" value="${order.orderContact.guaranteeInfo.country}" />
	<c:set var="province" value="${order.orderContact.guaranteeInfo.province}" />
	<c:set var="city" value="${order.orderContact.guaranteeInfo.city}" />
	<c:set var="county" value="${order.orderContact.guaranteeInfo.county}" />
	<c:set var="address" value="${order.orderContact.guaranteeInfo.address}" />
	<input name="order.orderContact.guaranteeInfo.country" type="text" value="${country}" class="min validate" errorFieldName="国家" />&nbsp;(国家)&nbsp;
	<input name="order.orderContact.guaranteeInfo.province" type="text" value="${province}" class="min validate" errorFieldName="省" />&nbsp;(省)&nbsp;
	<input name="order.orderContact.guaranteeInfo.city" type="text" value="${city}" class="min validate" errorFieldName="市" />&nbsp;(市)&nbsp;
	<input name="order.orderContact.guaranteeInfo.county" type="text" value="${county}" class="min validate" errorFieldName="区县" />&nbsp;(区县)<br> 
	<input name="order.orderContact.guaranteeInfo.address" type="text" value="${address}" class="larger validate" errorFieldName="街道地址" />&nbsp;(街道地址)<br>
	<c:set var="postalcode" value="${order.orderContact.guaranteeInfo.postalcode}" />
	<input name="order.orderContact.guaranteeInfo.postalcode" type="text" value="${postalcode}" class="mini validate" errorFieldName="邮编" />&nbsp;(邮编)<br>
	<hr>
	
	<h2>紧急联系人信息</h2>
	<c:set var="gender" value="${order.orderContact.contactPersonInfo.gender}" />
	称呼: <select name="order.orderContact.contactPersonInfo.gender">
		<option value="0" <c:if test="${gender eq 0}">selected</c:if>>Mr.</option>
		<option value="1" <c:if test="${gender eq 1}">selected</c:if>>Mrs.</option>
		<option value="2" <c:if test="${gender eq 2}">selected</c:if>>Miss</option>
	</select><br> 关系：
	<c:set var="relationship" value="${order.orderContact.contactPersonInfo.relationship}" />
	<input type="text" name="order.orderContact.contactPersonInfo.relationship" value="${relationship}" /><br> 姓：
	<c:set var="lastName" value="${order.orderContact.contactPersonInfo.lastName}" />
	<input name="order.orderContact.contactPersonInfo.lastName" type="text" value="${lastName}" class="min validate" errorFieldName="姓" /><br> 名：
	<c:set var="name" value="${order.orderContact.contactPersonInfo.name}" /> 	<input name="order.orderContact.contactPersonInfo.name" var="name" value="${order.orderContact.contactPersonInfo.name}"  class="min validate" errorFieldName="名"  /><br />国籍：
 	<c:set var="nationality" value="${order.orderContact.contactPersonInfo.nationality}" />
	<input name="order.orderContact.contactPersonInfo.nationality" type="text" value="${nationality}" class="validate" errorFieldName="国籍" /><br> 出生日期：
	<c:set var="birthday" value="${order.orderContact.contactPersonInfo.birthday}" />
	<input class="datepicker validate" errorFieldName="出生日期" name="order.orderContact.contactPersonInfo.birthday" type="text" value="<fmt:formatDate value='${birthday}' pattern='yyyy-MM-dd'/>" /><br> 电子邮件：
	<c:set var="email" value="${order.orderContact.contactPersonInfo.email}" />
	<input id="login" name="order.orderContact.contactPersonInfo.email" type="text" class="long validate" errorFieldName="电子邮件" value="${email}" /><br> QQ：
	<c:set var="qq" value="${order.orderContact.contactPersonInfo.qq}" />
	<input name="order.orderContact.contactPersonInfo.qq" type="text" value="${qq}" class="validate" errorFieldName="QQ" /><br> 微信号：
	<c:set var="wechat" value="${order.orderContact.contactPersonInfo.wechat}" />
	<input name="order.orderContact.contactPersonInfo.wechat" type="text" value="${wechat}" class="validate" errorFieldName="微信号" /><br> 手机号码：
	<c:set var="phone" value="${order.orderContact.contactPersonInfo.phone}" />
	<input name="order.orderContact.contactPersonInfo.phone" type="text" value="${phone}" class="validate" errorFieldName="手机号码" /> 家庭住址：
	<c:set var="country" value="${order.orderContact.contactPersonInfo.country}" />
	<c:set var="province" value="${order.orderContact.contactPersonInfo.province}" />
	<c:set var="city" value="${order.orderContact.contactPersonInfo.city}" />
	<c:set var="county" value="${order.orderContact.contactPersonInfo.county}" />
	<c:set var="address" value="${order.orderContact.contactPersonInfo.address}" />
	<input name="order.orderContact.contactPersonInfo.country" type="text" value="${country}" class="min validate" errorFieldName="国家" />&nbsp;(国家)&nbsp;
	<input name="order.orderContact.contactPersonInfo.province" type="text" value="${province}" class="min validate" errorFieldName="省" />&nbsp;(省)&nbsp;
	<input name="order.orderContact.contactPersonInfo.city" type="text" value="${city}" class="min validate" errorFieldName="市" />&nbsp;(市)&nbsp;
	<input name="order.orderContact.contactPersonInfo.county" type="text" value="${county}" class="min validate" errorFieldName="区县" />&nbsp;(区县)<br> 
	<input name="order.orderContact.contactPersonInfo.address" type="text" value="${address}" class="larger validate" errorFieldName="街道地址" />&nbsp;(街道地址)<br>
	<c:set var="postalcode" value="${order.orderContact.contactPersonInfo.postalcode}" />
	<input name="order.orderContact.contactPersonInfo.postalcode" type="text" value="${postalcode}" class="mini validate" errorFieldName="邮编" />&nbsp;(邮编)<br>
	<hr>
	
	<h2>补充信息</h2>
	毕业院校：
	<c:set var="graduateSchool" value="${order.orderContact.prefer.graduateSchool}" />
	<input name="graduateSchool" type="text" value="${graduateSchool}" class="long" />
	<br />
	推送入读城市信息:
	<c:set var="needPush" value="${order.orderContact.prefer.needPush}" />
	<input name="needPush" type="radio" value="Y" <c:if test="${empty needPush or needPush}">checked</c:if> /><label>是</label>
	<input name="needPush" type="radio" value="N" <c:if test="${not empty needPush and not needPush}">checked</c:if> /><label>否</label>
	<br />
	已阅读并同意留学生活网的《条款条例》:
	<c:set var="readClause" value="${order.orderContact.prefer.readClause}" />
	<input class="isChoose" name="readClause" type="radio" value="Y" <c:if test="${empty readClause or readClause}">checked</c:if> /><label>是</label> 
	<input class="isChoose" name="readClause" type="radio" value="N" <c:if test="${not empty readClause and not readClause}">checked</c:if> /><label>否</label>

	<hr>
	价格：<input type="text" name="price" value="${order.amount}" /> <br> 
	支付链接： <input type="text" name="paymentUrl" value="${item.paymentUrl}" /><br> 
	操作：<input name="operation" type="radio" value="REVIEWDE" />
	审核，发送付款邮件&nbsp;&nbsp; | &nbsp;&nbsp;<input name="operation" type="radio" value="PAYMENT_DONE" />确认支付，发送车票邮件<br> 
	<input type="submit" value="提交" />
</form>
</html>