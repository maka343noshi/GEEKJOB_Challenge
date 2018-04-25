<?php

$num = (Integer)filter_input(INPUT_GET, 'num');
$numf = $num;
$result = null;

while($numf % 2 == 0){
    $numf /= 2;
    $result .= '2×';
}

while($numf % 3 == 0){
    $numf /= 3;
    $result .= '3×';
}
while($numf % 5 == 0){
    $numf /= 5;
    $result .= '5×';
}
while($numf % 7 == 0){
    $numf /= 7;
    $result .= '7×';
}


echo $num. '<br>'. mb_substr($result, 0, mb_strlen($result) - 1). '<br>';
if($numf != 0){
    echo '余り '. $numf;
}
