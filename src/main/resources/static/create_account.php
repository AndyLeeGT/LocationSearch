
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIGN UP PAGE</title>
    <!-- adding login css-->
    <link rel = "stylesheet" href="create_account.css">

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
    <div class= "create_class">
        <section id = "create_content">    
            <form method = "post" action= "create_account_register.php">
            <h1> SIGNUP PAGE </h1>
             <!--error message for username taken -->
             <?php if(isset($_GET['error'])){ ?>
                <p class = "error"><?php echo $_GET['error']; ?></p>
            <?php } ?>

            <div id = "create_name">
                <input type = "text" placeholder= "name" require= "" id = "name" name = "name"/>
            </div>
            <!-- UserName contents-->
            <div id = "create_userName">
                <input type="text" placeholder="username" required = "" id="username" name = "username" />
            </div>
            <!-- password contents-->
            <div id = "create_password">
                <input type="text" placeholder="password" required= "" id="password" name = "password"/>
            </div>

            <!-- Re_password contents-->
            <div id = "create_re_password">
                <input type="text" placeholder="re_password" required= "" id="re_password" name = "re_password"/>
            </div>
            <!--submit button contents-->
            <div>
                <input type= "submit" value="Sign Up" />
            </div>
            <div>
                <a href = "login_page_structure.php"> Already have an account?</a>
            </div>

            
            </form>
        </section>
    </div>     
</body>
</html>