<div class="comment">
	<%--<form action="<c:url value='/dormitory/rate.html' />" method="POST"> --%>
	<form action="#" method="POST">
		<input type="hidden" name="dormitoryId" value="${dormitory['id']}" />
		<input type="hidden" name="id" value="${curRate['id']}" />
		<div class="title">发表评论</div>
		<fieldset>
			<dl>
				<dd>昵称</dd>
				<dt>
					<input type="text" name="alias" value="${empty curRate['alias'] ? userName : curRate['alias']}" />
				</dt>
			</dl>
			<dl>
				<dd>评论</dd>
				<dt>
					<textarea name="comment">${curRate['comment']}</textarea>
				</dt>
			</dl>
			<dl>
				<dd>评分</dd>
				<dt>
					<div id="rate" data-score="${curRate['point']}"></div>
					<input class="btn-comment" type="button" ${empty sessionScope['USER_ID'] ? 'disabled value="登录后才能评论"' : 'value="评论"'} />
				</dt>
			</dl>
		</fieldset>
	</form>
	<div class="title">
		用户评论
	</div>
	<ul class="comment-list">
		<c:forEach var="rate" items="${rates}">
			<c:if test="${rate['status'] > 0}">
				<li>
					<p>
						<a href="#">${rate['alias']}</a>
					</p>
					<div class="comment-content">${rate['comment']}</div>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</div>