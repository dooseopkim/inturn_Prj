<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/chkCert.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人Turn &mdash; 다시 인생을 시작하다.</title>
</head>
<body>
	<jsp:include page="userMenu.jsp" />
	<nav class="fh5co-nav" role="navigation">
	<div class="container-wrap">
		<div class="top-menu">
			<div class="row">
				<div class="col-xs-2">
					<div id="fh5co-logo">
						<a href="main.do">人Turn</a>
					</div>
				</div>
				<div class="col-xs-10 text-right menu-1">
					<ul>
						<li class="active"><a href="main.do">홈</a></li>
						<li class="has-dropdown"><a href="intro1.do">소개</a>
							<ul class="dropdown">
								<li><a href="intro1.do">사업소개</a></li>
								<li><a href="intro2.do">서비스소개</a></li>
							</ul></li>
						<li><a href="mentor.do">멘토찾기</a></li>
						<li><a href="mentee.do">멘티찾기</a></li>
						<li><a href="freeBoard.do?page_num=1">자유게시판</a></li>
						<li class="has-dropdown"><a href="#">이용안내</a>
							<ul class="dropdown">
								<li><a href="#">자주 묻는 질문</a></li>
								<li><a href="csBoard.do?page_num=1">고객서비스</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<div class="container-wrap">
		<div class="container">
			<ul class="list-inline">
				<li class="selected">
					<div class="step-bar">
						<strong><em>01</em> 약관동의 및 <span class="m-br">본인인증</span></strong>
						<p>
							약관동의와 본인인증이<br>필요합니다.
						</p>
					</div>
				</li>
				<li class="">
					<div class="step-bar">
						<strong><em>02</em> 개인정보<span class="m-br">입력</span></strong>
						<p>
							입력하신 정보는 안전하게<br>보호됩니다.
						</p>
					</div>
				</li>
				<li class="">
					<div class="step-bar">
						<strong><em>04</em> 가입완료</strong>
						<p>
							진로교육정보망 통합회원이<br>되신 것을 환영합니다.
						</p>
					</div>
				</li>
			</ul>
		</div>
		<!-- END container -->

		<style>

/* board-list  개인정보 수집 및 이용 약관에 쓰일 테이블 스타일*/
table {
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #dde2eb;
}

.board-list {
	width: 100%;
	border-top: 1px solid #979797;
	table-layout: fixed;
	line-height: 20px;
}

.board-list th {
	padding: 16px 5px;
	border-bottom: 1px solid #dde2eb;
	color: #666;
}

.board-list td {
	padding: 16px 5px;
	border-bottom: 1px solid #dde2eb;
	color: #333;
	text-align: center;
}

.board-list td.b-point {
	color: #ff5200;
	font-weight: 700;
}

.board-list td img {
	vertical-align: middle;
}

.board-list td a {
	color: #333;
}

.board-list td.subject {
	padding-left: 20px;
	text-align: left;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.board-list td.approval-refusal a {
	margin: 0 5px;
}

.btn-c+.board-list {
	margin-top: 50px;
}

.btn-c+.board-scroll {
	margin-top: 50px;
}

.search-box+.board-list {
	margin-top: 30px;
}

.board-scroll {
	overflow-x: hidden;
	overflow-y: auto;
	height: 219px;
}
</style>
		<div id="fh5co-contact">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center">
					<h2>약관동의</h2>
				</div>
				<div id="container">
					<div class="container-inner">
						<div class="acceptBox">
							<input type="checkbox" id="chk_all"
								onclick="fn_clickAgreeAll(this)"> <label>이용약관,
								개인정보 수집 및 이용에 모두 동의합니다.</label>
						</div>
						<div class="terms-agree">
							<input type="checkbox" id="chk_agree01"
								onclick="fn_clickAgree(this);"> <label for="chk_agree01">이용약관</label>
							<em class="c-required">필수</em>
							<div class="contentBox">
								<strong>제1장 총칙</strong><br> <br> 제1조 (목적) 이 약관은 진로교육
								관련 사이트와 진로교육정보망 통합회원 시스템이 제공하는 인터넷 서비스(이하 “서비스”라 한다)의 이용조건 및 절차,
								기타 필요한 사항을 규정하는 것을 목적으로 합니다.<br> <br> 제2조 (용어의 정의) 본
								약관에서 사용하는 용어의 정의는 다음과 같습니다.<br> 1. 사이트란 진로교육 관련 사이트와
								진로교육정보망 통합회원 시스템을 말하며, 해당 사이트의 범위는 다음 각목과 같습니다. <br> <br>
								가. 진로교육정보망 통합회원 시스템(sso.career.go.kr)<br> 나.
								커리어넷(www.career.go.kr)<br> 다. 원격영상진로멘토링
								(mentoring.career.go.kr)<br> 라. 청소년 기업가체험 프로그램
								(www.yeep.kr)<br> <br> 2. 이용자란 사이트에 접속하여 본 약관에 따라 서비스를
								이용하는 회원 및 비회원을 말합니다.<br> 3. 이용신청자란 사이트의 서비스 이용하기 위해 회원가입을
								하고자 하는 사람을 말합니다.<br> 4. 회원이란 본 약관에 동의하고, 정상적으로 통합회원 ID와
								Password를 발급받아 이용할 수 있는 권한을 부여 받은 개인과 기관/기업을 말합니다.<br> 5.
								비회원이란 회원이 아니면서 서비스를 이용하는 자를 말합니다.<br> 6. 통합회원 ID란 회원이 사이트를
								원활하게 이용할 수 있도록 하나의 ID와 Password로 회원 인증, 회원정보 변경, 회원 가입 및 탈퇴, 서비스
								이용 등이 가능하도록 하는 ID를 말합니다.<br> 7 관리자란 교육부로부터 사이트의 기획, 관리 및
								서비스 운영 등의 업무에 대하여 일부 또는 전부를 위탁 받은 법인 및 단체를 말합니다.<br> 8.
								게시물이라 함은 이용자가 서비스를 이용하면서 게시한 글, 사진, 각종 파일과 링크 등을 말합니다.<br>
								<br> <br> 제3조 (약관의 효력 및 변경)<br> 1. 본 약관의 내용은 서비스
								화면에 게시하고, 이용신청자가 회원가입을 완료함으로써 그 효력이 발생합니다.<br> 2. 합리적인 사유가
								발생될 경우에는 관련 법령에 위배되지 않는 범위 내에서 본 약관을 변경할 수 있습니다,<br> 3. 약관이
								변경되는 경우에는 최소한 7일 전에 제1항과 같은 방법으로 공지하며 공지된 약관 변경 적용일에 그 효력이
								발생합니다.<br> 4. 관리자가 제3항에 따라 변경된 약관을 사이트에 공지하고, 이용자가 명시적으로
								거부의사를 표시하지 아니한 경우 회원이 개정약관에 동의한 것으로 봅니다.<br> 5. 변경된 약관에
								동의하지 않을 경우 이용자는 회원 탈퇴(해지)를 요청할 수 있습니다.<br> <br> 제4조
								(약관 외 준칙) 본 약관에 명시되지 않은 사항은 전기통신기본법, 전기통신사업법, 정보통신망이용촉진등에관한 법률 및
								기타 관련법령의 규정에 따르며, 그렇지 않은 경우에는 일반적인 관례에 따릅니다.<br> <br>
								<strong>제2장 이용계약 체결</strong><br> 제5조 (이용계약의 성립) 이용계약은
								이용신청자가 본 이용약관의 내용에 대하여 동의를 하고, 통합회원 ID 가입 신청 후 관리자가 신청에 대하여
								승인함으로써 성립됩니다.<br> <br> 제6조 (서비스 이용 신청)<br> 1. 만
								14세 미만의 아동인 경우에는 부모 등 법정 대리인의 동의를 얻은 후에 서비스 이용을 신청하여야 합니다.<br>
								2. 서비스 이용신청자는 다음 사항을 준수하여야 합니다.<br> 가. 다른 사람의 명의를 사용하여 기재하지
								않아야 합니다.<br> 나. 가입신청 양식의 내용은 현재의 사실과 일치하여야 합니다.<br> 다.
								사회의 안녕, 질서 또는 미풍양속을 저해할 목적으로 신청해서는 안 됩니다.<br> 라. 등록 양식 또는 그
								내용에 변경이 생긴 경우 현재의 사실과 일치하는 완전한 정보로 갱신해야 합니다.<br> 마. 이용신청자가
								제공한 정보가 부정확하거나 현재의 사실과 일치하지 않는 경우, 또는 그러하다고 의심할 수 있는 합리적인 이유가 있는
								경우 서비스 이용을 제한할 수 있습니다.<br> <br> 제7조 (이용 신청의 제한) 다음과 같은
								경우 이용신청자의 이용 신청 승낙을 제한할 수 있고, 이 사유가 해소될 때 까지 승낙을 유보할 수 있습니다.<br>
								<br> 가. 서비스 관련 설비 용량이 부족한 경우<br> 나. 기술상 문제가 있는 경우<br>
								다. 기타 부득이한 사정이 있는 경우<br> <br> 제8조 (회원 정보의 변경)<br>
								1. 다음과 같은 경우에 관리자는 회원 ID를 변경하도록 요구할 수 있습니다.<br> <br>
								가. 회원 ID가 회원의 전화번호, 주민등록번호 등으로 등록되어 회원의 사생활을 침해할 우려가 있는 경우<br>
								나. 타인에게 혐오감을 주거나 미풍양속에 저해되는 경우<br> 다. 기타 소정의 합리적인 이유가 있는 경우<br>
								2. 회원은 이용 신청 시 기재한 회원정보가 변경되었을 경우 자신이 직접 온라인으로 수정해야 하며, 관리자에게
								수정을 요구할 수 있습니다. 이 때 변경하지 않은 정보로 인해 발생되는 문제의 책임은 회원에게 있습니다.<br>
								<br> 제9조 (계약해지 및 자격 상실 등)<br> 1. 회원이 이용계약을 해지하고자 하는
								때에는 회원 본인이 서비스를 통하여 해지신청을 하여야 합니다. 단, 부득이하게 서비스를 통해 해지신청을 할 수 없는
								경우에는 전자우편(E-mail) 등을 통해 이용계약 해지를 요청할 수 있습니다.<br> 2. 회원이 다음
								각 호의 사유에 해당하는 경우, 관리자는 회원 자격을 제한 및 정지시킬 수 있습니다.<br> <br>
								가. 가입 신청 시에 허위 내용을 등록한 경우<br> 나. 다른 사람의 서비스 이용을 방해하거나 그 정보를
								도용하는 등 전자거래질서를 위협하는 경우<br> 다. 제공되는 정보를 변경하는 등 서비스의 운영을 방해한
								경우<br> 라. 법령과 이 약관이 금지하거나 미풍양속에 반하는 행위를 하는 경우<br> <br>
								3. 관리자가 회원자격을 제한 정지시킨 후 그 사유가 시정되지 아니하는 경우 사이트는 회원 자격을 상실시킬 수
								있습니다.<br> 4. 관리자가 회원자격을 상실시키는 경우에는 회원 등록을 말소합니다. 이 경우 회원에게
								이를 통지하고, 회원등록 말소 전에 소명할 기회를 부여합니다.<br> 5. 관리자는 회원자격을 상실하고
								등록이 말소된 회원이 다시 이용신청을 하는 경우 일정기간 그 승낙을 제한할 수 있습니다.<br> <br>
								<strong>제3장 개인정보보호</strong><br> <br> 제10조 (관리자의 보안관리)
								관리자는 이용자의 개인정보가 분실, 도난, 누출, 변조 또는 훼손되지 않도록 안전성 확보에 필요한 조치를
								강구합니다. 단, 회원이 게시판이나 댓글 등 온라인 상에서 자발적으로 제공하는 개인정보는 다른 사람이 수집하여
								사용할 가능성이 있으며 이러한 위험은 개인에게 책임이 있고 관리자는 책임이 없습니다.<br> <br>
								제11조 (관리자의 회원정보 사용에 대한 동의)<br> 1. 관리자는 제공하는 서비스의 이용자를 대상으로
								해당 서비스의 양적, 질적 향상을 위하여 이용자의 개인 식별이 가능한 개인정보를 이용자의 동의를 받아 이를 수집,
								이용할 수 있습니다.<br> 2. 관리자가 수집하는 개인정보는 서비스의 제공에 필요한 최소한으로 하되,
								필요한 경우 더 자세한 정보를 요구할 수 있습니다.<br> 3. 이용자가 제공한 개인정보는 동의 없이
								제3자에게 누설하거나 제공하지 않습니다. 단, 관리자는 관련 법률에 어긋나지 않는 한 회원에게 제공되는 서비스의
								질을 향상시킬 목적이나 통계작성 또는 시장조사 등을 위하여 특정 개인을 식별할 수 없는 형태로 제공할 수 있습니다.<br>
								4. 회원은 관리자가 제공한 개인정보의 수집과 이용에 대한 동의를 철회할 수 있습니다.<br> 5. 회원은
								언제든지 본인의 개인정보를 열람하고 변경사항을 정정할 수 있습니다.<br> 6. 전기통신사업법 등 법률
								규정에 의해 국가 기관의 요구가 있는 경우, 수사상 목적이 있거나 방송통신심의위원회의 요청이 있는 경우 또는 기타
								관계법령 절차에 따른 정보제공 요청이 있는 경우 회원 정보가 제공될 수 있습니다.<br> 7. 관리자는
								서비스를 통해 회원의 컴퓨터에 쿠키를 전송할 수 있습니다. 회원은 쿠키 수신을 거부하거나 쿠키 수신에 대해
								경고하도록 브라우저 설정을 변경할 수 있습니다. 단, 서비스에 링크된 웹사이트들이 개인정보를 수집하는 행위에
								대해서는 관리자가 책임지지 않습니다.<br> <br> 제12조 (관리자의 개인정보 수집 및
								이용목적) 관리자는 다음과 같은 이유로 이용자의 개인정보를 수집 및 이용 할 수 있습니다.<br> <br>
								가. 회원의 서비스 질 향상과 사이트 기획 시<br> 나. 회원 정보를 이용한 학술적 목적 연구 시<br>
								다. 회원 정보를 이용한 통계조사 시<br> <br> 제13조 (개인정보 보유 및 이용기간)<br>
								1. 개인정보는 회원가입 시 이루어지는 회원의 동의를 받아 사이트가 보유합니다.<br> 2. 회원정보는
								회원탈퇴 전까지 보유합니다.<br> 3. 회원정보의 보유에 대해 2년을 주기로 회원의 재동의를 받습니다.
								재동의 요청에 대해 아무런 응답을 하지 않는 경우에는 2개월의 유예 기간을 거쳐 회원탈퇴 처리합니다.<br>
								<br> <br> <strong>제4장 서비스 이용</strong><br> <br>
								제14조 (서비스 이용 범위) <br> 1. 이용자는 사이트별 특성에 따라 제공하는 구체적인 서비스 내용,
								이용조건 및 절차 등에 따라 해당 서비스를 이용할 수 있습니다.<br> 2. 사이트는 관련 법령 및 사이트
								별 특성에 따라 일정 기준에 따라 회원을 구분하여 제공하는 서비스 메뉴를 달리 적용할 수 있습니다.<br>
								<br> 제15조 (서비스의 이용 시간)<br> 1. 사이트는 이용자의 이용신청을 승낙한 때부터
								즉시 서비스를 개시합니다. 단 관리자의 업무상 또는 기술상의 장애로 인하여 서비스를 개시하지 못하는 경우, 서비스에
								공지하거나 회원에게 즉시 이를 통지합니다.<br> 2. 서비스의 이용은 연중무휴 1일 24시간을 원칙으로
								합니다. 다만 관리자가 업무상 또는 기술상의 이유로 서비스의 전부 또는 일부가 일시 중지되거나, 운영상의 목적으로
								관리자가 정한 기간에는 서비스의 전부 또는 일부가 일시 중지될 수 있습니다. 이러한 경우 사전 또는 사후 이를
								공지합니다.<br> 3. 관리자는 서비스별로 이용 가능한 시간을 별도로 정할 수 있으며 이 경우 그 내용을
								사전에 공지합니다.<br> <br> 제16조 (정보의 제공 및 광고의 게재)<br> 1.
								관리자는 서비스의 운용과 관련하여 서비스 화면 등 사이트에서 지정하는 위치에 광고 등을 게재할 수 있습니다.<br>
								2. 회원은 사이트에서 제공하는 홈페이지 배너 광고에 대해 임의의 삭제, 비방과 기타 광고를 방해하는 행위를 할 수
								없습니다.<br> <br> 제 17 조 (회원의 게시물 등)<br> 1. 회원이 서비스에
								등록하는 게시물 등으로 인하여 본인 또는 타인에게 손해나 기타 문제가 발생하는 경우 회원은 이에 대한 책임을 지게
								되며, 관리자는 특별한 사정이 없는 한 이에 대하여 책임을 지지 않습니다.<br> 2. 관리자는 다음 각
								호에 해당하는 게시물 등을 회원의 사전 동의 없이 임시게시 중단, 수정, 삭제, 이동 또는 등록 거부 등의 관련
								조치를 취할 수 있습니다.<br> <br> 가. 다른 회원 또는 제 3자에게 심한 모욕을 주거나
								명예를 손상시키는 내용인 경우<br> 나. 공공질서 및 미풍양속에 위반되는 내용을 유포하거나 링크시키는
								경우<br> 다. 불법복제 또는 해킹을 조장하는 내용인 경우<br> 라. 영리를 목적으로 하는
								광고일 경우<br> 마. 범죄와 결부된다고 객관적으로 인정되는 내용일 경우<br> 바. 다른
								이용자 또는 제 3자의 저작권 등 기타 권리를 침해하는 내용인 경우<br> 사. 사적인 정치적 판단이나
								종교적 견해의 내용으로 관리자가 서비스 성격에 부합하지 않는다고 판단하는 경우<br> 아. 사이트에서
								규정한 게시물 원칙에 어긋나거나, 게시판 성격에 부합하지 않는 <br> 자. 기타 관계법령에 위배된다고
								판단되는 경우<br> <br> 3. 관리자는 게시물 등에 대하여 제3자로부터 명예훼손, 지적재산권
								등의 권리 침해를 이유로 게시중단 요청을 받은 경우 이를 임시로 게시중단(전송중단)할 수 있으며, 게시중단 요청자와
								게시물 등록자 간에 소송, 합의 기타 이에 준하는 관련기관의 결정에 따릅니다.<br> 4. 해당 게시물
								등에 대해 임시게시중단이 된 경우, 게시물을 등록한 회원은 재게시(전송재개)를 사이트에 요청할 수 있으며, 게시
								중단일로부터 3개월 내에 재 게시를 요청하지 아니한 경우 관리자는 이를 삭제할 수 있습니다.<br> <br>
								제18조 (게시물에 대한 저작권)<br> 1. 관리자가 작성한 게시물 또는 저작물에 대한 저작권 기타
								지적재산권은 관리자에 귀속합니다.<br> 2. 회원이 서비스 내에 게시한 게시물의 저작권은 게시한 회원에게
								귀속됩니다. 단, 관리자는 서비스의 운영, 전시, 전송, 배포, 홍보의 목적으로 회원의 별도의 허락 없이 무상으로
								저작권법에 규정하는 공정한 관행에 합치되게 합리적인 범위 내에서 다음과 같이 회원이 등록한 게시물을 사용할 수
								있습니다.<br> <br> 가. 서비스 내에서 회원 게시물의 복제, 수정, 개조, 전시, 전송,
								배포 및 저작물성을 해치지 않는 범위 내에서의 편집 저작물 작성<br> 나. 미디어, 통신사 등 서비스
								제휴 파트너에게 회원의 게시물 내용을 제공, 전시 혹은 홍보하게 하는 것. 단, 이 경우 관리자는 별도의 동의 없이
								회원의 통합회원 ID 외에 회원의 개인정보를 제공하지 않습니다. 회원의 게시물을 이용하고자 하는 경우, 전화,
								팩스, 전자우편(E-mail) 등의 방법을 통해 사전에 회원의 동의를 얻어야 합니다.<br> <br>
								3. 회원이 이용계약 해지를 한 경우 본인 계정에 기록된 게시물 일체는 삭제됩니다. 단, 타인에 의해 보관, 담기
								등으로 재게시 되거나 복제된 게시물과 타인의 게시물과 결합되어 제공되는 게시물, 공용 게시판에 등록된 게시물 등은
								그러하지 않습니다.<br> 4. 관리자는 제3항 이외의 방법으로 회원의 게시물을 이용하고자 하는 경우,
								전화, 팩스, 전자우편(E-mail) 등의 방법을 통해 사전에 회원의 동의를 얻어야 합니다.<br> <br>
								제19조 (서비스 제공의 중지)<br> 1. 사이트는 제공되는 서비스의 일부 또는 전부를 운영환경 및
								정책의 변화에 따라 중지 할 수 있습니다.<br> 2. 사이트는 제1항으로 인한 서비스의 중지에 따른
								이용자의 기대이익 상실에 대하서는 배상하지 않습니다.<br> <br> 제20조 (서비스 이용제한)
								관리자는 회원이 서비스 이용내용에 있어서 다음 각 호에 해당하는 경우 서비스 이용 제한, 초기화, 이용계약 해지 및
								기타 해당 조치를 할 수 있습니다.<br> <br> 가. 회원정보에 부정한 내용을 등록하거나
								타인의 ID, 비밀번호 기타 개인정보를 도용하는 행위 또는 이용자 ID를 타인과 거래하거나 제공하는 행위<br>
								나. 공공질서 및 미풍양속에 위반되는 저속, 음란한 내용 또는 타인의 명예나 프라이버시를 침해할 수 있는 내용의
								정보, 문장, 도형, 음향, 동영상을 전송, 게시, 전자우편(E-mail) 또는 기타의 방법으로 타인에게 유포하는
								행위<br> 다. 다른 이용자를 희롱 또는 위협하거나, 특정 이용자에게 지속적으로 고통 또는 불편을 주는
								행위<br> 라. 관리자로부터 특별한 권리를 부여 받지 않고 사이트의 클라이언트 프로그램을 변경하거나,
								서버를 해킹하는 등 웹사이트 또는 게시된 정보의 일부분 또는 전체를 임의로 변경하는 행위<br> 마.
								서비스를 통해 얻은 정보를 센터의 사전 승낙 없이 서비스 이용 외의 목적으로 복제하거나, 이를 출판 및 방송 등에
								사용하거나, 제 3자에게 제공하는 행위<br> 바. 사이트의 운영진, 직원 또는 관계자를 사칭하거나 고의로
								서비스를 방해하는 등 정상적인 서비스 운영에 방해가 될 경우<br> 사. 방송통신심의위원회 등 관련
								공공기관의 시정 요구가 있는 경우<br> 아. 약관을 포함하여 관리자가 정한 제반 규정을 위반하거나 범죄와
								결부된다고 객관적으로 판단되는 등 제반 법령을 위반하는 행위<br> <br> <br> <strong>제5장
									권리와 의무</strong><br> <br> 제21조 (사이트의 의무)<br> 1. 사이트는 특별한
								사유가 없는 한 서비스 제공 설비를 항상 운용 가능한 상태로 유지 보수하여야 하며, 안정적으로 서비스를 제공할 수
								있도록 최선의 노력을 다하여야 합니다.<br> 2. 사이트는 서비스와 관련한 회원의 불만사항이 접수되는
								경우 이를 즉시 처리하여야 하며, 즉시 처리가 곤란한 경우 그 사유와 처리 일정을 서비스 또는
								전자우편(E-mail)을 통하여 해당 회원에게 통지하여야 합니다.<br> <br> 제22조
								(회원의 의무)<br> 1. 회원은 관계 법령, 본 약관의 규정, 이용 안내 및 서비스 상에 공지한
								주의사항, 관리자가 통지하는 사항을 준수하여야 하며, 기타 사이트의 업무에 방해되는 행위를 하여서는 안됩니다.<br>
								2. 회원은 관리자의 사전 동의 없이 서비스를 이용하여 어떠한 영리행위도 할 수 없으며, 법에 저촉되는 자료를 배포
								또는 게재할 수 없습니다.<br> 3. 회원은 관리자가 "개인정보보호정책"에 의하여 책임을 지는 경우를
								제외하고, 자신의 통합회원 ID와 비밀번호를 유지 관리할 책임이 있으며 자신의 통합회원ID와 비밀번호를 사용하여
								발생하는 모든 결과에 대해 전적인 책임이 있습니다. 또한 자신의 통합회원ID와 비밀번호가 자신의 승낙 없이
								사용되었을 경우 즉시 관리자에게 통보하여야 합니다.<br> 4. 회원은 서비스와 관련하여 다음 사항을
								하여서는 안 됩니다.<br> 가. 서비스를 이용하여 얻은 정보를 관리자의 사전 승낙 없이 복사, 복제,
								변경, 번역, 출판, 방송, 전송, 전시 기타의 방법으로 사용하거나 타인에게 제공하는 행위<br> 나.
								서비스와 게시판에 음란물을 게재 또는 음란 사이트를 링크하거나, 유포 등 사회질서를 해치는 행위<br>
								다. 타인의 명예를 훼손하거나 모욕하는 행위, 타인의 지적재산권 등의 권리를 침해하는 행위<br> 라.
								해킹 또는 컴퓨터 바이러스를 유포하는 일, 타인의 의사에 반하여 광고성 정보 등 일정한 내용을 지속적으로 전송하는
								행위<br> 마. 다른 회원의 ID를 부정 사용하는 행위<br> 바. 다른 회원의 개인 정보를
								수집, 저장하는 행위<br> 사. 타인을 사칭하는 행위<br> 아. 서비스를 통해 전송된 콘텐츠의
								발신인을 위조하는 행위<br> 자. 서비스를 통한 스토킹(stalking), 기타 타인을 괴롭히는 행위<br>
								차. 서비스의 운영에 지장을 주거나 줄 우려가 있는 일체의 행위, 기타 관계 법령에 위배되는 행위<br>
								<br> 제23조 (양도금지) 회원은 서비스의 이용권한, 기타 이용 계약상 지위를 타인에게 양도, 증여할
								수 없으며, 이를 담보로 제공할 수 없습니다.<br> <br> 제24조 (손해배상) 사이트는
								제공하는 서비스와 관련하여 회원에게 어떠한 손해가 발생하더라도 사이트의 중대한 과실에 의한 경우를 제외하고 이에
								대하여 책임을 부담하지 않습니다.<br> <br> 제25조 (면책 조항)<br> 1.
								사이트는 회원이 서비스를 통해 게재 또는 전송한 정보, 자료, 사실의 정확성, 신뢰성 등 내용에 관하여 어떠한
								보증도 하지 아니하며 회원의 서비스 자료에 대한 취사선택 또는 이용으로 발생하는 손해 등에 대해 책임을 지지
								아니합니다.<br> 2. 사이트는 회원이 서비스를 이용하여 기대하는 손익이나 서비스를 통하여 얻은 자료로
								인한 손해에 관하여 책임을 지지 아니합니다.<br> 3. 사이트는 회원 상호간 또는 회원과 제3자 상호간에
								서비스를 매개로 발생한 분쟁에 대해서는 개입할 의무가 없으며 이로 인한 손해를 배상할 책임도 없습니다.<br>
								4. 사이트는 회원의 귀책사유로 인하여 서비스 이용의 장애가 발생한 경우에는 책임이 면제됩니다.<br>
								5. 약관의 규정을 위반함으로 인하여 사이트에 손해가 발생하게 되는 경우, 이 약관을 위반한 회원은 센터에 발생되는
								모든 손해를 배상하여야 하며, 동 손해로부터 사이트를 면책시켜야 합니다.<br> 6. 사이트는 서비스에서
								제공되는 웹페이지, 게시판의 게시물 등이 보유되는 기간, 송수신할 수 있는 게시물의 최대크기 등 일반 사용에 대한
								제한을 할 수 있습니다.<br> <br> 제26조 (분쟁의 해결)<br> 1. 사이트와
								회원은 서비스와 관련하여 발생한 분쟁을 원만하게 해결하기 위하여 필요한 모든 노력을 하여야 합니다.<br>
								2. 모든 노력에도 불구하고 소송이 제기될 경우, 사이트는 해당 관리자의 소재지 관할 법원을 전속 관할 법원으로
								합니다.<br> <br> 제27조 (법률의 적용) 회원의 서비스 사용으로 발생되는 모든 법적
								문제는 대한민국 관계 법령의 적용을 받습니다.<br> <br> 부칙<br> <br>
								이 약관은 공시한 날부터 시행합니다.

							</div>
							<p class="txt-error" style="display: none;">이용약관에 동의해주세요.</p>
						</div>
						<div class="terms-agree">
							<br> <input type="checkbox" id="chk_agree01"
								onclick="fn_clickAgree(this);"> <label for="chk_agree01">개인정보
								수집 및 이용</label> <em class="c-required">필수</em>
							<div class="contentBox">
								<strong>1. 개인정보 수집 및 이용 목적</strong><br> - 서비스 이용에 따른 본인 식별,
								가입의사 확인<br> - 불량회원의 부정이용 방지 및 비인가 사용 방지<br> - 이용 대상별
								서비스 접근 제한<br> - 공지사항 전달 및 신규 서비스 등 정보 안내<br> <br>
								<strong>2. 수집하는 개인정보의 항목</strong><br>

								<table class="board-list">
									<caption>수집하는 개인정보의 항목</caption>
									<colgroup>
										<col>
										<col>
										<col>
									</colgroup>
									<thead>
										<tr>
											<th scope="col">구분</th>
											<th scope="col">필수</th>
											<th scope="col">선택</th>

										</tr>
									</thead>
									<tbody>
										<tr>
											<td>개인</td>
											<td>이름 또는 별명, 성별, 아이디,<br> 비밀번호, 이메일주소, 생년월일
											</td>
											<td>통합대상사이트 기존회원ID, 학교, <br>학년/반, 연락처, 직업
											</td>
										</tr>
										<tr>
											<td>기관/기업</td>
											<td>아이디, 비밀번호, 소속기관·기업명,주소,<br> 사업자등록번호, 담당자 성명,
												성별, 연락처
											</td>
											<td>통합대상사이트 기존회원ID, 직업</td>
										</tr>
									</tbody>
								</table>
								<br> <br> <strong>3. 개인정보의 보유 및 이용기간</strong><br>
								- 개인정보는 회원탈퇴 전까지 보유합니다.<br> - 회원탈퇴 시 모든 개인정보는 삭제됩니다.<br>
								- 회원정보의 보유에 대해 2년 주기로 회원의 재동의를 받습니다. 재동의 요청에 대해 아무런 응답을 하지 않는
								경우에는 2개월의 유예 기간을 거쳐 회원탈퇴 처리합니다.<br> <br> <strong>4.
									동의를 거부할 권리 및 동의 거부에 따른 불이익</strong><br> - 수집하는 개인정보의 항목 중 필수 정보에
								대해서는 수집 및 이용에 동의를 하셔야 이후 절차를 진행할 수 있습니다. 동의를 하지 않을 경우 회원가입이
								제한되고, 회원 로그인이 필요한 일부 서비스의 이용이 제한됩니다. 선택정보에 대해서는 동의를 거부할 수 있으며,
								이를 거부하더라도 서비스 이용에 대한 불이익은 없습니다.<br> ※ 선택정보 수집에 대한 동의를 거부할 수
								있으나 회원가입시나 회원가입 후 개인정보수정시 선택정보를 입력할 경우 선택정보 수집 및 이용에 동의한 것으로
								간주됩니다. <br>
							</div>
							<p class="txt-error" style="display: none;">개인정보 수집 및 이용에
								동의해주세요.</p>
						</div>

						<div class="terms-agree">
							<br> <input type="checkbox" id="chk_agree01"
								onclick="fn_clickAgree(this);"> <label for="chk_agree01">제3자
								정보제공동의</label> <em class="c-required">필수</em>
							<div class="contentBox">
								한국직업능력개발원은 진로교육정보망 통합회원 시스템 운영 등을 위해 아래와 같이 회원정보를 제공합니다. <br>
								제공하는 개인정보는 개인정보처리방침에서 고지한 제3자 제공 범위 내에서 제공하며, 정보주체의 사전 동의 없이 범위를
								초과하여 제3자에게 제공하지 않습니다.<br> <strong>1. 개인정보를 제공받는 자</strong><br>
								ㅇ 이용약관에 정의된 사이트를 운영하는 기관</strong><br> <br> <strong>2.
									개인정보를 제공받는 자의 개인정보 이용 목적</strong><br> ㅇ 회원제 서비스 이용, 본인 확인 및 개인식별,
								콘텐츠 제공, 이용자의 불만처리 등 통합회원과 연계된 회원정보 관리<br> <br> <strong>3.
									제공하는 개인정보의 항목</strong><br> ㅇ 통합회원 정보<br> 개인회원 <br> - 필수항목
								: 이름 또는 별명, 성별, 아이디, 비밀번호, 이메일주소, 생년월일<br> - 선택항목 : 통합대상사이트
								기존회원ID, 학교, 학년/반, 연락처, 직업<br> <br> 기관/기업 회원 <br>
								- 필수항목 : 아이디, 비밀번호, 소속기관·기업명, 주소, 사업자등록번호, 담당자 성명, 성별, 연락처 <br>
								- 선택항목 : 통합대상사이트 기존회원ID, 직업<br> <br> 자동수집항목<br> -
								IP주소, 쿠키, MAC주소, 서비스 이용기록, 방문기록, 불량 이용기록 등<br> <br> <strong>4.
									개인정보를 제공받는 자의 개인정보 보유 및 이용기간 : 회원 탈퇴시 또는 2년 주기 재동의(2년)</strong><br>
								<font color='blue'>※ 개인정보 제공에 대한 동의를 거부할 권리가 있으며, 동의를 거부할
									경우 서비스를 이용할 수 없습니다.</font><br>
							</div>
							<p class="txt-error" style="display: none;">제3자 정보제공동의에
								동의해주세요.</p>
						</div>
						<div class="btn-c">
							<a href="javascript:void(0);" onclick="fn_cancel(event)"
								class="btn-info btn">미동의</a>
						</div>
						<br>
					</div>
				</div>
				<hr>
				<br>
				<div class="col-md-6 col-md-offset-3 text-center">
					<h2>본인인증</h2>
				</div>
				<div class="container-inner">
					<div class="box-certify">
						<a href="javascript:void(0);"
							onclick="fn_checkStplat('modal_email', event)"
							class="input-email bnt btn-lg btn-primary" title="레이어팝업 열림">이메일
							인증하기</a> <a href="javascript:void(0);"
							onclick="fn_checkStplat('layer_SNS', event)"
							class="sns-type bnt btn-lg btn-primary" title="레이어팝업 열림">SNS
							인증하기</a>
					</div>
				</div>
			</div>
		</div>
		<!-- END fh5co-contact -->
		<div class="modal" id="modal_email" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h2>
							<em>이메일 인증</em>
						</h2>
						<button id="cfclose" type="button" class="close"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<h4>이메일 입력</h4>
						<div align="center">
							<input type="text" id="emailInput1"
								class="form-control emailCert"
								style="width: 180px; display: inline;"
								onkeyup="chkKorean(this.value);this.value=this.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g,'');this.value=this.value.replace(/\s/gi,'');">
							<span>@</span> <input type="text" id="emailInput2"
								class="form-control" style="width: 180px; display: inline;"
								onkeyup="chkKorean(this.value);this.value=this.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g,'');this.value=this.value.replace(/\s/gi,'');">
							<select id="emailSelect" class="form-control selectBar"
								style="width: 150px; display: inline;">
								<option value="">직접입력</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="hotmail.com">hotmail.com</option>
								<option value="chol.com">chol.com</option>
								<option value="dreamwiz.com">dreamwiz.com</option>
								<option value="empal.com">empal.com</option>
								<option value="lycos.co.kr">lycos.co.kr</option>
								<option value="netian.com">netian.com</option>
							</select>
						</div>
						<br>
						<div align="center">
							<a href="javascript:void(0);"
								onclick="fn_sendIssuCrtfcInfo('emailIput01', 'emailIput02')"
								class="bnt btn-lg btn-info">인증번호 받기</a> <br>
							<p class="txt-info" id='noti-email' style="display: none;">
								인증번호를 발송했습니다.<br>인증번호가 오지 않으면 입력하신 정보가 정확한지 확인하여 주세요.<br>받은메일함에서
								인증번호가 확인이 안되시면, 스팸메일함을 확인하여 주세요.
							</p>
						</div>
						<input type="hidden" name="encptEmailAdres" id="encptEmailAdres"
							value="" /> <br>
						<hr>
						<br>
						<h4>인증번호 입력</h4>
						<input type="text" id="codeIput" placeholder="인증번호"
							class="form-control" style="width: 400px; display: inline;">
						<a href="javascript:void(0);" onclick="check()"
							class="bnt btn-lg btn-primary" id="checkCode">인증번호 확인</a>
						<p class="txt-error" id="empty_checkCrtfcNo"
							style="display: none;">인증번호가 발송되지 않았습니다.</p>
						<p class="txt-error" id="differ_checkCrtfcNo"
							style="display: none;">인증번호가 올바르지 않습니다.</p>
						<br>
					</div>
					<div class="modal-footer">
						<ul style="list-style-type: none;">
							<li>※ 자주 이용하시는 이메일을 입력해주세요.</li>
							<li>※ 입력하신 이메일로 가입 승인 메일이 발송됩니다.</li>
							<li>※ 24시간 안에 가입 승인 메일을 확인해주세요.</li>
							<li>※ 받은메일함에서 인증번호가 확인이 안되면 스팸문자함 등을<br>확인하시기 바랍니다.
							</li>
						</ul>
					</div>
					<input type="hidden" id="joinCode" value="">
					<form action="" target="" id="chkEmail">
						<input type="hidden" value="" name="email" id="email">
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- END container-wrap -->
</body>
</html>