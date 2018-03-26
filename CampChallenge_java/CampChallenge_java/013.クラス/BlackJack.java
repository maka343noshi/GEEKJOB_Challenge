package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlackJack extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //user、dealerインスタンス生成
            User user = new User();
            Dealer dealer = new Dealer();
            //山札を用意
            dealer.Dealer();
            //カードを配る
            user.setCard(dealer.deel());
            dealer.setCard(dealer.deel());

            out.print("あなたのカードは：" + user.yourCard() +"<br>");
            out.print("ディーラーのカードは：■　" + dealer.myCards.get(1) + "<br>");
            
            boolean userEnd = true;
            boolean dealerEnd = true;
            int resultType = 0;
            int i = 0;
            //Userのターン
            while(userEnd && i < 1000){

                if(user.checkSum()){
                    out.print("あなたのヒット" + "<br>");
                    user.setCard(dealer.hit());
                    out.print("あなたは　" + user.myCards.get(user.myCards.size() - 1) + "　を引いた" + "<br>");
                    if(user.open() > 21){
                        out.print("バストした" + "<br>");
                        resultType = 1;
                        break;
                    }
                }else{
                    out.print("あなたはスタンドした" + "<br>");
                    userEnd = false;
                }
                i++;
            }
            
            if(resultType == 0){
            //dealerのターン
            while(dealerEnd && i < 1000){

                if(dealer.checkSum()){
                    out.print("ディーラーのヒット" + "<br>");
                    dealer.setCard(dealer.hit());
                    out.print("ディーラーは　" + dealer.myCards.get(dealer.myCards.size() - 1) + "　を引いた" + "<br>");
                    if(dealer.open() > 21){
                        out.print("バストした" + "<br>");
                        resultType = 2;
                        break;
                    }
                }else{
                    out.print("ディーラーはスタンドした" + "<br>");
                    dealerEnd = false;
                }
                i++;
            }
            }
            
            if(resultType == 0){
                //open
                if(user.open() > dealer.open()){
                    resultType = 3;
                }else if(user.open() < dealer.open()){
                    resultType = 4;
                }else if(user.open() == dealer.open()){
                    resultType = 5;
                }else{
                    resultType = 9;
                }
            }
            
            //結果
            out.print("<br>" + "Result" + "<br>");
            switch(resultType){
                case 1:
                    out.print("あなたのカードは：" + user.yourCard() +"<br>");
                    out.print("ディーラーのカードは：" + dealer.yourCard() +"<br>");
                    out.print("あなたの負け");
                    break;
                case 2:
                    out.print("あなたのカードは：" + user.yourCard() +"<br>");
                    out.print("ディーラーのカードは：" + dealer.yourCard() +"<br>");
                    out.print("あなたの勝ち");
                    break;
                case 3:
                    out.print("あなたのカードは：" + user.yourCard() +"<br>");
                    out.print("ディーラーのカードは：" + dealer.yourCard() +"<br>");
                    out.print("あなたの勝ち");
                    break;
                case 4:
                    out.print("あなたのカードは：" + user.yourCard() +"<br>");
                    out.print("ディーラーのカードは：" + dealer.yourCard() +"<br>");
                    out.print("あなたの負け");
                    break; 
                case 5:
                    out.print("あなたのカードは：" + user.yourCard() +"<br>");
                    out.print("ディーラーのカードは：" + dealer.yourCard() +"<br>");
                    out.print("引き分け");
                    break;
                default:
                    out.print("あなたのカードは：" + user.yourCard() +"<br>");
                    out.print("ディーラーのカードは：" + dealer.yourCard() +"<br>");
                    out.print("予期しない結果　resultType:" + resultType);
                    break;
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
