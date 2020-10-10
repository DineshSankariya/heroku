$(document).ready(function(){
//        alert("submit button clicked before");
    $(".submit").click(function(event){

        event.preventDefault();
//        alert("submit button clicked");
//       var user=$("form").serialize();
          var data={

                 "name":$("#name").val(),
                 "email":$("#email").val(),
                 "password":$("#pass").val(),
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
                alert(data);
            },
        error: function() {
            alert('failure');
        }

        })

    })

})