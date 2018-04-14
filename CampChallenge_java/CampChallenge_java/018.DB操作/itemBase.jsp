<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理　ホーム</title>
    </head>
    <body>
        <h1>在庫管理</h1><br>
        <h3>ようこそ！　<% out.print(hs.getAttribute("name"));%> さん</h3><br><br>
        
        <h4>在庫の検索、編集追加はこちらから</h4><br>
        <a href="./itemSeach">在庫を検索する</a>
        <br>
        <h4>在庫一覧はこちらから</h4>
        <form action="./itemList" method="POST">
            <input type="hidden" name="List" value="2">
            <input type="submit" name="subList" value="在庫一覧を見る">
        </form>
        <br><br>
        <a href="./index">ログアウト</a>
    </body>
</html>
