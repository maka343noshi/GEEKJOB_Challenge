package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mesod6 extends HttpServlet {

    //メソッドの定義
    String[] kensaku(String id, PrintWriter pw){
        String[] profil1 = {"310", "1990/02/15", "東京都千代田区〇〇〇"};
        String[] profil2 = {"311", "1992/08/22", "愛知県名古屋市〇〇〇"};
        String[] profil3 = {"312", "1999/05/05", "大阪府大阪市〇〇〇"};
        
        if(id == profil1[0]){
            return profil1;
        } else if(id == profil2[0]){
            return profil2;
        }else if(id == profil3[0]){
            return profil3;
        }else{
            return null;
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //メソッドの戻り値を受け取る
            String[] result = kensaku("313", out);
            //結果の表示
            if(null == result){
                out.print("不適切な入力です。");
            }else{
                for(int i = 1; i <= 2; i++){
                    out.print(result[i] + "<br>");
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
