<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>School.js</title>
</head>
<body>
	<script type="text/javascript">
		/**
		 * @author 박현호
		 * @version 1.0
		 * @since 2018.05.11
		 */
		 
		function regionChange() {
			getSchoolList();
		}
		/**
		* @see
		* 학교가 고등학교인지 대학교인지 select로 받아온 후 고등학교일 경우 high_list부분의
		* option들을 추가해주고, 대학교인 경우 else의 경우에 option을 추가
		*/
		function gubunChange() {
			$("#sch").empty();
			var gubun = $("#gubun").val();
			var options = '';
			if (gubun == "high_list") {
				options += '<option value=100362>일반고</option>';
				options += '<option value=100363>특성화고</option>';
				options += '<option value=100364>특수목적고</option>';
				options += '<option value=100365>자율고</option>';
				options += '<option value=100366>기타</option>';
			} else {
				options += '<option value=100322>전문대학</option>';
				options += '<option value=100323>대학(4년제)</option>';
			}
			$("#sch").append(options);
			getSchoolList();
		}
		/**
		 * @see
		 * 여태 입력한 지역과 학교정보를 전달하여,
		 * Controller에서 OpenAPI를 통해 학교이름을 받아오는 함수
		 */
		function getSchoolList() {
			$("#schoolName").empty();
			$.ajax({
				type : "POST",
				url : "/getSchoolList/" + $("#gubun").val() + "/" + $("#region").val() + "/" + $("#sch").val(),
				headers : {
					"Content-Type" : "application/json"
				},
				success : function(list) {
					var options = '';
					for (var i = 0; i < list.length; i++) {
						options += '<option value=' + list[i] + '>' + list[i] + '</option>';
					}
					$("#schoolName").append(options);
				}
			})
		}
		function schChange() {
			getSchoolList();
		}
		$(function() {
			$("#addSchool").click(function() {
				var tag = '';
				tag += '<div id="school" class="row">';
				tag += '지역 : ';
				tag += '<select id="region" onchange="regionChange()">';
				tag += '<option value="100260">서울특별시</option>';
				tag += '<option value="100267">부산광역시</option>';
				tag += '<option value="100269">인천광역시</option>';
				tag += '<option value="100271">대전광역시</option>';
				tag += '<option value="100272">대구광역시</option>';
				tag += '<option value="100273">울산광역시</option>';
				tag += '<option value="100275">광주광역시</option>';
				tag += '<option value="100276">경기도</option>';
				tag += '<option value="100278">강원도</option>';
				tag += '<option value="100280">충청북도</option>';
				tag += '<option value="100281">충청남도</option>'	;
				tag += '<option value="100282">전라북도</option>';
				tag += '<option value="100283">전라남도</option>';
				tag += '<option value="100285">경상북도</option>';
				tag += '<option value="100291">경상남도</option>';
				tag += '<option value="100292">제주도</option>';
				tag += '</select>';
				tag += '학교분류 : ';
				tag += '<select id="gubun" onchange="gubunChange()">';
				tag += '<option value="high_list">고등학교</option>';
				tag += '<option value="univ_list">대학교</option>';
				tag += '</select>';
				tag += '학교유형 : ';
				tag += '<select id="sch" onchange="schChange()">';
				tag += '<option value=100362>일반고</option>';
				tag += '<option value=100363>특성화고</option>';
				tag += '<option value=100364>특수목적고</option>';
				tag += '<option value=100365>자율고</option>';
				tag += '<option value=100366>기타</option>';
				tag += '</select>';
				tag += '학교 : ';
				tag += '<select id="schoolName"></select>';
				tag += '</div>';
				$("#schoolArea").append(tag);
				getSchoolList();
			})
	
			$("#deleteSchool").click(function() {
				$("#schoolArea").empty();
			})
		})
	</script>
</body>
</html>