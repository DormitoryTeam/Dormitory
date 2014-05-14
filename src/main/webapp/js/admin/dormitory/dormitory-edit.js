$(function() {
    $('#fileupload').fileupload({
        dataType : 'json',

        done : function(e, data) {
            appendLastestImagePreview(data);
            bindRemoveUploadImageButton();
        },

        progressall : function(e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css('width', progress + '%');
        },

        dropZone : $('#dropzone')
    });

    bindRemoveUploadImageButton();
    $("#sltCountry").bind("change", loadCitiesByCountry);
    $("#sltCity").bind("change", loadCollegesByCity);
    
    $(".folding").bind("click", foldingDormitoryDetails);
});

function loadCitiesByCountry() {
    $.ajax({
        type : "POST",
        url : "/navigation/getCity.html",
        data : {
            countryId : this.value
        },
        success : function(data) {
            renderOption("sltCity", data, 'name');
        }
    });

}

function loadCollegesByCity() {
    $.ajax({
        type : "POST",
        url : "/navigation/getCollege.html",
        data : {
            cityId : this.value
        },
        success : function(data) {
            renderOption("sltCollege", data, 'originalName');
        }
    });
}

function renderOption(selectId, data, textName) {
    var select = $("#" + selectId).empty();
    var jsonObject = $.parseJSON(data);
    if (jsonObject != null) {
        $.each(jsonObject, function(i, e) {
            select.append("<option value='" + e.id + "'>" + e[textName] + "</option>");
        })
        if (select.find("option").length <= 0) {
            select.append("<option value='0'>no valid result</option>");
        }
    }
}


function bindRemoveUploadImageButton() {
    $(".btnRemove").unbind().bind('click', removeFileFromSubmitForm);
}

function removeFileFromSubmitForm() {
    var parentRowElement = $(this).parent().parent();
    $(parentRowElement, "#uploaded-files").remove();

    var fileName = $(this).attr("fileName");
    $.each($(".fileNames"), function(i, e) {
        if ($(e).val() === fileName) {
            $(e, "#formDormitory").remove();
            return false;
        }
    });
}

function appendLastestImagePreview(data) {
    $.each(data.result, function(i, e) {
        var imageURL = "/upload/images/dormitory/" + $("#hidDormitoryId").val() + "/" + e.name;
        var row = $('<tr>');
        row.append($('<td>').html("<input type=\"text\" name=\"imageNames\" class=\"fileNames\" value=\"" + e.name + "\" />"));
        row.append($('<td>').html("<a href='" + imageURL + "'><img src='" + imageURL + "' /></a>"));
        row.append($('<td>').html("<input type=\"button\" value=\"删除\" class=\"btnRemove\" fileName=\"" + e.name + "\" />"));
        $("#uploaded-files").append(row)
    });
}

function foldingDormitoryDetails(e) {
	var target = $(e.target);
	var rows = target.closest("tbody").find("tr.need_folding");
	var parentRow = target.parent();
	if(parentRow.attr("status") == "expand") {
		parentRow.attr("status", "collapse");
		rows.hide();
	} else if(parentRow.attr("status") == "collapse") {
		parentRow.attr("status", "expand");
		rows.show();
	}
}
