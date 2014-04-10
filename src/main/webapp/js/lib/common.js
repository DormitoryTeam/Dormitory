/**
	* Copyright(c) 2013 AAXIS ecommerce store
	* Mouse event
	* Date: 2013/03/13
	* http://acs.com/ 
	*
	* 1 Set all kinds of mouse events about the different responsive devices. And judge the version of the current browser.
	* 2 Judge the version of the current browser.
	* 3 Mouse event.
		* 3.1 The methods are executed, when the mouse clicks down.
		* 3.2 The methods are executed, when the mouse clicks down and moves.
		* 3.3 The methods are executed, When the mouse clicks up.
	* 4 Returning the offset value, when the mouse clicks down and moves.
		* 4.1 When set to switch to the left, calculate the offset value in real time and set the corresponding moving animation.
		* 4.2 When set to switch to the right, calculate the offset value in real time and set the corresponding moving animation. 
	*  5 Returning the offset value and moved unit quantity, when the mouse clicks up.
		* 5.1 When the default action is switching to left, calculate the offset value which happens when the mouse clicks up, and return the current moved unit number.
		* 5.2 When the default action is switching to right, calculate the offset value which happens when the mouse clicks up, and return the current moved unit number.
 */

// 1 Set all kinds of mouse events about the different responsive devices. And judge the version of the current browser.
var isTouch = 'ontouchstart' in window,
	mouseClickEvent = isTouch ? 'touchstart' : 'click',
	mouseDownEvent = isTouch ? 'touchstart' : 'mousedown',
	mouseMoveEvent = isTouch ? 'touchmove' : 'mousemove',
	mouseUpEvent = isTouch ? 'touchend' : 'mouseup',
	mouseEnterEvent = isTouch ? 'touchstart' : 'mouseenter',
	mouseLeaveEvent = isTouch ? 'touchend' : 'mouseleave',
	isFirefox = false,
	isWebkit = false,
	isIe7 = false,
	isIe8 = false,
	isIe9 = false,
	isIe = false;
var acsCommon = {
	init: function(options, node) {
		return;
	},
	
	// 2 Judge the version of the current browser.
	setBrowserInfo: function() {
		if(navigator.userAgent.indexOf("Firefox")>0) {
			isFirefox = true;
		}else if(navigator.userAgent.match('WebKit') != null) {
			isWebkit = true;
			grabOutCursor = '-webkit-grab';
			grabInCursor = '-webkit-grabbing';
		} else if(navigator.userAgent.match('Gecko') != null) {
			isGecko = true;
			grabOutCursor = 'move';
			grabInCursor = '-moz-grabbing';
		} else if(navigator.userAgent.match('MSIE 7') != null) {
			isIe7 = true;
			isIe = true;
		} else if(navigator.userAgent.match('MSIE 8') != null) {
			isIe8 = true;
			isIe = true;
		} else if(navigator.userAgent.match('MSIE 9') != null) {
			isIe9 = true;
			isIe = true;
		}
		
	},
	
	/**
	 * 3.1 The methods are executed, when the mouse clicks down.
	 * 	   Forbid all default events of the linker target in the container. 
	 *     Get the current time (The current dragging action is effective, when there is offset value and the mouse clicks up quickly during the dragging action.).
	 *     Get the order of the slider list that the mouse focus on.
	 *     Get the offset value of the current element in the slider list: offsetLeft and marginLeft. 
	 */
	downEvent: function(e, obj, setting){
		$(obj).find('a').bind(mouseClickEvent, function(event){
			if(!isTouch) event.preventDefault()
		})
		if(setting.sliderDown){
			if(setting.sliderLength > Math.round(setting.sliderWidth/setting.sliderItemWidth)){
				setting.sliderDrag = true;
				setting.startEventTime = new Date();
				setting.startEventX = !isTouch ? e.pageX : e.originalEvent.touches[0].pageX;
				var elm = e.target;
				while(elm && !$(elm).hasClass(setting.sliderItem)) {
					elm = elm.parentNode;
				}
				if(elm || $(elm).hasClass(setting.sliderItem)) {
					setting.currentDragNum = $(elm).index();
					var sliderList = obj;
					setting.offsetLeft = parseInt($(obj).css('left'));
					setting.marginLeft = parseInt($(obj).css('margin-left'));
				}
			}else setting.sliderDrag = false;
		}
	},
	
	// 3.2 The methods are executed, when the mouse clicks down and moves.
	moveEvent: function(event, setting) {
		if(!setting.sliderCanDrag) return false;
		
		// Get the current coordinate where the mouse focus, and store the coordinate into the option parameter. But it need to emphasize that the option parameter only store the last coordinate.
		// Then, the coordinate is the coordinates happened when the mouse clicks up. Why we do this, because coordinate can not be get when the mouse clicks up in the ipad device.
		var moveEventX = !isTouch ? event.pageX : event.originalEvent.touches[0].pageX;
		setting.endEventX = moveEventX;
		
		var num = setting.currentDragNum, 
			currentNum = setting.sliderCurrent,
			elm = event.target, 
			realLeft, 
			startEventX = setting.startEventX,
			returnNum;
		setting.sliderOffset = moveEventX - startEventX;
		
		// The dragging up and down actions are forbidden in window, when the offset value is more than five pixels in horizontal direction.
		// (In the ipad device, the all javascript will be stopped to execute when the dragging down or up action happens in window. 
		// So, when the default vertical scroll appears, dragging left and right actions will become invalid.)
		if(Math.abs(setting.sliderOffset)>10){
			event.preventDefault();	
			setting.currentMoveNum = Math.ceil(setting.sliderOffset/setting.sliderItemWidth);
			while(elm && !$(elm).hasClass(setting.sliderItem)) {
				elm = elm.parentNode;
			};
			
			// The default selection status is canceled, when the mouse is dragging.
			if(document.selection) !document.selection.empty ? document.selection = null : document.selection.empty();
			else if(window.getSelection) window.getSelection().removeAllRanges();
			
			if(!setting.sliderDrag) return false; 
			else{
				drawGadget.resetProgress(setting);
				setting.endEventTime = new Date();
				if(setting.sliderMethod.toLowerCase() == 'left') {
					returnNum = acsCommon.returnLeftMouseMoveNum(elm, num, currentNum, realLeft, startEventX, moveEventX, setting);
					return returnNum;
					
				}else if(setting.sliderMethod.toLowerCase() == 'right') {
					returnNum = acsCommon.returnRightMouseMoveNum(elm, num, currentNum, realLeft, startEventX, moveEventX, setting);
					return returnNum;
					
				}
			}
		}
		
	},
	
	// 3.3 The methods are executed, When the mouse clicks up.
	upEvent:function(elm, setting){
		if(!setting.sliderCanDrag) return false; 
		drawGadget.resetProgress(setting);
		setting.sliderDrag = false;
		setting.sliderDown = false;
		startEventX = setting.startEventX;
		endEventX = setting.endEventX;
		setting.endEventX = undefined;
		var num = setting.sliderCurrent;
		setting.endEventTime = new Date();
		if(!endEventX) {
			setting.sliderDown = true;
			if(isTouch && setting.display) method.sliderAutoPlay(num,setting);
		}
		
		// Judge whether or not there is offset value during the mouse clicks up and down, or judge whether or not the mouse clicks. 
		// Then, the linker target in container can be able to use.  
		if(startEventX == endEventX || !endEventX){
			setting.sliderCov.find("a").bind(mouseClickEvent, function(e){
				if(startEventX == endEventX || !endEventX){
					var srclink = $(this).attr('href');
					if(srclink){
						if(srclink != 'javascript:void(0)' || srclink != '#')window.location = $(this).attr('href');
					}
				}
			})
		}
		
		if(setting.sliderMethod.toLowerCase() == 'left') {
			
			num = acsCommon.returnLeftMouseUpNum(elm, num, startEventX, endEventX, setting);
			return num
			
		}else if(setting.sliderMethod.toLowerCase() == 'right'){
			num = acsCommon.returnRightMouseUpNum(elm, num, startEventX, endEventX, setting);
			return num
			
		}else setting.sliderDown = true;
	},
	
	// 4.1 When set to switch to the left, calculate the offset value in real time and set the corresponding moving animation.
	returnLeftMouseMoveNum: function(elm, num, currentNum, realLeft, startEventX, moveEventX, setting){
		if(!setting.sliderLoop) {
			
			// When the loop parameter is false, set the offset value which is used 
			// when the mouse is on the first item or the last item or the middle item, or the mouse moves out of the container during the dragging action.
			if($(elm).index() == 0) {
				realLeft = moveEventX > startEventX ? ((moveEventX - startEventX)/2.5 + setting.offsetLeft) : (moveEventX - startEventX + setting.offsetLeft);
			}else if($(elm).index() == setting.sliderLength-1) {
				realLeft = moveEventX < startEventX ? ((moveEventX - startEventX)/2.5 + setting.offsetLeft) : (moveEventX - startEventX + setting.offsetLeft)
			}else if($(elm).index()=='-1' || setting.endEventX<=0) {
				setting.endEventX = "";
				setting.sliderDrag = false;
				if(moveEventX > startEventX) num--;
				else if(startEventX > moveEventX) num++;
				if(num<0) num++;
				if(num>setting.sliderLength-1) num--;
				if(setting.display) setting.sliderAutoPlay = true;
				return num-1;
			}else realLeft = moveEventX - startEventX + setting.offsetLeft;
			setting.sliderCov.find('.'+ setting.sliderItem).parent().css('left', realLeft);
		}else {
			
			// When the loop parameter is false, set the moved pixels which is used when the mouse on the one of the item, or the mouse moves out of the container during the dragging action.
			if($(elm).index()=='-1' || setting.endEventX<=0) {
				setting.sliderDrag = false;
				setting.endEventX = "";
				if(setting.display) setting.sliderAutoPlay = true;
				setting.sliderOffset = moveEventX - startEventX;
				setting.endEventTime = new Date();
				setting.currentMoveNum = 1;
				if(setting.sliderItemWidth < setting.sliderWidth){
					setting.currentMoveNum = Math.ceil(Math.abs(setting.sliderOffset/setting.sliderItemWidth));
				}
				if(startEventX > moveEventX) {
					return currentNum;
				}else {
					setting.sliderBack = true;
					setting.sliderDragBack = true;
					currentNum = currentNum < 0 ? setting.sliderLength + currentNum : currentNum;
					return currentNum-1;
				}
			}else realLeft = moveEventX - startEventX;
			if(realLeft<0){

				// When the relative displacement is reverse, set the slider position corresponded by the the current offset value.
				setting.sliderCov.find('.'+ setting.sliderItem).each(function(){
					if($(this).index() <= Math.abs(setting.currentMoveNum)){
						$(this).css({
							'margin-left': realLeft + $(this).index()*setting.sliderItemWidth
						})
					}
				})
			}else{

				// When the relative displacement is forward, set the slider position corresponded by the the current offset value.
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0).css('margin-left', realLeft)
			}
		}
	},
	
	// 4.2 When set to switch to the right, calculate the offset value in real time and set the corresponding moving animation. 
	returnRightMouseMoveNum:function(elm, num, currentNum, realLeft, startEventX, moveEventX, setting){
		if(!setting.sliderLoop) {
			if($(elm).index() == 0){
				realLeft = moveEventX < startEventX ? ((moveEventX - startEventX)/2.5 + setting.offsetLeft) : (moveEventX - startEventX + setting.offsetLeft);
			}else if($(elm).index() == setting.sliderLength-1) {
				realLeft = moveEventX > startEventX ? ((moveEventX - startEventX)/2.5 + setting.offsetLeft) : (moveEventX - startEventX + setting.offsetLeft);
			}else if($(elm).index()=='-1' || setting.endEventX<=0) {
				setting.sliderDrag = false;
				setting.endEventX = "";
				if(moveEventX > startEventX) num++; 
				else if(startEventX > moveEventX) num--;
				if(num<0) num++;
				if(num>setting.sliderLength-1) num--;
				if(setting.display) setting.sliderAutoPlay = true;
				return num-1;
			}else realLeft = moveEventX - startEventX + setting.offsetLeft;
			setting.sliderCov.find('.'+ setting.sliderItem).parent().css('left', realLeft);
		}else{
			if($(elm).index()=='-1' || setting.endEventX<=0){
				currentNum = currentNum < 0 ? setting.sliderLength + currentNum : currentNum;
				if(setting.display) setting.sliderAutoPlay = true;
				setting.sliderDrag = false;
				setting.endEventX = "";
				setting.sliderOffset = moveEventX - startEventX;
				setting.endEventTime = new Date();
				setting.currentMoveNum = 1;
				if(setting.sliderItemWidth < setting.sliderWidth){
					setting.currentMoveNum = Math.ceil(Math.abs(setting.sliderOffset/setting.sliderItemWidth));
				}
				if(startEventX > moveEventX){
					setting.sliderBack = true;
					return currentNum-1;
				}else{
					return currentNum;
				}
			}else {
				realLeft = moveEventX - startEventX;
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0).css('margin-right', -realLeft)					
			}				
		}
	},

	// 5.1 When the default action is switching to left, calculate the offset value which happens when the mouse clicks up, and return the current moved unit number.
	returnLeftMouseUpNum:function(elm, num, startEventX, endEventX, setting){
		if(!setting.sliderLoop) {
			if(startEventX != endEventX && endEventX>='0') {
				if($(elm).index()==0) {
					if((startEventX - endEventX) <= setting.sliderWidth/2) {
						if(startEventX > endEventX) num = (setting.endEventTime - setting.startEventTime<setting.sliderSpeed) ? num : num-1;
						else num = num-1
					}else num = num
				}else if($(elm).index() == setting.sliderLength-1) {
					if((endEventX - startEventX) <= setting.sliderWidth/2) {
						if(startEventX < endEventX) num = (setting.endEventTime - setting.startEventTime<setting.sliderSpeed) ? num-2 : num-1;
						else num = num-1
					}else num = num-2
				}else {
					if(startEventX > endEventX) {
						if(startEventX - endEventX <= setting.sliderWidth/2) num = (setting.endEventTime - setting.startEventTime<setting.sliderSpeed) ? num : num-1;
					}else if(endEventX > startEventX) {
						if((endEventX - startEventX) <= setting.sliderWidth/2) num = (setting.endEventTime - setting.startEventTime<setting.sliderSpeed) ? num-2 : num-1
						else num = num-2
					}
				}
				num = num<0 ? num + setting.sliderLength : num;
				return num;

				// When the dragging action has finished, calculate the multiple relationship between the relative displacement and the width of every slider or carousel.
				// Then, calculate how many items shoulde be moved during the current dragging action and return the number of the moved items. Next, the sliderMethod execute the  the rest of actions. 
			}
		}else {
			if(startEventX > endEventX && endEventX>='0') {
				setting.currentMoveNum = Math.ceil(Math.abs(setting.sliderOffset/setting.sliderItemWidth));
				if((startEventX - endEventX) < setting.sliderItemWidth/2) {
					if(setting.endEventTime - setting.startEventTime < setting.sliderSpeed) return num;
					else {
						setting.sliderCov.find('.'+ setting.sliderItem).eq(0).animate({
							'margin-left': 0
						},setting.sliderPlayTimer, setting.sliderInterval, function(){
							setting.sliderDown = true;
							if(isTouch && setting.display) method.sliderAutoPlay(num,setting);
						})
					}
				}else return num;
			}else if(startEventX < endEventX && endEventX>='0') {
				setting.currentMoveNum = Math.ceil(Math.abs(setting.sliderOffset/setting.sliderItemWidth));
				setting.sliderBack = true;
				setting.sliderDragBack = true;
				if((endEventX - startEventX) < setting.sliderItemWidth/2) {
					if(setting.endEventTime - setting.startEventTime<setting.sliderSpeed) {
						setting.sliderOffset = endEventX - startEventX;
						num = setting.sliderCurrent - 1;
						num = num<0 ? num + setting.sliderLength : num;
						return num;
					}else {
						setting.sliderCov.find('.'+ setting.sliderItem).eq(0).animate({
							'margin-left': 0
						},setting.sliderPlayTimer, setting.sliderInterval, function(){
							setting.sliderBack = false;
							setting.sliderDown = true;
							if(isTouch && setting.display) method.sliderAutoPlay(num,setting);
						})
					}
				}else {
					setting.sliderOffset = endEventX - startEventX;
					num = setting.sliderCurrent - 1;
					num = num<0 ? num + setting.sliderLength : num;
					return num;
				}
			}else setting.sliderDown = true;
		}
	},
	
	// 5.2 When the default action is switching to right, calculate the offset value which happens when the mouse clicks up, and return the current moved unit number.
	returnRightMouseUpNum:function(elm, num, startEventX, endEventX, setting){
		if(!setting.sliderLoop){
			if(startEventX != endEventX && endEventX>=0) {
				if($(elm).index()==0){
					if(startEventX < endEventX){
						if((endEventX - startEventX) <= setting.sliderWidth/2) num = (setting.endEventTime - setting.startEventTime<setting.sliderSpeed) ? num : num-1;
					}else num = num-1;
				}else if($(elm).index() == setting.sliderLength-1){
					if(startEventX > endEventX){
						if((startEventX - endEventX) <= setting.sliderWidth/2) num = (setting.endEventTime - setting.startEventTime<setting.sliderSpeed) ? num-2 : num-1;
						else num = num-2;
					}else num = num-1;
				}else {
					if(startEventX > endEventX){
						if(startEventX - endEventX <= setting.sliderWidth/2) num = (setting.endEventTime - setting.startEventTime<setting.sliderSpeed) ? num-2 : num-1;
						else num = num-2
					}else if(endEventX > startEventX){
						if((endEventX - startEventX) <= setting.sliderWidth/2) num = (setting.endEventTime - setting.startEventTime<setting.sliderSpeed) ? num : num-1;
					}
				}
				num = num<0 ? num + setting.sliderLength : num;
				return num;
			}
		}else{
			if(startEventX > endEventX && endEventX>='0'){
				num = num < 0 ? setting.sliderLength + num : num;
				setting.sliderOffset = endEventX - startEventX;
				setting.sliderBack = true;
				if((startEventX - endEventX) < setting.sliderWidth/2){
					if(setting.endEventTime - setting.startEventTime<setting.sliderSpeed) return num-1;
					else{
						setting.sliderCov.find('.'+ setting.sliderItem).eq(0).animate({
							'margin-right': 0
						},setting.sliderPlayTimer, setting.sliderInterval,function(){
							setting.sliderDown = true;
							if(isTouch && setting.display) method.sliderAutoPlay(num,setting);
						})
					}
				}else return num-1;
			}else if(startEventX < endEventX && endEventX>='0'){
				if((endEventX - startEventX) < setting.sliderWidth/2){
					if(setting.endEventTime - setting.startEventTime<setting.sliderSpeed) return num;
					else{
						setting.sliderCov.find('.'+ setting.sliderItem).eq(0).animate({
							'margin-right': 0
						},setting.sliderPlayTimer, setting.sliderInterval,function(){
							setting.sliderDown = true;
							if(isTouch && setting.display) method.sliderAutoPlay(num,setting);
						})
					}
				}else return num;
			}else setting.sliderDown = true;
		}
	}
};