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
<script type="text/javascript" src="<c:url value='/js/jquery-rte/bootstrap-wysiwyg.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/js/google-code-prettify/prettify.css' />" />
<link type="text/css" rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" />
<link type="text/css" rel="stylesheet" href="<c:url value='/js/jquery-rte/bootstrap-combined.no-icons.min.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/js/jquery-rte/bootstrap-responsive.min.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/js/jquery-rte/index.css' />" />
</head>
<body>
	<br />
	<form id="form" action="<c:url value='/admin/site/article-save.html'/>" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${article['id']}" />
		<input type="hidden" name="userId" value="${article['userId']}" />
		<input id="iptTextBody" type="hidden" name="textBody" value="" />
		
		<div class="container">
			<div class="hero-unit">
				文章标题:<input type="text" name="title" value="${article['title']}" />&nbsp;
				<select name="type">
					<option value="1" ${article['type'] eq 1 ? 'selected' : ''}>新闻</option>
					<option value="2" ${article['type'] eq 2 ? 'selected' : ''}>去旅行</option>
				</select>
				<select name="status">
					<option value="0" ${0 eq article['status'] ? 'selected' : ''}>不展示</option>
					<option value="1" ${1 eq article['status'] ? 'selected' : ''}>展示</option>
				</select> 
				<hr />
				<div id="alerts"></div>
				<div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
					<div class="btn-group">
						<a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="icon-font"></i><b class="caret"></b></a>
						<ul class="dropdown-menu"></ul>
					</div>
					<div class="btn-group">
						<a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
							<li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
							<li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
						</ul>
					</div>
					<div class="btn-group">
						<a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
						<a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
						<a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="icon-strikethrough"></i></a>
						<a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
					</div>
					<div class="btn-group">
						<a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="icon-list-ul"></i></a>
						<a class="btn" data-edit="insertorderedlist" title="Number list"><i class="icon-list-ol"></i></a>
						<a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
						<a class="btn" data-edit="indent" title="Indent (Tab)"><i class="icon-indent-right"></i></a>
					</div>
					<div class="btn-group">
						<a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
						<a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
						<a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
						<a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
					</div>
					<div class="btn-group">
						<a class="btn dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="icon-link"></i></a>
						<div class="dropdown-menu input-append">
							<input class="span2" placeholder="URL" type="text" data-edit="createLink" />
							<button class="btn" type="button">Add</button>
						</div>
						<a class="btn" data-edit="unlink" title="Remove Hyperlink"><i class="icon-cut"></i></a>
					</div>
					<div class="btn-group">
						<a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="icon-picture"></i></a>
						<input type="file" id="img-upload" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
					</div>
					<div class="btn-group">
						<a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
						<a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
					</div>
				</div>
		
				<div id="editor">${article['textBody']}</div>
				
				文章封面:
				<input type="hidden" name="coverPath" value="${article['coverPath']}" />
				<input type="file" name="cover" />
				<c:if test="${not empty article['coverPath']}">
					<img style="height:160px;" src="<c:url value='/upload/images/articleCover/${article.id}/${article.coverPath}'/>" />
					<input id="ckbRemoveCover" type="checkbox" value="删除封面" />
					Remove cover:
					<input id="hidRemoveCover" type="hidden" name="removeCover" value="false" />
				</c:if>

				<br />
				
				<input id="btnSubmit" type="button" value="提交" />
				<c:if test="${not empty backURL}">
					&nbsp;<a href="${backURL}">Back</a>
				</c:if>
			</div>
		</div>
	</form>
	
	<script type="text/javascript" src="<c:url value='/js/admin/site/article.js' />"></script>
</body>
</html>