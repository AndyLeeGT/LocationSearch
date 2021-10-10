$(document).ready(function() {
    
    $('#signupbutton').click(function() {
        var username = $("#username").val();
        var password = $("#password").val();
        var JSONdata = { "password": password };
        $.ajax({
            url: 'https://directed-post-326819.uc.r.appspot.com/users?username=' + username,
            type: 'PUT',
            contentType: 'application/json',
            dataType: 'json',
            data: JSONdata,
            timeout: 2500,
            success: function(result){
                console.log('Completed with success and data: ', result);
            },
            error: function(result){
                console.log('Error with message: ', result);
            }
        });

    });
});

