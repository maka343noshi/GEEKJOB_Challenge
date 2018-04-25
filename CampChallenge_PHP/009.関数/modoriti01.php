<?php

function myprofile(){
    echo '川崎<br>';
    echo '1997-01-13<br>';
    echo '宜しくお願いします。<br>';
    return true;
}

if(myprofile()){
    echo 'この処理は正しく実行できました';
}else {
    echo '正しく実行できませんでした';
}