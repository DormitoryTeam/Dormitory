<c:if test="${not page.firstPage}">
<a href="?pageSize=${page.pageSize}&currentPage=1&${page.queryString}">首页</a>&nbsp;&nbsp;<a href="?pageSize=${page.pageSize}&currentPage=${page.prePage}&${page.queryString}">上一页</a>
</c:if>
第${page.pageNum}页
&nbsp;&nbsp;共 ${page.maxPageNum}页
<c:if test="${not page.lastPage}">
&nbsp;&nbsp;<a href="?pageSize=${page.pageSize}&currentPage=${page.nextPage}&${page.queryString}">下一页</a>&nbsp;&nbsp;<a href="?pageSize=${page.pageSize}&currentPage=${page.maxPageNum}&${page.queryString}">末页</a>
</c:if>&nbsp;&nbsp;
