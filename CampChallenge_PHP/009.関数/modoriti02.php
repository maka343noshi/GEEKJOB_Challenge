<?php

function profile(){
    return array('ID'=>'236', 'name'=>'川崎', 'birthday'=>'1997-01-13', 'address'=>'東京都品川区');
}

$data = profile();

foreach ($data as $key => $value) {
    if(strcmp($key, 'ID') == 0){
        continue;
    }
    echo $value. '<br>';
}
