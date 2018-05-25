<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="/css/user/loginFooter.css">
</head>
<body>
	<!-- 회원가입, ID 및 비밀번호 찾기 -->
	<div>
		<ul class="utill-login">
			<li class="btn-join"><a href="javascript:void(0);"
				onclick="javascript: window.location='signup.do' ; return false ;"><strong>회원가입</strong>
					아직 회원이 아니신가요?</a></li>
			<li class="find-id"><a href="javascript:void(0);"
				onclick="javascript: window.location='findIDForm.do' ; return false ;"><strong>아이디
						찾기</strong> 아이디를 분실하셨나요?</a></li>
			<li class="find-pw"><a href="javascript:void(0);"
				onclick="javascript: window.location='findPW.do' ; return false ;"><strong>비밀번호
						찾기</strong> 비밀번호를 분실하셨나요?</a></li>
		</ul>
	</div>
</body>
</html>