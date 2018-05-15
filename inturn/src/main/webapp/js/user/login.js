/**
 * 
 */
$(function(){
	
	/*아이디, 비밀번호 입력하지 않고 로그인 버튼 클릭 시*/
	$("#btn_login").click(function(){
		if($("#loginId").val()==""){
			alert("아이디를 입력하세요.");
			$("#loginId").focus()
			return false;
		} else if ($("#password").val()==""){
			alert("비밀번호를 입력하세요.");
			$("#password").focus();
			return false;
		} else {
			login();
		}
	});
	
	/*아이디 입력란에서 엔터 시*/
	$("#loginId").keydown(function(e) {
		if (e.keyCode === 13) {
			$("#password").focus();
		} 
	});
	
	/*비밀번호 입력란에서 엔터 시*/
	$("#password").keydown(function(e){
		if(e.keyCode === 13){
			login();
		}
	});
	
	function login(){
		$.ajax({
			url: "login.do",
			method: "POST",
			type: "JSON",
			data: {
				"id" : $("#loginId").val(), 
				"pw" : $("#password").val() 
			},
			success: function(data){
				if(data.result == "success"){
					alert("회원님 반갑습니다! 로그인하셨네요");
					location.href="/";
				}
				else
					alert("로그인 정보를 확인하고 다시 입력해주세요!");		
			}
				
		});
	}
	

});

