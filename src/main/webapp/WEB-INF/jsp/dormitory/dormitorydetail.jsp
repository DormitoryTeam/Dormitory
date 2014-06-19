<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="hostel" tagdir="/WEB-INF/tags"%>
<hostel:container template="hostel">
	<%-- top section --%>
	<script type="text/javascript" src="<c:url value='/js/jquery-raty/jquery.raty.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/dormitory/dormitory-detail.js'/>"></script>
	<!--<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDseYSlaYVhokgVdQuPH9Y35gACzO2n3BM&sensor=false"></script>-->
	
	<header>
		<jsp:include page="/jsp/header/header.jsp" />
	</header>

	<%-- main section --%>
	<main> <%-- content --%>
	<div class="container">
		<div class="row">
			<div class="sidebar pull-right">
				<jsp:include page="include/dormitorydetail-quickbook.jsp" />
				<jsp:include page="include/dormitorydetail-rightbar.jsp" />
			</div>
			<div class="contentBox">
				<jsp:include page="include/dormitorydetail-detail.jsp" />
				<jsp:include page="include/dormitorydetail-comment.jsp" />
			</div>
		</div>
	</div>
	<div id="mask" times="2" id="xubox_shade2" class="xubox_shade" style="display: none; background-color: rgb(0, 0, 0); color: rgb(54, 54, 54); font-size: 14px; font-style: normal; font-variant: normal; font-weight: normal; height: 100%; left: 0px; line-height: 21px; margin-bottom: 0px; margin-left: 0px; margin-right: 0px; margin-top: 0px; opacity: 0.8999999761581421; padding-bottom: 0px; padding-left: 0px; padding-right: 0px; padding-top: 0px; position: fixed; top: 0px; width: 100%; z-index: 19891016;"></div>
	<div id="preview-popup" times="2" showtime=-"0" style="display: none; color: rgb(54, 54, 54); font-size: 14px; font-style: normal; font-variant: normal; font-weight: normal; height: auto; left: 683px; line-height: 21px; margin-bottom: 0px; margin-left: -308.5px; margin-right: 0px; margin-top: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px; padding-top: 0px; position: fixed; top: 100px; width: auto; z-index: 19891017;" id="xubox_layer2" class="xubox_layer" type="page">
		<div style="z-index: 19891016; height: 400px; width: 617.7705826612766px;" class="xubox_main">
			<div class="xubox_page">
				<div class="xuboxPageHtml">
					<div class="xubox_bigimg" >
							<img id="preview-img" src="http://sentsin.qiniudn.com/sentsin_39101a660cf4671b7ec297a74cc652c74152104f.jpg" layer-pid="109" style="top: 114.5px; visibility: visible;">
							<div class="xubox_imgsee" style="display: none;">
							<a href="" class="xubox_iconext xubox_prev"></a><a href="" class="xubox_iconext xubox_next"></a>
							<div class="xubox_imgbar">
								<span class="xubox_imgtit"><a href="javascript:;">JSON请求的相册 </a><em>1/5</em></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<span class="xubox_setwin"><a id="review-popup-close" style="background-attachment: scroll; background-clip: border-box; background-color: rgba(0, 0, 0, 0); background-image: url(/img/xubox_ico0.png); background-origin: padding-box; background-position: -60px -195px; background-size: auto; color: rgb(54, 54, 54); cursor: pointer; display: block; font-size: 0px; font-style: normal; font-variant: normal; font-weight: normal; height: 30px; line-height: 0px; margin-left: 0px; overflow-x: hidden; overflow-y: hidden; position: absolute; right: -28px; text-decoration: none solid rgb(54, 54, 54); top: -28px; vertical-align: top; width: 30px;" href="javascript:;" style=""></a></span>
			<span class="xubox_botton"></span>
		</div>
	</div>
	</main>

	<%-- bottom section --%>
	<footer>
		<jsp:include page="/jsp/footer/footer.jsp" />
	</footer>
</hostel:container>