<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    boolean alreadyInput = true;
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    //入力前か入力後かを判断
    if(udb == null ){
        alreadyInput = false;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        <font color="red"><!-- 未入力時、赤色で表示 -->
        <% if(alreadyInput && udb.getName().equals("")){out.print("未入力です<br>");} %>
        </font>
        名前:
        <input type="text" name="name" value="<% if(udb != null){out.print(udb.getName());}%>">
        <br><br>
        <font color="red">
        <% if(alreadyInput && (udb.getYear() == 0 || udb.getMonth() == 0 || udb.getDay() == 0)){out.print("選択してください<br>");} %>
        </font>
        生年月日:
        <select name="year">
            <option value="0">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <% if(udb != null && i == udb.getYear()){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="0">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% if(udb != null && i == udb.getMonth()){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="0">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <% if(udb != null && i == udb.getDay()){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>
        
        種別:
        <br>                                      <!-- 入力前ならエンジニアを選択 -->
        <input type="radio" name="type" value="1" <% if(!alreadyInput || (udb != null && udb.getType() == 1)){out.print("checked");}%>>エンジニア<br>
        <input type="radio" name="type" value="2" <% if(udb != null && udb.getType() == 2){out.print("checked");}%>>営業<br>
        <input type="radio" name="type" value="3" <% if(udb != null && udb.getType() == 3){out.print("checked");}%>>その他<br>
        <br>
        <font color="red">
        <% if(alreadyInput && udb.getTell().equals("")){out.print("未入力です<br>");} %>
        </font>
        電話番号:
        <input type="text" name="tell" value="<% if(udb != null){out.print(udb.getTell());}%>">
        <br><br>
        <font color="red">
        <% if(alreadyInput && udb.getComment().equals("")){out.print("未入力です<br>");} %>
        </font>
        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><% if(udb != null){out.print(udb.getComment());}%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
