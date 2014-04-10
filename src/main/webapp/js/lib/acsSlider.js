/**
	* Copyright(c) 2013 AAXIS ecommerce store
	* Slider function
	* Date: 2013/03/13
	* http://acs.com/ 
	*
	* 1 Initialize slider.
	* 2 When initialize slider and the window is resized, set the size of the slider container and initialize the relative position of the slider list.
	* 3 According to judge whether or not the slider loops, reconstruct the slider list.
 */

$.extend($.fn, {
	acsSlider: function() {
		acsSlider.init.apply(this, arguments);
	}
});

var acsSlider = $.extend({}, acsCommon, drawGadget, {
	
	// 1 Initialize slider.
	init: function(options, node){
		var setting = $.extend(true,{
			sliderAutoPlay: true,
			sliderDown: true,
			sliderDrag: false,
			sliderProgress: false,
			sliderProgressClass: 'sliderProgress',
			sliderCurrent: 0,
			currentPager: 0,
			sliderPager: true,
			sliderButton: true,
			sliderSummary: true,
			startwidth: 960,
       		startheight: 400,
			sliderMethod: 'left',
			sliderItem: 'sliderItem',
			sliderMoveNum: 1,
			sliderLoop: true,
			sliderOffset: 0,
			sliderInterval: 'swing',
			sliderTimer: 4000,
			sliderPlayTimer: 500,
			sliderSpeed: 260,
			sliderPagerCov: 'sliderPager',
			sliderPagerMethod: '',
			sliderPageActive: 'active', 
			sliderButtonCov: 'sliderButton',
			sliderButtonPrev: 'sliderPrev',
			sliderButtonNext: 'sliderNext'
		},options||{});
		if(!node) node = this;
		return $(node).each(function(){
			setting.display = setting.sliderAutoPlay;
			setting.sliderCov = $(this);
			setting.sliderContainer = $(this);
			if(setting.beforLoad){
				$.extend({}, setting).beforLoad(this,setting);
			};
			acsSlider.setDefault(setting);
			acsSlider.setSize(setting);
			acsSlider.setProgressClass(setting);
			acsSlider.setPager(setting);
			acsSlider.setButton(setting);
			if(setting.sliderAutoPlay){
				method.sliderAutoPlay(setting.sliderCurrent,setting);
				
				$(setting.sliderCov).bind(mouseEnterEvent,function(){
					setting.sliderAutoPlay = false;
					if(setting.sliderProgress) setting.sliderProgressElm.stop(false, false);
					clearTimeout(setting.sliderAuto);
				});
				
				$(setting.sliderCov).bind(mouseLeaveEvent,function(){
					setting.sliderAutoPlay = true;
					if(setting.sliderDown){
						if(setting.sliderProgress){
							var remainTime = (1-setting.sliderProgressElm.width()/$(setting.sliderCov).find('.sliderProgress').width())*setting.sliderTimer
							var timer = remainTime;
						}
						method.sliderAutoPlay(setting.sliderCurrent,setting, timer);
					}
				});
			}
			
			if(setting.callBack) $.extend({}, setting).callBack(this,setting);
			if(setting.beforePlay) $.extend({}, setting).beforePlay(setting.sliderCov, setting);
			if(setting.afterPlay) $.extend({}, setting).afterPlay(setting.sliderCov, setting);
			
			$(window).bind('resize',function(e){
				acsSlider.setSize(setting);
			});
			
			var returnNum, currentElm, currentItem = 0, touchEvent = !isTouch ? document : this;
			
			acsSlider.setBrowserInfo()
			
			//To come true the container dragging, set the image unable to be choosen when the mouse is dragging it.
			if(!isTouch)$(this).find('img').bind('dragstart', function(event) {event.preventDefault(); });
			
			//Clicking event of button in slider.
			setting.sliderContainer.find("." + setting.sliderButtonCov).find('a').bind(mouseUpEvent, function(e){
				if($(this).hasClass(setting.sliderDisabled)) return false;
				gadgets.buttonClick(e, currentItem, this, setting);
			});
			
			//Clicking event of paging in slider.
			setting.sliderCov.find("." + setting.sliderPagerCov).find('a').bind(mouseUpEvent, function(e){
				gadgets.pageClick(e, this, setting);
			});
			
			//Judge whether or not the slider can be dragged.
			if(!setting.sliderCanDrag) {
				setting.sliderContainer.unbind(mouseDownEvent);
				return false;
			}else {
				
				//Dragging: the event is executed when the mouse clicks down.
				setting.sliderCov.children(':first-child').unbind(mouseDownEvent).bind(mouseDownEvent, function(event) {
					if(!isTouch) event.preventDefault();
					acsSlider.downEvent(event, this, setting);
				});
				
				//Dragging: the event is executed when the mouse clicks down and moves.
				$(touchEvent).bind(mouseMoveEvent,function(event){
					if(!setting.sliderDrag){
						return false;
					}else {
						returnNum = acsSlider.moveEvent(event, setting);
						if(!isNaN(returnNum)) {
							method.sliderMethod(returnNum, setting);
						}
					}
				});
				
				//Dragging: the event is executed when the mouse clicks up.
				$(touchEvent).bind(mouseUpEvent, function(event){
					if(!setting.sliderDrag) return false;
					else{
						var elm = event.target, endEventX;
						while(elm && !$(elm).hasClass(setting.sliderItem)){
							elm = elm.parentNode;
						};
						if(elm || $(elm).hasClass(setting.sliderItem)){
							returnNum = acsSlider.upEvent(elm, setting);
							if(!isNaN(returnNum)) {
								method.sliderMethod(returnNum, setting);
							}
						}else setting.sliderDrag = true;
					}
				})
			}
		});
	},
	
	// 2 When initialize slider and the window is resized, set the size of the slider container and initialize the relative position of the slider list.
	setSize:function(setting){
		var sliderCov = setting.sliderCov.children(':first-child'),
			sliderWidth = setting.sliderCov.width();
			if(setting.toScale){
				var sliderHeight = setting.startheight/setting.startwidth * sliderWidth;
			}else{
				var sliderHeight = setting.sliderCov.height();
			}
		sliderCov.find('.'+ setting.sliderItem).width(sliderWidth);
		setting.sliderCov.height(sliderHeight);
		setting.sliderItemWidth = sliderCov.find('.'+ setting.sliderItem).width();
		setting.realMoveNum = setting.sliderMoveNum = 1;
		setting.currentMoveNum = setting.sliderMoveNum;
		setting.sliderCov.find('.'+ setting.sliderItem).css({
			'width' : sliderWidth,
			'height' : sliderHeight
		})
		switch (setting.sliderMethod.toLowerCase()){
			case 'left' :
				setting.sliderWidth = sliderWidth;
				if(setting.sliderLoop){
					setting.sliderCov.children().eq(0).css('margin-left',-sliderWidth)
					sliderCov.css({
						width : setting.sliderWidth * 2 * setting.sliderLength,
						height : sliderHeight
					});
				}else {
					setting.sliderCov.children().eq(0).css({'left':-setting.sliderCurrent*sliderWidth})
					sliderCov.css({
						width : setting.sliderWidth * setting.sliderLength,
						height : sliderHeight
					});
				}
			break;
			case 'right' :
				setting.sliderWidth = sliderWidth;
				if(setting.sliderLoop){
					setting.sliderCov.children().eq(0).css('left',-sliderWidth * (setting.sliderLength*2-2))
					sliderCov.css({
						'width' : setting.sliderWidth * setting.sliderLength * 2,
						'height' : sliderHeight
					});
				}else {
					setting.sliderCov.children().eq(0).css('left',-sliderWidth * (setting.sliderLength-setting.sliderCurrent-1))
					sliderCov.css({
						'width' : setting.sliderWidth * setting.sliderLength,
						'height' : sliderHeight
					});
				}
				setting.sliderCov.find('.'+ setting.sliderItem).css('float','right');
			break;
			case 'up' :
				setting.sliderHeight = sliderHeight;
				if(setting.sliderLoop){
					setting.sliderCov.children().eq(0).css('top',-sliderHeight);
					sliderCov.css({
						width : sliderWidth,
						height : sliderHeight * setting.sliderLength * 2
					})
				}else {
					$(setting.sliderCov).children().eq(0).css({'top':-setting.sliderCurrent*sliderHeight})
					sliderCov.css({
						width : sliderWidth,
						height : sliderHeight * setting.sliderLength
					})
				}
				setting.sliderCov.find('.'+ setting.sliderItem).css('float','left');
			break;
			case 'down' :
				setting.sliderHeight = sliderHeight;
				var length = setting.sliderCov.find('.'+ setting.sliderItem).length;
				setting.sliderCov.find('.'+ setting.sliderItem).each(function(){
					$(this).css({
						'position' : 'absolute',
						'top' : (length - $(this).index()-1) * sliderHeight
					})
				});
				if(setting.sliderLoop){
					setting.sliderCov.children().eq(0).css('top',-sliderHeight*(setting.sliderLength*2-2));
					sliderCov.css({
						width : sliderWidth,
						height : sliderHeight * setting.sliderLength*2
					})
				}else {
					setting.sliderCov.children().eq(0).css('top',-sliderHeight*(setting.sliderLength-1));
					sliderCov.css({
						width : sliderWidth,
						height : sliderHeight * setting.sliderLength
					})
				}
				setting.sliderCov.find('.'+ setting.sliderItem).css('float','left');
			break;
			default :
				sliderCov.css({
					width : sliderWidth,
					height : sliderHeight
				})
				setting.sliderCov.find('.'+ setting.sliderItem).css({
					'position' : 'absolute',
					'top' : (length - $(this).index()-1) * sliderHeight
				})
				setting.sliderWidth = sliderWidth;
				setting.sliderHeight = sliderHeight;
			break;
		};
	},
	
	// 3 According to judge whether or not the slider loops, reconstruct the slider list.
	setDefault:function(setting){
		setting.sliderLength = setting.sliderCov.find('.'+ setting.sliderItem).length;
		if(setting.sliderMethod.toLowerCase() == 'fadein'){
			setting.sliderCov.find('.'+ setting.sliderItem).eq(0).appendTo(setting.sliderCov.find('.'+ setting.sliderItem).parent());
		}else{
			if(setting.sliderLoop){
				setting.sliderCov.find('.'+ setting.sliderItem).parent().append(setting.sliderCov.find('.'+ setting.sliderItem).clone());
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0).before(setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength*2-1));
			}
		}
	}	
})