package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.Date;
import process.Check;
import process.DBoperation;
import process.issueSQL;
import process.dataList;

public class itemList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession hs = request.getSession();
            request.setCharacterEncoding("UTF-8");
            
            //ID、Pass確認
            try{
                    String name = Check.LoginCheck(String.valueOf(hs.getAttribute("userID")), String.valueOf(hs.getAttribute("pass")));
                    if(name != null){
                        //商品情報更新後、マーカーをつける（未実装）
                        if(request.getAttribute("result") != null){
                            ResultSet rs = DBoperation.allselect();
                            String list = dataList.list(rs, Integer.valueOf(String.valueOf(request.getAttribute("result"))));
                            request.setAttribute("list", list);
                            request.setAttribute("type", "一覧");
                            request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp").forward(request, response);
                        
                        }else if(Integer.valueOf(request.getParameter("List")) == 1){
                            if(null == Integer.valueOf(request.getParameter("search"))){
                                request.setAttribute("error", "※予期しない選択");
                                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                            }else //処理を記述
                            //ID検索、条件検索分岐
                            switch (Integer.valueOf(request.getParameter("search"))) {
                                case 1:
                                    //商品ID検索
                                    hs.setAttribute("select", "1");
                                    String SitemID = String.valueOf(request.getParameter("itemID"));
                                    out.print(SitemID);
                                    //入力チェック
                                    if(Check.searchCheck(SitemID)){
                                        //DBアクセス、リスト作成
                                        ResultSet rs = DBoperation.idsearch(SitemID);
                                        String list = dataList.list(rs);
                                        request.setAttribute("list", list);
                                        request.setAttribute("type", "検索結果");
                                        request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp").forward(request, response);
                                    }else{
                                        request.setAttribute("errorid", "※未入力か、不適切な入力です。<br>（商品ＩＤは４桁の半角文字です。）");
                                        request.getRequestDispatcher("/WEB-INF/jsp/itemSeach.jsp").forward(request, response);
                                    }   break;
                                case 2:
                                    //複数条件検索
                                    hs.setAttribute("select", "2");
                                    if(Check.termsCheck(
                                            request.getParameter("itemName").length(), Integer.valueOf(request.getParameter("itemGroup")),
                                            Integer.valueOf(request.getParameter("priceMin")), Integer.valueOf(request.getParameter("priceMin")))){
                                        request.setAttribute("errortarms", "※いずれかの入力が必要です。");
                                        request.getRequestDispatcher("/WEB-INF/jsp/itemSeach.jsp").forward(request, response);
                                    }   //DBアクセス、リスト作成
                                    ResultSet rs = DBoperation.terms(
                                            String.valueOf(request.getParameter("itemName")), Integer.valueOf(request.getParameter("itemGroup")),
                                            Integer.valueOf(request.getParameter("priceMin")), Integer.valueOf(request.getParameter("priceMin")));
                                    String list = dataList.list(rs);
                                    request.setAttribute("list", list);
                                    request.setAttribute("type", "検索結果");
                                    request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp").forward(request, response);
                                    break;
                                default:
                                    request.setAttribute("error", "※予期しない選択");
                                    request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                                    break;
                            } 
                        }else if(Integer.valueOf(request.getParameter("List")) == 2){
                            //DBアクセス、リスト作成
                            ResultSet rs = DBoperation.allselect();
                            String list = dataList.list(rs);
                            request.setAttribute("list", list);
                            request.setAttribute("type", "一覧");
                            request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp").forward(request, response);
                        }else{
                            request.setAttribute("error", "※予期しない選択");
                            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                        }
                    }else{
                        request.setAttribute("error", "もう一度ログインしなおしてください");
                        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                    }
                    
                   
            //例外処理を記述
            }catch (ClassNotFoundException e){
                request.setAttribute("error", "ClassNotFoundException");
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("error", "SQLException");
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("error", "Exception");
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
