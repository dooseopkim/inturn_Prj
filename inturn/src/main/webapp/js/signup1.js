$(function() {
	$("#signUpBtn").click(function() {
		var birth = $("#yy").val() + "-" + $("#mm") + "-" + $("#dd");
		$.ajax({
			url : "dsfdfsd",
			method : POST,
			type : "JSON",
			data : {
				"name" : $("#name").val(),
				"id" : $("#id").val(),
				"pw" : $("#pw").val(),
				"phone" : $("#phone").val(),
				"birth" : birth,
				"email" : $("#email").val()
			},
			success : function(data) {
				if(data.result == "success")
					window.open("popUp.jsp?popUp=WEB-INF/views/popUp/successSignUp.jsp","회원가입 성공","width=350px,height=350px,toolbar=no,location=no,status=no,menubar=no,resizable=no,status=no");
				else
					window.open("popUp.jsp?popUp=WEB-INF/views/popUp/failSignUp.jsp","회원가입 실패","width=350px,height=350px,toolbar=no,location=no,status=no,menubar=no,resizable=no,status=no");
			},
			error:function(request, status, error){
				alert("error:"+error)
			}
		});
	});
});