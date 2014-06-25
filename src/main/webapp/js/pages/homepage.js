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

			$('.jQ-regbtn').on('click', function() {
				$(this).acsPopup({
					popupSrc : $(this).attr("data-popupSrc"),
					callBack : function() {
						$("#btnRegisterSubmit").unbind('click').bind('click', function(e) {
							e.preventDefault();
							if (validateEmail($("#iptLogin").val())) {
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
											window.location.href = ctx + "/navigation/home.html?login=" + data.login
										} else {
											$(".errorMessage").html(data.message);
										}
									},
									error : function(e) {
										alert(e);
									}
								});
							} else {
								$(".errorMessage").html("请输入合法的邮箱地址。");
							}
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
								url : ctx + "/user/asynLogin.html",
								data : {
									login : $("#iptLogin").val(),
									password : $("#iptPassword").val()
								},
								success : function(data) {
									if (data.result) {
										
										if (window.location.href.lastIndexOf('#') > 0) {
											window.location.href = window.location.href.substr(0, window.location.href.lastIndexOf('#')) + "&login=" + data.login
										} else {
											window.location.href = window.location.href + "&login=" + data.login;
										}
										
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
		url : ctx + "/navigation/getCity.html",
		data : {
			countryId : this.value
		},
		success : function(data) {
			renderOption("sltCity", data);
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

function validateEmail(email) {
	var patten = new RegExp(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
	return patten.test(email);
}