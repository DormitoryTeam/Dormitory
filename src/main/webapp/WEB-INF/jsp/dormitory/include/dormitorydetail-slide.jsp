<div class="img-larger-content">
	<c:if test="${not empty dormitory['picPath']}">
		<img src="<c:url value='/upload/images/dormitory/${dormitory.id}/${dormitory.picPath[0]}'/>" class="popup-preview" />
	</c:if>
	<c:if test="${empty dormitory['picPath']}">
		<img src="<c:url value='/img/house/house-larger.jpg'/>" class="popup-preview" />
	</c:if>
</div>

<div class="scroll-small">
	<a class="prev browse left"></a>
	<div class="scrollable" id="scrollable">
		<div class="items">
			<c:if test="${not empty dormitory['picPath']}">
				<c:set var="count" value="1" />
				<c:forEach var="img" items="${dormitory['picPath']}">
					<c:if test="${count eq 1}">
						<div>
					</c:if>
					<img src="<c:url value='/upload/images/dormitory/${dormitory.id}/${img}'/>" />
					<c:if test="${count eq 5}">
				</div>
				<c:set var="count" value="0" />
				</c:if>
				<c:set var="count" value="${count + 1}" />
				</c:forEach>
				<c:if test="${count > 1}">
				</div>
				</c:if>
			</c:if>
			<c:if test="${empty dormitory['picPath']}">
				<div>
					<img src="<c:url value='/img/house/house-larger.jpg'/>" />
				</div>
			</c:if>
		</div>
	</div>
	<a class="next browse right"></a>
</div>