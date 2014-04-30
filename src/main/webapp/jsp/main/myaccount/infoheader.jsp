<ul class="info-header">
	<li class="header-img">
		<img src="/img/login/header.jpg" alt="" />
	</li>
	<li>
		${user.login}
		<p><a href="#">修改密码</a><span>|</span><a href="<c:url value="/user/signout.html"/>">注销</a></p>
	</li>
	<li>
		识别码：${user.code}
	</li>
</ul>