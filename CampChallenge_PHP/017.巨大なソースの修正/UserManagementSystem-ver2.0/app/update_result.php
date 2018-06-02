<?php 
require_once '../common/defineUtil.php';
require_once '../common/scriptUtil.php';
require_once '../common/dbaccesUtil.php';
?>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
      <title>更新結果画面</title>
</head>
  <body>
    <?php
    if(isset($_POST['name']) && empty($_POST['year']) == false && empty($_POST['month']) == false && empty($_POST['day']) == false && isset($_POST['type']) && isset($_POST['tell']) && isset($_POST['comment'])){
      $birthday = $_POST['year'].'-'.sprintf('%02d',$_POST['month']).'-'.sprintf('%02d',$_POST['day']);
      $result = update_profile($_POST['id'],$_POST['name'],$birthday,$_POST['tell'],$_POST['type'],$_POST['comment']);
      //エラーが発生しなければ表示を行う
      if(!isset($result)){
      ?>
      <h1>更新確認</h1>
      以上の内容で更新しました。<br>
      <?php
      }else{
          echo 'データの更新に失敗しました。次記のエラーにより処理を中断します:'.$result;
      }
    }else{
      echo '入力項目が不完全です';
    }
    echo return_top(); 
    ?>
  </body>
</html>
