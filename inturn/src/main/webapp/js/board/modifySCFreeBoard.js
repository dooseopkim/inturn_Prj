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
	//전송버튼
	$("#modifyBoard").click(function() {
		if($("#title").val() == '') {
			alert("제목을 입력해주세요");
			return false;
		}

		//id가 smarteditor인 textarea에 에디터에서 대입
		obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
		//폼 submit
		$("#modifyBoardFrm").submit();
	});
	$("#cancelBtn").click(function() {
		var execute = confirm("게시글 작성을 취소하시겠습니까?");
		if(execute)
			location.href = "/viewSCFreeBoard.do?condition="+$("#condition").val()+"&search="+$("#search").val()+"&fb_num="+$("#fb_num").val()+"&thisPage="+$("#thisPage").val();
	});
});