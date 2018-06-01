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
			if(data.result == "success") {
				writeReplies(data.list);
			}
		}
	})
}

function insertReply() {
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
			$("#getReplies").children().remove();
			getReplies();
		}
	})
}

function reReply(i) {
	
}

function modifyEnter(rp_num, i) {
	if(event.keyCode == 13)
		modifyReply(rp_num, i);
}

function modifyReply(rp_num, i) {
	var content = $("#modifyContent"+i).val();
	$.ajax({
		url: "modifyReply.do",
		method: "POST",
		datatype: "JSON",
		data: {
			"content" : content,
			"rp_num" : rp_num
		},
		success: function(data){
			$("#getReplies").children().remove();
			getReplies();
		}
	})
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
	tag += '<button onclick="reReply('+i+')" class="btn-sm btn-primary">답글</button>&nbsp;';
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
	tag += '<button onclick="modifyReply('+rp_num+','+i+')" class="btn-sm btn-info">저장</button>&nbsp;';
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
			success: function(data){
				$("#reply"+i).remove();
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
		tag += '<span id="Reply'+i+'id">'+list[i].id+'</span>';
		tag += '</div>';
		tag += '<div class="col-sm-6">';
		tag += '<span id="Reply'+i+'content">'+list[i].content+'</span>';
		tag += '</div>';
		tag += '<div class="col-sm-4 text-left">';
		tag += '<span id="Reply'+i+'regDate">'+list[i].regDate+'</span>&nbsp;';
		tag += '<button onclick="reReply('+i+')" class="btn-sm btn-primary">답글</button>&nbsp;';
		if(list[i].id == $("#id").val()) {
			tag += '<button onclick="writeModify('+list[i].rp_num+','+i+')" class="btn-sm btn-info">수정</button>&nbsp;';
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