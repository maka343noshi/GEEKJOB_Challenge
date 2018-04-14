//このクラスはDB接続を行います。
package process;

import java.sql.*;

public class DBcon {
    
public static Connection connect() 
        throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        //JDBCドライバのロード
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        //challenge_dbへ接続
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/challenge_db", "root", "");
        
        return con;
    }   
}
