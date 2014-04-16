<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
Title:
${article['title']}<br />
Cover:
<c:if test="${not empty article['coverPath']}">
	<img src="/dormitory/upload/images/articleCover/${article['id']}/${article['coverPath']}" /><br />
</c:if>
<br />
<hr />
<br />
${article['textBody']}
</body>
</html>