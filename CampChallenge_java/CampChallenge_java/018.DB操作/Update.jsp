<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>profiles 更新画面</h2>
        
        <form action="./dbupdate" method="POST">
            更新するデータのprofileIDを入力<br>
            <input type="text" name="profileID"><br><br><br>
            
            名前<br>
            <input type="text" name="name"> <br><br>
            tell<br>
            <input type="text" name="tel"><br><br>
            age<br>
            <input type="text" name="age"><br><br>
            birthday<br>
            <input type="text" name="birthday"><br><br>
            
            <input type="submit" name="btnSubmit" value="更新">
        </form>
    </body>
</html>
