<?php

try{
    $dns =  'mysql:host=localhost;';
    $dns .= 'dbname=Challenge_db;';
    $dns .= 'charset=utf8';
    // データベースへ接続
    $pdo = new PDO($dns, 'root', '');
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    //プリペアドステートメントを作成
    $sql = 'insert into profiles value(:profileID, :name, :tel, :age, :birthday)';
    $stmt = $pdo->prepare($sql);

    $stmt -> bindValue(':profileID', '7');
    $stmt -> bindValue(':name', '佐藤 猛');
    $stmt -> bindValue(':tel', '090-1123-4537');
    $stmt -> bindValue(':age', '23');
    $stmt -> bindValue(':birthday', '1994-09-30');
    
    $stmt->execute();
    $pdo = null;

    echo '成功';
} catch (PDOException $e) {
    echo 'DB接続に失敗しました。' . $e->getMessage();
}
