package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
import process.Check;


public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //文字化け防止
            request.setCharacterEncoding("UTF-8");
            
            //情報の取得
            String userID = request.getParameter("userID");
            String pass = request.getParameter("pass");
            
            //セッションスタート
            HttpSession hs = request.getSession();
            hs.setAttribute("userID", userID);
            hs.setAttribute("pass", pass);
            
            try{
                   String name = Check.LoginCheck(String.valueOf(hs.getAttribute("userID")), String.valueOf(hs.getAttribute("pass")));
                   if(name != null){
                       request.setAttribute("name", name);
                       request.getRequestDispatcher("/WEB-INF/jsp/itemBase.jsp").forward(request, response);
                   }else{
                       request.setAttribute("error", "※ ユーザーID、またはパスワードが違います。");
                       request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
                   }
                   
            //例外処理を記述
            }catch (ClassNotFoundException e){
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
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
