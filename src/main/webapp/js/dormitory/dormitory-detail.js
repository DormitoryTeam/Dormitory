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
	
	initialize();
});


function initialize() {

	var latitude = $("#dormitoryLatitude").val();
	var longitdue = $("#dormitoryLongitude").val();
	var myLatlng = new google.maps.LatLng(latitude, longitdue);

	var mapOptions = {
		center : myLatlng,
		zoom : 8,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("map_canvas"),
			mapOptions);

	var marker = new google.maps.Marker({
		position : myLatlng,
		map : map,
		title : "Hello World!"
	});
	marker.setMap(map);
}