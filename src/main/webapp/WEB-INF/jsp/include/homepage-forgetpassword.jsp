<div class="pop-content">
	<form class="register">
		<fieldset>
			<dl>
				<dt>输入邮箱地址，用于找回密码</dt>
				<dd><input id="iptLogin" type="text"></dd>
			</dl>
			<dl>
				<dd class="error"><span class="errorMessage">&nbsp;</span></dd>
			</dl>
			<dl class="btnBox">
				<dd>
					<input type="button" id="btnForgetPasswordSubmit" value="找回密码">
				</dd>
			</dl>
		</fieldset>
		<a href="javascript:void(0)" id="forgetPasswordTip" class="jQ-email" data-popupSrc="<c:url value='/user/toForgetPasswordResult.html'/>" style="display: none;" >&nbsp;</a>
	</form>
</div>