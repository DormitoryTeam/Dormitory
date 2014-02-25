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
});

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
        var imageURL = "/dormitory/admin/dormitory/dormitory-image-preview.html?dormitoryId=" + $("#hidDormitoryId").val() + "&fileName=" + e.name;
        var row = $('<tr>');
        row.append($('<td>').html("<input type=\"text\" name=\"imageNames\" class=\"fileNames\" value=\"" + e.name + "\" />"));
        row.append($('<td>').html("<a href='" + imageURL + "'><img src='" + imageURL + "' /></a>"));
        row.append($('<td>').html("<input type=\"button\" value=\"Remove\" class=\"btnRemove\" fileName=\"" + e.name + "\" />"));
        $("#uploaded-files").append(row)
    });
}
