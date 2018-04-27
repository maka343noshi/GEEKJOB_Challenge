<?php

try{
    $dns =  'mysql:host=localhost;';
    $dns .= 'dbname=Challenge_db;';
    $dns .= 'charset=utf8';
    // データベースへ接続
    $pdo = new PDO($dns, 'root', '');
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    
    //sql文の作成
    $sql = 'update profiles set name = :name, age = :age, birthday = :birthday where profileID = :id';
    $stmt = $pdo->prepare($sql);

    //idを指定
    $stmt->bindValue(':id', 1);
    $stmt->bindValue(':name', '松岡 修造');
    $stmt->bindValue(':age', 48);
    $stmt->bindValue(':birthday', '1967-11-06');
    
    $stmt->execute();
    
    //全件検索　表示
    $stmt = $pdo->prepare('select * from profiles');
    $stmt->execute();
    $datas = $stmt->fetchAll(PDO::FETCH_ASSOC);
    foreach($datas as $recod){
        foreach ($recod as $key => $value) {
            echo $key. ' : '. $value. '<br>';
        }
        echo '<br>';
    }

    $pdo = null;

    echo '成功';
} catch (PDOException $e) {
    echo 'DB接続に失敗しました。' . $e->getMessage();
}


