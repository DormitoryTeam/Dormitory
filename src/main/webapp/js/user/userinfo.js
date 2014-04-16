$(function() {
	$(".btn-user-info-save").click(function() {
		$("#userForm").submit();
	});
	$(".btn-user-info-edit").click(function() {
		var gotoURL = $(this).attr("gotoURL");
		window.location.href=gotoURL;
	});
});