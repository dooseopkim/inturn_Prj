<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CertificateModal</title>
</head>
<body>
	<div class="modal" id="certificateModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title">자격증 입력</h3>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-6">
							<label class="col-form-label label-edu">자격증 명</label> 
							<input type="search" class="form-control" id="certificate_name" name="certificate_name">
						</div>
						<div class="col-sm-6">
							<label class="col-form-label label-edu">발급기관</label> 
							<input type="text" class="form-control"	 id="published_by_license" name="published_by_license" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="writeCertificate">저장</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>