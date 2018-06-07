/**
 * 마이페이지 관련 자바스크립트 and JQuery
 */

/**
 * 페이지 로딩시 필요한 정보들을 가져오는 함수 수행
 */
$(window).load(function(){
	getFreeBoardReply();
	getMentorBoardReply();
})

/**
 * 최근 게시글에 대한 댓글이 존재하면
 * 해당 댓글을 tag로 써주는 함수
 */
function writeFreeBoardAlarm(list) {
	var tag ='';
	tag += '<ul>';
	for(i=0; i<list.length; i++) {		
		var contents;
		if(list[i].content.length > 15)
			contents = list[i].content.substring(0,11)+"....";
		else
			contents = list[i].content;
		tag += '<li><a href="viewFreeBoard.do?fb_num='+list[i].fb_num+'&thisPage=1">'+list[i].id+' : '+contents+'</a></li>';
	}
	tag += '</ul>';
	$("#freeBoardAlarm").append(tag);
}

/**
 * if list == null 해도 되는데
 * 그냥 나눠봄
 */
function writeFreeBoardNull() {
	var tag ='';
	tag += '<p>최근 게시글에 대한 댓글이 없습니다.</p>';
	$("#freeBoardAlarm").append(tag);
}

/**
 * Controller로 부터 
 * 자신의 가장 최근 게시글에 대한
 * 댓글 10개를 가져오는 함수
 */
function getFreeBoardReply() {
	$.ajax({
		url: "freeBoardAlarm.do",
		success: function(data) {
			if(data.result == "success") 
				writeFreeBoardAlarm(data.list);
			else 
				writeFreeBoardNull();
		}
	})
}

/**
 * mentorBoard 최신 댓글 불러오기 관련 함수
 * 
 */
function getMentorBoardReply() {
	$.ajax({
		url: "mentorBoardAlarm.do",
		success: function(data) {
			if(data.result == "success") 
				writeMentorBoardAlarm(data.list);
			else 
				writeMentorBoardNull();
		}
	})
}

function writeMentorBoardAlarm(list) {
	var tag ='';
	tag += '<ul>';
	for(i=0; i<list.length; i++) {		
		var contents;
		if(list[i].content.length > 15)
			contents = list[i].content.substring(0,11)+"....";
		else
			contents = list[i].content;
		tag += '<li><a href="viewMentorBoard.do?mb_num='+list[i].mb_num+'">'+list[i].id+' : '+contents+'</a></li>';
	}
	tag += '</ul>';
	$("#mentorBoardAlarm").append(tag);
}

function writeMentorBoardNull() {
	var tag ='';
	tag += '<p>최근 게시글에 대한 댓글이 없습니다.</p>';
	$("#mentorMentorAlarm").append(tag);
}