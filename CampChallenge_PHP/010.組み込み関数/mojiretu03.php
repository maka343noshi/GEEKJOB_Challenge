<?php

$str = 'きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます';

$str = str_replace('U', 'う', $str);
$str = str_replace('I', 'い', $str);

echo $str;
