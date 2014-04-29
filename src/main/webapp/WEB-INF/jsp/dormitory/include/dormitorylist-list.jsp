<ul class="row hostel-list-page">
	<c:forEach var="dormitory" items="${dormitories}" varStatus="i">
		<li>
			<div class="hostel-img pull-left">
			
				<c:if test="${not empty dormitory['rooms']}">
					<a href="<c:url value='/dormitory/dormitory-detail.html?id=${dormitory.id}'/>"><img src="<c:url value='/img/house/house.jpg'/>" alt /></a>
				</c:if>
				
				<c:if test="${empty dormitory['rooms']}">
					<img src="<c:url value='/img/house/house.jpg'/>" alt />
				</c:if>
				
				<p class="hostel-server">
					<a href="#" class="video">&nbsp;</a>
					<a href="#" class="plane">&nbsp;</a>
					<a href="#" class="sale">&nbsp;</a>
					<a href="#" class="sunlight">&nbsp;</a>
				</p>
			</div>
			<div class="hostel-info">
				<input type="hidden" class="hidLocation" value="${dormitory['name']},${dormitory['latitude']},${dormitory['longitude']}"/>
				<div class="price">
					价格<span><em>&#163;</em>${not empty dormitory['rooms'] && not empty dormitory['rooms'][0]['contractPrice'][0] ? dormitory['rooms'][0]['contractPrice'][0]['salePrice'] : dormitory['salePrice']}</span>起
					<div class="starBox" data-score="${dormitory['rating']}"></div>
				</div>
				<div class="title">
					<c:if test="${not empty dormitory['rooms']}">
						<a href="<c:url value='/dormitory/dormitory-detail.html?id=${dormitory.id}'/>">${dormitory['name']}</a>
					</c:if>
					<c:if test="${empty dormitory['rooms']}">
						<a href="#">${dormitory['name']}</a>
					</c:if>
					<span style="color: #ff5400;">
						(<fmt:formatNumber value="${dormitory['distance']}" pattern="#,#0.00"/>KM)
						<%--<c:if test="${dormitory['status'] eq 'HAS_VACANCY'}">尚有空房</c:if>
						<c:if test="${dormitory['status'] eq 'NO_VACANCY'}">已注满</c:if>--%>
					</span>
				</div>
				<div class="address">${dormitory['address']}<br /><em>${dormitory['postcode']}</em></div>
				<p>设施：${dormitory['equipment']}</p>
				<p>服务：${dormitory['service']}</p>
				<p>附加费用：<span><em>&#163;</em>${dormitory['additionalPrice']}</span></p>
				<p>优惠：${dormitory['promotion']}</p>
				<table>
					<thead>
						<tr>
							<th class="td-larger">名称</th>
							<th class="td-long">床型</th>
							<th class="td-long">入住时间</th>
							<th class="td-min">价格</th>
							<th class="td-min">状态</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty dormitory['rooms']}">
							<c:forEach var="room" items="${dormitory['rooms']}" varStatus="j" begin="0" end="1">
								<c:if test="${not empty room}">
									<tr>
										<td class="td-larger" style="text-align: left;">${room['name']}</td>
										<td class="td-long">${room['bedType']}</td>
										<td class="td-long">${room['checkinDateString']}</td>
										<td class="td-min">
											<c:if test="${not empty room['contractPrice'][0]}">
												<em>&#163;</em>${room['contractPrice'][0]['salePrice']}
											</c:if>
										</td>
										<td class="td-min">
											<c:if test="${room['status'] eq 'HAS_VACANCY'}">尚有空房</c:if>
											<c:if test="${room['status'] eq 'NO_VACANCY'}">已注满</c:if>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:if>
						<c:if test="${empty dormitory['rooms']}">
							<tr>
								<td colspan="4">No valid room data.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</li>
	</c:forEach>
</ul>
<div class="row pager">
	<jsp:include page="/jsp/utils/pagination.jsp" flush="true"/> 
</div>