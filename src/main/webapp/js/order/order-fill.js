$(function() {
    $("#otherUserEmail").bind('click', function() {
    });

    $("#btnSearchOtherUserByEmail").bind('click', function() {
        $.ajax({
            type : "POST",
            url : "/dormitory/user/queryUserInfoByEmail.html",
            data : {
                email : $("#otherUserEmail").val()
            },
            success : function(data) {
                var jsonObject = $.parseJSON(data);
                $("#otherUserEmail").val(jsonObject.email);
                $("#othername").val(jsonObject.name);
                $("#otherphone").val(jsonObject.phone);
                $("#otherqq").val(jsonObject.qq);
                $("#otheraddress").val(jsonObject.address);
                $("#othergender").val(!!jsonObject.gender ? 1 : 0);
            }
        });
    });

});
