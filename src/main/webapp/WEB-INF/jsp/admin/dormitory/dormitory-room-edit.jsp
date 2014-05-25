<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.1.9.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/admin/dormitory/room-edit.js' />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/style/admin.css' />" />
<title></title>
</head>
<body>

	<br />
	<c:if test="${not empty result}">
		&nbsp;&nbsp;&nbsp;${result ? '保存成功!' : '保存失败!'}
	</c:if>
	<br />
	<br />
	
	<form action="<c:url value='/admin/dormitory/room-save.html'/>" method="POST">
		<input type="hidden" name="dormitoryId" value="${dormitoryId}" />
		<input type="hidden" id="roomId" name="id" value="${empty roomId ? '-1' : roomId}" />
		<table id="tableRoom" class="table table-hover table-bordered table-striped">
			<tbody>
				<tr class="success">
					<td>房间类型*</td>
					<td>房间状态*</td>
					<td>房间名称*</td>
					<td colspan="3">入住时间*</td>
				</tr>
				<tr>
					<td><select name="roomTypeId">
							<c:forEach var="roomType" items="${roomTypes}">
								<option value="${roomType.id}" ${roomType.id eq room.roomTypeId ? 'selected' : ''}>${roomType.name}</option>
							</c:forEach>
					</select></td>
					<td><select name="status">
							<option value="0" ${'0' eq room.status ? 'selected' : ''}>已订满</option>
							<option value="1" ${'1' eq room.status ? 'selected' : ''}>尚有空房</option>
							<option value="2" ${'2' eq room.status ? 'selected' : ''}>剩余不多</option>
							<option value="3" ${'3' eq room.status ? 'selected' : ''}>仅剩几间</option>
							<option value="4" ${'4' eq room.status ? 'selected' : ''}>仅剩9间</option>
							<option value="5" ${'5' eq room.status ? 'selected' : ''}>仅剩8间</option>
							<option value="6" ${'6' eq room.status ? 'selected' : ''}>仅剩7间</option>
							<option value="7" ${'7' eq room.status ? 'selected' : ''}>仅剩6间</option>
							<option value="8" ${'8' eq room.status ? 'selected' : ''}>仅剩5间</option>
							<option value="9" ${'9' eq room.status ? 'selected' : ''}>仅剩4间</option>
							<option value="10" ${'10' eq room.status ? 'selected' : ''}>仅剩3间</option>
							<option value="11" ${'11' eq room.status ? 'selected' : ''}>仅剩2间</option>
							<option value="12" ${'12' eq room.status ? 'selected' : ''}>仅剩0间</option>
							<option value="13" ${'13' eq room.status ? 'selected' : ''}>请先咨询</option>
					</select></td>
					<td><input type="text" name="name" value="${room.name}" /></td>
					<td colspan="3"><input type="text" name="checkinDate" value="${room.checkinDate}" /></td>
				</tr>
				<tr class="success">
					<td>房屋面积</td>
					<td>床型</td>
					<td>共享厨房人数</td>
					<td>独立卫浴</td>
					<td>可否安排朝向</td>
					<td>可提供语言宿舍</td>
				</tr>
				<tr>
					<td><input type="text" name="houseArea" value="${room.houseArea}" /></td>
					<td><input type="text" name="bedType" value="${room.bedType}" /></td>
					<td><input type="text" name="kitchenPeople" value="${room.kitchenPeople}" /></td>
					<td><select name="ensuitBathroom">
							<option value="false" ${!room.ensuitBathroom ? 'selected' : ''}>没有</option>
							<option value="true" ${ room.ensuitBathroom ? 'selected' : ''}>有</option>
					</select></td>
					<td><select name="orientationArrange">
							<option value="false" ${!room.orientationArrange ? 'selected' : ''}>不可以</option>
							<option value="true" ${ room.orientationArrange ? 'selected' : ''}>可以</option>
					</select></td>
					<td><select name="roomLanguageArrange">
							<option value="false" ${!room.roomLanguageArrange ? 'selected' : ''}>不可以</option>
							<option value="true" ${ room.roomLanguageArrange ? 'selected' : ''}>可以</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td colspan="5">
						<input type="button" id="btnAddPrice" value="新增价格" />
						&nbsp;&nbsp;&nbsp;
						<input type="submit" value="保存">
						&nbsp;&nbsp;&nbsp;
						<a href="<c:url value='/admin/dormitory/dormitory-edit.html?dormitoryId=${dormitoryId}'/>">返回编辑宿舍</a></td>
				</tr>
				<tr class="warning">
					<td>入住周期</td>
					<td>是否启用*</td>
					<td>货币类型*</td>
					<td>周价*</td>
					<td>总价*</td>
					<td>操作</td>
				</tr>
				<c:forEach var="price" items="${room.contractPrice}" varStatus="i">
					<tr class="rowPrice" index="${i.index}">
						<td><select name="contractPrice[${i.index}].contractId">
								<c:forEach var="contract" items="${contractTypes}">
									<option value="${contract.id}" ${contract.id eq price.contractId ? 'selected' : ''}>${contract.name}</option>
								</c:forEach>
							</select>
							<input type="hidden" name="contractPrice[${i.index}].id" value="${price.id}" />
							<input type="hidden" name="contractPrice[${i.index}].roomInfoId" value="${room.id}" /> 
						</td>
						<td><input type="checkbox" name="contractPrice[${i.index}].status" value="1" ${price.status == 1 ? 'checked' : ''} /></td>
						<td><input class="price" type="text" name="contractPrice[${i.index}].currency" value="${empty price.currency ? '' : price.currency}" /></td>
						<td><input class="price" type="text" name="contractPrice[${i.index}].weekPrice" value="<fmt:formatNumber value="${empty price.weekPrice ? 0 : price.weekPrice}" pattern="#0.00"/>" /></td>
						<td><input class="price" type="text" name="contractPrice[${i.index}].salePrice" value="<fmt:formatNumber value="${empty price.salePrice ? 0 : price.salePrice}" pattern="#0.00"/>" /></td>
						<td><input type="button" class="btnRemovePrice" value="删除" />
							<input type="hidden" class="hidShouldDelete" value="false" name="contractPrice[${i.index}].shouldDelete" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		&nbsp;&nbsp;&nbsp;
		<input type="button" id="btnAddPrice" value="新增价格" />
		&nbsp;&nbsp;&nbsp;
		<input type="submit" value="保存" />
		&nbsp;&nbsp;&nbsp;
		<a href="<c:url value='/admin/dormitory/dormitory-edit.html?dormitoryId=${dormitoryId}'/>">返回编辑宿舍</a></td>
	</form>
	
	<script type="text/javascript">
		contractOptionDomStr = '<c:forEach var="contract" items="${contractTypes}"><option value="${contract.id}">${contract.name}</option></c:forEach>';
	</script>
</body>
</html>