<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta charset="utf-8"> -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>人Turn &mdash; 다시 인생을 시작하다.</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by freehtml5.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<!-- <meta name="author" content="freehtml5.co" /> -->

<link href="https://fonts.googleapis.com/css?family=Oxygen:300,400"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,700"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Flexslider  -->
<link rel="stylesheet" href="css/flexslider.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<jsp:include page="userMenu.jsp" />
	<nav class="fh5co-nav" role="navigation">
	<div class="container-wrap">
		<div class="top-menu">
			<div class="row">
				<div class="col-xs-2">
					<div id="fh5co-logo">
						<a href="index.jsp">人Turn</a>
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
		<div id="fh5co-contact">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center">
					<h2>회원가입</h2>
				</div>
			</div>
			<div class="row">
				<form action="">
					<input id="type" type="hidden" class="form-control" name="type" value="mentee">
					<div class="col-md-4 col-md-push-4 animate-box">
						<div class="row">
							<div id="nameDiv" class="form-group">
								<input id="name" type="text" class="form-control" name="name"
									placeholder="이름" requierd="requierd">
							</div>
							<div id="idDiv" class="form-group form-inline">
								<input id="id" type="text" class="form-control" name="id"
									placeholder="아이디" requierd="requierd" style="width: 65%">
								<a href="javascript:void(0);"
									onclick="fn_checkDplctByLoginId(event)" class="btn btn-primary">중복확인</a>
							</div>
							<div id="pwDiv" class="form-group">
								<input id="pw" type="password" class="form-control"
									requierd="requierd" placeholder="비밀번호">
							</div>
							<div id="pwCheckDiv" class="form-group">
								<input type="password" id="pwCheck" name="pwCheck"
									class="form-control is-invalid" placeholder="비밀번호 확인"
									required="required" id="pw" onblur="fn_checkPassword()">
								<p class="txt-msg msg-help" id="msg-hashcdLoginPassword">
									영문, 숫자, 특수문자를 포함하여 <span class="m-br">8자 이상</span>
									<!-- <a href="javascript:void(0);"
										onclick="_NtelsUtil.layerOpen('layer_pwIndo', event);"
										class="btn-question">사용 불가능한 비밀번호 보기</a> -->
								</p>
							</div>
							<div id="nameDiv" class="form-group">
								<input id="phone" type="text" maxlength="11"
									class="form-control" name="phone" placeholder="휴대전화 번호"
									requierd="requierd">
							</div>
							<div id="birthDiv" class="form-group form-inline">
								<input type="text" id="yy" name="yy" maxlength="4"
									style="width: 37%" class="form-control" placeholder="출생년도"
									onblur="fn_checkBirthday()"> <select id="mm"
									class="input-lg input-group" name="mm" title="월 선택"
									onfocus="fn_checkBirthday()" onblur="fn_checkBirthday()">
									<option value="">월</option>

									<option value="1">1월</option>

									<option value="2">2월</option>

									<option value="3">3월</option>

									<option value="4">4월</option>

									<option value="5">5월</option>

									<option value="6">6월</option>

									<option value="7">7월</option>

									<option value="8">8월</option>

									<option value="9">9월</option>

									<option value="10">10월</option>

									<option value="11">11월</option>

									<option value="12">12월</option>

								</select> <select id="dd" name="dd" class="input-lg input-group"
									onfocus="fn_checkBirthday()" onblur="fn_checkBirthday()">
									<option value="">일</option>

									<option value="1">1일</option>

									<option value="2">2일</option>

									<option value="3">3일</option>

									<option value="4">4일</option>

									<option value="5">5일</option>

									<option value="6">6일</option>

									<option value="7">7일</option>

									<option value="8">8일</option>

									<option value="9">9일</option>

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
									placeholder="이메일 주소">
							</div>
							<br>

							<div class="col-md-12 col-md-push-3">
								<div class="form-group">
									<button id="signUpBtn" type="button" class="btn btn-primary">다음</button>
									<a href="" class="btn btn-primary">뒤로</a>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>