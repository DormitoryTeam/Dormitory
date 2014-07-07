bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
$(function(){

$("#btnSubmit").bind('click', function(){
        $("#iptTextBody").val($(".nicEdit-main").html());
        $("#form").submit();
    });
});