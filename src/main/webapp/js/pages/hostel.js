require(['config'], function(config) {
    require(['jquery', 'utils', 'raty', 'jQueryUI', 'jqueryTools', 'acsPopup'], function($, utils, raty, jQueryUI, jqueryTools, acsPopup) {
        $(function() {
            //init header
            utils.init();

            //scrollpane parts
            var scrollPane = $(".scroll-pane"), scrollContent = $(".scroll-content");

            scrollContent.css("width", $(".scroll-content  > .scroll-content-item.itme-header").length * 140);

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

            $(".jQ-citylist").on('click', function() {
                $(this).parent().siblings().removeClass('open').addClass('close');
                $(this).parent().removeClass('close').addClass('open');
            })

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

            $('.jQ-quick').on('click', function() {
                var roomId = $(this).attr("roomId");
                $("#roomInfoId").val(roomId);

                $(this).acsPopup({
                    popupSrc : $(this).attr("data-popupSrc"),
                    callBack : function() {
                        var contracts = room_contracts[roomId];
                        for (var i in contracts) {
                            var bookHTML = '<option value="' + contracts[i].id + '">' + contracts[i].name + '</option>';
                            var bookDIV = $(bookHTML);
                            $("#selectContract").append(bookDIV);
                        }

                        $('select').simSelect();
                        $('.btnBook').on('click', function() {
                            var contractId = $("#selectContract").val();
                            $("#contractId").val(contractId);
                            $("#placeOrderForm").submit();
                        });
                    }
                });
            })
        });
    });
});