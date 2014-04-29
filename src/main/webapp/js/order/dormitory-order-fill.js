$(function() {

    $("#btnSearchOtherUserByEmail").bind('click', function() {
        $.ajax({
            type : "POST",
            url : ctx + "/user/queryUserInfoByEmail.html",
            data : {
                email : $("#otheremail").val()
            },
            success : function(data) {
                if (data != null && data != "") {
                    var jsonObject = $.parseJSON(data);
                    $("#otherid").val(jsonObject.id);
                    $("#othername").val(jsonObject.name);
                    $("#otherphone").val(jsonObject.phone);
                    $("#otherqq").val(jsonObject.qq);
                    $("#otheraddress").val(jsonObject.address);
                    $("#othergender").val(!!jsonObject.gender ? 1 : 0);
                }
            }
        });
    });

    $(".orderFor").bind('click', function() {
        if ($(this).val() === "true") {
            $("#otherid").val($("#id").val());
            $("#othername").val($("#name").val());
            $("#otherphone").val($("#phone").val());
            $("#otherqq").val($("#qq").val());
            $("#otheraddress").val($("#address").val());
            $("#othergender").val($("#gender").val());
            $(".trOther").hide();
        } else {
            $(".otheruser").val("");
            $("#othergender").val(0);
            $(".trOther").show();
        }
    });

});
