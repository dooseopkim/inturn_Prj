<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/signup.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/sha256.js"></script>
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
				<li class="selected">
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


		<div id="fh5co-contact">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center">
					<h2>개인정보</h2>
				</div>
			</div>
			<div class="row">
				<form id="signup" action="" target="_self">
					<div class="col-md-4 col-md-push-4 animate-box">
						<div class="row">
							<!-- <div id="iconDiv" class="form-group text-center">
							<img alt="" src="images/profile.png" id="" width="200px" height="200px">
							<input type="file" name="icon" accept="image/*">
							</div> -->
							<div id="typeDiv" class="form-group">
								<select id="type" class="form-control" name="type"
									requierd="requierd">
									<option value="">멘티/멘토 선택</option>
									<option value="mentee">멘티-청년</option>
									<option value="mentor">멘토-신중년</option>
								</select>
							</div>
							<div id="nameDiv" class="form-group">
								<input id="name" type="text" class="form-control" name="name"
									placeholder="이름" requierd="requierd" onkeypress="hangul();">
								<p class="txt-msg msg-help">이름은 한글만 입력가능합니다.</p>
							</div>
							<div id="idDiv" class="form-group form-inline">
								<input id="availId" type="text" class="form-control"
									placeholder="아이디" requierd="requierd" style="width: 59%;">
								<a href="javascript:void(0);" onclick="chkId()"
									style="vertical-align: sub;" class="bnt btn-lg btn-primary">중복확인</a>
								<input type="hidden" id="id" name="id" value="">
							</div>
							<div id="pwDiv" class="form-group">
								<input id="pw" type="password" class="form-control"
									requierd="requierd" placeholder="비밀번호">
								<p class="txt-msg msg-help" id="msg-hashcdLoginPassword">
									영문, 숫자, 특수문자를 포함하여 <span class="m-br">8자 이상</span>
								</p>
							</div>
							<div id="pwCheckDiv" class="form-group">
								<input type="password" id="pwCheck" name="pwCheck"
									class="form-control is-invalid" placeholder="비밀번호 확인"
									required="required" id="pw" onblur="chkPw()">
								<p id="msg-pwError" style="display: none; color: red;">비밀번호가
									일치하지 않습니다!</p>
							</div>
							<div id="nameDiv" class="form-group">
								<input id="phone" type="text" maxlength="11"
									class="form-control" name="phone" style="ime-mode: disabled;"
									placeholder="휴대전화 번호" requierd="requierd"
									onkeydown="return onlyNum(event)" onkeyup="removeChar(event)">
								<p class="txt-msg msg-help" id="msg-hashcdLoginPassword">
									'-' 없이 숫자만 입력해주세요.</p>
							</div>
							<div id="birthDiv" class="form-group form-inline">
								<input type="text" id="yy" name="yy" maxlength="4"
									required="required" style="width: 37%" class="form-control"
									placeholder="예) 1988" onkeydown="return onlyNum(event)"
									onkeyup="removeChar(event)"> <select id="mm"
									class="input-lg input-group" name="mm" title="월 선택"
									onfocus="fn_checkBirthday()" onblur="fn_checkBirthday()">
									<option value="">월</option>

									<option value="01">1월</option>

									<option value="02">2월</option>

									<option value="03">3월</option>

									<option value="04">4월</option>

									<option value="05">5월</option>

									<option value="06">6월</option>

									<option value="07">7월</option>

									<option value="08">8월</option>

									<option value="09">9월</option>

									<option value="10">10월</option>

									<option value="11">11월</option>

									<option value="12">12월</option>

								</select> <select id="dd" name="dd" class="input-lg input-group"
									onfocus="fn_checkBirthday()" onblur="fn_checkBirthday()">
									<option value="">일</option>

									<option value="01">1일</option>

									<option value="02">2일</option>

									<option value="03">3일</option>

									<option value="04">4일</option>

									<option value="05">5일</option>

									<option value="06">6일</option>

									<option value="07">7일</option>

									<option value="08">8일</option>

									<option value="09">9일</option>

									<option value="10">10일</option>

									<option value="11">11일</option>

									<option value="12">12일</option>

									<option value="13">13일</option>

									<option value="14">14일</option>

									<option value="15">15일</option>

									<option value="16">16일</option>

									<option value="17">17일</option>

									<option value="18">18일</option>

									<option value="19">19일</option>

									<option value="20">20일</option>

									<option value="21">21일</option>

									<option value="22">22일</option>

									<option value="23">23일</option>

									<option value="24">24일</option>

									<option value="25">25일</option>

									<option value="26">26일</option>

									<option value="27">27일</option>

									<option value="28">28일</option>

									<option value="29">29일</option>

									<option value="30">30일</option>

									<option value="31">31일</option>

								</select>
							</div>
							<div id="emailDiv" class="input-email">
								<input type="email" id="email" name="email" class="form-control"
									value="${email }" readonly="readonly">
							</div>
							<br>

							<div class="col-md-12 col-md-push-3">
								<div class="form-group">
									<a href="signup.do" class="bnt btn-lg btn-primary">뒤로</a> <a
										href="javascript:void(0);" onclick="signup(event)"
										id="signUpBtn" class="bnt btn-lg btn-primary">완료</a>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- END fh5co-contact -->
	</div>
	<!-- END container-wrap -->
</body>
</html>