$(function() {
	$(".btn-user-info-save").click(function() {
		$("#userForm").submit();
	});
	$(".btn-user-info-edit").click(function() {
		var gotoURL = $(this).attr("gotoURL");
		window.location.href=gotoURL;
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
});