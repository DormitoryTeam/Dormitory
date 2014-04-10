(function(factory) {
	if(typeof define === 'function' && define.amd) {
		define(['jquery'], factory);
	} else {
		factory(jQuery);
	}
})(function($) {
	var Tooltip = function(el, conf) {
		this.init('popover', el, conf);
	}

	Tooltip.prototype.init = function(type, el, conf) {
		this.conf = conf;	
		this.$el = $(el);
		this.type = type;
		
		this.setContent();
		
		if(conf.show) {
			this.show(conf);
		}
	}

	Tooltip.prototype.setContent = function() {
		var $tip = this.tip(),
			content = this.getContent();
		$tip.html(content);
	}

	Tooltip.prototype.getContent = function() {
		return this.conf.content || this.$el.data('content');
	}

	Tooltip.prototype.layout = function(conf) {
		var $el = this.$el,
			top = $el.offset().top,
			left = $el.offset().left;

		this.setContent();

		this.$tip.css({
			display: 'block'
		});

		$('body').append(this.$tip);
		
		var height = this.$tip.height() + conf.padding*2 + conf.marginT,
			width = this.$tip.width() + conf.padding*2 + conf.marginL,
			top = top - height,
			left = (conf.align == 'left') ? left : left - width/2 + $el.width()/2;

		this.$tip.css({
			top: top,
			left: left
		});
	}

	Tooltip.prototype.show = function() {
		this.layout(this.conf);
		this.$tip.fadeIn();
	}

	Tooltip.prototype.hide = function() {
		this.$tip.detach();
	}

	Tooltip.prototype.tip = function() {
		return this.$tip = this.$tip || $(this.conf.template);
	}

	Tooltip.DEFAULTS = {
		template: '<div class="popover"></div>',
		trigger: 'hover',
		selector: false,
		padding: 0,
		marginL: 0,
		marginT: 0,
		align: 'center'
	}

	$.fn.popover = function(opts) {
		return this.each(function() {
			var $this = $(this),
				data = $this.data('popover'),
				conf = $.extend({}, Tooltip.DEFAULTS, typeof opts === 'object' && opts);
			
			if (!data) $this.data('popover', (data = new Tooltip(this, conf)));
			if (typeof opts == 'string'){
				data[opts]();
			}
		});
	}
});