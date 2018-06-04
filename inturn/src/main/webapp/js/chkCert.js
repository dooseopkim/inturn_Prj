$(function() {
	$("#emailSelect").change(function() {
		$("#emailInput2").val($("#emailSelect").val());
	});
})

/**
 * 체크박스 전체 동의
 * 
 * @param element
 * @returns
 */
function fn_clickAgreeAll(element) {
	if ($(element).is(':checked')) {
		$.each($('div.terms-agree input[type="checkbox"]'), function(index,
				target) {
			$(this).prop('checked', true);
			$(this).closest('div.terms-agree').find('p.txt-error').hide();
		})
	} else {
		$.each($('div.terms-agree input[type="checkbox"]'), function(index,
				target) {
			$(this).prop('checked', false);
			$(this).closest('div.terms-agree').find('p.txt-error').hide();
		})

	}
}

/**
 * 하나씩 동의
 * 
 * @param element
 * @returns
 */
function fn_clickAgree(element) {
	if ($(element).is(':checked')) {
		$(element).closest('div.terms-agree').find('p.txt-error').hide();
	} else {
		$('#chk_all').prop('checked', false);
	}
}

/**
 * 이메일 인증 레이어 열림
 * 
 * @param openLayerId
 * @param event
 * @returns
 */
function fn_checkStplat(openLayerId, event) {
	var result = true;
	$.each($('div.terms-agree input[type="checkbox"]'),
			function(index, target) {
				if (!$(this).is(':checked')) {
					$(this).focus();
					var info = $(this).closest('div.terms-agree').find(
							'p.txt-error').html();
					alert(info);
					if (result) {
						result = false;
						return false;
					}
				}
			});

	if (result) {
		$('div.modal').modal();
	}

}

/**
 * 미동의
 * 
 * @param event
 * @returns
 */
function fn_cancel(event) {
	if (confirm('회원가입을 취소하시겟습니까?')) {
		location.replace('main.do');
	}
}

/**
 * 이메일에 한글입력시 alert
 * 
 * @param str
 * @returns
 */
function chkKorean(str) {
	var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	var check2 = /\s/gi;
	if (check.test(str))
		alert("이메일은 영문만 입력 가능합니다.");
	if (check2.test(str))
		alert("공백없이 입력하세요.");
}

/**
 * 이메일 유효성 검사
 * 
 * @param tempEmail
 * @returns
 */
function checkEmail(tempEmail) {
	var result = new Object();
	result['isSuccess'] = true;
	result['msg'] = '';

	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;

	if (tempEmail.match(regExp) == null) {
		result['isSuccess'] = false;
		result['msg'] = '올바르지 않은 이메일 주소입니다.';
	}
	return result;
}

/**
 * 이메일 입력 검사
 * 
 * @param emailId
 * @param emailDomainId
 * @param event
 * @returns
 */
function fn_sendIssuCrtfcInfo(emailId, emailDomainId) {

	_IsCheckCrtfcInfo = false;
	$('#req_email').hide();
	$('#empty_email').hide();

	var email_id = $('#emailInput1').val();
	var email_domain = $('#emailInput2').val();

	if (email_id == null || email_domain == null) {
		alert("이메일 주소를 올바르게 입력해주세요");
	} else {
		var tempEmail = email_id + '@' + email_domain;
		var emailResult = checkEmail(tempEmail);

		if (!emailResult.isSuccess) {
			// alert(emailResult.msg);
			$('#error-email').show();
		} else {
			$('#error-email').hide();
			sendEmail(email_id + '@' + email_domain);
		}
	}
}

/**
 * 이메일로 인증번호 전송하기
 * 
 * @param emailAddress
 * @returns
 */
function sendEmail(emailAddress) {
	$('#noti-email').show();
	$.ajax({
		url : "sendEmail.do",
		method : "POST",
		type : "JSON",
		data : {
			"to" : emailAddress
		},
		success : function(data) {
			$("#joinCode").val(data);
			return false;
		}
	})
}

/**
 * 인증번호 확인 후 맞으면 signupForm.do로 이동
 * 
 * @returns
 */
function check() {
	var codeInput = document.getElementById('codeIput').value;
	var realCode = document.getElementById('joinCode').value;
	var email_id = $('#emailInput1').val();
	var email_domain = $('#emailInput2').val();
	if (codeInput == realCode) {
		alert("인증에 성공하였습니다.");
		$('#email').val(email_id + '@' + email_domain);
		$('#chkEmail').attr('action', 'signupForm.do');
		$('#chkEmail').attr('target', '_self');
		$('#chkEmail')[0].submit();
	} else {
		alert("틀린 인증번호 입니다. 다시 한번 확인해주세요.");
	}
}
