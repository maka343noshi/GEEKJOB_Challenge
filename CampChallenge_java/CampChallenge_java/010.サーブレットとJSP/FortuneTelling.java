/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Randomのインポート
import java.util.Random;
//ResultData インポート
import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import org.mypackage.sample.ResultData;

/**
 *
 * @author maka3
 */
public class FortuneTelling extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //
            String luckList[] = {"大吉", "中吉", "吉", "半吉", "末小吉", "凶", "小凶", "半凶", "末凶", "凶", "大凶"};
            
            //乱数クラス生成
            Random rand = new Random();
            //乱数所得
            Integer index = rand.nextInt(luckList.length);
            
            //リクエストスコープへ結果を設定
            ResultData data = new ResultData();
            data.setD(new Date());
            data.setLuck(luckList[index]);
            request.setAttribute("DATA", data);
            
            
            //サーブレットからJPSへ処理を移行
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/FotuneTellingResult.jsp");
            rd.forward(request, response);
            
            
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>課題 占いサービスを作ってみよう！</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //ランダム生成した数字でluckListの要素を指定
            out.println("<h1>きょうのあなたの運勢は。。。" + luckList[index]);
            out.println("</body>");
            out.println("</html>");
            */
            
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
