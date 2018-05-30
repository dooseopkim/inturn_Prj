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
			resetboxAddEdu();
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
					resetboxAddEdu();
					$("#box_addEducation").hide();
				} else {
					alert(data.result);
				}
			}
		});
	});
	
	function resetboxAddEdu(){
		$("#school_name").val("");
		$("#degree_level").val("");
		$("#admission_date").val("");
		$("#graduation_date").val("");
		$("#current_status").val("졸업");
		$("#major").val("");
		$("#avg_score").val("");
		$("#total_score").val("4.5");
		
	}
});

/**
 * 학력 항목을 클릭할 때
 * 
 * @returns
 */
//function formEducationClick() {
//	if ($("#education").is(':visible')) {
//		$("#education").hide();
//	} else {
//		$.ajax({
//			url : "getUserEduLvl.do",
//			method : "POST",
//			type : "JSON",
//			data : {},
//			success : function(data){
//				if(data.result == "success"){
//					console.log("성공");
//					$("#getUserEdu").load("jsp/profileGetUserEdu.jsp");
//					$("#education").show();
//				} else {
//					alert(data.result);
//				}
//			}
//		});
//	}
//}

function formEducationClick() {
	var a = '';
	if ($("#education").is(':visible')) {
		$("#education").hide();
	} else {
		$.ajax({
			url : "getUserEduLvl.do",
			method : "POST",
			type : "JSON",
			data : {},
			success : function(data){
				if(data.result == "success"){
					console.log("성공");
					$("#getUserEdu").load("jsp/profileGetUserEdu.jsp");
					$("#education").show();
				} else {
					alert(data.result);
				}
			}
		});
	}
}

function chkDelete(){
	if(confirm("삭제 후 복구할 수 없습니다. 삭제하시겠습니까?")){
		return true;
	}else {
		return false;
	}
}
