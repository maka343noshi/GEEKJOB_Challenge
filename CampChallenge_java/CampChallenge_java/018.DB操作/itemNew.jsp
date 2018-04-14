<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録</title>
    </head>
    <body>
        <h1>商品登録</h1><br>
        <form action="./itemNewConf" method="POST">
            <table>
                <tr>
                    <th>商品ＩＤ</th>
                    <th>商品名</th>
                    <th>種別</th>
                    <th>価格（円）</th>
                    <th>在庫</th>
                </tr>
                <tr>
                    <th><input type="text" name="itemID" size="5"></th>
                    <th><input type="text" name="itemName" size="10"></th>
                    <th><select name="itemGroup">
                        <option value="1">家電</option>
                        <option value="2">ゲーム</option>
                        <option value="3">その他</option></th>
                    <th><input type="text" name="itemPrice" size="8"></th>
                    <th><input type="text" name="itemStock" size="4"></th>
                </tr>
                
            </table>
            <br>
            <input type="submit" name="itemNew" value="新規作成">
        </form>
    </body>
</html>
