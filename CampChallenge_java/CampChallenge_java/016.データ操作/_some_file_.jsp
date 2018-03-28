<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    
    int total = Integer.valueOf(request.getParameter("total"));
    int count = Integer.valueOf(request.getParameter("count"));
    int type = Integer.valueOf(request.getParameter("type"));
    
    switch(type){
        case 1 :
            out.print("雑貨");
            break;
        case 2 :
            out.print("生鮮食品");
            break;
        case 3 :
            out.print("その他");
            break;            
    }
    out.print("<br>");
    out.print(total / count);
    out.print("<br>");
    
    if(total < 3000){
        out.print("0");
    }else if(total <5000){
        out.print(total * 0.04);
    }else{
        out.print(total * 0.04);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>
