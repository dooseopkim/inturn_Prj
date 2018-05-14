<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/login.css">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('YOUR APP KEY');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        alert(JSON.stringify(authObj));
      },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
    });
  //]]>
</script>
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
						<li class=""><a href="main.do">홈</a></li>
						<li class="has-dropdown"><a href="intro1.do">소개</a>
							<ul class="dropdown">
								<li><a href="intro1.do">사업소개</a></li>
								<li><a href="intro2.do">서비스소개</a></li>
							</ul></li>
						<li><a href="mentor.do">멘토찾기</a></li>
						<li><a href="mentee.do">멘티찾기</a></li>
						<li><a href="freeBoard.do">자유게시판</a></li>
						<li class="has-dropdown"><a href="#">이용안내</a>
							<ul class="dropdown">
								<li><a href="#">자주 묻는 질문</a></li>
								<li><a href="csBoard.do">고객서비스</a></li>
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
	<div class="row">
		<h2 class="login-h2">회원 로그인</h2>
				<div class="col-sm-5 box-login">
				<form action="login.do" method="post">
					<fieldset>
						<!-- <legend>로그인</legend> -->
							<label for="loginId" class="invisible">아이디</label> <input
								type="text" name="loginId" id="loginId" placeholder="아이디"
								title="아이디 입력">
							<label for="password" class="invisible">비밀번호</label> <input
								type="password" name="password" id="password"
								onkeypress="if(event.keyCode==13){fn_SSO_login();}"
								placeholder="비밀번호" title="비밀번호 입력">
						<!-- <p>
							<input type="checkbox" id="chk_log" class="common-check">
							<label for="chk_log">아이디저장</label>
						</p> -->
						<!-- <a href="javascript:void(0);" class="btn-login"
							onclick="fn_SSO_login()">로그인</a> -->
						<input type="submit" id="btn_login" class="btn btn-secondary" value="로그인">	
					</fieldset>
				</form>
			</div>
		
		<div class="col-sm-1"></div>
		<!-- 카카오/네이버 로그인 -->
		<div class="col-sm-6 box-snsLogin">
		<form name="SnsLoginForm" id="SnsLoginForm" action="/cloud/oneid/saml2/sso/login.process.do" method="post">
					<ul class="snsLoginList">
						<li><a id="kakao-login-btn"  class="btn btn-snsLogin" ><img alt="login_kakao.png" src="/images/btn/login_kakao.png" width="300"></a></li>
						<li><a href="#" class="btn btn-snsLogin"><img alt="login_naver.png" src="/images/btn/login_naver.png" width="300"></a></li>
					</ul>
					<p class="etc-login-text">※ 공용 PC에서 SNS 로그인 사용 후 로그아웃 시 SNS 로그아웃을 확인하세요.</p>
					<input type="hidden" name="snsLoginId" id="snsLoginId">
					<input type="hidden" name="snsTypeCode" id="snsTypeCode">
					</form>
					
		</div>
	</div>
	
	<!-- 회원가입, ID 및 비밀번호 찾기 -->
	<div>
	<ul class="utill-login">
		<li class="btn-join"><a href="javascript:void(0);" onclick="javascript: window.location='signUp.do' ; return false ;"><strong>회원가입</strong> 아직 회원이 아니신가요?</a></li>
		<li class="find-id"><a href="javascript:void(0);" onclick="javascript: window.location='findID.do' ; return false ;"><strong>아이디 찾기</strong> 아이디를 분실하셨나요?</a></li>
		<li class="find-pw"><a href="javascript:void(0);" onclick="javascript: window.location='sendNewPW.do' ; return false ;"><strong>비밀번호 찾기</strong> 비밀번호를 분실하셨나요?</a></li>
	</ul>
	
	</div>
	</div>
	</div>
</body>
</html>