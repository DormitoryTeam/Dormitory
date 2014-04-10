/**
	* Copyright(c) 2013 AAXIS ecommerce store
	* Tabs function
	* Date: 2013/03/13
	* http://acs.com/ 
	*
	* 1 Initialize tab and reset the default choose of the tabControl. 
	* 2 Get the corresponding key and value which was stored in cookie.
	* 3 Get the serialization key and value which was stored in cookie.
	* 4 When the other TabControl is clicked, delete the current cookie about the tab.
 */

$.extend($.fn, {
	acsTabs: function() {
		acsTabs.init.apply(this, arguments);
	}
});

var acsTabs = {
	
	/**
	 * Initialize the change tab.
	 * 
	 * Explain the setting parameters,
	 * 
	 * tabTitle         the navigation area of the TabControl.
	 * tabContent	    the content area.
	 * tabItem          the style of the content area corresponding to the every tabControl.
	 * tabTitleActive   the choosen tabControl.
	 * currentNum       the index value of the choosen tabControl.
	 * showClass        the default value, when a tabControl was choosen, the corresponding content add the style to show.  
	 * cookieName       get the value, according to the key which was stored in cookie. 
	 */
	init: function(options, node) {
		var setting = $.extend(true, {
			tabTitle:'tabTitle',
			tabContent:'tabContent',
			tabItem: 'tabItem',
			tabUnit: 'tabUnit',
			tabTitleActive: 'active',
			currentNum: 0,
			showClass: 'show',
			cookieName: 'currentTab'
		}, options||{});
		if(!node) node = this;
		
		return $(node).each(function() {
			setting.cov = $(this),
			setting.title = $(this).find('.' + setting.tabTitle).find('.' + setting.tabUnit);
			setting.content = $(this).find('.' + setting.tabContent);
			setting.items = $(this).find('.' + setting.tabContent).find('.' + setting.tabItem);
			var cookieValue = acsTabs.getTabIndex(setting.cookieName);
			if(cookieValue) setting.currentNum = $(this).find('.' + setting.tabTitle).find('.'+cookieValue).index();
			acsTabs.resetStatus(setting);
			
			setting.title.bind('click', function(){
				setting.currentNum = $(this).index();
				acsTabs.resetStatus(setting);
				acsTabs.delCookie(setting.cookieName);
			})
		});
	},
	
	// 1 Initialize tab and reset the default choose of the tabControl.
	resetStatus: function(setting){
		$(setting.title).removeClass(setting.tabTitleActive);
		$(setting.title).eq(setting.currentNum).addClass(setting.tabTitleActive);
		$(setting.items).removeClass(setting.showClass);
		$(setting.items).eq(setting.currentNum).addClass(setting.showClass);
	},
	
	/*
	 * 2 Get the corresponding key and value which was stored in cookie.
	 *   When the rating target is clicked, skip to current tab position, and set the rating content and corresponding tabControl to active status.
	 *   For example, if the string 'current = rating' was stored in the cookie, the returned value is rating.
	 */
	getTabIndex: function(name){
		var string = name + "=", stringLength = string.length, cookieLength = document.cookie.length
		var i = 0;
		while (i < cookieLength){
			var j = i + stringLength;
			if (document.cookie.substring(i, j) == string) return acsTabs.getCookieVal(j);
			i = document.cookie.indexOf(" ", i) + 1;
			if (i == 0) break;
		}
		return null;
	},
	
	// 3 Get the serialization key and value which was stored in cookie.
	getCookieVal: function(num){
		var endstr = document.cookie.indexOf (";", num);
		if (endstr == -1) endstr = document.cookie.length;
		return unescape(document.cookie.substring(num, endstr));
	},
	
	// 4 When the other TabControl is clicked, delete the current cookie about the tab.
	delCookie: function(name){
		var exp = new Date();
		exp.setTime(exp.getTime() - 1);
		var cookieValue = acsTabs.getCookieVal(name);
		if(cookieValue!=null) document.cookie= name + "="+cookieValue+";expires="+exp.toGMTString();
	}
}