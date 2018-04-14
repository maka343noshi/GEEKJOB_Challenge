<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品　表示</title>
    </head>
    <body>
        <h1>商品  <% out.print(request.getAttribute("type")); %>  表示</h1><br>
        
        <form action="./itemControl" method="POST">
            <input type="submit" name="insert" value="新規作成">　　<input type="submit" name="update" value="編集">　　<input type="submit" name="delete" value="削除"><br>
            <% out.print(request.getAttribute("list")); %><br>
        </form><br><br>
        
        <a href="./itemSeach">検索条件に戻る</a><br>
        <a href="./itemBase">在庫管理ホームに戻る</a>
    </body>
</html>
