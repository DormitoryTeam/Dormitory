/**
	* Copyright(c) 2013 AAXIS ecommerce store
	* Imitate scroll Bar
	* Date: 2013/03/13
	* http://acs.com/ 
	*
	* 1 Initialize scroll bar.
	* 2 Judge whether or not the scroll bar appears.
	* 3 Drawing the scroll bar.
		* 3.1 Set the position of the scroll bar. 
		* Set the height of the button on the scroll bar. 
		* Set the entrance of mouse events of the all components in the scroll bar.
		* 3.2 When the top button or the bottom button is clicked a long time, calculate the offset value that the button moves. Then, return the value to the setScrollContainer method.
	* 4 The clicking events of buttons on the scroll bar.
		* 4.1 Record the current clicked coordinates, when the mouse clicks one of buttons on the scroll bar.
		* 4.2 When the mouse clicks down and moves on the scroll bar, calculate the offset value that the scroll bar moves. Next, return the value to the setScrollContainer method.
	* 5 According to the returning offset value, set the height that the scroll bar should move, and set the height that the content should move.
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
	
	$.extend($.fn, {
		acsScrollBar: function() {
			acsScrollBar.init.apply(this, arguments);
		}
	});
	
	var acsScrollBar = {
		
		/**
		 * 1 Initialize scroll bar.
		 * 
		 * Explain the setting parameters,
		 * 
		 * scrollShowWays     vertical scroll.
		 * scrollContent      the area that needs to scroll.
		 * minHeight          the critical value that the scroll bar appears.
		 * perScroll          the number of pixel that the middle button of the mouse moves. 
		 * perClickScroll     the number of pixel that the top button or the bottom button moves. 
		 * permoveTimer  	  the interval time that the scroll bar moves, when the mouse clicks a long time on the top button or the bottom button. 
		 * scrollBarCov       the area of the scroll bar. The parameter values as same as the class name of the scroll bar container.  
		 * scrollBarPrev      the class name of the top button in the scroll bar.
		 * scrollBarNext      the class name of the bottom button in the scroll bar.
		 * scrollBarBg        the background class name of the scroll area in the scroll bar.
		 * scrollBarButton    the class name of the scroll bar button 
		 * scrollBarBgMargin  the spacing between the scroll area and the top button, and the spacing between the scroll area and the bottom button.
		 */
		init: function(options, node) {
			var setting = $.extend(true, {
				scrollShowWays: 'lengthWays',
				scrollContent: 'cartItem',
				scrollCov: 'dis-scroll',
				scrollInnerContent: 'sbarContent',
				minHeight: '200',
				perScroll: '90',
				perClickScroll: '40',
				permoveTimer: 150,
				scrollBarCov: 'sbar-cov',
				scrollBarPrev: 'sbarPrev',
				scrollBarNext: 'sbarNext',
				scrollBarBg: 'sbar-bg',
				scrollBarButton: 'sbar-button',
				scrollBarBgMargin: 0,
				scrollWheel: true
			}, options||{});
			if(!node) node = this;
			var isTouch = 'ontouchstart' in window;
			return $(node).each(function() {
				setting.scrollContainer = $(this);
				setting.offsetTop = 0;
				setting.marginTop = 0;
				if(!isTouch) acsScrollBar.setDefault(setting);
				if(setting.scrollDis){
					setting.sbutton.bind('mousedown', function(e) {
						setting.scrollDrag = true;
						acsScrollBar.scrollBarDown(e, setting)
					});
				}
				
				setting.scrollContainer.parent().bind('mousemove', function(e) {
					if(setting.scrollDrag) {
						if(document.selection) !document.selection.empty ? document.selection = null : document.selection.empty();
						else if(window.getSelection) window.getSelection().removeAllRanges();
						acsScrollBar.scrollBarMove(e, setting)
					}
				});
				
				$(document).bind('mouseup', function(e) {
					setting.scrollDrag = false;
					if(setting.sbutton) setting.offsetTop = parseInt(setting.sbutton.css('top'));
				});
				
			});
		},
		
		scrollBarTo: function(e, setting) {
			if(!window.attachEvent) e.preventDefault();	
			if ( e.wheelDelta ) display = -e.wheelDelta/120;
			else if ( e.detail ) display = e.detail/3;
			setting.conHeight = setting.scrollContainer.children(0).height();
			if(setting.scrollWheel) {
				if(setting.containerHeight < setting.conHeight){
					var top = setting.offsetTop + display * setting.perScroll*setting.containerHeight/setting.conHeight;
					if(top<0) top=0;
					else if(top > setting.sbg.height()-setting.sbutton.height()) top = setting.sbg.height()-setting.sbutton.height();
					acsScrollBar.setScrollContainer(top, setting);
					setting.offsetTop = top;
				}
			}
		},
		
		// 2 Judge whether or not the scroll bar appears. 
		setDefault: function(setting) {
			if(!setting.scrollContainer.parent().hasClass(setting.scrollCov)){
				setting.scrollContainer.wrapAll("<div class='" + setting.scrollCov + "'></div>");
				setting.scrollContainer.children().wrapAll("<div class='" + setting.scrollInnerContent + "'></div>");
			} 
			setting.containerHeight = setting.scrollContainer.height();
			setting.conHeight = setting.scrollContainer.children(0).height();
			
			if(setting.containerHeight < setting.conHeight) {
				setting.scrollDis = true;
				if(setting.scrollShowWays.toLowerCase() == 'lengthways') {
					setting.scrollContainer.css('overflow', 'hidden');
					acsScrollBar.drawScrollBar(setting);
				}
			}else{
				setting.scrollContainer.parent().find('.' + setting.scrollBarCov).detach();
			}
		},
		
		// 3 Drawing the scroll bar.
		drawScrollBar: function(setting) {
			if(setting.scrollContainer.css('position')!='absolute' || setting.scrollContainer.css('position')!='relative') {
				setting.scrollContainer.css('position', 'relative');
			}
			var marginTop = setting.scrollContainer.css('margin-top');
			var sMarginTop = setting.scrollContainer.parent().css('margin-top')
			setting.scrollContainer.parent().css('margin-top',marginTop + sMarginTop);
			
			var scrollBar = "<div class="+ setting.scrollBarCov 
				+"><div class="+ setting.scrollBarPrev 
				+"></div><div class="+ setting.scrollBarNext 
				+"></div><div class="+ setting.scrollBarBg 
				+"><div class=" +setting.scrollBarButton+ "></div></div>";
			
			setting.scrollContainer.parent().find('.' + setting.scrollBarCov).detach();
			$(scrollBar).appendTo(setting.scrollContainer.parent());
			setting.scrollBar = setting.scrollContainer.parent().find("." + setting.scrollBarCov);
			acsScrollBar.setScrollBarPosition(setting);
		},
		
		// 3.1 Set the position of the scroll bar. 
		//     Set the height of the button on the scroll bar. 
		//     Set the entrance of mouse events of the all components in the scroll bar.
		setScrollBarPosition: function(setting) {
			setting.sprev = setting.scrollBar.find('.' + setting.scrollBarPrev);
			setting.snext = setting.scrollBar.find('.' + setting.scrollBarNext);
			setting.sbg = setting.scrollBar.find('.' + setting.scrollBarBg);
			setting.sbutton = setting.scrollBar.find('.' + setting.scrollBarButton);
			var spadding = parseInt(setting.scrollContainer.css('padding-top')) + parseInt(setting.scrollContainer.css('padding-bottom')),
				smargin = parseInt(setting.scrollBar.css('margin-top')) + parseInt(setting.scrollBar.css('margin-bottom')),
				sprevHeight = setting.sprev.height(),
				snextHeight = setting.snext.height(),
				sbgHeight = setting.scrollContainer.height() - spadding - sprevHeight - snextHeight - setting.scrollBarBgMargin*2;
			setting.conClonHeight = setting.conHeight + spadding + sprevHeight + snextHeight + setting.scrollBarBgMargin*2
			setting.scrollBar.css({
				'height': setting.scrollContainer.height() - spadding,
				'bottom': '0',
				'right': 0
				// 'right': parseInt(setting.scrollContainer.css('margin-right')) - setting.scrollBar.width()
			})
			setting.sbg.css({
				'height': sbgHeight,
				'top': sprevHeight + setting.scrollBarBgMargin
			});
			setting.sbg.find('.' + setting.scrollBarButton).css({
				'height': sbgHeight*setting.containerHeight/setting.conHeight,
				'top': '0'
			});
			var sim = (setting.sbg.height() - setting.sbutton.height())/(setting.conHeight - setting.containerHeight);
			setting.sprev.bind('mousedown', function() {
				setting.perMoveScroll = setting.perClickScroll * sim;
				acsScrollBar.intervalMethod(-1, setting);
			});
			setting.snext.bind('mousedown', function() {
				setting.perMoveScroll = setting.perClickScroll * sim;
				acsScrollBar.intervalMethod(1, setting);
			});
			setting.sbg.bind('mouseup', function(e) {
				var elm = e.target;
				while(elm && !$(elm).hasClass(setting.scrollBarBg)) {
					elm = elm.parentNode;
				};	
				if($(elm).hasClass(setting.scrollBarBg) && !setting.scrollDrag) {
					var clickY = e.pageY - setting.sbutton.offset().top;
					var display = clickY < 0 ? -1 : 1;
					var top = setting.offsetTop + display * setting.perScroll*setting.containerHeight/setting.conHeight;
					if(top<0) top=0;
					else if(top > setting.sbg.height()-setting.sbutton.height()) top = setting.sbg.height()-setting.sbutton.height();
					acsScrollBar.setScrollContainer(top, setting);
					setting.offsetTop = top;
				}
			});
			
			setting.sbg.dblclick(function() {
				if(document.selection) !document.selection.empty ? document.selection = null : document.selection.empty();
				else if(window.getSelection) window.getSelection().removeAllRanges();
			});
				
			setting.scrollBar.children().bind('mouseup', function() {
				setting.interval = false;
			});
			var addEvent = (function(){
				if (window.addEventListener) {
					return function(el, sType, fn, capture) {
						el.addEventListener(sType, fn, (capture));
					};
				} else if (window.attachEvent) {
					return function(el, sType, fn, capture) {
						el.attachEvent("on" + sType, fn);
					};
				} else return function() {};
			})(jQuery);
			
			var mousewheel = 'mousewheel';
			if (navigator.userAgent.indexOf("Firefox")>0) mousewheel = 'DOMMouseScroll';
			
			if(setting.scrollDis){
				addEvent(setting.scrollContainer[0], mousewheel, function(event) {
					if(event.preventDefault) event.preventDefault();
					event = window.event || event ;
					acsScrollBar.scrollBarTo(event, setting);
					return false; 
				}, false);
			}
			
			setting.scrollContainer.bind('mouseenter', function(event) {
				setting.scrollWheel = true;
			});
			
			setting.scrollContainer.bind('mouseleave', function(event) {
				setting.scrollWheel = false;
			})
		},
		
		// 3.2 When the top button or the bottom button is clicked a long time, calculate the offset value that the button moves. Then, return the value to the setScrollContainer method.
		intervalMethod: function(num, setting) {
			setting.interval = true;
			var interval = function() {
				if(setting.interval) {
					setting.marginTop= setting.marginTop + num * setting.perMoveScroll;
					acsScrollBar.setScrollContainer(setting.marginTop, setting)
					setTimeout(interval, setting.permoveTimer);
				}
			}
			interval();
		},
		
		// 4 The clicking events of buttons on the scroll bar.
		// 4.1 Record the current clicked coordinates, when the mouse clicks one of buttons on the scroll bar.
		scrollBarDown: function(e, setting) {
			setting.startEventY = e.pageY;
		},
		
		// 4.2 When the mouse clicks down and moves on the scroll bar, calculate the offset value that the scroll bar moves. Next, return the value to the setScrollContainer method.
		scrollBarMove: function(e, setting) {
			setting.endEventY = e.pageY;
			setting.realTop = setting.endEventY - setting.startEventY;
			if(isNaN(setting.offsetTop)) setting.offsetTop = 0;
			var top = setting.realTop + setting.offsetTop;
			acsScrollBar.setScrollContainer(top, setting);
		},
		
		// 5 According to the returning offset value, set the height that the scroll bar should move, and set the height that the content should move.
		setScrollContainer: function(top, setting) {
			if(top<0) top=0;
			else if(top>setting.sbg.height()-setting.sbutton.height()) top = setting.sbg.height()-setting.sbutton.height();
			setting.marginTop = top;
			setting.sbutton.css('top', top);
			setting.scrollContainer.children(':first').css({
				'margin-top': -(setting.conHeight - setting.containerHeight)/(setting.sbg.height() - setting.sbutton.height()) * top
			})
		}
	};
});