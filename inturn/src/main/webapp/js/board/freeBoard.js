/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.14
 * @see 자유게시판 관련 Jquery 및 JavaScript
 */
$(function(){
	/**
	 * 글쓰기 버튼을 눌렀을 때, 글쓰기 게시판으로 이동
	 */
	$("#insertBoardBtn").click(function(){
		location.href="/insertFreeBoard.do";
	})
})