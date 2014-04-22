<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row">
               <div class="reservation-content">
					<jsp:include page="display/displayOrderHeader.jsp"/>
					<div class="reservation-personal reservation-tab ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-vertical ui-helper-clearfix">
						<form">
							<a class="addOne" href="/dormitory/order/dormitory-place-order.html?dormitoryId=1&amp;contractId=1&amp;roomInfoId=1">&nbsp;</a>
							<div class="btnBox">
							</div>
							<ul role="tablist" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
								<li aria-selected="false" aria-labelledby="ui-id-1" aria-controls="tabs-personal" tabindex="-1" role="tab" class="ui-state-default ui-corner-left"><a id="ui-id-1" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-additional">个人信息</a></li>
								<li aria-selected="false" aria-labelledby="ui-id-2" aria-controls="tabs-hobby" tabindex="-1" role="tab" class="ui-state-default ui-corner-left"><a id="ui-id-2" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-additional">个人偏好</a></li>
								<li aria-selected="false" aria-labelledby="ui-id-3" aria-controls="tabs-security" tabindex="-1" role="tab" class="ui-state-default ui-corner-left"><a id="ui-id-3" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-additional">担保人信息</a></li>
								<li aria-selected="false" aria-labelledby="ui-id-4" aria-controls="tabs-emergency" tabindex="-1" role="tab" class="ui-state-default ui-corner-left"><a id="ui-id-4" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-additional">紧急联系人信息</a></li>
								<li aria-selected="true" aria-labelledby="ui-id-5" aria-controls="tabs-additional" tabindex="0" role="tab" class="ui-state-default ui-corner-left ui-tabs-active ui-state-active"><a id="ui-id-5" tabindex="-1" role="presentation" class="ui-tabs-anchor" href="#tabs-additional">补充信息</a></li>
							</ul>
							<div aria-hidden="false" aria-expanded="true" style="display: block;" role="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom" aria-labelledby="ui-id-5" id="tabs-additional">
								<div class="row text-center"> 
								<br><br><br><br><br><h1 style="color: #FF8A00;">下单成功</h1><br><br><br><br><br>
								<a style="color:#AE0000; font-weight: bold; font-size: 20px;" href="<c:url value="/user/orderList.html?orderType=D"/>" >返回我的订单</a>
								</div>
							</div>
						</form>
					</div>
				</div>
            </div>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>