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
	
	$(".btnBookDormitory").each(function(i, e) {
		$(e).click(function() {
			var bookContainer = $("#chooseContract");
			bookContainer.empty();
			var roomId = $(this).attr("roomId");
			$("#roomInfoId").val(roomId);
			var contracts = room_contracts[roomId];
			for (var i in contracts) {
				var bookHTML = '<div>#name#: #pice# <input type="button" contractId="#id#" class="bookNowbtn" value="Book Now"/></div>';
				console.log("id: " + contracts[i].id + "; name: " + contracts[i].name + "; salePrice: " + contracts[i].salePrice + "; currency: " + contracts[i].currency);
				bookHTML = bookHTML.replace("#name#", contracts[i].name);
				bookHTML = bookHTML.replace("#pice#", contracts[i].salePrice);
				bookHTML = bookHTML.replace("#id#", contracts[i].id);
				var bookDIV = $(bookHTML);
				bookContainer.append(bookDIV);
			}
			$(document).on("click",".bookNowbtn",function(){
				var contractId = $(this).attr("contractId");
				console.log("contractId: " + contractId);
				$("#contractId").val(contractId);
				$("#placeOrderForm").submit();
			});
		
		}); 
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