<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    
    String name = request.getParameter("txtName");
    String gender = request.getParameter("rdoSample");
    String hoby = request.getParameter("mulText");
    
    if(name == null){name = "";}
    if(gender == null){gender = "0";}
    if(hoby == null){hoby = "";}
    
    HttpSession hs = request.getSession();
    hs.setAttribute("name", name);
    hs.setAttribute("gender", gender);
    hs.setAttribute("hoby", hoby);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        登録が完了しました。<br><br>
        　　　<a href="./form.jsp">戻る </a>
    </body>
</html>
