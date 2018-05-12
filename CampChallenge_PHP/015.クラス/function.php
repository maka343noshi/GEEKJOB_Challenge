<?php

class func{
    private $dns =  'mysql:host=localhost;'. 'dbname=Challenge_db;'. 'charset=utf8';
    private $usertable = 'user';
    private $stocktable = 'stock';

    //DB接続する関数
    public function connect(){
        $pdo = null;
        try{
            $pdo = new PDO($this->dns, 'root', '');
            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            throw new Exception('DB接続に失敗しました');
        }
        return $pdo;
    }

    //ユーザーログイン　正しければユーザー名を　間違いであればnullを返す
    public function login($id, $pass){
        try{
            $pdo = $this->connect();
            $sql = 'select * from '. $this->usertable. ' where userID = :id and pass = :pass';
        $stmt = $pdo->prepare($sql);
        
        //idを指定
        $stmt->bindValue(':id', $id);
        $stmt->bindValue(':pass', $pass);
        $stmt->execute();
        // 実行結果を連想配列で取得
        $datas = $stmt->fetchAll(PDO::FETCH_ASSOC);

        foreach($datas as $recod){
            foreach ($recod as $key => $value) {
                if($key == 'name'){
                    $name = $value;
                }
            }
        }

        if(!$name){
            throw new Exception ('ユーザーID、またはパスワードが違います');
        }

        return $name;

        } catch (Exception $e) {
            throw new Exception ($e->getMessage());
        } catch (PDOException $e) {
            throw new Exception ('DB操作でエラーが生じました');
        }
    }

    //DBの検索
    public function select(){
        try{
            $pdo = $this->connect();
            $sql = 'select * from '. $this->stocktable;
            $stmt = $pdo->prepare($sql);
            
            $stmt->execute();
            // 実行結果を連想配列で取得
            $datas = $stmt->fetchAll(PDO::FETCH_ASSOC);

            return $datas;
        } catch (Exception $e) {
            throw new Exception ($e->getMessage());
        } catch (PDOException $e) {
            throw new Exception ('DB操作でエラーが生じました');
        }
    }

    //DBへデータの挿入
    public function insert($id, $name, $group){
        try{
            $pdo = $this->connect();
            $sql = 'insert into '. $this->stocktable. ' value(:id, :name, :group)';
            $stmt = $pdo->prepare($sql);
            
            $stmt->bindValue(':id', $id);
            $stmt->bindValue(':name', $name);
            $stmt->bindValue(':group', $group);

            $stmt->execute();
            
            $pdo = null;

            return $datas;
        } catch (Exception $e) {
            throw new Exception ($e->getMessage());
        } catch (PDOException $e) {
            throw new Exception ('DB操作でエラーが生じました');
        }
    }
}
