/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.31
 * @see 현재 검색결과로 보는 게시판보기에서 쓰여야 할 함수
 */
$(function(){
	/**
	 * 이전 게시글 버튼을 눌렀을 때, 검색된 게시판들 중에
	 * 이전 게시글이 없으면 해당 번호가 -1로 가져오기 때문에 
	 * -1이면 이전 게시글이 없다고 alert창을 띄우고 
	 * 그렇지 않으면 해당 게시글 보기로 이동
	 */
	$("#prevBtn").click(function(){
		if($("#prevfb_num").val() == -1)
			alert("이전 게시글이 없습니다.");
		else
			location.href="/viewSCFreeBoard.do?condition="+$("#condition").val()+"&search="+$("#search").val()+"&fb_num="+$("#prevfb_num").val()+"&thisPage="+$("#thisPage").val();
	});
	/**
	 * 다음 게시글 버튼을 눌렀을 때, 검색된 게시판들 중에
	 * 다음 게시글이 없으면 해당 번호가 -1로 가져오기 때문에 
	 * -1이면 다음 게시글이 없다고 alert창을 띄우고 
	 * 그렇지 않으면 해당 게시글 보기로 이동
	 */
	$("#nextBtn").click(function(){
		if($("#nextfb_num").val() == -1)
			alert("다음 게시글이 없습니다.");
		else
			location.href="/viewSCFreeBoard.do?condition="+$("#condition").val()+"&search="+$("#search").val()+"&fb_num="+$("#nextfb_num").val()+"&thisPage="+$("#thisPage").val();
	});
	/**
	 * 목록 버튼을 눌렀을 때, 검색했던 게시판 목록을 보여준다.
	 * 해당 게시판으로 들어오기 전에, 게시판 페이징 번호를 thisPage로 가져왔다가
	 * 그 값을 통해 다시 들어오기 전의 상황과 똑같은 페이지를 보게끔 한다.
	 */
	$("#listBtn").click(function(){
		location.href="/searchFreeBoard.do?condition="+$("#condition").val()+"&search="+$("#search").val()+"&page_num="+$("#thisPage").val();
	});
	/**
	 * 게시판 수정 후, 목록을 눌러 돌아간다면 기억하고 있어야 하므로 thisPage를 가져가서 계속 그 값을 유지한다.
	 * 수정버튼을 눌렀을 때, 게시판 수정 페이지로 이동하는 함수 
	 */
	$("#modifyBtn").click(function(){
		location.href="/modifySCFreeBoard.do?condition="+$("#condition").val()+"&search="+$("#search").val()+"&fb_num="+$("#fb_num").val()+"&thisPage="+$("#thisPage").val();
	});
	/**
	 * 삭제버튼을 눌렀을 때, 게시판을 삭제하는 함수
	 * 게시글 삭제 후 리스트로 돌아가야하므로, 이전에 보고있던 게시판 페이징번호로 이동
	 */
	$("#deleteBtn").click(function(){
		var execute = confirm("정말 삭제하시겠습니까?");
		if(execute)
			location.href="/deleteSCFreeBoard.do?condition="+$("#condition").val()+"&search="+$("#search").val()+"&fb_num="+$("#fb_num").val()+"&thisPage="+$("#thisPage").val();
	});
})