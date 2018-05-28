$(window).load(function() {
	var referrerURL = document.referrer
	referrerURL = referrerURL.substring(22, referrerURL.indexOf("."));
	if(referrerURL == "insertFreeBoard" || referrerURL == "modifyFreeBoard")
		location.href="/deleteFiles.do";
})