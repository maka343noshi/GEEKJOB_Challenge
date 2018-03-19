<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = 2; 
    
    if(num == 1){
        out.print("１です！");
    } else if(num == 2){
        out.print("プログラミングキャンプ！");
    } else {
        out.print("その他です！");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
