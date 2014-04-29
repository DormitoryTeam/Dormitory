
<c:if test="${not page.firstPage}">
<a <c:if test="${'myaccount' eq param.pageName}">style="background-color: #32b16c;"</c:if> href="?pageSize=${page.pageSize}&currentPage=1&${page.queryString}">首页</a>&nbsp;&nbsp;<a <c:if test="${'myaccount' eq param.pageName}">style="background-color: #32b16c;"</c:if>  href="?pageSize=${page.pageSize}&currentPage=${page.prePage}&${page.queryString}">上一页</a>
</c:if>
第${page.pageNum}页
&nbsp;&nbsp;共 ${page.maxPageNum}页
<c:if test="${not page.lastPage}">
&nbsp;&nbsp;<a <c:if test="${'myaccount' eq param.pageName}">style="background-color: #32b16c;"</c:if>  href="?pageSize=${page.pageSize}&currentPage=${page.nextPage}&${page.queryString}">下一页</a>&nbsp;&nbsp;<a <c:if test="${'myaccount' eq param.pageName}">style="background-color: #32b16c;"</c:if>  href="?pageSize=${page.pageSize}&currentPage=${page.maxPageNum}&${page.queryString}">末页</a>
</c:if>&nbsp;&nbsp;
