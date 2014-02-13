$(function() {
    $(".btnDetail").bind('click', function() {
    	window.location.href = "/dormitory/dormitory/dormitory-detail.html?id=" + $(this).attr('dormitoryId');
    })
}); 