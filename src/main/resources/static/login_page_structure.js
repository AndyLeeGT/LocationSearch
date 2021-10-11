$(document).ready(function() {
    $('#submitbutton').click(event => {
        event.preventDefault()
        var username = $("#username").val();
        var password = $("#password").val();
        var JSONdata = { username: username, password: password };
        axios.post("https://directed-post-326819.uc.r.appspot.com/users", JSONdata)
            .catch((err) => {
                alert("Incorrect username or password. Please try again.")
                console.log(err)
            })
            .then((response) => {
                if (response) {
                    location.assign('locationSearch.html')
                }
            })
    });
});

