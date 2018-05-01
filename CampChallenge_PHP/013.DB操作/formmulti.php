<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 初期ページ -->
<?php if(!isset($_POST['name'])){ ?>

        <title>検索フォーム</title>
    </head>
    <body>
        <form action="./formmulti.php" method="post">
            名前：
            <input type="text" name="name"><br><br> 
            年齢：
            <input type="text" name="age"><br><br>
            生年月日：<br>
            <input type="text" name="birthday"><br><br>

            <input type="submit" name="btnSubmit">
        </form>
    </body>

<!-- 入力後ページ -->
<?php }else{ ?>

<!-- 入力データを取得、DBアクセス -->
<?php
    //入力データの取得
    $name = $_POST['name'];
    $age = $_POST['age'];
    $birthday = $_POST['birthday'];
    try{
        $dns =  'mysql:host=localhost;';
        $dns .= 'dbname=Challenge_db;';
        $dns .= 'charset=utf8';
        // データベースへ接続
        $pdo = new PDO($dns, 'root', '');
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        
        //sql文の作成
        $sql = 'select * from profiles where name like :name and age = :age and birthday like :birthday';
        $stmt = $pdo->prepare($sql);

        //:nameの置き換え
        $stmt->bindValue(':name', '%'.$name.'%');
        $stmt->bindValue(':age', $age);
        $stmt->bindValue(':birthday', '%'.$birthday.'%');
        $stmt->execute();

        // 実行結果を取得
        $datas = $stmt->fetchAll(PDO::FETCH_ASSOC);
        
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

        <?php     } catch (PDOException $e) {
        echo 'DB接続に失敗しました。' . $e->getMessage();
        } ?>
        <br>
        <a href="./formmulti.php">戻る</a>
    </body>
<?php } ?>
</html>