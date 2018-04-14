<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    hs.setAttribute("userID", "0000");
    hs.setAttribute("pass", "0000");
    hs.setAttribute("name", "default");
    request.setAttribute("result", 2222);
    request.getRequestDispatcher("/itemList").forward(request, response);
    
%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1><br>
        <form action="./itemList" method="POST">
            <input type="hidden" name="List" value="1">
            <input type="submit" name="subList" value="在庫一覧を見る">
        </form>
    </body>
</html>
