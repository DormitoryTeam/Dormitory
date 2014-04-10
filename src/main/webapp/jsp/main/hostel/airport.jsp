<div class="row airport">
	<div class="nav-box">
		<ul class="reservation-nav">
			<li class="icon-plane"><a href="#">接机预定</a></li>
			<li class="icon-old"><a href="#">往年回顾</a></li>
			<li class="icon-air-compare"><a href="#">航班对比</a></li>
		</ul>
		<div class="air-tip">
			<div class="title">Tips:</div>
			<div class="tip-content">
				注意！
			</div>
		</div>
	</div>
	<div class="reservation-personal air-tab-personal">
		<div class="tip-text">
			2014年接机名额还剩1000个
		</div>
		<form>
			<a href="#" class="addOne">&nbsp;</a>
			<div class="btnBox">
				<input class="save" type="button" value="保存">
			</div>
			<ul>
				<li><a href="#tabs-personal">个人信息</a></li>
				<li><a href="#tabs-hobby">航班信息</a></li>
				<li><a href="#tabs-security">送达地址</a></li>
				<li><a href="#tabs-additional">补充信息</a></li>
			</ul>
			<div id="tabs-personal">
				<fieldset>
					<dl>
						<dt>称呼</dt>
						<dd>
							<select>
								<option value="Miss">Miss</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>姓</dt>
						<dd>
							<input type="text" class="min" /> 
						</dd>
						<dt>名</dt>
						<dd>
							<input type="text" class="min" /> 
						</dd>
					</dl>
					<dl>
						<dt>国籍</dt>
						<dd>
							<input type="text" class="min" /> 
						</dd>
						<dt class="long">服务语言</dt>
						<dd>
							<select>
								<option value="中文">中文</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>出生日期</dt>
						<dd>
							<select>
								<option value="1950">1950</option>
							</select>
							年
							<select>
								<option value="01">01</option>
							</select>
							月
							<select>
								<option value="01">01</option>
							</select>
							日
						</dd>
					</dl>
					<dl>
						<dt>电子邮件</dt>
						<dd>
							<input type="text" class="long" /> 
						</dd>
					</dl>
					<dl>
						<dt>QQ</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt>微信号</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt>手机号码</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt>家庭住址</dt>
						<dd>
							<input type="text" class="min" /> (国家)<input type="text" class="min" /> (省)<input type="text" class="min" /> (市)<input type="text" class="min" /> (区县)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input type="text" class="larger" /> (街道地址)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input type="text" /> (邮编)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<button class="btn-style">下一步</button>
						</dd>
					</dl>
				</fieldset>
			</div>
			<div id="tabs-hobby">
				<fieldset>
					<dl>
						<dt>起飞时间</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt class="long">起飞城市</dt>
						<dd>
							<input type="text" class="min" /> 
						</dd>
						<dt class="long">中转城市</dt>
						<dd>
							<input type="text" class="min" /> 
						</dd>
						<dt class="long">抵达城市</dt>
						<dd>
							<input type="text" class="min" /> 
						</dd>
					</dl>
					<dl>
						<dt>抵达国家</dt>
						<dd>
							<select>
								<option value="英国">英国</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dd>抵达机场</dd>
						<dd>
							<input type="radio" name="airport" checked /><label>曼彻斯特机场</label>
							<input type="radio" name="airport" /><label>利兹布拉德福德机场</label>
							<input type="radio" name="airport" /><label>伦敦希思罗机场</label>
							<input type="radio" name="airport" /><label>爱丁堡机场</label>
							<input type="radio" name="airport" /><label>伯明翰机场</label>
							<input type="radio" name="airport" /><label>盖特维克机场(Gatwick)</label>
						</dd>
					</dl>
					<dl>
						<dt>航空公司</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt>航班号</dt>
						<dd>
							<input type="text" placeholder="xxx转xxx" /> 
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<button class="btn-style">下一步</button>
						</dd>
					</dl>
				</fieldset>
			</div>
			<div id="tabs-security">
				<fieldset>
					<dl>
						<dt>城市</dt>
						<dd>
							<input type="text" /> (学生手填)
						</dd>
					</dl>
					<dl>
						<dt>地址</dt>
						<dd>
							<input type="text" class="larger" /> 
						</dd>
					</dl>
					<dl>
						<dt>邮编</dt>
						<dd>
							<input type="text" /> (若是公寓宿舍请提供其名字)
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<button class="btn-style">下一步</button>
						</dd>
					</dl>
				</fieldset>
			</div>
			<div id="tabs-additional">
				<fieldset>
					<dl>
						<dd>托运行李箱信息(可在订单管理页面更改)</dd>
					</dl>
					<dl>
						<dt>尺寸</dt>
						<dd>
							<input type="text" /> 
						</dd>
						<dt class="min">个数</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt>尺寸</dt>
						<dd>
							<input type="text" /> 
						</dd>
						<dt class="min">个数</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<button class="btn-style">下一步</button>
						</dd>
					</dl>
				</fieldset>
			</div>
		</form>
	</div>
</div>