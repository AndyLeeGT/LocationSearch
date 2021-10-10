<?php
session_start();

if(isset($_SESSION['id']) && isset($_SESSION['username'])){

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>locationSearch page</title>
</head>
<body>
    <h1> <?php echo "hi, you are ". $_SESSION['username']; ?></h1>
    
</body>
</html>

<?php
} else{
    header("Location: login_page_structure.php");
    exit();
}
?>