<?php

//受け取ったプロフィールデータを配列として返す
function profile($id, $name, $birthday, $address){
    return array('ID'=>$id, 'name'=>$name, 'birthday'=>$birthday, 'address'=>$address);
}

//プロフィールデータの検索
function kensaku($data, $keyword){
    foreach ($data as $profile) {
        if(strpos($profile['name'], $keyword) !== false){
            return $profile;
        }
    }
}

//データの用意
$profile1 = profile('101', '田中', '1997-08-10', '東京都世田谷区');
$profile2 = profile('102', '佐藤', '1993-12-24', '千葉県市原市');
$profile3 = profile('103', '長野', '2000-03-07', '愛知県名古屋市');
//配列にまとめる
$data = array($profile1, $profile2, $profile3);

//$dataより検索処理
$result = kensaku($data, '藤');

//表示
foreach ($result as $key => $value) {
    if(strcmp($key, 'ID') == 0){
        continue;
    }
    echo $value. '<br>';
}