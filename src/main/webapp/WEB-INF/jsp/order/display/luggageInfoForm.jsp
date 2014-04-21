<hostel:container template="hostel">
    <%-- top section --%>
    <header>
    </header>
    
    <%-- main section --%>
	<main>
		
		<%-- content --%>
		<div class="container">
            <div class="row airport">
				<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
				<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
					<div class="tip-text">
						2014年接机名额还剩1000个
					</div>
					<form >
					<div class="btnBox">
						<a style="color:#AE0000; font-weight: bold; font-size: 20px;" href="<c:url value="/user/orderList.html"/>" >返回</a>
					</div>
					<jsp:include page="displayPickupOrderTopNav.jsp">
						<jsp:param name="pageName" value="luggage"/>
					</jsp:include>
					<div aria-hidden="false" aria-expanded="true" style="display: block;" role="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom" aria-labelledby="ui-id-4" id="tabs-additional">
						<fieldset>
							<dl>
								<dd>托运行李箱信息</dd>
							</dl>
							<dl>
								<dt>尺寸</dt>
								<dd>
									${item.luggageSize}
								</dd>
								<dt class="min">个数</dt>
								<dd>
									${item.luggageAmount}
								</dd>
							</dl>
						</fieldset>
					</div>
					</form>
				</div>

            </div>
		</div>
	</main>
	
    <%-- bottom section --%>
    <footer>
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>