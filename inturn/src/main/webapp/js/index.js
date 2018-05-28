$(window).load(function() {
	if(document.referrer == "http://localhost:9000/insertFreeBoard.do" ||
			document.referrer == "http://localhost:9000/modifyFreeBoard.do")
		location.href="/deleteFiles.do";
})