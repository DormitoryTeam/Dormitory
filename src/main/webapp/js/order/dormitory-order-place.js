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
		if($("#sameas:checked").length>0) {
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
	
	$(".btn-back").click(function(event) {
		var url = $(this).attr("data-url");
		window.location.href = url;
	});
	
	$("#placeOrderForm").submit(function() {
		//if (0 == $("#pageStep").val()) {
		//	if($("#orderId").val()) {
		//		return true;
		//	}
		//	var hasOrder = false;
		//	$.ajax({
		//		url: ctx + "/order/hasOrder.html",
		//		data: {
		//			login: $("#login").val(),
		//			orderType: $("#orderType").val()
		//		},
		//		async: false,
		//		dataType: "json",
		//		success: function(data) {
		//			hasOrder = data.result;
		//		},
		//		error:function(data) {
		//			alert(data);
		//		}
		//	});
		//	if (hasOrder) {
		//		alert("您使用的邮箱：" + $("#login").val() + "已拥有一个订单。请登录查看");
		//	}
		//	return !hasOrder;
		//}
		if (!isChoosed("isChoose")) {
			alert("请选择已阅读条款条例");
			return false;
		}
		return true;
	});
	
	
	$('.showClause').on('click', function() {
		$(this).acsPopup({
			popupSrc : $(this).attr("data-popupSrc"),
			callBack : function() {
				$(".popupCov").css("height", "auto");
			}
		});
	});
});

var isChoosed= function (className) {
	if ($("."+ className).length > 0) {
		var choosedValue = $("."+ className + ":checked").val();
		if ("Y" == choosedValue) {
			return true;
		} else{
			return false;
		}
	}
	return true;
}


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