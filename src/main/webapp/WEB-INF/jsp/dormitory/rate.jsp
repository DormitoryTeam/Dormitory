<html5>
<body>
	<h2>=>Rating: ${avgRate}</h2>
	<hr />
	<form action="/dormitory/dormitory/unit-test/rate">
		Dormitory Id:<input type="text" name="dormitoryId" value="${dormitoryId}" />
		User Id:<input type="text" name="userId" value="${userId}" />
		Rate:<input type="text" name="point" />
		<input type="submit" value="Rate!" />
	</form>
</body>
</html5>