$(function() {
	$('#rate').raty({
		score : function() {
			return $(this).attr('data-score');
		},
		scoreName : 'point',
		cancel : true,
		cancelHint : 'My cancel hint!',
		path : '../style/img'
	});

	$('#dormitoryRate').raty({
		score : function() {
			return $(this).attr('data-score');
		},
		readOnly : true,
		path : '../style/img'
	});
});