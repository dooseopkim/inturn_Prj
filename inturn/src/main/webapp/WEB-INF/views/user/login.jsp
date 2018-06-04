<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
	<link rel="stylesheet" href="/css/user/user.css">
	<link rel="stylesheet" href="/css/user/login.css">
	<script src="/js/user/login.js"></script>
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/sha256.js"></script>
</head>
<body>
	<jsp:include page="../userMenu.jsp" />
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
						<li class=""><a href="main.do">홈</a></li>
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
		<div class="page-login">
			<!-- 로그인 창 -->
			<div class="row box-login">
				<h2 class="login-h2">회원 로그인</h2>
				<div class="col-sm-1"></div>
				<div class="col-sm-4 box-login-default">
					<form action="" method="post">
						<fieldset>
							<!-- <legend>로그인</legend> -->
							<label for="loginId" class="invisible">아이디</label>
							<input type="hidden" id="chkModPw" value="${chkModPw}">
							<input type="text" id="loginId" placeholder="아이디" title="아이디 입력" value="">
							<label for="password" class="invisible">비밀번호</label>
							<input type="password" id="password" placeholder="비밀번호" title="비밀번호 입력">
							<label id="label_checkSaveId" class="form-check-label"><input type="checkbox" id="checkSaveId" class="form-check-input">아이디 저장</label>
							<input type="button" id="btn_login" class="btn btn-outline-success" value="로그인">
							
						</fieldset>
					</form>
				</div>
				<div class="col-sm-2"></div>
				<!-- 카카오/네이버 로그인 -->
				<div class="col-sm-4 box-login-sns">
					<form name="SnsLoginForm" id="SnsLoginForm" action="snsLogin.do" method="post">
						<ul class="snsLoginList">
							<li><a id="kakaoIdLogin" href="javascript:loginWithKakao()">
									<img src="/images/btn/login_kakao.png" />
							</a></li>
							<li><a id="naverIdLogin"> <img alt="login_naver.png"
									src="/images/btn/login_naver.png">
							</a></li>
						</ul>
						<p>※ 공용 PC에서 SNS 로그인 사용 후 로그아웃 시 SNS 로그아웃을 확인하세요.</p>
					<input type="hidden" name="snsLoginId" id="snsLoginId">
					<input type="hidden" name="snsTypeCode" id="snsTypeCode">
					</form>
				</div>
				<div class="col-sm-1"></div>
			</div>

		<!-- 회원가입, ID 및 비밀번호 찾기 -->
		<jsp:include page="loginFooter.jsp" />
		
		</div>
		</div>
	<script type='text/javascript'>
	/* 카카오아이디로로그인 */
	//<![CDATA[
	// 사용할 앱의 JavaScript 키를 설정해 주세요.
	Kakao.init('{JavaScript키}');
	// 카카오 로그인 버튼을 생성합니다.
	function loginWithKakao() {
		// 로그인 창을 띄웁니다.
		Kakao.Auth.login({
			success : function(authObj) {
				alert(JSON.stringify(authObj));
				alert("로그인 성공");
				location.href="/";
			},
			fail : function(err) {
				alert(JSON.stringify(err));
			}
		});
	};
	//]]>

	/* 네이버아디디로로그인 초기화 Script */
	var naverLogin = new naver.LoginWithNaverId({
		clientId : "QmvYUAYvK3me4MirilEo",
		callbackUrl : "https://inturn.cf/naverLogin.do",
		isPopup : false, /* 팝업을 통한 연동처리 여부 */
		callbackHandle: true,
		loginButton : {
			color : "green",
			type : 4,
			height : 50
		}
	/* 로그인 버튼의 타입을 지정 */
	});

	/* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
	
	window.addEventListener('load', function () {
		naverLogin.getLoginStatus(function (status) {
			if (status) {
				$.ajax({
					url: "naverLogin.do",
					type: "POST",
					data: {
						"email" : naverLogin.user.getEmail(),
						"name" : naverLogin.user.getName(),
						"birthday" : naverLogin.user.getBirthday()
					},
					success: function(data) {
						location.href="/main.do"
					}
				})
			} else {
				console.log("AccessToken이 올바르지 않습니다.");
			}
		});
	});
	</script>
	
</body>
</html>