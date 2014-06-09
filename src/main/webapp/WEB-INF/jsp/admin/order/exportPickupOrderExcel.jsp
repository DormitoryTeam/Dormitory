
<form action="<c:url value='/admin/excel/exportPickUpExcel.html'/>" method="POST">
	<table>
		<tr>
			<td>下单时间:</td>
			<td><input type="text" name="dateFrom" value="" />到<input type="text" name="dateTo" value="" /></td>
		</tr>
		<tr>
			<td>订单状态:</td>
			<td><select name="status">
					<option value="">所有</option>
					<option value="INITIAL">等待用户完成订单</option>
					<option value="COMMIT">已提交,等待审核</option>
					<option value="REVIEWDE">审核完成，已发送付款邮件</option>
					<option value="PAYMENT_DONE">已支付，已发送车票邮件</option>
					<option value="PAYMENT_NOT_DONE">未支付，已发送车票邮件</option>
			</select></td>
		</tr>
		<tr>
			<td><input type="submit" value="下载"</td>
			<td><input type="button" value="返回" onclick="window.location.href='<c:url value="/admin/site/admin-navigation.html"/>'" /></td>
		</tr>
	</table>
</form>
