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
				<jsp:include page="/jsp/main/hostel/order/include/pickupTopNav.jsp"/>
				<div class="reservation-personal air-tab-personal ui-tabs ui-widget ui-widget-content ui-corner-all">
					<div class="tip-text">
						2014年接机名额还剩1000个
					</div>
					<form>
					<div class="btnBox">
						<a style="color:#AE0000; font-weight: bold; font-size: 20px;" href="<c:url value="/user/orderList.html"/>" >返回</a>
					</div>
					<jsp:include page="displayPickupOrderTopNav.jsp">
						<jsp:param name="pageName" value="destination"/>
					</jsp:include>
					
					
					<div aria-hidden="false" aria-expanded="true" style="display: block;" role="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom" aria-labelledby="ui-id-3" id="tabs-security">
						<fieldset>
							<dl>
								<dt>城市</dt>
								<dd>
									${item.pickup2City}
								</dd>
							</dl>
							<dl>
								<dt>地址</dt>
								<dd>
									${item.pickup2Address}
								</dd>
							</dl>
							<dl>
								<dt>宿舍</dt>
								<dd>
									${item.pickup2Dormitory}
								</dd>
							</dl>
							<dl>
								<dt>邮编</dt>
								<dd>
									${item.pickup2Postalcode}
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
    <jsp:include page="/jsp/footer/footer.jsp" />
    </footer>
    <script type="text/javascript" src="<c:url value='/js/order/dormitory-order-place.js'/>"></script>
</hostel:container>
