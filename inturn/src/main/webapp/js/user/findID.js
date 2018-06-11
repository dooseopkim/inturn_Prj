/**
 * @author 이슬기
 * @since 2018.05.18
 * @see findID 관련 JQuery 및 JavaScript
 * @returns
 */
$(function(){
	
	/*아이디찾기 버튼 클릭 시*/
	$("#btn_findID").click(function(){
		findId();
	});
	
	/*이름 입력란에서 엔터 시*/
	$("#name").keydown(function(e) {
		if (e.keyCode === 13) {
			$("#email").focus();
		} 
	});
	
	/*이메일 입력란에서 엔터 시*/
	$("#email").keydown(function(e){
		if(e.keyCode === 13){
			findId();
		}
	});
	
	function findId(){
		if($("#name").val()==""){
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}else if($("#email").val()==""){
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}
		$.ajax({
			url: "findID.do",
			method: "POST",
			type: "JSON",
			data: {
				"name" : $("#name").val(),
				"email" : $("#email").val()
			},
			success: function(data){
				if(data.result=="success"){
						alert($("#name").val()+"님의 아이디는 "+data.id+" 입니다.");
				} else {
					alert(data.result);
				}
			}
		});
	}
});
