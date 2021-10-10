<?php

$sname = "localhost";
$uname = "root";
$password = "";
$db = "usercredential";

$conn = mysqli_connect($sname,$uname,$password,$db);

if(!$conn){
    echo "connection failed";
}