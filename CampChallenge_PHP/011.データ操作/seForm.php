<?php

//セッションスタート
session_start();

//入力された値をセッションに格納
$_SESSION['name'] = filter_input(INPUT_POST, "name" );
$_SESSION['gender'] = filter_input(INPUT_POST, "gender");
$_SESSION['hoby'] = filter_input(INPUT_POST, "hoby");

echo 'セッションに登録しました。';
?>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>フォーム</title>
    </head>
    <body>
        <a href="./form.php">戻る</a>
    </body>
</html>
