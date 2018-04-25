<?php

$num = array(1,2,3,4,5,6,7,8,9);

//九九
foreach ($num as $side) {
    foreach ($num as $vertical) {
        echo $side * $vertical;
    }
    echo '<br>';
}

echo '<br>';

//九九　5の段のみ表示しない
foreach ($num as $side) {
    if($side == 5){
        continue;
    }
    foreach ($num as $vertical) {
        echo $side * $vertical;
    }
    echo '<br>';
}
