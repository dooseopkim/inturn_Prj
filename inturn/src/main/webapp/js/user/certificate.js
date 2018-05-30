function deleteCertificate(certificateCount) {
	$("#license"+certificateCount).remove();
}
/**
 * 자격증 항목을 클릭할 때
 * @returns
 */
$(function(){
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
		tag += '<div class="col-sm-6">';
		tag += '<label>자격증</label> ';
		tag += '<input type="text" class="form-control"	id="certificate_name" name="certificate_name[]" readonly="readonly">';
		tag += '</div>';
		tag += '<div class="col-sm-6">';
		tag += '<label>취득일</label> ';
		tag += '<input type="date" class="form-control"	id="acquisition_date" name="acquisition_date[]" readonly="readonly">';
		tag += '</div>';
		tag += '</div>';
		tag += '<div class="row">';
		tag += '<div class="col-sm-6">';
		tag += '<label>발급기관</label> ';
		tag += '<input type="text" class="form-control"	id="published_by_license" name="published_by_license[]" readonly="readonly">';
		tag += '</div>';
		tag += '<div class="col-sm-6">';
		tag += '<label>등록번호</label> ';
		tag += '<input type="text" class="form-control"	id="certificate_num" name="certificate_num[]" readonly="readonly">';
		tag += '</div>';
		tag += '</div>';
		tag += '</div>';
		tag += '</div>';
		$("#leftcolumn").append(tag);
	});
})
