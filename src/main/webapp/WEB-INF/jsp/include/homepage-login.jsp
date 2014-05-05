<div class="pop-content">
	<div class="login">
		<fieldset>
			<dl>
				<dt>账号:</dt>
				<dd><input id="iptLogin" name="login" value="${login}" type="text" /></dd>
			</dl>
			<dl>
				<dt>密码:</dt>
				<dd><input id="iptPassword" name="password" type="password" /></dd>
			</dl>
			<dl class="tip" style="width: auto;">
				<dt>&nbsp;</dt>
				<dd>
					<a href="<c:url value='/user/toForgetPassword.html'/>" class="foget">忘记密码</a> 
					<input type="checkbox"><label>记住我</label>
				</dd>
			</dl>
			<dl>
				<dt>&nbsp;</dt>
				<dd class="error"><span class="errorMessage">&nbsp;</span></dd>
			</dl>
			<dl class="btnBox">
				<dt>&nbsp;</dt>
				<dd>
					<input id="btnLoginSubmit" name="submit" type="button" value="登&nbsp;录" />
				</dd>
			</dl>
		</fieldset>
	</div>
</div> 