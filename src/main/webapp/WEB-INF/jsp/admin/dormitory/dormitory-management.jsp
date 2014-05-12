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
		<input type="submit" id="btnSearchAndSortBy" value="搜索">&nbsp;
		按城市<input type="radio" class="ckbSortField" name="sortField" value="city_id" <c:if test="${sortField eq 'city_id'}">checked="checked"</c:if> />
		按公司<input type="radio" class="ckbSortField" name="sortField" value="company_id" <c:if test="${sortField eq 'company_id'}">checked="checked"</c:if> />
		<input type="button" id="btnAdd" value="新建宿舍">&nbsp;
	</form>
	<hr />
	<table style="width:1100px;">
		<tbody>
			<c:if test="${not empty dormitories}">
				<c:forEach var="dormitory" items="${dormitories}" varStatus="i">
					<tr>
						<td>
							<ul>
								<li>宿舍名称: ${dormitory['name']} &nbsp; 
									<input type="button" class="btnEdit" dormitoryId="${dormitory['id']}" value="编辑宿舍" /></li>
								<li>状态: 
									<c:choose>
										<c:when test="${dormitory['status'] eq 'HAS_VACANCY'}">可预订</c:when>
										<c:when test="${dormitory['status'] eq 'NO_VACANCY'}">不可预订</c:when>
										<c:when test="${dormitory['status'] eq 'INVISIBILITY'}">隐藏</c:when>
									</c:choose>
								</li>
								<li>所在城市: ${dormitory['city']}</li>
								<li>所在公司: ${dormitory['company']}</li>
								<li>地址邮编: ${dormitory['address']}, ${dormitory['postcode']}</li>
								<li>设施:${dormitory['equipment']}</li>
								<li>服务: ${dormitory['service']}</li>
								<li>优惠: ${dormitory['promotion']}</li>
								<li>附加费用: ${dormitory['additionalPrice']}</li>
								<li>拥有房型个数: ${fn:length(dormitory['rooms'])}</li>
							</ul>
							<hr />
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/> 
</body>
</html>