/**
	* Copyright(c) 2013 AAXIS ecommerce store
	* Append plots
	* Date: 2013/03/13
	* http://acs.com/ 
	*
	* 1 Clicking event of element.
		* 1.1 The method is executed when the button element is clicked.
		* 1.2 The method is executed when the paging element is clicked.
		* 1.3 Drawing button. 
 */

var gadgets = {
	
	// 1.1 The method is executed when the button element is clicked.
	buttonClick: function(e, currentItem, obj, setting){
		e.preventDefault();
		
		if(setting.sliderDown){
			setting.sliderOffset = 0;
			realMoveNum = 0;
			setting.sliderDown = false;
			setting.currentMoveNum = setting.realMoveNum;
			if($(obj).hasClass(setting.sliderButtonPrev)){
				if(setting.sliderLoop){
					setting.sliderCurrent = setting.sliderCurrent<=0 ? setting.sliderLength-setting.realMoveNum : setting.sliderCurrent-setting.realMoveNum;
				}
				setting.sliderBack = true;
			}else if($(obj).hasClass(setting.sliderButtonNext)){
				setting.sliderBack = false;
			}
			if(!setting.sliderLoop){
				var num = setting.sliderPerPageSize;
				setting.currentMoveNum = setting.sliderPerPageSize;
				currentItem = setting.sliderCurrent;
				if(!setting.sliderBack){
					if(currentItem + num >= setting.sliderLength){
						realMoveNum = currentItem - 1;
					}else if(currentItem + num + setting.realMoveNum > setting.sliderLength){
						realMoveNum = setting.sliderLength - num - 1;
					}else{
						realMoveNum = currentItem + setting.realMoveNum -1;
					}
				}else{
					if(currentItem <= 0){
						realMoveNum = currentItem;
					}else if(currentItem < setting.realMoveNum){
						realMoveNum = 0;
					}else{
						realMoveNum = currentItem - setting.realMoveNum;
					}
				}
			}else {
				setting.currentMoveNum = setting.realMoveNum;	
				realMoveNum = setting.sliderCurrent;
			}
			drawGadget.resetProgress(setting);
			method.sliderMethod(realMoveNum,setting);
			return currentItem;
		}
		
	},
	

	// 1.2 The method is executed when the paging element is clicked.
	pageClick: function(e, obj, setting){
		e.preventDefault();
		var currentElm = e.target;
		while(currentElm && !$(currentElm).parent().hasClass(setting.sliderPagerCov)){
			currentElm = currentElm.parentNode;
		};
		currentItem = $(currentElm).index();
		setting.currentPager = currentItem;
		setting.currentMoveNum = Math.round(setting.sliderWidth/setting.sliderItemWidth);
		realMoveNum = 0;
		if(setting.sliderLength < (currentItem+1)*setting.currentMoveNum){
			realMoveNum = (currentItem+1)*setting.currentMoveNum - setting.sliderLength;
		}
		if(setting.sliderDown && setting.sliderLoop) {
			setting.sliderDown = false;
		}else{
			setting.sliderDown = true;	
		}
		drawGadget.resetProgress(setting);
		method.sliderMethod(currentItem*setting.currentMoveNum - realMoveNum -1,setting);
		return currentItem;
	}
};