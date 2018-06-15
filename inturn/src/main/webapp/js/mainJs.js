/**
 * 
 */

$(function(){
	$("#myCarousel").carousel();
    
    // Enable Carousel Indicators
    $(".item1").click(function(){
        $("#myCarousel").carousel(0);
    });
    $(".item2").click(function(){
        $("#myCarousel").carousel(1);
    });
    $(".item3").click(function(){
        $("#myCarousel").carousel(2);
    });
    $(".item4").click(function(){
        $("#myCarousel").carousel(3);
    });
    
    // Enable Carousel Controls
    $(".left").click(function(){
        $("#myCarousel").carousel("prev");
    });
    $(".right").click(function(){
        $("#myCarousel").carousel("next");
    });
    
	$(".btn-signup").click(function(){
		location.href="signup.do";
	});
	
	$(".btn-login").click(function(){
		location.href="loginForm.do";
	});
	
	$(".btn-mentor").click(function(){
		location.href="mentor.do";
	});
	
	$(".btn-mentee").click(function(){
		location.href="mentee.do";
	});
	
	$(".btn-free").click(function(){
		location.href="freeBoard.do?page_num=1";
	});
	
});