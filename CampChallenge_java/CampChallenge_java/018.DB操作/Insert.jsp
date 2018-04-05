<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>profiles 挿入</h2>
        
        
        <form action="./dbope2" method="POST">
            profileID<br>
            <input type="text" name="profileID"><br><br>
            名前<br>
            <input type="text" name="name"> <br><br>
            tell<br>
            <input type="text" name="tel"><br><br>
            age<br>
            <input type="text" name="age"><br><br>
            birthday<br>
            <input type="text" name="birthday"><br><br>
            
            <input type="submit" name="btnSubmit" value="挿入">
        </form>
    </body>
</html>
