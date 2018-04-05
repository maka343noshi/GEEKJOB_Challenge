<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>profiles 検索画面</title>
    </head>
    <body>
        <h2>profiles 検索画面</h2>
        
        <form action="./dbope" method="POST">
            名前を入力してください<br>
            <input type="text" name="name"> <br>
            <input type="submit" name="btnSubmit" value="検索">
        </form>
        
    </body>
</html>
