<?php

$name = $_POST['name'];
$gendernum = $_POST['gender'];
$hoby = $_POST['hoby'];
$gender = null;

if($gendernum == 1){
    $gender = '男性';
}elseif($gendernum == 2){
    $gender = '女性';
}

echo $name, '<br>';
echo $gender. '<br>';
echo $hoby, '<br>';
