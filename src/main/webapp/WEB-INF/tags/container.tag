<!doctype html>
<%@attribute name="template"%>
<head>
<%
    String ctx = request.getContextPath();
%>
<meta charset="utf-8">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0" name="viewport">
<link rel="stylesheet" href="<%=ctx%>/style/all.css" />
<link rel="stylesheet" href="<%=ctx%>/style/page/${template}.css">
<script>
	var baseUrl = "<%=ctx%>/js/";
</script>
<script src="<%=ctx%>/js/vendor/modernizr.custom.33292.js"></script>
<script src="<%=ctx%>/js/vendor/require.js" data-main="<%=ctx%>/js/pages/${template}"></script>
<script src="<%=ctx%>/js/vendor/jquery-1.10.2.min.js" data-main="<%=ctx%>/js/pages/${template}"></script>
<!--[if lt IE 9]>
	<link rel="stylesheet" href="<%=ctx%>/css/hostel/ie.css">
<![endif]-->
<style>
  .scroll-pane { overflow: auto; width: 99%; float:left; }
  .scroll-content { width: 2440px; float: left; }
  .scroll-content-item { width: 100px; height: 100px; float: left; margin: 10px; font-size: 3em; line-height: 96px; text-align: center; }
  .scroll-bar-wrap { clear: left; padding: 0 4px 0 2px; margin: 0 -1px -1px -1px; }
  .scroll-bar-wrap .ui-slider { background: none; border:0; height: 2em; margin: 0 auto;  }
  .scroll-bar-wrap .ui-handle-helper-parent { position: relative; width: 100%; height: 100%; margin: 0 auto; }
  .scroll-bar-wrap .ui-slider-handle { top:.2em; height: 1.5em; }
  .scroll-bar-wrap .ui-slider-handle .ui-icon { margin: -8px auto 0; position: relative; top: 50%; }
  </style>
<title>Hostel-Mockup</title>
</head>
<body>
	<div id="wrapper" class="${template}">
		<jsp:doBody />
	</div>
</body>
</html>