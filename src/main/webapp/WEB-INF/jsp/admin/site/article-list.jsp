<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<br />
	<input type="button" onclick="window.location.href='<c:url value='/admin/site/article-add-or-update.html'/>';return false;" value="新建文章" />
	<hr />
	<table class="table table-hover table-bordered table-striped">
		<thead>
			<tr class="success">
				<th>#</th>
				<th>文章标题</th>
				<th>文章类型</th>
				<th>文章状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articleTitles}" varStatus="i">
				<tr>
					<td>${article.id}</td>
					<td><a href="<c:url value='/admin/site/article-add-or-update.html?id=${article.id}'/>">${article['title']}</a></td>
					<td>
						<c:if test="${article.type eq '1'}">新闻</c:if>
						<c:if test="${article.type eq '2'}">去旅行</c:if>
					</td>
					<td>
						<c:if test="${article.status eq '0'}">不展示</c:if>
						<c:if test="${article.status eq '1'}">展示</c:if>
						<c:if test="${article.status eq '2'}">展示(热门)</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	<table>
</body>
</html>