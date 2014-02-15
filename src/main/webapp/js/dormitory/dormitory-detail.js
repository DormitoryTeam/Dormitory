$(function() {
	$("#btnBookDormitory").bind('click', function() {
		window.location.href = "/dormitory/order/dormitory-order-fill.html?dormitoryId=" + $(this).attr('dormitoryId');
	});
});