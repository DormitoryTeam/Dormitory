<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/home.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/admin/dormitory/dormitory-edit.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/vendor/jquery.ui.widget.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.iframe-transport.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.fileupload.js' />"></script>
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/style/dropzone.css' />" />

<!-- we code these -->
<link href="css/dropzone.css" type="text/css" rel="stylesheet" />
<title></title>
</head>
<body>

	<form action="/dormitory/admin/dormitory/dormitory-save.html" method="POST">
		<table>
			<tbody>
				<tr>
					<td>DormitoryId:<input type="hidden" name="id" id="hidDormitoryId" value="${dormitory['id']}" /></td>
					<td>${dormitory['id']}</td>
				</tr>
				<tr>
					<td>Name*:</td>
					<td><input type="text" name="name" value="${dormitory['name']}" /></td>

				</tr>
				<tr>
					<td>Country:</td>
					<td><select id="sltCountry" name="countryId">
							<c:forEach items="${countries}" var="country">
								<option value="${country['id']}" <c:if test="${country['id'] eq currentCountry['id']}"></c:if>>${country['name']}</option>
							</c:forEach>
					</select></td>
					<td>City*:</td>
					<td><select id="sltCity" name="cityId">
							<c:forEach var="city" items="${cities}">
								<option value="${city['id']}" <c:if test="${city['id'] eq dormitory['cityId']}">selected="selected"</c:if>>${city['name']}</option>
							</c:forEach>
					</select></td>
				</tr>

				<td>College*:</td>
				<td><select id="sltCollege" name="collegeId">
						<c:forEach var="college" items="${colleges}">
							<option value="${college['id']}" <c:if test="${college['id'] eq dormitory['collegeId']}">selected="selected"</c:if>>${college['name']}</option>
						</c:forEach>
				</select></td>
				<td>Post Code:</td>
				<td><input type="text" name="postCode" value="${dormitory['postCode']}" /></td>
				</tr>

				<tr>
					<td>Contract:</td>
					<td><select name="contractId">
							<c:forEach var="contractType" items="${contractTypes}">
								<option value="${contractType['id']}" <c:if test="${contractType['id'] eq dormitory['contractId']}">selected="selected"</c:if>>${contractType['name']}</option>
							</c:forEach>
					</select></td>
					<td>Dormitory Type:</td>
					<td><select name="dormitoryTypeId">
							<c:forEach var="dormitoryType" items="${dormitoryTypes}">
								<option value="${dormitoryType['id']}" <c:if test="${dormitoryType['id'] eq dormitory['dormitoryTypeId']}">selected="selected"</c:if>>${dormitoryType['name']}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Latitude:</td>
					<td><input type="text" name="latitude" value="${dormitory['latitude']}" /></td>
					<td>Longitude:</td>
					<td><input type="text" name="longitude" value="${dormitory['longitude']}" /></td>
				</tr>
				<tr>
					<td>Address*:</td>
					<td><input type="text" name="address" value="${dormitory['address']}" style="width: 300px;" /></td>
					<td>Currency:</td>
					<td><input type="text" name="currency" value="${dormitory['currency']}" /></td>
				</tr>
				<tr>
					<td>List Price:</td>
					<td><input type="text" name="listPrice" value="${dormitory['listPrice']}" /></td>
					<td>Sale Price:</td>
					<td><input type="text" name="salePrice" value="${dormitory['salePrice']}" /></td>
				</tr>
				<tr>
					<td>Service:</td>
					<td><input type="text" name="service" value="${dormitory['service']}" /></td>
					<td>Equipment:</td>
					<td><input type="text" name="equipment" value="${dormitory['equipment']}" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td colspan="3"><textarea name="description" cols="80" rows="5">
						${dormitory['description']}
					</textarea></td>
				</tr>

				<tr>
					<td>Images:</td>
					<td>
						<table id="uploaded-files" class="table" style="width: 500px; padding: 20px;">
							<tr>
								<th>#</th>
								<th>File Name</th>
								<th>File Size</th>
								<th>File Type</th>
								<th>Preview</th>
							</tr>
							<c:forEach var="path" items="${dormitory['picPath']}" varStatus="index">
								<tr>
									<td>${index.count}</td>
									<td></td>
									<td></td>
									<td></td>
									<td><a href="/dormitory/admin/dormitory/dormitory-image-preview.html?dormitoryId=${dormitory['id']}&fileName=${path}"> <img src="/dormitory/admin/dormitory/dormitory-image-preview.html?dormitoryId=${dormitory['id']}&fileName=${path}" /></a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<div style="width: 500px; padding: 20px;">
							<input id="fileupload" type="file" name="files[]" data-url="/dormitory/admin/dormitory/dormitory-image-upload.html?dormitoryId=${dormitory['id']}" multiple="multiple">
							<div id="dropzone" class="fade well">Drop files here</div>
							<div id="progress" class="progress">
								<div class="bar" style="width: 0%;"></div>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Update" /></td>
					<td><a href="${backURL}">Back to list</a></td>
				</tr>
			</tbody>
		</table>
	</form>

	<hr />

</body>
</html>