/*
    DB殻読み込んだResultSetをwebブラウザに表示できる形に編集します。
    （StringBufferで出力→out.print();で出力）
 */
package process;

import java.sql.*;
import java.util.Date;

public class dataList {
    
    public static String list(ResultSet rs, int itemUp) throws SQLException{
       
        String list = "<table border=\"lpx\">" +
            "<tr>" +
            "<th></th>" +
            "<th>商品ＩＤ</th>" +
            "<th>商品名</th>" +
            "<th>種別</th>" +
            "<th>価格（円）</th>" +
            "<th>在庫</th>" +
            "<th>登録日</th>" +
            "<th>更新日</th>" +
            "</tr>";
        
        while(rs.next()){
            if(itemUp == Integer.valueOf(rs.getString("itemID"))){
                list += "<tr bgcolor=\"yellow\">";
            }else{
                list += "<tr>";
            }
            list += "<td><input type=\"checkbox\" name=\"itemCheck\" value=\"" + rs.getString("itemID") +"\"></td>" +
                    "<td>" + rs.getString("itemID") + "</td>" +
                    "<td>" + rs.getString("itemName") + "</td>" +
                    "<td>" + Check.group(rs.getInt("itemGroup")) + "</td>" +
                    "<td>" + rs.getInt("itemPrice") + "</td>" +
                    "<td>" + rs.getInt("itemStock") + "</td>" +
                    "<td>" + rs.getDate("dateEntry") + "</td>" +
                    "<td>" + rs.getDate("dateUpdate") + "</td>" +
                    "</tr>";
        }
        list += "</table>";
        return list;
    }
    
    public static String list(ResultSet rs) throws SQLException{
        return list(rs, 10000);
    }
}
