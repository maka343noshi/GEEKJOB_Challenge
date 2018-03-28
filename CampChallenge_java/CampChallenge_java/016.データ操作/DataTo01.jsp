<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");

    out.print(request.getParameter("txtName") + "<br>");
    out.print(request.getParameter("rdo") + "<br>");
    out.print(request.getParameter("mulText") + "<br>");
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
