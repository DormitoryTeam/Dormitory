<div class="reservation-content">
	<jsp:include page="/jsp/main/hostel/order/include/orderHeader.jsp"/>
	<div class="reservation-personal reservation-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
		<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
			<input type="hidden" name="command" id="command"/>
			<input type="hidden" name="pageStep" value="1"/>
			<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
			<input type="hidden" name="contractId" value="${price.contractId}" /> 
			<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
			<input type="hidden" name="preferId" value="${order.orderContact.prefer.id}"/>
			<input type="hidden" name="needPush" value="${(null ==  order.orderContact.prefer.needPush or order.orderContact.prefer.needPush) ? "Y" : "N"}" />
			<input type="hidden" name="readClause" value="${(null ==  order.orderContact.prefer.readClause or order.orderContact.prefer.readClause) ? "Y" : "N"}" />
			<input type="hidden" name="graduateSchool" value="${order.orderContact.prefer.graduateSchool}" />
			<!-- <a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${dormitory.id}&contractId=${price.contractId}&roomInfoId=${roomInfo.id}"/>" class="addOne">&nbsp;</a>-->
			<div class="btnBox">
				<input class="save btn-place-order-save" type="button" value="保存" />
				<input type="button" style="background-color: #808080;" value="提交" />
			</div>
			<jsp:include page="/jsp/main/hostel/order/include/dormitoryOrderTab.jsp"/>
			
			<div id="tabs-hobby" aria-labelledby="ui-id-2" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: block;" aria-expanded="true" aria-hidden="false">
				<fieldset>
					<dl>
						<dd>您是否抽烟?</dd>
						<dd>
							<c:set var="smoke" value="${order.orderContact.prefer.smoke}" />
							<c:if test="${null == smoke}">
							<c:set var="smoke" value="${user.prefer.smoke}" />
							</c:if>
							<input name="smoke" type="radio" value="Y" <c:if test="${smoke}">checked</c:if>/><label>是</label>
							<input name="smoke" type="radio" value="N" <c:if test="${not smoke}">checked</c:if> /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd>您是否是素食主义者?</dd>
						<dd>
							<c:set var="vegetarianism" value="${order.orderContact.prefer.vegetarianism}" />
							<c:if test="${null == vegetarianism}">
							<c:set var="vegetarianism" value="${user.prefer.vegetarianism}" />
							</c:if>
							<input name="vegetarianism" type="radio" value="Y" <c:if test="${vegetarianism}">checked</c:if> /><label>是</label>
							<input name="vegetarianism" type="radio" value="N"  <c:if test="${not vegetarianism}">checked</c:if> /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd>What will be your year of study?</dd>
						<dd>
							<c:set var="yourGrade" value="${order.orderContact.prefer.yourGrade}" />
							<c:if test="${null == yourGrade}">
							<c:set var="yourGrade" value="${user.prefer.yourGrade}" />
							</c:if>
						
							<input type="radio" name="yourGrade" value="1" <c:if test="${'1' eq yourGrade}">checked</c:if> /><label>大一</label>
							<input type="radio" name="yourGrade" value="2" <c:if test="${'2' eq yourGrade}">checked</c:if> /><label>大二</label>
							<input type="radio" name="yourGrade" value="3" <c:if test="${'3' eq yourGrade}">checked</c:if> /><label>大三</label>
							<input type="radio" name="yourGrade" value="4" <c:if test="${'4' eq yourGrade}">checked</c:if> /><label>大四</label>
							<input type="radio" name="yourGrade" value="5" <c:if test="${'5' eq yourGrade}">checked</c:if> /><label>硕士</label>
							<input type="radio" name="yourGrade" value="6" <c:if test="${'6' eq yourGrade}">checked</c:if> /><label>博士</label>
						</dd>
					</dl>
					<dl>
						<dd>您想和哪个年级的人一起住?</dd>
						<dd>
							<c:set var="roomMemberGrade" value="${order.orderContact.prefer.roomMemberGrade}" />
							<c:if test="${null == roomMemberGrade}">
							<c:set var="roomMemberGrade" value="${user.prefer.roomMemberGrade}" />
							</c:if>
							<input type="radio" name="roomMemberGrade" value="1" <c:if test="${'1' eq roomMemberGrade}">checked</c:if> /><label>大一</label>
							<input type="radio" name="roomMemberGrade" value="2" <c:if test="${'2' eq roomMemberGrade}">checked</c:if> /><label>大二</label>
							<input type="radio" name="roomMemberGrade" value="3" <c:if test="${'3' eq roomMemberGrade}">checked</c:if> /><label>大三</label>
							<input type="radio" name="roomMemberGrade" value="4" <c:if test="${'4' eq roomMemberGrade}">checked</c:if> /><label>大四</label>
							<input type="radio" name="roomMemberGrade" value="5" <c:if test="${'5' eq roomMemberGrade}">checked</c:if> /><label>硕士</label>
							<input type="radio" name="roomMemberGrade" value="6" <c:if test="${'6' eq roomMemberGrade}">checked</c:if> /><label>博士</label>
						</dd>
					</dl>
					<dl>
						<dd>室友性别要求?</dd>
						<dd>
							<c:set var="roomMemberGender" value="${order.orderContact.prefer.roomMemberGender}" />
							<c:if test="${null == roomMemberGender}">
							<c:set var="roomMemberGender" value="${user.prefer.roomMemberGender}" />
							</c:if>
							<input name="roomMemberGender" type="radio" value="0" <c:if test="${0 eq roomMemberGender}">checked</c:if> /><label>混合性别</label>
							<input name="roomMemberGender" type="radio" value="1" <c:if test="${1 eq roomMemberGender}">checked</c:if> /><label>我是男性想和所有男性一起住</label>
							<input name="roomMemberGender" type="radio" value="2" <c:if test="${2 eq roomMemberGender}">checked</c:if> /><label>我是女性想和所有女性一起住</label>
							<input name="roomMemberGender" type="radio" value="3" <c:if test="${3 eq roomMemberGender}">checked</c:if> /><label>无所谓</label>
						</dd>
					</dl>
					<dl>
						<dt>您的专业</dt>
						<dd>
							<c:set var="major" value="${order.orderContact.prefer.major}" />
							<c:if test="${null == major}">
							<c:set var="major" value="${user.prefer.major}" />
							</c:if>
							<input name="major" type="text" value="${major}" /> 
						</dd>
					</dl>
					<dl>
						<dt>学校</dt>
						<dd>
							<c:set var="college" value="${order.orderContact.prefer.college}" />
							<c:if test="${null == college}">
							<c:set var="college" value="${user.prefer.college}" />
							</c:if>
							<input name="college" value="${college}"/>
						</dd>
					</dl>
					<dl>
						<dt>特殊要求</dt>
						<dd>
							<c:set var="floor" value="${order.orderContact.prefer.floor}" />
							<c:if test="${null == floor}">
							<c:set var="floor" value="${user.prefer.floor}" />
							</c:if>
							<input name="floor" type="text" value="${floor}" class="larger" placeholder="楼层/朝向/团队预定/语言班宿舍/提前入住" />
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<c:if test="${not empty order.id}"><button class="btn-style btn-place-order-pre" preStep="<c:url value="/order/dormitory-place-order.html?orderId=${order.id}&pageStep=0"/>">上一步</button></c:if><button class="btn-style btn-place-order-next">下一步</button>
						</dd>
					</dl>
				</fieldset>
			</div>
			
			
			
		</form>
	</div>
</div>
<%--
<div class="reservation-content">
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
			<input type="hidden" name="pageStep" value="1"/>
			<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
			<input type="hidden" name="contractId" value="${price.contractId}" /> 
			<input type="hidden" name="roomInfoId" value="${roomInfo.id}" />
			<input type="hidden" name="preferId" value="${order.orderContact.prefer.id}"/>
			<input type="hidden" name="needPush" value="${order.orderContact.prefer.needPush ? "Y" : "N"}" />
			<input type="hidden" name="readClause" value="${order.orderContact.prefer.readClause ? "Y" : "N"}" />
			<input type="hidden" name="graduateSchool" value="${order.orderContact.prefer.graduateSchool}" />
			<a href="<c:url value="/order/dormitory-place-order.html?dormitoryId=${dormitory.id}&contractId=${price.contractId}&roomInfoId=${roomInfo.id}"/>" class="addOne">&nbsp;</a>
			<div class="btnBox">
				<input class="save btn-place-order-save" type="button" value="保存" />
				<input type="submit" style="background-color: #808080;" value="提交" />
			</div>
			<ul>
				<li><a href="#tabs-hobby">个人信息</a></li>
				<li style="background-color: antiquewhite;"><a href="#tabs-hobby">个人偏好</a></li>
				<li><a href="#tabs-hobby">担保人信息</a></li>
				<li><a href="#tabs-hobby">紧急联系人信息</a></li>
				<li><a href="#tabs-hobby">补充信息</a></li>
			</ul>
			<div id="tabs-hobby">
				<fieldset>
					<dl>
						<dd>您是否抽烟?</dd>
						<dd>
							<c:set var="smoke" value="${order.orderContact.prefer.smoke}" />
							<c:if test="${null == smoke}">
							<c:set var="smoke" value="${user.prefer.smoke}" />
							</c:if>
							<input name="smoke" type="radio" value="Y" <c:if test="${smoke}">checked</c:if>/><label>是</label>
							<input name="smoke" type="radio" value="N" <c:if test="${not smoke}">checked</c:if> /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd>您是否是素食主义者?</dd>
						<dd>
							<c:set var="vegetarianism" value="${order.orderContact.prefer.vegetarianism}" />
							<c:if test="${null == vegetarianism}">
							<c:set var="vegetarianism" value="${user.prefer.vegetarianism}" />
							</c:if>
							<input name="vegetarianism" type="radio" value="Y" <c:if test="${vegetarianism}">checked</c:if> /><label>是</label>
							<input name="vegetarianism" type="radio" value="N"  <c:if test="${not vegetarianism}">checked</c:if> /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd>您的年级?</dd>
						<dd>
							<c:set var="yourGrade" value="${order.orderContact.prefer.yourGrade}" />
							<c:if test="${null == yourGrade}">
							<c:set var="yourGrade" value="${user.prefer.yourGrade}" />
							</c:if>
						
							<input type="radio" name="yourGrade" value="1" <c:if test="${'1' eq yourGrade}">checked</c:if> /><label>大一</label>
							<input type="radio" name="yourGrade" value="2" <c:if test="${'2' eq yourGrade}">checked</c:if> /><label>大二</label>
							<input type="radio" name="yourGrade" value="3" <c:if test="${'3' eq yourGrade}">checked</c:if> /><label>大三</label>
							<input type="radio" name="yourGrade" value="4" <c:if test="${'4' eq yourGrade}">checked</c:if> /><label>大四</label>
							<input type="radio" name="yourGrade" value="5" <c:if test="${'5' eq yourGrade}">checked</c:if> /><label>硕士</label>
							<input type="radio" name="yourGrade" value="6" <c:if test="${'6' eq yourGrade}">checked</c:if> /><label>博士</label>
						</dd>
					</dl>
					<dl>
						<dd>您想和哪个年级的人一起住?</dd>
						<dd>
							<c:set var="roomMemberGrade" value="${order.orderContact.prefer.roomMemberGrade}" />
							<c:if test="${null == roomMemberGrade}">
							<c:set var="roomMemberGrade" value="${user.prefer.roomMemberGrade}" />
							</c:if>
							<input type="radio" name="roomMemberGrade" value="1" <c:if test="${'1' eq roomMemberGrade}">checked</c:if> /><label>大一</label>
							<input type="radio" name="roomMemberGrade" value="2" <c:if test="${'2' eq roomMemberGrade}">checked</c:if> /><label>大二</label>
							<input type="radio" name="roomMemberGrade" value="3" <c:if test="${'3' eq roomMemberGrade}">checked</c:if> /><label>大三</label>
							<input type="radio" name="roomMemberGrade" value="4" <c:if test="${'4' eq roomMemberGrade}">checked</c:if> /><label>大四</label>
							<input type="radio" name="roomMemberGrade" value="5" <c:if test="${'5' eq roomMemberGrade}">checked</c:if> /><label>硕士</label>
							<input type="radio" name="roomMemberGrade" value="6" <c:if test="${'6' eq roomMemberGrade}">checked</c:if> /><label>博士</label>
						</dd>
					</dl>
					<dl>
						<dd>室友性别要求?</dd>
						<dd>
							<c:set var="roomMemberGender" value="${order.orderContact.prefer.roomMemberGender}" />
							<c:if test="${null == roomMemberGender}">
							<c:set var="roomMemberGender" value="${user.prefer.roomMemberGender}" />
							</c:if>
							<input name="roomMemberGender" type="radio" value="0" <c:if test="${0 eq roomMemberGender}">checked</c:if> /><label>混合性别</label>
							<input name="roomMemberGender" type="radio" value="1" <c:if test="${1 eq roomMemberGender}">checked</c:if> />我是男性想和所有男性一起住</label>
							<input name="roomMemberGender" type="radio" value="2" <c:if test="${2 eq roomMemberGender}">checked</c:if> /><label>我是女性想和所有女性一起住</label>
							<input name="roomMemberGender" type="radio" value="3" <c:if test="${3 eq roomMemberGender}">checked</c:if> /><label>无所谓</label>
						</dd>
					</dl>
					<dl>
						<dt>您的专业</dt>
						<dd>
							<c:set var="major" value="${order.orderContact.prefer.major}" />
							<c:if test="${null == major}">
							<c:set var="major" value="${user.prefer.major}" />
							</c:if>
							<input name="major" type="text" value="${major}" /> 
						</dd>
					</dl>
					<dl>
						<dt>学校</dt>
						<dd>
							<c:set var="college" value="${order.orderContact.prefer.college}" />
							<c:if test="${null == college}">
							<c:set var="college" value="${user.prefer.college}" />
							</c:if>
							<input name="college" value="${college}"/>
						</dd>
					</dl>
					<dl>
						<dt>特殊要求</dt>
						<dd>
							<c:set var="floor" value="${order.orderContact.prefer.floor}" />
							<c:if test="${null == floor}">
							<c:set var="floor" value="${user.prefer.floor}" />
							</c:if>
							<input name="floor" type="text" value="${floor}" class="larger" placeholder="楼层/朝向/团队预定/语言班宿舍/提前入住" />
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<button class="btn-style btn-place-order-next">下一步</button>
						</dd>
					</dl>
				</fieldset>
			</div>
		</form>
	</div>
</div>
--%>