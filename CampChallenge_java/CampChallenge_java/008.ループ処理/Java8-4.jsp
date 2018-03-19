<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    double num = 1000;
    
    while(num >= 100){
        num /= 2;
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
