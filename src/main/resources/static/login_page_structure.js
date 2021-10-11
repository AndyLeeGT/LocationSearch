$(document).ready(function() {
    $('#submitbutton').click(event => {
        event.preventDefault()
        var username = $("#username").val();
        var password = $("#password").val();
        var JSONdata = { username: username, password: password };
        axios.post("http://localhost:8080/users", JSONdata)
            .then(
                window.location = "/locationSearch.html"
            )
            .catch(err => console.log(err))
    });
});

