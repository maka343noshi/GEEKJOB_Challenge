<?php

//cookieに現在時刻をセット
$access = date('Y-m-d H:m:s');
setcookie('LastLoginDate', $access);

//cookieがあれば読み込む
if(isset($_COOKIE['LastLoginDate']) !== false){
    echo '前回のアクセス日時：'. $_COOKIE['LastLoginDate'];
}else{
    echo '前回のアクセス日時：enpty';
}
