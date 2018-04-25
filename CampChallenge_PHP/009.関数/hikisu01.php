<?php

function kisugusu($num){
    if($num % 2 == 0){
        echo $num. 'は偶数です。';
    }elseif($num % 2 == 1){
        echo $num. 'は奇数です。';
    }
}

kisugusu(128);
