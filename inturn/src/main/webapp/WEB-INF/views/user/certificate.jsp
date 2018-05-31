<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Certificate</title>
</head>
<body>
	<div id="license" class="card">
		<input type="hidden" id="id" value="${login.id}">
		<div class="card-header">
			<div class="row">
				<div class="col-sm-6">
					<h3>자격증</h3>
				</div>
				<div class="col-sm-6 text-right">
					<input type="button" class="btn btn-primary" id="addCertificate"
						value="추가">
				</div>
			</div>
		</div>
		<div id="plusCertificate" class="card-body"></div>
		<div id="certificateFooter" class="card-footer"></div>
	</div>
</body>
</html>