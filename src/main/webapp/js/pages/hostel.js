require(['config'], function(config) {
    require(['jquery', 'utils', 'raty', 'jQueryUI', 'jqueryTools', 'acsPopup', 'timepicker'], function($, utils, raty, jQueryUI, jqueryTools, acsPopup, timepicker) {
        $(function() {
            //init header
            utils.init();

            //scrollpane parts
            var scrollPane = $(".scroll-pane"), scrollContent = $(".scroll-content");

            scrollContent.css("width", $(".scroll-content  > .scroll-content-item.itme-header").length * 140);

			
			
			// build slider
			//console.log($(".scroll-pane").width());
			//console.log($(".scroll-content").width());
			var perPage = 140;
			var paneWidth = $(".scroll-pane").width()
			var contentWidth = $(".scroll-content").width();
			//console.log((contentWidth - paneWidth)/perPage);
			var totalPage = Math.ceil((contentWidth - paneWidth)/perPage);
			
			//console.log(totalPage);
			//var pageSize = (contentWidth - paneWidth) % perPage == 0 ?
			$( ".scroll-bar" ).slider({
			  range: "max",
			  min: 1,
			  max: totalPage,
			  value: 1,
			  slide: function( event, ui ) {
			    var left = 0 - perPage * (ui.value - 1);
				$(".scroll-content").css("margin-left", left + "px");
				//$( "#amount" ).val( ui.value );
			  }
			});
			/**
			139
			scroll-pane
			scroll-content 
            //build slider
            var scrollbar = $(".scroll-bar").slider({
                slide : function(event, ui) {
                    if (scrollContent.width() > scrollPane.width()) {
                        scrollContent.css("margin-left", Math.round(ui.value / 100 * (scrollPane.width() - scrollContent.width() )) + "px");
                    } else {
                        scrollContent.css("margin-left", 0);
                    }
                }
            });

            //append icon to handle
            var handleHelper = scrollbar.find(".ui-slider-handle").mousedown(function() {
                scrollbar.width(handleHelper.width());
            }).mouseup(function() {
                scrollbar.width("100%");
            }).append("<span class='ui-icon ui-icon-grip-dotted-vertical'></span>").wrap("<div class='ui-handle-helper-parent'></div>").parent();

            //change overflow to hidden now that slider handles the scrolling
            scrollPane.css("overflow", "hidden");

            //size scrollbar and handle proportionally to scroll distance
            function sizeScrollbar() {
                var remainder = scrollContent.width() - scrollPane.width();
                var proportion = remainder / scrollContent.width();
                var handleSize = scrollPane.width() - (proportion * scrollPane.width() );
                scrollbar.find(".ui-slider-handle").css({
                    width : handleSize,
                    "margin-left" : -handleSize / 2
                });
                handleHelper.width("").width(scrollbar.width() - handleSize);
            }

            //reset slider value based on scroll content position
            function resetValue() {
                var remainder = scrollPane.width() - scrollContent.width();
                var leftVal = scrollContent.css("margin-left") === "auto" ? 0 : parseInt(scrollContent.css("margin-left"));
                var percentage = Math.round(leftVal / remainder * 100);
                scrollbar.slider("value", percentage);
            }

            //if the slider is 100% and window gets larger, reveal content
            function reflowContent() {
                var showing = scrollContent.width() + parseInt(scrollContent.css("margin-left"), 10);
                var gap = scrollPane.width() - showing;
                if (gap > 0) {
                    scrollContent.css("margin-left", parseInt(scrollContent.css("margin-left"), 10) + gap);
                }
            }

            //change handle position on window resize
            $(window).resize(function() {
                resetValue();
                sizeScrollbar();
                reflowContent();
            });
            //init scrollbar size
            setTimeout(sizeScrollbar, 10);
            //safari wants a timeout
			*/

			$(".jQ-citylist").on('click', function(e){
				if($(this).parent().hasClass('open')){
					$(this).parent().siblings().removeClass('open').addClass('close');
					$(this).parent().removeClass('open').addClass('close');	
				}else{
					$(this).parent().siblings().removeClass('open').addClass('close');
					$(this).parent().removeClass('close').addClass('open');	
				}
				$(document).scrollTop($(this).offset().top);
			});

            $('.comment .starBox').raty({
                path : '../www.static.war/css/common',
                click : function(score, evt) {
                    //ID: $(this).attr('id')
                    //score:score
                    //event:evt
                }
            });

            $('.hostel-info .starBox').raty({
                path : '../style/img',
                readOnly : true,
                score : function() {
                    return $(this).attr('data-score');
                },
                click : function(score, evt) {
                    //ID: $(this).attr('id')
                    //score:score
                    //event:evt
                }
            });

            $('.house-score .starBox').raty({
                path : '../style/img',
                starOn : 'star-white-on.png',
                starOff : 'star-white-off.png',
                readOnly : true,
                score : function() {
                    return $(this).attr('data-score');
                },
                click : function(score, evt) {
                    //ID: $(this).attr('id')
                    //score:score
                    //event:evt
                }
            });

            $(".house-tabs").tabs();

            //$(".air-tab-personal").tabs();

            //$(".reservation-tab").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
            //$(".reservation-tab li").removeClass("ui-corner-top").addClass("ui-corner-left");

            $(".scrollable").scrollable();

            $(".items img").click(function() {
                if ($(this).hasClass("active")) {
                    return;
                }
                var url = $(this).attr("src").replace("_t", ""), wrap = $(".img-larger-content").fadeTo("medium", 0.5), img = new Image();

                img.onload = function() {
                    wrap.fadeTo("fast", 1);
                    wrap.find("img").attr("src", url);
                };

                img.src = url;

                $(".items img").removeClass("active");
                $(this).addClass("active");
            }).filter(":first").click();

            // bind datepicker
            var currentYear = new Date().getFullYear();
            $(".datepicker").datepicker({ 
                dateFormat: "yy-mm-dd",
                showMonthAfterYear:true,
                changeMonth: true,
                changeYear: true,
                yearRange: (currentYear-34) + ":" + currentYear
            });
            $(".datepicker").attr("readonly",true);
            $(".timepicker").datepicker({ 
                dateFormat: "yy-mm-dd",
                showMonthAfterYear:true,
                changeMonth: true,
                changeYear: true,
                duration: '',
	            showTime: true,
	            constrainInput: false,
	            time24h: true
            });
            $(".timepicker").attr("readonly",true);
            $('.jQ-loginbtn').on('click', function() {
				$(this).acsPopup({
					popupSrc : $(this).attr("data-popupSrc"),
					callBack : function() {
						$("#btnLoginSubmit").unbind('click').bind('click', function(e) {
							e.preventDefault();
							$(".errorMessage").html("&nbsp;");
							$.ajax({
								type : "POST",
								dataType : "json",
								url : ctx + "/user/asynLogin.html",
								data : {
									login : $("#iptLogin").val(),
									password : $("#iptPassword").val()
								},
								success : function(data) {
									if (data.result) {
										
										if (window.location.href.lastIndexOf('#') > 0) {
											window.location.href = window.location.href.substr(0, window.location.href.lastIndexOf('#')) + "&login=" + data.login
										} else {
											window.location.href = window.location.href + "&login=" + data.login;
										}
										
									} else {
										$(".errorMessage").html(data.message);
									}
								},
								error : function(e) {
									alert(e);
								}
							})
						});
					}
				});
			});
        });
    });
});