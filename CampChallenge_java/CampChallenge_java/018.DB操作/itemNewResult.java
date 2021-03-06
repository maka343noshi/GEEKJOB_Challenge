package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import process.Check;
import process.DBoperation;


public class itemNewResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //セッションスタート
            HttpSession hs = request.getSession();
            
            try{
                   String name = Check.LoginCheck(String.valueOf(hs.getAttribute("userID")), String.valueOf(hs.getAttribute("pass")));
                   if(name != null){
                       
                       String itemID = String.valueOf(hs.getAttribute("itemID"));
                       String itemName = String.valueOf(hs.getAttribute("itemName"));
                       int itemGroup = Integer.valueOf(String.valueOf(hs.getAttribute("itemGroup")));
                       int itemPrice = Integer.valueOf(String.valueOf(hs.getAttribute("itemPrice")));
                       int itemStock = Integer.valueOf(String.valueOf(hs.getAttribute("itemStock")));
                       
                       DBoperation.Insert(itemID, itemName, itemGroup, itemPrice, itemStock, Check.stump());
                       
                       request.getRequestDispatcher("/WEB-INF/jsp/itemNewResult.jsp").forward(request, response);
                       
                   }else{
                       request.setAttribute("error", "もう一度ログインしなおしてください");
                       request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                   }
                   
            //例外処理を記述
            }catch (ClassNotFoundException e){
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
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
