<%@page import="process.Check"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    HttpSession hs = request.getSession();
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>以下の内容で登録します</h2><br>
        <table>
            <tr>
                <th>商品ＩＤ</th>
                <th>商品名</th>
                <th>種別</th>
                <th>価格（円）</th>
                <th>在庫</th>
            </tr>
            <tr>
                <th><% out.print(hs.getAttribute("itemID")); %></th>
                <th><% out.print(hs.getAttribute("itemName")); %></th>
                <th><% out.print(Check.group(Integer.valueOf(String.valueOf(hs.getAttribute("itemGroup"))))); %></th>
                <th><% out.print(hs.getAttribute("itemPrice")); %></th>
                <th><% out.print(hs.getAttribute("itemStock")); %></th>
            </tr>
        </table>
         
        <br><br>
        <form action="./itemNewResult" method="POST">
            <input type="submit" name="insert" value="新規登録">
        </form>
        <br>
        <a href="./itemNew.jsp">戻る</a>
    </body>
</html>
