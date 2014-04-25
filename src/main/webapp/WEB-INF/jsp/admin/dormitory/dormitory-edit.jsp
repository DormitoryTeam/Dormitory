<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/admin/dormitory/dormitory-edit.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/vendor/jquery.ui.widget.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.iframe-transport.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.fileupload.js' />"></script>
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/style/dropzone.css' />" />
<link href="css/dropzone.css" type="text/css" rel="stylesheet" />
<title></title>
</head>
<body>
	<br />
	<form id="formDormitory" action="<c:url value='/admin/dormitory/dormitory-save.html'/>" method="POST">
		<input type="hidden" name="id" id="hidDormitoryId" value="${empty dormitory['id'] ? 0 : dormitory['id']}" />
		<table class="table table-hover table-bordered table-striped" style="width:1000px">
			<tbody>
				<tr>
					<td>Dormitory Status*</td>
					<td><select name="status">
							<c:forEach var="status" items="${allDormitoryStatus}">
								<option value="${status['name']}" ${status eq dormitory['status'] ? 'selected' : ''}>${status['name']}</option>
							</c:forEach>
						</select>
					</td>
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
				<tr>
					<td>College*:</td>
					<td><select id="sltCollege" name="collegeId">
						<c:forEach var="college" items="${colleges}">
							<option value="${college['id']}" <c:if test="${college['id'] eq dormitory['collegeId']}">selected="selected"</c:if>>${college['name']}</option>
						</c:forEach>
					</select></td>
					<td>Post Code:</td>
					<td><input type="text" name="postcode" value="${dormitory['postcode']}" /></td>
				</tr>
				<tr>
					<td>Latitude*:</td>
					<td><input type="text" name="latitude" value="${dormitory['latitude']}" /></td>
					<td>Longitude*:</td>
					<td><input type="text" name="longitude" value="${dormitory['longitude']}" /></td>
				</tr>
				<tr>
					<td>Address*:</td>
					<td><input type="text" name="address" value="${dormitory['address']}" style="width: 300px;" /></td>
					<td>Currency:</td>
					<td><input type="text" name="currency" value="${dormitory['currency']}" /></td>
				</tr>
				<tr>
					<td>Week Price*:</td>
					<td><input type="text" name="weekPrice" value="${dormitory['weekPrice']}" /></td>
					<td>Sale Price*:</td>
					<td><input type="text" name="salePrice" value="${dormitory['salePrice']}" /></td>
				</tr>
				<tr>
					<td>Service:</td>
					<td colspan="3">
						<c:forEach var="service" items="${services}" varStatus="i">
							<input type="checkbox" name="inputService" value="${i['index']}"
								${dormitory['binaryServiceArray'][i['index']] eq '1'.charAt(0) ? 'checked=\"true\"' : ''}" /> ${service} &nbsp;
						</c:forEach>
					</td>
				</tr><tr>
					<td>Equipment:</td>
					<td colspan="3">
						<c:forEach var="equipment" items="${equipments}" varStatus="i">
							<input type="checkbox" name="inputEquipment" value="${i['index']}"
								${dormitory['binaryEquipmentArray'][i['index']] eq '1'.charAt(0) ? 'checked=\"true\"' : ''}" /> ${equipment} &nbsp;
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>Description:</td>
					<td colspan="3"><textarea name="description" cols="600" rows="5">${dormitory['description']}</textarea></td>
				</tr>
			</tbody>
		</table>

		<table class="table table-hover table-bordered" style="width:1000px">
			<tbody>
				<c:set var="contractCount" value="${fn:length(contractTypes)}" />
				<c:forEach var="roomType" items="${roomTypes}" varStatus="i">
					<c:set var="curRoom" value="${emptyRoom}" />
					<c:forEach var="room" items="${dormitory['rooms']}">
						<c:if test="${roomType['id'] eq room['roomTypeId']}">
							<c:set var="curRoom" value="${room}" />
						</c:if>
					</c:forEach>
					
					<tr class="success">
						<td>RoomType</td>
						<td>Status*</td>
						<td>RoomName*</td>
						<td>CheckinDate*</td>
						<td>HouseArea</td>
						<td>BedType</td>
						<td>EnsuitBathroom</td>
						<td>OrientationArrange</td>
						<td>RoomLanguageArrange</td>
						<td>BathroomEquipment</td>
						<td>KitchenEquipment</td>
					</tr>
					<tr>
						<th rowspan="${contractCount+2}">${roomType['name']}</th>
						<td>
							<input type="hidden" name="rooms[${i['index']}].dormitoryId" value="${empty dormitory['id'] ? 0 : dormitory['id']}" />
							<input type="hidden" name="rooms[${i['index']}].id" value="${curRoom['id']}" />
							<input type="hidden" name="rooms[${i['index']}].roomTypeId" value="${roomType['id']}" />
							<select name="rooms[${i['index']}].status">
							<c:forEach var="status" items="${allDormitoryStatus}">
								<option value="${status['name']}" ${status eq curRoom['status'] ? 'selected' : ''}>${status['name']}</option>
							</c:forEach>
						</select></td>
						<td><input type="text" name="rooms[${i['index']}].name" value="${curRoom['name']}" /></td>
						<td><input type="text" name="rooms[${i['index']}].checkinDateString" value="${curRoom['checkinDateString']}" /></td>
						<td><input type="text" name="rooms[${i['index']}].houseArea" value="${curRoom['houseArea']}" /></td>
						<td><input type="text" name="rooms[${i['index']}].bedType" value="${curRoom['bedType']}" /></td>
						<td><select name="rooms[${i['index']}].ensuitBathroom">
							<option value="false" ${!curRoom['ensuitBathroom'] ? 'selected' : ''}>No</option>
							<option value="true"  ${ curRoom['ensuitBathroom'] ? 'selected' : ''}>Yes</option>
						</select></td>
						<td><select name="rooms[${i['index']}].orientationArrange">
							<option value="false" ${!curRoom['orientationArrange'] ? 'selected' : ''}>No</option>
							<option value="true"  ${ curRoom['orientationArrange'] ? 'selected' : ''}>Yes</option>
						</select></td>
						<td><select name="rooms[${i['index']}].roomLanguageArrange">
							<option value="false" ${!curRoom['roomLanguageArrange'] ? 'selected' : ''}>No</option>
							<option value="true"  ${ curRoom['roomLanguageArrange'] ? 'selected' : ''}>Yes</option>
						</select></td>
						<td><input type="text" name="rooms[${i['index']}].bathroomEquipment" value="${curRoom['bathroomEquipment']}" /></td>
						<td><input type="text" name="rooms[${i['index']}].kitchenEquipment" value="${curRoom['kitchenEquipment']}" /></td>
					</tr>
					<tr class="warning">
						<td>Contract</td>
						<td>Active*</td>
						<td>Currency*</td>
						<td>Week Price*</td>
						<td>Sale Price*</td>
					</tr>
					<c:forEach var="contract" items="${contractTypes}" varStatus="j">
						<c:set var="curPrice" value="${emptyPrice}" />
						<c:forEach var="price" items="${curRoom['contractPrice']}">
							<c:if test="${contract['id'] eq price['contractId']}">
								<c:set var="curPrice" value="${price}" />
							</c:if>
						</c:forEach>
						<tr>
							<td>${contract['name']}
								<input type="hidden" name="prices[${contractCount*i['index']+j['index']}].id" value="${curPrice['id']}" />
								<input type="hidden" name="prices[${contractCount*i['index']+j['index']}].roomInfoId" value="${curRoom['id']}" />
								<input type="hidden" name="prices[${contractCount*i['index']+j['index']}].contractId" value="${contract['id']}" />
							</td>
							<td><input type="checkbox" name="prices[${contractCount*i['index']+j['index']}].status" value="1" ${curPrice['status'] == 1 ? 'checked' : ''} /></td>
							<td><input type="text" name="prices[${contractCount*i['index']+j['index']}].currency" value="${empty curPrice['currency'] ? '' : curPrice['currency']}" /></td>
							<td><input type="text" name="prices[${contractCount*i['index']+j['index']}].weekPrice" value="${empty curPrice['weekPrice'] ? 0.0 : curPrice['weekPrice']}" /></td>
							<td><input type="text" name="prices[${contractCount*i['index']+j['index']}].salePrice" value="${empty curPrice['salePrice'] ? 0.0 : curPrice['salePrice']}" /></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${not empty dormitory['id']}">
			<hr />
			<div style="width: 500px; padding: 20px;">
				<input id="fileupload" type="file" name="files[]" data-url="<c:url value='/admin/dormitory/dormitory-image-upload.html?dormitoryId=${dormitory.id}'/>" multiple="multiple">
				<div id="dropzone" class="fade well">Drop files here</div>
				<div id="progress" class="progress">
					<div class="bar" style="width: 0%;"></div>
				</div>
			</div>
			<table id="uploaded-files" class="table table-hover table-bordered" style="width: 500px; padding: 20px;">
				<tr>
					<th>File Name</th>
					<th>Preview</th>
					<th>Action</th>
				</tr>
				<c:forEach var="path" items="${dormitory['picPath']}" varStatus="index">
					<tr>
						<td><input type="text" name="imageNames" class="fileNames" value="${path}" /></td>
						<td><a href="<c:url value='/upload/images/dormitory/${dormitory.id}/${path}'/>"> <img src="<c:url value='/upload/images/dormitory/${dormitory.id}/${path}'/>" /></a></td>
						<td><input type="button" value="Remove" class="btnRemove" fileName="${path}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<hr />
		<input type="submit" value="Update" /> <a href="${backURL}">Back to list</a>
	</form>
</body>
</html>