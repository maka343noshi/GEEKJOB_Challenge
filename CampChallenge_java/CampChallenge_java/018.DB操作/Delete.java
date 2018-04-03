package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //各変数を用意
            Connection con = null;
            String url = "jdbc:mysql://localhost:3306/challenge_db";
            String user = "root";
            String pass = "";
            
            try{
                //JDBCドライバのロード
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                out.print("ドライバのロードに成功<br>");
                
                //challenge_dbへ接続
                con = DriverManager.getConnection(url, user, pass);
                out.print("データベースへの接続に成功<br>");
                
                //Statementの生成 executeUpdateでsql文の送信
                Statement stm = con.createStatement();
                String sql = "delete from profiles where profileID = 6";
                int num = stm.executeUpdate(sql);
                out.print("データを削除");
                
                sql = "select * from profiles";
                ResultSet rs = stm.executeQuery(sql);
                //表示
                while(rs.next()){
                    int userID = rs.getInt("profileID");
                    String name = rs.getString("name");
                    String tell = rs.getString("tel");
                    int age = rs.getInt("age");
                    Date birthday = rs.getDate("birthday");
                    
                    out.print(userID + name + tell + age + birthday + "<br>");
                }
                
                //クローズ
                rs.close();
                stm.close();
                
            //例外処理を記述
            }catch (ClassNotFoundException e){
                out.print("ClassNotFoundException:" + e.getMessage());
            } catch (SQLException e) {
                out.print("SQLException:" + e.getMessage());
            } catch (Exception e) {
                out.print("Exceptoin" + e.getMessage());
            //接続があれば切断
            } finally {
                try{
                    if(con != null){
                        con.close();
                        out.print("切断に成功");
                    }else{
                        out.print("接続がありません<br>");
                    }
                } catch (SQLException e){
                    out.print(e.getMessage());
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
