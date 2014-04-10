/**
	* Copyright(c) 2013 AAXIS ecommerce store
	* Append plots
	* Date: 2013/03/13
	* http://acs.com/ 
	*
	* 1 Drawing element.
		* 1.1 Drawing scroll bar.
		* 1.2 Drawing paging.
		* 1.3 Drawing button.
		*  
	* 2 the operation of the progress bar.
		* 2.1 Reset the progress bar.
		* 2.2 Restart the progress bar.
 */

var drawGadget = {
	
	// 1.1 Drawing scroll bar.
	setProgressClass:function(setting){
		if(setting.sliderProgress){
			setting.sliderContainer.append("<div class='"+ setting.sliderProgressClass +"'><span></span></div>");
			setting.sliderProgressElm = setting.sliderContainer.find('.'+setting.sliderProgressClass+' span');
		}
	},
	
	// 1.2 Drawing paging.
	setPager:function(setting){
		if(setting.sliderPager && setting.sliderLength > Math.round(setting.sliderWidth/setting.sliderItemWidth)){
			var pagers = "";
			for(i=1;i<setting.sliderLength / Math.round(setting.sliderWidth/setting.sliderItemWidth)+1;i++){
				if(!setting.sliderPagerMethod) pagers += '<a></a>';
				else{
					if(setting.sliderPagerMethod.toLowerCase() == 'num') pagers += '<a>'+ i +'</a>';
					else if(setting.sliderPagerMethod.toLowerCase() == 'graphic'){
						var imgSrc = setting.sliderContainer.find('.'+ setting.sliderItem).eq(i-1).find('var').attr('pager');
						if(!imgSrc) imgSrc = setting.sliderContainer.find('.'+ setting.sliderItem).eq(i-1).find('img:first').attr('src');
						if(imgSrc) pager += '<a><img src="'+ imgSrc +'" border="0"></a>';	
						else pagers += '<a>'+ i +'</a>';
					}
				}
			}
			setting.sliderContainer.find("." + setting.sliderPagerCov).detach();
			setting.sliderContainer.append("<div class= '"+ setting.sliderPagerCov +"'>" + pagers + "</div>");
			setting.sliderContainer.find('.'+setting.sliderPagerCov).children().eq(setting.currentPager).addClass(setting.sliderPageActive);
		}
	},
	
	// 1.3 Drawing button.
	setButton: function(setting,sliderLength) {
		var button = "", result= false;
		if(setting.renderBtn){
			setting.sliderContainer.find('.' + setting.sliderButtonCov).detach();
		}
		
		if(setting.sliderMethod.toLowerCase() == 'up' || setting.sliderMethod.toLowerCase() == 'down' && 
			setting.sliderLength > Math.round(setting.sliderHeight/setting.sliderItemHeight)){
			result = true;
		}else if(setting.sliderLength > Math.round(setting.sliderWidth/setting.sliderItemWidth)){
			result = true;
		}
		
		if(result){
			if(setting.sliderButton){
				if(setting.renderBtn){
					button = "<div class= '"+ setting.sliderButtonCov +"'><a class='"+ setting.sliderButtonPrev +"'></a><a class = '"+ setting.sliderButtonNext +"'></a></div>";
					setting.sliderContainer.append(button);
				}
			}
		}else{
			setting.sliderContainer.find("." + setting.sliderButtonCov +" a").addClass('disabled');
		}
	},
	
	
	/**
	 *  2.1 Reset the progress bar.
	 *      The method is executed when the new switching action start.
	 *      For example, the progress bar become zero, when the button is clicked, the paging is clicked, or the dragging action has finished.
	 */
	resetProgress: function(setting) {
		if(setting.sliderProgress){
			setting.sliderProgressElm.stop(false, false);
			setting.sliderProgressElm.css('width','0');
		}
	},
	
	// 2.2 Restart the progress bar.
	restartProgress: function() {
		if(setting.sliderProgress){
			setting.sliderProgressElm.animate({
				'width': '100%'
			},setting.sliderTimer,function(){
				setting.sliderAutoPlay = true;
				if(setting.sliderTimeBak){
					setting.sliderTimer = setting.sliderTimeBak;
				}
				return method.sliderMethod(num, setting)
			})
		}
	}
};