$(function() {
    $(".btnEdit").bind('click', function() {
        var curURL = window.location.href.substring(window.location.href.indexOf("dormitory") - 1);
        window.location.href = "/dormitory/admin/dormitory/dormitory-edit.html?dormitoryId=" + $(this).attr("dormitoryId") + "&backURL=" + encodeURIComponent(curURL);
    });
});
