/*
    DBの操作を行います。
*/
package process;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DBoperation {
    
  public static ResultSet allselect()
          throws ClassNotFoundException,SQLException, InstantiationException, IllegalAccessException{
      
      Connection con = DBcon.connect();
      issueSQL is = new issueSQL();
      is.allcase();
      PreparedStatement pstm = con.prepareStatement(is.getsql());
      return pstm.executeQuery();
  }
  
  public static ResultSet idsearch(String id)
          throws ClassNotFoundException,SQLException, InstantiationException, IllegalAccessException{
      
      Connection con = DBcon.connect();
      issueSQL is = new issueSQL();
      is.idsearch(id);
      PreparedStatement pstm = con.prepareStatement(is.getsql());
      return pstm.executeQuery();
  }
  
  public static ResultSet terms(String name, int group, int min, int max)
          throws ClassNotFoundException,SQLException, InstantiationException, IllegalAccessException{
      
      Connection con = DBcon.connect();
      issueSQL is = new issueSQL();
      is.terms(name, group, min, max);
      PreparedStatement pstm = con.prepareStatement(is.getsql());
      return pstm.executeQuery();
  }
  
  public static void Insert(String itemID, String itemName, int itemGroup, int itemPrice, int itemStock, java.util.Date date) 
          throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String strdate = sdf.format(date);
      
      Connection con = DBcon.connect();
      String sql = "insert into itemINF value('"
            + itemID + "', '" + itemName + "', " + itemGroup + ", " + itemPrice + ", " + itemStock + ", '" + strdate + "', '" + strdate + "')";
      PreparedStatement pstm = con.prepareStatement(sql);
      pstm.executeUpdate();
      pstm.close();
      con.close(); 
      
  }
  
  public static String Insert2(String itemID, String itemName, int itemGroup, int itemPrice, int itemStock, java.util.Date date) 
          throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String strdate = sdf.format(date);

      String sql = "insert into itemINF value('"
            + itemID + "', '" + itemName + "', " + itemGroup + ", " + itemPrice + ", " + itemStock + ", '" + strdate + "', '" + strdate + "')";
      return sql;
      
  }
  
}
