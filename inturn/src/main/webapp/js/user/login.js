/**
 * @author 이슬기
 * @since 2018.05.17
 * @see login 관련 JQuery 및 JavaScript
 */
$(function(){
	/** 
	 * 아이디저장 체크시 7일간 저장 관련 JQuery
	 * @author http://zero-gravity.tistory.com/245, 이슬기
	 */
	var inputUserId = getCookie("inputUserId");
	$("#loginId").val(inputUserId);
	
    if($("#loginId").val() != ""){
    	$("#checkSaveId").attr("checked", true);
    }
    
    $("#checkSaveId").change(function(){
        if($("#checkSaveId").is(":checked")){
            var inputUserId = $("#loginId").val();
            setCookie("inputUserId", inputUserId, 7);
        }else{
            deleteCookie("inputUserId");
        }
    });
    
    $("#loginId").keyup(function(){
        if($("#checkSaveId").is(":checked")){
            var inputUserId = $("#loginId").val();
            setCookie("inputUserId", inputUserId, 7);
        }
    });


    
	/*로그인 버튼 클릭 시*/
	$("#btn_login").click(function(){
		login();
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
		if($("#loginId").val()==""){
			alert("아이디를 입력하세요.");
			$("#loginId").focus()
			return false;
		} else if ($("#password").val()==""){
			alert("비밀번호를 입력하세요.");
			$("#password").focus();
			return false;
		} 
		if($("#chkModPw").val()=="true"){
			var pw = $("#password").val();
		} else {
			var pw = CryptoJS.SHA256($("#password").val()).toString();
		}
		$.ajax({
			url: "login.do",
			method: "POST",
			type: "JSON",
			data: {
				"id" : $("#loginId").val(),
				"pw" : pw
			},
			success: function(data){
				if(data.result == "success"){
					if(data.chkTempPw == "true"){
						alert("로그인 성공! 비밀번호를 변경하세요.")
						location.href="modifyUserPwForm.do";
					} else {
						alert("로그인 성공! 반갑습니다!");
						location.href="/";
					}
				}
				else
					alert("로그인 정보를 확인하고 다시 입력해주세요.");
					$("#loginId").val("");
					$("#password").val("");
					$("#loginId").focus();
			}
				
		});
	}
});

/** 
 * 아이디저장 체크시 7일간 저장 관련 function
 * @author http://zero-gravity.tistory.com/245, 이슬기
 */
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}