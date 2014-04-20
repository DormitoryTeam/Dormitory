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

            $('.jQ-regbtn').on('click', function() {
                $(".errorMessage").html("&nbsp;");
                $(this).acsPopup({
                    popupSrc : $(this).attr("data-popupSrc"),
                    callBack : function() {
                        $("#btnRegisterSubmit").unbind('click').bind('click', function(e) {
                            e.preventDefault();
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
            })

            $('.jQ-loginbtn').on('click', function() {
                $(".errorMessage").html("&nbsp;");
                $(this).acsPopup({
                    popupSrc : $(this).attr("data-popupSrc"),
                    callBack : function(setting) {
                        $("#btnLoginSubmit").unbind('click').bind('click', function(e) {
                            e.preventDefault();
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
            })
        });
    });
});
