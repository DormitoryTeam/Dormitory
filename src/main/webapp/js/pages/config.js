require.config({
	baseUrl: baseUrl,
	waitSeconds: 60,
	paths: {
		/* Vendor */
		jquery: baseUrl + '/js/vendor/jquery-1.10.2.min',
		modal: baseUrl + '/js/vendor/jquery.modal',
		Handlebars: baseUrl + '/js/vendor/handlebars',
		
		/* Modules */

		/* Libs */
		fCheck: baseUrl + '/js/lib/jquery.fCheck',
		formValidate: baseUrl + '/js/lib/jquery.formValidate',
		placeholder: baseUrl + '/js/lib/jquery.placeholder',
		simSelect: baseUrl + '/js/lib/jquery.simSelect',
		acsScrollBar: baseUrl + '/js/lib/acsScrollBar',
		jqzoom: baseUrl + '/js/lib/jquery.jqzoom-core',
		popover: baseUrl + '/js/lib/jquery.popover',
		utils: baseUrl + '/js/lib/utils',
		raty: baseUrl + '/js/jquery-raty/jquery.raty.min',
		jQueryUI: baseUrl + '/js/lib/jquery-ui',
		jqueryTools: baseUrl + '/js/lib/jquery.tools.min',

		common: baseUrl + '/js/lib/common',
		drawGadget: baseUrl + '/js/lib/drawGadget',
		gadgets: baseUrl + '/js/lib/gadgets',
		sliderMethod: baseUrl + '/js/lib/sliderMethod',
		acsCarousel: baseUrl + '/js/lib/acsCarousel',
		acsSlider: baseUrl + '/js/lib/acsSlider'
	},
	shim: {
		Handlebars: {
			exports: 'Handlebars'
		},
		common: {
            exports: 'acsCommon'
        },
        drawGadget: {
        	exports: 'drawGadget'
        },
        gadgets: {
        	exports: 'gadgets'
        },
        sliderMethod: {
        	exports: 'sliderMethod'
        },
        acsCarousel: {
        	deps: ['jquery', 'common', 'drawGadget', 'gadgets', 'sliderMethod'],
            exports: 'jQuery.fn.acsCarousel'
        },
        acsSlider: {
        	deps: ['jquery', 'common', 'drawGadget', 'gadgets', 'sliderMethod'],
            exports: 'jQuery.fn.acsSlider'
        },
        jqzoom: {
        	deps: ['jquery'],
        	exports: 'jQuery.fn.jqzoom'
        }
	}
});