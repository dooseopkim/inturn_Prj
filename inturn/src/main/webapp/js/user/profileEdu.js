/**
 * 
 */
$(function(){
	/**
	 * 학력사항 카드에서 추가 관련 function
	 */
	$("#btn_addSchool").click(function(){
		$("#box_addEducation").show();
		$("#school_name").focus();
	});
	
	$("#btn_cancelAddEducation").click(function(){
		if(confirm("현재 페이지에서 나가시겠습니까? 변경사항이 저장되지 않을 수 있습니다.")){
			$("#box_addEducation").hide();
		}
	});
	
	$("#school_name").click(function(){
		$("#schoolModal").modal("show");
		$("#gubun").val("high_list");
		gubunChange();
		getSchoolList();
	});
	
	$("#btn_schoolModal").click(function(){
		var degreeLvl = $("#sch :selected").text();
		$("#school_name").val($("#schoolName").val());
		$("#degree_level").val(degreeLvl);
		
		$("#schoolModal").modal("hide");
	});
	
	$("#btn_addEducation").click(function(){
		if($("#school_name").val()==""){
			alert("학교명을 입력하세요.");
			$("#school_name").focus();
			return false;
		} else if($("#admission_date").val()==""){
			alert("입학일을 입력하세요.");
			$("#admission_date").focus();
			return false;
		} else if($("#graduation_date").val()==""){
			alert("졸업일을 입력하세요.");
			$("#graduation_date").focus();
			return false;
		} else if($("#major").val()==""){
			alert("전공을 입력하세요.");
			$("#major").focus();
			return false;
		} else if($("#avg_score").val()==""){
			alert("학점을 입력하세요.");
			$("#avg_score").focus();
			return false;
		}
		
		$.ajax({
			url: "addProfileEdu.do",
			method: "POST",
			type: "JSON",
			data: {
				"degree_level" : $("#degree_level").val(),
				"school_name" : $("#school_name").val(),
				"admission_date" : $("#admission_date").val(),
				"graduation_date" : $("#graduation_date").val(),
				"current_status" : $("#current_status").val(),
				"major" : $("#major").val(),
				"avg_score" : $("#avg_score").val(),
				"total_score" : $("#total_score").val()
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