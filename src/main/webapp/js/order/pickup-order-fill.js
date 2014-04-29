$(function() {
    $("#sltCountry").bind("change", loadCitiesByCountry);
    $("#sltCity").bind("change", loadFlightsByCity);

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

function loadCitiesByCountry() {
    $.ajax({
        type : "POST",
        url : ctx + "/navigation/getCity.html",
        data : {
            countryId : this.value
        },
        success : function(data) {
            renderOption("sltCity", data);
        }
    });

}

function loadFlightsByCity() {
    $.ajax({
        type : "POST",
        url : ctx + "/navigation/getFlight.html",
        data : {
            cityId : this.value
        },
        success : function(data) {
            renderOption("sltFlight", data, true);
        }
    });
}

function renderOption(selectId, data, isFlight) {
    var select = $("#" + selectId).empty();
    var jsonObject = $.parseJSON(data);
    if (jsonObject != null) {
        $.each(jsonObject, function(i, e) {
            if (isFlight) {
                select.append("<option value='" + e.flightNum + "'>" + e.name + "</option>");
            } else {
                select.append("<option value='" + e.id + "'>" + e.name + "</option>");
            }
        })
        if (select.find("option").length <= 0) {
            select.append("<option value='0'>no valid result</option>");
        }
    }

}
