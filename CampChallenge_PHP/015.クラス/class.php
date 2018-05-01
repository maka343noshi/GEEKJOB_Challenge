<?php

// Humanクラスの宣言
class Human {
    // フィールドの宣言
    public $name = '';
    public $age = 0;

    //２つの変数に値を設定するパブリックな関数
    public function setHuman($n, $a) {
        $this->name = $n;
        $this->age = $a;
    }

    //２つの変数の中身をechoするパブリックな関数
    public function echoHuman($n, $a) {
        echo $this->name;
        echo $this->age;
    }
}