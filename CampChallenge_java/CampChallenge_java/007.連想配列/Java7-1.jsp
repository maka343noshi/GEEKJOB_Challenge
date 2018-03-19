<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.util.HashMap" %>
<%
  //連想配列の作成
    HashMap<String, String> datas = new HashMap<String, String>();
    
    //要素の追加
    datas.put("1", "AAA");
    datas.put("hello", "world");
    datas.put("soeda", "33");
    datas.put("20", "20");
    
    //出力確認
    out.print(datas.get("1") + "<br>");
    out.print(datas.get("hello") + "<br>");
    out.print(datas.get("soeda") + "<br>");
    out.print(datas.get("20") + "<br>");

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
