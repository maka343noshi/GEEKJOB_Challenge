<?php

try{
    $dns =  'mysql:host=localhost;';
    $dns .= 'dbname=Challenge_db;';
    $dns .= 'charset=utf8';
    // データベースへ接続
    $pdo_obj = new PDO($dns, 'root', '');
    // データベースの切断
    $pdo_obj = null;
} catch (PDOException $e) {
    echo 'DB接続に失敗しました。' . $e->getMessage();
}



