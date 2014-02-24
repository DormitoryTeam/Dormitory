$(function() {
    $('#fileupload').fileupload({
        dataType : 'json',

        done : function(e, data) {
            //$("tr:has(td)", $("#uploaded-files")).remove();
            $.each(data.result, function(i, f) {
                var imageURL = "/dormitory/admin/dormitory/dormitory-image-preview.html?dormitoryId=" + $("#hidDormitoryId").val() + "&fileName=" + f.name;
                var row = $('<tr>');
                row.append($('<td>').text(f.name));
                row.append($('<td>').text(f.size));
                row.append($('<td>').text(f.type));
                row.append($('<td>').html("<a href='" + imageURL + "'><img src='" + imageURL + "' /></a>"));
                $("#uploaded-files").append(row)
            });
        },

        progressall : function(e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css('width', progress + '%');
        },

        dropZone : $('#dropzone')
    });
});
