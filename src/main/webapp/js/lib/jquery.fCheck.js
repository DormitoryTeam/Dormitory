/**
 * This is a jquery plug for custom Checkbox and radio, and it is compatible for AMD
 * Usage:
 * if you want to just make all the radio and checkbox to ferguson style, 
 * simple use: $('input').fCheck();
 * 
 * The public method:
 * 1. $('selector').fCheck('check');
 * make specific elements to be checked
 * 
 * 2. $('selector').fCheck('uncheck');
 * make specific elements to be unchecked
 *
 * 3. $('selector').fCheck('disable');
 * make specific elements to be disabled
 *
 * 4. $('selector').fCheck('enable');
 * make specific elements to be enable
 *
 * 5. $('selector').fCheck('update');
 * apply input changes, which were done outside the plugin
 *
 * notes:In the pages, don't use any css style to radio and checkbox.
 * if you have to use some styles on them, you can assign to their parents.
 * 
 * @author LanceLi
 */

;(function(factory) {
	if (typeof define === 'function' && define.amd) {
		//AMD support
		define(['jquery'], factory);
	} else {
		//Browser global
		factory(jQuery);
	}

})(function($) {

	var CustomCheckRadio = function(el, options) {
		this.options = options;
		this.$el = $(el);
		init(this);
	};

	CustomCheckRadio.DEFAULTS = {
		checkboxClass: 'fcheckbox',
		radioClass: 'fradio',
		checkedClass: 'fchecked',
		disabledClass: 'fdisabled',
		wrapperDom: '<label></label>'
	};

	CustomCheckRadio.prototype.check = function() {
		var options = this.options,
			$el = this.$el,
			$parent = $el.parent();

		if ($el.is(':radio')) {
			$($el[0].form).find('input[name='+ $el.attr('name') +']')
				.parent().removeClass(options.checkedClass);
		}
		$el.prop('checked', true);
		$parent.addClass(options.checkedClass);

	};

	CustomCheckRadio.prototype.uncheck = function() {
		var options = this.options,
			$el = this.$el,
			$parent = $el.parent();

		$el.prop('checked', false);
		$parent.removeClass(options.checkedClass);

	};

	CustomCheckRadio.prototype.disable = function() {
		var options = this.options,
			$el = this.$el,
			$parent = $el.parent();

		$el.prop('disabled', true);
		$parent.addClass(options.disabledClass);

	};

	CustomCheckRadio.prototype.enable = function() {
		var options = this.options,
			$el = this.$el,
			$parent = $el.parent();

		$el.prop('disabled', false);
		$parent.removeClass(options.disabledClass);

	};

	CustomCheckRadio.prototype.update = function() {
		var options = this.options,
			$el = this.$el,
			$parent = $el.parent();

		if ($el.is(':checked')) {
			$parent.addClass(options.checkedClass);
		} else {
			$parent.removeClass(options.checkedClass);
		}

		if ($el.is(':disabled')) {
			$parent.addClass(options.disabledClass);
		} else {
			$parent.removeClass(options.disabledClass);
		}

	};

	function init(_this) {
		var options = _this.options,
			$el = _this.$el;

		$el.wrap(function() {
			var $wd = $(options.wrapperDom),
				$this = $(this);

			if ($this.is(':checkbox')) {
				$wd.addClass(options.checkboxClass);
			} else if ($this.is(':radio')) {
				$wd.addClass(options.radioClass);
			}

			if ($this.is(':checked')) {
				$wd.addClass(options.checkedClass);
			}
			if ($this.is(':disabled')) {
				$wd.addClass(options.disabledClass);
			}

			return $wd;
		}).css({
			'width': '100%',
			'height': '100%',
			'margin-left': '-10000px'
		}).on('change', function() {
			var $this = $(this),
				$parent = $this.parent();

			if ($this.is(':radio')) {
				//when radio location in a form
				if (this.form) {
					$(this.form)
						.find('input[name='+ $this.attr('name') +']')
						.parent()
						.removeClass(options.checkedClass);
				} else {
					$('input[name='+ $this.attr('name') +']').each(function() {
						if (!this.form) {
							$(this).parent().removeClass(options.checkedClass);
						}
					});
				}
				
			}

			if ($this.is(':checked')) {
				$parent.addClass(options.checkedClass);
			} else {
				$parent.removeClass(options.checkedClass);
			}

			if ($this.is(':disabled')) {
				$parent.addClass(options.disabledClass);
			} else {
				$parent.removeClass(options.disabledClass);
			}

		});
	}

	$.fn.fCheck = function (option) {
        var options = $.extend({}, CustomCheckRadio.DEFAULTS, typeof option === 'object' && option),
        	filter = 'input[type="radio"], input[type="checkbox"]';
    
        return this.filter(filter).each(function () {
		    var $this = $(this);
		    var data  = $this.data('fCheck');
 
		    if (!data) $this.data('fCheck', new CustomCheckRadio(this, options));
		    if (typeof option === 'string') data[option]();

        });
    }

});
