/**
 * 
 */
$(function(){
	/**
	 * 학력사항 카드에서 추가 관련 function
	 */
	$("#btn_addCareer").click(function(){
		$("#box_addCareer").show();
		$("#company_name2").focus();
	});
	
	$("#btn_cancelAddEducation").click(function(){
		if(confirm("현재 페이지에서 나가시겠습니까? 변경사항이 저장되지 않을 수 있습니다.")){
			$("#box_addEducation").hide();
		}
	});
	
	$("input[name=position]").click(function(){
		$("#positionModal").modal("show");
	});
	
	/**
	 * 직급/직책 모달에서 직접입력 선택 시
	 */
	$("#job_grade_etc021").click(function(){
			$("#job_text_input").attr("readonly",false);
	});

	/**
	 * 직급/직책 모달에서 프리랜서 선택 시
	 */
	$("#job_grade_etc020").click(function(){
		$("#job_text_input").attr("readonly",true);
	});
	
	/**
	 * 직급/직책 모달에서 초기화 버튼 클릭 시
	 */
	$("#clearBtn").click(function(){
		$("input:radio[name=job_grade]").removeAttr('checked');
		$("input:radio[name=job_duties]").removeAttr('checked');
	});
	
	$("#btn_schoolModal").click(function(){
		var degreeLvl = $("#sch :selected").text();
		$("#school_name").val($("#schoolName").val());
		$("#degree_level").val(degreeLvl);
		
		$("#schoolModal").modal("hide");
	});
	
	$("#addCareer").click(function(){
		if($("#company_name2").val()==""){
			alert("회사명을 입력하세요.");
			$("#company_name2").focus();
			return false;
		} else if($("#dept_name2").val()==""){
			alert("부서명을 입력하세요.");
			$("#dept_name2").focus();
			return false;
		} else if($("#indate2").val()==""){
			alert("입사년월을 입력하세요.");
			$("date2").focus();
			return false;
		} else if($("#outdate2").val()==""){
			alert("퇴사년월을 입력하세요.");
			$("#outdate2").focus();
			return false;
		} else if($("#position2").val()==""){
			alert("직급/직책을 입력하세요.");
			$("#position2").focus();
			return false;
		} else if($("#duty2").val()==""){
			alert("직무를 입력하세요.");
			$("#position2").focus();
			return false;
		} else if($("#kind2").val()==""){
			alert("상세직무를 입력하세요.");
			$("#position2").focus();
			return false;
		}
		
		$.ajax({
			url: "addProfileCareer.do",
			method: "POST",
			type: "JSON",
			data: {
				"company_name" : $("#company_name").val(),
				"dept_name" : $("#dept_name").val(),
				"indate" : $("#indate").val(),
				"outdate" : $("#outdate").val(),
				"position" : $("#position").val(),
				"duty" : $("#duty").val(),
				"kind" : $("#kind").val(),
			},
			success: function(data){
				if(data.result=="success"){
					alert("학력사항을 추가했습니다.");
				} else {
					alert(data.result);
				}
			}
				
			
		});
		
	});
//	$("#btn_addEducation").click(function(){
//		if($("#school_name").val()==""){
//			alert("학교명을 입력하세요.");
//			$("#school_name").focus();
//			return false;
//		} else if($("#admission_date").val()==""){
//			alert("입학일을 입력하세요.");
//			$("#admission_date").focus();
//			return false;
//		} else if($("#graduation_date").val()==""){
//			alert("졸업일을 입력하세요.");
//			$("#graduation_date").focus();
//			return false;
//		} else if($("#major").val()==""){
//			alert("전공을 입력하세요.");
//			$("#major").focus();
//			return false;
//		} else if($("#avg_score").val()==""){
//			alert("학점을 입력하세요.");
//			$("#avg_score").focus();
//			return false;
//		}
//		
//		$.ajax({
//			url: "addProfileEdu.do",
//			method: "POST",
//			type: "JSON",
//			data: {
//				"degree_level" : $("#degree_level").val(),
//				"school_name" : $("#school_name").val(),
//				"admission_date" : $("#admission_date").val(),
//				"graduation_date" : $("#graduation_date").val(),
//				"current_status" : $("#current_status").val(),
//				"major" : $("#major").val(),
//				"avg_score" : $("#avg_score").val(),
//				"total_score" : $("#total_score").val()
//			},
//			success: function(data){
//				if(data.result=="success"){
//					alert("학력사항을 추가했습니다.");
//				} else {
//					alert(data.result);
//				}
//			}
//				
//			
//		});
//		
//	});
});

/**
 * 사이드네비에서 경력 항목을 클릭할 때
 * @returns
 */
function formCareerClick() {
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
	$("#career").toggle(function(){
		$("#box_addCareer").hide();
		$('#company_name').focus();
	});
}