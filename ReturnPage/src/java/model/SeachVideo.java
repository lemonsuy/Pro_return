package model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.videos;
import java.util.*;

public class SeachVideo extends HttpServlet {

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
        String title = request.getParameter("title");
        try {
            List<videos> v = videos.findByTitle(title);
            if (v != null) {
                if (title.equalsIgnoreCase("calculus")) {
                    request.setAttribute("videos", v);
                    getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
                } else if (title.equalsIgnoreCase("webtech")) {
                    request.setAttribute("videos", v);
                    getServletContext().getRequestDispatcher("/webtech.jsp").forward(request, response);
                } else if (title.equalsIgnoreCase("computerprogramming")) {
                    request.setAttribute("videos", v);
                    getServletContext().getRequestDispatcher("/compro.jsp").forward(request, response);
                } else if (title.equalsIgnoreCase("platform")) {
                    request.setAttribute("videos", v);
                    getServletContext().getRequestDispatcher("/platform.jsp").forward(request, response);

                }
            } else {
                request.setAttribute("msg", "Not found Video ");
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
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
