<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 初期ページ -->
<?php if(!isset($_POST['name'])){ ?>

        <title>検索フォーム</title>
    </head>
    <body>
        <form action="./formselect.php" method="post">
            名前：
            <input type="text" name="name"><br>

            <input type="submit" name="btnSubmit">
        </form>
    </body>

<!-- 入力後ページ -->
<?php }else{ ?>

<!-- 入力データを取得、DBアクセス -->
<?php
    //入力データの取得
    $name = $_POST['name'];
    try{
        $dns =  'mysql:host=localhost;';
        $dns .= 'dbname=Challenge_db;';
        $dns .= 'charset=utf8';
        // データベースへ接続
        $pdo = new PDO($dns, 'root', '');
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        
        //sql文の作成
        $sql = 'select * from profiles where name like :name';
        $stmt = $pdo->prepare($sql);

        //:nameの置き換え
        $stmt->bindValue(':name', '%'.$name.'%');
        $stmt->execute();

        // 実行結果を取得
        $datas = $stmt->fetchAll(PDO::FETCH_ASSOC);

        $pdo = null;
        
    } catch (PDOException $e) {
        echo 'DB接続に失敗しました。' . $e->getMessage();
    }
?>

<!-- tableにして表示 -->
            <title>検索結果</title>
    </head>
    <body>

        <table border=1>
            <tr>
                <th>profileID</th>
                <th>name</th>
                <th>tel</th>
                <th>age</th>
                <th>birthday</th>
            </tr>
            <?php foreach($datas as $recod){ ?>
            <tr align="right">
                <?php foreach ($recod as $key => $value){  ?>
                <td><?php echo $value ?></td>
                <?php } ?>
            </tr>
            <?php } ?>
        </table>
        <br>
        <a href="./formselect.php">戻る</a>
    </body>

<?php } ?>

</html>