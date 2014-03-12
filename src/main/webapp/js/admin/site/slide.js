$.fn.swap = function(other) {
    $(this).replaceWith($(other).after($(this).clone(true)));
};

$(function() {
    $('#fileupload').fileupload({
        dataType : 'json',

        done : function(e, data) {
            appendLastestImagePreview(data);
            bindRemovButton();
            bindMoveUpButton();
            bindMoveDownButton();
        },

        progressall : function(e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css('width', progress + '%');
        },

        dropZone : $('#dropzone')
    });

    bindRemovButton();
    bindMoveUpButton();
    bindMoveDownButton();
});

function bindRemovButton() {
    $(".btnRemove").unbind().bind('click', removeRow);
}

function bindMoveUpButton() {
    $(".btnUp").unbind().bind('click', moveRowUp);
}

function bindMoveDownButton() {
    $(".btnDown").unbind().bind('click', moveRowDown);
}

function appendLastestImagePreview(data) {
    $.each(data.result, function(i, e) {
        var imageURL = "/dormitory/admin/slide-image-preview.html?fileName=" + e.name;
        var row = $("<tr class=\"fileRow\">");
        row.append($('<td>').html("<input type=\"text\" name=\"imageNames\" class=\"fileNames\" value=\"" + e.name + "\" /><input type=\"hidden\" name=\"imageIndexes\" class=\"fileIndex\" value=\"" + getNextIndex() + "\" />"));
        row.append($('<td>').html("<a href='" + imageURL + "'><img src='" + imageURL + "' /></a>"));
        row.append($('<td>').html("<input type=\"button\" value=\"Up ↑\" class=\"btnUp\" />"));
        row.append($('<td>').html("<input type=\"button\" value=\"Down ↓\" class=\"btnDown\" />"));
        row.append($('<td>').html("<input type=\"button\" value=\"Remove\" class=\"btnRemove\" />"));
        row.append($('<td>').html("<select name=\"imageShow\"><option value=\"1\">Show</option><option value=\"0\">Hide</option></select>"));
        $("#uploaded-files").append(row)
    });
}

function getFileNameInput(btn) {
    return $(btn).parents("tr:first").find("td:first>input.fileNames");
}

function getFileIndexInput(btn) {
    return $(btn).parents("tr:first").find("td:first>input.fileIndexes");
}

function moveRowUp() {
    switchRow(this, -1);
}

function moveRowDown() {
    switchRow(this, 1);
}

function removeRow() {
    var parentRowElement = $(this).parents("tr:first");

    $(parentRowElement, "#uploaded-files").remove();

    var fileName = getFileNameInput(this).val();
    $.each($(".fileNames"), function(i, e) {
        if ($(e).val() === fileName) {
            $(e, "#formDormitory").remove();
            return false;
        }
    });
}

function switchRow(btn, relatedIndex) {
    var tableRows = $("#uploaded-files tr.fileRow");
    var curRow = $(btn).parents("tr:first");
    var curIndex = tableRows.index(curRow);
    var destIndex = curIndex;
    if (relatedIndex === -1) {
        if (curIndex === 0) {
            return;
        }
        destIndex += relatedIndex;
    } else if (relatedIndex === 1) {
        if (curIndex === tableRows.length - 1) {
            return;
        }
        destIndex += relatedIndex;
    }
    curRow.swap(tableRows[destIndex]);

    resetIndexes();
}

function resetIndexes() {
    $.each($("#uploaded-files tr.fileRow"), function(i, e) {
        $(e).find("td:first>input.fileIndex").val(i);
    });
}

function getNextIndex() {
    var nextIndex = 0;
    $.each($("td:first>input.fileIndexes"), function(i, e) {
        var curIndex = parseInt(e.val());
        // TODO Index = -1 always
        if (curIndex > nextIndex) {
            nextIndex = curIndex;
        }
    });
    return nextIndex + 1;
}
