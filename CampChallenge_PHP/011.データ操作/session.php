<?php

// セッション開始
session_start();


// セッションに情報を入れる。
$_SESSION['LastLogin'] = date('Y-m-d H:m:s');


// セッションからデータを取り出す
if(isset($_SESSION['LastLogin']) !== false){
    echo '前回のアクセス日時：'. $_SESSION['LastLogin'];
}else{
    echo '前回のアクセス日時：empty';
}