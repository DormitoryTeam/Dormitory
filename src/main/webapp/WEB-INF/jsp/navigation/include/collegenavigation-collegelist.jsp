<br />
<br />
<br />
<br />
<div class="row hot-city">
	<div class="title">
		<span>公寓预定热门学校</span>
		<a href="<c:url value='/navigation/hot-cities.html?countryId=1'/>" class="more">> 切换到城市列表</a>
	</div>
	<ul class="city-list show-list-c">
		<c:forEach var="college" items="${allColleges}">
			<c:if test="${college['topCollege']}">
				<li><a href="<c:url value='/dormitory/dormitory-list.html?cityId=${college.cityId}&collegeId=${college.id}'/>">${college['originalName']}</a></li>
			</c:if>
		</c:forEach>
	</ul>
</div>