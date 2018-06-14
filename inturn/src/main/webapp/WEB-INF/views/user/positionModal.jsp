<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>positionModal</title>
</head>
<body>
	<!-- 직급/직책 모달 -->
	<div class="modal" id="positionModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title">직급/직책 선택</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<table class="table positionTable">
						<tbody>
							<tr>
								<th>직급</th>
								<td><ul class="list_depth2" id="gradeList">
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg000">
												<input type="radio" id="job_grade_jg000" name="job_grade"
												class="inp_check" value="인턴/수습"> <span
												class="txt_check">인턴/수습</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg010">
												<input type="radio" id="job_grade_jg010" name="job_grade"
												class="inp_check" value="사원"> <span
												class="txt_check">사원</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg020">
												<input type="radio" id="job_grade_jg020" name="job_grade"
												class="inp_check" value="주임"> <span
												class="txt_check">주임</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg030">
												<input type="radio" id="job_grade_jg030" name="job_grade"
												class="inp_check" value="계장"> <span
												class="txt_check">계장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg040">
												<input type="radio" id="job_grade_jg040" name="job_grade"
												class="inp_check" value="대리"> <span
												class="txt_check">대리</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg050">
												<input type="radio" id="job_grade_jg050" name="job_grade"
												class="inp_check" value="과장"> <span
												class="txt_check">과장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg060">
												<input type="radio" id="job_grade_jg060" name="job_grade"
												class="inp_check" value="차장"> <span
												class="txt_check">차장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg070">
												<input type="radio" id="job_grade_jg070" name="job_grade"
												class="inp_check" value="부장"> <span
												class="txt_check">부장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg080">
												<input type="radio" id="job_grade_jg080" name="job_grade"
												class="inp_check" value="감사"> <span
												class="txt_check">감사</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg090">
												<input type="radio" id="job_grade_jg090" name="job_grade"
												class="inp_check" value="이사"> <span
												class="txt_check">이사</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg100">
												<input type="radio" id="job_grade_jg100" name="job_grade"
												class="inp_check" value="상무"> <span
												class="txt_check">상무</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg110">
												<input type="radio" id="job_grade_jg110" name="job_grade"
												class="inp_check" value="전무"> <span
												class="txt_check">전무</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg120">
												<input type="radio" id="job_grade_jg120" name="job_grade"
												class="inp_check" value="부사장"> <span
												class="txt_check">부사장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg140">
												<input type="radio" id="job_grade_jg140" name="job_grade"
												class="inp_check" value="사장"> <span
												class="txt_check">사장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg130">
												<input type="radio" id="job_grade_jg130" name="job_grade"
												class="inp_check" value="임원"> <span
												class="txt_check">임원</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg150">
												<input type="radio" id="job_grade_jg150" name="job_grade"
												class="inp_check" value="연구원"> <span
												class="txt_check">연구원</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg160">
												<input type="radio" id="job_grade_jg160" name="job_grade"
												class="inp_check" value="주임연구원"> <span
												class="txt_check">주임연구원</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg170">
												<input type="radio" id="job_grade_jg170" name="job_grade"
												class="inp_check" value="선임연구원"> <span
												class="txt_check">선임연구원</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg180">
												<input type="radio" id="job_grade_jg180" name="job_grade"
												class="inp_check" value="책임연구원"> <span
												class="txt_check">책임연구원</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg190">
												<input type="radio" id="job_grade_jg190" name="job_grade"
												class="inp_check" value="수석연구원"> <span
												class="txt_check">수석연구원</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_grade_jg200">
												<input type="radio" id="job_grade_jg200" name="job_grade"
												class="inp_check" value="연구소장"> <span
												class="txt_check">연구소장</span>
										</label></li>
									</ul></td>
							</tr>
							<!-- 직급 END -->
							<tr>
								<th scope="row">직책</th>
								<td>
									<ul class="list_depth2" id="dutyList">
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd010">
												<input type="radio" id="job_duties_jd010" name="job_duties"
												class="inp_check" value="팀원"> <span
												class="txt_check">팀원</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd020">
												<input type="radio" id="job_duties_jd020" name="job_duties"
												class="inp_check" value="팀장"> <span
												class="txt_check">팀장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd030">
												<input type="radio" id="job_duties_jd030" name="job_duties"
												class="inp_check" value="실장"> <span
												class="txt_check">실장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd040">
												<input type="radio" id="job_duties_jd040" name="job_duties"
												class="inp_check" value="총무"> <span
												class="txt_check">총무</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd050">
												<input type="radio" id="job_duties_jd050" name="job_duties"
												class="inp_check" value="지점장"> <span
												class="txt_check">지점장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd060">
												<input type="radio" id="job_duties_jd060" name="job_duties"
												class="inp_check" value="지사장"> <span
												class="txt_check">지사장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd070">
												<input type="radio" id="job_duties_jd070" name="job_duties"
												class="inp_check" value="파트장"> <span
												class="txt_check">파트장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd080">
												<input type="radio" id="job_duties_jd080" name="job_duties"
												class="inp_check" value="그룹장"> <span
												class="txt_check">그룹장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd090">
												<input type="radio" id="job_duties_jd090" name="job_duties"
												class="inp_check" value="센터장"> <span
												class="txt_check">센터장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd100">
												<input type="radio" id="job_duties_jd100" name="job_duties"
												class="inp_check" value="매니저"> <span
												class="txt_check">매니저</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd110">
												<input type="radio" id="job_duties_jd110" name="job_duties"
												class="inp_check" value="본부장"> <span
												class="txt_check">본부장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd120">
												<input type="radio" id="job_duties_jd120" name="job_duties"
												class="inp_check" value="사업부장"> <span
												class="txt_check">사업부장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd130">
												<input type="radio" id="job_duties_jd130" name="job_duties"
												class="inp_check" value="원장"> <span
												class="txt_check">원장</span>
										</label></li>
										<li class="item_depth2"><label
											class="sri_check small sri_radio" for="job_duties_jd140">
												<input type="radio" id="job_duties_jd140" name="job_duties"
												class="inp_check" value="국장"> <span
												class="txt_check">국장</span>
										</label></li>
									</ul>
								</td>
							</tr>
							<!-- 직책  END-->
						</tbody>
					</table>
					<div class="box_select_etc">
						<label class="sri_check small sri_radio" for="job_grade_etc020">
							<input type="radio" id="job_grade_etc020" name="job_grade_etc"
							class="inp_check" value="etc020" onclick="free()"> <span class="txt_check" style="padding-right: 1em;">임시직/프리랜서</span>
						</label> <label class="sri_check small sri_radio" for="job_grade_etc021">
							<input type="radio" id="job_grade_etc021" name="job_grade_etc"
							class="inp_check" value="etc021" onclick="self()"> <span class="txt_check" style="padding-right: 1em;">직접입력</span>
						</label> <input type="text" id="job_text_input" name="job_text_input" class="form-control"
							style="width: 250px; display: inline;" maxlength="20" readonly="readonly">
					</div>
				</div>
				<!-- modal body END -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="modalOk" onclick="" style="height: 40.47px; margin-bottom: 0px; margin-left: 4px" >완료</button>
					<button type="button" class="btn btn-tmp" id="modalCancel">취소</button>
					<button type="button" class="btn btn-default" id="modalClear">초기화</button>

				</div>
			</div>
			<!-- modal content END -->
		</div>
		<!-- modal dialog END -->
	</div>
	<!-- modal END -->
</body>
</html>