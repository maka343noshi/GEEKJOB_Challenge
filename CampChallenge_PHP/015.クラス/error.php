<?php
session_start();
?>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>ログインフォーム</title>
    </head>
    <body>
        エラーが発生しました<br>
        <?php echo $_SESSION['error']; ?><br>
        <a href='./index.php'>ホームに戻る</a>
    </body>
</html>