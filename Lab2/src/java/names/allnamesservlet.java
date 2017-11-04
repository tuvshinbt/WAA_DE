/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package names;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tuvshuu
 */
@WebServlet(name = "allnamesservlet", urlPatterns = {"/names.html"})
public class allnamesservlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lab2 - SessionScope</title>");
            out.println("</head>");
            out.println("<body>");
            /**
             * LIST of person
             */
            HttpSession httpSession = request.getSession(false);
            if (httpSession != null && httpSession.getAttribute("personMap") != null) {
                HashMap<String, Person> personMap = (HashMap<String, Person>) httpSession.getAttribute("personMap");
                if (personMap != null && personMap.size() > 0) {
                    out.println("List of Names<br/>");
                    for (Person person : personMap.values()) {
                        out.println("key=" + person.getKey()
                                + " first name=" + person.getFirstName()
                                + " last name=" + person.getLastName());
                        out.println("<br/>");
                    }
                }
            }
            /**
             * Show all Names
             */
            out.println("<form action=\"names.html\" method=\"GET\">");
            out.println("<input type=\"submit\" value=\"Show all Names\" />");
            out.println("</form>");
            /**
             * Add person
             */
            out.println("<form action=\"addnamesservlet\" method=\"GET\">");
            out.println("Key=<input type=\"text\" name=\"key\"/>");
            out.println("First Name=<input type=\"text\" name=\"firstName\"/>");
            out.println("Last Name=<input type=\"text\" name=\"lastName\"/>");
            out.println("<input type=\"submit\" value=\"Add\" />");
            out.println("</form>");
            /**
             * Remove person
             */
            out.println("<form action=\"removenamesservlet\" method=\"GET\">");
            out.println("Key=<input type=\"text\" name=\"key\"/>");
            out.println("<input type=\"submit\" value=\"Remove\" />");
            out.println("</form>");
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
