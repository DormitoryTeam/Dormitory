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
					<li style="background-color: white;"><a href="#tabs-data" style="color: #32B16C">个人资料</a></li>
					<li><a href="#tabs-data">个人偏好</a></li>
					<li><a href="#tabs-data">担保人信息</a></li>
					<li><a href="#tabs-data">紧急联系人信息</a></li>
					<li style="background-color: #32B16C;"><a href="#tabs-data" style="color:white;">补充信息</a></li>
				</ul>
				<div id="tabs-data">
				<form action="<c:url value="/user/editUserInfo.html"/>" method="POST" id="userForm">
					<input name="preferId" type="hidden" value="${user.prefer.id}"/>
					<input name="pageStep" type="hidden" value="4"/>
					<fieldset>
						<dl>
							<dd>毕业院校</dd>
							<dt>
							${user.prefer.graduateSchool}
							</dt>
						</dl>
						<dl>
							<dd>是否需要推送你的入读城市信息?</dd>
							<dt>
							<c:if test="${user.prefer.needPush}"><label>是</label></c:if>
							<c:if test="${not user.prefer.needPush}"><label>否</label></c:if>
							</dt>
						</dl>
						<dl>
							<dd>我已阅读并同意留学生活网的《条款条例》</dd>
							<dt>
							<c:if test="${user.prefer.readClause}"><label>是</label></c:if>
							<c:if test="${not user.prefer.readClause}"><label>否</label></c:if>
							</dt>
						</dl>
					</fieldset>
					<a href="#" class="modify btn-user-info-save" gotoURL="<c:url value='/user/editUserInfo.html?command=edit&pageStep=4'/>">修改</a>
				<form>
				</div>
			</div>
		</div>
		
    </div>
</div>