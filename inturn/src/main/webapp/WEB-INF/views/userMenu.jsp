<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserMenu</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-10"></div>
		<div class="col-md-3 col-md-push-9">
			<c:if test="${empty login.id}">
				<a class="btn" id="login" href="/loginForm.do">로그인</a>
				<a class="btn" id="signUp" href="signup.do">회원가입</a>
			</c:if>
			<c:if test="${!empty login.id}">
				<a class="btn" id="logout" href="/logout.do">로그아웃</a>
				<a class="btn" id="mypage" href="/mypage.do">마이페이지</a>
			</c:if>
		</div>
	</div>
</body>
</html>