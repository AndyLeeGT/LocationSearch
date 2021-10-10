
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOG IN PAGE</title>
    <!-- adding login css-->
    <link rel = "stylesheet" href="login_page_structure.css">

</head>
<style>
    h1{text-align: center;}
    form{text-align: center;}
</style>    
<body>
    
    <!-- link to forget password-->
    <link rel = "password_reset" href="password_reset.html">
    <link rel = "create account" href="create_account.html"> 
    <!-- login functionality-->
    <div class= "log_in_class">
        <section id = "log_in_content">    
            <form method = "$POST"action= "login.php">
            <h1> LOGIN PAGE </h1>
            <!-- UserName contents-->
            <div id = "log_in_userName">
                <input type="text" placeholder="Username" required = "" id="username" />
            </div>
            <!-- password contents-->
            <div id = "log_in_password">
                <input type="text" placeholder="Password" required= "" id="password" />
            </div>
            <!--submit button contents-->
            <div>
                <input type= "submit" value="Log in" />
            </div>
            
            <div>
                <input type="checkbox" checked = "checked" name ="remember"> Remember Me
            </div>
            
            <div>
            <a href="password_reset.html">Forgot Password? </a>

            <a href="create_account.html">Need account? </a>
            </div>
            </form>
        </section>
    </div>

    <script src="login_page_strucutre.js"></script>       
</body>
</html>