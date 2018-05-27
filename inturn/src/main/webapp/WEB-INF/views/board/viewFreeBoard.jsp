<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>View Board</title>
</head>
<body>
	<div class="container-wrap">
		<div class="row">
			제목 : ${board.title}
		</div>
		<div class="row">
			내용 : ${board.content}
		</div>
	</div>
</body>
</html>