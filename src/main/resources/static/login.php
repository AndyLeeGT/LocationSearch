<?php
session_start();
include "db_conn.php";

if(isset($_POST['username']) && isset($_POST['password'])){
        function validate($data){
            $data = trim($data);
            $data = stripslashes($data);
            $data = htmlspecialchars($data);
            return $data;
        }
        $username = validate($_POST['username']);
        $password = validate($_POST['password']);

        if(empty($username)){
            header("Location: login_page_structure.php?error= username required");
            exit();
        } else if(empty($password)){
            header("Location: login_page_structure.php?error= password required");
            exit();
        } else{
            $sql = "SELECT * FROM login WHERE username = '$username' AND password = '$password'";
            $result = mysqli_query($conn,$sql);
            
            if(mysqli_num_rows($result) === 1){
                $row = mysqli_fetch_assoc($result);
                if($row['username'] === $username && $row['password'] === $password){
                    $_SESSION['username'] = $row['username'];
                    $_SESSION['password'] = $row['password'];
                    $_SESSION['id'] = $row['id'];
                    
                    header("Location: locationSearch.php");


                }
            }else{
                header("Location: login_page_structure.php?error= Incorrect Username or password");
            }

        }
}else{
    header("Location: login_page_structure.php?error");
    exit();
}