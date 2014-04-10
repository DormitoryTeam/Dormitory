/**
	* Copyright(c) 2013 AAXIS ecommerce store
	* Interaction effect
	* Date: 2013/03/13
	* http://acs.com/ 
	*
	* 1 Automatic switching action.
	* 2 When automatic switching action has finished, the default setting is restored and entering the next switching action.
	* 3 The methods is  executed for different switching action.
		* 3.1 The switching left action.
		* 3.2 The switching right action.
		* 3.3 The switching up action.
		* 3.4 The switching down action.
		* 3.5 Then fading out action, fading in action and other actions.
 */

var method = {
	
	// 1 Automatic switching action.
	sliderAutoPlay: function(num, setting, timer){
		timer = !timer ? setting.sliderTimer : timer;
		if(setting.display){
			if(setting.sliderProgress){
				setting.sliderAutoPlay = false;
				setting.sliderProgressElm.animate({
					'width': '100%'
				}, timer, function(){
					setting.sliderAutoPlay = true;
					if(setting.sliderTimeBak){
						setting.sliderTimer = setting.sliderTimeBak;
					}
					return method.sliderMethod(num, setting)
				})
			}else {
				clearTimeout(setting.sliderAuto);
				setting.sliderAuto = setTimeout(function(){
					method.sliderMethod(num, setting)
				},timer)
			};
		}
		
	},
	
	// 2 When automatic switching action has finished, the default setting is restored and entering the next switching action.
	sliderMoveAction: function(num,setting){
		if(setting.sliderProgress) setting.sliderProgressElm.css('width','0');
		setting.sliderOffset = 0;
		if(setting.beforePlay){
			$.extend({}, setting).beforePlay(setting.sliderCov, setting);
		}
		setting.sliderMove = setTimeout(function(){
			if(setting.afterPlay){
				$.extend({}, setting).afterPlay(setting.sliderCov, setting);
			}
			if(isTouch && setting.display){
				method.sliderAutoPlay(num,setting);
			}
			if(setting.sliderAutoPlay){
				method.sliderAutoPlay(num,setting);
			}
			setting.sliderDown = true;
		}, setting.sliderPlayTimer, function(){});
	},
	
	// 3 The methods is  executed for different switching action.
	sliderMethod: function(num, setting){
		setting.sliderDown = false;
		setting.sliderCov.find('.'+ setting.sliderItem).eq(0).stop(false,false);
		clearTimeout(setting.sliderAuto);
		if(!setting.sliderBack) num = (num >= setting.sliderLength-1) ? 0 : num+1;
		setting.sliderCov.find('.'+setting.sliderPagerCov).children().removeClass(setting.sliderPageActive);
		setting.sliderCov.find('.'+setting.sliderPagerCov).children().eq(num).addClass(setting.sliderPageActive);
		var numDiffer = num - setting.sliderCurrent + setting.currentMoveNum - 1;
		numDiffer = (numDiffer<0) ? numDiffer + setting.sliderLength : numDiffer;
		if(setting.sliderMethod.toLowerCase() == 'left'){
			method.slideLeft(num, numDiffer, setting)
			
		}else if(setting.sliderMethod.toLowerCase() == 'right'){
			method.slideRight(num, numDiffer, setting)
			
		}else if(setting.sliderMethod.toLowerCase() == 'up'){
			method.slideUp(num, numDiffer, setting)
			
		}else if(setting.sliderMethod.toLowerCase() == 'down'){
			method.slideDown(num, numDiffer, setting)
			
		}else{
			method.otherEffect(num, numDiffer, setting)
		}
		setting.sliderCurrent = num;
		setting.startItemNum = num + 1;
		setting.endItemNum = num + setting.sliderPerPageSize;
		method.sliderMoveAction(num,setting);
		if(setting.callBack) $.extend({}, setting).callBack(setting.sliderContainer, setting);
	},
	
	// 3.1 The switching left action.
	slideLeft: function(num, numDiffer, setting){
		if(setting.sliderLoop){
			
			// The methods is executed when the switching action loops.
			var realLength = setting.sliderCov.find('.'+ setting.sliderItem).length;
			if(setting.sliderBack){
				
				// When the prevbutton is clicked, the reverse action is executed. After the reverse action has finished, the direction of switching action is set as forward.
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0).css('margin-left',0)
				if(setting.sliderDragBack){
					
					// When the current reverse action is that the relative displacement of mouse is dragged to reverse direction 
					// and the current reverse action has finished, reset the judging condition of the reverse dragging 
					// and set the direction of the switching action as forward.
					for(i=realLength; i>realLength - setting.currentMoveNum; i--){
						setting.sliderCov.find('.'+ setting.sliderItem).eq(0).before(setting.sliderCov.find('.'+ setting.sliderItem).eq(realLength - 1))
					}
					setting.sliderCov.find('.'+ setting.sliderItem).eq(0).css('margin-left', setting.sliderOffset - setting.sliderItemWidth*setting.currentMoveNum);
					setting.sliderCov.find('.'+ setting.sliderItem).eq(0).animate({
						'margin-left': 0
					},setting.sliderPlayTimer, setting.sliderInterval, function(){
						setting.sliderDown = true;
						setting.sliderBack = false;
						setting.sliderDragBack = false;
					})
				}else{
					
					// When the current reverse action is not that the relative displacement of mouse is dragged to reverse direction 
					// but the prevbutton is clicked, then, after the current reverse action has finished, set the direction of the switching action as forward.  
					for(i=realLength,j=1; i>realLength - setting.currentMoveNum; i--,j++){
						setting.sliderCov.find('.'+ setting.sliderItem).eq(0).before(setting.sliderCov.find('.'+ setting.sliderItem).eq(realLength - 1))
						setting.sliderCov.find('.'+ setting.sliderItem).eq(0).css('margin-left', setting.sliderOffset - setting.sliderItemWidth*j);
					}
					setting.sliderCov.find('.'+ setting.sliderItem).each(function(){
						if($(this).index() < setting.currentMoveNum){
							$(this).animate({
								'margin-left': 0
							},setting.sliderPlayTimer, setting.sliderInterval, function(){
								setting.sliderDown = true;
								setting.sliderBack = false;
							})
						}
					})
				}
			}else {
				
				// When the nextbutton or the pager is clicked, and the direction of the dragging is forward, the forward action is executed.
				setting.sliderCov.find('.'+ setting.sliderItem).each(function(){
					if($(this).index()<numDiffer){
						$(this).animate({
							'margin-left': setting.sliderItemWidth*($(this).index() - numDiffer)
						},setting.sliderPlayTimer, setting.sliderInterval, function(){
							setting.sliderDown = true;
							$(this).css('margin-left',0)
								.appendTo(setting.sliderCov.find('.'+ setting.sliderItem).parent());
						})
					}
				})
			}
		}else {

			// The method is executed when the setting does not loop.
			setting.sliderCov.find('> .'+ setting.sliderItem).parent().stop().animate({
				'left': -num * setting.sliderItemWidth
			},setting.sliderPlayTimer, setting.sliderInterval, function(){
				setting.sliderDown = true;
				setting.sliderBack = false;
			})
		}
	},
	
	// 3.2 The switching right action.
	slideRight: function(num, numDiffer, setting){
		if(setting.sliderLoop){
			var realLength = setting.sliderCov.find('.'+ setting.sliderItem).length;
			if(setting.sliderBack){
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0).css('margin-right',0)
				setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength*2-1).css('margin-right', -setting.sliderWidth - setting.sliderOffset)
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0)
					.before(setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength*2-1))
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0).animate({
					'margin-right': 0
				},setting.sliderPlayTimer, setting.sliderInterval, function(){
					setting.sliderDown = true;
					setting.sliderBack = false;
				})
			}else {
				setting.sliderCov.find('.'+ setting.sliderItem).each(function(){
					if($(this).index()<numDiffer){
						$(this).animate({
							'margin-right': setting.sliderWidth*($(this).index() - numDiffer)
						},setting.sliderPlayTimer, setting.sliderInterval, function(){
							setting.sliderDown = true;
							setting.sliderCov.find('.'+ setting.sliderItem).eq(0).css('margin-right',0)
								.appendTo(setting.sliderCov.find('.'+ setting.sliderItem).parent());
						})
					}
				})
			}
		}else {
			setting.sliderCov.find('.'+ setting.sliderItem).parent().stop().animate({
				'left': (num-setting.sliderLength+1) * setting.sliderWidth
			},setting.sliderPlayTimer, setting.sliderInterval, function(){
				setting.sliderDown = true;
				setting.sliderBack = false;
			})
		}
	},
	
	// 3.3 The switching up action.
	slideUp: function(num, numDiffer, setting){
		if(setting.sliderLoop){
			if(setting.sliderBack){
				setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength*2-1).css('margin-top', -setting.sliderHeight)
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0)
					.before(setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength*2-1))
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0).animate({
					'margin-top': 0
				},setting.sliderPlayTimer, 'easeOutExpo',function(){
					setting.sliderDown = true;
					setting.sliderBack = false;
				})						
			}else {
				setting.sliderCov.find('.'+ setting.sliderItem).each(function(){
					if($(this).index()<numDiffer){
						$(this).animate({
							'margin-top': setting.sliderHeight*($(this).index() - numDiffer)
						},setting.sliderPlayTimer, setting.sliderInterval, function(){
							setting.sliderDown = true;
							setting.sliderCov.find('.'+ setting.sliderItem).eq(0).css('margin-top',0)
								.appendTo(setting.sliderCov.find('.'+ setting.sliderItem).parent());
						})
					}
				})
			}
		}else {
			if(setting.sliderCov.find('.'+ setting.sliderItem).parent().css("position") != 'absolute'){
				setting.sliderCov.find('.'+ setting.sliderItem).parent().animate({
					'margin-top': -num * setting.sliderItemHeight
				},setting.sliderPlayTimer, setting.sliderInterval, function(){
					setting.sliderDown = true;
					setting.sliderBack = false;
				})
			}else{
				setting.sliderCov.find('.'+ setting.sliderItem).parent().stop().animate({
					'top': -num * setting.sliderItemHeight
				},setting.sliderPlayTimer, setting.sliderInterval, function(){
					setting.sliderDown = true;
					setting.sliderBack = false;
				})
			}
		}
	},
	
	// 3.4 The switching down action.
	slideDown: function(num, numDiffer, setting){
		if(setting.sliderLoop){
			if(setting.sliderBack){
				setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength*2-1).css('top', setting.sliderHeight*(setting.sliderLength*2-2))
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0)
					.before(setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength*2-1))
				setting.sliderCov.find('.'+ setting.sliderItem).each(function(){
					$(this).animate({
						'top': setting.sliderHeight*(setting.sliderLength*2-$(this).index()-1)
					},setting.sliderPlayTimer, setting.sliderInterval, function(){
						setting.sliderDown = true;
					})
				})
				setting.sliderBack = false;
			}else {
				setting.sliderCov.find('.'+ setting.sliderItem).each(function(){
					$(this).animate({
						'top': parseInt($(this).css('top')) + setting.sliderHeight*(numDiffer)
					},setting.sliderPlayTimer, setting.sliderInterval,function(){
						setting.sliderDown = true;
						if(parseInt($(this).css('top'))>=(setting.sliderLength)*(setting.sliderHeight*2)){
							$(this).css('top',(parseInt($(this).css('top'))-(setting.sliderLength)*(setting.sliderHeight*2)))
								.appendTo(setting.sliderCov.find('.'+ setting.sliderItem).parent());
						}	
					})
				})
			}
		}else {
			setting.sliderCov.find('.'+ setting.sliderItem).parent().stop().animate({
				'top': -num * setting.sliderItemHeight
			},setting.sliderPlayTimer, setting.sliderInterval, function(){
				setting.sliderDown = true;
				setting.sliderBack = false;
			})
		}	
	},
	
	// 3.5 Then fading out action, fading in action and other actions.
	otherEffect: function(num, numDiffer, setting){
		setting.sliderCov.find('.'+ setting.sliderItem).css('opacity','0');
		setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength-1).css('opacity','1');
		if(setting.sliderBack){
			setting.sliderCov.find('.'+ setting.sliderItem).eq(0)
				.before(setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength-1))
		}else {
			for(i=0;i<setting.sliderLength-numDiffer;i++){
				setting.sliderCov.find('.'+ setting.sliderItem).eq(0)
					.before(setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength-1));
			}
		}
		setting.sliderCov.find('.'+ setting.sliderItem).eq(setting.sliderLength-1).animate({
			'opacity':'1'
		},setting.sliderPlayTimer, 'swing', function(){
			setting.sliderDown = true;
		})
		setting.sliderBack = false;
	}
}