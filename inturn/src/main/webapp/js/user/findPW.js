/**
 * 
 */

$(function(){
	$("#btn_sendNewPW").click(function(){
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
				"email" : $("email").val()
			},
			success: function(data){
				alert(data.email+" 으로 임시 비밀번호를 발송했습니다.");
			}
			
		});
	});
});
