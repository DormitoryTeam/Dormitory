$(function() {
    $(".btnEdit").bind('click', function() {
        var curURL = window.location.href.substring(window.location.href.indexOf("dormitory") - 1);
        window.location.href = "/admin/dormitory/dormitory-edit.html?dormitoryId=" + $(this).attr("dormitoryId") + "&backURL=" + encodeURIComponent(curURL);
    });
    
    $("#btnAdd").bind('click', function() {
    	var curURL = window.location.href.substring(window.location.href.indexOf("dormitory") - 1);
        window.location.href = "/admin/dormitory/dormitory-add.html?dormitoryId=" + $(this).attr("dormitoryId") + "&backURL=" + encodeURIComponent(curURL);
    });
    
	$(".ckbSortField").bind("click", function() {
		$("#btnSearchAndSortBy").click();
	});
});
