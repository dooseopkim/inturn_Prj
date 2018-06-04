/**
 * @author 이슬기
 * @since 2018.05.18
 * @see modifyUserPW 관련 JQuery 및 JavaScript
 * @returns
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
	
	$("#newPw").keyup(function(e){
		if(e.keyCode === 13){
			$("#rePw").focus();
		} else {
			checkNewPw();
		}
	});
	
	$("#rePw").keyup(function(e){
		if(e.keyCode === 13){
			modifyUserPw();
		} else {
			checkRePw();
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
		} else if($("#newPw").val().length <8 || $("#newPw").val().length >16){
			alert("새 비밀번호는 영문(대소문자구분), 숫자, 특수문자(~!@#$%^&*()-_+= 만 허용)를 혼용하여 8~16자를 입력해 주세요.");
			return false;
		} else if(checkNewPw() != true){
			alert("새 비밀번호는 영문(대소문자구분), 숫자, 특수문자(~!@#$%^&*()-_+= 만 허용)를 혼용하여 8~16자를 입력해 주세요.");
			$("#newPw").val("");
			$("#rePw").val("");
			$("#newPw").focus();
			return false;
		} else if($("#newPw").val() != $("#rePw").val()){
			alert("새 비밀번호가 일치하지 않습니다. 다시 시도해 주세요.");
			$("#rePw").val("");
			$("#rePw").focus();
			return false;
		}
		
		if($("#chkModPw").val()=="true"){
			var pw = $("#pw").val();
		} else {
			var pw = CryptoJS.SHA256($("#pw").val()).toString();
		}
		
		var newPw = CryptoJS.SHA256($("#newPw").val()).toString();
		
		$.ajax({
			url: "modifyUserPw.do",
			method: "POST",
			type: "JSON",
			data: {
				"id" : $("#id").val(),
				"pw" : pw,
				"newPw" : newPw
			},
			success: function(data){
				if(data.result == "success"){
					alert("비밀번호가 변경되었습니다.");
					feedReset();
					
				} else {
					alert(data.result);
					feedReset();
				}
			}
		});
	}
	
	function checkNewPw(){
		var newPw = $("#newPw").val();
		
		if(newPw != "" && $("#rePw").val() != ""){
			checkRePw();
		} 
		
		if(newPw == ""){
			$("#feedbackNewPw").html("");
			$("#feedbackNewPw").removeClass("valid-feedback invalid-feedback").addClass( "feedback" );
		} else if(newPw.length<8 || newPw.length>16){
			$("#feedbackNewPw").html("영문(대소문자구분), 숫자, 특수문자(~!@#$%^&*()-_+= 만 허용)를 혼용하여 8~16자를 입력해 주세요.");
			$("#feedbackNewPw").removeClass("feedback valid-feedback").addClass( "invalid-feedback" );
			$("#newPw").removeClass("is-valid").addClass( "is-invalid" );
			return false;
		} else if(!newPw.match(/([a-zA-Z0-9].*[~,!,@,#,$,%,^,&,*,(,),-,_,+,=])|([~,!,@,#,$,%,^,&,*,(,),-,_,+,=].*[a-zA-Z0-9])/)) {
			$("#feedbackNewPw").html("영문(대소문자구분), 숫자, 특수문자(~!@#$%^&*()-_+= 만 허용)를 혼용하여 8~16자를 입력해 주세요.");
			$("#feedbackNewPw").removeClass("feedback valid-feedback").addClass( "invalid-feedback" );
			$("#newPw").removeClass("is-valid").addClass( "is-invalid" );
		      return false;
		} else {
			$("#feedbackNewPw").html("");
			$("#feedbackNewPw").removeClass("feedback invalid-feedback").addClass( "valid-feedback" );
			$("#newPw").removeClass("is-invalid").addClass( "is-valid" );
			return true;
		}
	}
	
	function checkRePw(){
		if($("#rePw").val()=="" || $("#newPw").val() == ""){
			$("#feedbackRePw").removeClass("valid-feedback invalid-feedback").addClass( "feedback" );
			$("#feedbackRePw").html("");
		} else if($("#newPw").val() != $("#rePw").val()){
			$("#feedbackRePw").html("새 비밀번호가 일치하지 않습니다.");
			$("#feedbackRePw").removeClass("feedback valid-feedback").addClass( "invalid-feedback" );
			$("#rePw").removeClass("is-valid").addClass( "is-invalid" );
			
		} else {
			$("#feedbackRePw").html("새 비밀번호 확인 완료");
			$("#feedbackRePw").removeClass("feedback invalid-feedback").addClass( "valid-feedback" );
			$("#rePw").removeClass("is-invalid").addClass( "is-valid" );
		}
	}
	
	function feedReset(){
		$("#pw").val("");
		$("#newPw").val("");
		$("#rePw").val("");
		$("#feedbackNewPw").html("");
		$("#feedbackNewPw").removeClass("valid-feedback invalid-feedback").addClass( "feedback" );
		$("#feedbackRePw").html("");
		$("#feedbackRePw").removeClass("valid-feedback invalid-feedback").addClass( "feedback" );
	}
	
});