<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    
    String name = String.valueOf(hs.getAttribute("name"));
    String gender = String.valueOf(hs.getAttribute("gender"));
    String hoby = String.valueOf(hs.getAttribute("hoby"));
    
    String male = ""; 
    String fumale = "";
    if(Integer.valueOf(gender) == 1){
        male = "checked";
    }else if(Integer.valueOf(gender) == 2){
        fumale = "checked";
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
    </head>
    <body>
        <form action="./result.jsp" method="get">
            名前：
            <input type="text" name="txtName" value="<%= name %>"> <br>
            性別：　
            <input type="radio" name="rdoSample" value="1" <%= male %>>
            男性　
            <input type="radio" name="rdoSample" value="2" <%= fumale %>>
            女性 <br>
            趣味：<br>
            <textarea name="mulText"  rows=5 cols=30 ><%= hoby %></textarea><br>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>
