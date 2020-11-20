$(document).ready(function(){
//        alert("submit button clicked before");
//    $("input").focus(function(){
////        $("h2").css({"font-size":"49px","color":"white","transform":"rotate(-90deg)","position":"absolute","left":"140px","top":"285px","letter-spacing":"15px","transition-property":"all","transition":"0.7s"});
//        $("h2").addClass("animate_h2");
//    })
//
//
//    $("input").focusout(function(){
//            $("h2").removeClass("animate_h2");
//        })

    $("input").on("focus",function(){
             $("h2").addClass("animate_h2");
     })

     $("#dob").focusout(function(){
                  $("h2").removeClass("animate_h2");
          })



    $(".submit").click(function(event){

        event.preventDefault();
//        $("h2").removeClass("animate_h2");
//        alert("submit button clicked");
//       var user=$("form").serialize();

//        $("h2").removeClass("animate_h2");
          var data={

                 "name":$("#fname").val()+" "+$("#lname").val(),
                 "email":$("#email").val(),
                 "pass":$("#pass").val(),
                 "mobile":$("#mobile").val(),
                 "dob":$("#dob").val(),

             };

       console.log(JSON.stringify(data));
       $.ajax({
            contentType: 'application/json;charset=UTF-8',
            type: "POST",
            url: "/user-api/save",
            data: JSON.stringify(data),
            success: function(data){
//                alert('Form submitted');
                if(data=="Not saved"){
                    alert(data);
                }else{
                    alert(data);
                    window.location.href="/home/login";
                }

            },
        error: function() {
            alert('failure');
        }

        })

    })

})