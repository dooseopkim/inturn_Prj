/**
 * 
 */
$(function(){
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