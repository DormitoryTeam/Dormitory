$(function() {
    $(".anchorCountry").bind("click", loadCityListByCountry);
});

function loadCityListByCountry() {
    $.ajax({
        type : "POST",
        url : ctx + "/navigation/getCity.html",
        data : {
            countryId : $(this).attr("countryId")
        },
        success : function(data) {
            var tbody = $("#tableCity > tbody").empty();
            var result = $.parseJSON(data);
            if (result != null) {
                $.each(result, function(i, e) {
                    if (i == 0) {
                        tbody.append("<tr>");
                    }
                    if (i % 5 == 0) {
                        tbody.append("</tr><tr>");
                    }
                    tbody.append("<td><a href=\"javascript:void(0);\" class=\"anchorCity\" cityId=\"" + e.id + "\">" + e.name + "</a></td>");
                })
                if (tbody.find("td").length <= 0) {
                    tbody.append("<tr><td>no valid result.</td></tr>");
                } else {
                    tbody.append("</tr>");
                }
            }
            $(".anchorCity").bind("click", loadCollegeListByCountry);
        }
    });
}

function loadCollegeListByCountry() {
    $.ajax({
        type : "POST",
        url : ctx + "/navigation/getCollege.html",
        data : {
            cityId : $(this).attr("cityId")
        },
        success : function(data) {
            var tbody = $("#tableCollege > tbody").empty();
            var result = $.parseJSON(data);
            if (result != null) {
                $.each(result, function(i, e) {
                    if (i == 0) {
                        tbody.append("<tr>");
                    }
                    if (i % 5 == 0) {
                        tbody.append("</tr><tr>");
                    }
                    tbody.append("<td><a href=\"" + ctx + "/dormitory/dormitory-list.html?cityId=" + e.cityId + "&collegeId=" + e.id + "\" class=\"anchorCollege\" collegeId=\"" + e.id + "\">" + e.name + "</a></td>");
                })
                if (tbody.find("td").length <= 0) {
                    tbody.append("<tr><td>no valid result.</td></tr>");
                } else {
                    tbody.append("</tr>");
                }
            }
        }
    });
}

