<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 初期ページ -->
<?php if(!isset($_POST['name'])){ ?>

        <title>挿入フォーム</title>
    </head>
    <body>
        <form action="./forminsert.php" method="post">
            profileID：
            <input type="text" name="id"><br><br>
            名前：
            <input type="text" name="name"><br><br>
            電話番号：<br>
            <input type="text" name="tel"><br><br>
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
    $id = $_POST['id'];
    $name = $_POST['name'];
    $tel = $_POST['tel'];
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
        $sql = 'insert into profiles value(:id, :name, :tel, :age, :birthday)';
        $stmt = $pdo->prepare($sql);

        //:nameの置き換え
        $stmt->bindValue(':id', $id);
        $stmt->bindValue(':name', $name);
        $stmt->bindValue(':tel', $tel);
        $stmt->bindValue(':age', $age);
        $stmt->bindValue(':birthday', $birthday);
        
        $stmt->execute();

        $pdo = null;

        $massage = '挿入が完了しました。';
        
    } catch (PDOException $e) {
        $massage = 'DB接続に失敗しました。' . $e->getMessage();
    }
?>

<!-- tableにして表示 -->
            <title>挿入結果</title>
    </head>
    <body>

        <?php echo $massage ?>
        <br><br>
        <a href="./forminsert.php">戻る</a>
    </body>

<?php } ?>

</html>