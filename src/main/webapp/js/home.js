$(function() {
    initSlides();
    $("#sltCountry").bind("change", loadCitiesByCountry);
    $("#sltCity").bind("change", loadCollegesByCity);
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

function initSlides() {
    $('#slides').slidesjs({
        width : 450,
        height : 450,
        play : {
            active : true,
            auto : true,
            interval : 4000,
            swap : true
        }
    });
}