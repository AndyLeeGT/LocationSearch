const jsdom = require('jsdom')

var createContent = document.getElementById("create_content");
$(document).ready(function() {
    
    $('signupbutton').click(function() {

        $.ajax({
            url: 'https://directed-post-326819.uc.r.appspot.com/users?username=' + createContent.getElementsById("username").val() + "&password=" 
            + createContent.getElementsById("password").val(),
            type: 'POST',
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

