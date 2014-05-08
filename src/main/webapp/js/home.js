$(function() {
    $("#sltCountry").bind("change", loadCitiesByCountry);
    $("#sltCity").bind("change", loadCollegesByCity);
    $("#dormitory-tab").click(function() {
    	$("#dormitory-form").show();
    	$("#pickup-form").hide();
    });
    
    $("#pickup-tab").click(function() {
    	$("#dormitory-form").hide();
    	$("#pickup-form").show();
    });
    
    $("#sltPickupCountry").bind("change", function() {
    	$.ajax({
        type : "POST",
        url : ctx + "/navigation/getAirport.html",
        data : {
            countryId : $(this).val()
        },
        success : function(data) {
            renderOption("sltAirport", data);
            $('select').simSelect();
        }
    });
    });
    
    $("#pickupForm").submit(function() {
    	var hasPickupOrder = $("#pickupBtn").attr("hasPickupOrder");
    	if('true' == hasPickupOrder) {
    		alert("你只能拥有一个订单，请到个人中心查看。");
    		return false;
    	}
    	return true;
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
            $('select').simSelect();
        }
    });

}

function loadCollegesByCity() {
    $.ajax({
        type : "POST",
        url : ctx + "/navigation/getCollege.html",
        data : {
            cityId : this.value
        },
        success : function(data) {
            renderOption("sltCollege", data);
            $('select').simSelect();
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
