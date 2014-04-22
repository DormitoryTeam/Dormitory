<c:if test="${not page.firstPage}">
<a href="?pageSize=${page.pageSize}&currentPage=1&${page.queryString}">Fist</a>&nbsp;&nbsp;<a href="?pageSize=${page.pageSize}&currentPage=${page.prePage}&${page.queryString}">Pre</a>
</c:if>
Current Page:${page.pageNum}
&nbsp;&nbsp;Total Page: ${page.maxPageNum}
<c:if test="${not page.lastPage}">
&nbsp;&nbsp;<a href="?pageSize=${page.pageSize}&currentPage=${page.nextPage}&${page.queryString}">NEXT</a>&nbsp;&nbsp;<a href="?pageSize=${page.pageSize}&currentPage=${page.maxPageNum}&${page.queryString}">LAST</a>
</c:if>&nbsp;&nbsp;
