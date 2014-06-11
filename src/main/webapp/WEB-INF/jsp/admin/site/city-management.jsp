<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/vendor/jquery.ui.widget.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/admin/site/city.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<title>城市管理</title>
</head>
<body>
	<form action="<c:url value="/admin/site/city-management.html"/>" method="POST">
		城市名称: <input type="text" name="cityName" value="${name}" /> <input type="submit" value="搜索" />
	</form>
	<table class="table table-hover table-bordered table-striped">
		<tr>
			<th>#</th>
			<th>名称</th>
			<th>英文名称</th>
			<th>热门城市</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
		<c:forEach var="city" items="${cities}">
			<form action="<c:url value='/admin/site/save-city.html' />" method="POST">
				<tr>
					<td>${city.id}<input type="hidden" name="id" value="${city.id}" readonly="readonly" /></td>
					<td><input type="text" name="name" value="${city.name_ch}" /></td>
					<td><input type="text" name="originalName" value="${city.name}"</td>
					<td><select name="topCity" style="width: 100px;">
							<option value="true"  ${city.topCity ? 'selected' : ''}>是</option>
							<option value="false" ${!city.topCity ? 'selected' : ''}>不是</option>
					</select></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${city.create_time}" type="both"/></td>
					<td><input type="hidden" name="status" value="${city.status}" />
						<input type="button" value="${city.status eq '1' ? '删除' : '恢复'}" class="btnMarkDelete" />
						<input type="submit" value="保存" /></td>
				</tr>
			</form>
		</c:forEach>
		<form action="<c:url value='/admin/site/save-city.html' />" method="POST">
			<tr>
				<td></td>
				<td><input type="text" name="name" value="" /></td>
				<td><input type="text" name="originalName" value=""</td>
				<td><select name="topCity" style="width: 100px;">
						<option value="false">不是</option>
						<option value="true">是</option>
				</select></td>
				<td></td>
				<td><input type="hidden" name="status" value="1" />
					<input type="submit" value="新增" /></td>
			</tr>
		</form>
	</table>
</body>
</html>