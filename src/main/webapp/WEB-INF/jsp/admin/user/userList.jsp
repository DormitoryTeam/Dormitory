<form action="<c:url value='/admin/user/userList.html'/>" method="GET">
登录账号/用户ID: <input type="text" name="searchKey" value="${searchKey}"/><br>
用户识别码: <input type="text" name="token" value="${token}"/><br>
<input type="submit" value="Search"/>
</form>
<hr>
<table>
	<tr>
		<td>用户ID</td>
		<td>登录账号</td>
		<td>用户识别码</td>
		<td>密码</td>
		<td>操作</td>
	</tr>
	<c:forEach var="user" items="${users}" varStatus="i">
	<tr><form action="<c:url value="/admin/user/changePassword.html"/>" method="POST">
		<td>${user.id}</td>
		<td>${user.login}</td>
		<td>${user.token}</td>
		<td>${user.password}</td>
		<td>
		
		<input type="text" name="newPassword" placeholder="新密码"/><input type="submit" value="更新密码"/>
		<input type="hidden" name="oldPassword" value="${user.password}"/>
		<input type="hidden" name="login" value="${user.login}"/>
		<input type="hidden" name="token" value="${token}"/>
		<input type="hidden" name="searchKey" value="${searchKey}"/>
		<input type="hidden" name="currentPage" value="${page.pageNum}"/>
		<input type="hidden" name="pageSize" value="${page.pageSize}"/>
		</td></form>
	<tr>
	</c:forEach>
</table>
<a href="<c:url value="/admin/site/admin-navigation.html"/>">返回</a>&nbsp;&nbsp;|&nbsp;&nbsp;<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/>