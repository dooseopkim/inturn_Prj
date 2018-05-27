$(function(){
	$("#prevBtn").click(function(){
		if($("#prevfb_num").val() == -1)
			alert("이전 게시글이 없습니다.");
		else
			location.href="/viewFreeBoard.do?fb_num="+$("#prevfb_num").val()+"&thisPage="+$("#thisPage").val();
	});
	$("#nextBtn").click(function(){
		if($("#nextfb_num").val() == -1)
			alert("다음 게시글이 없습니다.");
		else
			location.href="/viewFreeBoard.do?fb_num="+$("#nextfb_num").val()+"&thisPage="+$("#thisPage").val();
	});
	$("#listBtn").click(function(){
		location.href="/freeBoard.do?page_num="+$("#thisPage").val();
	});
	$("#modifyBtn").click(function(){
		location.href="/modifyFreeBoard.do?fb_num="+$("#fb_num").val()+"&thisPage="+$("#thisPage").val();
	});
	$("#deleteBtn").click(function(){
		var execute = confirm("정말 삭제하시겠습니까?");
		if(execute)
			location.href="/deleteFreeBoard.do?fb_num="+$("#fb_num").val()+"&thisPage="+$("#thisPage").val();
	});
})