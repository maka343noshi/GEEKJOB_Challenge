<?php

try{
    $dns =  'mysql:host=localhost;';
    $dns .= 'dbname=Challenge_db;';
    $dns .= 'charset=utf8';
    // データベースへ接続
    $pdo = new PDO($dns, 'root', '');
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    
    //sql文の作成
    $sql = 'select * from profiles where profileID = :id';
    $stmt = $pdo->prepare($sql);
    
    //idを指定
    $stmt->bindValue(':id', 1);
    $stmt->execute();

    // 実行結果を連想配列で取得
    $datas = $stmt->fetchAll(PDO::FETCH_ASSOC);

    //表示
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


