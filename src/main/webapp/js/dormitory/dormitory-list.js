$(function() {

	var latitude = $("#collegeLatitude").val();
	var longitdue = $("#collegeLongitude").val();
	var originalName = $("#collegeOriginalName").val();
	var collegeLatlng = new google.maps.LatLng(latitude, longitdue);

	var mapOptions = {
		center : collegeLatlng,
		zoom : 10,
		mapTypeId : google.maps.MapTypeId.ROADMAP,
		scaleControl: true,
		scaleControlOptions: {
			position: google.maps.ControlPosition.BOTTOM_CENTER
		}
	};
	var map = new google.maps.Map(document.getElementById("map_canvas"),
			mapOptions);
			
	var marker = new google.maps.Marker({
		position : collegeLatlng,
		map : map,
		title : originalName
	});
	marker.setMap(map);

	$.each($(".hidLocation"), function(i, e) {
		var infoArray = $(e).val().split(",");
		var curLatlng = new google.maps.LatLng(infoArray[1], infoArray[2]);
		var marker = new google.maps.Marker({
			position : curLatlng,
			map : map,
			title : infoArray[0]
		});
		marker.setMap(map);
	});

	$(".ckbSortField").bind("click", function() {
		$("#btnSearchAndSortBy").click();
	});
});
