<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/admin/site/slide.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/vendor/jquery.ui.widget.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.iframe-transport.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.fileupload.js' />"></script>
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/style/dropzone.css' />" />
</head>
<body>
	<form action="<c:url value='/admin/slide-save.html'/>" method="POST">
		<table>
			<tr>
				<td valign="center">&nbsp;幻灯片:&nbsp;</td>
				<td>
					<table id="uploaded-files" class="table" style="width: 980px; padding: 20px;">
						<tr>
							<th>图片名称</th>
							<th>预览</th>
							<th>向前移</th>
							<th>向后移</th>
							<th>删除</th>
							<th>是否展示</th>
						</tr>
						<c:forEach var="slide" items="${slides}" varStatus="index">
							<tr class="fileRow">
								<td><input type="text" readonly="readonly" name="imageNames" class="fileNames" value="${slide['path']}" /> <input type="hidden" name="imageIndexes" class="fileIndex" value="${slide['index']}" /></td>
								<td><a href="<c:url value='/upload/images/slide/${slide.path}'/>"> <img src="<c:url value='/upload/images/slide/${slide.path}'/>" /></a></td>
								<td><input type="button" value="向前移 ↑" class="btnUp" /></td>
								<td><input type="button" value="向后移 ↓" class="btnDown" /></td>
								<td><input type="button" value="删除" class="btnRemove" /></td>
								<td><select name="imageShow">
									<option value="1" <c:if test="${slide['status'] eq '1'}">selected="selected"</c:if>>展示</option>
									<option value="0" <c:if test="${slide['status'] eq '0'}">selected="selected"</c:if>>不展示</option>
								</select></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div style="width: 500px; padding: 20px;">
						<input id="fileupload" type="file" name="files[]" data-url="<c:url value='/admin/slide-image-upload.html?dormitoryId=${dormitory.id}'/>" multiple="multiple">
						<div id="dropzone" class="fade well">移动图片到这里</div>
						<div id="progress" class="progress">
							<div class="bar" style="width: 0%;"></div>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body></html>