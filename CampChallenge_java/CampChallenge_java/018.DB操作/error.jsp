<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        <h3>エラーが発生しました。<br>
            <% out.print(request.getAttribute("error")); %></h3> <br><br>
        <a href="./index.html">トップに戻る</a>
    </body>
</html>
