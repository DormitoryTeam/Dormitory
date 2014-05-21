<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/vendor/jquery.ui.widget.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<title>公司管理</title>
</head>
<body>
	<table class="table table-hover table-bordered table-striped">
		<tr>
			<th>序号</th>
			<th>公司名称</th>
			<th>操作</th>
		</tr>
		<c:forEach var="company" items="${companies}" varStatus="i">
			<form action="<c:url value='/admin/site/update-company.html'/>" method="POST">
				<tr>
					<td>#&nbsp;${company['id']}</td>
					<td>${company['name']}</td>
					<td><input type="hidden" name="status" value="${company['status'] eq '1' ? '0' : '1'}" />
						<input type="hidden" name="id" value="${company['id']}">
						<input type="submit" value="${company['status'] eq '1' ? '删除' : '恢复'}"></td>
				</tr>
			</form>
		</c:forEach>
		<form action="<c:url value='/admin/site/save-company.html'/>" method="POST">
			<tr>
				<td></td>
				<td><input type="text" name="name" value="" /></td>
				<td><input type="submit" value="新增"></td>
			</tr>
		</form>
	</table>
</body>
</html>
