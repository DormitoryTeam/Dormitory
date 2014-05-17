<ul class="row hostel-list-page">
	<c:forEach var="dormitory" items="${dormitories}" varStatus="i">
		<li>
			<div class="hostel-img pull-left">
			
				<a href="<c:url value='/dormitory/dormitory-detail.html?id=${dormitory.id}&collegeId=${collegeId}'/>">
				<c:if test="${empty dormitory['picPath']}">
					<img src="<c:url value='/img/house/house.jpg'/>" alt /></a>
				</c:if>
				<c:if test="${not empty dormitory['picPath']}">
					<img src="<c:url value='/upload/images/dormitory/${dormitory.id}/${dormitory.picPath[0]}'/>" alt /></a>
				</c:if>
						
				<p class="hostel-server">
					<a href="#" class="video">&nbsp;</a>
					<a href="#" class="plane">&nbsp;</a>
					<a href="#" class="sale">&nbsp;</a>
					<a href="#" class="sunlight">&nbsp;</a>
				</p>
			</div>
			<div class="hostel-info">
				<input type="hidden" class="hidLocation" value="${dormitory['name']},${dormitory['latitude']},${dormitory['longitude']},${dormitory['id']}"/>
				<div class="price">
					价格<c:if test="${(not empty dormitory['rooms'] && not empty dormitory['rooms'][0]['contractPrice'][0] ? dormitory['rooms'][0]['contractPrice'][0]['salePrice'] : dormitory['salePrice']) >= 0}"><span><em>&#163;</em>&nbsp;<fmt:formatNumber value="${not empty dormitory['rooms'] && not empty dormitory['rooms'][0]['contractPrice'][0] ? dormitory['rooms'][0]['contractPrice'][0]['weekPrice'] : dormitory['weekPrice']}" pattern="#0.00"/></span>起</c:if><c:if test="${(not empty dormitory['rooms'] && not empty dormitory['rooms'][0]['contractPrice'][0] ? dormitory['rooms'][0]['contractPrice'][0]['weekPrice'] : dormitory['weekPrice']) <0}"><span>暂无定价</span></c:if>
					<div class="starBox" data-score="${dormitory['rating']}"></div>
				</div>
				<div class="title">
					<a href="<c:url value='/dormitory/dormitory-detail.html?id=${dormitory.id}&collegeId=${collegeId}'/>">${dormitory['name']}</a>
					<span style="color: #ff5400;">
						(<fmt:formatNumber value="${dormitory['distance']}" pattern="#,#0.00"/>KM)
						<%--<c:if test="${dormitory['status'] eq 'HAS_VACANCY'}">尚有空房</c:if>
						<c:if test="${dormitory['status'] eq 'NO_VACANCY'}">已注满</c:if>--%>
					</span>
				</div>
				<div class="address">${dormitory['address']}<br /><em>${dormitory['postcode']}</em></div>
				<p><span style="font-weight: bolder;">服务：</span>${dormitory['service']}</p>
				<p><span style="font-weight: bolder;">附加费用：</span><span><c:if test="${dormitory['additionalPrice']>=0}"><em>&#163;</em>&nbsp;<fmt:formatNumber value="${dormitory['additionalPrice']}" pattern="#0.00"/></c:if><c:if test="${dormitory['additionalPrice']<0}">暂未定价</c:if></p>
				<p><span style="font-weight: bolder;">优惠：</span>${dormitory['promotion']}</p>
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
										<td style="font-size: 10px;" class="td-larger" style="text-align: left;">${room['name']}</td>
										<td style="font-size: 10px;" class="td-long">${room['bedType']}</td>
										<td style="font-size: 10px;" class="td-long">${room['checkinDate']}</td>
										<td style="font-size: 10px;" class="td-min">
											<c:if test="${not empty room['contractPrice'][0]}">
												<c:if test="${room['contractPrice'][0]['weekPrice'] >= 0}"><em>&#163;</em>&nbsp;<fmt:formatNumber value="${room['contractPrice'][0]['weekPrice']}" pattern="#0.00"/></c:if><c:if test="${room['contractPrice'][0]['weekPrice'] < 0 }">暂未定价</c:if>
											</c:if>
										</td>
										<td style="font-size: 10px;" class="td-min">
											<c:if test="${room['status'] eq '0'}">已订满</c:if>
											<c:if test="${room['status'] eq '1'}">尚有空房</c:if>
											<c:if test="${room['status'] eq '2'}">剩余不多</c:if>
											<c:if test="${room['status'] eq '3'}">仅剩几间</c:if>
											<c:if test="${room['status'] eq '4'}">仅剩9间</c:if>
											<c:if test="${room['status'] eq '5'}">仅剩8间</c:if>
											<c:if test="${room['status'] eq '6'}">仅剩7间</c:if>
											<c:if test="${room['status'] eq '7'}">仅剩6间</c:if>
											<c:if test="${room['status'] eq '8'}">仅剩5间</c:if>
											<c:if test="${room['status'] eq '9'}">仅剩4间</c:if>
											<c:if test="${room['status'] eq '10'}">仅剩3间</c:if>
											<c:if test="${room['status'] eq '11'}">仅剩2间</c:if>
											<c:if test="${room['status'] eq '12'}">仅剩1间</c:if>
											<c:if test="${room['status'] eq '13'}">请先咨询</c:if>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:if>
						<c:if test="${empty dormitory['rooms']}">
							<tr>
								<td colspan="4">暂无房间信息</td>
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