<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    String select = String.valueOf(hs.getAttribute("select"));
        
    String id = "";
    String tarms = "";
    try{
    if(Integer.valueOf(select) == 1){
            id = "checked";
        }else if(Integer.valueOf(select) == 2){
            tarms = "checked";
        }
    }catch(NumberFormatException e){
       id = "checked";
       out.print("初回");
    }
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫検索</title>
    </head>
    <body>
        <h1>在庫検索画面</h1>
        <form action="./itemList" method="POST">
            <input type="radio" name="search" value="1" <% out.print(id); %>>商品IDで検索<br>
            <font color="red">
            <% if(request.getAttribute("errorid") != null){out.print(request.getAttribute("errorid") + "<br>");} %>
            </font><br>
            <input type="text" name="itemID" value=""><br><br>
            <input type="radio" name="search" value="2" <% out.print(tarms); %>>条件で検索<br>
            ↑商品IDが不明な場合はこちらにチェックをしてください。<br><br>
            <font color="red">
            <% if(request.getAttribute("errortarms") != null){out.print(request.getAttribute("errortarms") + "<br>");} %>
            </font><br>
            商品名
            <input type="text" name="itemName" value="">
            <br><br>
            
            種別
            <br>
            <input type="radio" name="itemGroup" value="0" checked="">指定しない<br>
            <input type="radio" name="itemGroup" value="1">家電<br>
            <input type="radio" name="itemGroup" value="2">ゲーム機<br>
            <input type="radio" name="itemGroup" value="3">その他<br>
            <br>
            
            価格
            <select name="priceMin">
            <option value="0">----</option>
            <option value="1000">1000</option>
            <option value="5000">5000</option>
            <option value="10000">10000</option>
            <option value="30000">20000</option>
            <option value="30000">30000</option>
            <option value="30000">50000</option>
            </select>以上
            <select name="priceMax">
            <option value="0">----</option>
            <option value="1000">1000</option>
            <option value="5000">5000</option>
            <option value="10000">10000</option>
            <option value="30000">20000</option>
            <option value="30000">30000</option>
            <option value="30000">50000</option>
            </select>以内
            <br><br><br>
            
            <input type="hidden" name="List" value="1">
            <input type="submit" name="subseach" value="検索">
        </form>
    </body>
</html>
