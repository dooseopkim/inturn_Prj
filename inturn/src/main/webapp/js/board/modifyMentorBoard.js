/**
 * 
 * @author 이슬기
 * @version 1.0
 * @since 2018.06.01
 * @see MentorBoard modify 관련 JQuery 및 JavaScript
 */

$(function() {
	//전역변수
	var obj = [];
	//스마트에디터 프레임생성
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : obj,
		elPlaceHolder : "editor",
		sSkinURI : "resources/editor/SmartEditor2Skin.html",
		htParams : {
			// 툴바 사용 여부
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부
			bUseModeChanger : true,
		}
	});
	
	$("#title").focus();
	
	$("#title").keydown(function(e) {
		if (e.keyCode === 13) {
			obj.getById["editor"].exec("FOCUS");
		} 
	});
	
	//전송버튼
	$("#btn_modifyMentorBoard").click(function() {
		if($("#title").val() == '') {
			alert("제목을 입력해주세요");
			return false;
		}
		//id가 smarteditor인 textarea에 에디터에서 대입
		obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
		//폼 submit
		$("#modifyMentorBoardFrm").submit();
	});
	
	$("#btn_cancelMentorBoard").click(function() {
		if(confirm("게시글 작성을 취소하시겠습니까?")){
			var mb_num = $("#mb_num").val();
			var nowPage = $("#nowPage").val();
			var condition = $("#condition").val();
			var keyword = $("#keyword").val();
			if(condition==""){
				location.href="viewMentorBoard.do?mb_num="+mb_num+"&nowPage="+nowPage;
			} else {
				location.href="viewMentorBoard.do?mb_num="+mb_num+"&nowPage="+nowPage+"&condition="+condition+"&keyword="+keyword;
			}
		}
	});
	
});