<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 初期ページ -->
<?php if(!isset($_POST['name'])){ ?>

        <title>挿入フォーム</title>
    </head>
    <body>
        <form action="./forminsert.php" method="post">
            商品ID：
            <input type="text" name="id"><br><br>
            商品名：
            <input type="text" name="name"><br><br>
            商品ジャンル：<br>
            <input type="text" name="group"><br><br>                        
                        
            <input type="submit" name="btnSubmit">
        </form>
    </body>

<!-- 入力後ページ -->
<?php }else{ ?>

<!-- 入力データを取得、DBアクセス -->
<?php
    //入力データの取得
    $id = $_POST['id'];
    $name = $_POST['name'];
    $group = $_POST['group'];

    require_once dirname(__FILE__). '/function.php';
    $func = new func();
    
    try{
        $datas = $func->insert();
        
    } catch (Exception $e) {
        session_start();
        $_SESSION['error'] = $e->getMessage();
        header( "Location: ./error.php" );
	    exit;
    } 
?>

<!-- tableにして表示 -->
            <title>挿入結果</title>
    </head>
    <body>

        <?php echo '挿入が完了しました。' ?>
        <br><br>
        <a href="./userhome.php">戻る</a>
    </body>

<?php } ?>

</html>