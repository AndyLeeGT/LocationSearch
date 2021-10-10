$(document).ready(function() {
    
    $('submitbutton').click(function() {

        $.ajax({
            url: 'https://directed-post-326819.uc.r.appspot.com/users?username=' + $("username").val() + "&password=" 
            + $("password").val(),
            type: 'GET',
            dataType: 'json',
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

