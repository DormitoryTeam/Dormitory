<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.4.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/admin/dormitory/dormitory-management.js'/>"></script>
<title></title>
</head>
<body>
	<form action="<c:url value="/admin/dormitory/dormitory-management.html"/>" method="get">
		按名字:<input type="text" name="dormitoryName" value="${dormitoryName}" />
		城市：
		<select id="sltCity" name="cityId">
			<option value="0">所有城市</option>
			<c:forEach var="city" items="${cities}" varStatus="i">
			<option value="${city['id']}" <c:if test="${cityId eq city['id']}">selected</c:if> >${city['name']}</option>
			</c:forEach>
		</select>
		<select name="status">
			<option value="" ${param.status eq '' ? 'selected' : ''}>有效的宿舍</option>
			<option value="INVISIBILITY" ${param.status eq 'INVISIBILITY' ? 'selected' : ''}>无效的宿舍</option>
		</select>
		<input type="submit" id="btnSearchAndSortBy" value="搜索">&nbsp;
		<input type="radio" class="ckbSortField" name="sortField" value="dor_displayOrder" <c:if test="${sortField eq 'dor_displayOrder'}">checked="checked"</c:if> />按显示优先级
		<input type="radio" class="ckbSortField" name="sortField" value="company_id" <c:if test="${sortField eq 'company_id'}">checked="checked"</c:if> />按公司
		<input type="button" id="btnAdd" value="新建宿舍">&nbsp;
		
	</form>
	<hr />
	<table style="width:1100px;">
		<tbody>
			<c:if test="${not empty dormitories}">
				<c:forEach var="dormitory" items="${dormitories}" varStatus="i">
					<tr>
						<form action="<c:url value="/admin/dormitory/update-dormitory-status.html" />" method="POST">
							<input type="hidden" name="id" value="${dormitory['id']}" />
							<input type="hidden" name="status" value="${dormitory['status'] eq 'INVISIBILITY' ? 'HAS_VACANCY' : 'INVISIBILITY'}" />
							<input type="hidden" name="queryString" value="${pageContext.request.queryString}"/>
						<td>
							<ul>
								<li><span style="font-weight: bolder">宿舍名称:</span> ${dormitory['name']} &nbsp; 
									<input type="button" class="btnEdit" dormitoryId="${dormitory['id']}" value="编辑宿舍" />&nbsp;&nbsp;
									<input type="submit" value="${dormitory['status'] eq 'INVISIBILITY' ? '取消删除' : '删除宿舍'}" />
									</li>
								<li><span style="font-weight: bolder">显示优先级:</span> 
									${dormitory['displayOrder']}
								</li>
								<li><span style="font-weight: bolder">状态:</span> 
									<c:choose>
										<c:when test="${dormitory['status'] eq 'HAS_VACANCY'}">可预订</c:when>
										<c:when test="${dormitory['status'] eq 'NO_VACANCY'}">不可预订</c:when>
										<c:when test="${dormitory['status'] eq 'INVISIBILITY'}">隐藏</c:when>
									</c:choose>
								</li>
								<li><span style="font-weight: bolder">所在城市:</span> ${dormitory['city']}</li>
								<li><span style="font-weight: bolder">所属公司:</span> ${dormitory['company']}</li>
								<li><span style="font-weight: bolder">地址邮编:</span> ${dormitory['address']}, ${dormitory['postcode']}</li>
								<li><span style="font-weight: bolder">设施:</span> ${dormitory['equipment']}</li>
								<li><span style="font-weight: bolder">服务:</span> ${dormitory['service']}</li>
								<li><span style="font-weight: bolder">优惠:</span> ${dormitory['promotion']}</li>
								<li><span style="font-weight: bolder">附加费用:</span> ${dormitory['additionalPrice']}</li>
								<li><span style="font-weight: bolder">拥有房型个数:</span> ${fn:length(dormitory['rooms'])}</li>
							</ul>
							<hr />
						</td>
						</form>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/> 
</body>
</html>