$(function() {
	$(".btnMarkDelete").bind("click", function(e) {
		var statusInput = $(e.target).parent().find(":hidden[name='status']");
		if (statusInput.val() == '1') {
			statusInput.val(0);
		} else {
			statusInput.val(1);
		}
		$(e.target).parent().find(":submit").click();
	});
});