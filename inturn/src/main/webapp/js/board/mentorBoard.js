/**
 * 
 * @author 이슬기
 * @version 1.0
 * @since 2018.06.01
 * @see MentorBoard 관련 Jquery 및 JavaScript
 */
$(function(){
	$("#btn_mentorBoardForm").click(function(){
		location.href="mentorBoardForm.do";
	});
	
});

function viewMentorBoard(mb_num){
	var nowPage = $("#nowPage").val();
	var condition = $("#condition").val();
	var keyword = $("#keyword").val();
	if(condition==""){
		location.href="viewMentorBoard.do?mb_num="+mb_num+"&nowPage="+nowPage;
	} else {
		location.href="viewMentorBoard.do?mb_num="+mb_num+"&nowPage="+nowPage+"&condition="+condition+"&keyword="+keyword;
	}
}


