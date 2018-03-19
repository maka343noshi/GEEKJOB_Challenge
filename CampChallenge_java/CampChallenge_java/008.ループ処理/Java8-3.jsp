<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = 0;
    
    for(int i = 0; i <= 100; i++){
        num += i;
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
