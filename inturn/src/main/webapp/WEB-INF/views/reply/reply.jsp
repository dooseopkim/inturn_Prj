<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Reply</title>
</head>
<body>
	<div class="container-wrap">
		<br>
		<div id="insertReply" class="row">
			<div class="col-sm-2 text-right" style="margin-top: 11px;">
				<label>댓글 입력 : </label>
			</div>
			<div class="col-sm-8">
				<input id="replyContent" name="content" type="text"
					class="form-control"> <input id="id" name="id"
					type="hidden" value="${login.id}">
			</div>
			<div class="col-sm-2" style="margin-top: 2px;">
				<button id="insertReplyBtn" type="button" class="btn btn-primary">입력</button>
			</div>
		</div>
		<br>
		<div id="getReplies" class="row">
		</div>
	</div>
</body>
</html>