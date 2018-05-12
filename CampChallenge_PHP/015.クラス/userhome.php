<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<?php
    //入力データの取得
    $id = $_POST['id'];
    $pass = $_POST['pass'];

    require_once dirname(__FILE__). '/function.php';
    $func = new func();
    
    try{
        $name = $func->login($id, $pass);
?>

<!-- tableにして表示 -->
            <title>挿入結果</title>
    </head>
    <body>
        ようこそ！
        <?php echo $name ?>さん
        <br><br>
        <h3>ここでは、在庫の確認、新規商品の在庫登録が行えます。</h3>
        <br>
        <a href='./stockdata.php'>在庫一覧</a><br>
        <a href='./stockinsert.php'>在庫登録</a>
        <br><br>
        <a href="./index.php">戻る</a>
    </body>

<?php
    } catch (Exception $e) {
        session_start();
        $_SESSION['error'] = $e->getMessage();
        header( "Location: ./error.php" );
	    exit;
    } 
?>

</html>