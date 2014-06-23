<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/vendor/jquery.ui.widget.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/admin/site/college.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<title>大学管理</title>
</head>
<body>
	<form action="<c:url value="/admin/site/college-management.html"/>" method="GET">
		大学名称: <input type="text" name="collegeName" value="${collegeName}" />
		城市: <select name="cityId">
			<option value="">所有城市</option>
			<c:forEach var="city" items="${cities}">
				<option value="${city.id}" ${cityId eq city.id ? 'selected' : ''}>${city.name_ch}</option>
			</c:forEach>
		</select>
		<input type="submit" value="搜索" />
	</form>
	<table class="table table-hover table-bordered table-striped">
		<tr>
			<th>#</th>
			<th>名称</th>
			<th>英文名称</th>
			<th>所属城市</th>
			<th>热门大学</th>
			<th>精度</th>
			<th>纬度</th>
			<th>邮编</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
		<c:forEach var="college" items="${colleges}">
			<form action="<c:url value='/admin/site/save-college.html' />" method="POST">
				<tr>
					<td>${college.id}<input type="hidden" name="id" value="${college.id}" readonly="readonly" /></td>
					<td><input type="text" name="name" value="${college.name}" /></td>
					<td><input type="text" name="originalName" value="${college.original_name}"</td>
					<td><select name="cityId">
							<c:forEach var="city" items="${cities}">
								<option value="${city.id}" ${city.id eq college.city_id ? 'selected' : ''}>${city.name_ch}</option>
							</c:forEach>
					</select></td>
					<td><select name="topCollege" style="width: 100px;">
							<option value="true"  ${college.topCollege ? 'selected' : ''}>是</option>
							<option value="false" ${!college.topCollege ? 'selected' : ''}>不是</option>
					</select></td>
					<td><input type="text" name="latitude" value="${college.latitude}" /></td>
					<td><input type="text" name="longitude" value="${college.longitude}" /></td>
					<td><input type="text" name="postalcode" value="${college.postalcode}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${college.create_time}" type="both"/></td>
					<td><input type="hidden" name="status" value="${college.status}" />
						<input type="button" value="${college.status eq '1' ? '删除' : '恢复'}" class="btnMarkDelete" />
						<input type="submit" value="保存" /></td>
				</tr>
			</form>
		</c:forEach>
		<form action="<c:url value='/admin/site/save-college.html' />" method="POST">
			<tr>
				<td></td>
				<td><input type="text" name="name" value="" /></td>
				<td><input type="text" name="originalName" value=""</td>
				<td><select name="cityId">
						<c:forEach var="city" items="${cities}">
							<option value="${city.id}" ${city.id eq college.city_id ? 'selected' : ''}>${city.name_ch}</option>
						</c:forEach>
				</select></td>
				<td><select name="topCollege" style="width: 100px;">
						<option value="false">不是</option>
						<option value="true">是</option>
				</select></td>
				<td><input type="text" name="latitude" value="" /></td>
				<td><input type="text" name="longitude" value="" /></td>
				<td><input type="text" name="postalcode" value="" /></td>
				<td></td>
				<td><input type="hidden" name="status" value="1" />
					<input type="submit" value="新增" /></td>
			</tr>
		</form>
	</table>
	<a href="<c:url value="/admin/site/admin-navigation.html"/>">返回</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/>
</body>
</html>