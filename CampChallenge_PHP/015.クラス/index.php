
<!-- ランディングページ -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>在庫管理システム</title>
    </head>
    <body>
        <h1>在庫管理システム</h1><br>
        <h3>在庫管理を行うシステムです。</h3>
        <br>
        <a href='./userlogin.php'>ログイン</a>
    </body>
</html>

<?php
    require_once dirname(__FILE__). '/function.php';
    $test = new func();
    try{
        $test->connect();
        $name = $test->login(1,1110);
        echo $name;
    } catch (Exception $e) {
        echo $e->getMessage();
    }
?>