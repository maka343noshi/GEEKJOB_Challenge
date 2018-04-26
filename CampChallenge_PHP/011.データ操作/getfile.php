<?php

// 一時フォルダのファイルをWebアプリの管理下に移動
// Webアプリのファイル管理は、filesフォルダで実施
$files_path = './' . $_FILES['userfile']['name'];
// ファイルを移動
if (move_uploaded_file($_FILES['userfile']['tmp_name'], $files_path)) {
    // 成功したら、中身を表示してみる
    echo file_get_contents($files_path);
}
