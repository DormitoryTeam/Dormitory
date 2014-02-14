$(function() {
	$("#btnBookDormitory").bind('click', function() {
		window.location.href = "/dormitory/order/order-fill.html?dormitoryId=" + $(this).attr('dormitoryId');
	});
});