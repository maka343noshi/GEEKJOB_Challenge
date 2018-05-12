<?php


class Human extends base{
    private $table = 'profiles';

    //DBから全情報を取得        
    function load(){
        $datas = null;
        try{
            $dns =  'mysql:host=localhost;';
            $dns .= 'dbname=Challenge_db;';
            $dns .= 'charset=utf8';
            // データベースへ接続
            $pdo = new PDO($dns, 'root', '');
            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            
            // ユーザーテーブルを全て取得する
            $sql = 'select * from '. $this->table;
            $stmt = $pdo->prepare($sql);
            $stmt->execute();
            // 実行結果を連想配列で取得
            $datas = $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            echo 'DB接続に失敗しました。' . $e->getMessage();
        }
        return $datas;
    }

    //取得した情報の表示
    function show($datas){
        try{
            //表示
            foreach($datas as $recod){
                foreach ($recod as $key => $value) {
                    echo $key. ' : '. $value. '<br>';
                }
                echo '<br>';
            }
            $pdo = null;
        } catch (PDOException $e) {
            echo 'DB接続に失敗しました。' . $e->getMessage();
        }
    }
}