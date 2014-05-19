<form action="<c:url value='/dormitory/dormitory-list.html' />" method="GET">
	<input type="hidden" name="collegeId" value="${college['id']}" />
	<input type="hidden" name="cityId" value="${city['id']}" />
	<div class="row searchBox">
		<fieldset>
			搜索当前城市&nbsp;<input type="text" name="keyword" value="${keyword}" /> <input type="submit" id="btnSearchAndSortBy" class="btn-search" value="" placeholder="宿舍名称"/>
		</fieldset>
	</div>
	<ul class="row bread-crumb">
		<li><a style="color: #dfdfdf;" href="<c:url value='/navigation/hot-cities.html?countryId=${country.id}'/>">${country['name']}</a></li>
		<li><a style="color: #dfdfdf;" href="<c:url value='/navigation/hot-cities.html?cityId=${city.id}#${city.id}'/>"><span>&#62;</span>${city['name']}</a></li>
		<c:if test="${not empty collegeId}">
			<li style="color: #ae0000;"><span style="color: #dfdfdf;">&#62;</span>${college['originalName']}</li>
		</c:if>
	</ul>
	<c:choose>
	<c:when test="${fn:endsWith (sortField, '+')}">
		<c:set var="arr" value="&uarr;"/>
	</c:when>
	<c:otherwise>
		<c:set var="arr" value="&darr;"/>
	</c:otherwise>
	</c:choose>
	
	<div class="row filter">
		<fieldset>
			<dl>
				<dt>
					<input type="radio" class="ckbSortField" name="sortField" value="dor_displayOrder-" <c:if test="${fn:startsWith(sortField, 'dor_displayOrder')}">checked</c:if> />
				</dt>
				<dd>
					<label for="score">按推荐<c:if test="${fn:startsWith (sortField, 'rating')}">${arr}</c:if></label>
				</dd>
			</dl>
			<dl>
				<dt>
					<input type="radio" class="ckbSortField" name="sortField" value="<c:choose><c:when test="${fn:startsWith (sortField, 'salePrice') and fn:endsWith (sortField, '+')}">salePrice-</c:when><c:otherwise>salePrice+</c:otherwise></c:choose>" <c:if test="${fn:startsWith (sortField, 'salePrice')}">checked</c:if> />
				<dd>
					<label for="price">按价格<c:if test="${fn:startsWith (sortField, 'salePrice')}">${arr}</c:if></label>
				</dd>
			</dl>
			<c:if test="${not empty collegeId}">
				<dl>
					<dt>
						<input type="radio" class="ckbSortField" name="sortField" value="<c:choose><c:when test="${fn:startsWith(sortField, 'distance') and fn:endsWith(sortField, '+')}">distance-</c:when><c:otherwise>distance+</c:otherwise></c:choose>" <c:if test="${fn:startsWith(sortField, 'distance') or empty sortField}">checked</c:if> />
					</dt>
					<dd>
						<label for="range">按距离<c:if test="${fn:startsWith (sortField, 'distance')}">${arr}</c:if></label>
					</dd>
				</dl>
			</c:if>
			<dl>
				<dt>
					<input type="radio" class="ckbSortField" name="sortField" value="<c:choose><c:when test="${fn:startsWith(sortField, 'rating') and fn:endsWith(sortField, '-')}">rating+</c:when><c:otherwise>rating-</c:otherwise></c:choose>" <c:if test="${fn:startsWith(sortField, 'rating')}">checked</c:if> />
				</dt>
				<dd>
					<label for="score">按评分<c:if test="${fn:startsWith (sortField, 'rating')}">${arr}</c:if></label>
				</dd>
			</dl>
			<dl>
				<dt>
					<input type="radio" class="ckbSortField" name="sortField" value="<c:choose><c:when test="${fn:startsWith(sortField, 'dormitory_order_count') and fn:endsWith(sortField, '-')}">dormitory_order_count+</c:when><c:otherwise>dormitory_order_count-</c:otherwise></c:choose>" <c:if test="${fn:startsWith(sortField, 'dormitory_order_count')}">checked</c:if> />
				</dt>
				<dd>
					<label for="sales">按销量<c:if test="${fn:startsWith (sortField, 'dormitory_order_count')}">${arr}</c:if></label>
				</dd>
			</dl>
		</fieldset>
	</div>
</form>
<br/>