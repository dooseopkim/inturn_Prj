/**
 * 
 */


/**
 * 페이지 로딩시 해당 게시글의 댓글을 가져온다.
 */
$(window).load(function() {
	getReplies(1);
})

/**
 * 보고있는 페이지에 대한 댓글을 가져온다.
 */
function getReplies(pageNum) {
	$.ajax({
		url: "getMBReplies.do",
		method: "POST",
		datatype: "JSON",
		data: {
			"page_num" : pageNum,
			"mb_num" : $("#mb_num").val()
		},
		success: function(data){
			if(data.result == "success")
				writeReplies(data.list, data.page, pageNum);
		}
	})
}

/**
 * 댓글을 입력하는 함수
 * DB에 정상적으로 등록되면, 모두 지운 후 다시 리스트를 불러온다.
 */
function insertReply() {
	if($("#replyContent").val() == '')
		alert("아무것도 입력되지 않았습니다.");
	else {
		$.ajax({
			url: "insertMBReply.do",
			method: "POST",
			datatype: "JSON",
			data: {
				"mb_num" : $("#mb_num").val(),
				"content" : $("#replyContent").val(),
				"id" : $("#id").val()
			},
			success: function(data){
				if(data.result == "success") {
					$("#replyContent").val("");
					getReplies(1);
				}
			}
		})
	}
}

/**
 * 대댓글을 수정할 때 엔터키로 수행함
 */
function modifyReReplyEnter(rp_num, i) {
	if(event.keyCode == 13)
		modifyReReply(rp_num, i);
}

/**
 * 대댓글을 수정하는 함수
 * 수정이 완료되어 DB에 정상적으로 등록되면
 * 전체 리스트를 지우고 다시불러온다.
 */
function modifyReReply(rp_num, i) {
	if($("#modifyContent"+i).val() =='')
		alert("아무것도 입력되지 않았습니다.");
	else {
		$.ajax({
			url: "modifyReply.do",
			method: "POST",
			datatype: "JSON",
			data: {
				"rp_num" : rp_num,
				"content" : $("#modifyContent"+i).val()
			},
			success: function(data) {
				if(data.result == "success") 
					getReplies($("#thisReplyPage").val());
			}
		})
	}
}

/**
 * 대댓글을 수정버튼을 누른 후 취소했을 때,
 * content만 그 값이 바뀌므로 beforeContent input태그에서
 * 그 값을 미리 넣어놓고 그 값을 가져온다.
 * 이 후 수정으로 작성하던 부분을 모두 지우고 맨처음의 로딩 상태로 만들어놓는다.
 */
function cancelModifyReReply(rp_num, i) {
	var id = $("#modifyId"+i).val();
	var content = $("#beforeContent"+i).val();
	var regDate =$("#modifyDate"+i).val();
	$("#reply"+i).children().remove();
	var tag = '';
	tag += '<br>';
	tag += '<div class="col-sm-2">';
	tag += '<span class="icon-forward"/>&nbsp;<span id="Reply'+i+'id">'+id+'</span>';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<span id="Reply'+i+'content">'+content+'</span>';
	tag += '</div>';
	tag += '<div class="col-sm-4 text-left">';
	tag += '<span id="Reply'+i+'regDate">'+regDate+'</span>&nbsp;';
	if(id == $("#id").val()) {
		tag += '<button onclick="writeReModify('+rp_num+','+i+')" class="btn-sm btn-info">수정</button>&nbsp;';
		tag += '<button onclick="deleteReply('+rp_num+','+i+')" class="btn-sm btn-danger">삭제</button>';
	}
	tag += '</div>';
	$("#reply"+i).append(tag);
}

/**
 * 대댓글 수정하는 UI함수
 * 입력폼으로 바꾸고, beforeContent에 수정전 값을 넣어놓는다.
 */
function writeReModify(rp_num, i) {
	var id = $("#Reply"+i+"id").html();
	var content = $("#Reply"+i+"content").html();
	var regDate =$("#Reply"+i+"regDate").html();
	$("#reply"+i).children().remove();
	var tag = '';
	tag += '<br>';
	tag += '<div class="col-sm-2">';
	tag += '<input type="text" id="modifyId'+i+'" class="form-control" readonly="readonly" value="'+id+'">';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<input type="hidden" id="beforeContent'+i+'" value="'+content+'">'
	tag += '<input type="text" id="modifyContent'+i+'" class="form-control" onkeydown="modifyEnter('+rp_num+','+i+')" value="'+content+'">';
	tag += '</div>';
	tag += '<div class="col-sm-2 text-left">';
	tag += '<input type="text" id="modifyDate'+i+'" class="form-control" readonly="readonly" value="'+regDate+'">&nbsp;';
	tag += '</div>'
	tag += '<div class="col-sm-2 text-left">';
	tag += '<button onclick="modifyReReply('+rp_num+','+i+')" class="btn-sm btn-info">작성</button>&nbsp;';
	tag += '<button onclick="cancelModifyReReply('+rp_num+','+i+')" class="btn-sm btn-danger">취소</button>';
	tag += '</div>';
	$("#reply"+i).append(tag);
}

/**
 * 대댓글 입력을 엔터로 수행하게 함
 */
function insertReReplyEnter(rp_num, i) {
	if(event.keyCode == 13)
		insertReReply(rp_num, i);
}

/**
 * 대댓글을 등록하는 함수
 * DB에 입력 성공시 리스트를 다시 불러온다.
 */
function insertReReply(rp_num, i) {
	if($("#reReplyContent"+i).val() == '')
		alert("아무것도 입력되지 않았습니다.");
	else {
		$.ajax({
			url: "insertMBReReply.do",
			method: "POST",
			datatype: "JSON",
			data: {
				"mb_num" : $("#mb_num").val(),
				"content" : $("#reReplyContent"+i).val(),
				"regDate" : $("#reReplyDate"+i).val(),
				"parentNum" : rp_num,
				"id" : $("#reReplyId"+i).val()
			},
			success: function(data){
				if(data.result == "success")  
					getReplies($("#thisReplyPage").val());
			}
		})
	}
}

/**
 * 대댓글 작성 취소시 수행하는 함수
 * 대댓글은 하나씩 달려야하므로,
 * 대댓글 작성을 눌렀을때, 답글 버튼을 숨긴다.
 * 따라서 다시 보이게 해주고
 * 대댓글 작성부분을 지운다.
 */
function cancelReReply(i) {
	if(confirm("정말 취소하시겠습니까?")) {
		$("#reReplyBtn"+i).show();
		$("#reReply"+i).remove();
	}
}

/**
 * 답글 버튼을 눌렀을 때 수행하는 함수
 * 대댓글은 현재날짜를 미리 보여줘야해서
 * 현재날짜를 만들고 이를 보여준다.
 * 또한 답글이 하나씩 달려야하므로 답글 버튼을 숨긴다.
 * 그리고 insertReReply같은 밑의 버튼을 새로만들어
 * 해당 함수들을 수행하게끔 한다.
 */
function reReply(rp_num, i) {
	$("#reReplyBtn"+i).hide();
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	if(dd<10) {
	    dd='0'+dd
	} 
	if(mm<10) {
	    mm='0'+mm
	} 
	today = yyyy+'-'+mm+'-'+dd;
	var tag = '';
	tag += '<div id="reReply'+i+'" class="row">'
	tag += '<div class="col-sm-2" style="margin-top: 10px;">';
	tag += '<input type="text" id="reReplyId'+i+'" class="form-control" readonly="readonly" value="'+$("#id").val()+'">';
	tag += '</div>';
	tag += '<div class="col-sm-6" style="margin-top: 10px;">';
	tag += '<input type="text" id="reReplyContent'+i+'" class="form-control" onkeydown="insertReReplyEnter('+rp_num+','+i+')">';
	tag += '</div>';
	tag += '<div class="col-sm-2 text-left" style="margin-top: 10px;">';
	tag += '<input type="text" id="reReplyDate'+i+'" class="form-control" readonly="readonly" value="'+today+'">&nbsp;';
	tag += '</div>'
	tag += '<div class="col-sm-2 text-left" style="margin-top: 20px;">';
	tag += '<button onclick="insertReReply('+rp_num+','+i+')" class="btn-sm btn-info">작성</button>&nbsp;';
	tag += '<button onclick="cancelReReply('+i+')" class="btn-sm btn-danger">취소</button>';
	tag += '</div>';
	tag += '</div>';
	$("#reply"+i).append(tag);
}

/**
 * 댓글 수정함수를 엔터로 수행
 */
function modifyEnter(rp_num, i) {
	if(event.keyCode == 13)
		modifyReply(rp_num, i);
}

/**
 * 댓글 수정하는 함수
 * 해당 내용이 DB에 잘 등록되면,
 * 리스트를 초기화한다.
 */
function modifyReply(rp_num, i) {
	var content = $("#modifyContent"+i).val();
	if(content == '')
		alert("아무것도 입력되지 않았습니다.");
	else {
		$.ajax({
			url: "modifyReply.do",
			method: "POST",
			datatype: "JSON",
			data: {
				"content" : content,
				"rp_num" : rp_num
			},
			success: function(data) {
				if(data.result == "success") 
					getReplies($("#thisReplyPage").val());
			}
		})
	}
}

/**
 * 댓글 수정중 취소함수
 * 다시 원래대로 돌아가는 함수로
 * 해당 부분만 바꾸면되어 이렇게 불러오나
 * 위의 경우들 처럼 아에 전체리스트를 새로 불러와도 상관없다.
 */
function cancelModify(rp_num, i) {
	var id = $("#modifyId"+i).val();
	var content = $("#beforeContent"+i).val();
	var regDate =$("#modifyDate"+i).val();
	$("#reply"+i).children().remove();
	var tag = '';
	tag += '<br>';
	tag += '<div class="col-sm-2">';
	tag += '<span id="Reply'+i+'id">'+id+'</span>';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<span id="Reply'+i+'content">'+content+'</span>';
	tag += '</div>';
	tag += '<div class="col-sm-4 text-left">';
	tag += '<span id="Reply'+i+'regDate">'+regDate+'</span>&nbsp;';
	tag += '<button id="reReplyBtn'+i+'" onclick="reReply('+rp_num+','+i+')" class="btn-sm btn-primary">답글</button>&nbsp;';
	if(id == $("#id").val()) {
		tag += '<button onclick="writeModify('+rp_num+','+i+')" class="btn-sm btn-info">수정</button>&nbsp;';
		tag += '<button onclick="deleteReply('+rp_num+','+i+')" class="btn-sm btn-danger">삭제</button>';
	}
	tag += '</div>';
	$("#reply"+i).append(tag);
}

/**
 * 수정버튼 클릭 후 작성할 수 있게
 * 태그를 바꿔주는 함수 beforeContent를 만들어,
 * 취소버튼을 눌러도 다시 그 값으로 DB를 가따오지 않아도
 * 정상적으로 원상복귀하게 한다.
 */
function writeModify(rp_num, i) {
	var id = $("#Reply"+i+"id").html();
	var content = $("#Reply"+i+"content").html();
	var regDate =$("#Reply"+i+"regDate").html();
	$("#reply"+i).children().remove();
	var tag = '';
	tag += '<br>';
	tag += '<div class="col-sm-2">';
	tag += '<input type="text" id="modifyId'+i+'" class="form-control" readonly="readonly" value="'+id+'">';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<input type="hidden" id="beforeContent'+i+'" value="'+content+'">'
	tag += '<input type="text" id="modifyContent'+i+'" class="form-control" onkeydown="modifyEnter('+rp_num+','+i+')" value="'+content+'">';
	tag += '</div>';
	tag += '<div class="col-sm-2 text-left">';
	tag += '<input type="text" id="modifyDate'+i+'" class="form-control" readonly="readonly" value="'+regDate+'">&nbsp;';
	tag += '</div>'
	tag += '<div class="col-sm-2 text-left">';
	tag += '<button onclick="modifyReply('+rp_num+','+i+')" class="btn-sm btn-info">작성</button>&nbsp;';
	tag += '<button onclick="cancelModify('+rp_num+','+i+')" class="btn-sm btn-danger">취소</button>';
	tag += '</div>';
	$("#reply"+i).append(tag);
}

/**
 * 댓글 삭제함수
 * DB에서 정상적으로 삭제되면,
 * 해당 댓글부분의 태그를 지워준다.
 */
function deleteReply(rp_num, i) {
	if(confirm("정말 삭제하시겠습니까?")) {
		$.ajax({
			url: "deleteReply.do",
			method: "POST",
			dataType: "JSON",
			data: {
				"rp_num" : rp_num
			},
			success: function(data) {
				if(data.result == "success")
					getReplies($("#thisReplyPage").val());
			}
		})
	}
}

/**
 * 전체 댓글리스트를 태그로 쭉 작성해주는 함수
 * 만약 대댓글의 경우 parentNum이 -1이 아니다.
 * 따라서 이 경우에는 대댓글에 맞게 버튼의 함수나
 * 값을 조금 바꿔 태그가 나타나도록 한다.
 */
function writeReplies(list, page, thisPage) {
	$("#getReplies").children().remove();
	var tag = '';
	for(i=0; i<list.length; i++) {
		tag += '<div id="reply'+i+'" class="row">';
		tag += '<br>';
		tag += '<div class="col-sm-2">';
		if(list[i].parentNum == -1)
			tag += '<span id="Reply'+i+'id">'+list[i].id+'</span>';
		else
			tag += '<span class="icon-forward"/>&nbsp;<span id="Reply'+i+'id">'+list[i].id+'</span>';
		tag += '</div>';
		tag += '<div class="col-sm-6">';
		tag += '<span id="Reply'+i+'content">'+list[i].content+'</span>';
		tag += '</div>';
		tag += '<div class="col-sm-4 text-left">';
		tag += '<span id="Reply'+i+'regDate">'+list[i].regDate+'</span>&nbsp;';
		if(list[i].parentNum == -1)
			tag += '<button id="reReplyBtn'+i+'" onclick="reReply('+list[i].rp_num+','+i+')" class="btn-sm btn-primary">답글</button>&nbsp;';
		if(list[i].id == $("#id").val()) {
			if(list[i].parentNum == -1)
				tag += '<button onclick="writeModify('+list[i].rp_num+','+i+')" class="btn-sm btn-info">수정</button>&nbsp;';
			else
				tag += '<button onclick="writeReModify('+list[i].rp_num+','+i+')" class="btn-sm btn-info">수정</button>&nbsp;';
			tag += '<button onclick="deleteReply('+list[i].rp_num+','+i+')" class="btn-sm btn-danger">삭제</button>';
		}
		tag += '</div>';
		tag += '</div>';
	}
	tag += '<div class="row" style="text-align: center;">';
	tag += '<ul class="pagination">';
	tag += '<li class="page-item disabled"><a class="page-link" href="#">&laquo;</a></li>';
	for(i=0; i<page; i++) {
		if(thisPage == (i+1))
			tag += '<li class="page-item active"><a class="page-link" onclick="getReplies('+(i+1)+')">'+(i+1)+'</a></li>';
		else
			tag += '<li class="page-item"><a class="page-link" onclick="getReplies('+(i+1)+')">'+(i+1)+'</a></li>';
	}
	tag += '<li class="page-item disabled"><a class="page-link" href="#">&raquo;</a></li>';
	tag += '</ul>';
	tag += '</div>';
	tag += '<input type="hidden" id="thisReplyPage" value="'+thisPage+'">'
	$("#getReplies").append(tag);
}

$(function(){
	/**
	 * 댓글 작성 엔터로 수행
	 */
	$("#replyContent").keydown(function(e){
		if (e.keyCode === 13)
			insertReply();
	});
	
	/**
	 * 댓글 작성
	 */
	$("#insertReplyBtn").click(function(){
		insertReply();
	});
})