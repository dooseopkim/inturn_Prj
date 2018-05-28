$(function(){
	// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
	var floatPosition = parseInt($("#sidenav").css('top'));
	// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

	var bottom = parseInt($("#sidenav").css('bottom')); //스크롤 끝까지 내릴 때.... 더이상 안내려가게...

	$(window).scroll(function() {
		// 현재 스크롤 위치를 가져온다.
		var scrollTop = $(window).scrollTop();
		var scrollBottom = $(document).height() - $(window).height();
		var newPosition = scrollTop + floatPosition + "px";
		if (scrollTop > scrollBottom-292) {
			$("#sidenav").stop().animate({
				"top" : scrollBottom-18+"px"
			}, {
				'duration' : 500,
				'easing' : 'easeInOutCubic',
			});
		} else {
			/* $("#sidenav").stop().animate({
				"top" : newPosition
			}, 500); */
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
	
	
	/**
	 * 학력사항 카드에서 추가 관련 function
	 */
	$("#btn_addSchool").click(function(){
		$("#box_addEducation").show();
		$("#degree_level").focus();
	});
	
	$("#btn_cancelAddEducation").click(function(){
		if(confirm("현재 페이지에서 나가시겠습니까? 변경사항이 저장되지 않을 수 있습니다.")){
			$("#box_addEducation").hide();
		}
	});
	
	$("#school_name").click(function(){
		$("#schoolModal").modal("show");
		$("#gubun").val($("#degree_level").val());
		gubunChange();
		getSchoolList();
	});
	
	$("#btn_schoolModal").click(function(){
		$("#school_name").val($("#schoolName").val());
		$("#schoolModal").modal("hide");
	});
	
	
});
/**
 * 학력 항목을 클릭할 때
 * @returns
 */
function formEducationClick() {
	/*var tag = '';
	tag += '<div id="education" class="card">';
	tag += '<div class="row">';
	tag += '<div class="col-sm-6">';
	tag += '<h3>학력</h3>';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<input type="button" id="addSchool" value="추가">';
	tag += '<input type="button" id="deleteSchool" value="삭제">';
	tag += '</div>';
	tag += '</div>';
	tag += '<div id="schoolArea" class="row border border-info">';
	tag += '테스트';
	tag += '</div>';
	tag += '</div>';
	$("#leftcolumn").append(tag);*/
	$("#education").toggle(function(){
		$("#box_addEducation").hide();
	});
}

/**
 * 경력 항목을 클릭할 때
 * @returns
 */
function formCareerClick() {
	var tag = '';
	tag += '<div id="career" class="card">';
	tag += '<h3>경력</h3>';
	tag += '</div>';
	$("#leftcolumn").append(tag);
}

/**
 * 자격증 항목을 클릭할 때
 * @returns
 */
function formLicenseClick() {
	var tag = '';
	tag += '<div id="license" class="card">';
	tag += '<h3>자격증</h3>';
	tag += '</div>';
	$("#leftcolumn").append(tag);
}

/**
 * 자기소개 항목을 클릭할 때
 * @returns
 */
function formIntroductionClick() {
	var tag = '';
	tag += '<div id="introduction" class="card">';
	tag += '<h3>자기소개</h3>';
	tag += '</div>';
	$("#leftcolumn").append(tag);
}

