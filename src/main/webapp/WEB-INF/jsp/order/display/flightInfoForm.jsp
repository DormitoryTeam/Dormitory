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
						<jsp:param name="pageName" value="flight"/>
					</jsp:include>
					
					<div id="tabs-hobby" aria-labelledby="ui-id-2" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: block;" aria-expanded="true" aria-hidden="false">
						<fieldset>
							<dl>
								<dt>起飞时间</dt>
								<dd>
									<fmt:formatDate value='${item.takeOffDate}' pattern='yyyy-MM-dd'/>
								</dd>
							</dl>
							<dl>
								<dt class="long">起飞城市</dt>
								<dd>
									${item.takeOffCity}
								</dd>
								<dt class="long">抵达城市</dt>
								<dd>
									${item.arrivalCity}
								</dd>
							</dl>
							<dl>
								<dt>抵达国家</dt>
								<dd>
									${item.arrivalCountry}
								</dd>
							</dl>
							<dl>
								<dt>抵达机场</dt>
								<dd>
									${item.arrivalAirport}
								</dd>
							</dl>
							<dl>
								<dt>接机时间</dt>
								<dd>
									<fmt:formatDate value='${item.pickupDate}' pattern='yyyy-MM-dd'/>
								</dd>
							</dl>
							<dl>
								<dt>航空公司</dt>
								<dd>
									${item.flightCompany}
								</dd>
							</dl>
							<dl>
								<dt>航班号</dt>
								<dd>
									${item.flightNum}
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