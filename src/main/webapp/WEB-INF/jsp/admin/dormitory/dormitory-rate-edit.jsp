<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/admin/dormitory/dormitory-rate-edit.js' />"></script>
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<style type="text/css">
input[type="text"] {
	height: 30px;
	width: 180px;
}

select {
	width: 150px;
}
</style>
<link type="text/css" rel="stylesheet" href="<c:url value='/style/dropzone.css' />" />
<link href="css/dropzone.css" type="text/css" rel="stylesheet" />
<title>公寓评论编辑</title>
</head>
<body>
	<h4>
		${dormitory.name} -
		<c:choose>
			<c:when test="${dormitory['status'] eq 'HAS_VACANCY'}">可预订</c:when>
			<c:when test="${dormitory['status'] eq 'NO_VACANCY'}">不可预订</c:when>
			<c:when test="${dormitory['status'] eq 'INVISIBILITY'}">隐藏</c:when>
		</c:choose>
	</h4>
	<p>
		<a href="<c:url value="/admin/dormitory/dormitory-rates.html?dormitoryName=&cityId=0&status=&ratingStatus=0"/>">返回</a>
	</p>

	<table class="table table-hover table-bordered table-striped">
		<thead>
			<tr class="success">
				<th>#</th>
				<th>用户昵称</th>
				<th>评论内容</th>
				<th>评分</th>
				<th>评论时间</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="rate" items="${rates}" varStatus="i">
				<tr>
					<form action="<c:url value="/admin/dormitory/dormitory-rate-save.html"/>">
						<input type="hidden" name="id" value="${rate.id}" />
						<input type="hidden" name="userId" value="${rate.userId}" />
						<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
						<td>${i.count}</td>
						<td><input type="text" name="alias" value="${rate.alias}" /></td>
						<td><input type="text" name="comment" value="${rate.comment}" /></td>
						<td><select name="point">
								<option value="0" ${rate.point eq '0' ? 'selected' : ''}>0</option>
								<option value="1" ${rate.point eq '1' ? 'selected' : ''}>1</option>
								<option value="2" ${rate.point eq '2' ? 'selected' : ''}>2</option>
								<option value="3" ${rate.point eq '3' ? 'selected' : ''}>3</option>
								<option value="4" ${rate.point eq '4' ? 'selected' : ''}>4</option>
								<option value="5" ${rate.point eq '5' ? 'selected' : ''}>5</option>
						</select></td>
						<td>${rate.createTime}</td>
						<td><select name="status">
								<option value="-1" ${rate.status eq '-1' ? 'selected' : ''}>删除</option>
								<option value="0" ${rate.status eq '0' ? 'selected' : ''}>待审核</option>
								<option value="1" ${rate.status eq '1' ? 'selected' : ''}>通过审核</option>
						</select></td>
						<td><input type="submit" value="保存" /></td>
					</form>
				</tr>
			</c:forEach>
			<tr>
				<form action="<c:url value="/admin/dormitory/dormitory-rate-save.html"/>">
					<input type="hidden" name="id" value="-1" />
					<input type="hidden" name="userId" value="-1" />
					<input type="hidden" name="dormitoryId" value="${dormitory.id}" />
					<td></td>
					<td><input type="text" name="alias" value="" /></td>
					<td><input type="text" name="comment" value="" /></td>
					<td><select name="point">
							<option value="5">5</option>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
					</select></td>
					<td>${rate.createTime}</td>
					<td><select name="status">
							<option value="1">通过审核</option>
							<option value="0">待审核</option>
							<option value="-1">删除</option>
					</select></td>
					<td><input type="submit" value="新增" /></td>
				</form>
			</tr>
		</tbody>
	</table>
</body>
</html>