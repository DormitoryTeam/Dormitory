<!doctype html>
<%@attribute name="template"%>
<%@ tag pageEncoding="UTF-8"%> 
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
	var ctx = "<%=ctx%>";
</script>
<script src="<%=ctx%>/js/vendor/modernizr.custom.33292.js"></script>
<script src="<%=ctx%>/js/vendor/require.js" data-main="<%=ctx%>/js/pages/${template}"></script>
<script src="<%=ctx%>/js/vendor/jquery-1.10.2.min.js" data-main="<%=ctx%>/js/pages/${template}"></script>
<!--[if lt IE 9]>
	<link rel="stylesheet" href="<%=ctx%>/css/hostel/ie.css">
<![endif]-->
<title>英国留学生活服务-留学生活网(www.liuxuelife.com)</title>
</head>
<body>
	<div id="wrapper" class="${template}">
		<jsp:doBody />
	</div>
</body>
</html>