require.config({
	baseUrl: baseUrl,
	waitSeconds: 60,
	paths: {
		/* Vendor */
		jquery: 'vendor/jquery-1.10.2.min',
		modal: 'vendor/jquery.modal',
		Handlebars: 'vendor/handlebars',
		
		/* Modules */

		/* Libs */
		fCheck: 'lib/jquery.fCheck',
		formValidate: 'lib/jquery.formValidate',
		placeholder: 'lib/jquery.placeholder',
		simSelect: 'lib/jquery.simSelect',
		acsScrollBar: 'lib/acsScrollBar',
		jqzoom: 'lib/jquery.jqzoom-core',
		popover: 'lib/jquery.popover',
		utils: 'lib/utils',
		raty: 'lib/jquery.raty.min',
		jQueryUI: 'lib/jquery-ui',
		jqueryTools: 'lib/jquery.tools.min',

		common: 'lib/common',
		drawGadget: 'lib/drawGadget',
		gadgets: 'lib/gadgets',
		sliderMethod: 'lib/sliderMethod',
		acsCarousel: 'lib/acsCarousel',
		acsSlider: 'lib/acsSlider',
		acsPopup: 'lib/acsPopup',
		timepicker: 'lib/timepicker'
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
        acsPopup: {
        	deps: ['jquery', 'common', 'drawGadget', 'gadgets'],
            exports: 'jQuery.fn.acsPopup'
        },
        jqzoom: {
        	deps: ['jquery'],
        	exports: 'jQuery.fn.jqzoom'
        }
	}
});