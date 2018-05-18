$(function(){
	$("#emailSelect").change(function(){
		$("#emailInput2").val($("#emailSelect").val());
	});
})

/**
 * 체크박스 전체 동의
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
					var info = $(this).closest('div.terms-agree').find('p.txt-error').html();
					alert(info);
					if (result) {
						result = false;
						return false;
					}
				}
			});
	
	if (result) {
		/*_NtelsUtil.layerOpen(openLayerId, event);*/
		$('div.modal').modal();
	}

}

/**
 * 미동의
 * @param event
 * @returns
 */
function fn_cancel(event) {
	if (confirm('회원가입을 취소하시겟습니까?')) {
		location.replace('main.do');
	}
}

/*이메일인증 띄우기*/


