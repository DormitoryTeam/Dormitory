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
		title : originalName,
		icon : "http://www.liuxuelife.com/img/map/university.png"
	});
	marker.setMap(map);

	$.each($(".hidLocation"), function(i, e) {
		var infoArray = $(e).val().split(",");
		var dormitoryId = infoArray[3];
		var curLatlng = new google.maps.LatLng(infoArray[1], infoArray[2]);
		var marker = new google.maps.Marker({
			position : curLatlng,
			map : map,
			title : infoArray[0],
			icon : "http://maps.google.com/intl/en_us/mapfiles/ms/micons/red-dot.png"
		});
		marker.setMap(map);
		google.maps.event.addListener(marker, 'mouseover', function (e) {
			marker.setIcon('http://maps.google.com/intl/en_us/mapfiles/ms/micons/green-dot.png');  
		});
		google.maps.event.addListener(marker, 'mouseout', function (e) {
			marker.setIcon('http://maps.google.com/intl/en_us/mapfiles/ms/micons/red-dot.png');  
		});
		google.maps.event.addListener(marker, 'click', function (e) {
			window.location.href = ctx + '/dormitory/dormitory-detail.html?id=' + dormitoryId;  
		});
	});

	$(".ckbSortField").bind("click", function() {
		$("#btnSearchAndSortBy").click();
	});
});
