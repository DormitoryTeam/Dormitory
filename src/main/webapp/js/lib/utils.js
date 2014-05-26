define(['jquery', 'fCheck', 'placeholder', 'simSelect'], function($, fCheck, placeholder, simSelect) {
	return {
		init: function() {
			$('input[type!="checkbox"]').fCheck();
			$('[placeholder]').placeholder();
			$('select[class!="noSimSelect"]').simSelect();
		}
	}
});