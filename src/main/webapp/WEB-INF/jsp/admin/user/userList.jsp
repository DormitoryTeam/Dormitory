<form action="<c:url value='/admin/user/userList.html'/>" method="POST">
userName/ID: <input type="text" name="searchKey" value="${searchKey}"/><br>
group: <input type="text" name="groupId" value="${groupId}"/><br>
<input type="submit" value="Search"/>
</form>
<hr>
<table>
	<tr>
		<td>User Id</td>
		<td>User Name</td>
		<td>Group </td>
		<td>Action</td>
	</tr>
	<c:forEach var="user" items="${users}" varStatus="i">
	<tr>
		<td><a href="<c:url value='/admin/order/orderDetails.html?orderId=${order.id}&orderType=${type}'/>">${user.id}</a></td>
		<td>${user.login}</td>
		<td>${order.amount}</td>
		<td>Export</td>
	<tr>
	</c:forEach>
</table>