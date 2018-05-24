/**
 * 
 */
$(function(){
	$("#btn_modifyUserPW").click(function(){
		alert("클릭!")
		$.ajax({
			url: "modifyUserPw.do",
			method: "POST",
			type: "JSON",
			data: {
				"id" : $("#id").val(),
				"pw" : $("#pw").val(),
				"newPw" : $("#newPw").val()
			},
			success: function(data){
				if(data.result == "success"){
					alert("성공");
					
				} else {
					alert(data.result);
				}
			}
		});
	});
});