define(['jquery', 'fCheck', 'placeholder', 'simSelect'], function($, fCheck, placeholder, simSelect) {
	return {
		init: function() {
			$('input').fCheck();
			$('[placeholder]').placeholder();
			$('select').simSelect();
		}
	}
});