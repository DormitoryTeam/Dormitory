<div class="pop-content">
	<form class="register email">
		<fieldset>
			<p>验证邮件已发送到您的邮箱：${login}</p>
			<p>请点击邮件中的确认链接完成验证。</p>
			<dl class="btnBox">
				<dd>
					<a href="<c:url value="/navigation/home.html"/>">返回首页</a>
				</dd>
			</dl>
			<dl>
				<dt>没有收到验证邮件？</dt>
				<dd>1. 电子邮件偶尔会有延时状况，请耐心等待</dd>
				<dd>2. 尝试到垃圾邮件里找找看</dd>
				<dd>3. 如果仍然没有邮件：<a href="<c:url value='/user/toForgetPassword.html'/>">重新发送验证邮件</a></dd>
				<dd>4. 邮件地址写错了？<a href="<c:url value='/user/toRegister.html'/>">重新注册</a></dd>
			</dl>
		</fieldset>
	</form>
</div>