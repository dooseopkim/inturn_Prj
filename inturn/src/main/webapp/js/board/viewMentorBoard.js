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
	
	if($("#prevMb_num").val() == -1){
		$("#btn_prevMentorBoard").hide();
	}
	if($("#nextMb_num").val()==-1){
		$("#btn_nextMentorBoard").hide();
	}
	
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

