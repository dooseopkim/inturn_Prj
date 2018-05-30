/**
 * 추가한 자격증 창 삭제
 */
function deleteCertificate(certificateCount) {
	$("#license"+certificateCount).remove();
}

/**
 * 자격증 검색
 */
function certificateName(certificateCount){
	$("#datalist"+certificateCount).empty();
	var tag = '';
	tag += '<option>test</option>'
	$("#datalist"+certificateCount).append(tag);
}

$(function(){
	/**
	 * 자격증 항목을 클릭할 때
	 * @returns 자격증에 대한 태그들 추가
	 */
	$("#formLicense").click(function() {
		var certificateCount = parseInt($("#certificateCount").val());
		certificateCount = certificateCount + 1;
		$("#certificateCount").val(certificateCount);
		var tag = '';
		tag += '<div id="license'+certificateCount+'" class="card">';
		tag += '<div class="card-header">';
		tag += '<div class="row">';
		tag += '<div class="col-sm-6">';
		tag += '<h3>자격증</h3>';
		tag += '</div>';
		tag += '<div class="col-sm-6" style="text-align: right;">';
		tag += '<span id="explain">*어학자격증이 아닌 자격증만 입력해주세요 &nbsp;&nbsp;&nbsp;&nbsp;</span>';
		tag += '<a onclick="deleteCertificate('+certificateCount+')"><span class="icon-cross"></span></a>';
		tag += '</div>';
		tag += '</div>';
		tag += '</div>';
		tag += '<div class="card-body">';
		tag += '<div class="row">';
		tag += '<div id="cerName" class="col-sm-6">';
		tag += '<label>자격증</label> ';
		tag += '<input list="datalist'+certificateCount+'" class="form-control" id="certificate_name'+certificateCount+'" name="certificate_name[]" placeholder="입력하시려면 검색됩니다." onkeydown="certificateName('+certificateCount+')">';
		tag += '<datalist id="datalist'+certificateCount+'">';
		tag += '</datalist>';
		tag += '</div>';
		tag += '<div class="col-sm-6">';
		tag += '<label>취득일</label> ';
		tag += '<input type="date" class="form-control"	id="acquisition_date'+certificateCount+'" name="acquisition_date[]">';
		tag += '</div>';
		tag += '</div>';
		tag += '<div class="row">';
		tag += '<div class="col-sm-6">';
		tag += '<label>발급기관</label> ';
		tag += '<input type="text" class="form-control"	id="published_by_license'+certificateCount+'" name="published_by_license[]" readonly="readonly">';
		tag += '</div>';
		tag += '<div class="col-sm-6">';
		tag += '<label>등록번호</label> ';
		tag += '<input type="text" class="form-control"	id="certificate_num'+certificateCount+'" name="certificate_num[]">';
		tag += '</div>';
		tag += '</div>';
		tag += '</div>';
		tag += '</div>';
		$("#leftcolumn").append(tag);
	});
})
