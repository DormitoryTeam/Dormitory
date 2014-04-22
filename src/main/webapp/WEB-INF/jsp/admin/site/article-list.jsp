<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<a href="/dormitory/admin/site/article-add-or-update.html">create new article</a>
	<hr />
	<ul>
		<c:forEach var="article" items="${articleTitles}">
			<li><a href="/dormitory/admin/site/article-add-or-update.html?id=${article['id']}">${article['title']}</a></li>
		</c:forEach>
	</ul>
</body>
</html>