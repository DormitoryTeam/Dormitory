$(function() {
	$(".btn-place-order-next").click(function() {
		$("#placeOrderForm").submit();
	});
	
	$("#sameas").click(function() {
		if(!$(this).parent().hasClass("fchecked")) {
			for (var key in guarantee) {
				$("#"+key).val(guarantee[key]);
			}
			if ('0' == $("#gender").val()) {
				$("span .current").html("Mr.");
			}
			
			if ('1' == $("#gender").val()) {
				$("span .current").html("Mrs.");
			}
			if ('2' == $("#gender").val()) {
				$("span .current").html("Miss");
			}
		}	
	
	}) ;
	
	$(".btn-place-order-save").click(function() {
		$("#command").val("SAVE");
		$("#placeOrderForm").submit();
	}); 
});