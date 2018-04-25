<?php

$fp = fopen('sample.txt', 'w');

$intro = 'こんにちは。川崎です';

if ($fp != false) {
    fwrite($fp, $intro);
    fclose($fp);
}