<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    	<jsp:include page="/jsp/header/header.jsp" />
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row airport">
				<div class="nav-box">
					<ul class="reservation-nav">
						<li class="icon-plane"><a href="#">接机预定</a></li>
						<li class="icon-old"><a href="#">往年回顾</a></li>
						<li class="icon-air-compare"><a href="#">航班对比</a></li>
					</ul>
					<div class="air-tip">
						<!--
						<div class="title">Tips:</div>
						<div class="tip-content">
							注意！
						</div>
						-->
					</div>
				</div>
				<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
					<div class="tip-text">
						2014年接机名额还剩1000个
					</div>
						<form action="<c:url value="/order/dormitory-place-order.html"/>" method="POST" id="placeOrderForm">
						<input name="pageStep" value="0" type="hidden">
						<input name="command" id="command" type="hidden">
						<input name="orderType" value="pickup" type="hidden">
						<input name="dormitoryId" value="" type="hidden">
						<input name="contractId" value="" type="hidden"> 
						<input name="roomInfoId" value="" type="hidden">
						<input name="infoId" value="" type="hidden">
						<!-- <a class="addOne" href="<c:url value="/order/dormitory-place-order.html?orderType=pickup"/>">&nbsp;</a>-->
						<div class="btnBox">
						</div>
						<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
							<li class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-personal" aria-labelledby="ui-id-1" aria-selected="true"><a href="#tabs-personal" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">个人信息</a></li>
							<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-hobby" aria-labelledby="ui-id-2" aria-selected="false"><a href="#tabs-hobby" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">航班信息</a></li>
							<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-security" aria-labelledby="ui-id-3" aria-selected="false"><a href="#tabs-security" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">送达地址</a></li>
							<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-additional" aria-labelledby="ui-id-4" aria-selected="false"><a href="#tabs-additional" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">补充信息</a></li>
						</ul>
						<div id="tabs-personal" aria-labelledby="ui-id-1" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false">
							<div class="row text-center"> 
								<br><br><br><br><br><h1 style="color: #FF8A00;">下单成功</h1><br><br><br><br><br>
								<a style="color:#AE0000; font-weight: bold; font-size: 20px;" href="<c:url value="/user/orderList.html"/>" >返回我的订单</a>
								</div>
						</div>
						</form>
				</div>
            </div>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    <jsp:include page="/jsp/footer/footer.jsp" />
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>

