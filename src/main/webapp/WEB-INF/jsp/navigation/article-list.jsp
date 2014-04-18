<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<ul>
		<c:forEach var="article" items="${articleTitles}">
			<li><a href="/dormitory/navigation/article-detail.html?id=${article['id']}&backURL=${pageContext['request']['contextPath']}${requestScope['javax.servlet.forward.servlet_path']}">${article['title']}</a></li>
		</c:forEach>
	</ul>
</body>
</html>