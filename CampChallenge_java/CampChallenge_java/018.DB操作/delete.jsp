<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h2>profiles 削除画面</h2>
        
        <form action="./dbdelete" method="POST">
            profileIDを入力してください<br>
            <input type="text" name="profileID"> <br>
            <input type="submit" name="btnSubmit" value="削除">
        </form>
    </body>
</html>
