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


public class itemControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            HttpSession hs = request.getSession();
            
            try{
                   String name = Check.LoginCheck(String.valueOf(hs.getAttribute("userID")), String.valueOf(hs.getAttribute("pass")));
                   if(name != null){
                       
                       String url = Check.itemcon(request.getParameter("insert"), request.getParameter("update"), request.getParameter("delete"));
                       if(url != null){
                            String itemCheck[] = request.getParameterValues("itemCheck");
                            request.setAttribute("itemCheck", itemCheck);
                            request.getRequestDispatcher(url).forward(request, response);
                       }else{
                            request.setAttribute("error", "itemcon ページがありません");
                            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                       }
                       
                   }else{
                       out.print("check out");
                       request.setAttribute("error", "もう一度ログインしなおしてください");
                       request.getRequestDispatcher("/WEB=INF/jsp/error.jsp").forward(request, response);
                   }
                   
            //例外処理を記述
            }catch (ClassNotFoundException e){out.print("error");
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            } catch (SQLException e) {out.print("error");
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            } catch (Exception e) {out.print("error");
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
