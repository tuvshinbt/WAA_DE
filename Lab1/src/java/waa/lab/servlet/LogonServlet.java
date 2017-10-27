/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waa.lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuvshuu
 */
@WebServlet(name = "LogonServlet", urlPatterns = {"/LogonServlet"})
public class LogonServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {

            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            System.out.println("User - " + user + ", pass - " + pass);
            if (user != null && pass != null) {
                request.setAttribute("logged", (user.equals("user") && pass.equals("pass")));
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<body>");
            if (request.getAttribute("logged") != null && request.getAttribute("logged").toString().equals("true")) {
                out.println("<span>Welcome " + request.getParameter("username") + "</span>");
            } else {
                if (request.getAttribute("logged") != null) {
                    out.println("<span>Wrong userid or password! Please try agian</span>");
                }
                out.println("<form method=GET action=LogonServlet>");
                out.println("Username=<input type=text name=username> <br>");
                out.println("Password=<input type=text name=password>");
                out.println("<input type=submit value='Logon'>");
                out.println("</form>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
