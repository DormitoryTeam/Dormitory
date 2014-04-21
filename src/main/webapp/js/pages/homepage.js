require(['config'], function(config) {
    require(['jquery', 'utils', 'acsSlider', 'acsPopup'], function($, utils, acsSlider, acsPopup) {
        $(function() {
            //init header
            utils.init();

            $('.sliderShow').acsSlider({
                startwidth : 700,
                startheight : 350,
                sliderPagerMethod : 'num'
            });

            $("#sltCountry").bind("change", loadCitiesByCountry);
            $("#sltCity").bind("change", loadCollegesByCity);

            $('.jQ-regbtn').on('click', function() {
                $(this).acsPopup({
                    popupSrc : $(this).attr("data-popupSrc"),
                    callBack : function() {
                        $("#btnRegisterSubmit").unbind('click').bind('click', function(e) {
                            e.preventDefault();
                            $(".errorMessage").html("&nbsp;");
                            $.ajax({
                                type : "POST",
                                dataType : "json",
                                url : "/dormitory/user/asynRegister.html",
                                data : {
                                    login : $("#iptLogin").val(),
                                    password : $("#iptPassword").val()
                                },
                                success : function(data) {
                                    if (data.result) {
                                        window.location.href = "/dormitory/navigation/home.html?login=" + data.login
                                    } else {
                                        $(".errorMessage").html(data.message);
                                    }
                                },
                                error : function(e) {
                                    alert(e);
                                }
                            })
                        });
                    }
                });
            });

            $('.jQ-loginbtn').on('click', function() {
                $(this).acsPopup({
                    popupSrc : $(this).attr("data-popupSrc"),
                    callBack : function() {
                        $("#btnLoginSubmit").unbind('click').bind('click', function(e) {
                            e.preventDefault();
                            $(".errorMessage").html("&nbsp;");
                            $.ajax({
                                type : "POST",
                                dataType : "json",
                                url : "/dormitory/user/asynLogin.html",
                                data : {
                                    login : $("#iptLogin").val(),
                                    password : $("#iptPassword").val()
                                },
                                success : function(data) {
                                    if (data.result) {
                                        window.location.href = "/dormitory/navigation/home.html?login=" + data.login
                                    } else {
                                        $(".errorMessage").html(data.message);
                                    }
                                },
                                error : function(e) {
                                    alert(e);
                                }
                            })
                        });
                    }
                });
            });

        });
    });
});

function loadCitiesByCountry() {
    $.ajax({
        type : "POST",
        url : "/dormitory/navigation/getCity.html",
        data : {
            countryId : this.value
        },
        success : function(data) {
            renderOption("sltCity", data);
        }
    });

}

function loadCollegesByCity() {
    $.ajax({
        type : "POST",
        url : "/dormitory/navigation/getCollege.html",
        data : {
            cityId : this.value
        },
        success : function(data) {
            renderOption("sltCollege", data);
        }
    });
}

function renderOption(selectId, data) {
    var select = $("#" + selectId).empty();
    var jsonObject = $.parseJSON(data);
    if (jsonObject != null) {
        $.each(jsonObject, function(i, e) {
            select.append("<option value='" + e.id + "'>" + e.name + "</option>");
        })
        if (select.find("option").length <= 0) {
            select.append("<option value='0'>no valid result</option>");
        }
    }
}