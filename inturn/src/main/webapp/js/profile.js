$(function() {
	// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
	var floatPosition = parseInt($("#sidenav").css('top'));
	// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

	$(window).scroll(function() {
		var scrollTop = $(window).scrollTop(); // 현재 스크롤 위치를 가져온다.
		var scrollEnd = $(document).height() - $(window).height();
		var newPosition = scrollTop + floatPosition + "px";
		var footer = $('#fh5co-footer');
		if (scrollTop == scrollEnd-footer.height()) {
			$("#sidenav").stop().animate({
				"top" : scrollEnd-footer.height()+"px"
			}, {
				'duration' : 500,
				'easing' : 'easeInOutCubic'
			});
		} else {
			$("#sidenav").stop().animate({
				"top" : newPosition
			}, 500);
			$("#sidenav").stop().animate({
				"top" : newPosition
			}, {
				'duration' : 500,
				'easing' : 'easeInOutCubic',
				'complete' : function() {
					console.log('이동 완료하였습니다.');
					console.log(scrollTop);
				}
			});
		}
	}).scroll();
	
});

/**
 * 자기소개 항목을 클릭할 때
 * 
 * @returns
 */
function formIntroductionClick() {
	var tag = '';
	tag += '<div id="introduction" class="card">';
	tag += '<h3>자기소개</h3>';
	tag += '</div>';
	$("#leftcolumn").append(tag);
}
