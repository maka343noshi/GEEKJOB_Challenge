<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザーログイン</title>
    </head>
    <body>
        <h1>ログインページ</h1><br>
        <font color="red">
        <% if(request.getAttribute("error") != null){out.print(request.getAttribute("error") + "<br>");} %><br><br>
        </font>
        <form action="./Login" method="POST">
            ユーザーID<br>
            <input type="text" name="userID"><br><br>
            パスワード<br>
            <input type="text" name="pass"> <br><br>
            
            <input type="submit" name="sublogin" value="ログイン">
        </form>
        <br><br>
        <a href="./index.html">戻る</a>
    </body>
</html>
