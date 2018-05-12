<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<?php
    require_once dirname(__FILE__). '/function.php';
    $func = new func();
    try{
        $datas = $func->select();
        
    } catch (Exception $e) {
        session_start();
        $_SESSION['error'] = $e->getMessage();
        header( "Location: ./error.php" );
	    exit;
    } 
?>

<!-- tableにして表示 -->
            <title>在庫一覧</title>
    </head>
    <body>

        <table border=1>
            <tr>
                <th>profileID</th>
                <th>name</th>
                <th>tel</th>
                <th>age</th>
                <th>birthday</th>
            </tr>
            <?php foreach($datas as $recod){ ?>
            <tr align="right">
                <?php foreach ($recod as $key => $value){  ?>
                <td><?php echo $value ?></td>
                <?php } ?>
            </tr>
            <?php } ?>
        </table>
        <br>
        <a href="./userhome.php">戻る</a>
    </body>
</html>