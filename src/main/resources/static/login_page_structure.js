var loginInput = document.getElementById("login_input");
loginInput.onsubmit = function(){submitFunction()};

function submitFunction() {
    $.ajax({
        url: 'localhost:8080/users',
        type: 'GET',
        dataType: 'json',
        data: {username: loginInput.getElementById("username").value,
               password: loginInput.getElementsById("password").value},
        timeout: 2500,
        success: function(result){
            console.log('Completed with success and data: ', result);
        },
        error: function(result){
            console.log('Error with message: ', result);
        }
    });

}

