/**
 * This is a jquery plug for validate form, and it is compatible for AMD
 * use age:
 * 1.common fields validation
 * $('formSelector').formValidate({
 *     fields: {
 *         'inputSelector': {
 *             enterableType: 'email',
 *             remote: {
 *                 url: '/ferguson/backend.json',
 *                 data: function() {
 *                     return {key: value};
 *                 },
 *                 completeCallback: function(json) {
 *                 
 *                 }
 *             }
 *         },
 *         'selectSelector': {
 *             require: true,
 *             requireCallback: function(result) {
 *                 console.log(result);
 *             }
 *         }
 *     }
 * });
 *
 * 2. Ferg fields validation
 * $('formSelector').formValidate({
 *     fergFormValidate : true,
 *     remote: {
 *         remoteURL: '/ferguson/backend.json',
 *         data: function(opts) {
 *             return {key, value};
 *         },
 *         completeCallback: function(obj, opts) {
 *         
 *         }
 *     }
 * });
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

	var FormValidate = function(form, options) {
		this.$form = $(form);
		this.options = options;
		this.handleEnterableFields();

		if (options.fergFormValidate) {
			this.handleFergFields();
		} else {
			this.handleFields();
		}
	};

	FormValidate.DEFAULTS = {
		error: $.noop,
		success: $.noop,
		inlineErrorDom: '<span class="inline-error pull-left"></span>',
		dataAttrName : 'data-check-name',
		inputErrorClass : 'error',
		inlineErrorClass : '.inline-error',
		enabEmailReg: /[^a-zA-Z0-9@+-._]/g,
		enabNumberReg: /[^0-9]/g,
		enabExtNumberReg: /[^0-6]/g,
		enabSpacingReg: /[\s]/g,
		enabShippingCostReg: /[^0-9$-]/g
	};

	FormValidate.prototype.handleFergFields = function() {
		var opts = this.options,
			_this = this; 

		_this.$form.find('input').each(function(index, el) {
			var checkName = this.attributes.getNamedItem(opts.dataAttrName);
			
			if (checkName && checkName.value) {
				$(this).on('blur', function(e) {
					var param = {},
						data,
						finalData,
						currentInput = this;

					param[$(this).attr(opts.dataAttrName)] = $(this).val();
					
					if ($.isFunction(opts.remote.data)) {
						data = opts.remote.data.call(currentInput, opts);
					}
					finalData = $.extend({}, param, typeof data === 'object' && data);

					$.ajax({
						url: opts.remote.remoteURL,
						dataType: 'json',
						data: {
							'json': JSON.stringify(finalData)
						},
						success: function(obj) {
							if ($.isFunction(opts.remote.completeCallback)) {
								opts.remote.completeCallback.call(currentInput, obj, opts);
								return;
							}
							//Do default action
							if (obj[checkName.value]) {
								var $inlineErrorDom = $(opts.inlineErrorDom);
								$(currentInput).addClass(opts.inputErrorClass).siblings(opts.inlineErrorClass).remove();
							 	$inlineErrorDom.text(obj[checkName.value]);
							 	$inlineErrorDom.insertAfter(currentInput);
							 } else {
								 $(currentInput)
									.removeClass(opts.inputErrorClass)
									.siblings(opts.inlineErrorClass).remove();
							 }

						},
						error: function(xhr, textStatus) {
							console.log(textStatus);
						}
					});

				});
			}

		});

		_this._handleRequiredSelect();
	};

	FormValidate.prototype.handleFields = function() {
		var opts = this.options,
			_this = this; 

		$.each(opts.fields ? opts.fields : {}, function(key, value) {
			_this.$form.find(key).on('blur', function(e) {
				var currentInput = this;
				
				if (value.remote) {
					var param = {},
						data,
						finalData;

					param[$(this).attr('name')] = $(this).val();
					if ($.isFunction(value.remote.data)) {
						data = value.remote.data();
					}
					finalData = $.extend({}, param, typeof data === 'object' && data);

					$.ajax({
						url: value.remote.url,
						dataType: 'json',
						data: {
							'json': JSON.stringify(finalData)
						},
						success: function(obj) {
							if ($.isFunction(value.remote.completeCallback)) {
								value.remote.completeCallback.call(currentInput, obj);
							}
						}
					});
				}
			});
		});

		_this._handleRequiredSelect();
	};

	FormValidate.prototype.handleEnterableFields = function() {
		var opts = this.options,
			_this = this; 

		$.each(opts.fields ? opts.fields : {}, function(key, value) {
			if (value.enterableType) {
				_this.$form.find(key).on(getEventName(), function(e) {
					if (e.type === 'keypress' && !isValide(e.which)) {
						e.preventDefault();
						return;
					}
					var inputValue = $(this).val();
					switch (value.enterableType) {
						case 'email':
					    	if (opts.enabEmailReg.test(inputValue)) {
					    		$(this).val(inputValue.replace(opts.enabEmailReg, ''));
					    	}
							break;
						case 'number':
							if (opts.enabNumberReg.test(inputValue)) {
								$(this).val(inputValue.replace(opts.enabNumberReg, ''));
							}
							break;
						case 'spacing':
							if (opts.enabSpacingReg.test(inputValue)) {
								$(this).val(inputValue.replace(opts.enabSpacingReg, ''));
							}
							break;
						case 'extnumber':
							if (opts.enabExtNumberReg.test(inputValue)) {
								$(this).val(inputValue.replace(opts.enabExtNumberReg, ''));
							}
							break;
						case 'shippingcost':
							if (opts.enabShippingCostReg.test(inputValue)) {
								$(this).val(inputValue.replace(opts.enabShippingCostReg, ''));
							}
							break;
					}
				});
			}
		});
	};

	FormValidate.prototype._validateField = function($field, fieldConf) {
		var val = $.trim($field.val()),
			required = !!$field[0].attributes.getNamedItem('required') || fieldConf.require;

		if (required && !val.length) {
			return {
				type: 'required',
				result: false
			};
		} 

		return true;
	};

	FormValidate.prototype._handleRequiredSelect = function() {
		var opts = this.options,
			_this = this; 

		if (opts.fields) {
			$.each(opts.fields, function(key, value) {
				var $eachFormEl = _this.$form.find(key);
				if ($eachFormEl[0] && $eachFormEl[0].nodeName.toLowerCase() === 'select' && value.require) {
					$eachFormEl.on('change', function() {
						var result = _this._validateField($(this), value),
							currentInput = this;
						if (result !== true) {
							if (result.type === 'required') {
								value.requireCallback && value.requireCallback.call(currentInput, result.result);
							}
						} else {
							value.requireCallback && value.requireCallback.call(currentInput, true);
						}
					});
				}
			});
		}
	};

	/**
	 * get event name which is 'input' or 'keyup'
	 * @return {string} 
	 */
	function getEventName() {
		var el = document.createElement('input');
		el.setAttribute('oninput', 'return;');
		
		return typeof el.oninput == 'function' ? 'input' : 'keypress';
	}

	function isValide(keynum) {
		function inRange(num, array) {
			if (num >= array[0] && num <= array[1]) {
				return true;
			}
			return false;
		};

		var result = false;
		var validteObj = {
			capital: [65, 90],
			minuscule: [97, 122],
			num: [48, 57]
		};
		var specialChar = [64, 43, 95, 45, 46];

		$.each(validteObj, function(index, val) {
			if (inRange(keynum, val) || ($.inArray(keynum, specialChar) !== -1)) {
				result = true;
			}
		});

		return result;
	}

	$.fn.formValidate = function (option) {
        var options = $.extend({}, FormValidate.DEFAULTS, typeof option === 'object' && option);
        	
        return this.each(function () {
		    var $this = $(this);
		    var data  = $this.data('formValidate');
 
		    if (!data) $this.data('formValidate', new FormValidate(this, options));
        });
    };

});
