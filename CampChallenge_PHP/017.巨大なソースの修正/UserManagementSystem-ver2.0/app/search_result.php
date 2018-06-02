<?php 
require_once '../common/defineUtil.php';
require_once '../common/scriptUtil.php';
require_once '../common/dbaccesUtil.php';
$name = null;
$year = null;
$type = null;
?>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
      <title>検索結果画面</title>
</head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
        <?php
        $result = null;
        if(empty($_POST['name']) && empty($_POST['year']) && empty($_POST['type'])){
            $result = serch_all_profiles();
        }else{
            if(!empty($_POST['name'])){
                $name = $_POST['name'];
            }
            if(!empty($_POST['year'])){
                $year = $_POST['year'];
            }
            if(!empty($_POST['type'])){
                $type = $_POST['type'];
            }
            $result = serch_profiles($name,$year,$type);
        }
        foreach($result as $value){
        ?>
            <tr>
                <td><a href="<?php echo RESULT_DETAIL ?>?id=<?php echo $value['userID']?>"><?php echo $value['name']; ?></a></td>
                <td><?php echo $value['birthday']; ?></td>
                <td><?php echo ex_typenum($value['type']); ?></td>
                <td><?php echo date('Y年n月j日　G時i分s秒', strtotime($value['newDate']));; ?></td>
            </tr>
        <?php
        }
        ?>
        </table>

        <br>
        <?php echo return_top(); ?>
</body>
</html>
