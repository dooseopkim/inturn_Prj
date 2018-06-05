/**
 * @author 박현호
 * @version 1.0
 * @since 2018.05.30
 * @see 자격증과 관련된 자바스크립트, JQuery함수
 */

/**
 * 페이지 로딩시 자격증 정보를 가져오는 함수
 */
$(window).load(function() {
	$.ajax({
		url: "getCertificates.do",
		success: function(data){
			if(data.result == "success") {
				getRegisteredCertificate(data.list);
			}
			else
				$("#license").css("display","none");
		}
	})
})

/**
 * 수정버튼 후 작성버튼 클릭시 자격증 수정
 * 수정 전 정보와, 수정 후 정보를 가져와 ajax로 보냄
 * temp로 시작하는 부분이 수정버튼을 누르면 만들어졌다가
 * 수정이 완료되면 삭제할 input 태그로
 * 이 태그를 이용해서 값을 주고 받는다
 */
function modify_cert(i) {
	var name = $("#registered_certificate_name"+i).val();
	var date = $("#registered_acquisition_date"+i).val();
	var pbl = $("#registered_published_by_license"+i).val();
	var certnum = $("#registered_certificate_num"+i).val();
	if(name == '') {
		$("#registered_certificate_name"+i).focus();
		alert("빈칸을 채워주세요");
		return false;
	}
	if(date == '') {
		$("#registered_acquisition_date"+i).focus();
		alert("빈칸을 채워주세요");
		return false;
	}
	if(pbl == '') {
		$("#registered_published_by_license"+i).focus();
		alert("빈칸을 채워주세요");
		return false;
	}
	if(certnum == '') {
		$("#registered_certificate_num"+i).focus();
		alert("빈칸을 채워주세요");
		return false;
	}
	$.ajax({
		url: "modifyCertificate.do",
		method: "POST",
		datatype: "JSON",
		data: {
			"certificate_name" : $("#temp_name"+i).val(),
			"acquisition_date" : $("#temp_date"+i).val(),
			"published_by_license" : $("#temp_pbl"+i).val(),
			"certificate_num" : $("#temp_certnum"+i).val(),
			"id" : $("#id").val(),
			"certificate_name" : name,
			"acquisition_date" : date,
			"published_by_license" : pbl,
			"certificate_num" : certnum,
			"id" : $("#id").val()
		},
		success: function(data) {
			if(data.result == "success") {
				$("#temp_name"+i).val(data.list.certificate_name); 
				$("#temp_date"+i).val(data.list.acquisition_date);
				$("#temp_pbl"+i).val(data.list.published_by_license);
				$("#temp_certnum"+i).val(data.list.certificate_num);
				cancel_reg_cert_Modify(i);
			}
			else
				alert("이미 등록된 자격증 번호입니다.");
		}
	})
}

/**
 * 수정 버튼 클릭후 수정 취소 시
 * 수정 버튼 클릭 직후 만들어져있던 temp input태그에서
 * 그 값들을 가져온 와 원래 값을 입력 후 다시 자격증 정보를 띄워줌
 */
function cancel_reg_cert_Modify(i) {
	name = $("#temp_name"+i).val(); 
	date = $("#temp_date"+i).val();
	pbl = $("#temp_pbl"+i).val();
	certnum = $("#temp_certnum"+i).val();
	$("#registered_certificate"+i).children().remove();
	$("#temp"+i).remove();
	var tag = '';
	tag += '<div id="registered_certificate'+i+'" class="row">';
	tag += '<div class="row">';
	tag += '<div id="cerName" class="col-sm-6">';
	tag += '<label>자격증</label> ';
	tag += '<input class="form-control" id="registered_certificate_name'+i+'"readonly="readonly" value="'+name+'">';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<label>취득일</label>';
	tag += '<input type="date" class="form-control" id="registered_acquisition_date'+i+'" readonly="readonly" value="'+date+'">';
	tag += '</div>';
	tag += '</div>';
	tag += '<div class="row">';
	tag += '<div class="col-sm-6">';
	tag += '<label>발급기관</label> ';
	tag += '<input type="text" class="form-control" id="registered_published_by_license'+i+'" readonly="readonly" value="'+pbl+'">';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<label>등록번호</label> ';
	tag += '<input type="text" class="form-control" id="registered_certificate_num'+i+'" readonly="readonly" value="'+certnum+'">';
	tag += '</div>';
	tag += '</div>';
	tag += '<div class="row text-right">';
	tag += '<br>';
	tag += '<button onclick="modifyCertificate('+i+')" class="btn btn-info">수정</button>';
	tag += '<button onclick="deleteRegisteredCertificate('+i+')" class="btn btn-danger">삭제</button>';
	tag += '</div>';
	tag += '</div>';
	$("#registered_certificate"+i).append(tag);
}

/**
 * 수정 시 자격증 이름을 바꾸면 자격증 발급처를 알아서 띄워주는 함수
 * 밑에 똑같은 함수가 자세히 설명되어있음
 * 모듈화시켜야하는데 정신이없어서 내뚬...
 * 마지막 발급처 input 태그만 다르고 내용은 똑같음
 */
function reg_publishedByLicense(num){
	var pbl = ["한국산업인력공단","대한상공회의소","영화진흥위원회","한국광해관리공단","한국기술자격검정원","한국방송통신전파진흥원","한국원자력안전기술원","한국인터넷진흥원","한국콘텐츠진흥원"];
	var cerName = $("#registered_certificate_name"+num).val();
	var option = document.querySelectorAll("#reg_datalist"+num+" option");
	var index = 0;
	for(i=0; i<option.length; i++) {
		if(option[i].innerText == cerName) {
			index = option[i].getAttribute('data-value') - 1;
		}
	}
	$("#registered_published_by_license"+num).val(pbl[index]);
}

/**
 * 수정 버튼을 눌렀을 때 수정할 수 있는 태그로 바뀌는 함수
 */
function modifyCertificate(num) {
	var name = $("#registered_certificate_name"+num).val();
	var date = $("#registered_acquisition_date"+num).val();
	var pbl = $("#registered_published_by_license"+num).val();
	var certnum = $("#registered_certificate_num"+num).val();
	$("#registered_certificate"+num).children().remove();
	var tag = '';
	tag += '<div id="temp'+num+'">';
	tag += '<input type="hidden" id="temp_name'+num+'" value="'+name+'">';
	tag += '<input type="hidden" id="temp_date'+num+'" value="'+date+'">';
	tag += '<input type="hidden" id="temp_pbl'+num+'" value="'+pbl+'">';
	tag += '<input type="hidden" id="temp_certnum'+num+'" value="'+certnum+'">';
	tag += '</div>'
	tag += '<div class="row">';
	tag += '<div id="cerName" class="col-sm-6">';
	tag += '<label>자격증</label> ';
	tag += '<input list="reg_datalist'+num+'" class="form-control" id="registered_certificate_name'+num+'" value="'+name+'" onchange="reg_publishedByLicense('+num+')">';
	tag += '<datalist id="reg_datalist'+num+'">';
	tag += '<option data-value="1">기중기운전기능사</option>';
	tag += '<option data-value="1">로더운전기능사</option>';
	tag += '<option data-value="1">롤러운전기능사</option>';
	tag += '<option data-value="1">불도저운전기능사</option>';
	tag += '<option data-value="1">양화장치운전기능사</option>';
	tag += '<option data-value="1">천공기운전기능사</option>';
	tag += '<option data-value="1">천장크레인운전기능사</option>';
	tag += '<option data-value="1">컨테이너크레인운전기능사</option>';
	tag += '<option data-value="1">타워크레인운전기능사</option>';
	tag += '<option data-value="1">배관기능사</option>';
	tag += '<option data-value="1">배관기능장</option>';
	tag += '<option data-value="1">배관산업기사</option>';
	tag += '<option data-value="1">거푸집기능사</option>';
	tag += '<option data-value="1">건축구조기술사</option>';
	tag += '<option data-value="1">건축기계설비기술사</option>';
	tag += '<option data-value="1">건축기사</option>';
	tag += '<option data-value="1">건축도장기능사</option>';
	tag += '<option data-value="1">건축목공기능사</option>';
	tag += '<option data-value="1">건축목공산업기사</option>';
	tag += '<option data-value="1">건축목재시공기능장</option>';
	tag += '<option data-value="1">건축산업기사</option>';
	tag += '<option data-value="1">건축설비기사</option>';
	tag += '<option data-value="1">건축설비산업기사</option>';
	tag += '<option data-value="1">건축시공기술사</option>';
	tag += '<option data-value="1">건축일반시공기능장</option>';
	tag += '<option data-value="1">건축일반시공산업기사</option>';
	tag += '<option data-value="1">건축품질시험기술사</option>';
	tag += '<option data-value="1">도배기능사</option>';
	tag += '<option data-value="1">미장기능사</option>';
	tag += '<option data-value="1">방수기능사</option>';
	tag += '<option data-value="1">방수산업기사</option>';
	tag += '<option data-value="1">비계기능사</option>';
	tag += '<option data-value="1">실내건축기능사</option>';
	tag += '<option data-value="1">실내건축기사</option>';
	tag += '<option data-value="1">실내건축산업기사</option>';
	tag += '<option data-value="1">온수온돌기능사</option>';
	tag += '<option data-value="1">유리시공기능사</option>';
	tag += '<option data-value="1">전산응용건축제도기능사</option>';
	tag += '<option data-value="1">조적기능사</option>';
	tag += '<option data-value="1">철근기능사</option>';
	tag += '<option data-value="1">타일기능사</option>';
	tag += '<option data-value="1">세탁기능사</option>';
	tag += '<option data-value="1">사회조사분석사1급</option>';
	tag += '<option data-value="1">사회조사분석사2급</option>';
	tag += '<option data-value="1">소비자전문상담사1급</option>';
	tag += '<option data-value="1">소비자전문상담사2급</option>';
	tag += '<option data-value="1">컨벤션기획사1급</option>';
	tag += '<option data-value="1">컨벤션기획사2급</option>';
	tag += '<option data-value="1">금속가공기술사</option>';
	tag += '<option data-value="1">금속재료기능장</option>';
	tag += '<option data-value="1">금속재료기사</option>';
	tag += '<option data-value="1">금속재료기술사</option>';
	tag += '<option data-value="1">금속재료산업기사</option>';
	tag += '<option data-value="1">금속재료시험기능사</option>';
	tag += '<option data-value="1">금속제련기술사</option>';
	tag += '<option data-value="1">세라믹기술사</option>';
	tag += '<option data-value="1">압연기능사</option>';
	tag += '<option data-value="1">압연기능장</option>';
	tag += '<option data-value="1">열처리기능사</option>';
	tag += '<option data-value="1">재료조직평가산업기사</option>';
	tag += '<option data-value="1">제강기능사</option>';
	tag += '<option data-value="1">제강기능장</option>';
	tag += '<option data-value="1">제선기능사</option>';
	tag += '<option data-value="1">제선기능장</option>';
	tag += '<option data-value="1">축로기능사</option>';
	tag += '<option data-value="1">금형기능사</option>';
	tag += '<option data-value="1">금형기술사</option>';
	tag += '<option data-value="1">금형제작기능장</option>';
	tag += '<option data-value="1">사출금형산업기사</option>';
	tag += '<option data-value="1">사출금형설계기사</option>';
	tag += '<option data-value="1">프레스금형산업기사</option>';
	tag += '<option data-value="1">프레스금형설계기사</option>';
	tag += '<option data-value="1">건설기계기술사</option>';
	tag += '<option data-value="1">건설기계설비기사</option>';
	tag += '<option data-value="1">건설기계설비산업기사</option>';
	tag += '<option data-value="1">건설기계정비기능사</option>';
	tag += '<option data-value="1">건설기계정비기능장</option>';
	tag += '<option data-value="1">건설기계정비기사</option>';
	tag += '<option data-value="1">건설기계정비산업기사</option>';
	tag += '<option data-value="1">공조냉동기계기능사</option>';
	tag += '<option data-value="1">공조냉동기계기사</option>';
	tag += '<option data-value="1">공조냉동기계기술사</option>';
	tag += '<option data-value="1">공조냉동기계산업기사</option>';
	tag += '<option data-value="1">궤도장비정비기능사</option>';
	tag += '<option data-value="1">궤도장비정비기사</option>';
	tag += '<option data-value="1">궤도장비정비산업기사</option>';
	tag += '<option data-value="1">기계정비기능사</option>';
	tag += '<option data-value="1">기계정비산업기사</option>';
	tag += '<option data-value="1">농기계정비기능사</option>';
	tag += '<option data-value="1">농업기계기사</option>';
	tag += '<option data-value="1">농업기계산업기사</option>';
	tag += '<option data-value="1">메카트로닉스기사</option>';
	tag += '<option data-value="1">반도체장비유지보수기능사</option>';
	tag += '<option data-value="1">산업기계설비기술사</option>';
	tag += '<option data-value="1">생산자동화기능사</option>';
	tag += '<option data-value="1">생산자동화산업기사</option>';
	tag += '<option data-value="1">설비보전기능사</option>';
	tag += '<option data-value="1">설비보전기사</option>';
	tag += '<option data-value="1">승강기기능사</option>';
	tag += '<option data-value="1">승강기기사</option>';
	tag += '<option data-value="1">승강기산업기사</option>';
	tag += '<option data-value="1">전자부품장착기능사</option>';
	tag += '<option data-value="1">전자부품장착산업기사</option>';
	tag += '<option data-value="1">공유압기능사</option>';
	tag += '<option data-value="1">기계가공기능장</option>';
	tag += '<option data-value="1">기계가공조립기능사</option>';
	tag += '<option data-value="1">기계가공조립산업기사</option>';
	tag += '<option data-value="1">기계기술사</option>';
	tag += '<option data-value="1">기계설계기사</option>';
	tag += '<option data-value="1">기계설계산업기사</option>';
	tag += '<option data-value="1">연삭기능사</option>';
	tag += '<option data-value="1">일반기계기사</option>';
	tag += '<option data-value="1">전산응용기계제도기능사</option>';
	tag += '<option data-value="1">정밀측정기능사</option>';
	tag += '<option data-value="1">정밀측정산업기사</option>';
	tag += '<option data-value="1">치공구설계산업기사</option>';
	tag += '<option data-value="1">컴퓨터응용가공산업기사</option>';
	tag += '<option data-value="1">컴퓨터응용밀링기능사</option>';
	tag += '<option data-value="1">컴퓨터응용선반기능사</option>';
	tag += '<option data-value="1">농화학기술사</option>';
	tag += '<option data-value="1">시설원예기사</option>';
	tag += '<option data-value="1">시설원예기술사</option>';
	tag += '<option data-value="1">원예기능사</option>';
	tag += '<option data-value="1">유기농업기능사</option>';
	tag += '<option data-value="1">유기농업기사</option>';
	tag += '<option data-value="1">유기농업산업기사</option>';
	tag += '<option data-value="1">종자기능사</option>';
	tag += '<option data-value="1">종자기사</option>';
	tag += '<option data-value="1">종자기술사</option>';
	tag += '<option data-value="1">종자산업기사</option>';
	tag += '<option data-value="1">화훼장식기능사</option>';
	tag += '<option data-value="1">화훼장식기사</option>';
	tag += '<option data-value="1">원형기능사</option>';
	tag += '<option data-value="1">주조기능사</option>';
	tag += '<option data-value="1">주조기능장</option>';
	tag += '<option data-value="1">주조산업기사</option>';
	tag += '<option data-value="1">교통기사</option>';
	tag += '<option data-value="1">교통기술사</option>';
	tag += '<option data-value="1">교통산업기사</option>';
	tag += '<option data-value="1">도시계획기사</option>';
	tag += '<option data-value="1">도시계획기술사</option>';
	tag += '<option data-value="1">광고도장기능사</option>';
	tag += '<option data-value="1">금속도장기능사</option>';
	tag += '<option data-value="1">표면처리기능사</option>';
	tag += '<option data-value="1">표면처리기능장</option>';
	tag += '<option data-value="1">표면처리기술사</option>';
	tag += '<option data-value="1">표면처리산업기사</option>';
	tag += '<option data-value="1">시각디자인기사</option>';
	tag += '<option data-value="1">시각디자인산업기사</option>';
	tag += '<option data-value="1">웹디자인기능사</option>';
	tag += '<option data-value="1">제품디자인기사</option>';
	tag += '<option data-value="1">제품디자인기술사</option>';
	tag += '<option data-value="1">제품디자인산업기사</option>';
	tag += '<option data-value="1">제품응용모델링기능사</option>';
	tag += '<option data-value="1">컬러리스트기사</option>';
	tag += '<option data-value="1">컬러리스트산업기사</option>';
	tag += '<option data-value="1">컴퓨터그래픽스운용기능사</option>';
	tag += '<option data-value="1">가구제작기능사</option>';
	tag += '<option data-value="1">귀금속가공기능사</option>';
	tag += '<option data-value="1">귀금속가공기능장</option>';
	tag += '<option data-value="1">귀금속가공산업기사</option>';
	tag += '<option data-value="1">도자기공예기능사</option>';
	tag += '<option data-value="1">목공예기능사</option>';
	tag += '<option data-value="1">보석가공기능사</option>';
	tag += '<option data-value="1">보석감정사</option>';
	tag += '<option data-value="1">석공예기능사</option>';
	tag += '<option data-value="1">피아노조율기능사</option>';
	tag += '<option data-value="1">피아노조율산업기사</option>';
	tag += '<option data-value="1">국제의료관광코디네이터</option>';
	tag += '<option data-value="1">임상심리사1급</option>';
	tag += '<option data-value="1">임상심리사2급</option>';
	tag += '<option data-value="1">누설비파괴검사기사</option>';
	tag += '<option data-value="1">방사선비파괴검사기능사</option>';
	tag += '<option data-value="1">방사선비파괴검사기사</option>';
	tag += '<option data-value="1">방사선비파괴검사산업기사</option>';
	tag += '<option data-value="1">비파괴검사기술사</option>';
	tag += '<option data-value="1">와전류비파괴검사기사</option>';
	tag += '<option data-value="1">자기비파괴검사기능사</option>';
	tag += '<option data-value="1">자기비파괴검사기사</option>';
	tag += '<option data-value="1">자기비파괴검사산업기사</option>';
	tag += '<option data-value="1">초음파비파괴검사기능사</option>';
	tag += '<option data-value="1">초음파비파괴검사기사</option>';
	tag += '<option data-value="1">초음파비파괴검사산업기사</option>';
	tag += '<option data-value="1">침투비파괴검사기능사</option>';
	tag += '<option data-value="1">침투비파괴검사기사</option>';
	tag += '<option data-value="1">침투비파괴검사산업기사</option>';
	tag += '<option data-value="1">직업상담사1급</option>';
	tag += '<option data-value="1">직업상담사2급</option>';
	tag += '<option data-value="1">공장관리기술사</option>';
	tag += '<option data-value="1">포장기사</option>';
	tag += '<option data-value="1">포장기술사</option>';
	tag += '<option data-value="1">포장산업기사</option>';
	tag += '<option data-value="1">품질경영기사</option>';
	tag += '<option data-value="1">품질경영산업기사</option>';
	tag += '<option data-value="1">품질관리기술사</option>';
	tag += '<option data-value="1">섬유기사</option>';
	tag += '<option data-value="1">섬유기술사</option>';
	tag += '<option data-value="1">섬유디자인산업기사</option>';
	tag += '<option data-value="1">섬유산업기사</option>';
	tag += '<option data-value="1">염색기능사(날염)</option>';
	tag += '<option data-value="1">염색기능사(침염)</option>';
	tag += '<option data-value="1">의류기사</option>';
	tag += '<option data-value="1">의류기술사</option>';
	tag += '<option data-value="1">스포츠경영관리사</option>';
	tag += '<option data-value="1">수산제조기사</option>';
	tag += '<option data-value="1">수산제조기술사</option>';
	tag += '<option data-value="1">식품가공기능사</option>';
	tag += '<option data-value="1">식품기사</option>';
	tag += '<option data-value="1">식품기술사</option>';
	tag += '<option data-value="1">식품산업기사</option>';
	tag += '<option data-value="1">가스기능사</option>';
	tag += '<option data-value="1">가스기능장</option>';
	tag += '<option data-value="1">가스기사</option>';
	tag += '<option data-value="1">가스기술사</option>';
	tag += '<option data-value="1">가스산업기사</option>';
	tag += '<option data-value="1">건설안전기사</option>';
	tag += '<option data-value="1">건설안전기술사</option>';
	tag += '<option data-value="1">건설안전산업기사</option>';
	tag += '<option data-value="1">기계안전기술사</option>';
	tag += '<option data-value="1">산업안전기사</option>';
	tag += '<option data-value="1">산업안전산업기사</option>';
	tag += '<option data-value="1">산업위생관리기사</option>';
	tag += '<option data-value="1">산업위생관리기술사</option>';
	tag += '<option data-value="1">산업위생관리산업기사</option>';
	tag += '<option data-value="1">소방기술사</option>';
	tag += '<option data-value="1">소방설비기사(기계분야)</option>';
	tag += '<option data-value="1">소방설비기사(전기분야)</option>';
	tag += '<option data-value="1">소방설비산업기사(기계분야)</option>';
	tag += '<option data-value="1">소방설비산업기사(전기분야)</option>';
	tag += '<option data-value="1">인간공학기사</option>';
	tag += '<option data-value="1">인간공학기술사</option>';
	tag += '<option data-value="1">전기안전기술사</option>';
	tag += '<option data-value="1">화공안전기술사</option>';
	tag += '<option data-value="1">화재감식평가기사</option>';
	tag += '<option data-value="1">화재감식평가산업기사</option>';
	tag += '<option data-value="1">수산양식기능사</option>';
	tag += '<option data-value="1">수산양식기사</option>';
	tag += '<option data-value="1">수산양식기술사</option>';
	tag += '<option data-value="1">수산양식산업기사</option>';
	tag += '<option data-value="1">어로기술사</option>';
	tag += '<option data-value="1">어로산업기사</option>';
	tag += '<option data-value="1">어업생산관리기사</option>';
	tag += '<option data-value="1">기상감정기사</option>';
	tag += '<option data-value="1">기상기사</option>';
	tag += '<option data-value="1">기상예보기술사</option>';
	tag += '<option data-value="1">신재생에너지발전설비기능사(태양광)</option>';
	tag += '<option data-value="1">신재생에너지발전설비기사(태양광)</option>';
	tag += '<option data-value="1">신재생에너지발전설비산업기사(태양광)</option>';
	tag += '<option data-value="1">에너지관리기능사</option>';
	tag += '<option data-value="1">에너지관리기능장</option>';
	tag += '<option data-value="1">에너지관리기사</option>';
	tag += '<option data-value="1">에너지관리산업기사</option>';
	tag += '<option data-value="1">텔레마케팅관리사</option>';
	tag += '<option data-value="1">용접기능사</option>';
	tag += '<option data-value="1">용접기능장</option>';
	tag += '<option data-value="1">용접기사</option>';
	tag += '<option data-value="1">용접기술사</option>';
	tag += '<option data-value="1">용접산업기사</option>';
	tag += '<option data-value="1">특수용접기능사</option>';
	tag += '<option data-value="1">농기계운전기능사</option>';
	tag += '<option data-value="1">철도운송산업기사</option>';
	tag += '<option data-value="1">위험물기능사</option>';
	tag += '<option data-value="1">위험물기능장</option>';
	tag += '<option data-value="1">위험물산업기사</option>';
	tag += '<option data-value="1">신발류제조기능사</option>';
	tag += '<option data-value="1">양복기능사</option>';
	tag += '<option data-value="1">양장기능사</option>';
	tag += '<option data-value="1">패션디자인산업기사</option>';
	tag += '<option data-value="1">패션머천다이징산업기사</option>';
	tag += '<option data-value="1">한복기능사</option>';
	tag += '<option data-value="1">한복산업기사</option>';
	tag += '<option data-value="1">미용사(네일)</option>';
	tag += '<option data-value="1">미용사(메이크업)</option>';
	tag += '<option data-value="1">미용장</option>';
	tag += '<option data-value="1">이용사</option>';
	tag += '<option data-value="1">이용장</option>';
	tag += '<option data-value="1">사진기능사</option>';
	tag += '<option data-value="1">인쇄기능사</option>';
	tag += '<option data-value="1">인쇄기사</option>';
	tag += '<option data-value="1">인쇄산업기사</option>';
	tag += '<option data-value="1">전자출판기능사</option>';
	tag += '<option data-value="1">버섯종균기능사</option>';
	tag += '<option data-value="1">산림기능사</option>';
	tag += '<option data-value="1">산림기사</option>';
	tag += '<option data-value="1">산림기술사</option>';
	tag += '<option data-value="1">산림산업기사</option>';
	tag += '<option data-value="1">식물보호기사</option>';
	tag += '<option data-value="1">식물보호산업기사</option>';
	tag += '<option data-value="1">임산가공기능사</option>';
	tag += '<option data-value="1">임산가공기사</option>';
	tag += '<option data-value="1">임산가공산업기사</option>';
	tag += '<option data-value="1">임업종묘기능사</option>';
	tag += '<option data-value="1">임업종묘기사</option>';
	tag += '<option data-value="1">그린전동자동차기사</option>';
	tag += '<option data-value="1">자동차보수도장기능사</option>';
	tag += '<option data-value="1">자동차정비기능사</option>';
	tag += '<option data-value="1">자동차정비기능장</option>';
	tag += '<option data-value="1">자동차정비기사</option>';
	tag += '<option data-value="1">자동차정비산업기사</option>';
	tag += '<option data-value="1">자동차차체수리기능사</option>';
	tag += '<option data-value="1">차량기술사</option>';
	tag += '<option data-value="1">건축전기설비기술사</option>';
	tag += '<option data-value="1">발송배전기술사</option>';
	tag += '<option data-value="1">전기공사기사</option>';
	tag += '<option data-value="1">전기공사산업기사</option>';
	tag += '<option data-value="1">전기기능사</option>';
	tag += '<option data-value="1">전기기능장</option>';
	tag += '<option data-value="1">전기기사</option>';
	tag += '<option data-value="1">전기산업기사</option>';
	tag += '<option data-value="1">전기응용기술사</option>';
	tag += '<option data-value="1">전기철도기사</option>';
	tag += '<option data-value="1">전기철도기술사</option>';
	tag += '<option data-value="1">전기철도산업기사</option>';
	tag += '<option data-value="1">철도신호기사</option>';
	tag += '<option data-value="1">철도신호기술사</option>';
	tag += '<option data-value="1">철도신호산업기사</option>';
	tag += '<option data-value="1">철도전기신호기능사</option>';
	tag += '<option data-value="1">광학기기산업기사</option>';
	tag += '<option data-value="1">광학기능사</option>';
	tag += '<option data-value="1">광학기사</option>';
	tag += '<option data-value="1">반도체설계기사</option>';
	tag += '<option data-value="1">반도체설계산업기사</option>';
	tag += '<option data-value="1">산업계측제어기술사</option>';
	tag += '<option data-value="1">의공기사</option>';
	tag += '<option data-value="1">의공산업기사</option>';
	tag += '<option data-value="1">의료전자기능사</option>';
	tag += '<option data-value="1">임베디드기사</option>';
	tag += '<option data-value="1">전자계산기기능사</option>';
	tag += '<option data-value="1">전자계산기기사</option>';
	tag += '<option data-value="1">전자계산기제어산업기사</option>';
	tag += '<option data-value="1">전자기기기능사</option>';
	tag += '<option data-value="1">전자기기기능장</option>';
	tag += '<option data-value="1">전자기사</option>';
	tag += '<option data-value="1">전자산업기사</option>';
	tag += '<option data-value="1">전자응용기술사</option>';
	tag += '<option data-value="1">전자캐드기능사</option>';
	tag += '<option data-value="1">멀티미디어콘텐츠제작전문가</option>';
	tag += '<option data-value="1">사무자동화산업기사</option>';
	tag += '<option data-value="1">전자계산기조직응용기사</option>';
	tag += '<option data-value="1">정보관리기술사</option>';
	tag += '<option data-value="1">정보처리기사</option>';
	tag += '<option data-value="1">정보처리산업기사</option>';
	tag += '<option data-value="1">컴퓨터시스템응용기술사</option>';
	tag += '<option data-value="1">제과기능장</option>';
	tag += '<option data-value="1">조경기능사</option>';
	tag += '<option data-value="1">조경기사</option>';
	tag += '<option data-value="1">조경기술사</option>';
	tag += '<option data-value="1">조경산업기사</option>';
	tag += '<option data-value="1">복어조리기능사</option>';
	tag += '<option data-value="1">조리기능장</option>';
	tag += '<option data-value="1">조리산업기사(복어)</option>';
	tag += '<option data-value="1">조리산업기사(양식)</option>';
	tag += '<option data-value="1">조리산업기사(일식)</option>';
	tag += '<option data-value="1">조리산업기사(중식)</option>';
	tag += '<option data-value="1">조리산업기사(한식)</option>';
	tag += '<option data-value="1">조주기능사</option>';
	tag += '<option data-value="1">동력기계정비기능사</option>';
	tag += '<option data-value="1">선체건조기능사</option>';
	tag += '<option data-value="1">전산응용조선제도기능사</option>';
	tag += '<option data-value="1">조선기사</option>';
	tag += '<option data-value="1">조선기술사</option>';
	tag += '<option data-value="1">조선산업기사</option>';
	tag += '<option data-value="1">화약류관리기사</option>';
	tag += '<option data-value="1">화약류관리기술사</option>';
	tag += '<option data-value="1">화약류관리산업기사</option>';
	tag += '<option data-value="1">화약취급기능사</option>';
	tag += '<option data-value="1">철도차량기사</option>';
	tag += '<option data-value="1">철도차량기술사</option>';
	tag += '<option data-value="1">철도차량산업기사</option>';
	tag += '<option data-value="1">철도차량정비기능사</option>';
	tag += '<option data-value="1">철도차량정비기능장</option>';
	tag += '<option data-value="1">식육처리기능사</option>';
	tag += '<option data-value="1">축산기능사</option>';
	tag += '<option data-value="1">축산기사</option>';
	tag += '<option data-value="1">축산기술사</option>';
	tag += '<option data-value="1">축산산업기사</option>';
	tag += '<option data-value="1">건설재료시험기능사</option>';
	tag += '<option data-value="1">건설재료시험기사</option>';
	tag += '<option data-value="1">건설재료시험산업기사</option>';
	tag += '<option data-value="1">농어업토목기술사</option>';
	tag += '<option data-value="1">도로및공항기술사</option>';
	tag += '<option data-value="1">도화기능사</option>';
	tag += '<option data-value="1">상하수도기술사</option>';
	tag += '<option data-value="1">석공기능사</option>';
	tag += '<option data-value="1">수자원개발기술사</option>';
	tag += '<option data-value="1">응용지질기사</option>';
	tag += '<option data-value="1">잠수기능사</option>';
	tag += '<option data-value="1">잠수산업기사</option>';
	tag += '<option data-value="1">전산응용토목제도기능사</option>';
	tag += '<option data-value="1">지도제작기능사</option>';
	tag += '<option data-value="1">지적기능사</option>';
	tag += '<option data-value="1">지적기사</option>';
	tag += '<option data-value="1">지적기술사</option>';
	tag += '<option data-value="1">지적산업기사</option>';
	tag += '<option data-value="1">지질및지반기술사</option>';
	tag += '<option data-value="1">철도기술사</option>';
	tag += '<option data-value="1">철도토목기능사</option>';
	tag += '<option data-value="1">철도토목기사</option>';
	tag += '<option data-value="1">철도토목산업기사</option>';
	tag += '<option data-value="1">측량기능사</option>';
	tag += '<option data-value="1">측량및지형공간정보기사</option>';
	tag += '<option data-value="1">측량및지형공간정보기술사</option>';
	tag += '<option data-value="1">측량및지형공간정보산업기사</option>';
	tag += '<option data-value="1">콘크리트기능사</option>';
	tag += '<option data-value="1">콘크리트기사</option>';
	tag += '<option data-value="1">콘크리트산업기사</option>';
	tag += '<option data-value="1">토목구조기술사</option>';
	tag += '<option data-value="1">토목기사</option>';
	tag += '<option data-value="1">토목산업기사</option>';
	tag += '<option data-value="1">토목시공기술사</option>';
	tag += '<option data-value="1">토목품질시험기술사</option>';
	tag += '<option data-value="1">토질및기초기술사</option>';
	tag += '<option data-value="1">항공사진기능사</option>';
	tag += '<option data-value="1">항로표지기능사</option>';
	tag += '<option data-value="1">항로표지기사</option>';
	tag += '<option data-value="1">항로표지산업기사</option>';
	tag += '<option data-value="1">항만및해안기술사</option>';
	tag += '<option data-value="1">해양공학기사</option>';
	tag += '<option data-value="1">해양기술사</option>';
	tag += '<option data-value="1">해양자원개발기사</option>';
	tag += '<option data-value="1">해양조사산업기사</option>';
	tag += '<option data-value="1">해양환경기사</option>';
	tag += '<option data-value="1">금속재창호기능사</option>';
	tag += '<option data-value="1">판금제관기능사</option>';
	tag += '<option data-value="1">판금제관기능장</option>';
	tag += '<option data-value="1">판금제관산업기사</option>';
	tag += '<option data-value="1">플라스틱창호기능사</option>';
	tag += '<option data-value="1">항공기관기술사</option>';
	tag += '<option data-value="1">항공기관정비기능사</option>';
	tag += '<option data-value="1">항공기사</option>';
	tag += '<option data-value="1">항공기체기술사</option>';
	tag += '<option data-value="1">항공기체정비기능사</option>';
	tag += '<option data-value="1">항공산업기사</option>';
	tag += '<option data-value="1">항공장비정비기능사</option>';
	tag += '<option data-value="1">항공전자정비기능사</option>';
	tag += '<option data-value="1">생물공학기사</option>';
	tag += '<option data-value="1">화공기사</option>';
	tag += '<option data-value="1">화공기술사</option>';
	tag += '<option data-value="1">화약류제조기사</option>';
	tag += '<option data-value="1">화약류제조산업기사</option>';
	tag += '<option data-value="1">화학분석기능사</option>';
	tag += '<option data-value="1">화학분석기사</option>';
	tag += '<option data-value="1">농림토양평가관리산업기사</option>';
	tag += '<option data-value="1">대기관리기술사</option>';
	tag += '<option data-value="1">대기환경기사</option>';
	tag += '<option data-value="1">대기환경산업기사</option>';
	tag += '<option data-value="1">생물분류기사(동물)</option>';
	tag += '<option data-value="1">생물분류기사(식물)</option>';
	tag += '<option data-value="1">소음진동기사</option>';
	tag += '<option data-value="1">소음진동기술사</option>';
	tag += '<option data-value="1">소음진동산업기사</option>';
	tag += '<option data-value="1">수질관리기술사</option>';
	tag += '<option data-value="1">수질환경기사</option>';
	tag += '<option data-value="1">수질환경산업기사</option>';
	tag += '<option data-value="1">온실가스관리기사</option>';
	tag += '<option data-value="1">온실가스관리산업기사</option>';
	tag += '<option data-value="1">자연생태복원기사</option>';
	tag += '<option data-value="1">자연생태복원산업기사</option>';
	tag += '<option data-value="1">자연환경관리기술사</option>';
	tag += '<option data-value="1">토양환경기사</option>';
	tag += '<option data-value="1">토양환경기술사</option>';
	tag += '<option data-value="1">폐기물처리기사</option>';
	tag += '<option data-value="1">폐기물처리기술사</option>';
	tag += '<option data-value="1">폐기물처리산업기사</option>';
	tag += '<option data-value="1">환경기능사</option>';
	tag += '<option data-value="2">비서1급</option>';
	tag += '<option data-value="2">비서2급</option>';
	tag += '<option data-value="2">비서3급</option>';
	tag += '<option data-value="2">워드프로세서</option>';
	tag += '<option data-value="2">전산회계운용사 1급</option>';
	tag += '<option data-value="2">전산회계운용사 2급</option>';
	tag += '<option data-value="2">전산회계운용사 3급</option>';
	tag += '<option data-value="2">전자상거래관리사1급</option>';
	tag += '<option data-value="2">전자상거래관리사2급</option>';
	tag += '<option data-value="2">전자상거래운용사</option>';
	tag += '<option data-value="2">컴퓨터활용능력1급</option>';
	tag += '<option data-value="2">컴퓨터활용능력2급</option>';
	tag += '<option data-value="2">한글속기1급</option>';
	tag += '<option data-value="2">한글속기2급</option>';
	tag += '<option data-value="2">한글속기3급</option>';
	tag += '<option data-value="3">영사기능사</option>';
	tag += '<option data-value="3">영사산업기사</option>';
	tag += '<option data-value="4">광산보안기능사</option>';
	tag += '<option data-value="4">광산보안기사</option>';
	tag += '<option data-value="4">광산보안산업기사</option>';
	tag += '<option data-value="4">광해방지기사</option>';
	tag += '<option data-value="4">광해방지기술사</option>';
	tag += '<option data-value="4">시추기능사</option>';
	tag += '<option data-value="4">자원관리기술사</option>';
	tag += '<option data-value="5">굴삭기운전기능사</option>';
	tag += '<option data-value="5">미용사(일반)</option>';
	tag += '<option data-value="5">미용사(피부)</option>';
	tag += '<option data-value="5">양식조리기능사</option>';
	tag += '<option data-value="5">일식조리기능사</option>';
	tag += '<option data-value="5">정보기기운용기능사</option>';
	tag += '<option data-value="5">정보처리기능사</option>';
	tag += '<option data-value="5">제과기능사</option>';
	tag += '<option data-value="5">제빵기능사</option>';
	tag += '<option data-value="5">중식조리기능사</option>';
	tag += '<option data-value="5">지게차운전기능사</option>';
	tag += '<option data-value="5">한식조리기능사</option>';
	tag += '<option data-value="6">무선설비기능사</option>';
	tag += '<option data-value="6">무선설비기사</option>';
	tag += '<option data-value="6">무선설비산업기사</option>';
	tag += '<option data-value="6">방송통신기능사</option>';
	tag += '<option data-value="6">방송통신기사</option>';
	tag += '<option data-value="6">방송통신산업기사</option>';
	tag += '<option data-value="6">전파전자통신기능사</option>';
	tag += '<option data-value="6">전파전자통신기사</option>';
	tag += '<option data-value="6">전파전자통신산업기사</option>';
	tag += '<option data-value="6">정보통신기사</option>';
	tag += '<option data-value="6">정보통신기술사</option>';
	tag += '<option data-value="6">정보통신산업기사</option>';
	tag += '<option data-value="6">통신기기기능사</option>';
	tag += '<option data-value="6">통신선로기능사</option>';
	tag += '<option data-value="6">통신선로산업기사</option>';
	tag += '<option data-value="6">통신설비기능장</option>';
	tag += '<option data-value="7">방사선관리기술사</option>';
	tag += '<option data-value="7">원자력기사</option>';
	tag += '<option data-value="7">원자력발전기술사</option>';
	tag += '<option data-value="8">정보보안기사</option>';
	tag += '<option data-value="8">정보보안산업기사</option>';
	tag += '<option data-value="9">게임그래픽전문가</option>';
	tag += '<option data-value="9">게임기획전문가</option>';
	tag += '<option data-value="9">게임프로그래밍전문가</option>';
	tag += '</datalist>';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<label>취득일</label> ';
	tag += '<input type="date" class="form-control"	id="registered_acquisition_date'+num+'" value="'+date+'">';
	tag += '</div>';
	tag += '</div>';
	tag += '<div class="row">';
	tag += '<div class="col-sm-6">';
	tag += '<label>발급기관</label> ';
	tag += '<input type="text" class="form-control" readonly="readonly" id="registered_published_by_license'+num+'" value="'+pbl+'">';
	tag += '</div>';
	tag += '<div class="col-sm-6">';
	tag += '<label>등록번호</label> ';
	tag += '<input type="text" class="form-control" id="registered_certificate_num'+num+'" value="'+certnum+'">';
	tag += '</div>';
	tag += '</div>';
	tag += '<div class="row text-right">';
	tag += '<br>';
	tag += '<button onclick="modify_cert('+num+')" class="btn btn-info">저장</button>';
	tag += '<button onclick="cancel_reg_cert_Modify('+num+')" class="btn btn-danger">취소</button>';
	tag += '</div>';
	tag += '</div>';
	$("#registered_certificate"+num).append(tag);
}

function deleteRegisteredCertificate(num) {
	if(confirm("정말 삭제하시겠습니까?")) {
		$.ajax({
			url: "deleteRegisteredCertificate.do",
			method: "POST",
			datatype: "JSON",
			data: {
				"certificate_num" : $("#registered_certificate_num"+num).val()
			},
			success: function(data) {
				if(data.result == "success")
					$("#registered_certificate"+num).remove();
			}
		})
	}
}

/**
 * 등록된 자격증 정보를 띄워주는 함수
 */
function getRegisteredCertificate(list) {
	for(i=list.length-1; i>=0; i--) {
		var tag = '';
		tag += '<div id="registered_certificate'+i+'" class="row">';
		tag += '<div class="row">';
		tag += '<div id="cerName" class="col-sm-6">';
		tag += '<label>자격증</label> ';
		tag += '<input class="form-control" id="registered_certificate_name'+i+'"readonly="readonly" value="'+list[i].certificate_name+'">';
		tag += '</div>';
		tag += '<div class="col-sm-6">';
		tag += '<label>취득일</label>';
		tag += '<input type="date" class="form-control" id="registered_acquisition_date'+i+'" readonly="readonly" value="'+list[i].acquisition_date+'">';
		tag += '</div>';
		tag += '</div>';
		tag += '<div class="row">';
		tag += '<div class="col-sm-6">';
		tag += '<label>발급기관</label> ';
		tag += '<input type="text" class="form-control" id="registered_published_by_license'+i+'" readonly="readonly" value="'+list[i].published_by_license+'">';
		tag += '</div>';
		tag += '<div class="col-sm-6">';
		tag += '<label>등록번호</label> ';
		tag += '<input type="text" class="form-control" id="registered_certificate_num'+i+'" readonly="readonly" value="'+list[i].certificate_num+'">';
		tag += '</div>';
		tag += '</div>';
		tag += '<div class="row text-right">';
		tag += '<br>';
		tag += '<button onclick="modifyCertificate('+i+')" class="btn btn-info">수정</button>';
		tag += '<button onclick="deleteRegisteredCertificate('+i+')" class="btn btn-danger">삭제</button>';
		tag += '</div>';
		tag += '</div>';
		$("#plusCertificate").prepend(tag);
	}
}

/**
 * 자격증 DB에 등록하는 함수
 * 먼저 name이 배열인 애들의 태그를 모두 각각의 이름으로 가져온다.
 * 이 후 그 태그들의 값을 입력받을 배열을 하나씩 만든다.
 * 각각 태그 배열을 순서대로 배열변수에 넣은 후 
 * ajax를 통해 server로 전송
 * 배열로 전송할 때에는, $.ajaxSettings.traditional = true;를 해주어야한다.
 * 직렬화 해주는 것이라고? 보면된다.
 * 객체로 만들어서 Array에 담아 보내봤는데 bad request로 에러가 발생해서
 * 그냥 배열로 모두 전송해서 DB에 넣었다.
 */
function insertCertificate() {
	var certificate_num = $("input[name='certificate_num[]']");
	var certificate_name = $("input[name='certificate_name[]']");
	var published_by_license = $("input[name='published_by_license[]']");
	var acquisition_date = $("input[name='acquisition_date[]']");
	var id = $("#id").val();

	var certificate_num_arr = Array();
	var certificate_name_arr = Array();
	var published_by_license_arr = Array();
	var acquisition_date_arr = Array();
	
	var j=0;
	for(i=0; i<certificate_num.length; i++) {
		certificate_num_arr[j] = certificate_num[i].value;
		if(certificate_num_arr[j] == '') {
			alert("빈칸을 채워주세요");
			$("#certificate_num"+i).focus();
			return false;
		}
		certificate_name_arr[j] = certificate_name[i].value;
		if(certificate_name_arr[j] == '') {
			alert("빈칸을 채워주세요");
			$("#certificate_name"+i).focus();
			return false;
		}
		published_by_license_arr[j] = published_by_license[i].value;
		if(published_by_license_arr[j] == '') {
			alert("빈칸을 채워주세요");
			$("#published_by_license"+i).focus();
			return false;
		}
		acquisition_date_arr[j] = acquisition_date[i].value;
		if(acquisition_date_arr[j] == '') {
			alert("빈칸을 채워주세요");
			$("#acquisition_date"+i).focus();
			return false;
		}
		j++;
	}
	
	$.ajaxSettings.traditional = true;
	$.ajax({
		url: "insertCertificate.do",
		method: "POST",
		datatype: "JSON",
		data: {
			"certificate_num" : certificate_num_arr,
			"certificate_name" : certificate_name_arr,
			"published_by_license" : published_by_license_arr,
			"acquisition_date" : acquisition_date_arr,
			"id" : id
		},
		success: function(data){
			if(data.result == "success") {
				$("#plusCertificate").children().remove();
				getRegisteredCertificate(data.list);
				$("#certificateFooter").children().remove();
				$("#certificateFlag").val("true");
				$("#certificateRemain").val(0);
			}
			else
				alert("이미 등록된 자격증 번호입니다.");
		}
	});
}

/**
 * 추가한 자격증 창 모두 삭제,
 * 데이터베이스에 등록한 자격증 모두 삭제
 */
function deleteAllCertificate() {
	var executeDelete = confirm("정말 삭제하시겠습니까?")
	if(executeDelete) {
		$.ajax({
			url: "deleteAllCertificate.do",
			success: function(data) {
				if(data.result == "success") {
					$("#plusCertificate").children().remove();
					$("#certificateFooter").children().remove();
					$("#certificateFlag").val("true");
					$("#certificateRemain").val(0);
				}
			}
		})
	}
}

/**
 * 추가한 자격증 창 삭제
 */
function deleteCertificate(certificateCount) {
	var executeDelete = confirm("정말 삭제하시겠습니까?")
	if(executeDelete) {
		$("#certBody"+certificateCount).remove();
		var remain = parseInt($("#certificateRemain").val());
		remain = remain - 1;
		$("#certificateRemain").val(remain);
		if(remain == 0) {
			$("#certificateFooter").children().remove();
			$("#certificateFlag").val("true");
		}
	}
}

/**
 * 자격증 이름을 통한 발급처 검색
 * option에서 data-value로 넣어놓은 값이 각 밑의 배열의 발급처를 나타냄
 * 먼저 선택된 자격증 이름과, datalist의 option 태그를 싹 다 가져온 후
 * 하나씩 비교해서 같은 경우에 해당 datalist의 data-value값을 가져옴
 * 그게 pbl의 index값인데 1부터 값을 적어놔서 -1 해줘서 index를 맞춤
 * 이제 발급처 이름을 해당 input태그에 넣어줌
 */
function publishedByLicense(certificateCount){
	var pbl = ["한국산업인력공단","대한상공회의소","영화진흥위원회","한국광해관리공단","한국기술자격검정원","한국방송통신전파진흥원","한국원자력안전기술원","한국인터넷진흥원","한국콘텐츠진흥원"];
	var cerName = $("#certificate_name"+certificateCount).val();
	var option = document.querySelectorAll("#datalist"+certificateCount+" option");
	var index = 0;
	for(i=0; i<option.length; i++) {
		if(option[i].innerText == cerName) {
			index = option[i].getAttribute('data-value') - 1;
		}
	}
	$("#published_by_license"+certificateCount).val(pbl[index]);
}

/**
 * 자격증 추가 버튼 클릭시 모두 저장 / 모두 삭제버튼 생기게 하는 함수
 */
function makeAllBtn() {
	var tag ='';
	tag += '<div class="row text-right">';
	tag += '<input type="button" class="btn btn-info" onclick="insertCertificate()" value="모두 저장">';
	tag += '<input type="button" class="btn btn-danger" onclick="deleteAllCertificate()" value="모두 삭제">';
	tag += '</div>';
	$("#certificateFooter").append(tag);
}

$(function(){
	/**
	 * 자격증 항목을 클릭할 때
	 * @returns 자격증에 대한 태그들 추가
	 */
	$("#formLicense").click(function() {
		$("#license").toggle(function(){	
		});
	})
	
	/**
	 * 자격증 목록 추가 함수
	 */
	$("#addCertificate").click(function() {
		var certificateCount = parseInt($("#certificateCount").val());
		var certificateRemain = parseInt($("#certificateRemain").val());
		var certificateFlag = $("#certificateFlag").val();
		if(certificateFlag == "true") {
			makeAllBtn();
			$("#certificateFlag").val("false");
		}
		certificateCount = certificateCount + 1;
		certificateRemain = certificateRemain + 1;
		$("#certificateCount").val(certificateCount);
		$("#certificateRemain").val(certificateRemain);
		var tag = '';
		tag += '<div id="certBody'+certificateCount+'" class="row">';
		tag += '<div class="col-sm-12 text-right">';
		tag += '<span id="explain">*어학자격증이 아닌 자격증만 입력해주세요 &nbsp;&nbsp;&nbsp;&nbsp;</span>';
		tag += '<a onclick="deleteCertificate('+certificateCount+')"><span class="icon-cross"></span></a>';
		tag += '</div>'
		tag += '<div class="row">';
		tag += '<div id="cerName" class="col-sm-6">';
		tag += '<label>자격증</label> ';
		tag += '<input list="datalist'+certificateCount+'" class="form-control" id="certificate_name'+certificateCount+'" name="certificate_name[]" placeholder="입력하시려면 검색됩니다." onchange="publishedByLicense('+certificateCount+')">';
		tag += '<datalist id="datalist'+certificateCount+'">';
		tag += '<option data-value="1">기중기운전기능사</option>';
		tag += '<option data-value="1">로더운전기능사</option>';
		tag += '<option data-value="1">롤러운전기능사</option>';
		tag += '<option data-value="1">불도저운전기능사</option>';
		tag += '<option data-value="1">양화장치운전기능사</option>';
		tag += '<option data-value="1">천공기운전기능사</option>';
		tag += '<option data-value="1">천장크레인운전기능사</option>';
		tag += '<option data-value="1">컨테이너크레인운전기능사</option>';
		tag += '<option data-value="1">타워크레인운전기능사</option>';
		tag += '<option data-value="1">배관기능사</option>';
		tag += '<option data-value="1">배관기능장</option>';
		tag += '<option data-value="1">배관산업기사</option>';
		tag += '<option data-value="1">거푸집기능사</option>';
		tag += '<option data-value="1">건축구조기술사</option>';
		tag += '<option data-value="1">건축기계설비기술사</option>';
		tag += '<option data-value="1">건축기사</option>';
		tag += '<option data-value="1">건축도장기능사</option>';
		tag += '<option data-value="1">건축목공기능사</option>';
		tag += '<option data-value="1">건축목공산업기사</option>';
		tag += '<option data-value="1">건축목재시공기능장</option>';
		tag += '<option data-value="1">건축산업기사</option>';
		tag += '<option data-value="1">건축설비기사</option>';
		tag += '<option data-value="1">건축설비산업기사</option>';
		tag += '<option data-value="1">건축시공기술사</option>';
		tag += '<option data-value="1">건축일반시공기능장</option>';
		tag += '<option data-value="1">건축일반시공산업기사</option>';
		tag += '<option data-value="1">건축품질시험기술사</option>';
		tag += '<option data-value="1">도배기능사</option>';
		tag += '<option data-value="1">미장기능사</option>';
		tag += '<option data-value="1">방수기능사</option>';
		tag += '<option data-value="1">방수산업기사</option>';
		tag += '<option data-value="1">비계기능사</option>';
		tag += '<option data-value="1">실내건축기능사</option>';
		tag += '<option data-value="1">실내건축기사</option>';
		tag += '<option data-value="1">실내건축산업기사</option>';
		tag += '<option data-value="1">온수온돌기능사</option>';
		tag += '<option data-value="1">유리시공기능사</option>';
		tag += '<option data-value="1">전산응용건축제도기능사</option>';
		tag += '<option data-value="1">조적기능사</option>';
		tag += '<option data-value="1">철근기능사</option>';
		tag += '<option data-value="1">타일기능사</option>';
		tag += '<option data-value="1">세탁기능사</option>';
		tag += '<option data-value="1">사회조사분석사1급</option>';
		tag += '<option data-value="1">사회조사분석사2급</option>';
		tag += '<option data-value="1">소비자전문상담사1급</option>';
		tag += '<option data-value="1">소비자전문상담사2급</option>';
		tag += '<option data-value="1">컨벤션기획사1급</option>';
		tag += '<option data-value="1">컨벤션기획사2급</option>';
		tag += '<option data-value="1">금속가공기술사</option>';
		tag += '<option data-value="1">금속재료기능장</option>';
		tag += '<option data-value="1">금속재료기사</option>';
		tag += '<option data-value="1">금속재료기술사</option>';
		tag += '<option data-value="1">금속재료산업기사</option>';
		tag += '<option data-value="1">금속재료시험기능사</option>';
		tag += '<option data-value="1">금속제련기술사</option>';
		tag += '<option data-value="1">세라믹기술사</option>';
		tag += '<option data-value="1">압연기능사</option>';
		tag += '<option data-value="1">압연기능장</option>';
		tag += '<option data-value="1">열처리기능사</option>';
		tag += '<option data-value="1">재료조직평가산업기사</option>';
		tag += '<option data-value="1">제강기능사</option>';
		tag += '<option data-value="1">제강기능장</option>';
		tag += '<option data-value="1">제선기능사</option>';
		tag += '<option data-value="1">제선기능장</option>';
		tag += '<option data-value="1">축로기능사</option>';
		tag += '<option data-value="1">금형기능사</option>';
		tag += '<option data-value="1">금형기술사</option>';
		tag += '<option data-value="1">금형제작기능장</option>';
		tag += '<option data-value="1">사출금형산업기사</option>';
		tag += '<option data-value="1">사출금형설계기사</option>';
		tag += '<option data-value="1">프레스금형산업기사</option>';
		tag += '<option data-value="1">프레스금형설계기사</option>';
		tag += '<option data-value="1">건설기계기술사</option>';
		tag += '<option data-value="1">건설기계설비기사</option>';
		tag += '<option data-value="1">건설기계설비산업기사</option>';
		tag += '<option data-value="1">건설기계정비기능사</option>';
		tag += '<option data-value="1">건설기계정비기능장</option>';
		tag += '<option data-value="1">건설기계정비기사</option>';
		tag += '<option data-value="1">건설기계정비산업기사</option>';
		tag += '<option data-value="1">공조냉동기계기능사</option>';
		tag += '<option data-value="1">공조냉동기계기사</option>';
		tag += '<option data-value="1">공조냉동기계기술사</option>';
		tag += '<option data-value="1">공조냉동기계산업기사</option>';
		tag += '<option data-value="1">궤도장비정비기능사</option>';
		tag += '<option data-value="1">궤도장비정비기사</option>';
		tag += '<option data-value="1">궤도장비정비산업기사</option>';
		tag += '<option data-value="1">기계정비기능사</option>';
		tag += '<option data-value="1">기계정비산업기사</option>';
		tag += '<option data-value="1">농기계정비기능사</option>';
		tag += '<option data-value="1">농업기계기사</option>';
		tag += '<option data-value="1">농업기계산업기사</option>';
		tag += '<option data-value="1">메카트로닉스기사</option>';
		tag += '<option data-value="1">반도체장비유지보수기능사</option>';
		tag += '<option data-value="1">산업기계설비기술사</option>';
		tag += '<option data-value="1">생산자동화기능사</option>';
		tag += '<option data-value="1">생산자동화산업기사</option>';
		tag += '<option data-value="1">설비보전기능사</option>';
		tag += '<option data-value="1">설비보전기사</option>';
		tag += '<option data-value="1">승강기기능사</option>';
		tag += '<option data-value="1">승강기기사</option>';
		tag += '<option data-value="1">승강기산업기사</option>';
		tag += '<option data-value="1">전자부품장착기능사</option>';
		tag += '<option data-value="1">전자부품장착산업기사</option>';
		tag += '<option data-value="1">공유압기능사</option>';
		tag += '<option data-value="1">기계가공기능장</option>';
		tag += '<option data-value="1">기계가공조립기능사</option>';
		tag += '<option data-value="1">기계가공조립산업기사</option>';
		tag += '<option data-value="1">기계기술사</option>';
		tag += '<option data-value="1">기계설계기사</option>';
		tag += '<option data-value="1">기계설계산업기사</option>';
		tag += '<option data-value="1">연삭기능사</option>';
		tag += '<option data-value="1">일반기계기사</option>';
		tag += '<option data-value="1">전산응용기계제도기능사</option>';
		tag += '<option data-value="1">정밀측정기능사</option>';
		tag += '<option data-value="1">정밀측정산업기사</option>';
		tag += '<option data-value="1">치공구설계산업기사</option>';
		tag += '<option data-value="1">컴퓨터응용가공산업기사</option>';
		tag += '<option data-value="1">컴퓨터응용밀링기능사</option>';
		tag += '<option data-value="1">컴퓨터응용선반기능사</option>';
		tag += '<option data-value="1">농화학기술사</option>';
		tag += '<option data-value="1">시설원예기사</option>';
		tag += '<option data-value="1">시설원예기술사</option>';
		tag += '<option data-value="1">원예기능사</option>';
		tag += '<option data-value="1">유기농업기능사</option>';
		tag += '<option data-value="1">유기농업기사</option>';
		tag += '<option data-value="1">유기농업산업기사</option>';
		tag += '<option data-value="1">종자기능사</option>';
		tag += '<option data-value="1">종자기사</option>';
		tag += '<option data-value="1">종자기술사</option>';
		tag += '<option data-value="1">종자산업기사</option>';
		tag += '<option data-value="1">화훼장식기능사</option>';
		tag += '<option data-value="1">화훼장식기사</option>';
		tag += '<option data-value="1">원형기능사</option>';
		tag += '<option data-value="1">주조기능사</option>';
		tag += '<option data-value="1">주조기능장</option>';
		tag += '<option data-value="1">주조산업기사</option>';
		tag += '<option data-value="1">교통기사</option>';
		tag += '<option data-value="1">교통기술사</option>';
		tag += '<option data-value="1">교통산업기사</option>';
		tag += '<option data-value="1">도시계획기사</option>';
		tag += '<option data-value="1">도시계획기술사</option>';
		tag += '<option data-value="1">광고도장기능사</option>';
		tag += '<option data-value="1">금속도장기능사</option>';
		tag += '<option data-value="1">표면처리기능사</option>';
		tag += '<option data-value="1">표면처리기능장</option>';
		tag += '<option data-value="1">표면처리기술사</option>';
		tag += '<option data-value="1">표면처리산업기사</option>';
		tag += '<option data-value="1">시각디자인기사</option>';
		tag += '<option data-value="1">시각디자인산업기사</option>';
		tag += '<option data-value="1">웹디자인기능사</option>';
		tag += '<option data-value="1">제품디자인기사</option>';
		tag += '<option data-value="1">제품디자인기술사</option>';
		tag += '<option data-value="1">제품디자인산업기사</option>';
		tag += '<option data-value="1">제품응용모델링기능사</option>';
		tag += '<option data-value="1">컬러리스트기사</option>';
		tag += '<option data-value="1">컬러리스트산업기사</option>';
		tag += '<option data-value="1">컴퓨터그래픽스운용기능사</option>';
		tag += '<option data-value="1">가구제작기능사</option>';
		tag += '<option data-value="1">귀금속가공기능사</option>';
		tag += '<option data-value="1">귀금속가공기능장</option>';
		tag += '<option data-value="1">귀금속가공산업기사</option>';
		tag += '<option data-value="1">도자기공예기능사</option>';
		tag += '<option data-value="1">목공예기능사</option>';
		tag += '<option data-value="1">보석가공기능사</option>';
		tag += '<option data-value="1">보석감정사</option>';
		tag += '<option data-value="1">석공예기능사</option>';
		tag += '<option data-value="1">피아노조율기능사</option>';
		tag += '<option data-value="1">피아노조율산업기사</option>';
		tag += '<option data-value="1">국제의료관광코디네이터</option>';
		tag += '<option data-value="1">임상심리사1급</option>';
		tag += '<option data-value="1">임상심리사2급</option>';
		tag += '<option data-value="1">누설비파괴검사기사</option>';
		tag += '<option data-value="1">방사선비파괴검사기능사</option>';
		tag += '<option data-value="1">방사선비파괴검사기사</option>';
		tag += '<option data-value="1">방사선비파괴검사산업기사</option>';
		tag += '<option data-value="1">비파괴검사기술사</option>';
		tag += '<option data-value="1">와전류비파괴검사기사</option>';
		tag += '<option data-value="1">자기비파괴검사기능사</option>';
		tag += '<option data-value="1">자기비파괴검사기사</option>';
		tag += '<option data-value="1">자기비파괴검사산업기사</option>';
		tag += '<option data-value="1">초음파비파괴검사기능사</option>';
		tag += '<option data-value="1">초음파비파괴검사기사</option>';
		tag += '<option data-value="1">초음파비파괴검사산업기사</option>';
		tag += '<option data-value="1">침투비파괴검사기능사</option>';
		tag += '<option data-value="1">침투비파괴검사기사</option>';
		tag += '<option data-value="1">침투비파괴검사산업기사</option>';
		tag += '<option data-value="1">직업상담사1급</option>';
		tag += '<option data-value="1">직업상담사2급</option>';
		tag += '<option data-value="1">공장관리기술사</option>';
		tag += '<option data-value="1">포장기사</option>';
		tag += '<option data-value="1">포장기술사</option>';
		tag += '<option data-value="1">포장산업기사</option>';
		tag += '<option data-value="1">품질경영기사</option>';
		tag += '<option data-value="1">품질경영산업기사</option>';
		tag += '<option data-value="1">품질관리기술사</option>';
		tag += '<option data-value="1">섬유기사</option>';
		tag += '<option data-value="1">섬유기술사</option>';
		tag += '<option data-value="1">섬유디자인산업기사</option>';
		tag += '<option data-value="1">섬유산업기사</option>';
		tag += '<option data-value="1">염색기능사(날염)</option>';
		tag += '<option data-value="1">염색기능사(침염)</option>';
		tag += '<option data-value="1">의류기사</option>';
		tag += '<option data-value="1">의류기술사</option>';
		tag += '<option data-value="1">스포츠경영관리사</option>';
		tag += '<option data-value="1">수산제조기사</option>';
		tag += '<option data-value="1">수산제조기술사</option>';
		tag += '<option data-value="1">식품가공기능사</option>';
		tag += '<option data-value="1">식품기사</option>';
		tag += '<option data-value="1">식품기술사</option>';
		tag += '<option data-value="1">식품산업기사</option>';
		tag += '<option data-value="1">가스기능사</option>';
		tag += '<option data-value="1">가스기능장</option>';
		tag += '<option data-value="1">가스기사</option>';
		tag += '<option data-value="1">가스기술사</option>';
		tag += '<option data-value="1">가스산업기사</option>';
		tag += '<option data-value="1">건설안전기사</option>';
		tag += '<option data-value="1">건설안전기술사</option>';
		tag += '<option data-value="1">건설안전산업기사</option>';
		tag += '<option data-value="1">기계안전기술사</option>';
		tag += '<option data-value="1">산업안전기사</option>';
		tag += '<option data-value="1">산업안전산업기사</option>';
		tag += '<option data-value="1">산업위생관리기사</option>';
		tag += '<option data-value="1">산업위생관리기술사</option>';
		tag += '<option data-value="1">산업위생관리산업기사</option>';
		tag += '<option data-value="1">소방기술사</option>';
		tag += '<option data-value="1">소방설비기사(기계분야)</option>';
		tag += '<option data-value="1">소방설비기사(전기분야)</option>';
		tag += '<option data-value="1">소방설비산업기사(기계분야)</option>';
		tag += '<option data-value="1">소방설비산업기사(전기분야)</option>';
		tag += '<option data-value="1">인간공학기사</option>';
		tag += '<option data-value="1">인간공학기술사</option>';
		tag += '<option data-value="1">전기안전기술사</option>';
		tag += '<option data-value="1">화공안전기술사</option>';
		tag += '<option data-value="1">화재감식평가기사</option>';
		tag += '<option data-value="1">화재감식평가산업기사</option>';
		tag += '<option data-value="1">수산양식기능사</option>';
		tag += '<option data-value="1">수산양식기사</option>';
		tag += '<option data-value="1">수산양식기술사</option>';
		tag += '<option data-value="1">수산양식산업기사</option>';
		tag += '<option data-value="1">어로기술사</option>';
		tag += '<option data-value="1">어로산업기사</option>';
		tag += '<option data-value="1">어업생산관리기사</option>';
		tag += '<option data-value="1">기상감정기사</option>';
		tag += '<option data-value="1">기상기사</option>';
		tag += '<option data-value="1">기상예보기술사</option>';
		tag += '<option data-value="1">신재생에너지발전설비기능사(태양광)</option>';
		tag += '<option data-value="1">신재생에너지발전설비기사(태양광)</option>';
		tag += '<option data-value="1">신재생에너지발전설비산업기사(태양광)</option>';
		tag += '<option data-value="1">에너지관리기능사</option>';
		tag += '<option data-value="1">에너지관리기능장</option>';
		tag += '<option data-value="1">에너지관리기사</option>';
		tag += '<option data-value="1">에너지관리산업기사</option>';
		tag += '<option data-value="1">텔레마케팅관리사</option>';
		tag += '<option data-value="1">용접기능사</option>';
		tag += '<option data-value="1">용접기능장</option>';
		tag += '<option data-value="1">용접기사</option>';
		tag += '<option data-value="1">용접기술사</option>';
		tag += '<option data-value="1">용접산업기사</option>';
		tag += '<option data-value="1">특수용접기능사</option>';
		tag += '<option data-value="1">농기계운전기능사</option>';
		tag += '<option data-value="1">철도운송산업기사</option>';
		tag += '<option data-value="1">위험물기능사</option>';
		tag += '<option data-value="1">위험물기능장</option>';
		tag += '<option data-value="1">위험물산업기사</option>';
		tag += '<option data-value="1">신발류제조기능사</option>';
		tag += '<option data-value="1">양복기능사</option>';
		tag += '<option data-value="1">양장기능사</option>';
		tag += '<option data-value="1">패션디자인산업기사</option>';
		tag += '<option data-value="1">패션머천다이징산업기사</option>';
		tag += '<option data-value="1">한복기능사</option>';
		tag += '<option data-value="1">한복산업기사</option>';
		tag += '<option data-value="1">미용사(네일)</option>';
		tag += '<option data-value="1">미용사(메이크업)</option>';
		tag += '<option data-value="1">미용장</option>';
		tag += '<option data-value="1">이용사</option>';
		tag += '<option data-value="1">이용장</option>';
		tag += '<option data-value="1">사진기능사</option>';
		tag += '<option data-value="1">인쇄기능사</option>';
		tag += '<option data-value="1">인쇄기사</option>';
		tag += '<option data-value="1">인쇄산업기사</option>';
		tag += '<option data-value="1">전자출판기능사</option>';
		tag += '<option data-value="1">버섯종균기능사</option>';
		tag += '<option data-value="1">산림기능사</option>';
		tag += '<option data-value="1">산림기사</option>';
		tag += '<option data-value="1">산림기술사</option>';
		tag += '<option data-value="1">산림산업기사</option>';
		tag += '<option data-value="1">식물보호기사</option>';
		tag += '<option data-value="1">식물보호산업기사</option>';
		tag += '<option data-value="1">임산가공기능사</option>';
		tag += '<option data-value="1">임산가공기사</option>';
		tag += '<option data-value="1">임산가공산업기사</option>';
		tag += '<option data-value="1">임업종묘기능사</option>';
		tag += '<option data-value="1">임업종묘기사</option>';
		tag += '<option data-value="1">그린전동자동차기사</option>';
		tag += '<option data-value="1">자동차보수도장기능사</option>';
		tag += '<option data-value="1">자동차정비기능사</option>';
		tag += '<option data-value="1">자동차정비기능장</option>';
		tag += '<option data-value="1">자동차정비기사</option>';
		tag += '<option data-value="1">자동차정비산업기사</option>';
		tag += '<option data-value="1">자동차차체수리기능사</option>';
		tag += '<option data-value="1">차량기술사</option>';
		tag += '<option data-value="1">건축전기설비기술사</option>';
		tag += '<option data-value="1">발송배전기술사</option>';
		tag += '<option data-value="1">전기공사기사</option>';
		tag += '<option data-value="1">전기공사산업기사</option>';
		tag += '<option data-value="1">전기기능사</option>';
		tag += '<option data-value="1">전기기능장</option>';
		tag += '<option data-value="1">전기기사</option>';
		tag += '<option data-value="1">전기산업기사</option>';
		tag += '<option data-value="1">전기응용기술사</option>';
		tag += '<option data-value="1">전기철도기사</option>';
		tag += '<option data-value="1">전기철도기술사</option>';
		tag += '<option data-value="1">전기철도산업기사</option>';
		tag += '<option data-value="1">철도신호기사</option>';
		tag += '<option data-value="1">철도신호기술사</option>';
		tag += '<option data-value="1">철도신호산업기사</option>';
		tag += '<option data-value="1">철도전기신호기능사</option>';
		tag += '<option data-value="1">광학기기산업기사</option>';
		tag += '<option data-value="1">광학기능사</option>';
		tag += '<option data-value="1">광학기사</option>';
		tag += '<option data-value="1">반도체설계기사</option>';
		tag += '<option data-value="1">반도체설계산업기사</option>';
		tag += '<option data-value="1">산업계측제어기술사</option>';
		tag += '<option data-value="1">의공기사</option>';
		tag += '<option data-value="1">의공산업기사</option>';
		tag += '<option data-value="1">의료전자기능사</option>';
		tag += '<option data-value="1">임베디드기사</option>';
		tag += '<option data-value="1">전자계산기기능사</option>';
		tag += '<option data-value="1">전자계산기기사</option>';
		tag += '<option data-value="1">전자계산기제어산업기사</option>';
		tag += '<option data-value="1">전자기기기능사</option>';
		tag += '<option data-value="1">전자기기기능장</option>';
		tag += '<option data-value="1">전자기사</option>';
		tag += '<option data-value="1">전자산업기사</option>';
		tag += '<option data-value="1">전자응용기술사</option>';
		tag += '<option data-value="1">전자캐드기능사</option>';
		tag += '<option data-value="1">멀티미디어콘텐츠제작전문가</option>';
		tag += '<option data-value="1">사무자동화산업기사</option>';
		tag += '<option data-value="1">전자계산기조직응용기사</option>';
		tag += '<option data-value="1">정보관리기술사</option>';
		tag += '<option data-value="1">정보처리기사</option>';
		tag += '<option data-value="1">정보처리산업기사</option>';
		tag += '<option data-value="1">컴퓨터시스템응용기술사</option>';
		tag += '<option data-value="1">제과기능장</option>';
		tag += '<option data-value="1">조경기능사</option>';
		tag += '<option data-value="1">조경기사</option>';
		tag += '<option data-value="1">조경기술사</option>';
		tag += '<option data-value="1">조경산업기사</option>';
		tag += '<option data-value="1">복어조리기능사</option>';
		tag += '<option data-value="1">조리기능장</option>';
		tag += '<option data-value="1">조리산업기사(복어)</option>';
		tag += '<option data-value="1">조리산업기사(양식)</option>';
		tag += '<option data-value="1">조리산업기사(일식)</option>';
		tag += '<option data-value="1">조리산업기사(중식)</option>';
		tag += '<option data-value="1">조리산업기사(한식)</option>';
		tag += '<option data-value="1">조주기능사</option>';
		tag += '<option data-value="1">동력기계정비기능사</option>';
		tag += '<option data-value="1">선체건조기능사</option>';
		tag += '<option data-value="1">전산응용조선제도기능사</option>';
		tag += '<option data-value="1">조선기사</option>';
		tag += '<option data-value="1">조선기술사</option>';
		tag += '<option data-value="1">조선산업기사</option>';
		tag += '<option data-value="1">화약류관리기사</option>';
		tag += '<option data-value="1">화약류관리기술사</option>';
		tag += '<option data-value="1">화약류관리산업기사</option>';
		tag += '<option data-value="1">화약취급기능사</option>';
		tag += '<option data-value="1">철도차량기사</option>';
		tag += '<option data-value="1">철도차량기술사</option>';
		tag += '<option data-value="1">철도차량산업기사</option>';
		tag += '<option data-value="1">철도차량정비기능사</option>';
		tag += '<option data-value="1">철도차량정비기능장</option>';
		tag += '<option data-value="1">식육처리기능사</option>';
		tag += '<option data-value="1">축산기능사</option>';
		tag += '<option data-value="1">축산기사</option>';
		tag += '<option data-value="1">축산기술사</option>';
		tag += '<option data-value="1">축산산업기사</option>';
		tag += '<option data-value="1">건설재료시험기능사</option>';
		tag += '<option data-value="1">건설재료시험기사</option>';
		tag += '<option data-value="1">건설재료시험산업기사</option>';
		tag += '<option data-value="1">농어업토목기술사</option>';
		tag += '<option data-value="1">도로및공항기술사</option>';
		tag += '<option data-value="1">도화기능사</option>';
		tag += '<option data-value="1">상하수도기술사</option>';
		tag += '<option data-value="1">석공기능사</option>';
		tag += '<option data-value="1">수자원개발기술사</option>';
		tag += '<option data-value="1">응용지질기사</option>';
		tag += '<option data-value="1">잠수기능사</option>';
		tag += '<option data-value="1">잠수산업기사</option>';
		tag += '<option data-value="1">전산응용토목제도기능사</option>';
		tag += '<option data-value="1">지도제작기능사</option>';
		tag += '<option data-value="1">지적기능사</option>';
		tag += '<option data-value="1">지적기사</option>';
		tag += '<option data-value="1">지적기술사</option>';
		tag += '<option data-value="1">지적산업기사</option>';
		tag += '<option data-value="1">지질및지반기술사</option>';
		tag += '<option data-value="1">철도기술사</option>';
		tag += '<option data-value="1">철도토목기능사</option>';
		tag += '<option data-value="1">철도토목기사</option>';
		tag += '<option data-value="1">철도토목산업기사</option>';
		tag += '<option data-value="1">측량기능사</option>';
		tag += '<option data-value="1">측량및지형공간정보기사</option>';
		tag += '<option data-value="1">측량및지형공간정보기술사</option>';
		tag += '<option data-value="1">측량및지형공간정보산업기사</option>';
		tag += '<option data-value="1">콘크리트기능사</option>';
		tag += '<option data-value="1">콘크리트기사</option>';
		tag += '<option data-value="1">콘크리트산업기사</option>';
		tag += '<option data-value="1">토목구조기술사</option>';
		tag += '<option data-value="1">토목기사</option>';
		tag += '<option data-value="1">토목산업기사</option>';
		tag += '<option data-value="1">토목시공기술사</option>';
		tag += '<option data-value="1">토목품질시험기술사</option>';
		tag += '<option data-value="1">토질및기초기술사</option>';
		tag += '<option data-value="1">항공사진기능사</option>';
		tag += '<option data-value="1">항로표지기능사</option>';
		tag += '<option data-value="1">항로표지기사</option>';
		tag += '<option data-value="1">항로표지산업기사</option>';
		tag += '<option data-value="1">항만및해안기술사</option>';
		tag += '<option data-value="1">해양공학기사</option>';
		tag += '<option data-value="1">해양기술사</option>';
		tag += '<option data-value="1">해양자원개발기사</option>';
		tag += '<option data-value="1">해양조사산업기사</option>';
		tag += '<option data-value="1">해양환경기사</option>';
		tag += '<option data-value="1">금속재창호기능사</option>';
		tag += '<option data-value="1">판금제관기능사</option>';
		tag += '<option data-value="1">판금제관기능장</option>';
		tag += '<option data-value="1">판금제관산업기사</option>';
		tag += '<option data-value="1">플라스틱창호기능사</option>';
		tag += '<option data-value="1">항공기관기술사</option>';
		tag += '<option data-value="1">항공기관정비기능사</option>';
		tag += '<option data-value="1">항공기사</option>';
		tag += '<option data-value="1">항공기체기술사</option>';
		tag += '<option data-value="1">항공기체정비기능사</option>';
		tag += '<option data-value="1">항공산업기사</option>';
		tag += '<option data-value="1">항공장비정비기능사</option>';
		tag += '<option data-value="1">항공전자정비기능사</option>';
		tag += '<option data-value="1">생물공학기사</option>';
		tag += '<option data-value="1">화공기사</option>';
		tag += '<option data-value="1">화공기술사</option>';
		tag += '<option data-value="1">화약류제조기사</option>';
		tag += '<option data-value="1">화약류제조산업기사</option>';
		tag += '<option data-value="1">화학분석기능사</option>';
		tag += '<option data-value="1">화학분석기사</option>';
		tag += '<option data-value="1">농림토양평가관리산업기사</option>';
		tag += '<option data-value="1">대기관리기술사</option>';
		tag += '<option data-value="1">대기환경기사</option>';
		tag += '<option data-value="1">대기환경산업기사</option>';
		tag += '<option data-value="1">생물분류기사(동물)</option>';
		tag += '<option data-value="1">생물분류기사(식물)</option>';
		tag += '<option data-value="1">소음진동기사</option>';
		tag += '<option data-value="1">소음진동기술사</option>';
		tag += '<option data-value="1">소음진동산업기사</option>';
		tag += '<option data-value="1">수질관리기술사</option>';
		tag += '<option data-value="1">수질환경기사</option>';
		tag += '<option data-value="1">수질환경산업기사</option>';
		tag += '<option data-value="1">온실가스관리기사</option>';
		tag += '<option data-value="1">온실가스관리산업기사</option>';
		tag += '<option data-value="1">자연생태복원기사</option>';
		tag += '<option data-value="1">자연생태복원산업기사</option>';
		tag += '<option data-value="1">자연환경관리기술사</option>';
		tag += '<option data-value="1">토양환경기사</option>';
		tag += '<option data-value="1">토양환경기술사</option>';
		tag += '<option data-value="1">폐기물처리기사</option>';
		tag += '<option data-value="1">폐기물처리기술사</option>';
		tag += '<option data-value="1">폐기물처리산업기사</option>';
		tag += '<option data-value="1">환경기능사</option>';
		tag += '<option data-value="2">비서1급</option>';
		tag += '<option data-value="2">비서2급</option>';
		tag += '<option data-value="2">비서3급</option>';
		tag += '<option data-value="2">워드프로세서</option>';
		tag += '<option data-value="2">전산회계운용사 1급</option>';
		tag += '<option data-value="2">전산회계운용사 2급</option>';
		tag += '<option data-value="2">전산회계운용사 3급</option>';
		tag += '<option data-value="2">전자상거래관리사1급</option>';
		tag += '<option data-value="2">전자상거래관리사2급</option>';
		tag += '<option data-value="2">전자상거래운용사</option>';
		tag += '<option data-value="2">컴퓨터활용능력1급</option>';
		tag += '<option data-value="2">컴퓨터활용능력2급</option>';
		tag += '<option data-value="2">한글속기1급</option>';
		tag += '<option data-value="2">한글속기2급</option>';
		tag += '<option data-value="2">한글속기3급</option>';
		tag += '<option data-value="3">영사기능사</option>';
		tag += '<option data-value="3">영사산업기사</option>';
		tag += '<option data-value="4">광산보안기능사</option>';
		tag += '<option data-value="4">광산보안기사</option>';
		tag += '<option data-value="4">광산보안산업기사</option>';
		tag += '<option data-value="4">광해방지기사</option>';
		tag += '<option data-value="4">광해방지기술사</option>';
		tag += '<option data-value="4">시추기능사</option>';
		tag += '<option data-value="4">자원관리기술사</option>';
		tag += '<option data-value="5">굴삭기운전기능사</option>';
		tag += '<option data-value="5">미용사(일반)</option>';
		tag += '<option data-value="5">미용사(피부)</option>';
		tag += '<option data-value="5">양식조리기능사</option>';
		tag += '<option data-value="5">일식조리기능사</option>';
		tag += '<option data-value="5">정보기기운용기능사</option>';
		tag += '<option data-value="5">정보처리기능사</option>';
		tag += '<option data-value="5">제과기능사</option>';
		tag += '<option data-value="5">제빵기능사</option>';
		tag += '<option data-value="5">중식조리기능사</option>';
		tag += '<option data-value="5">지게차운전기능사</option>';
		tag += '<option data-value="5">한식조리기능사</option>';
		tag += '<option data-value="6">무선설비기능사</option>';
		tag += '<option data-value="6">무선설비기사</option>';
		tag += '<option data-value="6">무선설비산업기사</option>';
		tag += '<option data-value="6">방송통신기능사</option>';
		tag += '<option data-value="6">방송통신기사</option>';
		tag += '<option data-value="6">방송통신산업기사</option>';
		tag += '<option data-value="6">전파전자통신기능사</option>';
		tag += '<option data-value="6">전파전자통신기사</option>';
		tag += '<option data-value="6">전파전자통신산업기사</option>';
		tag += '<option data-value="6">정보통신기사</option>';
		tag += '<option data-value="6">정보통신기술사</option>';
		tag += '<option data-value="6">정보통신산업기사</option>';
		tag += '<option data-value="6">통신기기기능사</option>';
		tag += '<option data-value="6">통신선로기능사</option>';
		tag += '<option data-value="6">통신선로산업기사</option>';
		tag += '<option data-value="6">통신설비기능장</option>';
		tag += '<option data-value="7">방사선관리기술사</option>';
		tag += '<option data-value="7">원자력기사</option>';
		tag += '<option data-value="7">원자력발전기술사</option>';
		tag += '<option data-value="8">정보보안기사</option>';
		tag += '<option data-value="8">정보보안산업기사</option>';
		tag += '<option data-value="9">게임그래픽전문가</option>';
		tag += '<option data-value="9">게임기획전문가</option>';
		tag += '<option data-value="9">게임프로그래밍전문가</option>';
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
		tag += '<br>';
		tag += '</div>';
		$("#plusCertificate").append(tag);
	});
})
