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
							$("#btnRegisterSubmit").unbind('click').bind('click', asynRegister);
						}
					});
				});
			}

			if (hiddenInputPageType == "login") {
				$('#popupLink').on('click', function() {
					$("#popupLink").acsPopup({
						popupSrc : $("#popupLink").attr("data-popupSrc"),
						callBack : function() {
							$("#btnLoginSubmit").unbind('click').bind('click', asynLogin);
						}
					});
				});
			}

			if (hiddenInputPageType == "forget") {
				$('#popupLink').on('click', function() {
					$("#popupLink").acsPopup({
						popupSrc : $("#popupLink").attr("data-popupSrc"),
						callBack : function() {
							$("#btnForgetPasswordSubmit").unbind('click').bind('click', asynForgetPassword);

							$('.jQ-email').on('click', function() {
								$(this).acsPopup({
									popupSrc : $(this).attr("data-popupSrc") + "?login=" + $("#iptLogin").val()
								})
							});
						}
					});
				});
			}

			if (hiddenInputPageType == "change") {
				$('#popupLink').on('click', function() {
					$("#popupLink").acsPopup({
						popupSrc : $("#popupLink").attr("data-popupSrc"),
						callBack : function() {
							$("#btnChangePasswordSubmit").unbind('click').bind('click', asynChangePassword);
						}
					});
				});
			}

			$('#popupLink').click();
		});
	});
});

function asynRegister(e) {
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
				window.location.href = ctx + "/navigation/home.html?login=" + data.login
			} else {
				$(".errorMessage").html(data.message);
			}
		},
		error : function(e) {
			alert(e);
		}
	});
}

function asynLogin(e) {
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
				window.location.href = ctx + "/navigation/home.html?login=" + data.login
			} else {
				$(".errorMessage").html(data.message);
			}
		},
		error : function(e) {
			alert(e);
		}
	});
}

function asynForgetPassword(e) {
	e.preventDefault();
	$(".errorMessage").html("&nbsp;");
	$.ajax({
		type : "POST",
		dataType : "json",
		url : ctx + "/user/asynForgetPassword.html",
		data : {
			login : $("#iptLogin").val(),
		},
		success : function(data) {
			if (data.result) {
				$("#forgetPasswordTip").click();
			} else {
				$(".errorMessage").html(data.message);
			}
		},
		error : function(e) {
			alert(e);
		}
	});
}

function asynChangePassword(e) {
	e.preventDefault();
	$(".errorMessage").html("&nbsp;");
	if ($("#newPassword").val() != $("#newPassword2").val()) {
		$(".errorMessage").html("两次新输入密码不相同。");
		return;
	} else {
		$.ajax({
			type : "POST",
			dataType : "json",
			url : ctx + "/user/asynChangePassword.html",
			data : {
				oldPassword : $("#oldPassword").val(),
				newPassword : $("#newPassword").val()
			},
			success : function(data) {
				if (data.result) {
					$("#btnChangePasswordSubmit").attr("disabled", "disabled");
					timeCount();
				} else {
					$(".errorMessage").html(data.message);
				}
			},
			error : function(e) {
				alert(e);
			}
		});
	}
}

function timeCount() {
	var s = $("#second").val();
	if (s > 1) {
		s = s - 1;
		$("#second").val(s);
		$(".errorMessage").html("修改成功，" + s + " 秒后返回首页。");
		setTimeout("timeCount()", 1000);
	} else {
		window.location.href = ctx + "/navigation/home.html";
	}
}