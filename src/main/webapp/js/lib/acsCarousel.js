/**
	* Copyright(c) 2013 AAXIS ecommerce store
	* Product and image carousel function
	* Date: 2013/03/13
	* http://acs.com/ 
	*
	* 1 Initialize carousel.
	* 2 Set the size of the carousel container and initialize the relative position of the carousel list, when the carousel initialize and the window is resized.
	* 3 According to the sliderLoop parameter, reconstruct the carousel list.
	* 4 For the pager and button elements, set the critical value to them and set them unable to click, when the sliderLoop parameter is false.
 */ 


$.extend($.fn, {
	acsCarousel: function() {
		acsCarousel.init.apply(this, arguments);
	}
});

var acsCarousel = $.extend({}, acsCommon, drawGadget, {
	
	// 1 Initialize carousel.
	init: function(options, node) {
		var setting = $.extend(true, {
			sliderDown: true,
			sliderDrag: true,
			sliderCanDrag: false,
			sliderCurrent: 0,
			currentPager: 0,
			sliderButton: true,
			sliderPager: false,
			sliderPagerCov: 'pager',
			sliderPagerMethod: '',
			sliderPageActive: 'active',
			sliderItem: 'carouselItem',
			sliderList: 'slideContent',
			sliderLoop: true,
			sliderOffset: 0,
			sliderInterval: 'swing',
			sliderTimer: 5000,
			sliderPlayTimer: 700,
			sliderSpeed: 260,
			sliderButtonCov: 'arrow',
			sliderButtonPrev: 'prev',
			sliderButtonNext: 'next',
			sliderDisabled : 'disabled',
			renderBtn: true
		}, options||{});
		if(!node) node = this;
		
		return $(node).each(function() {
			var returnNum, realMoveNum = 0, currentItem = 0, currentElm, touchEvent = !isTouch ? document : this, display = setting.sliderAutoPlay;
			setting.sliderCov = $(this).find('.'+ setting.sliderList).children('ul');
			setting.sliderContainer = $(this);
			setting.sliderItemsPrev = setting.sliderCov.html();
			setting.sliderLength = setting.sliderCov.find('> .'+ setting.sliderItem).length;
			setting.startItemNum = 0;
			
			if(!setting.sliderMethod) setting.sliderMethod = 'left';
			if(setting.sliderLoop) setting.sliderPager = false;
			if(!setting.sliderLoop) setting.sliderCanDrag = false;
			
			acsCarousel.setSize(setting);
			acsCarousel.setDefault(setting);
			acsCarousel.setPager(setting);
			acsCarousel.setButton(setting);
			
			if(!setting.sliderLoop) acsCarousel.resetActive(setting,  setting.currentPager);
			
			var s_width = setting.sliderContainer.width();
			$(window).bind('resize', function(e) {
				if(s_width != setting.sliderContainer.width()){
					s_width = setting.sliderContainer.width();
					acsCarousel.setSize(setting);
					acsCarousel.setDefault(setting);
					acsCarousel.setPager(setting);
					acsCarousel.setButton(setting);
				}			
			});
			
			acsCarousel.setBrowserInfo();
			
			// To come true dragging container, set the image unable to be choosen when the mouse is dragging it.
			if(!isTouch) $(this).find('img').bind('dragstart', function(event) {event.preventDefault()});
			
			//Clicking event of paging in carousel. 
			setting.sliderContainer.find("." + setting.sliderPagerCov).find('a').on(mouseUpEvent, function(e){
				currentItem = gadgets.pageClick(e, this, setting);
				acsCarousel.resetActive(setting);
			});
			
			//Clicking event of button in carousel
			setting.sliderContainer.find("." + setting.sliderButtonCov).find('a').on(mouseUpEvent, function(e){
				if($(this).hasClass(setting.sliderDisabled)) return false;
				currentItem = gadgets.buttonClick(e, currentItem, this, setting);
				if(!setting.sliderLoop) acsCarousel.resetActive(setting);
			});
			
			//Judge whether or not the carousel can be dragged.
			if(!setting.sliderCanDrag) {
				setting.sliderCov.unbind(mouseDownEvent);
				return false;
			}else {
				
				//Dragging: the event is executed when the mouse clicks down.
				setting.sliderCov.unbind(mouseDownEvent).bind(mouseDownEvent, function(event) {
					if(setting.sliderLength > Math.round(setting.sliderWidth/setting.sliderItemWidth)){
						if(!isTouch)event.preventDefault();
						acsCarousel.downEvent(event, this, setting);
					}
				});
				
				//Dragging: the event is executed when the mouse clicks down and moves.
				$(touchEvent).bind(mouseMoveEvent,function(event){
					if(setting.sliderDrag){
						returnNum = acsCarousel.moveEvent(event, setting);
						if(!isNaN(returnNum)) {
							method.sliderMethod(returnNum, setting);
						}
					}
				});
				
				//Dragging: the event is executed when the mouse clicks up.
				$(touchEvent).bind(mouseUpEvent, function(event){
					if(setting.sliderDrag){
						var elm = event.target, endEventX;
						while(elm && !$(elm).hasClass(setting.sliderItem)){
							elm = elm.parentNode;
						};
						if(elm || $(elm).hasClass(setting.sliderItem)){
							returnNum = acsCarousel.upEvent(elm, setting);
							if(!isNaN(returnNum)) {
								method.sliderMethod(returnNum, setting);
							}
						}else setting.sliderDrag = true;
					}
				})
			}
		});
	},
	
	// 2 Initialize parameters. And set the size of the carousel container and initialize the relative position of the carousel list, when you resize the window.
	setSize:function(setting) {
		var sliderWidth = setting.sliderCov.parent().width(),
			sliderHeight = setting.sliderCov.parent().outerHeight(),
			items = setting.sliderCov.find('.'+ setting.sliderItem);
		
		if(setting.sliderMethod.toLowerCase() == 'left' || setting.sliderMethod.toLowerCase() == 'right'){
			sliderHeight = setting.sliderCov.find('li').eq(0).outerHeight();
			if(parseInt(setting.sliderCov.parent().height()) < parseInt(sliderHeight)){
				setting.sliderCov.parent().css('height', sliderHeight+'px');
			}
		}
				
		setting.sliderWidth = sliderWidth;
		setting.sliderHeight = sliderHeight;
		
		
		if(setting.sliderMethod.toLowerCase() == 'left' || setting.sliderMethod.toLowerCase() == 'right'){
			setting.sliderItemWidth = items.outerWidth();
			setting.sliderPerPageSize = Math.round(sliderWidth/setting.sliderItemWidth);
		}else if(setting.sliderMethod.toLowerCase() == 'up' || setting.sliderMethod.toLowerCase() == 'down'){
			setting.sliderItemHeight = items.outerHeight();
			setting.sliderPerPageSize = Math.round(sliderHeight/setting.sliderItemHeight);
		}
		
		setting.sliderMoveNum = !setting.sliderMoveNum ? setting.sliderPerPageSize : setting.sliderMoveNum;
		setting.realMoveNum = setting.sliderMoveNum > setting.sliderPerPageSize ? setting.sliderPerPageSize : setting.sliderMoveNum
		
		if(setting.sliderLength > setting.sliderPerPageSize){
			if(setting.sliderMethod.toLowerCase() == 'left' || setting.sliderMethod.toLowerCase() == 'right'){
				if(setting.sliderCov.find('> li.currentItem').length == 1){
					setting.sliderCurrent = setting.sliderCov.find('> li.currentItem').index();
					setting.sliderLoop ? setting.sliderCov.css('margin-left', -sliderWidth) : setting.sliderCov.css('left', - setting.sliderCov.find('> li.currentItem').index() * setting.sliderItemWidth);
				}else{
					setting.sliderLoop ? setting.sliderCov.css('margin-left', -sliderWidth) : setting.sliderCov.css('left', -setting.sliderCurrent * setting.sliderItemWidth);
				}
			}else if(setting.sliderMethod.toLowerCase() == 'up' || setting.sliderMethod.toLowerCase() == 'down'){
				setting.sliderLoop ? setting.sliderCov.css('margin-top', -sliderHeight) : setting.sliderCov.css('top', -setting.sliderCurrent * setting.sliderItemHeight);
				setting.sliderCov.css('top', '0');
			}
		}else {
			setting.sliderLoop ? setting.sliderCov.css('margin-left', 0) : setting.sliderCov.css('left', 0);
		}
	},
	
	
	// 3 According to the sliderLoop parameter, reconstruct the carousel list.
	setDefault:function(setting){
		setting.sliderRealLength = !setting.sliderLoop ? setting.sliderLength : setting.sliderLength*3;
		
		setting.sliderItemsCurrent = setting.sliderItemsPrev + setting.sliderItemsPrev + setting.sliderItemsPrev;
		if(setting.sliderLoop){
			if(setting.sliderLength > Math.round(setting.sliderWidth/setting.sliderItemWidth)){
				setting.sliderCov.html(setting.sliderItemsCurrent);
				setting.sliderRealLength = setting.sliderCov.find('.'+ setting.sliderItem).length;
				for(i=setting.sliderRealLength; i>setting.sliderRealLength-Math.round(setting.sliderWidth/setting.sliderItemWidth);i--){
					setting.sliderCov.find('.'+ setting.sliderItem).eq(0).before(setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderRealLength-1));
				}
			}else{
				setting.sliderCov.html(setting.sliderItemsPrev);
			}
		}
		if(setting.sliderMethod.toLowerCase() == 'left' || setting.sliderMethod.toLowerCase() == 'right'){
			setting.sliderCov.css({
				'width' : setting.sliderRealLength * setting.sliderItemWidth,
				'height' : setting.sliderHeight
			});	
		}else if(setting.sliderMethod.toLowerCase() == 'up' || setting.sliderMethod.toLowerCase() == 'down'){
			setting.sliderCov.css({
				'width' : setting.sliderWidth,
				'height' : setting.sliderRealLength * setting.sliderItemHeight
			});
		};
		setting.startItemNum = 1;
		setting.endItemNum = setting.startItemNum + (setting.sliderPerPageSize > setting.sliderLength ? setting.sliderLength-1 : setting.sliderPerPageSize - 1);
		if(setting.callBack) $.extend({}, setting).callBack(setting.sliderContainer, setting);
	},
	
	// 4 For the pager and button elements, set the critical value to them and set them unable to click, when the sliderLoop parameter is false.
	resetActive:function(setting, num){
		if(setting.sliderCov.parent().css('overflow') != 'hidden'){
			var currentIndex = isNaN(setting.sliderCurrent)?0:parseInt(setting.sliderCurrent);
			if(currentIndex-1 < 0){
				setting.sliderContainer.find('.'+ setting.sliderItem).eq(0).css('visibility', 'visible');
				setting.sliderContainer.find('.'+ setting.sliderItem + ':gt('+(currentIndex)+')').css('visibility', 'visible');
			}else{
				setting.sliderContainer.find('.'+ setting.sliderItem + ':gt('+(currentIndex - 1)+')').css('visibility', 'visible');
			}
			
			setting.sliderContainer.find('.'+ setting.sliderItem + ':lt('+(currentIndex)+')').css('visibility', 'hidden');
			
			setting.sliderContainer.find('.'+ setting.sliderItem + ':gt('+(currentIndex + setting.sliderPerPageSize-1)+')').css('visibility', 'hidden');
		}
		
		var pager = setting.sliderContainer.find("." + setting.sliderPagerCov);
		var button = setting.sliderContainer.find("." + setting.sliderButtonCov);
		pager.find("a").removeClass(setting.sliderPageActive);
		pager.find("a").eq(setting.currentPager).addClass(setting.sliderPageActive);
		button.find('a').removeClass(setting.sliderDisabled);
		var num = setting.sliderCurrent;
		if(setting.sliderPerPageSize >= setting.sliderLength){
			button.find("."+setting.sliderButtonPrev).addClass(setting.sliderDisabled);
			button.find("."+setting.sliderButtonNext).addClass(setting.sliderDisabled);
		}else {
			if(num <= 0){
				button.find("."+setting.sliderButtonPrev).addClass(setting.sliderDisabled);
			}else if(num + setting.sliderPerPageSize >= setting.sliderLength){
				button.find("."+setting.sliderButtonNext).addClass(setting.sliderDisabled);
			}	
		}
	}
})