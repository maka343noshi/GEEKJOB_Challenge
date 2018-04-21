package base;
/**
 *
 * @author hayashi-s
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
    public static Connection getConnection() throws IllegalMonitorStateException{
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","root","");
            System.out.println("DBConnected!!");
            return con;
        }catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException("データベースへの接続に失敗しました");
        } catch (SQLException e) {
            throw new IllegalMonitorStateException("データベースへの接続に失敗しました");
        }
    }
}
