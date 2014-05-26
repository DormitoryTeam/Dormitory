<div class="reservation-content">
	<div class="reservation-info">
		<span>基本信息</span>
		<fieldset>
			<dl>
				<dt>房屋名</dt>
				<dd>XXXXX</dd>
			</dl>
			<dl>
				<dt>租期</dt>
				<dd>51周</dd>
			</dl>
			<dl>
				<dt>单价</dt>
				<dd>&#163;100</dd>
			</dl>
			<dl>
				<dt>总价</dt>
				<dd>&#163;5100</dd>
			</dl>
			<dl>
				<dt>入住时间</dt>
				<dd>2014.01.04</dd>
			</dl>
		</fieldset>
	</div>
	<div class="reservation-personal reservation-tab">
		<form>
			<!-- <a href="#" class="addOne">&nbsp;</a>-->
			<div class="btnBox">
				<input class="save" type="button" value="保存" />
				<input type="submit" value="提交" />
			</div>
			<ul>
				<li><a href="#tabs-personal">个人信息</a></li>
				<li><a href="#tabs-hobby">个人偏好</a></li>
				<li><a href="#tabs-security">担保人信息</a></li>
				<li><a href="#tabs-emergency">紧急联系人信息</a></li>
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
							<input type="text" /> 
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
						<dd>您是否抽烟?</dd>
						<dd>
							<input type="radio" name="somking" checked /><label>是</label>
							<input type="radio" name="somking" /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd>您是否是素食主义者?</dd>
						<dd>
							<input type="radio" name="vegan" checked /><label>是</label>
							<input type="radio" name="vegan" /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd>What will be your year of study?</dd>
						<dd>
							<input type="radio" name="ustudy" checked /><label>大一</label>
							<input type="radio" name="ustudy" /><label>大二</label>
							<input type="radio" name="ustudy" /><label>大三</label>
							<input type="radio" name="ustudy" /><label>大四</label>
							<input type="radio" name="ustudy" /><label>硕士</label>
							<input type="radio" name="ustudy" /><label>博士</label>
						</dd>
					</dl>
					<dl>
						<dd>您想和哪个年级的人一起住?</dd>
						<dd>
							<input type="radio" name="study" checked /><label>大一</label>
							<input type="radio" name="study" /><label>大二</label>
							<input type="radio" name="study" /><label>大三</label>
							<input type="radio" name="study" /><label>大四</label>
							<input type="radio" name="study" /><label>硕士</label>
							<input type="radio" name="study" /><label>博士</label>
						</dd>
					</dl>
					<dl>
						<dd>室友性别要求?</dd>
						<dd>
							<input type="radio" name="sex" checked /><label>混合性别</label>
							<input type="radio" name="sex" /><label>我是男性想和所有男性一起住</label>
							<input type="radio" name="sex" /><label>我是女性想和所有女性一起住</label>
							<input type="radio" name="sex" /><label>无所谓</label>
						</dd>
					</dl>
					<dl>
						<dt>您的专业</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt>学校</dt>
						<dd>
							<input type="text" /> 
						</dd>
					</dl>
					<dl>
						<dt>特殊要求</dt>
						<dd>
							<input type="text" class="larger" placeholder="楼层/朝向/团队预定/语言班宿舍/提前入住" />
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
						<dt>称呼</dt>
						<dd>
							<select>
								<option value="Miss">Miss</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>与你的关系</dt>
						<dd>
							<input type="text" /> 
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
							<input type="text" /> 
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
			<div id="tabs-emergency">
				<fieldset>
					<dl>
						<dd>
							<input type="checkbox" /><label>同担保人信息</label>
						</dd>
					</dl>
					<dl>
						<dt>称呼</dt>
						<dd>
							<select>
								<option value="Miss">Miss</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>与你的关系</dt>
						<dd>
							<input type="text" /> 
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
							<input type="text" /> 
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
			<div id="tabs-additional">
				<fieldset>
					<dl>
						<dt>毕业院校</dt>
						<dd>
							<input type="text" class="long" /> 
						</dd>
					</dl>
					<dl>
						<dd>是否需要推送你的入读城市信息?</dd>
						<dd>
							<input type="radio" name="push" checked /><label>是</label>
							<input type="radio" name="push" /><label>否</label>
						</dd>
					</dl>
					<dl>
						<dd><input type="checkbox" />我已阅读并同意留学生活网的<a class="showClause" data-popupSrc="<c:url value="/jsp/main/hostel/order/clause.jsp"/>" target="_blank">《条款条例》</a></dd>
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