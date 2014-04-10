/**
 * @author frankjin
 * @Description this file is the JS to render json object from server on page.
 * @modify 1.0
 */

jQuery.json = {

	/** **************************** public ***************************** */

	/**
	 * @Description use $(selector).val() method.
	 */
	elementTypesForVal : [ "INPUT" ],

	/**
	 * @Description use $(selector).text() method.
	 */
	elementTypesForText : [ "SPAN", "P", "DIV" ],

	/**
	 * @Description render json object from server on page.
	 * @Param url
	 *            url for ajax request from server
	 * @Param postRenderJson
	 *            callback for you to customize your code
	 * @Param param
	 *            parameter for ajax request
	 * @Param selectors
	 *            mappings for elements on page to keys in json, for example:
	 *            {"selector": ".skuId", "dataMappings":[{"value": "skuId"}]},
	 *            {"selector": ".heroImage",
	 *            "dataMappings":[{"alt":"imgDesc"},{"src":"heroImagePath"}]}.
	 *            If there is not selectors, use property name of object in json
	 *            as default selector to find element of html and update it with
	 *            property value of object.
	 * 
	 * @modify 1.0
	 */
	renderJson : function(url, param, postRenderJson, selectors) {
		$.ajax({
			url : url,
			data : param,
			type : "post",
			dataType : "json",
			success : function(data) {
				$.json.renderReturnedJsonObject(data, selectors);
				postRenderJson.call(this, data);
			}
		});
	},

	/**
	 * @Description get value from json object
	 * 
	 * @modify 1.0
	 */
	getValueByAttribute : function(json, attribute) {
		if (!json || !attribute) {
			return undefined;
		}
		for ( var propertyName in json) {
			var propertyValue = json[propertyName];
			var typeOfValue = typeof (propertyValue);
			if (typeOfValue === "object") {
				$.json.getValueByAttribute(json, attribute);
			} else if (propertyName === attribute) {
				return propertyValue;
			}
		}
	},

	/**
	 * @Description you should overwrite this default callback to do your work
	 *              after renderJson.
	 * 
	 * @modify 1.0
	 */
	postRenderJson : function(data) {
		// alert(data);
	},

	/** **************************** private ***************************** */

	/**
	 * @Description render json object on page.
	 * 
	 * @modify 1.0
	 */
	renderReturnedJsonObject : function(json, selectors) {

		if (!json) {
			return;
		}

		if (selectors == undefined) {
			$.json.renderJsonByDefault(json);
		} else {
			$.json.renderJsonBySelectors(json, selectors);
		}
	},

	/**
	 * @Description when there is no selectors, use property name of object in
	 *              json to find element of html and update it with property
	 *              value of object.
	 * 
	 * @modify 1.0
	 */
	renderJsonByDefault : function(json) {

		if (!json) {
			return;
		}
		for ( var propertyName in json) {
			if (propertyName == undefined) {
				continue;
			}
			var propertyValue = json[propertyName];
			var typeOfValue = typeof (propertyValue);
			if (typeOfValue === "function" || typeOfValue == undefined) {
				continue;
			}
			if (typeOfValue === "object") {
				$.json.renderJsonByDefault(propertyValue);
			} else {
				// find selector by property name
				var selector = $.json.findSelector(propertyName);
				if (selector == undefined || selector.length == 0) {
					continue;
				}
				// alert(selector + "" + propertyValue);
				$.json.updateValueOfElement(selector, propertyValue);
			}
		}

	},

	/**
	 * @Description Find jquery selector by propertyName. Firstly find class
	 *              selector, if not find id selector.
	 * @modify 1.0
	 */
	findSelector : function(propertyName) {
		if (!propertyName) {
			return undefined;
		}
		var classSelector = "." + propertyName;
		var selector = $(classSelector);
		if (selector.length == 0) {
			var idSelector = "#" + propertyName;
			return $(idSelector);
		} else {
			return selector;
		}
	},

	/**
	 * @Description update value of html element by selector.
	 * 
	 * @modify 1.0
	 */
	updateValueOfElement : function(selector, value) {
		if (selector == undefined || value == undefined) {
			return;
		}
		var elementType = selector[0].nodeName;

		// handle with val() method
		for ( var i = 0; i < $.json.elementTypesForVal.length; i++) {
			var elementTypeForVal = $.json.elementTypesForVal[i];
			if (elementType === elementTypeForVal) {
				selector.val(value);
				return;
			}
		}
		// handle with text() method
		for ( var i = 0; i < $.json.elementTypesForText.length; i++) {
			var elementTypeForText = $.json.elementTypesForText[i];
			if (elementType === elementTypeForText) {
				selector.text(value);
				return;
			}
		}
		// handle with attr() method for 'img', 'a', etc.
		switch (elementType) {
		case "IMG":
			selector.attr("src", value);
			return;
		case "A":
			selector.attr("href", value);
			return;
		}

		// unknown type, handle with text() method
		selector.text(value);
	},

	/**
	 * @Description render json object on page by selector.
	 * 
	 * @modify 1.0
	 */
	renderJsonBySelectors : function(json, selectors) {
		if (!json || !selectors) {
			return undefined;
		}
		// iterate to update every field on page
		for ( var selectorIndex in selectors) {
			if (selectorIndex == undefined) {
				continue;
			}
			var selectorObject = selectors[selectorIndex];
			var dataMappings = selectorObject["dataMappings"];
			if (!dataMappings) {
				continue;
			}
			var jquerySelector = $(selectorObject.selector);
			if (jquerySelector == undefined || jquerySelector.length == 0) {
				continue;
			}
			$.json.updateValueByDataMappings(json, jquerySelector, dataMappings);
		}
	},

	updateValueByDataMappings : function(json, jquerySelector, dataMappings) {
		for ( var i = 0; i < dataMappings.length; i++) {
			var dataMap = dataMappings[i];
			for ( var key in dataMap) {
				var attribute = dataMap[key];
				if (key == undefined || attribute == undefined) {
					continue;
				}

				var value = $.json.getValueByAttribute(json, attribute);
				if (value == undefined) {
					continue;
				}
				$.json.updateValueOfElement(jquerySelector, value);
			}
		}
	}
};