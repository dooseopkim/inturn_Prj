/**
 * 아이디 중복체크 함수
 * 
 * @param id
 * @returns
 */
function chkId() {
	var id = $('#availId').val();
	$.ajax({
		url : "chkId.do",
		method : "POST",
		type : "JSON",
		data : {
			"id" : id
		},
		success : function(data) {
			if (data.result == "success") {
				if (confirm(id + ' 은/는 사용 가능한 아이디 입니다. 사용하시겠습니까?')) {
					$('#id').val(id);
					return false;
				}
			} else {
				alert('사용할 수 없는 아이디 입니다.');
				$('#id').val('');
				return false;
			}
		}
	});
}

/**
 * 이름에는 한글만 입력가능하도록!
 * @returns
 */
function hangul() {
	if ((event.keyCode < 12592) || (event.keyCode > 12687))
		event.returnValue = false;
}


/**
 * 비밀번호 확인
 * 
 * @returns
 */
function chkPw() {
	var pw = $('#pw').val();
	var pwCheck = $('#pwCheck').val();
	if (pw != pwCheck) {
		$('#msg-pwError').show();
		$('#pwCheck').focus();
	} else {
		$('#msg-pwError').hide();
	}
}

/**
 * 핸드폰번호나 출생년도 입력 시 숫자만 허용하도록
 * 
 * @param event
 * @returns
 */
function onlyNum(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
			|| keyID == 8 || keyID == 9 || keyID == 46 || keyID == 37
			|| keyID == 39) {
		return;
	} else {
		return false;
	}
}

/**
 * 위의 함수에서는 한글입력은 처리 못하기 때문에 추가로 한번 더 처리
 * 
 * @param event
 * @returns
 */
function removeChar(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
		return;
	else
		event.target.value = event.target.value.replace(/[^0-9]/g, "");
}

/**
 * 회원가입
 * 
 * @param event
 * @returns
 */
function signup(event) {
	var flag = false;
	var type = $('#type').val();
	var name = $('#name').val();
	var id = $('#id').val();
	var pw = $("#pw").val();
	var pwCheck = $('#pwCheck').val();
	var phone = $('#phone').val();
	var yyyy = $('#yy').val();
	var mm = $('#mm').val();
	var dd = $('#dd').val();
	var email = $('#email').val();

	if (type == '') {
		alert('멘토 멘티를 선택해주세요.');
		$('#type').focus();
	} else if (name == '') {
		$('#name').focus();
	} else if (id == '') {
		alert('중복확인을 해주세요.')
		$('#availId').focus();
	} else if (pw == '') {
		alert('비밀번호를 입력해주세요.')
		$('#pw').focus();
	} else if (pwCheck == '') {
		alert('비밀번호 확인란을 입력해주세요.');
		$('#pwCheck').focus();
	} else if (phone == '' || phone.length <= 10) {
		alert('휴대전화 번호를 확인해주세요.');
		$('#phone').focus();
	} else if (yyyy == '' || yyyy.length <= 3) {
		alert('출생년도를 정확히 입력해주세요.');
		$('#yy').focus();
	} else if (mm == '') {
		alert('태어난 달을 선택해주세요.');
		$('#mm').focus();
	} else if (dd == '') {
		alert('태어난 일을 선택해주세요.');
		$('#dd').focus();
	} else if (email == '') {
		alert('본인인증이 필요합니다.')
		location.href = "/signup.do"
	} else {
		flag = true;
		var birthday = yyyy + "-" + mm + "-" + dd;
	}
	if (flag) {
		$.ajax({
			url : "insertUser.do",
			method : "POST",
			type : "JSON",
			data : {
				"type" : $("#type").val(),
				"name" : $("#name").val(),
				"id" : $("#id").val(),
				"pw" : CryptoJS.SHA256($("#pw").val()).toString(),
				"phone" : $("#phone").val(),
				"birthday" : birthday,
				"email" : $("#email").val()
			},
			success : function(data) {
				if (data.result == "success") {
					alert('회원가입에 성공했습니다.');
					location.href = "successSignup.do";
					null;
				} else {
					alert('죄송합니다. 회원가입에 실패했습니다. 다시 진행해주세요.');
					location.href = "signup.do";
					null;
				}
			},
			error : function(request, status, error) {
				alert("error:" + error);
			}
		});
	}
}
