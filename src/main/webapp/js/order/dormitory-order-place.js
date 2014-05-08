$(function() {
	$(".btn-place-order-next").click(function(event) {
		event.preventDefault();
		if (validate()) {
			$("#placeOrderForm").submit();
		}
	});
	
	
	$(".btn-place-order-pre").click(function(event) {
		event.preventDefault();
		var preStep = $(this).attr("preStep");
		window.location.href = preStep;
	});
	
	$("#sameas").click(function() {
		if(!$(this).parent().hasClass("fchecked")) {
			$(".same-as").each(function(i, e) {
				var id = $(e).attr("id");
				var value = $("#" + id + "_val").val();
				$(e).val(value);
			});
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
	
	$(".btn-place-order-save").click(function(event) {
		event.preventDefault();
		$("#command").val("SAVE");
		if (validate()) {
			$("#placeOrderForm").submit();
		}
		
	});
	$("#placeOrderForm").submit(function() {
		if (0 == $("#pageStep").val()) {
			var hasOrder = false;
			$.ajax({
				url: ctx + "/order/hasOrder.html",
				data: {
					login: $("#login").val(),
					orderType: $("#orderType").val()
				},
				async: false,
				dataType: "json",
				success: function(data) {
					hasOrder = data.result;
				},
				error:function(data) {
					alert(data);
				}
			});
			if (hasOrder) {
				alert("您使用的邮箱：" + $("#login").val() + "已拥有一个订单。请登录查看");
			}
			return !hasOrder;
		}
		return true;
	});
	
});

var validate = function() {
	var fieldName = "";
	var pass = true;
	$(".validate").each(function(i, e) {
		if ("" == $(e).val() || NaN == $(e).val()) {
			fieldName = $(e).attr("errorFieldName");
			pass = false;
		}
		
	}); 
	if (!pass) {
		alert(fieldName + " 不能为空");
	}
	return pass;
};