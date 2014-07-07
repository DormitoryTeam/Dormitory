<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.hotkeys.js' />"></script>
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/google-code-prettify/prettify.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/js/google-code-prettify/prettify.css' />" />
<link type="text/css" rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" />
<link type="text/css" rel="stylesheet" href="<c:url value='/js/jquery-rte/bootstrap-combined.no-icons.min.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/js/jquery-rte/bootstrap-responsive.min.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/js/jquery-rte/index.css' />" />
<script type="text/javascript" src="/js/nicEdit/nicEdit.js"></script>
<style type="text/css">
#editor {line-height: 16px}
</style>

</head>
<body>
	<br />
	<form id="form" action="<c:url value='/admin/site/article-save.html'/>" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${article['id']}" />
		<input type="hidden" name="userId" value="${article['userId']}" />
		<input id="iptTextBody" type="hidden" name="textBody" value="" />
		
		<div class="container">
			<div class="hero-unit">
				文章标题:&nbsp;<input type="text" name="title" value="${article['title']}" /><br />
				文章类型:&nbsp;<select name="type">
					<option value="1" ${article['type'] eq 1 ? 'selected' : ''}>新闻</option>
					<option value="2" ${article['type'] eq 2 ? 'selected' : ''}>去旅行</option>
				</select><br />
				文章状态:&nbsp;<select name="status">
					<option value="0" ${0 eq article['status'] ? 'selected' : ''}>不展示</option>
					<option value="1" ${1 eq article['status'] ? 'selected' : ''}>展示</option>
					<option value="2" ${2 eq article['status'] ? 'selected' : ''}>展示(热门)</option>
				</select> 
				<hr />
				<div id="alerts"></div>
		
				<div id="editor"><textarea id="nicEditor" style="width:100%; height:100%">${article['textBody']}</textarea></div>
				
				<p>文章封面:</p>
				<c:if test="${not empty article['coverPath']}">
					<img style="height:160px;" src="<c:url value='/upload/images/articleCover/${article.id}/${article.coverPath}'/>" />
					<input id="ckbRemoveCover" type="checkbox" value="删除封面" alt="删除封面" />
					删除封面
					<input id="hidRemoveCover" type="hidden" name="removeCover" value="false" />
				</c:if>
				<br />
				<input type="file" name="cover" />
				<input type="hidden" name="coverPath" value="${article['coverPath']}" />

				<br />
				<br />
				<br />
				
				<input id="btnSubmit" type="button" value="提交" />
				<input type="button" value="返回" onclick='window.location.href="<c:url value='/admin/site/article-list.html'/>";return false;' />
			</div>
		</div>
	</form>
	
	<script type="text/javascript" src="<c:url value='/js/admin/site/article1.js' />"></script>
</body>
</html>