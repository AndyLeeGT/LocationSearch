<?php
session_start();
include "db_conn.php";

if(isset($_POST['name']) && isset($_POST['username']) && isset($_POST['password']) && isset($_POST['re_password'])){
        function validate($data){
            $data = trim($data);
            $data = stripslashes($data);
            $data = htmlspecialchars($data);
            return $data;
        }
        $username = validate($_POST['username']);
        $password = validate($_POST['password']);
        $name = validate($_POST['name']);
        $re_password = validate($_POST['re_password']);

        $user_data ='username'.$username. '$name ='.$name;

        if(empty($username)){
            header("Location: create_account.php?error= username required");
            exit();
        } else if(empty($password)){
            header("Location: create_account.php?error= password required");
            exit();
        } else{
            //hashing password
            $password = md5($password);

            $sql = "SELECT * FROM login WHERE username = '$username'";
            $result = mysqli_query($conn,$sql);
            
            if(mysqli_num_rows($result) > 0){
                header("Location: create_account.php?error=Please use different username");
                exit();
            }
            else{
                $sql_register = "INSERT INTO login(username,password,name) VALUES ('$username' , '$password' , '$name')";
                $result_register = mysqli_query($conn,$sql_register);
            }
            if($result_register){
                header("Location: create_account_success.php");
                exit();
            }

        }
}else{
    header("Location: create_account.php?error");
    exit();
}