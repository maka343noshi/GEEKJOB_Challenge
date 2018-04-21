<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("userData");
    ArrayList<String> chkList = new ArrayList<String>();
    if(request.getAttribute("chkList") != null){
        chkList = (ArrayList<String>)request.getAttribute("chkList");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        
        <font color="red"><!-- 未入力時、赤色で表示 -->
        <% if(JumsHelper.getInstance().inputCheck(chkList, "name")){out.print("未入力です<br>");} %>
        </font>
        名前:
        <input type="text" name="name" value="<%= udb.getName()%>">
        <br><br>
        
        <font color="red"><!-- 未入力時、赤色で表示 -->
        <% if(JumsHelper.getInstance().inputCheck(chkList, "year")){out.print("年が未入力です<br>");} %>
        <% if(JumsHelper.getInstance().inputCheck(chkList, "month")){out.print("月が未入力です<br>");} %>
        <% if(JumsHelper.getInstance().inputCheck(chkList, "day")){out.print("日が未入力です<br>");} %>
        </font>
        生年月日:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <% if(udb.getYear() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% if(udb.getMonth() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <% if(udb.getDay() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>
        
        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>" <%if(udb.getType() == i){out.print("checked = \"checked\"");}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>
        
        <font color="red"><!-- 未入力時、赤色で表示 -->
        <% if(JumsHelper.getInstance().inputCheck(chkList, "tell")){out.print("未入力です<br>");} %>
        </font><br>
        電話番号:
        <input type="text" name="tell" value="<%= udb.getTell()%>">
        <br><br>

        <font color="red"><!-- 未入力時、赤色で表示 -->
        <% if(JumsHelper.getInstance().inputCheck(chkList, "comment")){out.print("未入力です<br>");} %>
        </font><br>
        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udb.getComment()%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="更新">
    </form>
        <br>
        <%= jh.detail((Integer)hs.getAttribute("id"))%>
        <br>
        <%=jh.home()%>
    </body>
</html>
