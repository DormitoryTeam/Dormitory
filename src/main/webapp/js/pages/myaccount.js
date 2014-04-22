require(['config'], function(config) {
require(['jquery', 'utils', 'raty', 'jQueryUI', 'jqueryTools'], function($, utils, raty, jQueryUI, jqueryTools) {
$(function() {
	//init header
	utils.init();


	//$( ".myaccount-tab" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );

  //$( ".personal-info-tab" ).tabs();
	// bind datepicker
    $(".datepicker").datepicker({ dateFormat: "yy-mm-dd" });
    $(".datepicker").attr("readonly",true);
});
});
});