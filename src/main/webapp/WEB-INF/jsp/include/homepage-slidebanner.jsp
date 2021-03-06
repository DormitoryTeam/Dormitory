﻿<div class="row">
	<div class="sidebar ml-10 pull-right">
		<div class="serviceBox">
			<div class="itembar">
				<ul>
					<li id="dormitory-tab" style="cursor: pointer;">宿舍</li>
					<li id="pickup-tab" style="cursor: pointer;">接机</li>
				</ul>
			</div>
			<div class="selectContent" id="dormitory-form">
				<form action="<c:url value='/navigation/hot-cities.html'/>" method="GET">
					<fieldset class="select-show-info">
						<dl>
							<dt>国家</dt>
							<dd>
								<select id="sltCountry" name="countryId">
									<c:choose>
										<c:when test="${not empty countries}">
											<c:forEach items="${countries}" var="country">
												<option value="${country['id']}">${country['name']}</option>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="0">no valid result</option>
										</c:otherwise>
									</c:choose>
								</select>
							</dd>
						</dl>
						<dl>
							<dt>城市</dt>
							<dd>
								<select id="sltCity" name="cityId">
									<c:choose>
										<c:when test="${not empty cities}">
											<c:forEach items="${cities}" var="city">
												<c:if test="${city['topCity']}">
													<option value="${city['id']}">${city['name']}</option>
												</c:if>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="0">no valid result</option>
										</c:otherwise>
									</c:choose>
								</select>
							</dd>
						</dl>
					</fieldset>
					<fieldset>
						<dl class="btnBox">
							<dt>&nbsp;</dt>
							<dd>
								<input type="submit" value="搜&nbsp;索" class="btn-search" />
							</dd>
						</dl>
					</fieldset>
				</form>
			</div>
			<div class="selectContent" style="display:none;" id="pickup-form">
				<form id="pickupForm" action="<c:url value="/order/dormitory-place-order.html"/>" method="GET">
					<input type="hidden" name="orderType" value="pickup" />
					<fieldset class="select-show-info">
						<dl>
							<dt>国家</dt>
							<dd>
								<select id="sltPickupCountry" name="countryId">
									<c:choose>
										<c:when test="${not empty countries}">
											<c:forEach items="${countries}" var="country">
												<option value="${country['id']}">${country['name']}</option>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="0">no valid result</option>
										</c:otherwise>
									</c:choose>
								</select>
							</dd>
						</dl>
						<dl>
							<dt>机场</dt>
							<dd>
								<select id="sltAirport" name="airportId">
									<c:choose>
										<c:when test="${not empty airports}">
											<c:forEach items="${airports}" var="airport">
												<option value="${airport['id']}">${airport['name']}</option>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="0">no valid result</option>
										</c:otherwise>
									</c:choose>
								</select>
							</dd>
						</dl>
					</fieldset>
					<fieldset>
						<dl class="btnBox">
							<dt>&nbsp;</dt>
							<dd>
								<input type="submit" value="接&nbsp;机&nbsp;预&nbsp;定" class="btn-search" id="pickupBtn" hasPickupOrder="${hasPickupOrder}"/>
							</dd>
						</dl>
					</fieldset>
				</form>
			</div>
		</div>
		<c:if test="${sessionScope.USER_ID > 0}">
			<div class="userInfo">
				<ul>
					<li class="user-header">
						<div class="header-img-opacity">
							<img src="<c:url value='/img/login/header.jpg'/>" alt="" />
						</div>
					</li>
					<li>
						<div class="user-name">
							<a href="#">${user['login']}</a>
						</div>
						<ul class="user-links">
							<li><a href="<c:url value="/user/orderList.html?orderType=D"/>">我的订单</a></li>
							<li><a href="<c:url value="/user/editUserInfo.html"/>">个人中心</a></li>
							<li><a href="<c:url value="/user/signout.html"/>">注销</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</c:if>
		<c:if test="${empty sessionScope.USER_ID}">
			<div class="login-plan">
				<ul>
					<li><a href="javascript:void(0)" class="reg-btn jQ-regbtn" data-popupSrc="<c:url value="/user/loadRegister.html"/>">&nbsp;</a></li>
					<li><a href="javascript:void(0)" class="login-btn jQ-loginbtn" data-popupSrc="<c:url value="/user/loadLogin.html"/>">&nbsp;</a></li>
				</ul>
			</div>
		</c:if>
	</div>
	<div class="contentBox">
		<div class="sliderShow">
			<div class="sliderList">
				<c:if test="${not empty slides}">
					<c:forEach var="img" items="${slides}">
						<div class="sliderItem">
							<c:if test="${not empty img.redirecturl}">
								<a href="${img.redirecturl}">
									<img src="<c:url value='/upload/images/slide/${img.path}'/>" alt="${empty img['desc'] ? img['path'] : img['desc']}" />
								</a>
							</c:if>
							<c:if test="${empty img.redirecturl}">
								<a href="<c:url value='/upload/images/slide/${img.path}' />">
									<img src="<c:url value='/upload/images/slide/${img.path}'/>" alt="${empty img['desc'] ? img['path'] : img['desc']}" />
								</a>
							</c:if>
							<p class="text"></p>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty slides}">
					<div class="sliderItem">
						<a href="#">
							<img src="<c:url value='/img/slider/slider-img.jpg'/>" alt="" />
						</a>
						<p class="text"></p>
					</div>
				</c:if>
			</div>
			<div class="sliderPager"></div>
		</div>
	</div>
</div>