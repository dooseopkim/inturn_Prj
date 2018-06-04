/**
 * @author 이슬기
 * @since 2018.05.18
 * @see findPW 관련 JQuery 및 JavaScript
 * @returns
 */

$(function(){
	
	/*비밀번호 찾기 버튼 클릭 시*/
	$("#btn_sendNewPW").click(function(){
		findPw();
	});
	
	/*아이디 입력란에서 엔터 시*/
	$("#id").keydown(function(e) {
		if (e.keyCode === 13) {
			$("#name").focus();
		} 
	});
	
	/*이름 입력란에서 엔터 시*/
	$("#name").keydown(function(e) {
		if (e.keyCode === 13) {
			$("#email").focus();
		} 
	});
	
	/*이메일 입력란에서 엔터 시*/
	$("#email").keydown(function(e){
		if(e.keyCode === 13){
			findPw();
		}
	});
	
	function findPw(){
		if($("#id").val()==""){
			alert("아이디를 입력하세요.");
			$("#id").focus();
			return false;
		}else if($("#name").val()==""){
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}else if($("#email").val()==""){
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}

		$.ajax({
			url: "sendNewPW.do",
			method: "POST",
			type: "JSON",
			data: {
				"id" : $("#id").val(),
				"name" : $("#name").val(),
				"email" : $("#email").val()
			},
			beforeSend: function() {
		        $('html').css("cursor", "wait");
		    },
		    complete: function() {
		        $('html').css("cursor", "auto");
		    },
		    success: function(data){
				if(data.result=='success'){
					if(confirm(data.userEmail+" (으)로 임시 비밀번호를 발송했습니다.")){
						location.href="loginForm.do";
					};
				} else {
					alert(data.result);
				}
			} 
		});
	}
});
