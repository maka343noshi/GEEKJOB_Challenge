<?php

//課題「ユーザー定義関数」
function myprofile(){
    echo '川崎<br>';
    echo '1997-01-13<br>';
    echo '宜しくお願いします。<br>';
}

//課題「引数1」
function kisugusu($num){
    if($num % 2 == 0){
        echo $num. 'は偶数です。';
    }elseif($num % 2 == 1){
        echo $num. 'は奇数です。';
    }
}