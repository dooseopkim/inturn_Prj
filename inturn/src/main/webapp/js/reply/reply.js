/**
 * 댓글 CRUD 기능 관련 함수
 * @author 박현호
 * @version 1.0
 * @since 2018.06.01
 * @see 
 */

$(window).load(function() {
	getReplies();
})

function getReplies() {
	$.ajax({
		url: "getReplies.do",
		method: "POST",
		datatype: "JSON",
		data: {
			"page_num" : 1
		},
		success: function(data){
			if(data.result == "success")
				writeReplies(data.list);
		}
	})
}

function insertReply() {
	if($("#replyContent").val() == '')
		alert("아무것도 입력되지 않았습니다.");
	else {
		$.ajax({
			url: "insertReply.do",
			method: "POST",
			datatype: "JSON",
			data: {
				"fb_num" : $("#fb_num").val(),
				"content" : $("#replyContent").val(),
				"id" : $("#id").val()
			},
			success: function(data){
				if(data.result == "success") {
					$("#getReplies").children().remove();
					getReplies();
				}
			}
		})
	}
}

function modifyReReplyEnter(i) {
	if(event.keyCode == 13)
		modifyReReply(i);
}

function modifyReReply(i) {
	if(i =='')
		alert("아무것도 입력되지 않았습니다.");
	else {
		$.ajax({
			url: "",
			method: "POST",
			datatype: "JSON",
			data: {
				"rp_num" : rp_num,
				"content" : $("#modifyContent").val()
			},
			success: function(data) {
				if(data.result == "success") {
					$("#getReplies").children().remove();
					getReplies();
				}
			}
		})
	}
}

function cancelModifyReReply(rp_num, i) {
	var id = $("#modifyId"+i).val();
	var content = $("#befoerContent"+i).val();
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
	tag += '<input type="hidden" id="befoerContent'+i+'" value="'+content+'">'
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

function insertReReplyEnter(rp_num, i) {
	if(event.keyCode == 13)
		insertReReply(rp_num, i);
}

function insertReReply(rp_num, i) {
	if($("#reReplyContent"+i).val() == '')
		alert("아무것도 입력되지 않았습니다.");
	else {
		$.ajax({
			url: "insertReReply.do",
			method: "POST",
			datatype: "JSON",
			data: {
				"fb_num" : $("#fb_num").val(),
				"content" : $("#reReplyContent"+i).val(),
				"regDate" : $("#reReplyDate"+i).val(),
				"parentNum" : rp_num,
				"id" : $("#reReplyId"+i).val()
			},
			success: function(data){
				if(data.result == "success") {
					$("#getReplies").children().remove();
					getReplies();
				}
			}
		})
	}
}

function cancelReReply(i) {
	if(confirm("정말 취소하시겠습니까?")) {
		$("#reReplyBtn"+i).show();
		$("#reReply"+i).remove();
	}
}

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

function modifyEnter(rp_num, i) {
	if(event.keyCode == 13)
		modifyReply(rp_num, i);
}

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
				if(data.result == "success") {
					$("#getReplies").children().remove();
					getReplies();
				}
			}
		})
	}
}

function cancelModify(rp_num, i) {
	var id = $("#modifyId"+i).val();
	var content = $("#befoerContent"+i).val();
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
	tag += '<input type="hidden" id="befoerContent'+i+'" value="'+content+'">'
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
				if(data.result == "success") {
					$("#reply"+i).remove();
				}
			}
		})
	}
}

function writeReplies(list) {
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
	$("#getReplies").append(tag);
}

$(function(){
	$("#replyContent").keydown(function(e){
		if (e.keyCode === 13)
			insertReply();
	});
	
	$("#insertReplyBtn").click(function(){
		insertReply();
	});
})