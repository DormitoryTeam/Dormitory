require(['config'], function(config) {
    require(['jquery', 'utils', 'acsSlider', 'acsPopup'], function($, utils, acsSlider, acsPopup) {
        $(function() {
            // init header
            utils.init();

            var hiddenInputPageType = $("#hidPageType").val();

            if (hiddenInputPageType == "register") {
                $('#popupLink').on('click', function() {
                    $("#popupLink").acsPopup({
                        popupSrc : $("#popupLink").attr("data-popupSrc"),
                        callBack : function() {
                            $("#btnRegisterSubmit").unbind('click').bind('click', function(e) {
                                e.preventDefault();
                                $(".errorMessage").html("&nbsp;");
                                $.ajax({
                                    type : "POST",
                                    dataType : "json",
                                    url : ctx + "/user/asynRegister.html",
                                    data : {
                                        login : $("#iptLogin").val(),
                                        password : $("#iptPassword").val()
                                    },
                                    success : function(data) {
                                        if (data.result) {
                                            window.location.href = ctx +"/navigation/home.html?login=" + data.login
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
            } else if (hiddenInputPageType == "login") {
                $('#popupLink').on('click', function() {
                    $("#popupLink").acsPopup({
                        popupSrc : $("#popupLink").attr("data-popupSrc"),
                        callBack : function() {
                            $("#btnLoginSubmit").unbind('click').bind('click', function(e) {
                                e.preventDefault();
                                $(".errorMessage").html("&nbsp;");
                                $.ajax({
                                    type : "POST",
                                    dataType : "json",
                                    url : ctx +"/user/asynLogin.html",
                                    data : {
                                        login : $("#iptLogin").val(),
                                        password : $("#iptPassword").val()
                                    },
                                    success : function(data) {
                                        if (data.result) {
                                            window.location.href = ctx + "/navigation/home.html?login=" + data.login
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
            }
            
            $('#popupLink').click();
        });
    });
});
