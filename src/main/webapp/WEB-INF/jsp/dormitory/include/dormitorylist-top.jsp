<form action="<c:url value='/dormitory/dormitory-list.html' />" method="GET">
	<input type="hidden" name="collegeId" value="${college['id']}" />
	<input type="hidden" name="cityId" value="${city['id']}" />
	<div class="row searchBox">
		<fieldset>
			搜索当前城市<input type="text" name="keyword" value="${keyword}" /> <input type="submit" id="btnSearchAndSortBy" class="btn-search" value="" />
		</fieldset>
	</div>
	<ul class="row bread-crumb">
		<li><a href="<c:url value='/navigation/navigator.html?countryId=${country.id}'/>">${country['name']}</a></li>
		<li><a href="<c:url value='/navigation/navigator.html?cityId=${city.id}'/>"><span>&#62;</span>${city['name']}</a></li>
		<c:if test="${not empty collegeId}">
			<li><span>&#62;</span>${college['originalName']}</li>
		</c:if>
	</ul>
	<div class="row filter">
		<fieldset>
			<dl>
				<dt>
					<input type="radio" class="ckbSortField" name="sortField" value="salePrice" <c:if test="${sortField eq 'salePrice'}">checked</c:if> />
				<dd>
					<label for="price">按价格</label>
				</dd>
			</dl>
			<c:if test="${not empty collegeId}">
				<dl>
					<dt>
						<input type="radio" class="ckbSortField" name="sortField" value="distance" <c:if test="${sortField eq 'distance' or empty sortField}">checked</c:if> />
					</dt>
					<dd>
						<label for="range">按距离</label>
					</dd>
				</dl>
			</c:if>
			<dl>
				<dt>
					<input type="radio" class="ckbSortField" name="sortField" value="rating" <c:if test="${sortField eq 'rating'}">checked</c:if> />
				</dt>
				<dd>
					<label for="score">按评分</label>
				</dd>
			</dl>
			<dl>
				<dt>
					<input type="radio" class="ckbSortField" name="sortField" value="sales" <c:if test="${sortField eq 'sales'}">checked</c:if> />
				</dt>
				<dd>
					<label for="sales">按销量</label>
				</dd>
			</dl>
		</fieldset>
	</div>
</form>
<br/>