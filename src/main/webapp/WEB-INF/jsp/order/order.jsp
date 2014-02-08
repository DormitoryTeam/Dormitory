<html5>
<body>
	<hr />
	results: ${results}
	<hr />
	<form action="/dormitory/order/unit-test/order">
		OrderType:
		<select name="orderType">
			<option value="DORMITORY">Dormitory</option>
			<option value="PICKUP">Pick up</option>
		</select>
		<input type="submit" value="RandomOrder!" />
	</form>
		result: ${result}
	<hr />
</body>
</html5>