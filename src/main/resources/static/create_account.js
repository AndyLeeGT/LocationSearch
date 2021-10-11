$(document).ready(function() {
    
    $('#signupbutton').click(function() {
        var username = $("#username").val();
        var password = $("#password").val();
        var JSONdata = { "password": password };
        axios.put("http://localhost:8080/users?username=" + username, JSONdata)
            .then(
                window.location = "/locationSearch.html"
            )
            .catch(err => console.log(err))

    });
});

