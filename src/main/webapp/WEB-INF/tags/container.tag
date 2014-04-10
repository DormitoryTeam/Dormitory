<!doctype html>
<head>
<% String ctx = request.getContextPath()+"/www.static.war" ; %>
<meta charset="utf-8"> 
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0" name="viewport">
<link rel="stylesheet" href="<%=ctx%>/css/all.min.css"/>
<link rel="stylesheet" href="<%=ctx%>/css/page/<%= request.getParameter("template") %>.css" >
<script>
	var baseUrl ="../www.static.war/javascript";
</script>
<script src="<%=ctx%>/javascript/vendor/modernizr.custom.33292.js"></script>
<script src="<%=ctx%>/javascript/vendor/require.js" data-main="<%=ctx%>/javascript/pages/<%= request.getParameter("template") %>"></script>
<!--[if lt IE 9]>
<link rel="stylesheet" href="<%=ctx%>/css/hostel/ie.css">
<![endif]-->
<title>Hostel-Mockup</title>
</head>
	<body>
		<div id="wrapper" class="<%= request.getParameter("template") %>">
					
			<jsp:doBody/>					

		</div>
	</body>
</html>