<div class="row myaccount">
    <jsp:include page="/jsp/main/myaccount/infoheader.jsp" />
    <div class="myaccount-tab">
    	<ul>
			<li style="background-color: #32B16C;"><a href="#tabs-personal">个人信息</a></li>
			<li><a href="#tabs-personal">宿舍订单</a></li>
			<li><a href="#tabs-personal">接机订单</a></li>
			<li><a href="#tabs-personal">旅游年卡</a></li>
			<li><a href="#tabs-personal">导游服务</a></li>
			<li><a href="#tabs-personal">校友卡</a></li>
			<li><a href="#tabs-personal">24H安全</a></li>
		</ul>
		<div id="tabs-personal">
			<div class="personal-info-tab">
		    	<ul>
					<li style="background-color: white;"><a href="#tabs-data" style="color:#32B16C;">个人资料</a></li>
					<li style="background-color: #32B16C;"><a href="#tabs-data" style="color: white;">个人偏好</a></li>
					<li><a href="#tabs-data">担保人信息</a></li>
					<li><a href="#tabs-data">紧急联系人信息</a></li>
					<li><a href="#tabs-data">补充信息</a></li>
				</ul>
				<div id="tabs-data">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="preferId" type="hidden" value="${user.prefer.id}"/>
					<input name="pageStep" type="hidden" value="1"/>
					<fieldset>
						<dl>
							<dd>您是否抽烟?</dd>
							<dt>
							<c:set var="smoke" value="${user.prefer.smoke}" />
							<input name="smoke" type="radio" value="Y" <c:if test="${smoke}">checked</c:if>/><label>是</label>
							<input name="smoke" type="radio" value="N" <c:if test="${not smoke}">checked</c:if> /><label>否</label>
							</dt>
						</dl>
						<dl>
							<dd>您是否是素食主义者?</dd>
							<dt>
							<c:set var="vegetarianism" value="${user.prefer.vegetarianism}" />
							<input name="vegetarianism" type="radio" value="Y" <c:if test="${vegetarianism}">checked</c:if> /><label>是</label>
							<input name="vegetarianism" type="radio" value="N"  <c:if test="${not vegetarianism}">checked</c:if> /><label>否</label>
							</dt>
						</dl>
						<dl>
							<dd>您的年级?</dd>
							<dt>
							<c:set var="yourGrade" value="${user.prefer.yourGrade}" />
							<input type="radio" name="yourGrade" value="1" <c:if test="${'1' eq yourGrade}">checked</c:if> /><label>大一</label>
							<input type="radio" name="yourGrade" value="2" <c:if test="${'2' eq yourGrade}">checked</c:if> /><label>大二</label>
							<input type="radio" name="yourGrade" value="3" <c:if test="${'3' eq yourGrade}">checked</c:if> /><label>大三</label>
							<input type="radio" name="yourGrade" value="4" <c:if test="${'4' eq yourGrade}">checked</c:if> /><label>大四</label>
							<input type="radio" name="yourGrade" value="5" <c:if test="${'5' eq yourGrade}">checked</c:if> /><label>硕士</label>
							<input type="radio" name="yourGrade" value="6" <c:if test="${'6' eq yourGrade}">checked</c:if> /><label>博士</label>
							</dt>
						</dl>
						<dl>
							<dd>您想和哪个年级的人一起住?</dd>
							<dt>
							<c:set var="roomMemberGrade" value="${user.prefer.roomMemberGrade}" />
							<input type="radio" name="roomMemberGrade" value="1" <c:if test="${'1' eq roomMemberGrade}">checked</c:if> /><label>大一</label>
							<input type="radio" name="roomMemberGrade" value="2" <c:if test="${'2' eq roomMemberGrade}">checked</c:if> /><label>大二</label>
							<input type="radio" name="roomMemberGrade" value="3" <c:if test="${'3' eq roomMemberGrade}">checked</c:if> /><label>大三</label>
							<input type="radio" name="roomMemberGrade" value="4" <c:if test="${'4' eq roomMemberGrade}">checked</c:if> /><label>大四</label>
							<input type="radio" name="roomMemberGrade" value="5" <c:if test="${'5' eq roomMemberGrade}">checked</c:if> /><label>硕士</label>
							<input type="radio" name="roomMemberGrade" value="6" <c:if test="${'6' eq roomMemberGrade}">checked</c:if> /><label>博士</label>
							</dt>
						</dl>
						<dl>
							<dd>室友性别要求?</dd>
							<dt>
							<c:set var="roomMemberGender" value="${user.prefer.roomMemberGender}" />
							<input name="roomMemberGender" type="radio" value="0" <c:if test="${0 eq roomMemberGender}">checked</c:if> /><label>混合性别</label>
							<input name="roomMemberGender" type="radio" value="1" <c:if test="${1 eq roomMemberGender}">checked</c:if> />我是男性想和所有男性一起住</label>
							<input name="roomMemberGender" type="radio" value="2" <c:if test="${2 eq roomMemberGender}">checked</c:if> /><label>我是女性想和所有女性一起住</label>
							<input name="roomMemberGender" type="radio" value="3" <c:if test="${3 eq roomMemberGender}">checked</c:if> /><label>无所谓</label>
							</dt>
						</dl>
						<dl>
							<dd>您的专业</dd>
							<dt><input name="major" type="text" value="${user.prefer.major}" /> </dt>
						</dl>
						<dl>
							<dd>学校</dd>
							<dt><input name="college" value="${user.prefer.college}"/></dt>
						</dl>
						<dl>
							<dd>特殊要求</dd>
							<dt><input name="floor" type="text" value="${user.prefer.floor}" class="larger" placeholder="楼层/朝向/团队预定/语言班宿舍/提前入住" /></dt>
						</dl>
					</fieldset>
					<a href="#" class="modify btn-user-info-save">完成</a>
				<form>
				</div>
			</div>
		</div>
		
    </div>
</div>