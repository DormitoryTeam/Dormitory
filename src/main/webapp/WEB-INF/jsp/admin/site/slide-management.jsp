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
	<form action="/dormitory/admin/slide-save.html" method="POST">
		<table>
			<tr>
				<td>Images:</td>
				<td>
					<table id="uploaded-files" class="table" style="width: 500px; padding: 20px;">
						<tr>
							<th>File Name</th>
							<th>Preview</th>
							<th>Up</th>
							<th>Down</th>
							<th>Remove</th>
							<th>Show</th>
						</tr>
						<c:forEach var="slide" items="${slides}" varStatus="index">
							<tr class="fileRow">
								<td>${slide}<input type="text" readonly="readonly" name="imageNames" class="fileNames" value="${slide['path']}" /> <input type="hidden" name="imageIndexes" class="fileIndex" value="${slide['index']}" /></td>
								<td><a href="/dormitory/admin/slide-image-preview.html?fileName=${slide['path']}"> <img src="/dormitory/admin/slide-image-preview.html?fileName=${slide['path']}" /></a></td>
								<td><input type="button" value="Up ↑" class="btnUp" /></td>
								<td><input type="button" value="Down ↓" class="btnDown" /></td>
								<td><input type="button" value="Remove" class="btnRemove" /></td>
								<td><select name="imageShow">
									<option value="1" <c:if test="${slide['status'] eq '1'}">selected="selected"</c:if>>Show</option>
									<option value="0" <c:if test="${slide['status'] eq '0'}">selected="selected"</c:if>>Hide</option>
								</select></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div style="width: 500px; padding: 20px;">
						<input id="fileupload" type="file" name="files[]" data-url="/dormitory/admin/slide-image-upload.html?dormitoryId=${dormitory['id']}" multiple="multiple">
						<div id="dropzone" class="fade well">Drop files here</div>
						<div id="progress" class="progress">
							<div class="bar" style="width: 0%;"></div>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="save" /></td>
			</tr>
		</table>
	</form>
</body></html>