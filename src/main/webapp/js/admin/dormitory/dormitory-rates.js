$(function() {
    $(".btnEdit").bind('click', function() {
        var curURL = window.location.href.substring(window.location.href.indexOf("dormitory") - 1);
        window.location.href = "/admin/dormitory/dormitory-rate-edit.html?dormitoryId=" + $(this).attr("dormitoryId");
    });
    
	$(".ckbSortField").bind("click", function() {
		$("#btnSearchAndSortBy").click();
	});
});
