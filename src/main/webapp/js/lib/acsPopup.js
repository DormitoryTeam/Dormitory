$.extend($.fn, {
    acsPopup: function() {
        acsPopup.init.apply(this, arguments);
    }
});

var acsPopup = $.extend({}, {
    init: function(options, node) {
        var setting = $.extend(true, {
            maxWidth: 800,
            maxHeight: 500,
            initWidth: 600,
            initHeight: 460,
            popupMargin: 10,
            realWidth: '',
            realHeight: '',
            scrollTop: 0,
            popupMethod: '',
            popupCloseText: '',
            popupTitle: '',
            popupSrc: '',
            popupLayerTitle: 'popupTitle',
            popupLayerCov: 'popupCov',
            popupLayerContent: 'popupContent',
            popupLayerBg: 'popupLayerBg',
            popupLayerClose: 'popupClose',
            popupScroll: false,
            popupDrag: true,
            imgRegex: /\.(gif|png|jp(e|g|eg)|bmp|ico)((#|\?).*)?$/i
        }, options);
        if (!node)
            node = this;
        return $(node).each(function() {
            acsPopup.drawPopup(setting);
            if (setting.layerDrew) {
                acsPopup.popupPosition(setting);
                acsPopup.loadLayerSrc(setting);
                $(window).resize(function() {
                    acsPopup.popupPosition(setting, 'resize');
                });
            }
        });
    },
    
    drawPopup: function(setting) {
        var layerTitle = setting.popupTitle ? setting.popupTitle : 'No description', 
        errorMsg = '<h4>Not Found</h4><div>the requested image was not found on this server</div>';
        var container = "<div class='" + setting.popupLayerBg + "'></div>";
        container += "<div class='" + setting.popupLayerCov + "'>";
        container += "<div class='" + setting.popupLayerTitle + "'>";
        container += "<span></span>";
        container += "<a href='javascript:void(0)' class='" + setting.popupLayerClose + "'></a>";
        container += "</div>";
        container += "<div class='" + setting.popupLayerContent + "'>";
        container += "</div>";
        container += "</div>";
        if (!setting.layerDrew) {
            $('body').append(container);
            setting.layerDrew = true;
        }
    },
    
    popupPosition: function(setting, isResize) {
        if (setting.popupScroll)
            $('html').css('overflow', 'hidden');
        var bodyHeight = $(window).height(), 
        bodyWidth = $(window).width();
        setting.scrollTop = document.all ? document.documentElement.scrollTop : $(document).scrollTop();
        if (isResize) {
            $('.' + setting.popupLayerCov).css({
                'width': setting.realW + setting.conMarginX + setting.covBorderX + setting.covPaddingX,
                'height': setting.realH + setting.conMarginY + setting.covBorderY + setting.covPaddingY + setting.titleHeight,
                "left": bodyWidth - setting.realW - setting.conMarginX - setting.covBorderX - setting.covPaddingX < 0 ? 0 : (bodyWidth - setting.realW - setting.conMarginX - setting.covBorderX - setting.covPaddingX) / 2,
                "top": bodyHeight - setting.realH - setting.conMarginY - setting.covBorderY - setting.covPaddingY - setting.titleHeight < 0 ? parseInt(setting.scrollTop) : (bodyHeight - setting.realH - setting.conMarginY - setting.covBorderY - setting.covPaddingY - setting.titleHeight) / 2 + parseInt(setting.scrollTop)
            })
        } else {
            $('.' + setting.popupLayerCov).css({
                'width': setting.initWidth,
                'height': setting.initHeight,
                "left": (bodyWidth - setting.initWidth) / 2,
                "top": bodyHeight > setting.initHeight ? (bodyHeight - setting.initHeight) / 2 + setting.scrollTop : setting.scrollTop,
                "opacity": '0'
            })
        }
    },
    
    loadLayerSrc: function(setting) {
        $('.' + setting.popupLayerTitle + ' span').html(setting.popupTitle);
        $('.' + setting.popupLayerClose).html(setting.popupCloseText)
        if (acsPopup.isImage(setting)) {
            newImg = new Image();
            $(newImg).appendTo("." + setting.popupLayerContent);
            newImg.onload = function() {
                isLoad = true;
                newImg.src = setting.popupSrc;
                acsPopup.setPopupSize(setting);
                acsPopup.bindEvent(setting);
            }
        } else {
            $.ajax({
                url: setting.popupSrc,
                success: function(str) {
                    $("." + setting.popupLayerContent).html(str);
                    acsPopup.setPopupSize(setting);
                    acsPopup.bindEvent(setting);
                }
            })
        }
    },
    
    setPopupSize: function(setting, isreSize) {
        var bodyHeight = $(window).height(), 
        bodyWidth = $(window).width(), 
        popupCov = $('.' + setting.popupLayerCov), 
        popupCon = $('.' + setting.popupLayerContent), 
        popupTitle = $('.' + setting.popupLayerTitle), 
        height = popupCon.children(":first").height(), 
        width = popupCon.children(":first").width();
        setting.scrollTop = document.all ? document.documentElement.scrollTop : $(document).scrollTop();
        setting.covBorderX = (isNaN(parseInt(popupCov.css('border-left-width'))) ? 0 : parseInt(popupCov.css('border-left-width'))) + 
        (isNaN(parseInt(popupCov.css('border-right-width'))) ? 0 : parseInt(popupCov.css('border-right-width'))), 
        setting.covBorderY = (isNaN(parseInt(popupCov.css('border-top-width'))) ? 0 : parseInt(popupCov.css('border-top-width'))) + 
        (isNaN(parseInt(popupCov.css('border-bottom-width'))) ? 0 : parseInt(popupCov.css('border-bottom-width'))), 
        setting.covPaddingX = parseInt(popupCov.css('padding-left')) + parseInt(popupCov.css('padding-right')), 
        setting.covPaddingY = parseInt(popupCov.css('padding-top')) + parseInt(popupCov.css('padding-bottom')), 
        setting.conMarginX = parseInt(popupCon.css('margin-left')) + parseInt(popupCon.css('margin-right')), 
        setting.conMarginY = parseInt(popupCon.css('margin-top')) + parseInt(popupCon.css('margin-bottom')), 
        setting.titleHeight = parseInt(popupTitle.height()) + 
        (isNaN(parseInt(popupTitle.css('border-top-width'))) ? 0 : parseInt(popupTitle.css('border-top-width'))) + 
        (isNaN(parseInt(popupTitle.css('border-bottom-width'))) ? 0 : parseInt(popupTitle.css('border-bottom-width'))) + 
        parseInt(popupTitle.css('padding-top')) + 
        parseInt(popupTitle.css('padding-bottom')) + 
        parseInt(popupTitle.css('margin-top')) + 
        parseInt(popupTitle.css('margin-bottom'));
        setting.realH = !setting.realHeight ? (height > setting.maxHeight ? setting.maxHeight : height) : parseInt(setting.realHeight);
        setting.realW = !setting.realWidth ? (width > setting.maxWidth ? setting.maxWidth : width) : parseInt(setting.realWidth);
        if (setting.popupMethod.toLowerCase() == 'fade') {
            popupCov.css({
                'width': setting.realW + setting.conMarginX + setting.covBorderX + setting.covPaddingX,
                'height': setting.realH + setting.conMarginY + setting.covBorderY + setting.covPaddingY + setting.titleHeight,
                "left": bodyWidth - setting.realW - setting.conMarginX - setting.covBorderX - setting.covPaddingX < 0 ? 0 : (bodyWidth - setting.realW - setting.conMarginX - setting.covBorderX - setting.covPaddingX) / 2,
                "top": bodyHeight - setting.realH - setting.conMarginY - setting.covBorderY - setting.covPaddingY - setting.titleHeight < 0 ? parseInt(setting.scrollTop) : (bodyHeight - setting.realH - setting.conMarginY - setting.covBorderY - setting.covPaddingY - setting.titleHeight) / 2 + parseInt(setting.scrollTop)
            });
            
            popupCov.animate({
                "opacity": '1'
            }, 300, function() {
                acsPopup.setCovSize(setting);
                if (setting.afterSetPosition)
                    $.extend({}, setting).afterSetPosition(setting);
            });
        } else {
            popupCov.animate({
                'width': setting.realW + setting.conMarginX + setting.covBorderX + setting.covPaddingX,
                'height': setting.realH + setting.conMarginY + setting.covBorderY + setting.covPaddingY + setting.titleHeight,
                "left": bodyWidth - setting.realW - setting.conMarginX - setting.covBorderX - setting.covPaddingX < 0 ? 0 : (bodyWidth - setting.realW - setting.conMarginX - setting.covBorderX - setting.covPaddingX) / 2,
                "top": bodyHeight - setting.realH - setting.conMarginY - setting.covBorderY - setting.covPaddingY - setting.titleHeight < 0 ? parseInt(setting.scrollTop) : (bodyHeight - setting.realH - setting.conMarginY - setting.covBorderY - setting.covPaddingY - setting.titleHeight) / 2 + parseInt(setting.scrollTop),
                "opacity": '1'
            }, 300, function() {
                acsPopup.setCovSize(setting);
                if (setting.afterSetPosition)
                    $.extend({}, setting).afterSetPosition(setting);
            });
        }
    },
    
    setCovSize: function(setting) {
        $('.' + setting.popupLayerContent).css({
            'width': setting.realW,
            'height': setting.realH
        })
    },
    
    bindEvent: function(setting) {
        if (setting.callBack)
            $.extend({}, setting).callBack(setting);
        
        $('.' + setting.popupLayerClose).unbind('click').bind('click', function() {
            acsPopup.popupLayerClose(setting);
        });
        
        $('.' + setting.popupLayerBg).unbind('click').bind('click', function() {
            acsPopup.popupLayerClose(setting);
        });
        if (setting.popupDrag) {
            $('.' + setting.popupLayerTitle).unbind('mousedown').bind('mousedown', function(e) {
                acsPopup.popupDown(e, setting);
            });
            
            $(document).unbind('mousemove').bind('mousemove', function(e) {
                if (setting.blocked) {
                    if (document.selection)
                        !document.selection.empty ? document.selection = null : document.selection.empty();
                    else if (window.getSelection)
                        window.getSelection().removeAllRanges();
                    acsPopup.popupMove(e, setting);
                }
            });
            
            $(document).unbind('mouseup').bind('mouseup', function(e) {
                setting.blocked = false;
            })
        }
        ;
    },
    
    popupLayerClose: function(setting) {
        $('.' + setting.popupLayerBg).animate({
            "opacity": '0'
        }, 500, function() {
            $(this).detach();
        });
        
        $('.' + setting.popupLayerCov).animate({
            "opacity": '0'
        }, 500, function() {
            $(this).detach();
            if (setting.popupScroll)
                $('html').css('overflow', '');
            setting.layerDrew = false;
        });
    },
    
    popupDown: function(e, setting) {
        var realObj = e.target
        while (realObj && !$(realObj).hasClass(setting.popupLayerTitle) && !$(realObj).hasClass(setting.popupLayerClose)) {
            realObj = realObj.parentNode
        }
        if ($(realObj).hasClass(setting.popupLayerTitle)) {
            setting.blocked = true;
            setting.popupContainer = $('.' + setting.popupLayerCov);
            setting.floatLeft = parseInt(setting.popupContainer.position().left) - e.pageX;
            setting.floatTop = parseInt(setting.popupContainer.position().top) - e.pageY;
        }
    },
    
    popupMove: function(e, setting) {
        var scrollY = document.all ? document.documentElement.scrollTop : $(document).scrollTop(), 
        scrollX = document.all ? document.documentElement.scrollLeft : $(document).scrollLeft(), 
        left = setting.floatLeft + e.pageX, 
        top = setting.floatTop + e.pageY, 
        bodyInnerHeight = $(window).height(), 
        bodyInnerWidth = $(window).width();
        acsCommon.setBrowserInfo();
        if (isIe8) {
            left = setting.floatLeft + e.pageX + scrollX;
            top = setting.floatTop + e.pageY + scrollY;
        }
        if (left <= setting.popupMargin + scrollX) {
            left = setting.popupMargin + scrollX;
        } else if (left >= bodyInnerWidth - setting.popupContainer.width() - setting.popupMargin + scrollX) {
            left = bodyInnerWidth - setting.popupContainer.width() - setting.popupMargin + scrollX
        }
        if (top <= setting.popupMargin + scrollY)
            top = setting.popupMargin + scrollY;
        else if (top >= bodyInnerHeight - setting.popupContainer.height() - setting.popupMargin + scrollY) {
            top = bodyInnerHeight - setting.popupContainer.height() - setting.popupMargin + scrollY
        }
        if (setting.blocked) {
            setting.popupContainer.css({
                'left': left,
                'top': top
            })
        }
    },
    
    isImage: function(setting) {
        return setting.imgRegex.test(setting.layerSrc);
    }
})
