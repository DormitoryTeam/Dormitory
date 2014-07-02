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
<style type="text/css">
	input[type="text"] { height: 30px; width: 180px;}
	select {width: 150px;}
</style>
<link type="text/css" rel="stylesheet" href="<c:url value='/style/dropzone.css' />" />
<link href="css/dropzone.css" type="text/css" rel="stylesheet" />
<title>公寓编辑</title>
</head>
<body>
	<br />
	<c:if test="${not empty param.result}">
		&nbsp;&nbsp;&nbsp;${param.result ? '保存成功!' : '保存失败!'}
	</c:if>
	<br />
	<br />
	
	<form id="formDormitory" action="<c:url value='/admin/dormitory/dormitory-save.html'/>" method="POST">
		<input type="hidden" name="id" id="hidDormitoryId" value="${empty dormitory['id'] ? 0 : dormitory['id']}" />
		
		<table class="table table-hover table-bordered table-striped">
			<tbody>
				<tr>
					<td>宿舍名称*:</td>
					<td><input type="text" name="name" value="${dormitory['name']}" class="validate" errorFieldName="宿舍名称"/></td>
					<td>宿舍状态:*</td>
					<td><select name="status">
							<c:forEach var="status" items="${allDormitoryStatus}">
								<option value="${status['name']}" ${status eq dormitory['status'] ? 'selected' : ''}>
									<c:if test="${status eq 'HAS_VACANCY'}">尚有空房</c:if>
									<c:if test="${status eq 'NO_VACANCY'}">已住满</c:if>
									<c:if test="${status eq 'INVISIBILITY'}">不展示</c:if>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>显示优先级:</td>
					<td><input type="text" name="displayOrder" value="${dormitory['displayOrder']}" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>所属国家:</td>
					<td><select id="sltCountry" name="countryId">
						<c:forEach items="${countries}" var="country">
							<option value="${country['id']}" <c:if test="${country['id'] eq currentCountry['id']}"></c:if>>${country['name']}</option>
						</c:forEach>
					</select></td>
					<td>所属城市*:</td>
					<td><select id="sltCity" name="cityId">
						<c:forEach var="city" items="${cities}">
							<option value="${city['id']}" <c:if test="${city['id'] eq dormitory['cityId']}">selected="selected"</c:if>>${city['name']}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>所属公司*:</td>
					<td><select name="companyId">
						<c:forEach var="company" items="${companies}">
							<option value="${company['id']}" <c:if test="${company['id'] eq dormitory['companyId']}">selected="selected"</c:if>>${company['name']}</option>
						</c:forEach>
					</select></td>
					<td>邮编:</td>
					<td><input type="text" name="postcode" value="${dormitory['postcode']}" /></td>
				</tr>
				<tr>
					<td>经度*:</td>
					<td><input type="text" name="latitude" value="${dormitory['latitude']}" class="validate" errorFieldName="经度" /></td>
					<td>纬度*:</td>
					<td><input type="text" name="longitude" value="${dormitory['longitude']}" class="validate" errorFieldName="纬度" /></td>
				</tr>
				<tr>
					<td>公寓地址*:</td>
					<td colspan="3"><input type="text" name="address" value="${dormitory['address']}" style="width: 500px;" /></td>
				</tr>
				<tr>
					<td>货币:</td>
					<td><input type="text" name="currency" value="${dormitory['currency']}" /></td>
					<td>固定评分(0-5)</td>
					<td><input type="text" name="defaultRating" value="${dormitory['defaultRating']}" /></td>
				</tr>
				<tr>
					<td>附加费用*:</td>
					<td><input type="text" name="additionalPrice" value="${dormitory['additionalPrice']}" /></td>
					<td>附加费用描述*:</td>
					<td><input type="text" name="additionalPriceText" value="${dormitory['additionalPriceText']}" /></td>
				</tr>
				<tr>
					<td>周价*:</td>
					<td><input type="text" name="weekPrice" value="${dormitory['weekPrice']}" readonly/></td>
					<td>总价*:</td>
					<td><input type="text" name="salePrice" value="${dormitory['salePrice']}" readonly/></td>
				</tr>
				<tr>
					<td>公寓描述:</td>
					<td colspan="3"><textarea name="description" class="span12" cols="600" rows="5">${dormitory['description']}</textarea></td>
				</tr>
				<tr>
					<td>优惠信息:</td>
					<td colspan="3"><textarea name="promotion" class="span12" cols="600" rows="5">${dormitory['promotion']}</textarea></td>
				</tr>
				<tr>
					<td>设施:</td>
					<td colspan="3"><textarea name="equipment" class="span12" cols="600" rows="5">${dormitory['equipment']}</textarea></td>
				</tr>
				<tr>
					<td>服务:</td>
					<td colspan="3"><textarea name="service" class="span12" cols="600" rows="5">${dormitory['service']}</textarea></td>
				</tr>
				<tr>
					<td>退款政策:</td>
					<td colspan="3"><textarea name="refund" class="span12" cols="600" rows="5">${dormitory['refund']}</textarea></td>
				</tr>
				<tr>
					<td>常见问题:</td>
					<td colspan="3"><textarea name="question" class="span12" cols="600" rows="5">${dormitory['question']}</textarea></td>
				</tr>
				<tr>
					<td>特色服务:</td>
					<td colspan="3"><textarea name="feature" class="span12" cols="600" rows="5">${dormitory['feature']}</textarea></td>
				</tr>
			</tbody>
		</table>
		
		<c:if test="${not empty dormitory['id']}">
			<div>
				<hr />
				<div style="width: 500px; padding: 20px;">
					<input id="fileupload" type="file" name="files[]" data-url="<c:url value='/admin/dormitory/dormitory-image-upload.html?dormitoryId=${dormitory.id}'/>" multiple="multiple">
					<div id="dropzone" class="fade well">移动图片到这里</div>
					<div id="progress" class="progress">
						<div class="bar" style="width: 0%;"></div>
					</div>
				</div>
				<table id="uploaded-files" class="table table-hover table-bordered" style="width: 500px; padding: 20px;">
					<tr>
						<th>图片名称</th>
						<th>图片预览</th>
						<th>默认图片</th>
						<th>操作</th>
					</tr>
					<c:forEach var="path" items="${dormitory['picPath']}" varStatus="index">
						<tr>
							<td><input type="text" name="imageNames" class="fileNames" value="${path}" /></td>
							<td><a href="<c:url value='/upload/images/dormitory/${dormitory.id}/${path}'/>"> <img src="<c:url value='/upload/images/dormitory/${dormitory.id}/${path}'/>" /></a></td>
							<td><input type="radio" name="coverImageName" value="${path}" ${dormitory.coverImageName eq path ? 'checked' : ''} /></td>
							<td><input type="button" value="删除" class="btnRemove" fileName="${path}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<hr />
			<c:if test="${not empty dormitory['id']}">
				&nbsp;&nbsp;&nbsp;
				<input type="button" value="新建房型" onclick="location.href = '<c:url value="/admin/dormitory/room-edit.html?dormitoryId=${dormitory.id}&roomId="/>';" />
			</c:if>
			&nbsp;&nbsp;&nbsp;
			<input type="submit" value="提交" />
			&nbsp;&nbsp;&nbsp;
			<input type="button" value="取消" onclick="location.reload(true); return false;" />
			&nbsp;&nbsp;&nbsp;
			<input type="button" value="返回" onclick="location.href = '<c:url value="/admin/dormitory/dormitory-management.html?dormitoryName=&cityId=0&status="/>';" />
		</c:if>
		
		<hr />

		<c:forEach var="room" items="${dormitory['rooms']}">
			<table class="table table-hover table-bordered">
				<tbody>
					<tr class="success">
						<td>${room.roomType}
							<input type="button" value="编辑" onclick="location.href = '<c:url value="/admin/dormitory/room-edit.html?dormitoryId=${dormitory.id}&roomId=${room.id}"/>';" />
						</td>
						<td>房间状态*</td>
						<td>房间名称*</td>
						<td>入住时间*</td>
						<td>房屋面积</td>
						<td>床型</td>
						<td>共享厨房人数</td>
						<td>独立卫浴</td>
						<td>可否安排朝向</td>
						<td>可提供语言宿舍</td>
					</tr>
					<tr>
						<td rowspan="${fn:length(room['contractPrice']) + 2}"></td>
						<td>
							<select disabled="disabled" name="rooms[${i['index']}].status">
								<option value="0" ${'0' eq room['status'] ? 'selected' : ''}>已订满</option>
								<option value="1" ${'1' eq room['status'] ? 'selected' : ''}>尚有空房</option>
								<option value="2" ${'2' eq room['status'] ? 'selected' : ''}>剩余不多</option>
								<option value="3" ${'3' eq room['status'] ? 'selected' : ''}>仅剩几间</option>
								<option value="4" ${'4' eq room['status'] ? 'selected' : ''}>仅剩9间</option>
								<option value="5" ${'5' eq room['status'] ? 'selected' : ''}>仅剩8间</option>
								<option value="6" ${'6' eq room['status'] ? 'selected' : ''}>仅剩7间</option>
								<option value="7" ${'7' eq room['status'] ? 'selected' : ''}>仅剩6间</option>
								<option value="8" ${'8' eq room['status'] ? 'selected' : ''}>仅剩5间</option>
								<option value="9" ${'9' eq room['status'] ? 'selected' : ''}>仅剩4间</option>
								<option value="10" ${'10' eq room['status'] ? 'selected' : ''}>仅剩3间</option>
								<option value="11" ${'11' eq room['status'] ? 'selected' : ''}>仅剩2间</option>
								<option value="12" ${'12' eq room['status'] ? 'selected' : ''}>仅剩0间</option>
								<option value="13" ${'13' eq room['status'] ? 'selected' : ''}>请先咨询</option>
						</select></td>
						<td>${room['name']}</td>
						<td>${room['checkinDate']}</td>
						<td>${room['houseArea']}</td>
						<td>${room['bedType']}</td>
						<td>${room['kitchenPeople']}</td>
						<td>${room['ensuitBathroom'] ? '有' : '没有'}</td>
						<td>${room['orientationArrange'] ? '可以' : '不可以'}</td>
						<td>${room['roomLanguageArrange'] ? '可以' : '不可以'}</td>
					</tr>
					<tr class="warning folding" status="collapse">
						<td>入住周期</td>
						<td>是否启用*</td>
						<td>货币类型*</td>
						<td>周价*</td>
						<td colspan="5">总价*</td>
					</tr>
					<c:forEach var="price" items="${room['contractPrice']}">
						<tr style="display: none;" class="need_folding">
							<td>${price['contract']}</td>
							<td>${price['status'] == 1 ? '启用' : '未启用'}</td>
							<td>${price['currency']}</td>
							<td><fmt:formatNumber value="${empty price['weekPrice'] ? '' : price['weekPrice']}" pattern="#0.00"/></td>
							<td colspan="5"><fmt:formatNumber value="${empty price['salePrice'] ? '' : price['salePrice']}" pattern="#0.00"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>

		<hr />
		<c:if test="${not empty dormitory['id']}">
			&nbsp;&nbsp;&nbsp;
			<input type="button" value="新建房型" onclick="location.href = '<c:url value="/admin/dormitory/room-edit.html?dormitoryId=${dormitory.id}&roomId="/>';" />
		</c:if>
		&nbsp;&nbsp;&nbsp;
		<input type="submit" value="提交" />
		&nbsp;&nbsp;&nbsp;
		<input type="button" value="取消" onclick="location.reload(true); return false;" />
		&nbsp;&nbsp;&nbsp;
		<input type="button" value="返回" onclick="location.href = '<c:url value="/admin/dormitory/dormitory-management.html?dormitoryName=&cityId=0&status="/>';" />
	</form>
</body>
</html>
