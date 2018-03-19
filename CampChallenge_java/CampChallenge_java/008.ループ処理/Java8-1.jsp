<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    long num = 1;
    
    for(int i = 0; i < 20; i++){
        num = num * 8;
    }
    
    out.print(num);
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
