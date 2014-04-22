$(function() {
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
	
	initialize();
});

function initialize() {

	var latitude = $("#dormitoryLatitude").val();
	var longitdue = $("#dormitoryLongitude").val();
	var dormitoryLatlng = new google.maps.LatLng(latitude, longitdue);

	var mapOptions = {
		center : dormitoryLatlng,
		zoom : 8,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("map_canvas"),
			mapOptions);

	var marker = new google.maps.Marker({
		position : dormitoryLatlng,
		map : map,
		title : $("#dormitoryName").val()
	});
	marker.setMap(map);
}