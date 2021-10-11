$(document).ready(function() {
    
    $('#signupbutton').click(function() {
        var username = $("#username").val();
        var password = $("#password").val();
        var JSONdata = { username: username, password: password };
        axios.put("https://directed-post-326819.uc.r.appspot.com/users", JSONdata)
            .catch(err => {
                alert("Failed to create user. Try a different username")
                console.log(err);
            })
            .then((response) => {
                if (response) {
                    location.assign('locationSearch.html')
                }
            })
    });
});

