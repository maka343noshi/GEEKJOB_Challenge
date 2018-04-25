<?php

$total = filter_input( INPUT_GET, "total" );
$count = filter_input( INPUT_GET, "count" );
$typenum = filter_input( INPUT_GET, "type" );
$type = null;
$point = 0;

//typeを日本語表示
if(strcmp($type,'1') == 0){
    $type = '雑貨';
}elseif($type == '2'){
    $type = '生鮮食品';
}elseif($type == '3'){
    $type = 'その他';
}else{
    $type = '該当なし';
}
//ポイント計算
if($total >= 3000){
    $point = $total * 0.04;
}elseif($total >= 5000){
    $point = $total * 0.05;
}

//表示
echo '総額：'. $total. '<br>';
echo '総数：'. $count. '<br>';
echo '商品種別：'. $type. '<br>';
echo '１個当たり：'. ($total / $count). '<br>';
echo 'ポイント：'. $point. '<br>';
