$(function() {

	bindRemovePrice();
	$("#btnAddPrice").unbind('click').bind('click', function(e) {
		var newRoomPriceDomStr = buildPriceRow();
		$("#tableRoom").append(newRoomPriceDomStr);
		bindRemovePrice();
	});
});

function buildPriceRow() {
	var index = -1;
	$.each($(".rowPrice"), function(i, e){
		var curIndex = $(e).attr("index");
		if(index < curIndex) {
			index = curIndex;
		}
	});
	index = parseInt(index) + 1;
	
	var rowPrice = '';
	rowPrice += '<tr class="rowPrice" index="' + index + '">';
	rowPrice += '<td><select name="contractPrice[' + index + '].contractId">';
	rowPrice += contractOptionDomStr;
	rowPrice += '</select>';
	rowPrice += '<input type="hidden" name="contractPrice[' + index + '].id" value="-1" />';
	rowPrice += '<input type="hidden" name="contractPrice[' + index + '].roomInfoId" value="' + $("#roomId").val() + '" /> ';
	rowPrice += '</td>';
	rowPrice += '<td><input type="checkbox" name="contractPrice[' + index + '].status" value="1" /></td>';
	rowPrice += '<td><input class="price" type="text" name="contractPrice[' + index + '].currency" value="" /></td>';
	rowPrice += '<td><input class="price" type="text" name="contractPrice[' + index + '].weekPrice" value="0" /></td>';
	rowPrice += '<td><input class="price" type="text" name="contractPrice[' + index + '].salePrice" value="0" /></td>';
	rowPrice += '<td><input type="button" class="btnRemovePrice" value="删除" />';
	rowPrice += '<input type="hidden" class="hidShouldDelete" value="false" name="contractPrice[' + index + '].shouldDelete" /></td>';
	
	return rowPrice;
}

function bindRemovePrice() {
	$(".btnRemovePrice").unbind('click').bind('click', function(e) {
		var hiddenShouldDelete = $(e.target).parent().find(".hidShouldDelete");
		if(hiddenShouldDelete.val() == 'false') {
			hiddenShouldDelete.val(true);
			$(e.target).val("恢复");
			$(e.target).parents("tr").addClass("error");
		} else {
			hiddenShouldDelete.val(false);
			$(e.target).val("删除");
			$(e.target).parents("tr").removeClass("error");
		}
	});
}