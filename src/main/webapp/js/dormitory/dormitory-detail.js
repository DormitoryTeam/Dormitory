$(function() {

	$('#choosePeriod').change(function() {
		var contractTypeId = $(this).val();
		var specificContract = contract_room_price['' + contractTypeId];
		if (specificContract) {
			for (var i in room_ids) {
				var roomId = '' + room_ids[i];
				var roomContract = specificContract[roomId];
				if (roomContract) {
					$("#period_" + roomId).text(roomContract['period']);
					$("#weekPrice_" + roomId).text(roomContract['weekPrice']);
					$("#price_" + roomId).text(roomContract['price']);
				}
			}
		}
	});

	$('#rate').raty({
		score : function() {
			return $(this).attr('data-score');
		},
		scoreName : 'point',
		cancel : true,
		cancelHint : 'My cancel hint!',
		path : '../style/img'
	});

	$('.starBox').raty({
		score : function() {
			return $(this).attr('data-score');
		},
		readOnly : true,
		path : '../style/img'
	});

	$("#selectQuickRoom").change(function(e) {
		var contracts = room_contracts[$(this).val()];
		var contractOptions = "";
		$.each(contracts, function(i, e) {
			contractOptions += "<option value='" + e.id + "'>" + e.name + "</option>";
		});
		$("#selectQuickContract").empty().append(contractOptions).simSelect();
		$("#quickPricePreview").html(contracts[0].currency + " " + contracts[0].salePrice);
		$("#quickRoomNamePreview").html(contracts[0].roomName);
	});

	$("#selectQuickContract").change(function(e) {
		var contracts = room_contracts[$("#selectQuickRoom").val()];
		$.each(contracts, function(i, e) {
			if(e.id == $("#selectQuickContract").val()) {
				$("#quickPricePreview").html(e.currency + " " + e.salePrice);
				$("#quickRoomNamePreview").html(e.roomName);
				return false;
			}
		});
	});

	$(".btn-quick").on('click', function(e) {
		$("#quickRoomInfoId").val($("#selectQuickRoom").val());
		$("#quickContractId").val($("#selectQuickContract").val());
		$("#quickPlaceOrderForm").submit();
	});

	$('.jQ-quick').on('click', function() {
		var roomId = $(this).attr("roomId");
		$("#roomInfoId").val(roomId);

		$(this).acsPopup({
			popupSrc : $(this).attr("data-popupSrc"),
			callBack : function() {
				var contracts = room_contracts[roomId];
				for (var i in contracts) {
					var bookHTML = '<option value="' + contracts[i].id + '">' + contracts[i].name + '</option>';
					var bookDIV = $(bookHTML);
					$("#selectContract").append(bookDIV);
				}

				$('select').simSelect();
				$('.btnBook').on('click', function() {
					var contractId = $("#selectContract").val();
					$("#contractId").val(contractId);
					$("#placeOrderForm").submit();
				});
			}
		});
	});

	$("#quickPlaceOrderForm").submit(function() {
		//var hasOrder = $("#expressBooking").attr("hasOrder");
		//var userId = $("#expressBooking").attr("userId");
		var disabled = $("#expressBooking").attr("disabled");
		if (disabled) {
		return false;
		}
		//if (userId) {
		//	if ('true' == hasOrder) {
		//		alert("你只能拥有一个订单，请到个人中心查看。");
		//		return false;
		//	}
		//}
		return true;
	});

	$(".auto-height-textarea").each(function(i, e) {
		$(e).css("height", this.scrollHeight);
	});
	$("#review-popup-close").click(function() {
		$("#mask").hide();
		$("#preview-popup").hide();
	});
	$(".popup-preview").click(function() {
		var src = $(this).attr("src");
		showImgPopup(src);
	});
	try {
		initialize();
	} catch(e) {
	}
	
});

function initialize() {

	var latitude = $("#dormitoryLatitude").val();
	var longitdue = $("#dormitoryLongitude").val();
	var dormitoryLatlng = new google.maps.LatLng(latitude, longitdue);

	var mapOptions = {
		center : dormitoryLatlng,
		zoom : 12,
		mapTypeId : google.maps.MapTypeId.ROADMAP,
		scaleControl : true,
		scaleControlOptions : {
			position : google.maps.ControlPosition.BOTTOM_CENTER
		}
	};
	var map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);

	var marker = new google.maps.Marker({
		position : dormitoryLatlng,
		map : map,
		title : $("#dormitoryName").val()
	});
	marker.setMap(map);

	var collegeLatitude = $("#collegeLatitude").val();
	var collegeLongitdue = $("#collegeLongitude").val();
	var collegeOriginalName = $("#collegeOriginalName").val();
	var collegeLatlng = new google.maps.LatLng(collegeLatitude, collegeLongitdue);

	marker = new google.maps.Marker({
		position : collegeLatlng,
		map : map,
		title : collegeOriginalName,
		icon : "http://www.liuxuelife.com/img/map/university.png"
	});
	marker.setMap(map);
}

function checkCustomHasLogin() {
	var userId = $("#hidUserId").val();
	if (userId == "") {
		$("#arcPopLogin").click();
	}
	return !(userId == "");
}

function showImgPopup(src) {
	$("#preview-img").attr("src", src);
	$("#mask").show();
	$("#preview-popup").show();
}
