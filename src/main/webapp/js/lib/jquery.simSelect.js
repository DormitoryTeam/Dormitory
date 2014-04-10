define(['acsScrollBar'], function() {
	var SimSelect = function(el, conf) {
		this.init(el, conf);
	}

	SimSelect.prototype.init = function(el, conf) {
		var $el = $(el),
			self = this;

		this.$el = $el;
		this.isDisabled = $el.prop('disabled');
		this.render();

		var $simSelect = $el.next(),
			$simHead = $simSelect.find('.sim-head'),
			$simList = $simSelect.find('.sim-list');
		
		this.$simSelect = $simSelect;
		
		if(this.isDisabled) $simSelect.addClass('disabled');
		$simSelect.on('click', '.sim-head', function() {
			if(self.isDisabled) return;
			self.open();			
		}).on('click', '.sim-list li', function() {
			var $this = $(this),
				val = $this.attr('str');

			if($this.hasClass('disabled')) return;

			$this.siblings().removeClass('hover').end().addClass('hover');

			$simHead.find('.current').attr('str', val).text($this.text());

			$simSelect.parent().css('z-index', '100');
			
			$simList.slideUp(100);
			$simSelect.removeClass('open');
			
			if(val === $el.val()) return;
			
			$el.val(val).trigger('change');
		}).on('mouseenter', '.sim-list li', function() {
			$(this).siblings().removeClass('hover').end().addClass('hover');
		}).on('mouseleave', '.sim-list li', function() {
			$(this).removeClass('hover');
		}).on('mouseleave', '.sim-list ul', function() {
			var val = $simHead.find('.current').attr('str');
			$(this).find('li[str="'+ val +'"]').addClass('hover');
		});
	}

	SimSelect.prototype.render = function() {
		var $el = this.$el,
			selectList = '',
			sClass = '',
			disabledClass = '',
			unavailableClass = '',
			selected = $el.val() ? $el.find("option[value = '"+ $el.val() +"']").text() : $el.find("option").eq(0).text(),
			selectStr = $el.val() ? $el.val() : $el.find("option").eq(0).val();

		for(var i = 0, len = $el.find('option').length; i<len; i++){
			sClass = $el.find("option").eq(i).attr('selected')? 'hover' : '';
			disabledClass = $el.find('option').eq(i).attr('disabled') ? 'disabled' : '';
			unavailableClass = $el.find('option').eq(i).attr('data-unavailable') ? 'unavailable' : '';
			if(i == $el.find("option").length-1 ){
				sClass += ' last';
			}
			selectList += "<li class='"+ sClass + ' ' + disabledClass + ' ' + unavailableClass +"' str='"+ $el.find("option").eq(i).attr('value') +"'>"+ $el.find("option").eq(i).html() +"</li>";
		}

		$el.wrap("<span class='select-el'></span>");
		var	str =	"<div class='sim-select'>";
			str += 		"<div class='sim-head'>";
			str +=			"<span class='current' str='"+ selectStr +"'>"+ selected +"</span>";
			str += 			"<span class='sim-arrow'></span>";
			str +=		"</div>";
			str += 		"<div class='sim-list'>";
			str +=			"<ul>"+ selectList +"</ul>";
			str +=		"</div>";
			str +=	"</div>";
		$el.after(str);
	}

	SimSelect.prototype.open = function() {
		var $el = this.$el,
			$simSelect = this.$simSelect,
			$simList = $simSelect.find('.sim-list');

		if($simSelect.hasClass('open')){
			$simSelect.parent().css('z-index', '100');
			$simList.slideUp(100, function(){
				$simSelect.removeClass('open');
			});
		}else {
			$simSelect.parent().css('z-index', '101');
			$simList.slideDown(100, function(){
				$simSelect.addClass('open');
				$simList.find('ul').acsScrollBar({
					minHeight: 210
				});
			});
		}
	}

	SimSelect.prototype.update = function() {
		var $el = this.$el,
			$simSelect = $el.next(),
			$simHead = $simSelect.find('.sim-head'),
			$simList = $simSelect.find('.sim-list'),
			selectList = '',
			sClass = '',
			disabledClass = '',
			selected = $el.val() ? $el.find("option[value = '"+ $el.val() +"']").html() : $el.find("option").eq(0).html(),
			selectStr = $el.val() ? $el.val() : $el.find("option").eq(0).attr('value');

		for(var i = 0, len = $el.find('option').length; i<len; i++){
			sClass = $el.find("option").eq(i).attr('selected')? 'hover' : '';
			disabledClass = $el.find('option').eq(i).attr('disabled') ? 'disabled' : '';
			if(i == $el.find("option").length-1 ){
				sClass += ' last';
			}
			selectList += "<li class='"+ sClass + ' ' + disabledClass +"' str='"+ $el.find("option").eq(i).attr('value') +"'>"+ $el.find("option").eq(i).html() +"</li>";
		}

		$simHead.find('.current').attr('str', selectStr).text(selected);
		$simList.html('<ul>'+ selectList + '</ul>');
	}

	$.fn.simSelect = function() {
		this.each(function() {
			var $this = $(this),
				data = $this.data('simSelect'),
				conf = $.extend({}, SimSelect.DEFAULTS, typeof opts === 'object' && opts);
			
			if (!data) {
				$this.data('simSelect', (data = new SimSelect(this, conf)));
			} else {
				data.update();
			}	
			if (typeof option == 'string') data[option]();
		});

		$(document).click(function(e){
			var elm = e.target;
			while(elm && !$(elm).hasClass('open')){
				elm = elm.parentNode;
			};
			if(!elm || !$(elm).hasClass('open')){
				$('.sim-select.open').parent().css('z-index', '100');
				$('.sim-select.open').find('.sim-list').slideUp(100);
				$('.sim-select.open').removeClass('open');
			}
		});

		return this;
	}
});