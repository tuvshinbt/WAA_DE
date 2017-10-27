/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waa.lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuvshuu
 */
@WebServlet(name = "guessnumber", urlPatterns = {"/guessnumber"})
public class guessnumber extends HttpServlet {

    Random random = new Random(10);

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
            int randomNumber = random.nextInt(10) + 1;

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet guessnumber</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet guessnumber</h1>");
            if (request.getParameter("guessnumber") != null) {
                try {
                    int guessNumber = Integer.parseInt(request.getParameter("guessnumber"));
                    if (guessNumber > randomNumber) {
                        // Too high, try again
                        out.println("<span>Too high, try again</span>");
                    } else if (guessNumber < randomNumber) {
                        // Too low, try again
                        out.println("<span>Too low, try again</span>");
                    } else {
                        // Correct, congratulations!
                        out.println("<span>Correct, congratulations!</span>");
                    }
                } catch (NumberFormatException e) {
                    out.println("<span>Invalid input!</span>");
                }
            }
            out.println("<form method=GET action=guessnumber>");
            out.println("Your number <input type=text name=guessnumber>");
            out.println("<input type=submit value='Check it'>");
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
