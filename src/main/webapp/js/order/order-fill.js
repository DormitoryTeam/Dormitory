$(function() {
	$("#otherUserEmail").bind('click', function() {
	});
	
	$("#btnSearchOtherUserByEmail").bind('click', funtion() {
	    $.ajax({
	        type : "POST",
	        url : "/dormitory/user/queryUserByEmail.html",
	        data : {
	            countryId : $(otherUserEmail).val()
	        },
	        success : function(data) {
	        }
	    });
		
	});

});