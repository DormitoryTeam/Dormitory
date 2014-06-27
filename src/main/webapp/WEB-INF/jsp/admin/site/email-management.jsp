<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/vendor/jquery.ui.widget.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<title>邮箱管理</title>
</head>
<body>
	<table class="table table-hover table-bordered table-striped">
		<tr>
			<th>编号</th>
			<th>邮箱</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach var="email" items="${emails}" varStatus="i">
			<form action="<c:url value='/admin/site/edit-email.html'/>" method="POST">
				<tr>
					<td>#&nbsp;${email['id']}<input type="hidden" name="id" value="${email['id']}"/><input type="hidden" name="type" value="${email['type']}"/></td>
					<td><input type="text" name="email" value="${email['email']}"/></td>
					<td><select name="status">
						<option value="1" ${email['status'] eq '1' ? 'selected' : ''}>有效</option>
						<option value="0" ${email['status'] eq '0' ? 'selected' : ''}>无效</option>
					</select></td>
					<td><input type="submit" value="更新"/></td>
				</tr>
			</form>
		</c:forEach>
		<form action="<c:url value='/admin/site/edit-email.html'/>" method="POST">
			<tr>
				<td></td>
				<td><input type="text" name="email" value="${company['name']}"/>
				<input type="hidden" name="type" value="${type}"/>
				</td>
				<td><select name="status">
						<option value="1" ${email['status'] eq '1' ? 'select' : ''}>有效</option>
						<option value="0" ${email['status'] eq '0' ? 'select' : ''}>无效</option>
					</select></td>
				<td><input type="submit" value="新增"></td>
			</tr>
		</form>
	</table>
	<a href="<c:url value="/admin/site/admin-navigation.html"/>">返回</a>&nbsp;&nbsp;
</body>
</html>
