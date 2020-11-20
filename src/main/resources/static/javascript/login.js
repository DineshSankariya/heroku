$(document).ready(function(){
    $("form").css("margin-top","10px");
    $(".submit").click(function(event){

        event.preventDefault();

        var name=$(".email").val();
        var pass=$(".password").val();

        if(name && pass){

            $.ajax({

                        type:"GET",
                        url:"/user-api/loggingprocess",
                        data:{
                            "username":name,
                            "password":pass
                        },
                        success:function(data){

                            if(data=="granted"){

                                   window.location.href="/home/success";

                            }else{
//                                alert("Invalid credential");
                                 var error="<p>User doesn't exists</p>";
                                    $("h2").append(error);
                                    $("p").css({"margin":"0px","padding":"0px","font-size":"19px"});
                                    $("form").css("margin","0px");
//                                    alert("Enter valid username and password");
                                    setTimeout(function(){
                                        window.location.href="/home/login";
                                    },2500);
                            }

                        }

                    })


        }else{
            alert("Credential should not be empty..");
        }


    })


})