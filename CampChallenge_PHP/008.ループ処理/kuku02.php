<?php

$num = array(1,2,3,4,5,6,7,8,9);

//九九 ７の段で処理を抜ける
foreach ($num as $side) {
    if($side == 7){
        break;
    }
    foreach ($num as $vertical) {
        echo $side * $vertical;
    }
    echo '<br>';
}
