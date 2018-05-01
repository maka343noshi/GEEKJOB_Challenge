<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 初期ページ -->
<?php if(!isset($_POST['id'])){ ?>

        <title>検索フォーム</title>
    </head>
    <body>
        <form action="./formdelete.php" method="post">
            profileID：
            <input type="text" name="id"><br>

            <input type="submit" name="btnSubmit">
        </form>
    </body>

<!-- 入力後ページ -->
<?php }else{ ?>

<!-- 入力データを取得、DBアクセス -->
<?php
    //入力データの取得
    $id = $_POST['id'];
    try{
        $dns =  'mysql:host=localhost;';
        $dns .= 'dbname=Challenge_db;';
        $dns .= 'charset=utf8';
        // データベースへ接続
        $pdo = new PDO($dns, 'root', '');
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        
        //sql文の作成
        $sql = 'delete from profiles where profileID = :id';
        $stmt = $pdo->prepare($sql);

        //:nameの置き換え
        $stmt->bindValue(':id', $id);
        $stmt->execute();

        $pdo = null;

        $massage = '削除しました。';
        
    } catch (PDOException $e) {
        $massage = 'DB接続に失敗しました。' . $e->getMessage();
    }
?>

<!-- tableにして表示 -->
            <title>検索結果</title>
    </head>
    <body>

        <?php echo $massage ?>
        <br><br>
        <a href="./formdelete.php">戻る</a>
    </body>

<?php } ?>

</html>