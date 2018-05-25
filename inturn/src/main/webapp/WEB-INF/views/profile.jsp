<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人Turn &mdash; 다시 인생을 시작하다.</title>
<script type="text/javascript">
	$(document).ready(function() {

		// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
		var floatPosition = parseInt($("#sidenav").css('top'));
		// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

		var bottom = parseInt($("#sidenav").css('bottom')); //스크롤 끝까지 내릴 때.... 더이상 안내려가게...

		$(window).scroll(function() {
			// 현재 스크롤 위치를 가져온다.
			var scrollTop = $(window).scrollTop();
			var scrollBottom = $(document).height() - $(window).height();
			var newPosition = scrollTop + floatPosition + "px";
			if (scrollTop > scrollBottom-292) {
				$("#sidenav").stop().animate({
					"top" : scrollBottom-18+"px"
				}, {
					'duration' : 500,
					'easing' : 'easeInOutCubic',
				});
			} else {
				/* $("#sidenav").stop().animate({
					"top" : newPosition
				}, 500); */
				$("#sidenav").stop().animate({
					"top" : newPosition
				}, {
					'duration' : 500,
					'easing' : 'easeInOutCubic',
					'complete' : function() {
						console.log('이동 완료하였습니다.');
						console.log(scrollTop);
					}
				});
			}
		}).scroll();

	});
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
						<li><a href="main.do">홈</a></li>
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

	<!-- 테스트용도 -->
	<div class="row blogLayout animate-box">
		<div class="leftcolumn">
			<div class="card">
				<h3>인적사항</h3>
			</div>
			<div class="card">
				<h3>인적사항</h3>
			</div>
			<div class="card">
				<h3>인적사항</h3>
			</div>
			<div class="card">
				<h3>인적사항</h3>
			</div>
			<div class="card">
				<h3>인적사항</h3>
			</div>
			<div class="card">
				<h3>인적사항</h3>
			</div>
			<div class="card">
				<h3>인적사항</h3>
			</div>
			<div class="card">
				<h3>인적사항</h3>
			</div>
		</div>
		<div class="rightcolumn">
			<div class="card sidenav" id="sidenav">
				<h4>이력서 항목</h4>
				<ul class="fh5co-social-icons" style="display: inline-block;">
					<li><a class="btn icon-pencil" href=""
						data-linked_form_id="formEducation"
						data-sync_id="InputStat_SchoolInputStat"> <span>학력&nbsp;&nbsp;&nbsp;</span>
					</a></li>
					<li><a class="btn icon-briefcase" style="padding: 10px 12px;"
						href="" data-linked_form_id="formCareer"
						data-sync_id="InputStat_CareerInputStat"> <span>경력</span>
					</a></li>
					<li><a class="btn icon-newspaper" style="padding: 10px 12px;"
						href="" data-linked_form_id="formLicense"
						data-sync_id="InputStat_LicenseInputStat"> <span>자격증</span>
					</a></li>
					<li><a class="btn icon-file-text2" style="padding: 10px 12px;"
						href="" data-linked_form_id="formIntroduction"
						data-sync_id="InputStat_UserIntroduceInputStat"> <span>자기소개서</span>
					</a></li>
				</ul>
				<input data-val="true"
					data-val-required="SchoolInputStat 필드가 필요합니다."
					id="InputStat_SchoolInputStat" name="InputStat.SchoolInputStat"
					type="hidden" value="True" /> <input data-val="true"
					data-val-required="CareerInputStat 필드가 필요합니다."
					id="InputStat_CareerInputStat" name="InputStat.CareerInputStat"
					type="hidden" value="False" /> <input data-val="true"
					data-val-required="SocialInputStat 필드가 필요합니다."
					id="InputStat_SocialInputStat" name="InputStat.SocialInputStat"
					type="hidden" value="True" /> <input data-val="true"
					data-val-required="EduInputStat 필드가 필요합니다."
					id="InputStat_EduInputStat" name="InputStat.EduInputStat"
					type="hidden" value="True" /> <input data-val="true"
					data-val-required="AwardInputStat 필드가 필요합니다."
					id="InputStat_AwardInputStat" name="InputStat.AwardInputStat"
					type="hidden" value="False" /> <input data-val="true"
					data-val-required="LicenseInputStat 필드가 필요합니다."
					id="InputStat_LicenseInputStat" name="InputStat.LicenseInputStat"
					type="hidden" value="True" /> <input data-val="true"
					data-val-required="TrainingInputStat 필드가 필요합니다."
					id="InputStat_TrainingInputStat" name="InputStat.TrainingInputStat"
					type="hidden" value="False" /> <input data-val="true"
					data-val-required="LanguageInputStat 필드가 필요합니다."
					id="InputStat_LanguageInputStat" name="InputStat.LanguageInputStat"
					type="hidden" value="True" /> <input data-val="true"
					data-val-required="PortfolioInputStat 필드가 필요합니다."
					id="InputStat_PortfolioInputStat"
					name="InputStat.PortfolioInputStat" type="hidden" value="True" />
				<input data-val="true"
					data-val-required="UserAdditionInputStat 필드가 필요합니다."
					id="InputStat_UserAdditionInputStat"
					name="InputStat.UserAdditionInputStat" type="hidden" value="True" />
				<input data-val="true"
					data-val-required="UserIntroduceInputStat 필드가 필요합니다."
					id="InputStat_UserIntroduceInputStat"
					name="InputStat.UserIntroduceInputStat" type="hidden" value="True" />
			</div>
		</div>
	</div>

	<!-- <div class="container-wrap">
		<div id="fh5co-contact">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
					<h2>Contact us</h2>
					<p>Far far away, behind the word mountains, far from the
						countries Vokalia and Consonantia.</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 col-md-push-1 animate-box">
					<h3>Our Address</h3>
					<ul class="contact-info">
						<li><i class="icon-location4"></i>198 West 21th Street, Suite
							721 New York NY 10016</li>
						<li><i class="icon-phone3"></i>+ 1235 2355 98</li>
						<li><i class="icon-location3"></i><a href="#">info@yoursite.com</a></li>
						<li><i class="icon-globe2"></i><a href="#">www.yoursite.com</a></li>
					</ul>
				</div>
				<div class="col-md-7 col-md-push-1 animate-box">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Name">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Email">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<textarea name="" class="form-control" id="" cols="30" rows="7"
									placeholder="Message"></textarea>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<input type="submit" value="Send Message"
									class="btn btn-primary btn-modify">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
</body>
</html>