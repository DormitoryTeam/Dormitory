require(['config'], function(config) {
require(['jquery', 'utils', 'acsSlider'], function($, utils, acsSlider) {
$(function() {
	//init header
	utils.init();
	
	$('.sliderShow').acsSlider({
		startwidth: 700,
   		startheight: 350,
   		sliderPagerMethod: 'num'
	});

});
});
});
