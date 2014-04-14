<!doctype html>
<head>
<%
    String ctx = request.getContextPath();
%>
<meta charset="utf-8">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0" name="viewport">
<link rel="stylesheet" href="<%=ctx%>/style/all.min.css" />
<link rel="stylesheet" href="<%=ctx%>/style/page/<%=request.getParameter("template")%>.css">
<script>
	var baseUrl = "<%=ctx%>";
</script>
<script src="<%=ctx%>/js/vendor/modernizr.custom.33292.js"></script>
<script src="<%=ctx%>/js/vendor/require.js" data-main="<%=ctx%>/js/pages/<%=request.getParameter("template")%>"></script>
<script src="<%=ctx%>/js/vendor/jquery-1.10.2.min.js" data-main="<%=ctx%>/js/pages/<%=request.getParameter("template")%>"></script>
<!--[if lt IE 9]>
	<link rel="stylesheet" href="<%=ctx%>/css/hostel/ie.css">
<![endif]-->
<title>Hostel-Mockup</title>
</head>
<body>
	<div id="wrapper" class="<%=request.getParameter("template")%>">
		<jsp:doBody />
	</div>
</body>
</html>