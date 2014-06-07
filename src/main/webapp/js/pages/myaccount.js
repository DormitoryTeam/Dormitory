require(['config'], function(config) {
require(['jquery', 'utils', 'raty', 'jQueryUI', 'jqueryTools'], function($, utils, raty, jQueryUI, jqueryTools) {
$(function() {
	//init header
	utils.init();


	//$( ".myaccount-tab" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );

  //$( ".personal-info-tab" ).tabs();
	// bind datepicker
    $(".datepicker").datepicker({
        dateFormat: "yy-mm-dd",
        changeMonth: true,
        changeYear: true
    });
    $(".datepicker").attr("readonly",true);
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
								url : ctx + "/user/asynLogin.html",
								data : {
									login : $("#iptLogin").val(),
									password : $("#iptPassword").val()
								},
								success : function(data) {
									if (data.result) {
										window.location.href = window.location.href + "&login=" + data.login
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
});