$(function() {
    $("#sltCountry").bind("change", loadCitiesByCountry);
    $("#sltCity").bind("change", loadCollegesByCity);
});

function loadCitiesByCountry() {
    $.ajax({
        type : "POST",
        url : "/dormitory/navigation/getCity",
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
        url : "/dormitory/navigation/getCollege",
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
    if (data != null) {
        $.each(jQuery.parseJSON(data), function(i, e) {
            select.append("<option value='" + e.id + "'>" + e.name + "</option>");
        })
        if (select.find("option").length <= 0) {
            select.append("<option value='0'>no valid result</option>");
        }
    }

}
