<?php

session_start();
//変数の用意
$name = null;
$gender = null;
$hoby = null;

$man = null;
$woman = null;

//すでにセッションがあれば取得
if(isset($_SESSION['name'])){
    $name = $_SESSION['name'];
    $gender = $_SESSION['gender'];
    $hoby = $_SESSION['hoby'];
    if($gender == '1'){
        $man = ' checked';
    }elseif($gender == '2'){
        $woman = ' checked';
    }
}

?>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>フォーム</title>
    </head>
    <body>
        <form action="./seForm.php" method="post">
            名前：
            <input type="text" name="name" value="<?php echo $hoby; ?>"><br><br>
            性別：<br>
            <input type="radio" name="gender" value="1"<?php echo $man; ?>>男性　
            <input type="radio" name="gender" value="2"<?php echo $woman; ?>>女性<br>
            趣味：<br>
            <textarea name="hoby"><?php echo $hoby; ?></textarea><br>

            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>