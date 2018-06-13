/**
 * 
 * @author 이슬기
 * @version 1.0
 * @since 2018.06.01
 * @see MentorBoard view 관련 JQuery 및 JavaScript
 */

$(function(){
	var mb_num = $("#mb_num").val();
	var nowPage = $("#nowPage").val();
	var condition = $("#condition").val();
	var keyword = $("#keyword").val();
	var prevMb_num = $("#prevMb_num").val();
	var nextMb_num = $("#nextMb_num").val();
//	var edu = $("#edu").val();
//	var career = $("#career").val();
//	var certificate = $("#certificate").val();
//	var num = 0;
	
	
	if($("#prevMb_num").val() == -1){
		$("#btn_prevMentorBoard").hide();
	}
	
	if($("#nextMb_num").val()==-1){
		$("#btn_nextMentorBoard").hide();
	}
	
		

	if ($("#edu").val() == "true") {
		$.ajax({
			url : "getUserEduLvl.do",
			method : "POST",
			type : "JSON",
			data : {
				"id" : $("#writerID").val()
			},
			success : function(data) {
				if (data.result == "success") {
					setEduLvlList(data);
					$("#link_profile").show();
					$("#mb_edu").show();
				} else {
					console.log("edu : " + data.result);
				}
			}
		});
	}

	if ($("#career").val() == "true") {
		$.ajax({
			url : "getUserCareer.do",
			method : "POST",
			type : "JSON",
			data : {
				"id" : $("#writerID").val()
			},
			success : function(data) {
				if (data.result == "success") {
					setCareerList(data);
					$("#link_profile").show();
					$("#mb_career").show();
				} else {
					console.log("career : " + data.result);
				}
			}
		});
	}

	if ($("#certificate").val() == "true") {
		$.ajax({
			url : "getCertificates.do",
			method : "POST",
			type : "JSON",
			data : {
				"id" : $("#writerID").val()
			},
			success : function(data) {
				if (data.result == "success") {
					setCertificateList(data);
					$("#link_profile").show();
					$("#mb_certificate").show();
				} else {
					console.log("certificate : " + data.result);
				}
			}
		});
	}
	
	$("#link_profile").click(function(){
		$(".modal").modal("show");
	});
	
	$("#btn_prevMentorBoard").click(function(){
		if(condition==""){
			location.href="viewMentorBoard.do?mb_num="+prevMb_num+"&nowPage="+nowPage;
		} else {
			location.href="viewMentorBoard.do?mb_num="+prevMb_num+"&nowPage="+nowPage+"&condition="+condition+"&keyword="+keyword;
		}
	});
	
	$("#btn_nextMentorBoard").click(function(){
		if(condition==""){
			location.href="viewMentorBoard.do?mb_num="+nextMb_num+"&nowPage="+nowPage;
		} else {
			location.href="viewMentorBoard.do?mb_num="+nextMb_num+"&nowPage="+nowPage+"&condition="+condition+"&keyword="+keyword;
		}
	});
	
	$("#btn_mentorBoardList").click(function(){
		if(condition==""){
			location.href="mentorBoard.do?nowPage="+nowPage;	
		} else {
			location.href="mentorBoard.do?nowPage="+nowPage+"&condition="+condition+"&keyword="+keyword;
		}
	});
	
	$("#btn_modifyMentorBoardForm").click(function(){
		if(condition==""){
			location.href="modifyMentorBoardForm.do?mb_num="+mb_num+"&nowPage="+nowPage;
		} else {
			location.href="modifyMentorBoardForm.do?mb_num="+mb_num+"&nowPage="+nowPage+"&condition="+condition+"&keyword="+keyword;
		}
		
	});
	
	$("#btn_deleteMentorBoard").click(function(){
		if(confirm("삭제 후 복구할 수 없습니다. 삭제하시겠습니까?")){
			$.ajax({
				url: "deleteMentorBoard.do",
				method: "POST",
				type: "JSON",
				data: {
					"mb_num" : mb_num
				},
				success: function(data){
					if(data.result == "success"){
						alert("삭제를 완료했습니다.");
						location.href="mentorBoard.do";
					} else {
						alert(data.result);
					}
				}
			});
		}
	});
	
});

function setEduLvlList(data) {
	var title = '<h5><strong>학력사항</strong></h5>';
	var a = '';
	$("#mb_edu").empty();
	
	for (var i = 0; i < data.eduLvlList.length; i++) {
		a += '<div id="box_edu' + data.eduLvlList[i].eduLevel_num + '" class="box_edu">';
		a += '<b>학교명&nbsp;&nbsp;:&nbsp;&nbsp;' + data.eduLvlList[i].school_name + '&nbsp;&nbsp;(' + data.eduLvlList[i].current_status +')</b><br/>';
		a += '입학일&nbsp;&nbsp;:&nbsp;&nbsp;' + data.eduLvlList[i].admission_date + '&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;졸업일&nbsp;&nbsp;:&nbsp;&nbsp;' + data.eduLvlList[i].graduation_date + '<br/>';
		a += '전공 &nbsp;&nbsp;:&nbsp;&nbsp;' + data.eduLvlList[i].major + '<br/>';
		a += '학점&nbsp;&nbsp;:&nbsp;&nbsp;' + data.eduLvlList[i].avg_score + ' / '+ data.eduLvlList[i].total_score;
		a += '</div>';
	}
	
	$("#mb_edu").append(title);
	$("#mb_edu").append(a);
}

function setCareerList(data){
	var title = '<h5><strong>경력</strong></h5>';
	var a = '';
	
	$("#mb_career").empty();
	
	for(var i = 0 ; i < data.careerList.length ; i++){
		a += '<div id="box_career'+ data.careerList[i].num +'" class="box_career">';
		a += '<b>회사명&nbsp;&nbsp;:&nbsp;&nbsp;' + data.careerList[i].company_num + '</b><br/>';
		a += '부서명&nbsp;&nbsp;:&nbsp;&nbsp;' + data.careerList[i].dept_name + '&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;직급/직책&nbsp;&nbsp;:&nbsp;&nbsp;' + data.jobList[i].position + '<br/>';
		a += '직무&nbsp;&nbsp;:&nbsp;&nbsp;' + data.jobList[i].duty + '&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;세부직무&nbsp;&nbsp;:&nbsp;&nbsp;' + data.jobList[i].kinds + '<br/>';
		a += '입사일&nbsp;&nbsp;:&nbsp;&nbsp;' + data.careerList[i].indate + '&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;퇴사일&nbsp;&nbsp;:&nbsp;&nbsp;' + data.careerList[i].outdate + '<br/>';
		a += '</div>';
	}
	
	$("#mb_career").append(title);
	$("#mb_career").append(a);
}

function setCertificateList(data){
	var title = '<h5><strong>자격증</strong></h5>';
	var a = '';
	
	$("#mb_certificate").empty();
	
	for(var i = 0 ; i < data.list.length ; i++){
		a += '<div id="box_certificate'+ data.list[i].certificate_num +'" class="box_certificate">';
		a += '<b>자격증명&nbsp;&nbsp;:&nbsp;&nbsp;'+ data.list[i].certificate_name +'</b><br/>';
		a += '취득일&nbsp;&nbsp;:&nbsp;&nbsp;'+ data.list[i].acquisition_date +'<br/>';
		a += '발급기관&nbsp;&nbsp;:&nbsp;&nbsp;'+ data.list[i].published_by_license +'<br/>';
		a += '등록번호&nbsp;&nbsp;:&nbsp;&nbsp;'+ data.list[i].certificate_num +'<br/>';
		a += '</div>';
	}
	
	$("#mb_certificate").append(title);
	$("#mb_certificate").append(a);
}

