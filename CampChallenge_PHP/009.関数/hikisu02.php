<?php

function kakezan($num1, $num2=5, $bool=false){
    if($bool){
        return ($num1*$num2)**2;
    }else{
        return $num1*$num2;
    }
}

echo kakezan(3, 4, true);
