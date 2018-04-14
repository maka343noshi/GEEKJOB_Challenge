/*
    ID,パスワードのチェック
    入力、チェック
    商品情報種別のチェック
*/
package process;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.*;
import javax.servlet.http.HttpSession;
import process.DBcon;

//ログイン
public class Check {
    
    public static String LoginCheck(String userID, String pass) 
            throws ClassNotFoundException,SQLException, InstantiationException, IllegalAccessException{
        //戻り値の用意
        String name = null;
        
        //接続を開始
        Connection con = DBcon.connect();
        
        //受け取ったid, passで検索
        String sql = "select userID, name, pass from userINF where userID = ? and pass = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, userID);
        pstm.setString(2, pass);
        ResultSet rs = pstm.executeQuery();

        //該当するか
        if(rs.next()){
            name = rs.getString("name");
        }
        
        //クローズ
        rs.close();
        pstm.close();

        if(con != null){
            con.close();
        }
        return name;
    }
    
    public static boolean searchCheck(String id){
        if(id.matches("[0-9]{4}")){
            return true;
        }else{
            return false;
        }     
    }
    
    public static boolean termsCheck(int name, int group, int min, int max){
        if(name != 0){
            return false;
        }else if(group != 0){
            return false;
        }else if(min != 0){
            return false;
        }else if(max != 0){
            return false;
        }else{
            return true;
        }
    }
    
    public static String itemcon(String insert, String update, String delete){
        if(insert != null){
            return "/WEB-INF/jsp/itemNew.jsp";
        }else if(update != null){
            return "/WEB-INF/jsp/itemUpdate.jsp";
        }else if(delete != null){
            return "/WEB-INF/jsp/itemDelete.jsp";
        }else{
            return null;
        }
    }
    
    public static String group(int group){
      if(group == 1){
          return "家電";
      }else if(group == 2){
          return "ゲーム";
      }else{
          return "その他";
      }
  }
    
    public static java.util.Date stump(){
        java.util.Date now = new java.util.Date();
        return now;
    }
}
