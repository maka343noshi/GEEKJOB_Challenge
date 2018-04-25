<?php

// 2016年11月4日 10時0分0秒のタイムスタンプ
$stamp = mktime(10, 0, 0, 11, 4, 2016);

$today = date('Y-m-d H:m:s', $stamp);

echo $today;
