<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
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
						<li><a href="freeBoard.do">자유게시판</a></li>
						<li class="has-dropdown"><a href="#">이용안내</a>
							<ul class="dropdown">
								<li><a href="#">자주 묻는 질문</a></li>
								<li><a href="csBoard.do">고객서비스</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<div class="container-wrap">
		<aside id="fh5co-hero">
		<div class="flexslider">
			<ul class="slides ">
				<li style="background-image: url(images/img_bg_3.jpg);">
					<div class="overlay-gradient"></div>
					<div class="container-fluids">
						<div class="row">
							<div class="col-md-6 col-md-offset-3 slider-text">
								<div class="slider-text-inner text-center">
									<h1>What Would You Like To Learn?</h1>
									<h2>
										Free html5 templates Available at <a
											href="http://Themewagon.com/theme_tag/free/" target="_blank">Themewagon</a>
									</h2>
									<p>
										<a class="btn btn-primary btn-demo" href="#"></i> View Demo</a> <a
											class="btn btn-primary btn-learn">Learn More</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
		</aside>


		<div id="fh5co-work" class="fh5co-light-grey">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
					<h2>Work</h2>
					<p>Dignissimos asperiores vitae velit veniam totam fuga
						molestias accusamus alias autem provident. Odit ab aliquam dolor
						eius.</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 text-center animate-box">
					<a href="work-single.html" class="work"
						style="background-image: url(images/portfolio-1.jpg);">
						<div class="desc">
							<h3>Project Name</h3>
							<span>Illustration</span>
						</div>
					</a>
				</div>
				<div class="col-md-4 text-center animate-box">
					<a href="work-single.html" class="work"
						style="background-image: url(images/portfolio-2.jpg);">
						<div class="desc">
							<h3>Project Name</h3>
							<span>Brading</span>
						</div>
					</a>
				</div>
				<div class="col-md-4 text-center animate-box">
					<a href="work-single.html" class="work"
						style="background-image: url(images/portfolio-3.jpg);">
						<div class="desc">
							<h3>Project Name</h3>
							<span>Illustration</span>
						</div>
					</a>
				</div>
			</div>
		</div>


		<div id="fh5co-blog" class="blog-flex">
			<div class="featured-blog"
				style="background-image: url(images/blog-1.jpg);">
				<div class="desc-t">
					<div class="desc-tc">
						<span class="featured-head">Featured Posts</span>
						<h3>
							<a href="#">Top 20 Best WordPress Themes 2017 Multi Purpose
								and Creative Websites</a>
						</h3>
						<span><a href="#" class="read-button">Learn More</a></span>
					</div>
				</div>
			</div>
			<div class="blog-entry fh5co-light-grey">
				<div class="row animate-box">
					<div class="col-md-12">
						<h2>Latest Posts</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 animate-box">
						<a href="#" class="blog-post"> <span class="img"
							style="background-image: url(images/blog-2.jpg);"></span>
							<div class="desc">
								<h3>26 Best Education WordPress Themes 2017 You Need To See</h3>
								<span class="cat">Collection</span>
							</div>
						</a>
					</div>
					<div class="col-md-12 animate-box">
						<a href="#" class="blog-post"> <span class="img"
							style="background-image: url(images/blog-1.jpg);"></span>
							<div class="desc">
								<h3>16 Outstanding Photography WordPress Themes You Must
									See</h3>
								<span class="cat">Collection</span>
							</div>
						</a>
					</div>
					<div class="col-md-12 animate-box">
						<a href="#" class="blog-post"> <span class="img"
							style="background-image: url(images/blog-3.jpg);"></span>
							<div class="desc">
								<h3>16 Outstanding Photography WordPress Themes You Must
									See</h3>
								<span class="cat">Collection</span>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!-- END container-wrap -->
	</div>
	<!-- END container-wrap -->
</body>
</html>