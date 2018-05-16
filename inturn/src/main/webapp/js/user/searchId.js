/**
 * 
 */
$(function(){
	$("#btn_searchId").click(function(){
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
			url: "searchId.do",
			method: "POST",
			type: "JSON",
			data: {
				"name" : $("#name").val(),
				"email" : $("email").val()
			},
			success: function(data){
				alert($("#name").val()+"님의 아이디는 "+data.id+"입니다.");
			}
			
		});
	});
});
