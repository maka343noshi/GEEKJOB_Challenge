<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = Integer.valueOf(request.getParameter("num"));
    int numf = num;
    boolean end = true;
    String result = "";
    
    int i = 0;
    while(end && i <= 10000){
        i++;
        if(numf % 2 == 0){
            numf /= 2;
            result += "2 * ";
        }else if(numf % 3 == 0){
            numf /= 3;
            result += "3 * ";
        }else if(numf % 5 == 0){
            numf /= 5;
            result += "5 * ";
        }else if(numf % 7 == 0){
            numf /= 7;
            result += "7 * ";
        }else{
            end = false;
        }
    }
    if(numf == 1){
        numf = 0;
    }
    out.print(num + " = " + result.substring(0, result.length() - 2) + " 余り " + numf);
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
