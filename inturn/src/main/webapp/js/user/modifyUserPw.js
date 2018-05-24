/**
 * 
 */
$(function(){
	var newPw = $("#newPw").val(),
		rePw = $("#rePw").val();
	
	$("#pw").focus();
	$("#pw").keydown(function(e) {
		if(e.keyCode === 13){
			$("#newPw").focus();
		}
	});
	
	$("#newPw").keydown(function(e){
		if(e.keyCode === 13){
			$("#rePw").focus();
		}
		
	});
	
	$("#rePw").keydown(function(e){
		if(e.keyCode === 13){
			modifyUserPw();
		}
	});
	
	
	$("#btn_modifyUserPW").click(function(){
		modifyUserPw();
		
	});
	
	function modifyUserPw(){
		if($("#pw").val()==""){
			alert("현재 비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		} else if ($("#newPw").val()==""){
			alert("새 비밀번호를 입력하세요.");
			$("#newPw").focus();
			return false;
		} else if($("#rePw").val()==""){
			alert("새 비밀번호 확인을 입력하세요.")
			$("#rePw").focus();
			return false;
		} else if($("#newPw").val() != $("#rePw").val()){
			alert("새 비밀번호가 일치하지 않습니다. 다시 시도해 주세요.");
			$("#rePw").val("");
			$("#rePw").focus();
			return false;
		}
		
		$.ajax({
			url: "modifyUserPw.do",
			method: "POST",
			type: "JSON",
			data: {
				"id" : $("#id").val(),
				"pw" : $("#pw").val(),
				"newPw" : $("#newPw").val()
			},
			success: function(data){
				if(data.result == "success"){
					alert("비밀번호가 변경되었습니다.");
				} else {
					alert(data.result);
					$("#pw").val("");
					$("#newPw").val("");
					$("#rePw").val("");
					$("#pw").focus();
				}
			}
		});
	}
	
});