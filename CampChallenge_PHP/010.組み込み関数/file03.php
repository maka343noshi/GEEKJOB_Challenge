<?php
require_once dirname(__FILE__).'/fileutil.php';

$filename = 'log.txt';

//ファイルを開き開始を記入
$fp = fopen($filename, 'a');
if ($fp != false) {
    fwrite($fp, start()."\r\n");
    fclose($fp);
}


for($i=1; $i<1000000; $i++){
    $num = 5*500;
    $num = 5/500;
}


//ファイルを開き終了を記入
$fp = fopen($filename, 'a');
if ($fp != false) {
    fwrite($fp, tend()."\r\n");
    fclose($fp);
}
