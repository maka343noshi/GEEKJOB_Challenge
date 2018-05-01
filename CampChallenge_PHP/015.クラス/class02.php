<?php

//Humanクラスを継承
class Teacher extends Human {

    //２つの変数の中身をクリアするパブリックな関数
    public function clear() {
        $this->name = '';
        $this->age = 0;
    }
}
